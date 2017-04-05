package ch.truanisei.pr4nkM4st3rZ.data;

/**
 * @author Elisei Lucas
 * @author Truan David
 */
public class Message {

    private String _body;
    private String _subject;

    public Message(String body, String subject) {
        _body = body;
        _subject = subject;
    }

    public String getBody() {
        return _body;
    }

    public void setBody(String _body) {
        this._body = _body;
    }

    public String getSubject() {
        return _subject;
    }

    public void setSubject(String _subject) {
        this._subject = _subject;
    }
}
