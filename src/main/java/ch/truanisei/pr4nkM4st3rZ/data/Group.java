package ch.truanisei.pr4nkM4st3rZ.data;

import java.util.ArrayList;

/**
 * @author Elisei Lucas
 * @author Truan David
 */
public class Group {

    private ArrayList<String> _recipients = new ArrayList<String>();
    private String _sender;

    public void Group() {
    }

    public void addRecipient(String recipient) {
        _recipients.add(recipient);
    }


    public ArrayList<String> getRecipients() {
        return _recipients;
    }

    public void setRecipients(ArrayList<String> _recipients) {
        this._recipients = _recipients;
    }

    public String getSender() {
        return _sender;
    }

    public void setSender(String _sender) {
        this._sender = _sender;
    }

    @Override
    public String toString() {
        return "sender: " + _sender + "\n" + _recipients.toString();
    }
}
