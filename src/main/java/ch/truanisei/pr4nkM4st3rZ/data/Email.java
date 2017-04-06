package ch.truanisei.pr4nkM4st3rZ.data;

import java.util.ArrayList;

/**
 * Class representing an email.
 * It has a sender (email address), a list of recipients (email addresses), a subject and a body.
 * @author Elisei Lucas
 * @author Truan David
 */
public class Email {
    private Group group;
    private Message message;

    /**
     * Create a Mail with a for a Group with a Message
     * @param group
     * @param message
     */
    public Email(Group group, Message message) {
        this.group = group;
        this.message = message;
    }

    /**
     * Create a blank mail, you can populate it with the setters, getters
     */
    public Email() {

    }

    /**
     *
     * @return an ArrayList containing all the recipients' mail address from the Mail
     */
    public ArrayList<String> getRecipients() {
        return group.getRecipients();
    }

    /**
     * Set a list of recipients for the mail
     * @param recipients
     */
    public void setRecipients(ArrayList<String> recipients) {
        this.group.setRecipients(recipients);
    }

    /**
     * Add a recipient to the recipient list
     * @param recipient
     */
    public void addRecipient(String recipient) {
        this.group.addRecipient(recipient);
    }

    /**
     * Get the sender's mail address
     * @return the sender's mail address
     */
    public String getSender() {
        return this.group.getSender();
    }

    public void setSender(String sender) {
        this.group.setSender(sender);
    }

    /**
     * Get the subject of the mail
     * @return a String containing the subject of the mail
     */
    public String getSubject() {
        return this.message.getSubject();
    }

    /**
     * Set the subject of the mail
     * @param subject
     */
    public void setSubject(String subject) {
        this.message.setSubject(subject);
    }

    /**
     * Get a String containing the mail body
     * @return the mail body
     */
    public String getBody() {
        return this.message.getBody();
    }

    /**
     * Set the mail body
     * @param body
     */
    public void setBody(String body) {
        this.message.setBody(body);
    }
}
