package ch.truanisei.pr4nkM4st3rZ.data;

import ch.truanisei.pr4nkM4st3rZ.data.Group;
import ch.truanisei.pr4nkM4st3rZ.data.Message;

import java.util.ArrayList;

/**
 * @author Elisei Lucas
 * @author Truan David
 */
public class Mail {

    private ArrayList<String> _recipients;
    private String _sender;
    private String _subject;
    private String _body;

    public ArrayList<String> get_recipients() {
        return _recipients;
    }

    public void set_recipients(ArrayList<String> _recipients) {
        this._recipients = _recipients;
    }

    public String get_sender() {
        return _sender;
    }

    public void set_sender(String _sender) {
        this._sender = _sender;
    }

    public String get_subject() {
        return _subject;
    }

    public void set_subject(String _subject) {
        this._subject = _subject;
    }

    public String get_body() {
        return _body;
    }

    public void set_body(String _body) {
        this._body = _body;
    }

    public Mail(Group group, Message message) {
        _recipients = group.getRecipients();

        _sender = group.getSender();
        _subject = message.getSubject();
        _body = message.getBody();
    }
}
