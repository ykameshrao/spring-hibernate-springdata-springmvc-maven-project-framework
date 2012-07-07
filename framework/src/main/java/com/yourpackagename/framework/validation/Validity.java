package com.yourpackagename.framework.validation;

import java.util.List;

/**
 * Class to store the status of an entity validation
 * to respond the request in best possible and standard way
 *
 * @author: Y Kamesh Rao
 * @created: 11/1/11 5:47 PM
 * @company: &copy; 2011-12, Kaleidosoft Labs
 */
public class Validity {
    private boolean valid = false;
    private List<String> errors = null;


    public Validity(boolean valid, List<String> errors) {
        this.valid = valid;
        this.errors = errors;
    }


    public Validity(boolean valid) {
        this.valid = valid;
        this.errors = null;
    }
    
    public void addError(String error) {
        this.errors.add(error);
        this.valid = this.errors.isEmpty();
    }


    public Object errorMsgs() {
        if (errors.size() > 1)
            return errors;
        else
            return errors.get(0);
    }


    public String errors() {
        StringBuilder errorMsgs = new StringBuilder();
        for (String err : errors) {
            errorMsgs.append(err + " ");
        }
        return errorMsgs.toString();
    }


    public boolean isValid() {
        return valid;
    }


    public void setValid(boolean valid) {
        this.valid = valid;
    }


    public List<String> getErrors() {
        return errors;
    }


    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
