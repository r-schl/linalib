package linalib;

import java.nio.FloatBuffer;

public class Mat3 implements Mat3Readable {

    public static final Mat3 IDENTITY = new Mat3(1, 0, 0, 0, 1, 0, 0, 0, 1);

    public static final Mat3 FLIP = new Mat3(0, 0, 1, 0, 1, 0, 1, 0, 0);

    public float m00, m01, m02;
    public float m10, m11, m12;
    public float m20, m21, m22;

    public Mat3() {
        this(IDENTITY);
    }

    public Mat3(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
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

    public Mat3(Mat3Readable other) {
        this.m00 = other.get00();
        this.m01 = other.get01();
        this.m02 = other.get02();
        this.m10 = other.get10();
        this.m11 = other.get11();
        this.m12 = other.get12();
        this.m20 = other.get20();
        this.m21 = other.get21();
        this.m22 = other.get22();
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
    public float get02() {
        return this.m02;
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
    public float get12() {
        return this.m12;
    }

    @Override
    public float get20() {
        return this.m20;
    }

    @Override
    public float get21() {
        return this.m21;
    }

    @Override
    public float get22() {
        return this.m22;
    }

    @Override
    public float get(int r, int c) {
        if (r == 0 && c == 0)
            return m00;
        else if (r == 0 && c == 1)
            return m01;
        else if (r == 0 && c == 2)
            return m02;
        else if (r == 1 && c == 0)
            return m10;
        else if (r == 1 && c == 1)
            return m11;
        else if (r == 1 && c == 2)
            return m12;
        else if (r == 2 && c == 0)
            return m20;
        else if (r == 2 && c == 1)
            return m21;
        else if (r == 2 && c == 2)
            return m22;
        else
            throw new IllegalArgumentException("Row and/or column out of range of a 3x3 matrix.");
    }

    @Override
    public float[] getNewArr() {
        return new float[] {
                m00, m01, m02,
                m10, m11, m12,
                m20, m21, m22
        };
    }

    @Override
    public float[][] getNewArr2() {
        return new float[][] {
                { m00, m01, m02 },
                { m10, m11, m12 },
                { m20, m21, m22 }
        };
    }

    @Override
    public void storeInBuffer(FloatBuffer buf) {
        buf.put(m00);
        buf.put(m01);
        buf.put(m20);
        buf.put(m10);
        buf.put(m11);
        buf.put(m12);
        buf.put(m20);
        buf.put(m21);
        buf.put(m22);
    }

    // SETTERS

    public Mat3 transpose() {
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

    public Mat3 flipHor() {
        return this.mul(Mat3.FLIP);
    }

    public Mat3 flipVer() {
        return this.premul(Mat3.FLIP);
    }

    public Mat3 set(int r, int c, float val) {
        if (r == 0 && c == 0)
            this.m00 = val;
        else if (r == 0 && c == 1)
            this.m01 = val;
        else if (r == 0 && c == 2)
            this.m02 = val;
        else if (r == 1 && c == 0)
            this.m10 = val;
        else if (r == 1 && c == 1)
            this.m11 = val;
        else if (r == 1 && c == 2)
            this.m12 = val;
        else if (r == 2 && c == 0)
            this.m20 = val;
        else if (r == 2 && c == 1)
            this.m21 = val;
        else if (r == 2 && c == 2)
            this.m22 = val;
        else
            throw new IllegalArgumentException("Row and/or column out of range of a 3x3 matrix.");
        return this;
    }

    public Mat3 roundElementWise() {
        this.m00 = Math.round(this.m00);
        this.m01 = Math.round(this.m01);
        this.m02 = Math.round(this.m02);
        this.m10 = Math.round(this.m10);
        this.m11 = Math.round(this.m11);
        this.m12 = Math.round(this.m12);
        this.m20 = Math.round(this.m20);
        this.m21 = Math.round(this.m21);
        this.m22 = Math.round(this.m22);
        return this;
    }

    public Mat3 floorElementWise(float r) {
        this.m00 = (this.m00 - (this.m00 % r));
        this.m01 = (this.m01 - (this.m00 % r));
        this.m02 = (this.m02 - (this.m00 % r));
        this.m10 = (this.m10 - (this.m00 % r));
        this.m11 = (this.m11 - (this.m00 % r));
        this.m12 = (this.m12 - (this.m00 % r));
        this.m20 = (this.m20 - (this.m00 % r));
        this.m21 = (this.m21 - (this.m00 % r));
        this.m22 = (this.m22 - (this.m00 % r));
        return this;
    }

    public Mat3 negateElementWise() {
        this.m00 = -this.m00;
        this.m01 = -this.m01;
        this.m02 = -this.m02;
        this.m10 = -this.m10;
        this.m11 = -this.m11;
        this.m12 = -this.m12;
        this.m20 = -this.m20;
        this.m21 = -this.m21;
        this.m22 = -this.m22;
        return this;
    }

    public Mat3 toInt() {
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

    public Mat3 absElementWise() {
        this.m00 = Math.abs(m00);
        this.m01 = Math.abs(m01);
        this.m02 = Math.abs(m02);
        this.m10 = Math.abs(m10);
        this.m11 = Math.abs(m11);
        this.m12 = Math.abs(m12);
        this.m20 = Math.abs(m20);
        this.m21 = Math.abs(m21);
        this.m22 = Math.abs(m22);
        return this;
    }

    public Mat3 addElementWise(float r) {
        this.m00 = this.m00 + r;

        this.m01 = this.m01 + r;
        this.m02 = this.m02 + r;
        this.m10 = this.m10 + r;
        this.m11 = this.m11 + r;
        this.m12 = this.m12 + r;
        this.m20 = this.m20 + r;
        this.m21 = this.m21 + r;
        this.m22 = this.m22 + r;
        return this;
    }

    public Mat3 subElementWise(float r) {
        this.m00 = this.m00 - r;

        this.m01 = this.m01 - r;
        this.m02 = this.m02 - r;
        this.m10 = this.m10 - r;
        this.m11 = this.m11 - r;
        this.m12 = this.m12 - r;
        this.m20 = this.m20 - r;
        this.m21 = this.m21 - r;
        this.m22 = this.m22 - r;
        return this;
    }

    public Mat3 presubElementWise(float r) {
        this.m00 = r - this.m00;

        this.m01 = r - this.m01;
        this.m02 = r - this.m02;
        this.m10 = r - this.m10;
        this.m11 = r - this.m11;
        this.m12 = r - this.m12;
        this.m20 = r - this.m20;
        this.m21 = r - this.m21;
        this.m22 = r - this.m22;
        return this;
    }

    public Mat3 mulElementWise(float r) {
        this.m00 = this.m00 * r;

        this.m01 = this.m01 * r;
        this.m02 = this.m02 * r;
        this.m10 = this.m10 * r;
        this.m11 = this.m11 * r;
        this.m12 = this.m12 * r;
        this.m20 = this.m20 * r;
        this.m21 = this.m21 * r;
        this.m22 = this.m22 * r;
        return this;
    }

    public Mat3 divElementWise(float r) {
        this.m00 = this.m00 / r;

        this.m01 = this.m01 / r;
        this.m02 = this.m02 / r;
        this.m10 = this.m10 / r;
        this.m11 = this.m11 / r;
        this.m12 = this.m12 / r;
        this.m20 = this.m20 / r;
        this.m21 = this.m21 / r;
        this.m22 = this.m22 / r;
        return this;
    }

    public Mat3 predivElementWise(float r) {
        this.m00 = r / this.m00;
        this.m01 = r / this.m01;
        this.m02 = r / this.m02;
        this.m10 = r / this.m10;
        this.m11 = r / this.m11;
        this.m12 = r / this.m12;
        this.m20 = r / this.m20;
        this.m21 = r / this.m21;
        this.m22 = r / this.m22;
        return this;
    }

    public Mat3 set(Mat3Readable mat) {
        this.m00 = mat.get00();
        this.m01 = mat.get01();
        this.m02 = mat.get02();
        this.m10 = mat.get10();
        this.m11 = mat.get11();
        this.m12 = mat.get12();
        this.m20 = mat.get20();
        this.m21 = mat.get21();
        this.m22 = mat.get22();
        return this;
    }

    public Mat3 addElementWise(Mat3Readable mat) {
        this.m00 = this.m00 + mat.get00();
        this.m01 = this.m01 + mat.get01();
        this.m02 = this.m02 + mat.get02();
        this.m10 = this.m10 + mat.get10();
        this.m11 = this.m11 + mat.get11();
        this.m12 = this.m12 + mat.get12();
        this.m20 = this.m20 + mat.get20();
        this.m21 = this.m21 + mat.get21();
        this.m22 = this.m22 + mat.get22();
        return this;
    }

    public Mat3 subElementWise(Mat3Readable mat) {
        this.m00 = this.m00 - mat.get00();
        this.m01 = this.m01 - mat.get01();
        this.m02 = this.m02 - mat.get02();
        this.m10 = this.m10 - mat.get10();
        this.m11 = this.m11 - mat.get11();
        this.m12 = this.m12 - mat.get12();
        this.m20 = this.m20 - mat.get20();
        this.m21 = this.m21 - mat.get21();
        this.m22 = this.m22 - mat.get22();
        return this;
    }

    public Mat3 presubElementWise(Mat3Readable mat) {
        this.m00 = mat.get00() - this.m00;
        this.m01 = mat.get01() - this.m01;
        this.m02 = mat.get02() - this.m02;
        this.m10 = mat.get10() - this.m10;
        this.m11 = mat.get11() - this.m11;
        this.m12 = mat.get12() - this.m12;
        this.m20 = mat.get20() - this.m20;
        this.m21 = mat.get21() - this.m21;
        this.m22 = mat.get22() - this.m22;
        return this;
    }

    public Mat3 mulElementWise(Mat3Readable mat) {
        this.m00 = this.m00 * mat.get00();
        this.m01 = this.m01 * mat.get01();
        this.m02 = this.m02 * mat.get02();
        this.m10 = this.m10 * mat.get10();
        this.m11 = this.m11 * mat.get11();
        this.m12 = this.m12 * mat.get12();
        this.m20 = this.m20 * mat.get20();
        this.m21 = this.m21 * mat.get21();
        this.m22 = this.m22 * mat.get22();
        return this;
    }

    public Mat3 divElementWise(Mat3Readable mat) {
        this.m00 = this.m00 / mat.get00();
        this.m01 = this.m01 / mat.get01();
        this.m02 = this.m02 / mat.get02();
        this.m10 = this.m10 / mat.get10();
        this.m11 = this.m11 / mat.get11();
        this.m12 = this.m12 / mat.get12();
        this.m20 = this.m20 / mat.get20();
        this.m21 = this.m21 / mat.get21();
        this.m22 = this.m22 / mat.get22();
        return this;
    }

    public Mat3 predivElementWise(Mat3Readable mat) {
        this.m00 = mat.get00() / this.m00;
        this.m01 = mat.get01() / this.m01;
        this.m02 = mat.get02() / this.m02;
        this.m10 = mat.get10() / this.m10;
        this.m11 = mat.get11() / this.m11;
        this.m12 = mat.get12() / this.m12;
        this.m20 = mat.get20() / this.m20;
        this.m21 = mat.get21() / this.m21;
        this.m22 = mat.get22() / this.m22;
        return this;
    }

    public Mat3 mul(Mat3Readable mat) {
        float m00 = this.m00 * mat.get00() + this.m01 * mat.get10() + this.m02 * mat.get20();
        float m01 = this.m00 * mat.get01() + this.m01 * mat.get11() + this.m02 * mat.get21();
        float m02 = this.m00 * mat.get02() + this.m01 * mat.get12() + this.m02 * mat.get22();
        float m10 = this.m10 * mat.get00() + this.m11 * mat.get10() + this.m12 * mat.get20();
        float m11 = this.m10 * mat.get01() + this.m11 * mat.get11() + this.m12 * mat.get21();
        float m12 = this.m10 * mat.get02() + this.m11 * mat.get12() + this.m12 * mat.get22();
        float m20 = this.m20 * mat.get00() + this.m21 * mat.get10() + this.m22 * mat.get20();
        float m21 = this.m20 * mat.get01() + this.m21 * mat.get11() + this.m22 * mat.get21();
        float m22 = this.m20 * mat.get02() + this.m21 * mat.get12() + this.m22 * mat.get22();
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

    public Mat3 premul(Mat3Readable mat) {
        float m00 = mat.get00() * this.m00 + mat.get01() * this.m10 + mat.get02() * this.m20;
        float m01 = mat.get00() * this.m01 + mat.get01() * this.m11 + mat.get02() * this.m21;
        float m02 = mat.get00() * this.m02 + mat.get01() * this.m12 + mat.get02() * this.m22;
        float m10 = mat.get10() * this.m00 + mat.get11() * this.m10 + mat.get12() * this.m20;
        float m11 = mat.get10() * this.m01 + mat.get11() * this.m11 + mat.get12() * this.m21;
        float m12 = mat.get10() * this.m02 + mat.get11() * this.m12 + mat.get12() * this.m22;
        float m20 = mat.get20() * this.m00 + mat.get21() * this.m10 + mat.get22() * this.m20;
        float m21 = mat.get20() * this.m01 + mat.get21() * this.m11 + mat.get22() * this.m21;
        float m22 = mat.get20() * this.m02 + mat.get21() * this.m12 + mat.get22() * this.m22;
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
    public String toString() {
        float[] arr = this.getNewArr();

        float max = arr[0];
        for (int i = 0; i < 9; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxNumDigits = String.valueOf(max).length();

        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int numLength = String.valueOf(arr[row * 3 + col]).length();
                for (int i = 0; i < maxNumDigits - numLength; i++) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(arr[row * 3 + col] + " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    // STATIC METHODS

    public static Mat3 transpose(Mat3Readable a) {
        return new Mat3(a).transpose();
    }

    public static Mat3 flipHor(Mat3Readable a) {
        return new Mat3(a).flipHor();
    }

    public static Mat3 flipVer(Mat3Readable a) {
        return new Mat3(a).flipVer();
    }

    public static Mat3 roundElementWise(Mat3Readable a) {
        return new Mat3(a).roundElementWise();
    }

    public static Mat3 floorElementWise(Mat3Readable a, float r) {
        return new Mat3(a).floorElementWise(r);
    }

    public static Mat3 negateElementWise(Mat3Readable a) {
        return new Mat3(a).negateElementWise();
    }

    public static Mat3 toInt(Mat3Readable a) {
        return new Mat3(a).toInt();
    }

    public static Mat3 absElementWise(Mat3Readable a) {
        return new Mat3(a).absElementWise();
    }

    public static Mat3 addElementWise(Mat3Readable a, float r) {
        return new Mat3(a).addElementWise(r);
    }

    public static Mat3 subElementWise(Mat3Readable a, float r) {
        return new Mat3(a).subElementWise(r);
    }

    public static Mat3 subElementWise(float r, Mat3Readable a) {
        return new Mat3(a).presubElementWise(r);
    }

    public static Mat3 mulElementWise(Mat3Readable a, float r) {
        return new Mat3(a).mulElementWise(r);
    }

    public static Mat3 divElementWise(Mat3Readable a, float r) {
        return new Mat3(a).divElementWise(r);
    }

    public static Mat3 divElementWise(float r, Mat3Readable a) {
        return new Mat3(a).predivElementWise(r);
    }

    public static Mat3 addElementWise(Mat3Readable a, Mat3Readable b) {
        return new Mat3(a).addElementWise(b);
    }

    public static Mat3 subElementWise(Mat3Readable a, Mat3Readable b) {
        return new Mat3(a).subElementWise(b);
    }

    public static Mat3 mulElementWise(Mat3Readable a, Mat3Readable b) {
        return new Mat3(a).mulElementWise(b);
    }

    public static Mat3 divElementWise(Mat3Readable a, Mat3Readable b) {
        return new Mat3(a).divElementWise(b);
    }

    public static Mat3 mul(Mat3Readable a, Mat3Readable b) {
        return new Mat3(a).mul(b);
    }

    public static Mat3 initRot2(float angle) {
        float cosA = (float) Math.cos(Math.toRadians(-angle));
        float sinA = (float) Math.sin(Math.toRadians(-angle));
        return new Mat3(
                cosA, -sinA, 0,
                sinA, cosA, 0,
                0, 0, 1);
    }

    public static Mat3 initRot3AroundAxis(Vec3Readable axis, float angle) {
        float a = (float) Math.toRadians(angle);
        float sinA = (float) Math.sin(a);
        float cosA = (float) Math.cos(a);
        float axisX = axis.getX();
        float axisY = axis.getY();
        float axisZ = axis.getZ();

        return new Mat3(
                axisX * axisX * (1 - cosA) + cosA, axisX * axisY * (1 - cosA) - axisZ * sinA,
                axisX * axisZ * (1 - cosA) + axisY * sinA,
                axisY * axisX * (1 - cosA) + axisZ * sinA, axisY * axisY * (1 - cosA) + cosA,
                axisY * axisZ * (1 - cosA) - axisX * sinA,
                axisZ * axisX * (1 - cosA) - axisY * sinA, axisZ * axisY * (1 - cosA) + axisX * sinA,
                axisZ * axisZ * (1 - cosA) + cosA);
    }

    public static Mat3 initRot3(Vec3Readable forward, Vec3Readable up, Vec3Readable right) {
        float rX = right.getX();
        float rY = right.getY();
        float rZ = right.getZ();
        float uX = up.getX();
        float uY = up.getY();
        float uZ = up.getZ();
        float fX = forward.getX();
        float fY = forward.getY();
        float fZ = forward.getZ();
        return new Mat3(
                rX, rY, rZ,
                uX, uY, uZ,
                fX, fY, fZ);
    }

    // public static Mat3 initRot3FromQuaternion();

    public static Mat3 initTranslation2(Vec2Readable d) {
        return new Mat3(1, 0, d.getX(),
                0, 1, d.getY(),
                0, 0, 1);
    }

    public static Mat3 initScale2(Vec2Readable s) {
        return new Mat3(s.getX(), 0, 0,
                0, s.getY(), 0,
                0, 0, 1);
    }

    public static Mat3 initScale3(Vec3Readable s) {
        return new Mat3(
                s.getX(), 0, 0,
                0, s.getY(), 0,
                0, 0, s.getZ());
    }

}