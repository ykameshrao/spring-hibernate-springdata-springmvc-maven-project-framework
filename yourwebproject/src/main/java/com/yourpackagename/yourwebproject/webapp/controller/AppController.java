package com.yourpackagename.yourwebproject.webapp.controller;

import com.yourpackagename.yourwebproject.webapp.common.Route;
import com.yourpackagename.yourwebproject.webapp.common.View;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 * App central controller to render home page
 *
 * @author: Y Kamesh Rao
 * @created: 2/28/12 7:54 AM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
@Controller
public class AppController extends BaseWebAppController {

    @RequestMapping(value = Route.home, method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return View.home;
    }
}
