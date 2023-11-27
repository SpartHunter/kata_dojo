package edu.training.fraction_operation;

public class Fraction {
    private Integer numerator;
    private Integer denominator;

    public Fraction ( Integer numerator, Integer denominator ) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Integer getNumerator () {
        return numerator;
    }

    public void setNumerator ( Integer numerator ) {
        this.numerator = numerator;
    }

    public Integer getDenominator () {
        return denominator;
    }

    public void setDenominator ( Integer denominator ) {
        this.denominator = denominator;
    }

    private int pgcdOfFraction () {
        int pgcd = 0;

        for( Integer i = 1; i<=this.getNumerator() && i<=this.getDenominator(); i++ ) {

            if( this.getNumerator() % i == 0 && this.getDenominator() % i == 0 ) {
                pgcd = i;
            }
        }

        return pgcd;
    }

    private Fraction simplifyFraction ( int pgcd ) {
        if(pgcd != 0) {
            return new Fraction( ( this.getNumerator() / pgcd ), ( this.getDenominator() / pgcd ) );
        } else {
            return new Fraction( ( this.getNumerator() ), ( this.getDenominator() ) );
        }
    }

    private void showFraction(){
        if((this.getNumerator() % this.getDenominator()) == 0) {
            System.out.println( this.getNumerator() / this.getDenominator() );
        } else {
            System.out.println( this.getNumerator() + "/" + this.getDenominator() );
        }
    }

    public void add ( Fraction fraction ) {
        Fraction additionResult = new Fraction( ( ( this.getNumerator() * fraction.getDenominator() ) + ( fraction.getNumerator() * this.getDenominator() ) ),
                                                ( this.getDenominator() * fraction.getDenominator() ) );

        additionResult.simplifyFraction( additionResult.pgcdOfFraction() ).showFraction();
    }

    public void  subtract ( Fraction fraction ) {
        Fraction subtractionResult = new Fraction( ( ( this.getNumerator() * fraction.getDenominator() ) - ( fraction.getNumerator() * this.getDenominator() ) ),
                                                ( this.getDenominator() * fraction.getDenominator() ) );

        subtractionResult.simplifyFraction( subtractionResult.pgcdOfFraction() ).showFraction();
    }

    public void  multiply ( Fraction fraction ) {
        Fraction multiplicationResult = new Fraction( ( this.getNumerator() * fraction.getNumerator()), (this.getDenominator() * fraction.getDenominator()));

        multiplicationResult.simplifyFraction( multiplicationResult.pgcdOfFraction()).showFraction();
    }

    public void  divide ( Fraction fraction ) {
        Fraction divisionResult = new Fraction( ( this.getNumerator() * fraction.getDenominator() ), ( this.getDenominator() * fraction.getNumerator() ) );

        divisionResult.simplifyFraction( divisionResult.pgcdOfFraction() ).showFraction();
    }
}
