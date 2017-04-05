package ch.truanisei.pr4nkM4st3rZ;

import ch.truanisei.pr4nkM4st3rZ.SMTP.*;
import ch.truanisei.pr4nkM4st3rZ.data.*;

import java.io.IOException;

/**
 * @author Elisei Lucas
 * @author Truan David
 */
public class Application {


    public static void main(String... args) throws IOException {
        SMTPClient client = new SMTPClient();
        Message msg = new Message("Test", "e");
        client.sendMail();
    }
}
