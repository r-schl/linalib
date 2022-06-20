package linalib;

import java.nio.FloatBuffer;

public class Mat4 implements Mat4Readable {

    public static final Mat4Readable IDENTITY = new Mat4(
            1, 0, 0, 0,
            0, 1, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1);

    public static final Mat4Readable FLIP = new Mat4(
            0, 0, 0, 1,
            0, 0, 1, 0,
            0, 1, 0, 0,
            1, 0, 0, 0);

    public static final Mat4Readable ZEROS = new Mat4(
            0, 0, 0, 0,
            0, 0, 0, 0,
            0, 0, 0, 0,
            0, 0, 0, 0);

    public static final Mat4Readable ONES = new Mat4(
            1, 1, 1, 1,
            1, 1, 1, 1,
            1, 1, 1, 1,
            1, 1, 1, 1);

    public float m00, m01, m02, m03;
    public float m10, m11, m12, m13;
    public float m20, m21, m22, m23;
    public float m30, m31, m32, m33;

    public Mat4() {
        this(IDENTITY);
    }

    public Mat4(float m00, float m01, float m02, float m03,
            float m10, float m11, float m12, float m13,
            float m20, float m21, float m22, float m23,
            float m30, float m31, float m32, float m33) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m30 = m30;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
    }

    public Mat4(Mat4Readable other) {
        this.m00 = other.get00();
        this.m01 = other.get01();
        this.m02 = other.get02();
        this.m03 = other.get03();
        this.m10 = other.get10();
        this.m11 = other.get11();
        this.m12 = other.get12();
        this.m13 = other.get13();
        this.m20 = other.get20();
        this.m21 = other.get21();
        this.m22 = other.get22();
        this.m23 = other.get23();
        this.m30 = other.get30();
        this.m31 = other.get31();
        this.m32 = other.get32();
        this.m33 = other.get33();
    }

    @Override
    public float get00() {
        return m00;
    }

    @Override
    public float get01() {
        return m01;
    }

    @Override
    public float get02() {
        return m02;
    }

    @Override
    public float get03() {
        return m03;
    }

    @Override
    public float get10() {
        return m10;
    }

    @Override
    public float get11() {
        return m11;
    }

    @Override
    public float get12() {
        return m12;
    }

    @Override
    public float get13() {
        return m13;
    }

    @Override
    public float get20() {
        return m20;
    }

    @Override
    public float get21() {
        return m21;
    }

    @Override
    public float get22() {
        return m22;
    }

    @Override
    public float get23() {
        return m23;
    }

    @Override
    public float get30() {
        return m30;
    }

    @Override
    public float get31() {
        return m31;
    }

    @Override
    public float get32() {
        return m32;
    }

    @Override
    public float get33() {
        return m33;
    }

    @Override
    public float get(int r, int c) {
        if (r == 0 && c == 0)
            return m00;
        else if (r == 0 && c == 1)
            return m01;
        else if (r == 0 && c == 2)
            return m02;
        else if (r == 0 && c == 3)
            return m03;
        else if (r == 1 && c == 0)
            return m10;
        else if (r == 1 && c == 1)
            return m11;
        else if (r == 1 && c == 2)
            return m12;
        else if (r == 1 && c == 3)
            return m13;
        else if (r == 2 && c == 0)
            return m20;
        else if (r == 2 && c == 1)
            return m21;
        else if (r == 2 && c == 2)
            return m22;
        else if (r == 2 && c == 3)
            return m23;
        else if (r == 3 && c == 0)
            return m30;
        else if (r == 3 && c == 1)
            return m31;
        else if (r == 3 && c == 2)
            return m32;
        else if (r == 3 && c == 3)
            return m33;
        else
            throw new IllegalArgumentException("Row and/or column out of range of a 4x4 matrix.");
    }

    @Override
    public float[] getNewArr() {
        return new float[] {
                m00, m01, m02, m03,
                m10, m11, m12, m13,
                m20, m21, m22, m23,
                m30, m31, m32, m33
        };
    }

    @Override
    public float[][] getNewArr2() {
        return new float[][] {
                { m00, m01, m02, m03 },
                { m10, m11, m12, m13 },
                { m20, m21, m22, m23 },
                { m30, m31, m32, m33 }
        };
    }

    @Override
    public void storeInBuffer(FloatBuffer buf) {
        buf.put(m00);
        buf.put(m01);
        buf.put(m02);
        buf.put(m03);
        buf.put(m10);
        buf.put(m11);
        buf.put(m12);
        buf.put(m13);
        buf.put(m20);
        buf.put(m21);
        buf.put(m22);
        buf.put(m23);
        buf.put(m30);
        buf.put(m31);
        buf.put(m32);
        buf.put(m33);
    }

    // SETTERS

    public Mat4 transpose() {
        float tm01 = m01;
        m01 = m10;
        float tm02 = m02;
        m02 = m20;
        float tm03 = m03;
        m03 = m30;
        m10 = tm01;
        float tm12 = m12;
        m12 = m21;
        float tm13 = m13;
        m13 = m31;
        m20 = tm02;
        m21 = tm12;
        float tm23 = m23;
        m23 = m32;
        m30 = tm03;
        m31 = tm13;
        m32 = tm23;
        return this;
    }

    public Mat4 flipHor() {
        return this.mul(Mat4.FLIP);
    }

    public Mat4 flipVer() {
        return this.premul(Mat4.FLIP);
    }

    public Mat4 set(int r, int c, float val) {
        if (r == 0 && c == 0)
            this.m00 = val;
        else if (r == 0 && c == 1)
            this.m01 = val;
        else if (r == 0 && c == 2)
            this.m02 = val;
        else if (r == 0 && c == 3)
            this.m03 = val;
        else if (r == 1 && c == 0)
            this.m10 = val;
        else if (r == 1 && c == 1)
            this.m11 = val;
        else if (r == 1 && c == 2)
            this.m12 = val;
        else if (r == 1 && c == 3)
            this.m13 = val;
        else if (r == 2 && c == 0)
            this.m20 = val;
        else if (r == 2 && c == 1)
            this.m21 = val;
        else if (r == 2 && c == 2)
            this.m22 = val;
        else if (r == 2 && c == 3)
            this.m23 = val;
        else if (r == 3 && c == 0)
            this.m30 = val;
        else if (r == 3 && c == 1)
            this.m31 = val;
        else if (r == 3 && c == 2)
            this.m32 = val;
        else if (r == 3 && c == 3)
            this.m33 = val;
        else
            throw new IllegalArgumentException("Row and/or column out of range of a 4x4 matrix.");
        return this;
    }

    public Mat4 roundElementWise() {
        this.m00 = Math.round(this.m00);
        this.m01 = Math.round(this.m01);
        this.m02 = Math.round(this.m02);
        this.m03 = Math.round(this.m03);
        this.m10 = Math.round(this.m10);
        this.m11 = Math.round(this.m11);
        this.m12 = Math.round(this.m12);
        this.m13 = Math.round(this.m13);
        this.m20 = Math.round(this.m20);
        this.m21 = Math.round(this.m21);
        this.m22 = Math.round(this.m22);
        this.m23 = Math.round(this.m23);
        this.m30 = Math.round(this.m30);
        this.m31 = Math.round(this.m31);
        this.m32 = Math.round(this.m32);
        this.m33 = Math.round(this.m33);
        return this;
    }

    public Mat4 floorElementWise(float r) {
        this.m00 = (this.m00 - (this.m00 % r));
        this.m01 = (this.m01 - (this.m00 % r));
        this.m02 = (this.m02 - (this.m00 % r));
        this.m03 = (this.m03 - (this.m00 % r));
        this.m10 = (this.m10 - (this.m00 % r));
        this.m11 = (this.m11 - (this.m00 % r));
        this.m12 = (this.m12 - (this.m00 % r));
        this.m13 = (this.m13 - (this.m00 % r));
        this.m20 = (this.m20 - (this.m00 % r));
        this.m21 = (this.m21 - (this.m00 % r));
        this.m22 = (this.m22 - (this.m00 % r));
        this.m23 = (this.m23 - (this.m00 % r));
        this.m30 = (this.m30 - (this.m00 % r));
        this.m31 = (this.m31 - (this.m00 % r));
        this.m32 = (this.m32 - (this.m00 % r));
        this.m33 = (this.m33 - (this.m00 % r));
        return this;
    }

    public Mat4 negateElementWise() {
        this.m00 = -this.m00;
        this.m01 = -this.m01;
        this.m02 = -this.m02;
        this.m03 = -this.m03;
        this.m10 = -this.m10;
        this.m11 = -this.m11;
        this.m12 = -this.m12;
        this.m13 = -this.m13;
        this.m20 = -this.m20;
        this.m21 = -this.m21;
        this.m22 = -this.m22;
        this.m23 = -this.m23;
        this.m30 = -this.m30;
        this.m31 = -this.m31;
        this.m32 = -this.m32;
        this.m33 = -this.m33;
        return this;
    }

    public Mat4 toInt() {
        this.m00 = (int) m00;
        this.m01 = (int) m01;
        this.m02 = (int) m02;
        this.m03 = (int) m03;
        this.m10 = (int) m10;
        this.m11 = (int) m11;
        this.m12 = (int) m12;
        this.m13 = (int) m13;
        this.m20 = (int) m20;
        this.m21 = (int) m21;
        this.m22 = (int) m22;
        this.m23 = (int) m23;
        this.m30 = (int) m30;
        this.m31 = (int) m31;
        this.m32 = (int) m32;
        this.m33 = (int) m33;
        return this;
    }

    public Mat4 absElementWise() {
        this.m00 = Math.abs(m00);
        this.m01 = Math.abs(m01);
        this.m02 = Math.abs(m02);
        this.m03 = Math.abs(m03);
        this.m10 = Math.abs(m10);
        this.m11 = Math.abs(m11);
        this.m12 = Math.abs(m12);
        this.m13 = Math.abs(m13);
        this.m20 = Math.abs(m20);
        this.m21 = Math.abs(m21);
        this.m22 = Math.abs(m22);
        this.m23 = Math.abs(m23);
        this.m30 = Math.abs(m30);
        this.m31 = Math.abs(m31);
        this.m32 = Math.abs(m32);
        this.m33 = Math.abs(m33);
        return this;
    }

    public Mat4 addElementWise(float r) {
        this.m00 = this.m00 + r;
        this.m01 = this.m01 + r;
        this.m02 = this.m02 + r;
        this.m03 = this.m03 + r;
        this.m10 = this.m10 + r;
        this.m11 = this.m11 + r;
        this.m12 = this.m12 + r;
        this.m13 = this.m13 + r;
        this.m20 = this.m20 + r;
        this.m21 = this.m21 + r;
        this.m22 = this.m22 + r;
        this.m23 = this.m23 + r;
        this.m30 = this.m30 + r;
        this.m31 = this.m31 + r;
        this.m32 = this.m32 + r;
        this.m33 = this.m33 + r;
        return this;
    }

    public Mat4 subElementWise(float r) {
        this.m00 = this.m00 - r;
        this.m01 = this.m01 - r;
        this.m02 = this.m02 - r;
        this.m03 = this.m03 - r;
        this.m10 = this.m10 - r;
        this.m11 = this.m11 - r;
        this.m12 = this.m12 - r;
        this.m13 = this.m13 - r;
        this.m20 = this.m20 - r;
        this.m21 = this.m21 - r;
        this.m22 = this.m22 - r;
        this.m23 = this.m23 - r;
        this.m30 = this.m30 - r;
        this.m31 = this.m31 - r;
        this.m32 = this.m32 - r;
        this.m33 = this.m33 - r;
        return this;
    }

    public Mat4 presubElementWise(float r) {
        this.m00 = r - this.m00;
        this.m01 = r - this.m01;
        this.m02 = r - this.m02;
        this.m03 = r - this.m03;
        this.m10 = r - this.m10;
        this.m11 = r - this.m11;
        this.m12 = r - this.m12;
        this.m13 = r - this.m13;
        this.m20 = r - this.m20;
        this.m21 = r - this.m21;
        this.m22 = r - this.m22;
        this.m23 = r - this.m23;
        this.m30 = r - this.m30;
        this.m31 = r - this.m31;
        this.m32 = r - this.m32;
        this.m33 = r - this.m33;
        return this;
    }

    public Mat4 mulElementWise(float r) {
        this.m00 = this.m00 * r;
        this.m01 = this.m01 * r;
        this.m02 = this.m02 * r;
        this.m03 = this.m03 * r;
        this.m10 = this.m10 * r;
        this.m11 = this.m11 * r;
        this.m12 = this.m12 * r;
        this.m13 = this.m13 * r;
        this.m20 = this.m20 * r;
        this.m21 = this.m21 * r;
        this.m22 = this.m22 * r;
        this.m23 = this.m23 * r;
        this.m30 = this.m30 * r;
        this.m31 = this.m31 * r;
        this.m32 = this.m32 * r;
        this.m33 = this.m33 * r;
        return this;
    }

    public Mat4 divElementWise(float r) {
        this.m00 = this.m00 / r;
        this.m01 = this.m01 / r;
        this.m02 = this.m02 / r;
        this.m03 = this.m03 / r;
        this.m10 = this.m10 / r;
        this.m11 = this.m11 / r;
        this.m12 = this.m12 / r;
        this.m13 = this.m13 / r;
        this.m20 = this.m20 / r;
        this.m21 = this.m21 / r;
        this.m22 = this.m22 / r;
        this.m23 = this.m23 / r;
        this.m30 = this.m30 / r;
        this.m31 = this.m31 / r;
        this.m32 = this.m32 / r;
        this.m33 = this.m33 / r;
        return this;
    }

    public Mat4 predivElementWise(float r) {
        this.m00 = r - this.m00;
        this.m01 = r - this.m01;
        this.m02 = r - this.m02;
        this.m03 = r - this.m03;
        this.m10 = r - this.m10;
        this.m11 = r - this.m11;
        this.m12 = r - this.m12;
        this.m13 = r - this.m13;
        this.m20 = r - this.m20;
        this.m21 = r - this.m21;
        this.m22 = r - this.m22;
        this.m23 = r - this.m23;
        this.m30 = r - this.m30;
        this.m31 = r - this.m31;
        this.m32 = r - this.m32;
        this.m33 = r - this.m33;
        return this;
    }

    public Mat4 set(Mat4Readable mat) {
        this.m00 = mat.get00();
        this.m01 = mat.get01();
        this.m02 = mat.get02();
        this.m03 = mat.get03();
        this.m10 = mat.get10();
        this.m11 = mat.get11();
        this.m12 = mat.get12();
        this.m13 = mat.get13();
        this.m20 = mat.get20();
        this.m21 = mat.get21();
        this.m22 = mat.get22();
        this.m23 = mat.get23();
        this.m30 = mat.get30();
        this.m31 = mat.get31();
        this.m32 = mat.get32();
        this.m33 = mat.get33();
        return this;
    }

    public Mat4 set(float m00, float m01, float m02, float m03,
            float m10, float m11, float m12, float m13,
            float m20, float m21, float m22, float m23,
            float m30, float m31, float m32, float m33) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m30 = m30;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        return this;
    }

    public Mat4 addElementWise(Mat4Readable mat) {
        this.m00 = this.m00 + mat.get00();
        this.m01 = this.m01 + mat.get01();
        this.m02 = this.m02 + mat.get02();
        this.m03 = this.m03 + mat.get03();
        this.m10 = this.m10 + mat.get10();
        this.m11 = this.m11 + mat.get11();
        this.m12 = this.m12 + mat.get12();
        this.m13 = this.m13 + mat.get13();
        this.m20 = this.m20 + mat.get20();
        this.m21 = this.m21 + mat.get21();
        this.m22 = this.m22 + mat.get22();
        this.m23 = this.m23 + mat.get23();
        this.m30 = this.m30 + mat.get30();
        this.m31 = this.m31 + mat.get31();
        this.m32 = this.m32 + mat.get32();
        this.m33 = this.m33 + mat.get33();
        return this;
    }

    public Mat4 subElementWise(Mat4Readable mat) {
        this.m00 = this.m00 - mat.get00();
        this.m01 = this.m01 - mat.get01();
        this.m02 = this.m02 - mat.get02();
        this.m03 = this.m03 - mat.get03();
        this.m10 = this.m10 - mat.get10();
        this.m11 = this.m11 - mat.get11();
        this.m12 = this.m12 - mat.get12();
        this.m13 = this.m13 - mat.get13();
        this.m20 = this.m20 - mat.get20();
        this.m21 = this.m21 - mat.get21();
        this.m22 = this.m22 - mat.get22();
        this.m23 = this.m23 - mat.get23();
        this.m30 = this.m30 - mat.get30();
        this.m31 = this.m31 - mat.get31();
        this.m32 = this.m32 - mat.get32();
        this.m33 = this.m33 - mat.get33();
        return this;
    }

    public Mat4 presubElementWise(Mat4Readable mat) {
        this.m00 = mat.get00() - this.m00;
        this.m01 = mat.get01() - this.m01;
        this.m02 = mat.get02() - this.m02;
        this.m03 = mat.get03() - this.m03;
        this.m10 = mat.get10() - this.m10;
        this.m11 = mat.get11() - this.m11;
        this.m12 = mat.get12() - this.m12;
        this.m13 = mat.get13() - this.m13;
        this.m20 = mat.get20() - this.m20;
        this.m21 = mat.get21() - this.m21;
        this.m22 = mat.get22() - this.m22;
        this.m23 = mat.get23() - this.m23;
        this.m30 = mat.get30() - this.m30;
        this.m31 = mat.get31() - this.m31;
        this.m32 = mat.get32() - this.m32;
        this.m33 = mat.get33() - this.m33;
        return this;
    }

    public Mat4 mulElementWise(Mat4Readable mat) {
        this.m00 = this.m00 * mat.get00();
        this.m01 = this.m01 * mat.get01();
        this.m02 = this.m02 * mat.get02();
        this.m03 = this.m03 * mat.get03();
        this.m10 = this.m10 * mat.get10();
        this.m11 = this.m11 * mat.get11();
        this.m12 = this.m12 * mat.get12();
        this.m13 = this.m13 * mat.get13();
        this.m20 = this.m20 * mat.get20();
        this.m21 = this.m21 * mat.get21();
        this.m22 = this.m22 * mat.get22();
        this.m23 = this.m23 * mat.get23();
        this.m30 = this.m30 * mat.get30();
        this.m31 = this.m31 * mat.get31();
        this.m32 = this.m32 * mat.get32();
        this.m33 = this.m33 * mat.get33();
        return this;
    }

    public Mat4 divElementWise(Mat4Readable mat) {
        this.m00 = this.m00 / mat.get00();
        this.m01 = this.m01 / mat.get01();
        this.m02 = this.m02 / mat.get02();
        this.m03 = this.m03 / mat.get03();
        this.m10 = this.m10 / mat.get10();
        this.m11 = this.m11 / mat.get11();
        this.m12 = this.m12 / mat.get12();
        this.m13 = this.m13 / mat.get13();
        this.m20 = this.m20 / mat.get20();
        this.m21 = this.m21 / mat.get21();
        this.m22 = this.m22 / mat.get22();
        this.m23 = this.m23 / mat.get23();
        this.m30 = this.m30 / mat.get30();
        this.m31 = this.m31 / mat.get31();
        this.m32 = this.m32 / mat.get32();
        this.m33 = this.m33 / mat.get33();
        return this;
    }

    public Mat4 predivElementWise(Mat4Readable mat) {
        this.m00 = mat.get00() / this.m00;
        this.m01 = mat.get01() / this.m01;
        this.m02 = mat.get02() / this.m02;
        this.m03 = mat.get03() / this.m03;
        this.m10 = mat.get10() / this.m10;
        this.m11 = mat.get11() / this.m11;
        this.m12 = mat.get12() / this.m12;
        this.m13 = mat.get13() / this.m13;
        this.m20 = mat.get20() / this.m20;
        this.m21 = mat.get21() / this.m21;
        this.m22 = mat.get22() / this.m22;
        this.m23 = mat.get23() / this.m23;
        this.m30 = mat.get30() / this.m30;
        this.m31 = mat.get31() / this.m31;
        this.m32 = mat.get32() / this.m32;
        this.m33 = mat.get33() / this.m33;
        return this;
    }

    public Mat4 mul(Mat4Readable mat) {
        // row 1
        float m00 = this.m00 * mat.get00() + this.m01 * mat.get10() + this.m02 * mat.get20() + this.m03 * mat.get30();
        float m01 = this.m00 * mat.get01() + this.m01 * mat.get11() + this.m02 * mat.get21() + this.m03 * mat.get31();
        float m02 = this.m00 * mat.get02() + this.m01 * mat.get12() + this.m02 * mat.get22() + this.m03 * mat.get32();
        float m03 = this.m00 * mat.get03() + this.m01 * mat.get13() + this.m02 * mat.get23() + this.m03 * mat.get33();
        // row 2
        float m10 = this.m10 * mat.get00() + this.m11 * mat.get10() + this.m12 * mat.get20() + this.m13 * mat.get30();
        float m11 = this.m10 * mat.get01() + this.m11 * mat.get11() + this.m12 * mat.get21() + this.m13 * mat.get31();
        float m12 = this.m10 * mat.get02() + this.m11 * mat.get12() + this.m12 * mat.get22() + this.m13 * mat.get32();
        float m13 = this.m10 * mat.get03() + this.m11 * mat.get13() + this.m12 * mat.get23() + this.m13 * mat.get33();
        // row 3
        float m20 = this.m20 * mat.get00() + this.m21 * mat.get10() + this.m22 * mat.get20() + this.m23 * mat.get30();
        float m21 = this.m20 * mat.get01() + this.m21 * mat.get11() + this.m22 * mat.get21() + this.m23 * mat.get31();
        float m22 = this.m20 * mat.get02() + this.m21 * mat.get12() + this.m22 * mat.get22() + this.m23 * mat.get32();
        float m23 = this.m20 * mat.get03() + this.m21 * mat.get13() + this.m22 * mat.get23() + this.m23 * mat.get33();
        // row 4
        float m30 = this.m30 * mat.get00() + this.m31 * mat.get10() + this.m32 * mat.get20() + this.m33 * mat.get30();
        float m31 = this.m30 * mat.get01() + this.m31 * mat.get11() + this.m32 * mat.get21() + this.m33 * mat.get31();
        float m32 = this.m30 * mat.get02() + this.m31 * mat.get12() + this.m32 * mat.get22() + this.m33 * mat.get32();
        float m33 = this.m30 * mat.get03() + this.m31 * mat.get13() + this.m32 * mat.get23() + this.m33 * mat.get33();
        // set values
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m30 = m30;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        return this;
    }

    public Mat4 premul(Mat4Readable mat) {
        // row 1
        float m00 = mat.get00() * this.m00 + mat.get01() * this.m10 + mat.get02() * this.m20 + mat.get03() * this.m30;
        float m01 = mat.get00() * this.m01 + mat.get01() * this.m11 + mat.get02() * this.m21 + mat.get03() * this.m31;
        float m02 = mat.get00() * this.m02 + mat.get01() * this.m12 + mat.get02() * this.m22 + mat.get03() * this.m32;
        float m03 = mat.get00() * this.m03 + mat.get01() * this.m13 + mat.get02() * this.m23 + mat.get03() * this.m33;
        // row 2
        float m10 = mat.get10() * this.m00 + mat.get11() * this.m10 + mat.get12() * this.m20 + mat.get13() * this.m30;
        float m11 = mat.get10() * this.m01 + mat.get11() * this.m11 + mat.get12() * this.m21 + mat.get13() * this.m31;
        float m12 = mat.get10() * this.m02 + mat.get11() * this.m12 + mat.get12() * this.m22 + mat.get13() * this.m32;
        float m13 = mat.get10() * this.m03 + mat.get11() * this.m13 + mat.get12() * this.m23 + mat.get13() * this.m33;
        // row 3
        float m20 = mat.get20() * this.m00 + mat.get21() * this.m10 + mat.get22() * this.m20 + mat.get23() * this.m30;
        float m21 = mat.get20() * this.m01 + mat.get21() * this.m11 + mat.get22() * this.m21 + mat.get23() * this.m31;
        float m22 = mat.get20() * this.m02 + mat.get21() * this.m12 + mat.get22() * this.m22 + mat.get23() * this.m32;
        float m23 = mat.get20() * this.m03 + mat.get21() * this.m13 + mat.get22() * this.m23 + mat.get23() * this.m33;
        // row 4
        float m30 = mat.get30() * this.m00 + mat.get31() * this.m10 + mat.get32() * this.m20 + mat.get33() * this.m30;
        float m31 = mat.get30() * this.m01 + mat.get31() * this.m11 + mat.get32() * this.m21 + mat.get33() * this.m31;
        float m32 = mat.get30() * this.m02 + mat.get31() * this.m12 + mat.get32() * this.m22 + mat.get33() * this.m32;
        float m33 = mat.get30() * this.m03 + mat.get31() * this.m13 + mat.get32() * this.m23 + mat.get33() * this.m33;
        // set values
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m30 = m30;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        return this;
    }

    @Override
    public String toString() {
        float[] arr = this.getNewArr();

        float max = arr[0];
        for (int i = 0; i < 16; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxNumDigits = String.valueOf(max).length();

        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int numLength = String.valueOf(arr[row * 4 + col]).length();
                for (int i = 0; i < maxNumDigits - numLength; i++) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(arr[row * 4 + col] + " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    // STATIC METHODS

    public static Mat4 transpose(Mat4Readable a) {
        return new Mat4(a).transpose();
    }

    public static Mat4 flipHor(Mat4Readable a) {
        return new Mat4(a).flipHor();
    }

    public static Mat4 flipVer(Mat4Readable a) {
        return new Mat4(a).flipHor();
    }

    public static Mat4 roundElementWise(Mat4Readable a) {
        return new Mat4(a).roundElementWise();
    }

    public static Mat4 floorElementWise(Mat4Readable a, float r) {
        return new Mat4(a).floorElementWise(r);
    }

    public static Mat4 negateElementWise(Mat4Readable a) {
        return new Mat4(a).negateElementWise();
    }

    public static Mat4 toInt(Mat4Readable a) {
        return new Mat4(a).toInt();
    }

    public static Mat4 absElementWise(Mat4Readable a) {
        return new Mat4(a).absElementWise();
    }

    public static Mat4 addElementWise(Mat4Readable a, float r) {
        return new Mat4(a).addElementWise(r);
    }

    public static Mat4 subElementWise(Mat4Readable a, float r) {
        return new Mat4(a).subElementWise(r);
    }

    public static Mat4 subElementWise(float r, Mat4Readable a) {
        return new Mat4(a).presubElementWise(r);
    }

    public static Mat4 mulElementWise(Mat4Readable a, float r) {
        return new Mat4(a).mulElementWise(r);
    }

    public static Mat4 divElementWise(Mat4Readable a, float r) {
        return new Mat4(a).divElementWise(r);
    }

    public static Mat4 divElementWise(float r, Mat4Readable a) {
        return new Mat4(a).predivElementWise(r);
    }

    public static Mat4 addElementWise(Mat4Readable a, Mat4Readable b) {
        return new Mat4(a).addElementWise(b);
    }

    public static Mat4 subElementWise(Mat4Readable a, Mat4Readable b) {
        return new Mat4(a).subElementWise(b);
    }

    public static Mat4 mulElementWise(Mat4Readable a, Mat4Readable b) {
        return new Mat4(a).mulElementWise(b);
    }

    public static Mat4 divElementWise(Mat4Readable a, Mat4Readable b) {
        return new Mat4(a).divElementWise(b);
    }

    public static Mat4 mul(Mat4Readable a, Mat4Readable b) {
        return new Mat4(a).mul(b);
    }

    public static Mat4 initRot3AroundAxis(Vec3Readable axis, float angle) {
        float a = (float) Math.toRadians(angle);
        float sinA = (float) Math.sin(a);
        float cosA = (float) Math.cos(a);
        float axisX = axis.getX();
        float axisY = axis.getY();
        float axisZ = axis.getZ();

        return new Mat4(
                axisX * axisX * (1 - cosA) + cosA, axisX * axisY * (1 - cosA) - axisZ * sinA,
                axisX * axisZ * (1 - cosA) + axisY * sinA, 0,
                axisY * axisX * (1 - cosA) + axisZ * sinA, axisY * axisY * (1 - cosA) + cosA,
                axisY * axisZ * (1 - cosA) - axisX * sinA, 0,
                axisZ * axisX * (1 - cosA) - axisY * sinA, axisZ * axisY * (1 - cosA) + axisX * sinA,
                axisZ * axisZ * (1 - cosA) + cosA, 0,
                0, 0, 0, 1);
    }

    public static Mat4 initRot3(Vec3Readable forward, Vec3Readable up, Vec3Readable right) {
        float rX = right.getX();
        float rY = right.getY();
        float rZ = right.getZ();
        float uX = up.getX();
        float uY = up.getY();
        float uZ = up.getZ();
        float fX = forward.getX();
        float fY = forward.getY();
        float fZ = forward.getZ();
        return new Mat4(
                rX, rY, rZ, 0,
                uX, uY, uZ, 0,
                fX, fY, fZ, 0,
                0, 0, 0, 1);
    }

    public static Mat4 initRot3FromQuaternion(QuaternionReadable q) {
        // normalize the quaternion
        float len = (float) Math
                .sqrt(q.getW() * q.getW() + q.getX() * q.getX() + q.getY() * q.getY() + q.getZ() * q.getZ());
        float w = q.getW() / len;
        float x = -q.getX() / len;
        float y = -q.getY() / len;
        float z = -q.getZ() / len;

        return new Mat4(
                (1.0f - (2.0f * ((y * y) + (z * z)))), (2.0f * ((x * y) - (z * w))),
                (float) (2.0f * ((x * z) + (y * w))), 0,
                (2.0f * ((x * y) + (z * w))), (1.0f - (2.0f * ((x * x) + (z * z)))),
                (float) (2.0f * ((y * z) - (x * w))), 0,
                -(float) (2.0f * ((x * z) - (y * w))), -(float) (2.0f * ((y * z) + (x * w))),
                -(float) (1.0f - (2.0f * ((x * x) + (y * y)))), 0,
                0, 0, 0, 1);
    }

    public static Mat4 initTranslation2(Vec2Readable d) {
        return new Mat4(
                1, 0, 0, d.getX(),
                0, 1, 0, d.getY(),
                0, 0, 1, 0,
                0, 0, 0, 1);
    }

    /**
     * This method creates a translation matrix so that a vector v can be translated
     * by multiplying this matrix by v.
     * M * v = v'
     * 
     * @param d
     * @return
     */
    public static Mat4 initTranslation3(Vec3Readable d) {
        return new Mat4(
                1, 0, 0, d.getX(),
                0, 1, 0, d.getY(),
                0, 0, 1, d.getZ(),
                0, 0, 0, 1);
    }

    public static Mat4 initScale2(Vec2Readable s) {
        return new Mat4(
                s.getX(), 0, 0, 0,
                0, s.getY(), 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1);
    }

    public static Mat4 initScale3(Vec3Readable s) {
        return new Mat4(
                s.getX(), 0, 0, 0,
                0, s.getY(), 0, 0,
                0, 0, s.getZ(), 0,
                0, 0, 0, 1);
    }

    public static Mat4 initScale4(Vec4Readable s) {
        return new Mat4(
                s.getX(), 0, 0, 0,
                0, s.getY(), 0, 0,
                0, 0, s.getZ(), 0,
                0, 0, 0, s.getW());
    }

    public static Mat4 initLookAt3(Vec3Readable pos, Vec3Readable tgt, Vec3Readable up) {
        Vec3 zAxis = new Vec3(tgt).sub(pos).normalize();
        Vec3 xAxis = new Vec3(up).cross(zAxis).normalize();
        Vec3 yAxis = new Vec3(zAxis).cross(xAxis);

        return new Mat4(
                xAxis.x, yAxis.x, zAxis.x, -pos.getX(),
                xAxis.y, yAxis.y, zAxis.y, -pos.getY(),
                xAxis.z, yAxis.z, zAxis.z, -pos.getZ(),
                0, 0, 0, 1);
    }

    public static Mat4 initView3FromQuaternion(Vec3Readable position, QuaternionReadable q) {
        return Mat4.initRot3FromQuaternion(q).mul(new Mat4(
                1, 0, 0, -position.getX(),
                0, 1, 0, -position.getY(),
                0, 0, 1, -position.getZ(),
                0, 0, 0, 1));
    }

    /**
     * This method created a perspective projection matrix given by 6 clipping
     * planes.
     * 
     * @param left   left clipping plane
     * @param right  right clipping plane
     * @param bottom bottom clipping plane
     * @param top    top clipping plane
     * @param near   near clipping plane
     * @param far    far clipping plane
     * @return perspective projection matrix
     */
    public static Mat4 initPerspective3(float left, float right, float bottom, float top, float near, float far) {
        float l = left;
        float r = right;
        float b = bottom;
        float t = top;
        float n = near;
        float f = far;
        return new Mat4(
                (2 * n) / (r - l), 0, (r + l) / (r - l), 0,
                0, (2 * n) / (t - b), (t + b) / (t - b), 0,
                0, 0, -(f + n) / (f - n), -(2 * f * n) / (f - n),
                0, 0, -1, 0);
    }

    /**
     * Multiplies this matrix with a perspective projection matrix given by the
     * aspect ratio,
     * near and far clipping plane and the field of view.
     * 
     * @param aspect aspect ratio of the window
     * @param near   near clipping plane
     * @param far    far clipping plane
     * @param fovY   field of view y axis (in degrees)
     * @return this matrix
     */
    public static Mat4 initPerspective3FoV(float aspect, float near, float far, float fovY) {
        float tanHalfFov = (float) Math.tan(Math.toRadians(fovY / 2.0));
        float pWidth = (2 * near) / (1 / tanHalfFov);
        float pHeight = (2 * near) / (1 / tanHalfFov * aspect);
        float right = pWidth / 2;
        float left = -pWidth / 2;
        float top = pHeight / 2;
        float bottom = -pHeight / 2;
        return initPerspective3(left, right, bottom, top, near, far);
    }

    public static Mat4 initOrthographic3(float left, float right, float bottom, float top, float near, float far) {
        float l = left;
        float r = right;
        float b = bottom;
        float t = top;
        float n = near;
        float f = far;
        return new Mat4(
                2 / (r - l), 0, 0, 0,
                0, 2 / (t - b), 0, 0,
                0, 0, (-2) / (f - n), 0,
                -(r + l) / (r - l), -(t + b) / (t - b), -(f + n) / (f - n), 1);
    }

    public static Mat4 initOblique3(float left, float right, float bottom, float top, float near, float far,
            float alpha, float beta) {
        float cosA = (float) Math.cos(Math.toRadians(alpha));
        float sinA = (float) Math.sin(Math.toRadians(alpha));
        float tanB = (float) Math.tan(Math.toRadians(beta));
        float sinB = (float) Math.sin(Math.toRadians(beta));
        return initOrthographic3(left, right, bottom, top, near, far).mul(
                new Mat4(
                        1, 0, -cosA / tanB, 0,
                        0, 1, sinA / tanB, 0,
                        0, 0, -1 / sinB, 0,
                        0, 0, 0, 1));
    }

    public static Mat4 initCabinet3(float left, float right, float bottom, float top, float near, float far,
            float angle) {
        return initOblique3(left, right, bottom, top, near, far, angle, (float) Math.toDegrees(Math.atan(2)));
    }

    public static Mat4 initCavalier3(float left, float right, float bottom, float top, float near, float far,
            float angle) {
        return initOblique3(left, right, bottom, top, near, far, angle, (float) Math.toDegrees(Math.atan(1)));
    }

}
