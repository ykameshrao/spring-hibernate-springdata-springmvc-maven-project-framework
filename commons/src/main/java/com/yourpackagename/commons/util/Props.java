package com.yourpackagename.commons.util;

//import org.apache.struts.util.MessageResources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is meant to read the config.controller from the file
 *
 * @author Y Kamesh Rao
 */
public class Props {
    private static Logger log = LoggerFactory.getLogger(Props.class);

    public static String getValue(String property, String propFilename) {
        try {
            //MessageResources messages = MessageResources.getMessageResources(propFilename);
            //String message = messages.getMessage(property);
            //return message;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error while reading the property " + property + " from the file : " + propFilename);
        }
        return null;
    }
}