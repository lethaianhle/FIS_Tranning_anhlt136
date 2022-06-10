package com.fis.cems.exception;

public class CriminalCaseNotFoundException extends RuntimeException{
    public CriminalCaseNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
