package edu.training.send_birthday_email;

import edu.training.Main;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class BirthdayGreetingMain {

    public void runScenario() {
        Repository csvrepository = new CsvRepository( new File( Objects.requireNonNull( Main.class.getClassLoader().getResource( "contacts_data.csv" ) )
                                                                       .getPath() ), "," );

        List<Contact> allContact = csvrepository.findAllContact();

        SendMailService sendMail = new SendMailService( allContact );
        sendMail.sendEmail();
    }
}
