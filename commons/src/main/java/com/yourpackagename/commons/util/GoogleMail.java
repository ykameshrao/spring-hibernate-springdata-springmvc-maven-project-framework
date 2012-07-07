package com.yourpackagename.commons.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Properties;

/**
 * Utility class to send email using Google's SMTP server. This class makes use
 * of Google account credentials to send across e-mail messages to recipients.
 *
 * @author Y Kamesh Rao
 */
public class GoogleMail {

    private String smtpHostName = "smtp.gmail.com";
    private String smtpPort = "465";
    private String sslFactory = "javax.net.ssl.SSLSocketFactory";
    private String senderUsername = "";
    private String senderPassword = "";
    private boolean debugMode = true;


    public boolean isDebugMode() {
        return debugMode;
    }


    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }


    /**
     * Method to send E-mail message using SSL Encryption.
     *
     * @param recipients
     *         Array of recipient E-mail addresses
     * @param subject
     *         Subject line of the E-mail
     * @param message
     *         Message body
     * @param from
     *         E-mail address of the sender
     *
     * @throws MessagingException
     */
    public void sendSSLMessage(
            String recipients[],
            String subject,
            String message,
            String from) throws MessagingException {
        // Add a Security Provider
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        boolean debug = debugMode;

        // Initialise the config.controller
        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHostName);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", sslFactory);
        props.put("mail.smtp.socketFactory.fallback", "false");

        // Set authentication
        Session session = Session.getDefaultInstance(
                props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                senderUsername,
                                senderPassword);
                    }
                });

        // Set debug mode
        session.setDebug(debug);

        // Set sender and recipients
        Message msg = new MimeMessage(session);
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo);

        // Setting the Subject and Content Type
        msg.setSubject(subject);
        msg.setContent(message, "text/plain");

        // Send message
        Transport.send(msg);
    }


    /**
     * @param smtpHostName
     *         the smtpHostName to set
     */
    public void setSmtpHostName(String smtpHostName) {
        this.smtpHostName = smtpHostName;
    }


    /** @return the smtpHostName */
    public String getSmtpHostName() {
        return smtpHostName;
    }


    /**
     * @param smtpPort
     *         The smtpPort to set
     */
    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }


    /** @return the smtpPort */
    public String getSmtpPort() {
        return smtpPort;
    }


    /**
     * @param sslFactory
     *         The sslFactory to set
     */
    public void setSslFactory(String sslFactory) {
        this.sslFactory = sslFactory;
    }


    /** @return the sslFactory */
    public String getSslFactory() {
        return sslFactory;
    }


    /**
     * @param senderUsername
     *         The senderUsername to set
     */
    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }


    /** @return the senderUsername */
    public String getSenderUsername() {
        return senderUsername;
    }


    /**
     * @param senderPassword
     *         The senderPassword to set
     */
    public void setSenderPassword(String senderPassword) {
        this.senderPassword = senderPassword;
    }


    /** @return the senderPassword */
    public String getSenderPassword() {
        return senderPassword;
    }
}