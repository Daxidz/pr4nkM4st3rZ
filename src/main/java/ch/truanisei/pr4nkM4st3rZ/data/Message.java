package ch.truanisei.pr4nkM4st3rZ.data;

/**
 * Class representing a message for an email.
 * It has a subject and a body
 * @author Elisei Lucas
 * @author Truan David
 */
public class Message {

    private String body;
    private String subject;

    public Message(String subject, String body) {
        this.body = body;
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
