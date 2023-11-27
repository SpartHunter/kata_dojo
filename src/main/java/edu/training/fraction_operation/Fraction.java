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

    public void showFraction(){
        if((this.getNumerator() % this.getDenominator()) == 0) {
            System.out.println( this.getNumerator() / this.getDenominator() );
        } else {
            System.out.println( this.getNumerator() + "/" + this.getDenominator() );
        }
    }

    public Fraction add ( Fraction fraction ) {
        Fraction additionResult = new Fraction( ( ( this.getNumerator() * fraction.getDenominator() ) + ( fraction.getNumerator() * this.getDenominator() ) ),
                                                ( this.getDenominator() * fraction.getDenominator() ) );

        return additionResult.simplifyFraction( additionResult.pgcdOfFraction() );
    }

    public Fraction  subtract ( Fraction fraction ) {
        Fraction subtractionResult = new Fraction( ( ( this.getNumerator() * fraction.getDenominator() ) - ( fraction.getNumerator() * this.getDenominator() ) ),
                                                ( this.getDenominator() * fraction.getDenominator() ) );

        return subtractionResult.simplifyFraction( subtractionResult.pgcdOfFraction() );
    }

    public Fraction  multiply ( Fraction fraction ) {
        Fraction multiplicationResult = new Fraction( ( this.getNumerator() * fraction.getNumerator()), (this.getDenominator() * fraction.getDenominator()));

        return multiplicationResult.simplifyFraction( multiplicationResult.pgcdOfFraction());
    }

    public Fraction  divide ( Fraction fraction ) {
        Fraction divisionResult = new Fraction( ( this.getNumerator() * fraction.getDenominator() ), ( this.getDenominator() * fraction.getNumerator() ) );

        return divisionResult.simplifyFraction( divisionResult.pgcdOfFraction() );
    }

    public String toString() {
        return this.getNumerator() + "/" + this.getDenominator();
    }
}
