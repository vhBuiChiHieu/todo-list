package com.vhbchieu.todolist.config;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Date;

public class DateValidator implements ConstraintValidator<NotPast, Date> {

    private Date today;

    @Override
    public void initialize(NotPast constraintAnnotation) {
        today = new Date();
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if (value == null)
            return true;
        return today.before(value);
    }
}
