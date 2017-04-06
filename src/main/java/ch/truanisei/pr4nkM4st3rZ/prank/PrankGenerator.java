package ch.truanisei.pr4nkM4st3rZ.prank;

import ch.truanisei.pr4nkM4st3rZ.data.Group;
import ch.truanisei.pr4nkM4st3rZ.data.Mail;
import ch.truanisei.pr4nkM4st3rZ.data.Message;

import java.util.ArrayList;

/**
 * This class is used to generate a list of mails using the config.properties file datas
 *
 * @author Elisei Lucas
 * @author Truan David
 */
public class PrankGenerator {

    private final int NB_VICTIMS_MIN = 3;
    private ArrayList<String> victims = new ArrayList<String>();
    private ArrayList<Message> pranks = new ArrayList<Message>();

    private int nbGroups; // load nb groups here

    public PrankGenerator() {
        // load victims and pranks here
        // victims = Parser.
        // pranks = Parser.

        victims.add("1@test.kek");
        victims.add("2@test.kek");
        victims.add("3@test.kek");
        victims.add("4@test.kek");
        victims.add("5@test.kek");
        victims.add("6@test.kek");
        victims.add("7@test.kek");
        victims.add("8@test.kek");
        victims.add("9@test.kek");
        victims.add("10@test.kek");
        victims.add("11@test.kek");
        victims.add("12@test.kek");
        victims.add("13@test.kek");
        victims.add("14@test.kek");

        pranks.add(new Message("body1", "subject1"));
        pranks.add(new Message("body2", "subject2"));
        pranks.add(new Message("body3", "subject3"));

        nbGroups = 5;
    }

    public ArrayList<Mail> generatePrankMails() {

        // Tests if there are enough victims and if we can generate the number of groups wanted
        if (victims.size() < NB_VICTIMS_MIN) {
            System.out.println("Too few victims! Cannot generate a group.");
            return null;
        }

        if (victims.size() / nbGroups < NB_VICTIMS_MIN) {
            System.out.println("Too few victims for the number of groups wanted.");
            nbGroups = victims.size() / NB_VICTIMS_MIN;
            System.out.println("New number of groups: " + nbGroups);
        }

        ArrayList<Group> groups = new ArrayList<Group>();
        for (int i = 0; i < nbGroups; ++i) {
            groups.add(new Group());
        }

        int random;

        // Add a random sender for each group
        for (Group group : groups) {
            random = (int) (Math.random() * victims.size());
            group.setSender(victims.get(random));
            victims.remove(random);
        }

        // Add the recipients for each group
        int indexGroup = 0;
        while (!victims.isEmpty()) {
            random = (int) (Math.random() * victims.size());
            groups.get(indexGroup++ % nbGroups).addRecipient(victims.get(random));
            victims.remove(random);
        }

        ArrayList<Mail> prankMails = new ArrayList<Mail>();

        // Create a mail with a random prank for each group
        for (Group group : groups) {
            random = (int) (Math.random() * pranks.size());
            Mail mail = new Mail(group, pranks.get(random));
            prankMails.add(mail);
        }

        return prankMails;
    }
}
