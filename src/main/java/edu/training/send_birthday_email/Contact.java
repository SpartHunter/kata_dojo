package edu.training.send_birthday_email;

import java.time.LocalDate;

public class Contact {
    private String LastName;
    private String FirstName;
    private LocalDate birthday;
    private String email;

    public Contact ( String lastName, String firstName, LocalDate birthday, String email ) {
        LastName = lastName;
        FirstName = firstName;
        this.birthday = birthday;
        this.email = email;
    }

    public String getLastName () {
        return LastName;
    }

    public void setLastName ( String lastName ) {
        LastName = lastName;
    }

    public String getFirstName () {
        return FirstName;
    }

    public void setFirstName ( String firstName ) {
        FirstName = firstName;
    }

    public LocalDate getBirthday () {
        return birthday;
    }

    public void setBirthday ( LocalDate birthday ) {
        this.birthday = birthday;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }
}
