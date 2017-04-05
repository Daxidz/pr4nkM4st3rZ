package ch.truanisei.pr4nkM4st3rZ.SMTP;

import ch.truanisei.pr4nkM4st3rZ.data.Mail;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Elisei Lucas
 * @author Truan David
 */
public class SMTPClient {

    private Socket serverSocket = null;

    private String serverName;
    private int port;

    BufferedReader in = null;
    PrintWriter out = null;

    public SMTPClient() {
        // chopper le nom du serveur et le port ici
        port = 25000;
        serverName = "localhost";
    }

    /**
     * NEED TO IMPLEMENT THIS
     * @param mail
     * @throws IOException
     */
    public void sendMail(Mail mail) throws IOException {
        connect();
        while(true) {
            System.out.println(in.readLine());
        }
    }

    /**
     * CLASS FOR TEST
     * @throws IOException
     */
    public void sendMail() throws IOException {
        connect();
        // lis la 1ere ligne
        System.out.println(in.readLine());


        sendCommand(SMTPProtocol.EHLO);
        System.out.println("de");
        String input = in.readLine();
        while(!input.contains(" ")) {
            System.out.println(input);
            input = in.readLine();
        }
        System.out.println("bla");
        sendCommand(SMTPProtocol.MAIL_FROM + "test");
        in.readLine();
        sendCommand(SMTPProtocol.RCPT_TO + "test_rcpt");
        in.readLine();
        sendCommand(SMTPProtocol.DATA);
        in.readLine();
        out.write(SMTPProtocol.FROM + "test" + SMTPProtocol.LINE_ENDING);
        out.write(SMTPProtocol.TO + "test2" + SMTPProtocol.LINE_ENDING);
        out.write(SMTPProtocol.SUBJECT + "subject" + SMTPProtocol.LINE_ENDING + SMTPProtocol.LINE_ENDING);
        out.write("Body Test" + SMTPProtocol.END_DATA);
        out.flush();
        in.readLine();
        sendCommand(SMTPProtocol.QUIT);

        in.close();
        out.close();



    }

    public void connect() {

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

    private void sendCommand(String command) {
        out.write(command);
        out.write(SMTPProtocol.LINE_ENDING);
        out.flush();
    }
}
