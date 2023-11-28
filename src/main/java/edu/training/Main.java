package edu.training;

import edu.training.send_birthday_email.Contact;
import edu.training.send_birthday_email.CsvRepository;
import edu.training.send_birthday_email.Repository;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main ( String[] args ) {

        Repository csvrepository = new CsvRepository( new File( Objects.requireNonNull( Main.class.getClassLoader().getResource( "contacts_data.csv" ) )
                                                                       .getPath()), "," );

        List<Contact> allContact = csvrepository.findAllContact();

        for( Contact contact : allContact ) {
            System.out.println( "contact = " + contact );
        }
    }
}