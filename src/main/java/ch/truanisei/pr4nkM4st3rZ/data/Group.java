package ch.truanisei.pr4nkM4st3rZ.data;

import java.util.ArrayList;

/**
 * Class representing a
 * @author Elisei Lucas
 * @author Truan David
 */
public class Group {

    private ArrayList<String> recipients = new ArrayList<String>();
    private String sender;

    /**
     * Get the group' list of recipients
     * @return an ArrayList of String containing the mail addresses of the recipients
     */
    public ArrayList<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(ArrayList<String> recipients) {
        this.recipients = recipients;
    }

    /**
     * Add a recipient to the group. Usually it is a mail address
     * @param recipient
     */
    public void addRecipient(String recipient) {
        recipients.add(recipient);
    }

    /**
     * Get the group' sender
     * @return the sender of the group
     */
    public String getSender() {
        return sender;
    }

    /**
     * Set the group' sender
     * @param sender
     */
    public void setSender(String sender) {
        this.sender = sender;
    }
}
