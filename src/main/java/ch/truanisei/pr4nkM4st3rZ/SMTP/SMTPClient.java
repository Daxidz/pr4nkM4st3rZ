package ch.truanisei.pr4nkM4st3rZ.SMTP;

import ch.truanisei.pr4nkM4st3rZ.data.Email;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a client which connects to an SMTP server.
 *
 * The address and port of the server are defined in the `config.properties` file.
 *
 * @author Lucas ELISEI (@faku99)
 * @author David TRUAN  (@Daxidz)
 */
public class SMTPClient {

    private static Logger LOG = Logger.getLogger(SMTPClient.class.getName());

    private Socket serverSocket = null;

    private String serverName = "";

    private int port = 25;

    private BufferedReader in = null;

    private PrintWriter out = null;

    public SMTPClient() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(new File("config.properties")));

            serverName = properties.getProperty("SMTP_ADDRESS");
            port = Integer.valueOf(properties.getProperty("SMTP_PORT"));
        } catch (IOException e) {
            LOG.log(Level.SEVERE, null, e);
        }
    }

    /**
     * Sends an email to the SMTP server.
     *
     * @param email The email to send.
     *
     * @throws IOException
     */
    public void sendEmail(Email email) throws IOException {
        ArrayList<String> recipients = email.get_recipients();

        connect();
        // Read the first line
        in.readLine();

        sendCommand(SMTPProtocol.EHLO + "truanisei");

        // read until we get to the line "250 ...."
        String input = in.readLine();
        while (!input.contains(" ")) {
            System.out.println(input);
            input = in.readLine();
        }
        sendCommand(SMTPProtocol.MAIL_FROM + email.get_sender());
        in.readLine();
        for (String receipient : recipients) {
            sendCommand(SMTPProtocol.RCPT_TO + receipient);
            in.readLine();
        }

        sendCommand(SMTPProtocol.DATA);
        in.readLine();
        out.write(SMTPProtocol.FROM + email.get_sender() + SMTPProtocol.LINE_ENDING);

        out.write(SMTPProtocol.TO);
        for (int i = 0; i < recipients.size(); ++i) {
            out.write(recipients.get(i));
            if (i != recipients.size() - 1) {
                out.write(", ");
            }
            out.flush();
        }
        out.write(SMTPProtocol.LINE_ENDING);
        out.write(SMTPProtocol.SUBJECT + email.get_subject() + SMTPProtocol.LINE_ENDING + SMTPProtocol.LINE_ENDING);

        out.write(email.get_body() + SMTPProtocol.END_DATA);
        out.flush();

        in.readLine();
        sendCommand(SMTPProtocol.QUIT);

        in.close();
        out.close();
    }

    private void connect() {
        try {
            serverSocket = new Socket(InetAddress.getByName(serverName), port);
            in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(serverSocket.getOutputStream()));
        } catch (IOException e) {
            LOG.log(Level.SEVERE, null, e);
        }
    }

    private void sendCommand(String command) {
        out.write(command);
        out.write(SMTPProtocol.LINE_ENDING);
        out.flush();
    }
}
