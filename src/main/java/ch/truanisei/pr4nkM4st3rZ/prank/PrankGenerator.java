package ch.truanisei.pr4nkM4st3rZ.prank;

import ch.truanisei.pr4nkM4st3rZ.data.Email;
import ch.truanisei.pr4nkM4st3rZ.data.Group;
import ch.truanisei.pr4nkM4st3rZ.data.Message;
import ch.truanisei.pr4nkM4st3rZ.data.Parser;

import java.util.ArrayList;

/**
 * Used to generate a list of prank emails.
 *
 * @author Lucas ELISEI (@faku99)
 * @author David TRUAN  (@Daxidz)
 */
public class PrankGenerator {

    private final static int NB_VICTIMS_MIN = 3;

    private ArrayList<String> victims;

    private ArrayList<Message> pranks;

    private int nbGroups;

    /**
     * Prank generator constructor.
     *
     * @param nbGroups Number of groups to generate.
     */
    public PrankGenerator(int nbGroups) {
        this.nbGroups = nbGroups;

        this.pranks = Parser.getMessagesList();
        this.victims = Parser.getVictimsList();
    }

    /**
     * Returns a list of generated prank emails.
     *
     * @return A list of generated prank emails.
     */
    public ArrayList<Email> generatePrankEmails() {

        // If there aren't enough victims, we notify the user and exit the program.
        if (victims.size() < NB_VICTIMS_MIN) {
            throw new IllegalArgumentException("Not enough victims! Cannot generate a group...");
        }

        if (victims.size() / nbGroups < NB_VICTIMS_MIN) {
            System.out.print("[WARNING] Too few victims for the number of groups wanted... ");
            nbGroups = victims.size() / NB_VICTIMS_MIN;
            System.out.println("New number of groups: " + nbGroups);
        }

        ArrayList<Group> groups = new ArrayList<>(nbGroups);
        for(int i = 0; i < nbGroups; ++i) {
            groups.add(new Group());
        }

        int random;
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

        ArrayList<Email> prankEmails = new ArrayList<>();

        // Create a mail with a random prank for each group
        for (Group group : groups) {
            random = (int) (Math.random() * pranks.size());
            Email email = new Email(group, pranks.get(random));
            prankEmails.add(email);
        }

        return prankEmails;
    }
}
