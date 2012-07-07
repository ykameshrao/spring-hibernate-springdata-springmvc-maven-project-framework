package com.yourpackagename.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * All controllers in spring should extend this controller so as to have
 * centralize control for doing any sort of common functionality.
 *
 * @author : Y Kamesh Rao
 */
@Controller
public class BaseController extends AbstractController {
    @Autowired public HttpServletRequest request;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest,
                                                 HttpServletResponse httpServletResponse) throws Exception {
        return null;
    }
}
