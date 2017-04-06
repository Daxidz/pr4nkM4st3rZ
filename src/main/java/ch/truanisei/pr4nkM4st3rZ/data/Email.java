package ch.truanisei.pr4nkM4st3rZ.data;

import java.util.ArrayList;

/**
 * Represents an email.
 * It has a sender (email address), a list of recipients (email addresses), a subject and a body.
 *
 * @author Lucas ELISEI (@faku99)
 * @author David TRAUN  (@Daxidz)
 */
public class Email {

    private Group group;

    private Message message;

    /**
     * Create an Email given a group and a message.
     *
     * @param group   Group which will receive the message.
     * @param message The message composing the email.
     */
    public Email(Group group, Message message) {
        this.group = group;
        this.message = message;
    }

    /**
     * Returns the email's recipients list.
     *
     * @return An ArrayList containing all the recipients' email addresses.
     */
    public ArrayList<String> getRecipients() {
        return group.getRecipients();
    }

    /**
     * Returns the sender's email address.
     *
     * @return The sender's email address.
     */
    public String getSender() {
        return group.getSender();
    }

    /**
     * Returns the email's subject.
     *
     * @return A String containing the email's subject.
     */
    public String getSubject() {
        return message.getSubject();
    }

    /**
     * Returns the email's body.
     *
     * @return The email's body.
     */
    public String getBody() {
        return this.message.getBody();
    }
}
