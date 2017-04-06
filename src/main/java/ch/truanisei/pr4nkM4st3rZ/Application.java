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
        //PrankGenerator prankGenerator = new PrankGenerator(Integer.valueOf(args[0]));
        PrankGenerator prankGenerator = new PrankGenerator(3);

        for (Email email : prankGenerator.generatePrankMails())
            client.sendEmail(email);
    }
}
