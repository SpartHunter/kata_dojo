package edu.training.send_birthday_email;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class SendMailService {
    private final static String HOST = "smtp.freesmtpservers.com";
    private final static String PORT = "25";
    private final Session session;
    private String to;
    private final String from;

    public SendMailService ( String to, String from ) {
        Properties props = new Properties();
        props.put( "mail.smtp.auth", "false" );
        props.put( "mail.smtp.starttls.enable", "true" );
        props.put( "mail.smtp.host", HOST );
        props.put( "mail.smtp.port", PORT );
        this.session = Session.getInstance( props );
        this.to = to;
        this.from = from;
    }

    public void sendEmail() {
        try{
            Message message = new MimeMessage( session );
            message.setFrom( new InternetAddress (this.from) );
            message.setRecipients( Message.RecipientType.TO, InternetAddress.parse( this.to ) );
            message.setSubject( "Happy Birthday" );
            message.setText( "Happy Birthday to you, enjoy, this is your day." );
            Transport.send( message );
            System.out.println("Message sent Successfully to user");
        } catch( MessagingException e ) {
            throw new RuntimeException( e );
        }
    }
}
