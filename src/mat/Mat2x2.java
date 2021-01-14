package src.mat;

public class Mat2x2 extends Matrix {

    public static final Mat2x2 FLIP = new Mat2x2(
            0, 1,
            1, 0
    );

    public float m00, m01;
    public float m10, m11;

    private final int rows = 2;
    private final int columns = 2;

    public Mat2x2() {
        this(
                1, 0,
                0, 1
        );
    }

    public Mat2x2(float m00, float m01,
                  float m10, float m11) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
    }

    public Mat2x2(Mat2x2 other) {
        this.m00 = other.m00;
        this.m01 = other.m01;
        this.m10 = other.m10;
        this.m11 = other.m11;
    }


    public void set(float m00, float m01,
                    float m10, float m11) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
    }

    public void set(Mat2x2 other) {
        this.m00 = other.m00;
        this.m01 = other.m01;
        this.m10 = other.m10;
        this.m11 = other.m11;
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
       /* Mat2x2Utils.mulMatWithMat(
                0, 1,
                1, 0,
                m00, m01,
                m10, m11,
                this
        );*/
        return this;
    }

    @Override
    public Mat2x2 flipVer() {
      /*  Mat2x2Utils.mulMatWithMat(
                0, 1,
                1, 0,
                m00, m01,
                m10, m11,
                this
        );*/
        return this;
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
        return new float[][]{
                {m00, m01},
                {m10, m11}
        };
    }

    public Mat2x2 mul(Mat2x2 b) {
        float m00 = this.m00 * b.m00 + this.m01 * b.m10;
        float m01 = this.m00 * b.m01 + this.m01 * b.m11;
        float m10 = this.m10 * b.m00 + this.m11 * b.m10;
        float m11 = this.m10 * b.m01 + this.m11 * b.m11;
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
        return this;
    }

}
