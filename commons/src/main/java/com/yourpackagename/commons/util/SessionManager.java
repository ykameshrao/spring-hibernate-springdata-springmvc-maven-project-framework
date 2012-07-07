package com.yourpackagename.commons.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Class to handle session management
 *
 * @author: Y Kamesh Rao
 * @created: 4/28/12 5:41 PM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
public class SessionManager {
    public static HttpSession newSession(HttpServletRequest request) {
        return request.getSession(true);
    }
}
