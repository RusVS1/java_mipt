package edu.phystech.hw5.service;

import edu.phystech.hw5.annotation.validation.NotBlank;
import edu.phystech.hw5.annotation.validation.Size;
import edu.phystech.hw5.exception.ValidationException;

import java.lang.reflect.Field;

public class ValidatorImpl implements Validator {

    @Override
    public void validate(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(NotBlank.class)) {
                validateNotBlank(object, field);
            }
            if (field.isAnnotationPresent(Size.class)) {
                validateSize(object, field);
            }
        }
    }

    private void validateNotBlank(Object object, Field field) {
        NotBlank notBlank = field.getAnnotation(NotBlank.class);
        field.setAccessible(true);
        try {
            String value = (String) field.get(object);
            if (value == null || value.trim().isEmpty()) {
                throw new ValidationException(notBlank.message());
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void validateSize(Object object, Field field) {
        Size size = field.getAnnotation(Size.class);
        field.setAccessible(true);
        try {
            String value = (String) field.get(object);
            if (value == null || value.length() < size.min() || value.length() > size.max()) {
                throw new ValidationException(size.message());
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

