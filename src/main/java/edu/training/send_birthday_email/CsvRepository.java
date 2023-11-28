package edu.training.send_birthday_email;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvRepository implements Repository{
    private Path pathOfCSV;
    private String delimiter;
    @Override
    public List<Contact> findAllContact () {
        try ( BufferedReader reader = new BufferedReader( new FileReader( pathOfCSV.toFile() ) ) ) {
            String currentLine;
            List<Contact> contacts = new ArrayList<>();
            while( ( currentLine = reader.readLine()) != null) {
                String[] values = currentLine.split( delimiter );
                contacts.add( new Contact( values[0], values[1], LocalDate.parse( values[2] ), values[3] ) );
            }
            return contacts;
        } catch( IOException e ) {
            throw new RuntimeException( e );
        }
    }
}
