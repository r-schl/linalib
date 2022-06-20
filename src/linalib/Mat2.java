package linalib;

import java.nio.FloatBuffer;

public class Mat2 implements Mat2Readable {

    public static final Mat2 IDENTITY = new Mat2(1, 0, 0, 1);

    public static final Mat2 FLIP = new Mat2(0, 1, 1, 0);

    public float m00, m01;
    public float m10, m11;

    public Mat2() {
        this(IDENTITY);
    }

    public Mat2(float m00, float m01, float m10, float m11) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
    }

    public Mat2(Mat2Readable other) {
        this.m00 = other.get00();
        this.m01 = other.get01();
        this.m10 = other.get10();
        this.m11 = other.get11();
    }

    @Override
    public float get00() {
        return this.m00;
    }

    @Override
    public float get01() {
        return this.m01;
    }

    @Override
    public float get10() {
        return this.m10;
    }

    @Override
    public float get11() {
        return this.m11;
    }

    @Override
    public float get(int r, int c) {
        if (r == 0 && c == 0)
            return m00;
        else if (r == 0 && c == 1)
            return m01;
        else if (r == 1 && c == 0)
            return m10;
        else if (r == 1 && c == 1)
            return m11;
        else
            throw new IllegalArgumentException("Row and/or column out of range of a 2x2 matrix.");
    }

    @Override
    public float[] getNewArr() {
        return new float[] {
                m00, m01,
                m10, m11
        };
    }

    @Override
    public float[][] getNewArr2() {
        return new float[][] {
                { m00, m01 },
                { m10, m11 }
        };
    }

    @Override
    public void storeInBuffer(FloatBuffer buf) {
        buf.put(m00);
        buf.put(m01);
        buf.put(m10);
        buf.put(m11);
    }

    // SETTERS

    public Mat2 transpose() {
        float tm01 = m01;
        m01 = m10;
        m10 = tm01;
        return null;
    }

    public Mat2 flipHor() {
        return this.mul(Mat2.FLIP);
    }

    public Mat2 flipVer() {
        return this.premul(Mat2.FLIP);
    }

    public Mat2 set(int r, int c, float val) {
        if (r == 0 && c == 0)
            this.m00 = val;
        else if (r == 0 && c == 1)
            this.m01 = val;
        else if (r == 1 && c == 0)
            this.m10 = val;
        else if (r == 1 && c == 1)
            this.m11 = val;
        else
            throw new IllegalArgumentException("Row and/or column out of range of a 2x2 matrix.");
        return this;
    }

    public Mat2 roundElementWise() {
        this.m00 = Math.round(this.m00);
        this.m01 = Math.round(this.m01);
        this.m10 = Math.round(this.m10);
        this.m11 = Math.round(this.m11);
        return this;
    }

    public Mat2 floorElementWise(float r) {
        this.m00 = (this.m00 - (this.m00 % r));
        this.m01 = (this.m01 - (this.m00 % r));
        this.m10 = (this.m10 - (this.m00 % r));
        this.m11 = (this.m11 - (this.m00 % r));
        return this;
    }

    public Mat2 negateElementWise() {
        this.m00 = -this.m00;
        this.m01 = -this.m01;
        this.m10 = -this.m10;
        this.m11 = -this.m11;
        return this;
    }

    public Mat2 toInt() {
        this.m00 = (int) m00;
        this.m01 = (int) m01;
        this.m10 = (int) m10;
        this.m11 = (int) m11;
        return this;
    }

    public Mat2 absElementWise() {
        this.m00 = Math.abs(m00);
        this.m01 = Math.abs(m01);
        this.m10 = Math.abs(m10);
        this.m11 = Math.abs(m11);
        return this;
    }

    public Mat2 addElementWise(float r) {
        this.m00 = m00 + r;
        this.m01 = m01 + r;
        this.m10 = m10 + r;
        this.m11 = m11 + r;
        return this;
    }

    public Mat2 subElementWise(float r) {
        this.m00 = m00 - r;
        this.m01 = m01 - r;
        this.m10 = m10 - r;
        this.m11 = m11 - r;
        return this;
    }

    public Mat2 presubElementWise(float r) {
        this.m00 = r - this.m00;
        this.m01 = r - this.m01;
        this.m10 = r - this.m10;
        this.m11 = r - this.m11;
        return this;
    }

    public Mat2 mulElementWise(float r) {
        this.m00 = m00 * r;
        this.m01 = m01 * r;
        this.m10 = m10 * r;
        this.m11 = m11 * r;
        return this;
    }

    public Mat2 divElementWise(float r) {
        this.m00 = m00 / r;
        this.m01 = m01 / r;
        this.m10 = m10 / r;
        this.m11 = m11 / r;
        return this;
    }

    public Mat2 predivElementWise(float r) {
        this.m00 = r / this.m00;
        this.m01 = r / this.m01;
        this.m10 = r / this.m10;
        this.m11 = r / this.m11;
        return this;
    }

    public Mat2 set(Mat2Readable mat) {
        this.m00 = mat.get00();
        this.m01 = mat.get01();
        this.m10 = mat.get10();
        this.m11 = mat.get11();
        return this;
    }

    public Mat2 addElementWise(Mat2Readable mat) {
        this.m00 = this.m00 + mat.get00();
        this.m01 = this.m01 + mat.get01();
        this.m10 = this.m10 + mat.get10();
        this.m11 = this.m11 + mat.get11();
        return this;
    }

    public Mat2 subElementWise(Mat2Readable mat) {
        this.m00 = this.m00 - mat.get00();
        this.m01 = this.m01 - mat.get01();
        this.m10 = this.m10 - mat.get10();
        this.m11 = this.m11 - mat.get11();
        return this;
    }

    public Mat2 presubElementWise(Mat2Readable mat) {
        this.m00 = mat.get00() - this.m00;
        this.m01 = mat.get01() - this.m01;
        this.m10 = mat.get10() - this.m10;
        this.m11 = mat.get11() - this.m11;
        return this;
    }

    public Mat2 mulElementWise(Mat2Readable mat) {
        this.m00 = this.m00 * mat.get00();
        this.m01 = this.m01 * mat.get01();
        this.m10 = this.m10 * mat.get10();
        this.m11 = this.m11 * mat.get11();
        return this;
    }

    public Mat2 divElementWise(Mat2Readable mat) {
        this.m00 = this.m00 / mat.get00();
        this.m01 = this.m01 / mat.get01();
        this.m10 = this.m10 / mat.get10();
        this.m11 = this.m11 / mat.get11();
        return this;
    }

    public Mat2 predivElementWise(Mat2Readable mat) {
        this.m00 = mat.get00() / this.m00;
        this.m01 = mat.get01() / this.m01;
        this.m10 = mat.get10() / this.m10;
        this.m11 = mat.get11() / this.m11;
        return this;
    }

    public Mat2 mul(Mat2Readable mat) {
        float m00 = this.m00 * mat.get00() + this.m01 * mat.get10();
        float m01 = this.m00 * mat.get01() + this.m01 * mat.get11();
        float m10 = this.m10 * mat.get00() + this.m11 * mat.get10();
        float m11 = this.m10 * mat.get01() + this.m11 * mat.get11();
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
        return this;
    }

    public Mat2 premul(Mat2Readable mat) {
        float m00 = mat.get00() * this.m00 + mat.get01() * this.m10;
        float m01 = mat.get00() * this.m01 + mat.get01() * this.m11;
        float m10 = mat.get10() * this.m00 + mat.get11() * this.m10;
        float m11 = mat.get10() * this.m01 + mat.get11() * this.m11;
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
        return this;
    }

    @Override
    public String toString() {
        float[] arr = this.getNewArr();

        float max = arr[0];
        for (int i = 0; i < 4; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxNumDigits = String.valueOf(max).length();

        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                int numLength = String.valueOf(arr[row * 2 + col]).length();
                for (int i = 0; i < maxNumDigits - numLength; i++) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(arr[row * 2 + col] + " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    // STATIC METHODS

    public static Mat2 transpose(Mat2Readable a) {
        return new Mat2(a).transpose();
    }

    public static Mat2 flipHor(Mat2Readable a) {
        return new Mat2(a).flipHor();
    }

    public static Mat2 flipVer(Mat2Readable a) {
        return new Mat2(a).flipVer();
    }

    public static Mat2 roundElementWise(Mat2Readable a) {
        return new Mat2(a).roundElementWise();
    }

    public static Mat2 floorElementWise(Mat2Readable a, float r) {
        return new Mat2(a).floorElementWise(r);
    }

    public static Mat2 negateElementWise(Mat2Readable a) {
        return new Mat2(a).negateElementWise();
    }

    public static Mat2 toInt(Mat2Readable a) {
        return new Mat2(a).toInt();
    }

    public static Mat2 absElementWise(Mat2Readable a) {
        return new Mat2(a).absElementWise();
    }

    public static Mat2 addElementWise(Mat2Readable a, float r) {
        return new Mat2(a).addElementWise(r);
    }

    public static Mat2 subElementWise(Mat2Readable a, float r) {
        return new Mat2(a).subElementWise(r);
    }

    public static Mat2 subElementWise(float r, Mat2Readable a) {
        return new Mat2(a).presubElementWise(r);
    }

    public static Mat2 mulElementWise(Mat2Readable a, float r) {
        return new Mat2(a).mulElementWise(r);
    }

    public static Mat2 divElementWise(Mat2Readable a, float r) {
        return new Mat2(a).divElementWise(r);
    }

    public static Mat2 divElementWise(float r, Mat2Readable a) {
        return new Mat2(a).predivElementWise(r);
    }

    public static Mat2 addElementWise(Mat2Readable a, Mat2Readable b) {
        return new Mat2(a).addElementWise(b);
    }

    public static Mat2 subElementWise(Mat2Readable a, Mat2Readable b) {
        return new Mat2(a).subElementWise(b);
    }

    public static Mat2 mulElementWise(Mat2Readable a, Mat2Readable b) {
        return new Mat2(a).mulElementWise(b);
    }

    public static Mat2 divElementWise(Mat2Readable a, Mat2Readable b) {
        return new Mat2(a).divElementWise(b);
    }

    public static Mat2 mul(Mat2Readable a, Mat2Readable b) {
        return new Mat2(a).mul(b);
    }

    public static Mat2 initRotation2(float angle) {
        float cosA = (float) Math.cos(Math.toRadians(-angle));
        float sinA = (float) Math.sin(Math.toRadians(-angle));
        return new Mat2(
                cosA, -sinA,
                sinA, cosA);
    }

    public static Mat2 initScale2(Vec2Readable s) {
        return new Mat2(
                s.getX(), 0,
                0, s.getY());
    }

}
