package com.example.scb.bookstore.validator;

import com.example.scb.bookstore.model.dao.User;
import com.example.scb.bookstore.model.dto.SaveUserValidateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.SmartValidator;

@Component
public class UserValidator {

    @Autowired
    private SmartValidator smartValidator;

    public SaveUserValidateResult validateSave(User user, BindingResult bindingResult) {
        SaveUserValidateResult result = new SaveUserValidateResult();

        smartValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            result.setPass(false);
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                result.setMessage(fieldError.getField() + " " + fieldError.getDefaultMessage());
            }
        }

        return result;
    }
}
