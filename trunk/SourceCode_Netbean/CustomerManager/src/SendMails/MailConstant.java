/**
 * @copyright 2008 JackHome Production.
 */
package SendMails;

import Helpers.GlobalVariables;

/**
 * MailConstant.java
 * @author Ashok Das
 * @version 1.2 May 19, 2008
 */
public class MailConstant {

    public static String MAIL_SERVER_INCOMING = "pop.gmail.com";
    public static String MAIL_SERVER_OUTGOING = "smtp.gmail.com";

    public static String INCOMING_PORT = "995";
    public static String OUTGOING_PORT = "465";

    public static boolean MAIL_SERVER_AUTH = true;

    public static boolean MAIL_DEBUG = false;
    public static String MAIL_CONTENT_TYPE = "text/html;charset=UTF-8";

    public static String INBOX = "INBOX";
    public static String POP_MAIL = "pop3";
    public static String SMTP_MAIL = "smtp";
}
