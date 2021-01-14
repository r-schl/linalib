package src.mat;

import java.nio.FloatBuffer;

public class Mat2x2 extends Matrix {

    public static final Mat2x2 IDENTITY = new Mat2x2(1, 0, 0, 1);

    public static final Mat2x2 FLIP = new Mat2x2(0, 1, 1, 0);

    public float m00, m01;
    public float m10, m11;

    private final int rows = 2;
    private final int columns = 2;

    public Mat2x2() {
        this.set(IDENTITY);
    }

    public Mat2x2(float m00, float m01, float m10, float m11) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
    }

    public Mat2x2(Mat2x2 mat) {
        this.m00 = mat.m00;
        this.m01 = mat.m01;
        this.m10 = mat.m10;
        this.m11 = mat.m11;
    }

    public void set(float m00, float m01, float m10, float m11) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
    }

    public void set(Mat2x2 mat) {
        this.m00 = mat.m00;
        this.m01 = mat.m01;
        this.m10 = mat.m10;
        this.m11 = mat.m11;
    }

    @Override
    public int rowCount() {
        return rows;
    }

    @Override
    public int colCount() {
        return columns;
    }

    @Override
    public float get(int row, int col) {
        if (row >= this.rows || col >= this.columns) {
            throw new IllegalArgumentException("Row and/or column out of range. " + row + " " + col);
        }
        if (row == 0) {
            if (col == 0) {
                return m00;
            } else if (col == 1) {
                return m01;
            }
        } else if (row == 1) {
            if (col == 0) {
                return m10;
            } else if (col == 1) {
                return m11;
            }
        }
        throw new IllegalArgumentException("Row and/or column out of range. " + row + " " + col);
    }

    @Override
    public void set(int row, int col, float val) {
        if (row >= this.rows || col >= this.columns) {
            throw new IllegalArgumentException("Row and/or column out of range. " + row + " " + col);
        }
        if (row == 0) {
            if (col == 0) {
                m00 = val;
                return;
            } else if (col == 1) {
                m01 = val;
                return;
            }
        } else if (row == 1) {
            if (col == 0) {
                m10 = val;
                return;
            } else if (col == 1) {
                m11 = val;
                return;
            }
        }
        throw new IllegalArgumentException("Row and/or column out of range. " + row + " " + col);
    }

    @Override
    public Mat2x2 copy() {
        return new Mat2x2(this);
    }

    @Override
    public Mat2x2 flipHor() {
        return this.mul(Mat2x2.FLIP);
    }

    @Override
    public Mat2x2 flipVer() {
        return this.mulRvs(Mat2x2.FLIP);
    }

    @Override
    public Mat2x2 transpose() {
        float tm01 = m01;
        m01 = m10;
        m10 = tm01;
        return null;
    }

    @Override
    public float[][] toArr() {
        return new float[][] { { m00, m01 }, { m10, m11 } };
    }

    public Mat2x2 mul(Mat2x2 mat) {
        float m00 = this.m00 * mat.m00 + this.m01 * mat.m10;
        float m01 = this.m00 * mat.m01 + this.m01 * mat.m11;
        float m10 = this.m10 * mat.m00 + this.m11 * mat.m10;
        float m11 = this.m10 * mat.m01 + this.m11 * mat.m11;
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
        return this;
    }

    public Mat2x2 mulRvs(Mat2x2 mat) {
        float m00 = mat.m00 * this.m00 + mat.m01 * this.m10;
        float m01 = mat.m00 * this.m01 + mat.m01 * this.m11;
        float m10 = mat.m10 * this.m00 + mat.m11 * this.m10;
        float m11 = mat.m10 * this.m01 + mat.m11 * this.m11;
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
        return this;
    }

    @Override
    public Matrix toInt() {
        this.m00 = (int) m00;
        this.m01 = (int) m01;
        this.m10 = (int) m10;
        this.m11 = (int) m11;
        return this;
    }

    @Override
    public Matrix storeInside(FloatBuffer buf) {
        buf.put(m00);
        buf.put(m01);
        buf.put(m10);
        buf.put(m11);
        return this;
    }

}
