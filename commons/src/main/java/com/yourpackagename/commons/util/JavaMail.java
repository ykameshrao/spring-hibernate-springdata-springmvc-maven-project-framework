package com.yourpackagename.commons.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * Helper class to send emails
 *
 * @author: Y Kamesh Rao
 * @created: 4/21/12 8:50 AM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
public class JavaMail {
    private Logger log = LoggerFactory.getLogger(JavaMail.class);
    private Properties props;


    public JavaMail(String protocol, String host, String uname, String pass) {
        props = new Properties();
        props.setProperty("mail.transport.protocol", protocol);
        props.setProperty("mail.host", host);
        props.setProperty("mail.user", uname);
        props.setProperty("mail.password", pass);
    }


    public boolean sendMail(String sender, List<String> receivers, String subject, String body,
                                  String contentType) {
        Transport transport = null;
        try {
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(true);
            transport = mailSession.getTransport();

            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject(subject);
            message.setFrom(new InternetAddress(sender));
            message.setContent(body, contentType);

            for (String r : receivers)
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(r));

            transport.connect();
            transport.sendMessage(message,
                    message.getRecipients(Message.RecipientType.TO));

            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            if (transport != null)
                try {
                    transport.close();
                } catch (MessagingException e) {
                    log.error(e.getMessage());
                }
        }

        return false;
    }
}
