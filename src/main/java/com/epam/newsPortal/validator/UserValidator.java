package com.epam.newsPortal.validator;

import com.epam.newsPortal.model.User;
import com.epam.newsPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        if (user.getName().length() < 6 || user.getName().length() > 32) {
            errors.rejectValue("name", "size.username");
        }
        if (userService.findByName(user.getName())!=null) {
            errors.rejectValue("name", "duplicate.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
        if (user.getPassword().length() < 6) {
            errors.rejectValue("password", "size.password");
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "different.password");
        }
    }
}
