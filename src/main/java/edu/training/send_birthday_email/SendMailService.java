package edu.training.send_birthday_email;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.training.Main;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class SendMailService {
    private final static String HOST = "smtp.mailosaur.net";
    private final static String PORT = "587";
    private final static String FROM = "birthdaygreeting@kata.com";
    private final Session session;
    List<Contact> contacts;

    public SendMailService ( List<Contact> contacts ) {
        Properties props = new Properties();
        props.put( "mail.smtp.auth", "true" );
        props.put( "mail.smtp.starttls.enable", "true" );
        props.put( "mail.smtp.host", HOST );
        props.put( "mail.smtp.port", PORT );
        JsonObject properties = convertFileToJson();
        this.session = Session.getInstance( props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication () {
                return new PasswordAuthentication( properties.get( "username" ).getAsString(), properties.get( "password" ).getAsString() );
            }
        } );
        this.contacts = this.selectionOfContactWithBirthdayIsCurrentDay( contacts );
    }

    public void sendEmail () {
        StringBuilder contactAsString = new StringBuilder();

        for(Contact contact : contacts){
            contactAsString.append( contact.getEmail() ).append( ", " );
        }

        try {
            Message message = new MimeMessage( session );
            message.setFrom( new InternetAddress( FROM ) );
            message.setRecipients( Message.RecipientType.TO, InternetAddress.parse( contactAsString.toString() ) );
            message.setSubject( "Happy Birthday" );
            message.setText( "Happy Birthday to you, enjoy, this is your day." );
            Transport.send( message );
            System.out.println( "Message sent Successfully to user" );
        } catch( MessagingException e ) {
            throw new RuntimeException( e );
        }
    }

    private List<Contact> selectionOfContactWithBirthdayIsCurrentDay ( List<Contact> contacts ) {
        List<Contact> contactsWithBirthdayIsToday = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for( Contact contact : contacts ) {
            if( contact.getBirthday().getMonthValue() == currentDate.getMonthValue() && contact.getBirthday().getDayOfMonth() == currentDate.getDayOfMonth() ) {
                contactsWithBirthdayIsToday.add( contact );
            }
        }

        return contactsWithBirthdayIsToday;
    }

    private JsonObject convertFileToJson() {
        File properties = new File( Objects.requireNonNull( Main.class.getClassLoader().getResource( "properties.json" ) ).getPath() );

        try {
            JsonElement jsonElement = JsonParser.parseReader( new FileReader( properties ) );
            return jsonElement.getAsJsonObject();
        } catch( IOException e ) {
            throw new RuntimeException( e );
        }

    }

}
