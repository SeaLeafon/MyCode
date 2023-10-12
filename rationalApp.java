public class rationalApp {
    public static void main(String[] args) {
        Rational sum = new Rational(1, 2);
        for (int i = 2; i < 100; i++) {
            Rational tempRational = new Rational(i, i + 1);
            sum = sum.add(tempRational);
        }
        sum.reduce();
        System.out.println("THE SUM REDUCED: " + sum);
    }
}
