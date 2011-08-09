/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SendMails;

import Helpers.GlobalVariables;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Store;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author letuan
 */
public class SendingMail {

    public Message[] messages = null;
    private Folder folder = null;
    private Store store = null;
    //private MailClient mailClient;
    private Runtime runtime = Runtime.getRuntime();
    private Authenticator authen = new SMTPAuthenticator();

    /**
     * Ham khoi dung
     */
    public SendingMail() {
    }

    /**
     * After sending email successfully, sending emails
     * @param to
     * @param cc
     * @param subject
     * @param content
     * @param file_name
     * @return
     */
    public boolean sendMail(String to, String subject, String content, String promotionCode) {
        boolean result = true;
        try {
            // Gets the System properties
            Properties props = new Properties();
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.host", MailConstant.MAIL_SERVER_OUTGOING);
            if (MailConstant.MAIL_SERVER_AUTH) {
                props.put("mail.smtp.auth", MailConstant.MAIL_SERVER_AUTH);
            }
            if (MailConstant.OUTGOING_PORT != null && !MailConstant.OUTGOING_PORT.trim().equals("")) {
                props.put("mail.smtp.port", MailConstant.OUTGOING_PORT);
                props.put("mail.smtp.socketFactory.port",
                        MailConstant.OUTGOING_PORT);
                props.put("mail.smtp.socketFactory.class",
                        "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.socketFactory.fallback", "false");
                props.setProperty("mail.smtp.quitwait", "false");
            }

            Session session = null;
            if (MailConstant.MAIL_SERVER_AUTH) {
                session = Session.getInstance(props, authen);
            } else {
                session = Session.getInstance(props);
            }
            // Get the default Session using Properties Object
            // Session session = Session.getDefaultInstance(l_props, null);

            session.setDebug(MailConstant.MAIL_DEBUG); // Enable the debug mode

            // Define message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(GlobalVariables.MAIL_SERVER_USER));
            /*
             * Multiple receipent to
             */

            message.addRecipients(Message.RecipientType.TO, to);

            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setContent(content.replace("[PromotionCode]", promotionCode),
                            "text/html" );

            Transport.send(message);

        } catch (MessagingException mex) { // Trap the MessagingException Error
            result = false;
        }
        return result;
    }

    /**
     * The Method close.
     * @return		void
     */
    public void close() {
        /*
         * Closing resources no use by now.
         */
        try {
            if (folder != null) {
                folder.close(true);
            }
            if (store != null) {
                store.close();
            }
        } catch (MessagingException e) {
            // e.printStackTrace();
        }
    }

    /**
     * @return the messages
     */
    public Message[] getMessages() {
        return messages;
    }

    /**
     * Inner class
     *
     * @author Ashok Das
     */
    private static class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(GlobalVariables.MAIL_SERVER_USER, GlobalVariables.MAIL_SERVER_PASSWORD);
        }
    }

    public String readFile() {
        String Content = ""; 	// String that holds current file line
        try {

            /*	Sets up a file reader to read the file passed on the command
            line one character at a time */
            FileReader input = new FileReader(System.getProperty("user.dir") + File.separator +
                        "src/SendMails/EmailTemplates.html");

            /* Filter FileReader through a Buffered read to read a line at a
            time */
            BufferedReader bufRead = new BufferedReader(input);
            
            int count = 0;	// Line number of count

            // Read first line
            String line = bufRead.readLine();
            Content += line;
            count++;

            // Read through file one line at time. Print line # and line
            while (line != null) {
                line = bufRead.readLine();
                Content += line;
                count++;
            }

            bufRead.close();

        } catch (ArrayIndexOutOfBoundsException e) {
            /* If no file was passed on the command line, this expception is
            generated. A message indicating how to the class should be
            called is displayed */
            System.out.println("Usage: java ReadFile filename\n");

        } catch (IOException e) {
            // If another exception is generated, print a stack trace
            e.printStackTrace();
        }

        return Content;
    }
}

