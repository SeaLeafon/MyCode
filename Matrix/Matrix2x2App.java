public class Matrix2x2App {
    public static void main(String[] args) {
        Matrix2x2 b = new Matrix2x2(1, 9, 4, 16);
        Matrix2x2 c = new Matrix2x2(1, 0, 0, 1);
        b = b.transpose().multiply(4);
        // BA = C -> A = (B^-1)C
        Matrix2x2 a = b.inverse().multiply(c);
        Matrix2x2 aInverse = a.inverse();
        System.out.println(aInverse);
    }
}
