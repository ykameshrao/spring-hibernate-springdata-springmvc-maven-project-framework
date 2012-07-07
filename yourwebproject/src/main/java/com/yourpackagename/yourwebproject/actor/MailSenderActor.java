package com.yourpackagename.yourwebproject.actor;

import com.yourpackagename.framework.exception.service.NotYetImplementedException;
import com.yourpackagename.yourwebproject.model.entity.User;

/**
 * Typed Actor to offload the mail sending activity
 * of the current thread
 *
 * @author: Y Kamesh Rao
 * @created: 4/21/12 5:27 PM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
public interface MailSenderActor {
    /**
     * Sends a mail to the user asking him/her to
     * verify his email id.
     *
     * @param user
     */
    public void sendUserEmailIdVerificationMail(final User user) throws NotYetImplementedException;


    /**
     * Sends a mail to the user informing him/her of successful
     * confirmation of their email address.
     *
     * @param user
     */
    public void sendUserEmailIdConfirmationMail(final User user);
}
