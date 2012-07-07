package com.yourpackagename.framework.dispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * BaseDispatcherServlet acts as a wrapper for Spring's DispatcherServlet class
 * so that we can have our own custom implementations written here to have those facilities
 * or features being provided to everybody extending this class
 *
 * @author Y Kamesh Rao
 */
public class BaseDispatcherServlet extends org.springframework.web.servlet.DispatcherServlet {

    private static final long serialVersionUID = 112233448L;


    @Override
    protected void doService(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        super.doService(request, response);
    }


    @Override
    protected void doDispatch(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        super.doDispatch(request, response);
    }


    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {
        super.service(request, response);
    }

}