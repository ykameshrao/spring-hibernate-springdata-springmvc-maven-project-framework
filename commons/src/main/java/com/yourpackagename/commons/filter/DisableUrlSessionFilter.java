package com.yourpackagename.commons.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter class to suppress sessions coming up in URLs as jsessionid parameter
 *
 * @author Y Kamesh Rao
 */
public class DisableUrlSessionFilter implements Filter {

    @Override
    public void destroy() {
    }


    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException,
            ServletException {
        // Do not process non-http requests
        if (!(request instanceof HttpServletRequest)) {
            chain.doFilter(request, response);
            return;
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Invalidate any sessions that are being backed by session Ids
        if (httpRequest.isRequestedSessionIdFromURL()) {
            HttpSession session = httpRequest.getSession();
            if (session != null)
                session.invalidate();
        }

        // Disable URL encoding by wrapping our httpResponse object
        HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(
                httpResponse) {
            public String encodeRedirectURL(String url) {
                return url;
            }


            public String encodeURL(String url) {
                return url;
            }
        };

        // Filter the request finally
        chain.doFilter(request, wrappedResponse);
    }


    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
