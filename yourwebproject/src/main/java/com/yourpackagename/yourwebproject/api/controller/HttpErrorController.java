package com.yourpackagename.yourwebproject.api.controller;

import com.yourpackagename.framework.common.Const;
import com.yourpackagename.framework.response.Response;
import com.yourpackagename.yourwebproject.api.common.ApiRoute;
import com.yourpackagename.yourwebproject.api.common.HttpError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller to handle the general error messages
 * that may come up in the REST APIs that would
 * be implemented
 *
 * @author: Y Kamesh Rao
 * @created: 3/17/12 9:42 PM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
@Controller
@RequestMapping(ApiRoute.errorController)
public class HttpErrorController extends BaseApiController {
    private @Autowired HttpError httpError;


    @RequestMapping(value = "/400")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ModelAndView badRequest() {
        Response response = this.serverResponse();
        response.setError(httpError.brCode, httpError.brMsg);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public @ResponseBody ModelAndView unauthorised() {
        Response response = this.serverResponse();
        response.setError(httpError.uaCode, httpError.uaMsg);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = "/404")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ModelAndView notFound() {
        Response response = this.serverResponse();
        response.setError(httpError.nfCode, httpError.nfMsg);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = "/405")
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public @ResponseBody ModelAndView methodNotAllowed() {
        Response response = this.serverResponse();
        response.setError(httpError.mnaCode, httpError.mnaMsg);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = "/408")
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public @ResponseBody ModelAndView requestTimeout() {
        Response response = this.serverResponse();
        response.setError(httpError.rtCode, httpError.rtMsg);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = "/415")
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public @ResponseBody ModelAndView unsupportedMediaType() {
        Response response = this.serverResponse();
        response.setError(httpError.umtCode, httpError.umtMsg);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = "/500")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ModelAndView internalServerError() {
        Response response = this.serverResponse();
        response.setError(httpError.iseCode, httpError.iseMsg);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = "/501")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public @ResponseBody ModelAndView notImplemented() {
        Response response = this.serverResponse();
        response.setError(httpError.niCode, httpError.niMsg);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = "/503")
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public @ResponseBody ModelAndView serviceUnavailable() {
        Response response = this.serverResponse();
        response.setError(httpError.suCode, httpError.suMsg);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = ApiRoute.authFailedUrl)
    public @ResponseBody ModelAndView authFailed() {
        Response response = this.serverResponse();
        response.setError(msg.aFailedCode, msg.aFailed);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = ApiRoute.credsMissingUrl)
    public @ResponseBody ModelAndView credsMissing() {
        Response response = this.serverResponse();
        response.setError(msg.aParamMissingCode, msg.aParamMissing);
        return mav().addObject(Const.responseKey, response);
    }


    @RequestMapping(value = ApiRoute.merchantNotFoundUrl)
    public @ResponseBody ModelAndView merchantNotFound() {
        Response response = this.serverResponse();
        response.setError(msg.aUserNotFoundCode, msg.aUserNotFound);
        return mav().addObject(Const.responseKey, response);
    }
}
