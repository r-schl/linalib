package matrix;

import vector.Vec2;

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

    public Mat2x2 set(float m00, float m01, float m10, float m11) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
        return this;
    }

    public Mat2x2 set(Mat2x2 mat) {
        this.m00 = mat.m00;
        this.m01 = mat.m01;
        this.m10 = mat.m10;
        this.m11 = mat.m11;
        return this;
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
    public int getInt(int row, int col) {
        if (row >= this.rows || col >= this.columns) {
            throw new IllegalArgumentException("Row and/or column out of range. " + row + " " + col);
        }
        if (row == 0) {
            if (col == 0) {
                return (int) m00;
            } else if (col == 1) {
                return (int) m01;
            }
        } else if (row == 1) {
            if (col == 0) {
                return (int) m10;
            } else if (col == 1) {
                return (int) m11;
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

    public Mat2x2 mul(float mat00, float mat01,
                      float mat10, float mat11) {
        float m00 = this.m00 * mat00 + this.m01 * mat10;
        float m01 = this.m00 * mat01 + this.m01 * mat11;
        float m10 = this.m10 * mat00 + this.m11 * mat10;
        float m11 = this.m10 * mat01 + this.m11 * mat11;
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

    public Mat2x2 mulRvs(float mat00, float mat01,
                         float mat10, float mat11) {
        float m00 = mat00 * this.m00 + mat01 * this.m10;
        float m01 = mat00 * this.m01 + mat01 * this.m11;
        float m10 = mat10 * this.m00 + mat11 * this.m10;
        float m11 = mat10 * this.m01 + mat11 * this.m11;
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
        return this;
    }

    public Mat2x2 rotation2d(float angle) {
        float cosA = (float) Math.cos(Math.toRadians(angle));
        float sinA = (float) Math.sin(Math.toRadians(angle));
        return this.mul(
            cosA, -sinA,
            sinA, cosA
        );
    }

    public Mat2x2 scale2d(Vec2 scale) {
        return scale2d(scale.x, scale.y);
    }

    public Mat2x2 scale2d(float scaleX, float scaleY) {
        return this.mul(
            scaleX, 0,
            0, scaleY
        );
    }

    @Override
    public Mat2x2 toInt() {
        this.m00 = (int) m00;
        this.m01 = (int) m01;
        this.m10 = (int) m10;
        this.m11 = (int) m11;
        return this;
    }

    @Override
    public Mat2x2 storeInside(FloatBuffer buf) {
        buf.put(m00);
        buf.put(m01);
        buf.put(m10);
        buf.put(m11);
        return this;
    }

    @Override
    public Mat2x2 absElWise() {
        this.m00 = Math.abs(m00);
        this.m01 = Math.abs(m01);
        this.m10 = Math.abs(m10);
        this.m11 = Math.abs(m11);
        return this;
    }

    public Mat2x2 addElWise(Mat2x2 mat) {
        this.m00 = this.m00 + mat.m00;
        this.m01 = this.m01 + mat.m01;
        this.m10 = this.m10 + mat.m10;
        this.m11 = this.m11 + mat.m11;
        return this;
    }

    public Mat2x2 addElWise(float mat00, float mat01,
                            float mat10, float mat11) {
        this.m00 = this.m00 + mat00;
        this.m01 = this.m01 + mat01;
        this.m10 = this.m10 + mat10;
        this.m11 = this.m11 + mat11;
        return this;
    }

    public Mat2x2 subElWise(Mat2x2 mat) {
        this.m00 = this.m00 - mat.m00;
        this.m01 = this.m01 - mat.m01;
        this.m10 = this.m10 - mat.m10;
        this.m11 = this.m11 - mat.m11;
        return this;
    }

    public Mat2x2 subElWise(float mat00, float mat01,
                            float mat10, float mat11) {
        this.m00 = this.m00 - mat00;
        this.m01 = this.m01 - mat01;
        this.m10 = this.m10 - mat10;
        this.m11 = this.m11 - mat11;
        return this;
    }

    public Mat2x2 subElWiseRvs(Mat2x2 mat) {
        this.m00 = mat.m00 - this.m00;
        this.m01 = mat.m01 - this.m01;
        this.m10 = mat.m10 - this.m10;
        this.m11 = mat.m11 - this.m11;
        return this;
    }

    public Mat2x2 subElWiseRvs(float mat00, float mat01,
                               float mat10, float mat11) {
        this.m00 = mat00 - this.m00;
        this.m01 = mat01 - this.m01;
        this.m10 = mat10 - this.m10;
        this.m11 = mat11 - this.m11;
        return this;
    }

    public Mat2x2 mulElWise(Mat2x2 mat) {
        this.m00 = this.m00 * mat.m00;
        this.m01 = this.m01 * mat.m01;
        this.m10 = this.m10 * mat.m10;
        this.m11 = this.m11 * mat.m11;
        return this;
    }

    public Mat2x2 mulElWise(float mat00, float mat01,
                            float mat10, float mat11) {
        this.m00 = this.m00 * mat00;
        this.m01 = this.m01 * mat01;
        this.m10 = this.m10 * mat10;
        this.m11 = this.m11 * mat11;
        return this;
    }

    public Mat2x2 divElWise(Mat2x2 mat){
        this.m00 = this.m00 / mat.m00;
        this.m01 = this.m01 / mat.m01;
        this.m10 = this.m10 / mat.m10;
        this.m11 = this.m11 / mat.m11;
        return this;
    }

    public Mat2x2 divElWise(float mat00, float mat01,
                            float mat10, float mat11) {
        this.m00 = this.m00 / mat00;
        this.m01 = this.m01 / mat01;
        this.m10 = this.m10 / mat10;
        this.m11 = this.m11 / mat11;
        return this;
    }
    
    public Mat2x2 divElWiseRvs(Mat2x2 mat){
        this.m00 = mat.m00 / this.m00;
        this.m01 = mat.m01 / this.m01;
        this.m10 = mat.m10 / this.m10;
        this.m11 = mat.m11 / this.m11;
        return this;
    }

    public Mat2x2 divElWiseRvs(float mat00, float mat01,
                               float mat10, float mat11) {
        this.m00 = mat00 / this.m00;
        this.m01 = mat01 / this.m01;
        this.m10 = mat10 / this.m10;
        this.m11 = mat11 / this.m11;
        return this;
    }

    public Mat2x2 addElWise(float r) {
        this.m00 = m00 + r;
        this.m01 = m01 + r;
        this.m10 = m10 + r;
        this.m11 = m11 + r;
        return this;
    }

    public Mat2x2 subElWise(float r) {
        this.m00 = m00 - r;
        this.m01 = m01 - r;
        this.m10 = m10 - r;
        this.m11 = m11 - r;
        return this;
    }

    public Mat2x2 mulElWise(float r) {
        this.m00 = m00 * r;
        this.m01 = m01 * r;
        this.m10 = m10 * r;
        this.m11 = m11 * r;
        return this;
    }

    public Mat2x2 divElWise(float r) {
        this.m00 = m00 / r;
        this.m01 = m01 / r;
        this.m10 = m10 / r;
        this.m11 = m11 / r;
        return this;
    }

    public Matrix subElWiseRvs(float r) {
        this.m00 = r - this.m00;
        this.m01 = r - this.m01;
        this.m10 = r - this.m10;
        this.m11 = r - this.m11;
        return this;
    }

    public Matrix divElWiseRvs(float r) {
        this.m00 = r / this.m00;
        this.m01 = r / this.m01;
        this.m10 = r / this.m10;
        this.m11 = r / this.m11;
        return this;
    }

}
