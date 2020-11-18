package com.restaurant.restaurantappserver.validator;

import com.restaurant.restaurantappserver.domain.ApplicationUser;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ApplicationUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ApplicationUser user = (ApplicationUser) o;
        if(user.getPassword().length()<6){
            errors.rejectValue("password","Length","Password must be at least 6 characters");
        }
        if(!user.getPassword().equals(user.getConfirmPassword())){
            errors.rejectValue("confirmPassword", "Match", "Passwords must match");
        }
    }
}
