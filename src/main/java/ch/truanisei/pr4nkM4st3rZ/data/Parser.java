package ch.truanisei.pr4nkM4st3rZ.data;

import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {

    private static Logger LOG = Logger.getLogger(Parser.class.getName());

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("config.properties")));
        } catch (IOException e) {
            LOG.log(Level.SEVERE, null, e);
        }
    }

    /**
     * Fetch the victims list.
     *
     * @return The victims list.
     */
    public static ArrayList<String> getVictimsList() {
        ArrayList<String> victimsList = new ArrayList<>();

        String filePath = properties.getProperty("VICTIMS_LIST");

        File file = new File(filePath);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            String line;
            while ((line = reader.readLine()) != null) {
                victimsList.add(line);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, null, e);
        }

        return victimsList;
    }

    public static ArrayList<Message> getMessagesList() {
        ArrayList<Message> messagesList = new ArrayList<>();

        String folderPath = properties.getProperty("MSGS_DIR");

        File folder = new File(folderPath);

        try {
            if (!folder.isDirectory()) {
                throw new FileNotFoundException(folder.getName() + " is not a directory.");
            }

            for (File messageFile : folder.listFiles()) {
                if (messageFile.isFile() && FilenameUtils.getExtension(messageFile.getName()).equals("txt")) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(messageFile)));

                    String line;
                    String subject = "";
                    StringBuilder body = new StringBuilder();
                    for (int i = 0; (line = reader.readLine()) != null; ++i) {
                        if (i == 0) {
                            subject = line;
                        } else {
                            body.append(line).append("\n");
                        }
                    }

                    messagesList.add(new Message(subject, body.toString()));
                }
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, null, e);
        }

        return messagesList;
    }
}
