import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {

    //data fields for numerator and denominator using BigInteger
    private BigInteger numerator;
    private BigInteger denominator;

    //default rational number is 0/1
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    //denominator cannot be zero
    public Rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Denominator cannot be zero");
        }

        //reduce by GCD and normalize
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd).multiply(denominator.signum() < 0 ? BigInteger.valueOf(-1) : BigInteger.ONE);
        this.denominator = denominator.abs().divide(gcd);
    }

    //accept Strings for numerator and denominator
    public Rational(String numerator, String denominator) {
        this(new BigInteger(numerator), new BigInteger(denominator));
    }

    //getter for numerator
    public BigInteger getNumerator() {
        return numerator;
    }

    //getter for denominator
    public BigInteger getDenominator() {
        return denominator;
    }

    //addition of two Rational numbers
    public Rational add(Rational secondRational) {
        BigInteger num = numerator.multiply(secondRational.getDenominator())
                .add(denominator.multiply(secondRational.getNumerator()));
        BigInteger denom = denominator.multiply(secondRational.getDenominator());
        return new Rational(num, denom);
    }

    //subtraction of two Rational numbers
    public Rational subtract(Rational secondRational) {
        BigInteger num = numerator.multiply(secondRational.getDenominator())
                .subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger denom = denominator.multiply(secondRational.getDenominator());
        return new Rational(num, denom);
    }

    //multiplication of two Rational numbers
    public Rational multiply(Rational secondRational) {
        BigInteger num = numerator.multiply(secondRational.getNumerator());
        BigInteger denom = denominator.multiply(secondRational.getDenominator());
        return new Rational(num, denom);
    }

    //division of two Rational numbers
    public Rational divide(Rational secondRational) {
        BigInteger num = numerator.multiply(secondRational.getDenominator());
        BigInteger denom = denominator.multiply(secondRational.getNumerator());
        return new Rational(num, denom);
    }

    //Override compareTo to compare Rational numbers
    @Override
    public int compareTo(Rational o) {
        BigInteger lhs = numerator.multiply(o.getDenominator());
        BigInteger rhs = denominator.multiply(o.getNumerator());
        return lhs.compareTo(rhs);
    }

    //Override equals method to check if two Rational numbers are equal
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Rational)) return false;
        Rational o = (Rational) other;
        return numerator.equals(o.getNumerator()) && denominator.equals(o.getDenominator());
    }

    //Override toString method to provide a string representation of the rational number
    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator.toString();  // No denominator if it's 1
        } else {
            return numerator + "/" + denominator;
        }
    }

    //convert Rational number to int
    @Override
    public int intValue() {
        return numerator.divide(denominator).intValue();
    }

    //convert Rational number to long
    @Override
    public long longValue() {
        return numerator.divide(denominator).longValue();
    }

    //convert Rational number to float
    @Override
    public float floatValue() {
        return numerator.divide(denominator).floatValue();
    }

    //convert Rational number to double
    @Override
    public double doubleValue() {
        return numerator.divide(denominator).doubleValue();
    }
}

import java.math.BigInteger;
import java.util.Scanner;

public class RationalTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //prompt user to enter numerator
        System.out.print("Enter the first rational number (numerator/denominator): ");
        String num1 = input.next();
        String denom1 = input.next();
        Rational r1 = new Rational(num1, denom1);

        //prompt user to enter denominator
        System.out.print("Enter the second rational number (numerator/denominator): ");
        String num2 = input.next();
        String denom2 = input.next();
        Rational r2 = new Rational(num2, denom2);

        //display input and output plus results
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));  // Addition
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));  // Subtraction
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));  // Multiplication
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));  // Division

        //check if two rational numbers are equal
        System.out.println(r2 + " is " + (r1.equals(r2) ? "" : "not ") + "equal to " + r1);
    }
}