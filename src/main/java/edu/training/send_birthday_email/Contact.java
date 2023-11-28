package edu.training.send_birthday_email;

import java.time.LocalDate;

public class Contact {
    private String lastname;
    private String firstname;
    private LocalDate birthday;
    private String email;

    public Contact ( String lastname, String firstname, LocalDate birthday, String email ) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
        this.email = email;
    }

    public String getLastname () {
        return lastname;
    }

    public void setLastname ( String lastname ) {
        this.lastname = lastname;
    }

    public String getFirstname () {
        return firstname;
    }

    public void setFirstname ( String firstname ) {
        this.firstname = firstname;
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

    public String toString () {
        return this.getLastname() + ", " + this.getFirstname() + ", " + this.getBirthday() + ", " + this.getEmail();
    }
}
