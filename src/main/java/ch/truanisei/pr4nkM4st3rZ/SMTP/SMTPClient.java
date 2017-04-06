package ch.truanisei.pr4nkM4st3rZ.SMTP;

import ch.truanisei.pr4nkM4st3rZ.data.Mail;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * @author Elisei Lucas
 * @author Truan David
 */
public class SMTPClient {

    private Socket serverSocket = null;

    private String serverName;
    private int port = 25;

    BufferedReader in = null;
    PrintWriter out = null;

    public SMTPClient() {
        // chopper le nom du serveur et le port ici
        port = 25000;

        serverName = "localhost";
    }

    /**
     * NEED TO IMPLEMENT THIS
     *
     * @param mail
     * @throws IOException
     */
    public void sendMail(Mail mail) {

        ArrayList<String> recipients = mail.getRecipients();

        connect();
        try {
            // Read the first line
            in.readLine();

            sendCommand(SMTPProtocol.EHLO + "truanisei");

            // read until we get to the line "250 ...."
            String input = in.readLine();
            while (!input.contains(" ")) {
                System.out.println(input);
                input = in.readLine();
            }
            sendCommand(SMTPProtocol.MAIL_FROM + mail.getSender());
            in.readLine();
            for (String receipient : recipients) {
                sendCommand(SMTPProtocol.RCPT_TO + receipient);
                in.readLine();
            }

            sendCommand(SMTPProtocol.DATA);
            in.readLine();
            out.write(SMTPProtocol.FROM + mail.getSender() + SMTPProtocol.LINE_ENDING);

            out.write(SMTPProtocol.TO);
            for (int i = 0; i < recipients.size(); ++i) {
                out.write(recipients.get(i));
                if (i != recipients.size() - 1) {
                    out.write(", ");
                }
                out.flush();
            }
            out.write(SMTPProtocol.LINE_ENDING);
            out.write(SMTPProtocol.SUBJECT + mail.getSubject() + SMTPProtocol.LINE_ENDING + SMTPProtocol.LINE_ENDING);

            out.write(mail.getBody() + SMTPProtocol.END_DATA);
            out.flush();

            in.readLine();
            sendCommand(SMTPProtocol.QUIT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        disconnect();
    }

    private void connect() {

        try {
            serverSocket = new Socket(InetAddress.getByName(serverName), port);
        } catch (UnknownHostException e) {
            System.out.println("Server name incorect");
        } catch (IOException e) {
            System.out.println("Cannot connect to port " + port);
        }

        try {
            in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(serverSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void disconnect() {
        try {
            serverSocket.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendCommand(String command) {
        out.write(command);
        out.write(SMTPProtocol.LINE_ENDING);
        out.flush();
    }
}
