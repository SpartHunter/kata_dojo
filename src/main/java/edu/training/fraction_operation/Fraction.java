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

    private Integer pgcdOfFraction ( Fraction fraction ) {
        Integer pgcd = 0;

        for( Integer i = 0; i<=fraction.getNumerator() && i<=fraction.getDenominator(); i++ ) {

            if( fraction.getNumerator() % i == 0 && fraction.getDenominator() % i == 0 ) {
                pgcd = i;
            }
        }

        return pgcd;
    }

    private Fraction simplifyFraction ( Integer pgcd ) {
        return new Fraction( ( this.getNumerator() / pgcd ), ( this.getDenominator() / pgcd ) );
    }

    public Fraction add ( Fraction fraction ) {
        Fraction additionResult = new Fraction( ( ( this.getNumerator() * fraction.getDenominator() ) + ( fraction.getNumerator() * this.getDenominator() ) ),
                                                ( this.getDenominator() * fraction.getDenominator() ) );

        return additionResult.simplifyFraction( pgcdOfFraction( additionResult ) );
    }

    public Fraction subtract ( Fraction fraction ) {
        Fraction additionResult = new Fraction( ( ( this.getNumerator() * fraction.getDenominator() ) - ( fraction.getNumerator() * this.getDenominator() ) ),
                                                ( this.getDenominator() * fraction.getDenominator() ) );

        return additionResult.simplifyFraction( pgcdOfFraction( additionResult ) );
    }

    public Fraction multiply ( Fraction fraction ) {
        Fraction additionResult = new Fraction( ( this.getNumerator() * fraction.getNumerator()), (this.getDenominator() * fraction.getDenominator()));

        return additionResult.simplifyFraction( pgcdOfFraction( additionResult ) );
    }

    public Fraction divide ( Fraction fraction ) {
        Fraction additionResult = new Fraction( ( this.getNumerator() * fraction.getDenominator() ), ( this.getDenominator() * fraction.getNumerator() ) );

        return additionResult.simplifyFraction( pgcdOfFraction( additionResult ) );
    }
}
