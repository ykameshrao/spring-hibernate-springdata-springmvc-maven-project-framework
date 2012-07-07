package com.yourpackagename.framework.exception.service;

import com.yourpackagename.framework.exception.BaseException;

/**
 * Exception indicating service implementation missing
 *
 * @author: Y Kamesh Rao
 */
public class NotYetImplementedException extends BaseException {
    private static final long serialVersionUID = -5223364559346480654L;


    public NotYetImplementedException(String serviceName) {
        super("Service not yet implemented: " + serviceName);
    }


    public NotYetImplementedException(String serviceName, Object errorCode) {
        super("Service not yet implemented: " + serviceName, errorCode);
    }
}
