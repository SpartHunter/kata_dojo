package edu.training;

import edu.training.fraction_operation.FractionMain;
import edu.training.send_birthday_email.BirthdayGreetingMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main ( String[] args ) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

        System.out.println("*** list of available scenarios ***");

        System.out.println("1) Calculation on fractions ");
        System.out.println("2) Birthday greeting ");

        System.out.println("Enter number of scenario you want to play : ");
        int numberOfScenarioToPlay = Integer.parseInt( reader.readLine() );

        if(numberOfScenarioToPlay == 1) {
            new FractionMain().runScenario();
        } else if (numberOfScenarioToPlay == 2) {
            new BirthdayGreetingMain().runScenario();
        } else {
            System.out.println("The number of scenario you enter is not valide ! ...... Bye");
        }
    }
}