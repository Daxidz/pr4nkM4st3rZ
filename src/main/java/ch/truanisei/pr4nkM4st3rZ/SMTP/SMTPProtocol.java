package ch.truanisei.pr4nkM4st3rZ.SMTP;

/**
 * Class which describe the basic SMTP protocol used in the application.
 *
 * @author Lucas ELISEI (@faku99)
 * @author David TRUAN  (@Daxidz)
 */
public class SMTPProtocol {

    public final static String LINE_ENDING = "\r\n";

    public final static String EHLO = "EHLO";
    public final static String MAIL_FROM = "MAIL FROM: ";
    public final static String RCPT_TO = "RCPT TO: ";

    public final static String DATA = "DATA";
    public final static String FROM = "From: ";
    public final static String TO = "To: ";
    public final static String SUBJECT = "Subject: ";

    public final static String END_DATA = LINE_ENDING + "." + LINE_ENDING;
    public final static String QUIT = "QUIT";


}
