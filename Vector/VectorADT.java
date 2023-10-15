package Vector;

public interface VectorADT {

    public Vector add(Vector c);

    public Vector multiply(double c);

    public Vector subtract(Vector c);

    public boolean equalTo(Vector c);

    public double scalar(Vector c);

    public double size();

    public String toString();
}
