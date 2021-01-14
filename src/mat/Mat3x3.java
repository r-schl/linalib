package src.mat;

import java.nio.FloatBuffer;

public class Mat3x3 extends Matrix {

    public static final Mat3x3 IDENTITY = new Mat3x3(1, 0, 0, 0, 1, 0, 0, 0, 1);

    public static final Mat3x3 FLIP = new Mat3x3(0, 0, 1, 0, 1, 0, 1, 0, 0);

    public float m00, m01, m02;
    public float m10, m11, m12;
    public float m20, m21, m22;

    private final int rows = 3;
    private final int columns = 3;

    public Mat3x3() {
        this.set(IDENTITY);
    }

    public Mat3x3(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
    }

    public Mat3x3(Mat3x3 mat) {
        this.m00 = mat.m00;
        this.m01 = mat.m01;
        this.m02 = mat.m02;
        this.m10 = mat.m10;
        this.m11 = mat.m11;
        this.m12 = mat.m12;
        this.m20 = mat.m20;
        this.m21 = mat.m21;
        this.m22 = mat.m22;
    }

    public void set(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
    }

    public void set(Mat3x3 mat) {
        this.m00 = mat.m00;
        this.m01 = mat.m01;
        this.m02 = mat.m02;
        this.m10 = mat.m10;
        this.m11 = mat.m11;
        this.m12 = mat.m12;
        this.m20 = mat.m20;
        this.m21 = mat.m21;
        this.m22 = mat.m22;
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
            } else if (col == 2) {
                return m02;
            }
        } else if (row == 1) {
            if (col == 0) {
                return m10;
            } else if (col == 1) {
                return m11;
            } else if (col == 2) {
                return m12;
            }
        } else if (row == 2) {
            if (col == 0) {
                return m20;
            } else if (col == 1) {
                return m21;
            } else if (col == 2) {
                return m22;
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
            } else if (col == 2) {
                m02 = val;
                return;
            }
        } else if (row == 1) {
            if (col == 0) {
                m10 = val;
                return;
            } else if (col == 1) {
                m11 = val;
                return;
            } else if (col == 2) {
                m12 = val;
                return;
            }
        } else if (row == 2) {
            if (col == 0) {
                m20 = val;
                return;
            } else if (col == 1) {
                m21 = val;
                return;
            } else if (col == 2) {
                m22 = val;
                return;
            }
        }
        throw new IllegalArgumentException("Row and/or column out of range. " + row + " " + col);
    }

    @Override
    public Mat3x3 copy() {
        return new Mat3x3(this);
    }

    @Override
    public Mat3x3 flipHor() {
        return this.mul(Mat3x3.FLIP);
    }

    @Override
    public Mat3x3 flipVer() {
        return this.mulRvs(Mat3x3.FLIP);
    }

    @Override
    public Mat3x3 transpose() {
        float tm01 = m01;
        m01 = m10;
        float tm02 = m02;
        m02 = m20;
        m10 = tm01;
        float tm12 = m12;
        m12 = m21;
        m20 = tm02;
        m21 = tm12;
        return this;
    }

    @Override
    public float[][] toArr() {
        return new float[][] { { m00, m01, m02 }, { m10, m11, m12 }, { m20, m21, m22 } };
    }

    public Mat3x3 mul(Mat3x3 mat) {
        float m00 = this.m00 * mat.m00 + this.m01 * mat.m10 + this.m02 * mat.m20;
        float m01 = this.m00 * mat.m01 + this.m01 * mat.m11 + this.m02 * mat.m21;
        float m02 = this.m00 * mat.m02 + this.m01 * mat.m12 + this.m02 * mat.m22;
        float m10 = this.m10 * mat.m00 + this.m11 * mat.m10 + this.m12 * mat.m20;
        float m11 = this.m10 * mat.m01 + this.m11 * mat.m11 + this.m12 * mat.m21;
        float m12 = this.m10 * mat.m02 + this.m11 * mat.m12 + this.m12 * mat.m22;
        float m20 = this.m20 * mat.m00 + this.m21 * mat.m10 + this.m22 * mat.m20;
        float m21 = this.m20 * mat.m01 + this.m21 * mat.m11 + this.m22 * mat.m21;
        float m22 = this.m20 * mat.m02 + this.m21 * mat.m12 + this.m22 * mat.m22;
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        return this;
    }

    public Mat3x3 mulRvs(Mat3x3 mat) {
        float m00 = mat.m00 * this.m00 + mat.m01 * this.m10 + mat.m02 * this.m20;
        float m01 = mat.m00 * this.m01 + mat.m01 * this.m11 + mat.m02 * this.m21;
        float m02 = mat.m00 * this.m02 + mat.m01 * this.m12 + mat.m02 * this.m22;
        float m10 = mat.m10 * this.m00 + mat.m11 * this.m10 + mat.m12 * this.m20;
        float m11 = mat.m10 * this.m01 + mat.m11 * this.m11 + mat.m12 * this.m21;
        float m12 = mat.m10 * this.m02 + mat.m11 * this.m12 + mat.m12 * this.m22;
        float m20 = mat.m20 * this.m00 + mat.m21 * this.m10 + mat.m22 * this.m20;
        float m21 = mat.m20 * this.m01 + mat.m21 * this.m11 + mat.m22 * this.m21;
        float m22 = mat.m20 * this.m02 + mat.m21 * this.m12 + mat.m22 * this.m22;
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        return this;
    }

    @Override
    public Matrix toInt() {
        this.m00 = (int) m00;
        this.m01 = (int) m01;
        this.m02 = (int) m02;
        this.m10 = (int) m10;
        this.m11 = (int) m11;
        this.m12 = (int) m12;
        this.m20 = (int) m20;
        this.m21 = (int) m21;
        this.m22 = (int) m22;
        return this;
    }

    @Override
    public Matrix storeInside(FloatBuffer buf) {
        buf.put(m00);
        buf.put(m01);
        buf.put(m20);
        buf.put(m10);
        buf.put(m11);
        buf.put(m12);
        buf.put(m20);
        buf.put(m21);
        buf.put(m22);
        return this;
    }
}
