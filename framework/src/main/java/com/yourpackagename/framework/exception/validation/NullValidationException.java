package com.yourpackagename.framework.exception.validation;

/**
 * Class to throw a NullValidationException if an object fails the null value check
 *
 * @author Y Kamesh Rao
 */
public class NullValidationException extends ValidationException {
    private static final long serialVersionUID = -1646809610491231827L;
    private String name;


    /**
     * Constructor class to initialize the exception
     *
     * @param name Name of the object that failed validation, to show in the message
     */
    public NullValidationException(String name) {
        this.name = name;
    }


    @Override
    public String getMessage() {
        return "The object " + name + " cannot be \'null\'. This fails null validation.";
    }

}
