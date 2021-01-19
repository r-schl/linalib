package matrix;

import java.nio.FloatBuffer;

public abstract class Matrix {

    public abstract int rowCount();

    public abstract int colCount();

    public int elmCount() {
        return rowCount() * colCount();
    }

    public abstract float get(int row, int col);

    public abstract int getInt(int row, int col);

    public abstract void set(int row, int col, float val);

    public abstract Matrix copy();

    public boolean isSqr() {
        return rowCount() == colCount();
    }

    public boolean isVer() {
        return rowCount() > colCount();
    }

    public boolean isHor() {
        return colCount() > rowCount();
    }

    public void rotate(int n) {
        if (n == 0) return;
        if (n > 0) {
            // clockwise
            for (int i = 0; i < n; i++) {
                this.transpose();
                this.flipHor();
            }
        }
        if (n < 0) {
            // anti clockwise
            for (int i = 0; i < Math.abs(n); i++) {
                this.transpose();
                this.flipVer();
            }
        }
    }

    public abstract Matrix flipHor();

    public abstract Matrix flipVer();

    public abstract Matrix transpose();

    public abstract Matrix toInt();

    public abstract Matrix storeInside(FloatBuffer buf);


    // element wise operations

    public abstract Matrix absElWise();

    public boolean hasSameDim(Matrix mat) {
        return mat.rowCount() == this.rowCount() && mat.colCount() == this.colCount();
    }

  

    public abstract float[][] toArr();

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < this.rowCount(); row++) {
            for (int col = 0; col < this.colCount(); col++) {
                builder.append(this.get(row, col));
                builder.append(" ");
            }
            if (row != this.rowCount() - 1) builder.append("\n");
        }
        return String.valueOf(builder);
    }

    public void print() {
        System.out.println(this);
    }


    // STATIC //


   /* public static mat.Matrix calcProduct(mat.Matrix A, mat.Matrix B) {
        int m1cols = A.colCount();
        int m1rows = A.rowCount();
        int m2cols = B.colCount();
        int m2rows = B.rowCount();

        if (m1cols != m2rows) {
            new Exception(m1rows + "x" + m1cols + " matrix cannot be multiplied by " + m2rows + "x" + m2cols + " matrix").printStackTrace();
            System.exit(-1);
        }

        mat.Matrix res = null;
        if (m1rows == 4 && m2cols == 4) res = new Mat4x4();
        else if (m1rows == 3 && m2cols == 3) res = new mat.Mat3x3();

        assert res != null;

        for (int row = 0; row < m1rows; row++) {
            for (int col = 0; col < m2cols; col++) {
                float cell = 0;
                for (int i = 0; i < m2rows; i++) {
                    cell += A.get(row, i) * B.get(i, col);
                }
                res.set(row, col, cell);
            }
        }
        return res;
    }*/
}
