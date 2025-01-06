package com.vhbchieu.todolist.config;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.util.Date;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = DateValidator.class)
public @interface NotPast {
    String message() default "Thời gian dự định không thể là quá khứ";
    //
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
