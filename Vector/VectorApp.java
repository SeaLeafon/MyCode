package Vector;

public class VectorApp {
    public static void main(String[] args) {
        Vector a = new Vector(3, 4);
        Vector b = new Vector(2, 1);
        Vector c = new Vector(5, 12);
        double x = (c.multiply(a.scalar(b))).size();
        System.out.println(x);
    }
}
