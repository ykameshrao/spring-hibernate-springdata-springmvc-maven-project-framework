package com.yourpackagename.framework.exception.database;

import com.yourpackagename.framework.exception.BaseException;

/**
 * Exception to denote that the requested entity is not found in the database
 *
 * @author Y Kamesh Rao
 */
public class NotFoundException extends BaseException {
    private static final long serialVersionUID = -8366510943647697642L;


    public NotFoundException(String message) {
        super(message);
    }


    public NotFoundException(String message, Object errorCode) {
        super(message, errorCode);
    }
}
