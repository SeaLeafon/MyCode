public class Matrix2x2 implements Matrix2x2ADT {
    private double[][] matrix2x2 = new double[2][2];

    public Matrix2x2(double a00, double a01, double a10, double a11) {
        matrix2x2[0][0] = a00;
        matrix2x2[0][1] = a01;
        matrix2x2[1][0] = a10;
        matrix2x2[1][1] = a11;
    }

    public double getElem(int i, int j) throws IndexOutOfBoundsException {
        try {
            return matrix2x2[i][j];
        } catch (IndexOutOfBoundsException e) {
            IndexOutOfBoundsException exceptionObj = new IndexOutOfBoundsException("Invalid Index");
            throw exceptionObj;
        }
    }

    public boolean equals(Matrix2x2 b) {
        for (int i = 0; i < matrix2x2.length; i++) {
            for (int j = 0; j < matrix2x2.length; j++) {
                if (matrix2x2[i][j] != b.getElem(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Matrix2x2 transpose() {
        Matrix2x2 transposedMatrix = new Matrix2x2(matrix2x2[0][0], matrix2x2[1][0], matrix2x2[0][1], matrix2x2[1][1]);
        return transposedMatrix;
    }

    public Matrix2x2 add(Matrix2x2 b) {
        double[][] temp = new double[2][2];
        for (int i = 0; i < matrix2x2.length; i++) {
            for (int j = 0; j < matrix2x2.length; j++) {
                temp[i][j] = matrix2x2[i][j] + b.getElem(i, j);
            }
        }
        Matrix2x2 resultMatrix = new Matrix2x2(temp[0][0], temp[0][1], temp[1][0], temp[1][1]);
        return resultMatrix;
    }

    public Matrix2x2 multiply(double c) {
        double[][] temp = new double[2][2];
        for (int i = 0; i < matrix2x2.length; i++) {
            for (int j = 0; j < matrix2x2.length; j++) {
                temp[i][j] = matrix2x2[i][j] * c;
            }
        }
        Matrix2x2 resultMatrix = new Matrix2x2(temp[0][0], temp[0][1], temp[1][0], temp[1][1]);
        return resultMatrix;
    }

    public Matrix2x2 multiply(Matrix2x2 b) {
        double[][] temp = new double[2][2];
        for (int i = 0; i < matrix2x2.length; i++) {
            for (int j = 0; j < matrix2x2.length; j++) {
                temp[i][j] = matrix2x2[i][i] * b.getElem(i, j) + matrix2x2[i][1 - i] * b.getElem(1 - i, j);
            }
        }
        Matrix2x2 resultMatrix = new Matrix2x2(temp[0][0], temp[0][1], temp[1][0], temp[1][1]);
        return resultMatrix;
    }

    public double det() {
        return matrix2x2[0][0] * matrix2x2[1][1] - matrix2x2[1][0] * matrix2x2[0][1];
    }

    public double cofactor(int i, int j) throws IndexOutOfBoundsException {
        try {
            double x = matrix2x2[1 - i][1 - j];
            if (i != j) {
                x = -1 * x;
            }
            return x;
        } catch (IndexOutOfBoundsException e) {
            IndexOutOfBoundsException exceptionObj = new IndexOutOfBoundsException("Invalid Index");
            throw exceptionObj;
        }
    }

    public Matrix2x2 adjoint() {
        Matrix2x2 transposed = transpose();
        Matrix2x2 resultMatrix = new Matrix2x2(transposed.cofactor(0, 0), transposed.cofactor(0, 1),
                transposed.cofactor(1, 0), transposed.cofactor(1, 1));
        return resultMatrix;
    }

    public boolean isSingular() {
        return det() == 0;
    }

    public Matrix2x2 inverse() {
        if (isSingular()) {
            return null;
        }
        Matrix2x2 resultMatrix = adjoint().multiply(1 / det());
        return resultMatrix;
    }

    public String toString() {
        double a00 = getElem(0, 0);
        double a01 = getElem(0, 1);
        double a10 = getElem(1, 0);
        double a11 = getElem(1, 1);
        return "|" + a00 + " " + a01 + "|\n|" + a10 + " " + a11 + "|\n";
    }

}
