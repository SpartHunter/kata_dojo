package edu.training.fraction_operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FractionMain {

    public void runScenario() throws IOException {
        int repeat;
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

       do{
           System.out.println( "*** Using our class fraction ***" );

           System.out.print( "Enter the first fraction in a/b form : " );
           String readLineForFirstEnter = reader.readLine();
           String[] splitFirstEnter = readLineForFirstEnter.split( "/" );
           Fraction firstFraction = new Fraction( Integer.valueOf( splitFirstEnter[ 0 ] ), Integer.valueOf( splitFirstEnter[ 1 ] ) );

           System.out.print( "Enter the second fraction in c/d form : " );
           String readLineForSecondEnter = reader.readLine();
           String[] splitSecondEnter = readLineForSecondEnter.split( "/" );
           Fraction secondFraction = new Fraction( Integer.valueOf( splitSecondEnter[ 0 ] ), Integer.valueOf( splitSecondEnter[ 1 ] ) );

           System.out.println( "Enter 1, for addition" );
           System.out.println( "Enter 2, for subtraction" );
           System.out.println( "Enter 3, for multiplication" );
           System.out.println( "Enter 4, for division" );
           System.out.print( "What operation do you want ? : " );
           int operation = Integer.parseInt( reader.readLine() );

           switch( operation ) {
               case 1 -> {
                   System.out.print( "The result for addition of " + firstFraction + " and " + secondFraction + " is : " );
                   firstFraction.add( secondFraction ).showFractionOrResultOfItsDivision();
               }
               case 2 -> {
                   System.out.print( "The result for subtraction " + firstFraction + " and " + secondFraction + " is : " );
                   firstFraction.subtract( secondFraction ).showFractionOrResultOfItsDivision();
               }
               case 3 -> {
                   System.out.print( "The result for multiplication " + firstFraction + " and " + secondFraction + " is : " );
                   firstFraction.multiply( secondFraction ).showFractionOrResultOfItsDivision();
               }
               case 4 -> {
                   System.out.print( "The result for division " + firstFraction + " and " + secondFraction + " is : " );
                   firstFraction.divide( secondFraction ).showFractionOrResultOfItsDivision();
               }
               default -> System.out.println( "Operation not valid" );
           }

           System.out.println("Do you want to do a calculation again ? ");
           System.out.print("Enter 0 for stop program and 1 for new calcul : ");
           repeat = Integer.parseInt( reader.readLine() );

        } while(repeat == 1);
    }
}
