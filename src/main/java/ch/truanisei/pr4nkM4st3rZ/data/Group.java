package ch.truanisei.pr4nkM4st3rZ.data;

import java.util.ArrayList;

/**
 * Represents a group for the forged emails.
 *
 * Each group is defined by a sender and a list of recipients.
 *
 * @author Lucas ELISEI (@faku99)
 * @author David TRUAN  (@Daxidz)
 */
public class Group {

    private ArrayList<String> recipients = new ArrayList<>();

    private String sender;

    /**
     * Returns the group's recipients list.
     *
     * @return An ArrayList containing the group's recipients.
     */
    public ArrayList<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(ArrayList<String> recipients) {
        this.recipients = recipients;
    }

    /**
     * Adds a recipient to the group.
     *
     * @param recipient The recipient's email address.
     */
    public void addRecipient(String recipient) {
        if(!recipients.contains(recipient)) {
            recipients.add(recipient);
        }
    }

    /**
     * Returns the group's sender.
     *
     * @return The group's sender.
     */
    public String getSender() {
        return sender;
    }

    /**
     * Sets the group's sender.
     *
     * @param sender The group's sender.
     */
    public void setSender(String sender) {
        this.sender = sender;
    }
}
