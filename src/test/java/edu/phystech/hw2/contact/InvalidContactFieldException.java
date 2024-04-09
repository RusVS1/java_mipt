package edu.phystech.hw2.contact;

public class InvalidContactFieldException extends RuntimeException {
    private String field;

    public String getFieldName() {
        return field;
    }

    InvalidContactFieldException(String field) {
        this.field = field;
    }
}
