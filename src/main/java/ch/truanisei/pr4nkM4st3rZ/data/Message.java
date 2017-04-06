package ch.truanisei.pr4nkM4st3rZ.data;

/**
 * Represent's an email message.
 *
 * It is composed by a subject and a body.
 *
 * @author Lucas ELISEI (@faku99)
 * @author David TRUAN  (@Daxidz)
 */
public class Message {

    private String body;

    private String subject;

    /**
     * Constructor of an email message.
     *
     * @param subject Subject of the email.
     * @param body    Body of the email.
     */
    public Message(String subject, String body) {
        this.body = body;
        this.subject = subject;
    }

    /**
     * Returns the email's body.
     *
     * @return The email's body.
     */
    public String getBody() {
        return body;
    }

    /**
     * Returns the email's subject.
     *
     * @return The email's subject.
     */
    public String getSubject() {
        return subject;
    }
}
