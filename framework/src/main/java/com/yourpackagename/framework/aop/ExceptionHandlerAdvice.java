package com.yourpackagename.framework.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import com.yourpackagename.framework.response.Response;

import java.lang.reflect.Method;

/**
 * Class to help handle the Exceptions in the application, system or any level
 * code at one single point. Acts as the intercepter point using Spring AOP to
 * commonly handle all the thrown exceptions on the beans/classes to which it is
 * proxying. This will print the exception to console. You can extend this class
 * to have specialized Exception handler features, like sending an email to
 * developer, showing a message on frontend, attaching an error code and common
 * user understandable message.
 *
 * @author Y Kamesh Rao
 */
public class ExceptionHandlerAdvice implements ThrowsAdvice {
    private Response response;
    private Logger log = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);


    public void setResponse(final Response response) {
        this.response = response;
    }


    /**
     * Gets called after the Exception is thrown at the code level
     *
     * @param m      Method where the exception was thrown
     * @param args   Arguments sent to that method
     * @param target The enclosing class of the method
     * @param ex     The exception that was thrown
     */
    public void afterThrowing(Method m, Object[] args, Object target, Throwable ex) {
        log.error("Exception in method: " + m.getName() + " Exception is: " + ex.getMessage());

        if (response != null)
            response.setError(500, ex.getMessage());

        log.error("Response: " + response.toString());
    }


    /**
     * Gets called after the Exception is thrown at the code level
     *
     * @param m      Method where the exception was thrown
     * @param args   Arguments sent to that method
     * @param target The enclosing class of the method
     * @param ex     The exception that was thrown
     */
    public void afterThrowing(Method m, Object[] args, Object target, Exception ex) {
        log.error("Exception in method: " + m.getName() + " Exception is: " + ex.getMessage());

        if (response != null)
            response.setError(500, ex.getMessage());

        log.error("Response: " + response.toString());
    }

}
