package Vector;

public class Vector implements VectorADT {
    private double u, v;

    public Vector(double a, double b) {
        u = a;
        v = b;
    }

    public double getU() {
        return u;
    }

    public double getV() {
        return v;
    }

    public Vector add(Vector c) {
        double a = u + c.getU();
        double b = v + c.getV();
        Vector result = new Vector(a, b);
        return result;
    }

    public Vector multiply(double c) {
        double a = u * c;
        double b = v * c;
        Vector result = new Vector(a, b);
        return result;
    }

    public Vector subtract(Vector c) {
        return add(c.multiply(-1));
    }

    public boolean equalTo(Vector c) {
        return (u == c.getU() & v == c.getV());
    }

    public double scalar(Vector c) {
        return u * c.getU() + v * c.getV();
    }

    public double size() {
        return Math.sqrt(Math.pow(u, 2) + Math.pow(v, 2));
    }

    public String toString() {
        return u + "i " + v + "j";
    }

}
