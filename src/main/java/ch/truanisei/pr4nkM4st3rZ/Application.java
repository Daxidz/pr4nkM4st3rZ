package ch.truanisei.pr4nkM4st3rZ;

import ch.truanisei.pr4nkM4st3rZ.prank.PrankGenerator;
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
        Group group = new Group();

        PrankGenerator prankGenerator = new PrankGenerator();

        for (Mail mail : prankGenerator.generatePrankMails())
            client.sendMail(mail);
    }
}
