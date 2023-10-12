import java.math.BigInteger;

public class Rational implements rationalADT {
    private BigInteger numerator;
    private BigInteger denominator;

    public Rational(BigInteger a, BigInteger b) {
        numerator = a;
        denominator = b;
    }

    public Rational(int a, int b) {
        numerator = BigInteger.valueOf(a);
        denominator = BigInteger.valueOf(b);
    }

    public BigInteger numer() {
        return numerator;
    }

    public BigInteger denom() {
        return denominator;
    }

    public Rational add(Rational r) {
        BigInteger a = (numerator.multiply(r.denom())).add(r.numer().multiply(denominator));
        BigInteger b = (denominator.multiply(r.denom()));
        Rational objRational = new Rational(a, b);
        return objRational;
    }

    public Rational subtract(Rational r) {
        BigInteger a = (numerator.multiply(r.denom())).subtract(r.numer().multiply(denominator));
        BigInteger b = (denominator.multiply(r.denom()));
        Rational objRational = new Rational(a, b);
        return objRational;
    }

    public Rational multiply(Rational r) {
        BigInteger a = (numerator.multiply(r.numer()));
        BigInteger b = (denominator.multiply(r.denom()));
        Rational objRational = new Rational(a, b);
        return objRational;
    }

    public Rational divide(Rational r) {
        BigInteger a = (numerator.multiply(r.denom()));
        BigInteger b = (denominator.multiply(r.numer()));
        Rational objRational = new Rational(a, b);
        return objRational;
    }

    public Rational negate() {
        Rational obRational = new Rational(numerator.multiply(BigInteger.valueOf(-1)), denominator);
        return obRational;
    }

    public Rational invert() {
        Rational obRational = new Rational(denominator, numerator);
        return obRational;
    }

    public void reduce() {
        BigInteger divisor = numerator.gcd(denominator);
        numerator = numerator.divide(divisor);
        denominator = denominator.divide(divisor);
    }

    public String toString() {
        return numerator.toString() + "/" + denominator.toString();
    }
}
