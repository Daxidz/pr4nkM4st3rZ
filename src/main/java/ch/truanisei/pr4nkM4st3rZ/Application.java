package ch.truanisei.pr4nkM4st3rZ;

import ch.truanisei.pr4nkM4st3rZ.prank.PrankGenerator;
import ch.truanisei.pr4nkM4st3rZ.SMTP.*;
import ch.truanisei.pr4nkM4st3rZ.data.*;

/**
 * Main program
 *
 * @author Lucas ELISEI (@faku99)
 * @author David TRUAN  (@Daxidz)
 */
public class Application {

    /**
     * Main program.
     *
     * @param args Number of groups.
     */
    public static void main(String... args) {
        if(args.length != 1) {
            System.out.println("Wrong number of arguments.");
            System.out.println("Usage: pr4nkM4st3rZ.jar <number_of_groups>");
            return;
        }

        SMTPClient client = new SMTPClient();
        PrankGenerator prankGenerator = new PrankGenerator(Integer.valueOf(args[0]));

        for (Email email : prankGenerator.generatePrankEmails()) {
            client.sendEmail(email);
        }

        System.out.println("Prank(s) sent successfully!");
    }
}
