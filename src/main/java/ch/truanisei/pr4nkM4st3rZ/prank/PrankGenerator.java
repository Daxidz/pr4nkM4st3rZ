package ch.truanisei.pr4nkM4st3rZ.prank;

import ch.truanisei.pr4nkM4st3rZ.data.Email;
import ch.truanisei.pr4nkM4st3rZ.data.Group;
import ch.truanisei.pr4nkM4st3rZ.data.Message;
import ch.truanisei.pr4nkM4st3rZ.data.Parser;

import java.util.ArrayList;

/**
 * This class is used to generate a list of mails using the config.properties file datas
 *
 * @author Elisei Lucas
 * @author Truan David
 */
public class PrankGenerator {

    private final static int NB_VICTIMS_MIN = 3;

    private ArrayList<String> victims;
    private ArrayList<Message> pranks;

    private int nbGroups;

    /**
     * Class used to generate a list of pranks emails. It takes the number of groups wanted as an arguments
     * and generate the list using the config.properties
     * @param nbGroups
     */
    public PrankGenerator(int nbGroups) {
        this.nbGroups = nbGroups;

        this.pranks = Parser.getMessagesList();
        this.victims = Parser.getVictimsList();
    }

    /**
     * Generate the list of prank emails
     * @return the list of prank Email
     */
    public ArrayList<Email> generatePrankMails() {

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

        ArrayList<Email> prankEmails = new ArrayList<Email>();

        // Create a mail with a random prank for each group
        for (Group group : groups) {
            random = (int) (Math.random() * pranks.size());
            Email email = new Email(group, pranks.get(random));
            prankEmails.add(email);
        }

        return prankEmails;
    }
}
