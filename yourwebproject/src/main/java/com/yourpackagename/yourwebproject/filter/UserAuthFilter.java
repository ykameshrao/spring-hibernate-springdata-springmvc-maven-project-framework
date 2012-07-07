package com.yourpackagename.yourwebproject.filter;

import com.yourpackagename.framework.exception.auth.AuthCredentialsMissingException;
import com.yourpackagename.framework.exception.auth.AuthenticationFailedException;
import com.yourpackagename.framework.exception.database.NotFoundException;
import com.yourpackagename.yourwebproject.api.common.ApiRoute;
import com.yourpackagename.yourwebproject.common.Key;
import com.yourpackagename.yourwebproject.common.Message;
import com.yourpackagename.yourwebproject.common.Props;
import com.yourpackagename.yourwebproject.model.entity.User;
import com.yourpackagename.yourwebproject.service.UserService;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter to process user authentication for the incoming service requests
 *
 * @author: Y Kamesh Rao
 * @created: 11/3/11 1:45 PM
 * @company: &copy; 2011-12, Kaleidosoft Labs
 */
public class UserAuthFilter extends OncePerRequestFilter {
    private Logger log = LoggerFactory.getLogger(UserAuthFilter.class);
    private @Autowired UserService userService;
    private @Autowired Props props;
    private @Autowired Message msg;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("authorization");
        String authenticationHeader = request.getHeader("authentication");
        String route;
        String suffix;

        if (request.getRequestURI().endsWith(".xml")) {
            route = request.getRequestURI().substring(0, request.getRequestURI().lastIndexOf(".xml"));
            suffix = ".xml";
        }
        else if (request.getRequestURI().endsWith(".json")) {
            route = request.getRequestURI().substring(0, request.getRequestURI().lastIndexOf(".json"));
            suffix = ".json";
        }
        else {
            route = request.getRequestURI();
            suffix = ".xml";
        }

        // Checking whether the current route needs to be authenticated
        if (props.apiAuthRoutes.contains(route) || props.webAuthRoutes.contains(route)) {
            try {
                // Check for authorization header presence
                String authHeader = null;
                if (authorizationHeader == null || authorizationHeader.equalsIgnoreCase("")) {
                    if (authenticationHeader == null || authenticationHeader.equalsIgnoreCase("")) {
                        authHeader = null;
                    } else {
                        authHeader = authenticationHeader;
                        log.info("authentication: " + authenticationHeader);
                    }
                } else {
                    authHeader = authorizationHeader;
                    log.info("authorization: " + authorizationHeader);
                }

                if (authHeader != null && !authHeader.equalsIgnoreCase("")) {
                    String[] creds = authHeader.split(" ");

                    // Check whether Basic Auth
                    if (creds[0].equalsIgnoreCase("basic")) {
                        String credString = new String(Base64.decodeBase64(creds[1].getBytes()));
                        String[] userPass = credString.split(":");

                        // Authenticate the credentials
                        if (userPass != null && userPass.length > 0) {
                            User user;
                            if (request.getSession(false) != null &&
                                    request.getSession(false).getAttribute(Key.userInSession) != null) {
                                user = (User) request.getSession(false).getAttribute(Key.userInSession);
                                authenticateUserFromSession(user, userPass, request);
                            }
                            else
                                authenticateUser(userPass, request);

                            // Now since the authentication process if finished
                            // move the request forward
                            filterChain.doFilter(request, response);
                        } else {
                            throw new AuthCredentialsMissingException(msg.aParamMissing);
                        }
                    } else {
                        throw new AuthCredentialsMissingException(msg.aParamMissing);
                    }
                } else {
                    throw new AuthCredentialsMissingException(msg.aParamMissing);
                }

            } catch (AuthenticationFailedException ae) {
                response.setHeader("content-type", request.getHeader("content-type"));
                response.sendRedirect(props.fApiPath + ApiRoute.errorController + ApiRoute.authFailedUrl + suffix);
                return;
            } catch (AuthCredentialsMissingException ae) {
                response.setHeader("content-type", request.getHeader("content-type"));
                response.sendRedirect(props.fApiPath + ApiRoute.errorController + ApiRoute.credsMissingUrl + suffix);
                return;
            } catch (NotFoundException nfe) {
                response.setHeader("content-type", request.getHeader("content-type"));
                response.sendRedirect(props.fApiPath + ApiRoute.errorController + ApiRoute.authFailedUrl + suffix);
                return;
            } catch (Exception e) {
                log.error(e.getMessage());
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                return;
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }


    private void authenticateUser(String[] userPass, HttpServletRequest request)
            throws NotFoundException, AuthenticationFailedException {
        final User user = userService.findByUsername(userPass[0]);
        log.info("User Found: " + user.getUserName());

        if (user.getPassWord().equals(User.hashPassword(userPass[1]))) {
            log.info("Authenticated: " + user.getUserName());

            // Store the attribute to be referenced later in the API code
            request.getSession(true).setAttribute(Key.userInSession, user);
        } else {
            log.info("User Authentication Failed: " + user.getUserName());
            throw new AuthenticationFailedException(msg.aFailed);
        }
    }


    private void authenticateUserFromSession(User user, String[] userPass, HttpServletRequest request)
            throws NotFoundException, AuthenticationFailedException {
        log.info("User Found: " + user.getUserName());

        if (user.getPassWord().equals(User.hashPassword(userPass[1]))) {
            log.info("Authenticated: " + user.getUserName());
        } else {
            log.info("User Authentication Failed: " + user.getUserName());
            throw new AuthenticationFailedException(msg.aFailed);
        }
    }
}
