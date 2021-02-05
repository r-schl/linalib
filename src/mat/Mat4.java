package mat;

import java.nio.FloatBuffer;

import quat.QuatReadable;
import vec.Vec2Readable;
import vec.Vec3;
import vec.Vec3Readable;
import vec.Vec4Readable;

public class Mat4 implements Mat4Writable {

    public static final Mat4Readable IDENTITY = new Mat4(
        1, 0, 0, 0,
        0, 1, 0, 0,
        0, 0, 1, 0,
        0, 0, 0, 1
    );

    public static final Mat4Readable FLIP = new Mat4(
        0, 0, 0, 1,
        0, 0, 1, 0,
        0, 1, 0, 0,
        1, 0, 0, 0
    );

    public static final Mat4Readable ZEROS = new Mat4(
        0, 0, 0, 0,
        0, 0, 0, 0,
        0, 0, 0, 0,
        0, 0, 0, 0
    );

    public static final Mat4Readable ONES = new Mat4(
        1, 1, 1, 1,
        1, 1, 1, 1,
        1, 1, 1, 1,
        1, 1, 1, 1
    );

    public float m00, m01, m02, m03;
    public float m10, m11, m12, m13;
    public float m20, m21, m22, m23;
    public float m30, m31, m32, m33;

    private final int rowCount = 4;
    private final int colCount = 4;

    public Mat4() {
        this.set(IDENTITY);
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
    public int rowCount() {
        return rowCount;
    }

    @Override
    public int colCount() {
        return colCount;
    }

    @Override
    public float get(int r, int c) {
        if (r == 0 && c == 0) return m00;
        else if (r == 0 && c == 1) return m01;
        else if (r == 0 && c == 2) return m02;
        else if (r == 0 && c == 3) return m03;
        else if (r == 1 && c == 0) return m10;
        else if (r == 1 && c == 1) return m11;
        else if (r == 1 && c == 2) return m12;
        else if (r == 1 && c == 3) return m13;
        else if (r == 2 && c == 0) return m20;
        else if (r == 2 && c == 1) return m21;
        else if (r == 2 && c == 2) return m22;
        else if (r == 2 && c == 3) return m23;
        else if (r == 3 && c == 0) return m30;
        else if (r == 3 && c == 1) return m31;
        else if (r == 3 && c == 2) return m32;
        else if (r == 3 && c == 3) return m33;
        else throw new IllegalArgumentException("Row and/or column out of range " + rowCount() + "x" +  colCount() + ". " + r + " " + c);
    }

    @Override
    public float[] newArr() {
        return new float[] {
            m00, m01, m02, m03,
            m10, m11, m12, m13,
            m20, m21, m22, m23,
            m30, m31, m32, m33
        };
    }

    @Override
    public float[][] newArr2() {
        return new float[][]{
            {m00, m01, m02, m03},
            {m10, m11, m12, m13},
            {m20, m21, m22, m23},
            {m30, m31, m32, m33}
        };
    }

    @Override
    public Mat4 storeInside(FloatBuffer buf) {
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
        return this;
    }

    @Override
    public Mat4 to(MatWritable mat) {
        this.extractTo(mat);
        return this;
    }

    @Override
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

    @Override
    public Mat4 flipHor() {
        return this.mul(Mat4.FLIP);
    }

    @Override
    public Mat4 flipVer() {
        return this.premul(Mat4.FLIP);
    }

    @Override
    public Mat4 set(int r, int c, float val) {
        if (r == 0 && c == 0) this.m00 = val;
        else if (r == 0 && c == 1) this.m01 = val;
        else if (r == 0 && c == 2) this.m02 = val;
        else if (r == 0 && c == 3) this.m03 = val;
        else if (r == 1 && c == 0) this.m10 = val;
        else if (r == 1 && c == 1) this.m11 = val;
        else if (r == 1 && c == 2) this.m12 = val;
        else if (r == 1 && c == 3) this.m13 = val;
        else if (r == 2 && c == 0) this.m20 = val;
        else if (r == 2 && c == 1) this.m21 = val;
        else if (r == 2 && c == 2) this.m22 = val;
        else if (r == 2 && c == 3) this.m23 = val;
        else if (r == 3 && c == 0) this.m30 = val;
        else if (r == 3 && c == 1) this.m31 = val;
        else if (r == 3 && c == 2) this.m32 = val;
        else if (r == 3 && c == 3) this.m33 = val;
        else throw new IllegalArgumentException("Row and/or column out of range " + rowCount() + "x" +  colCount() + ". " + r + " " + c);
        return this;
    } 

    @Override
    public Mat4 roundElWise() {
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

    @Override
    public Mat4 floorElWise(float r) {       
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

    @Override
    public Mat4 negateElWise() {
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

    @Override
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

    @Override
    public Mat4 absElWise() {
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

    @Override
    public Mat4 addElWise(float r) {
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

    @Override
    public Mat4 subElWise(float r) {
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

    @Override
    public Mat4 presubElWise(float r) {
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

    @Override
    public Mat4 mulElWise(float r) {
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

    @Override
    public Mat4 divElWise(float r) {
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

    @Override
    public Mat4 predivElWise(float r) {
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

    @Override
    public Mat4 from(MatReadable mat) {
        this.extractFrom(mat);
        return this;
    }

    @Override
    public Mat4 set00(float val) {
        this.m00 = val;
        return this;
    }

    @Override
    public Mat4 set01(float val) {
        this.m01 = val;
        return this;
    }

    @Override
    public Mat4 set02(float val) {
        this.m02 = val;
        return this;
    }

    @Override
    public Mat4 set03(float val) {
        this.m03 = val;
        return this;
    }

    @Override
    public Mat4 set10(float val) {
        this.m10 = val;
        return this;
    }

    @Override
    public Mat4 set11(float val) {
        this.m11 = val;
        return this;
    }

    @Override
    public Mat4 set12(float val) {
        this.m12 = val;
        return this;
    }

    @Override
    public Mat4 set13(float val) {
        this.m13 = val;
        return this;
    }

    @Override
    public Mat4 set20(float val) {
        this.m20 = val;
        return this;
    }

    @Override
    public Mat4 set21(float val) {
        this.m21 = val;
        return this;
    }

    @Override
    public Mat4 set22(float val) {
        this.m22 = val;
        return this;
    }

    @Override
    public Mat4 set23(float val) {
        this.m23 = val;
        return this;
    }

    @Override
    public Mat4 set30(float val) {
        this.m30 = val;
        return this;
    }

    @Override
    public Mat4 set31(float val) {
        this.m31 = val;
        return this;
    }

    @Override
    public Mat4 set32(float val) {
        this.m32 = val;
        return this;
    }

    @Override
    public Mat4 set33(float val) {
        this.m33 = val;
        return this;
    }

    @Override
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

    @Override
    public Mat4 set(float mat00, float mat01, float mat02, float mat03,
    float mat10, float mat11, float mat12, float mat13,
    float mat20, float mat21, float mat22, float mat23,
    float mat30, float mat31, float mat32, float mat33) {
        this.m00 = mat00;
        this.m01 = mat01;
        this.m02 = mat02;
        this.m03 = mat03;
        this.m10 = mat10;
        this.m11 = mat11;
        this.m12 = mat12;
        this.m13 = mat13;
        this.m20 = mat20;
        this.m21 = mat21;
        this.m22 = mat22;
        this.m23 = mat23;
        this.m30 = mat30;
        this.m31 = mat31;
        this.m32 = mat32;
        this.m33 = mat33;
        return this;
    }

    @Override
    public Mat4 addElWise(Mat4Readable mat) {
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

    @Override
    public Mat4 addElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11,
            float mat12, float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31,
            float mat32, float mat33) {
        this.m00 = this.m00 + mat00;
        this.m01 = this.m01 + mat01;
        this.m02 = this.m02 + mat02;
        this.m03 = this.m03 + mat03;
        this.m10 = this.m10 + mat10;
        this.m11 = this.m11 + mat11;
        this.m12 = this.m12 + mat12;
        this.m13 = this.m13 + mat13;
        this.m20 = this.m20 + mat20;
        this.m21 = this.m21 + mat21;
        this.m22 = this.m22 + mat22;
        this.m23 = this.m23 + mat23;
        this.m30 = this.m30 + mat30;
        this.m31 = this.m31 + mat31;
        this.m32 = this.m32 + mat32;
        this.m33 = this.m33 + mat33;
        return this;
    }

    @Override
    public Mat4 subElWise(Mat4Readable mat) {
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

    @Override
    public Mat4 subElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11,
            float mat12, float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31,
            float mat32, float mat33) {
        this.m00 = this.m00 - mat00;
        this.m01 = this.m01 - mat01;
        this.m02 = this.m02 - mat02;
        this.m03 = this.m03 - mat03;
        this.m10 = this.m10 - mat10;
        this.m11 = this.m11 - mat11;
        this.m12 = this.m12 - mat12;
        this.m13 = this.m13 - mat13;
        this.m20 = this.m20 - mat20;
        this.m21 = this.m21 - mat21;
        this.m22 = this.m22 - mat22;
        this.m23 = this.m23 - mat23;
        this.m30 = this.m30 - mat30;
        this.m31 = this.m31 - mat31;
        this.m32 = this.m32 - mat32;
        this.m33 = this.m33 - mat33;
        return this;
    }

    @Override
    public Mat4 presubElWise(Mat4Readable mat) {
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

    @Override
    public Mat4 presubElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11,
            float mat12, float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31,
            float mat32, float mat33) {
        this.m00 = mat00 - this.m00;
        this.m01 = mat01 - this.m01;
        this.m02 = mat02 - this.m02;
        this.m03 = mat03 - this.m03;
        this.m10 = mat10 - this.m10;
        this.m11 = mat11 - this.m11;
        this.m12 = mat12 - this.m12;
        this.m13 = mat13 - this.m13;
        this.m20 = mat20 - this.m20;
        this.m21 = mat21 - this.m21;
        this.m22 = mat22 - this.m22;
        this.m23 = mat23 - this.m23;
        this.m30 = mat30 - this.m30;
        this.m31 = mat31 - this.m31;
        this.m32 = mat32 - this.m32;
        this.m33 = mat33 - this.m33;
        return this;
    }

    @Override
    public Mat4 mulElWise(Mat4Readable mat) {
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

    @Override
    public Mat4 mulElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11,
            float mat12, float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31,
            float mat32, float mat33) {
        this.m00 = this.m00 * mat00;
        this.m01 = this.m01 * mat01;
        this.m02 = this.m02 * mat02;
        this.m03 = this.m03 * mat03;
        this.m10 = this.m10 * mat10;
        this.m11 = this.m11 * mat11;
        this.m12 = this.m12 * mat12;
        this.m13 = this.m13 * mat13;
        this.m20 = this.m20 * mat20;
        this.m21 = this.m21 * mat21;
        this.m22 = this.m22 * mat22;
        this.m23 = this.m23 * mat23;
        this.m30 = this.m30 * mat30;
        this.m31 = this.m31 * mat31;
        this.m32 = this.m32 * mat32;
        this.m33 = this.m33 * mat33;
        return this;
    }

    @Override
    public Mat4 divElWise(Mat4Readable mat) {
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

    @Override
    public Mat4 divElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11,
            float mat12, float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31,
            float mat32, float mat33) {
        this.m00 = this.m00 / mat00;
        this.m01 = this.m01 / mat01;
        this.m02 = this.m02 / mat02;
        this.m03 = this.m03 / mat03;
        this.m10 = this.m10 / mat10;
        this.m11 = this.m11 / mat11;
        this.m12 = this.m12 / mat12;
        this.m13 = this.m13 / mat13;
        this.m20 = this.m20 / mat20;
        this.m21 = this.m21 / mat21;
        this.m22 = this.m22 / mat22;
        this.m23 = this.m23 / mat23;
        this.m30 = this.m30 / mat30;
        this.m31 = this.m31 / mat31;
        this.m32 = this.m32 / mat32;
        this.m33 = this.m33 / mat33;
        return this;
    }

    @Override
    public Mat4 predivElWise(Mat4Readable mat) {
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

    @Override
    public Mat4 predivElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11,
            float mat12, float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31,
            float mat32, float mat33) {
        this.m00 = mat00 / this.m00;
        this.m01 = mat01 / this.m01;
        this.m02 = mat02 / this.m02;
        this.m03 = mat03 / this.m03;
        this.m10 = mat10 / this.m10;
        this.m11 = mat11 / this.m11;
        this.m12 = mat12 / this.m12;
        this.m13 = mat13 / this.m13;
        this.m20 = mat20 / this.m20;
        this.m21 = mat21 / this.m21;
        this.m22 = mat22 / this.m22;
        this.m23 = mat23 / this.m23;
        this.m30 = mat30 / this.m30;
        this.m31 = mat31 / this.m31;
        this.m32 = mat32 / this.m32;
        this.m33 = mat33 / this.m33;
        return this;
    }

    @Override
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

    @Override
    public Mat4 mul(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33) {
        // row 1
        float m00 = this.m00 * mat00 + this.m01 * mat10 + this.m02 * mat20 + this.m03 * mat30;
        float m01 = this.m00 * mat01 + this.m01 * mat11 + this.m02 * mat21 + this.m03 * mat31;
        float m02 = this.m00 * mat02 + this.m01 * mat12 + this.m02 * mat22 + this.m03 * mat32;
        float m03 = this.m00 * mat03 + this.m01 * mat13 + this.m02 * mat23 + this.m03 * mat33;
        // row 2
        float m10 = this.m10 * mat00 + this.m11 * mat10 + this.m12 * mat20 + this.m13 * mat30;
        float m11 = this.m10 * mat01 + this.m11 * mat11 + this.m12 * mat21 + this.m13 * mat31;
        float m12 = this.m10 * mat02 + this.m11 * mat12 + this.m12 * mat22 + this.m13 * mat32;
        float m13 = this.m10 * mat03 + this.m11 * mat13 + this.m12 * mat23 + this.m13 * mat33;
        // row 3
        float m20 = this.m20 * mat00 + this.m21 * mat10 + this.m22 * mat20 + this.m23 * mat30;
        float m21 = this.m20 * mat01 + this.m21 * mat11 + this.m22 * mat21 + this.m23 * mat31;
        float m22 = this.m20 * mat02 + this.m21 * mat12 + this.m22 * mat22 + this.m23 * mat32;
        float m23 = this.m20 * mat03 + this.m21 * mat13 + this.m22 * mat23 + this.m23 * mat33;
        // row 4
        float m30 = this.m30 * mat00 + this.m31 * mat10 + this.m32 * mat20 + this.m33 * mat30;
        float m31 = this.m30 * mat01 + this.m31 * mat11 + this.m32 * mat21 + this.m33 * mat31;
        float m32 = this.m30 * mat02 + this.m31 * mat12 + this.m32 * mat22 + this.m33 * mat32;
        float m33 = this.m30 * mat03 + this.m31 * mat13 + this.m32 * mat23 + this.m33 * mat33;
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
    public Mat4 premul(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11,
            float mat12, float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31,
            float mat32, float mat33) {
         // row 1
         float m00 = mat00 * this.m00 + mat01 * this.m10 + mat02 * this.m20 + mat03 * this.m30;
         float m01 = mat00 * this.m01 + mat01 * this.m11 + mat02 * this.m21 + mat03 * this.m31;
         float m02 = mat00 * this.m02 + mat01 * this.m12 + mat02 * this.m22 + mat03 * this.m32;
         float m03 = mat00 * this.m03 + mat01 * this.m13 + mat02 * this.m23 + mat03 * this.m33;
         // row 2
         float m10 = mat10 * this.m00 + mat11 * this.m10 + mat12 * this.m20 + mat13 * this.m30;
         float m11 = mat10 * this.m01 + mat11 * this.m11 + mat12 * this.m21 + mat13 * this.m31;
         float m12 = mat10 * this.m02 + mat11 * this.m12 + mat12 * this.m22 + mat13 * this.m32;
         float m13 = mat10 * this.m03 + mat11 * this.m13 + mat12 * this.m23 + mat13 * this.m33;
         // row 3
         float m20 = mat20 * this.m00 + mat21 * this.m10 + mat22 * this.m20 + mat23 * this.m30;
         float m21 = mat20 * this.m01 + mat21 * this.m11 + mat22 * this.m21 + mat23 * this.m31;
         float m22 = mat20 * this.m02 + mat21 * this.m12 + mat22 * this.m22 + mat23 * this.m32;
         float m23 = mat20 * this.m03 + mat21 * this.m13 + mat22 * this.m23 + mat23 * this.m33;
         // row 4
         float m30 = mat30 * this.m00 + mat31 * this.m10 + mat32 * this.m20 + mat33 * this.m30;
         float m31 = mat30 * this.m01 + mat31 * this.m11 + mat32 * this.m21 + mat33 * this.m31;
         float m32 = mat30 * this.m02 + mat31 * this.m12 + mat32 * this.m22 + mat33 * this.m32;
         float m33 = mat30 * this.m03 + mat31 * this.m13 + mat32 * this.m23 + mat33 * this.m33;
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
    public Mat4 rotation2d(float angle) {
        float cosA = (float) Math.cos(Math.toRadians(-angle));
        float sinA = (float) Math.sin(Math.toRadians(-angle));
        return this.mul(
            cosA, -sinA, 0, 0,
            sinA, cosA, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1
        );
    }

    @Override
    public Mat4 rot3dAroundAxis(Vec3Readable axis, float angle) {
        return rot3dAroundAxis(axis.getX(), axis.getY(), axis.getZ(), angle);
    }

    @Override
    public Mat4 rot3dAroundAxis(float axisX, float axisY, float axisZ, float angle) {
        float a = (float) Math.toRadians(angle);
        float sinA = (float) Math.sin(a);
        float cosA = (float) Math.cos(a);
        return this.mul(
            axisX * axisX * (1 - cosA) + cosA, axisX * axisY * (1 - cosA) - axisZ * sinA, axisX * axisZ * (1 - cosA) + axisY * sinA, 0,
            axisY * axisX * (1 - cosA) + axisZ * sinA, axisY * axisY * (1 - cosA) + cosA, axisY * axisZ * (1 - cosA) - axisX * sinA, 0,
            axisZ * axisX * (1 - cosA) - axisY * sinA, axisZ * axisY * (1 - cosA) + axisX * sinA, axisZ * axisZ * (1 - cosA) + cosA, 0,
            0, 0, 0, 1
        );
    }

    @Override
    public Mat4 rot3dAroundXAxis(float angle) {
        float cos = (float) Math.cos(Math.toRadians(angle));
        float sin = (float) Math.sin(Math.toRadians(angle));
        return this.mul(
            1, 0, 0, 0,
            0, cos, -sin, 0,
            0, sin, cos, 0,
            0, 0, 0, 1
        );
    }

    @Override
    public Mat4 rot3dAroundYAxis(float angle) {
        float cos = (float) Math.cos(Math.toRadians(angle));
        float sin = (float) Math.sin(Math.toRadians(angle));
        return this.mul(
            cos, 0, sin, 0,
            0, 1, 0, 0,
            -sin, 0, cos, 0,
            0, 0, 0, 1
        );
    }

    @Override
    public Mat4 rot3dAroundZAxis(float angle) {
        float cos = (float) Math.cos(Math.toRadians(angle));
        float sin = (float) Math.sin(Math.toRadians(angle));
        // rotation around z axis
        return this.mul(
            cos, -sin, 0, 0,
            sin, cos, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1
        );
    }

    @Override
    public Mat4 rotation3d(Vec3Readable forward, Vec3Readable up, Vec3Readable right) {
        return rotation3d(forward.getX(), forward.getY(), forward.getZ(), up.getX(), up.getY(), up.getZ(), right.getX(), right.getY(), right.getZ());
    }

    @Override
    public Mat4 rotation3d(float fX, float fY, float fZ, float uX, float uY, float uZ, float rX, float rY, float rZ) {
        return this.mul(
            rX, rY, rZ, 0,
            uX, uY, uZ, 0,
            fX, fY, fZ, 0,
            0, 0, 0, 1
        );
    }

    @Override
    public Mat4 rot3dFromQuaternion(QuatReadable q) {
        return rot3dFromQuaternion(q.getW(), q.getX(), q.getY(), q.getZ());
    }

    @Override
    public Mat4 rot3dFromQuaternion(float qw, float qx, float qy, float qz) {
        // normalize the quaternion
        float len = (float) Math.sqrt(qw * qw + qx * qx + qy * qy + qz * qz);
        float w = qw / len;
        float x = qx / len;
        float y = qy / len;
        float z = qz / len;
        return this.mul(
            (1.0f - (2.0f * ((y * y) + (z * z)))), (2.0f * ((x * y) - (z * w))), (float) (2.0f * ((x * z) + (y * w))), 0,
            (2.0f * ((x * y) + (z * w))), (1.0f - (2.0f * ((x * x) + (z * z)))), (float) (2.0f * ((y * z) - (x * w))), 0,
            (float) (2.0f * ((x * z) - (y * w))), (float) (2.0f * ((y * z) + (x * w))), (float) (1.0f - (2.0f * ((x * x) + (y * y)))), 0,
            0, 0, 0, 1
        );
    }

    @Override
    public Mat4 translation2d(Vec2Readable v) {
        return translation2d(v.getX(), v.getY());
    }

    @Override
    public Mat4 translation2d(float dX, float dY) {
        return this.mul(
            1, 0, 0, dX,
            0, 1, 0, dY,
            0, 0, 1, 0,
            0, 0, 0, 1
        );
    }

    @Override
    public Mat4 translation3d(Vec3Readable v) {
        return translation3d(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Mat4 translation3d(float dX, float dY, float dZ) {
        return this.mul(
            1, 0, 0, dX,
            0, 1, 0, dY,
            0, 0, 1, dZ,
            0, 0, 0, 1
        );
    }

    @Override
    public Mat4 scale2d(Vec2Readable v) {
        return scale2d(v.getX(), v.getY());
    }

    @Override
    public Mat4 scale2d(float scaleX, float scaleY) {
        return this.mul(
            scaleX, 0, 0, 0,
            0, scaleY, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1
        );
    }

    @Override
    public Mat4 scale3d(Vec3Readable v) {
        return scale3d(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Mat4 scale3d(float scaleX, float scaleY, float scaleZ) {
        return this.mul(
            scaleX, 0, 0, 0,
            0, scaleY, 0, 0,
            0, 0, scaleZ, 0,
            0, 0, 0, 1
        );
    }

    @Override
    public Mat4 scale4d(Vec4Readable v) {
        return scale4d(v.getX(), v.getY(), v.getZ(), v.getW());
    }

    @Override
    public Mat4 scale4d(float scaleX, float scaleY, float scaleZ, float scaleW) {
        return this.mul(
            scaleX, 0, 0, 0,
            0, scaleY, 0, 0,
            0, 0, scaleZ, 0,
            0, 0, 0, scaleW
        );
    }

    @Override
    public Mat4 lookAt3d(Vec3Readable pos, Vec3Readable tgt, Vec3Readable up) {
        return lookAt3d(pos.getX(), pos.getY(), pos.getZ(), tgt.getX(), tgt.getY(), tgt.getZ(), up.getX(), up.getY(), up.getZ());
    }

    @Override
    public Mat4 lookAt3d(float posX, float posY, float posZ, float tgtX, float tgtY, float tgtZ, float upX, float upY, float upZ) {
        Vec3 zAxis = new Vec3(tgtX, tgtY, tgtZ).sub(posX, posY, posZ).normalize();
        Vec3 xAxis = new Vec3(upX, upY, upZ).cross(zAxis).normalize();
        Vec3 yAxis = new Vec3(zAxis).cross(xAxis);

        this.mul(
            xAxis.x, yAxis.x, zAxis.x, -posX,
            xAxis.y, yAxis.y, zAxis.y, -posY,
            xAxis.z, yAxis.z, zAxis.z, -posZ,
            0, 0, 0, 1
        );
        return this;
    }

    @Override
    public Mat4 view3dFromQuaternion(Vec3Readable p, QuatReadable q) {
        return this.view3dFromQuaternion(p.getX(), p.getY(), p.getZ(), q.getW(), q.getX(), q.getY(), q.getZ());
    }

    @Override
    public Mat4 view3dFromQuaternion(float pX, float pY, float pZ, float qw, float qx, float qy, float qz) {
        this.rot3dFromQuaternion(qw, qx, qy, qz);
        float t03 = -(pX * this.m00 + pY * this.m10 + pZ * this.m20);
        float t13 = -(pX * this.m01 + pY * this.m11 + pZ * this.m21);
        float t23 = -(pX * this.m02 + pY * this.m12 + pZ * this.m22);
        return this.mul(
            1, 0, 0, t03,
            0, 1, 0, t13,
            0, 0, 1, t23,
            0, 0, 0, 1
        );
    }


    /**
     * Multiplies this matrix with a perspective projection matrix given by six clipping planes.
     * 
     * @param left      left clipping plane
     * @param right     right clipping plane
     * @param bottom    bottom clipping plane
     * @param top       top clipping plane
     * @param near      near clipping plane
     * @param far       far clipping plane
     * @return          this matrix
     */ 
    public Mat4 perspective3d(float left, float right, float bottom, float top, float near, float far) {
        float l = left;
        float r = right;
        float b = bottom;
        float t = top;
        float n = near;
        float f = far;
        return this.mul(
             (2 * n) / (r - l), 0, 0, 0,
             0, (2 * n) / (t - b), 0, 0,
             (r + l) / (r - l), (t + b) / (t - b), -(f + n) / (f - n), -1,
             0, 0, -(2 * f * n) / (f - n), 0
         );
    }

    /**
     * Multiplies this matrix with a perspective projection matrix given by the aspect ratio, 
     * near and far clipping plane and the field of view.
     * 
     * @param aspect    aspect ratio of the window
     * @param near      near clipping plane
     * @param far       far clipping plane
     * @param fovY      field of view y axis (in degrees)
     * @return          this matrix
     */
    @Override
    public Mat4 perspective3dFov(float aspect, float near, float far, float fovY) {
        float tanHalfFov = (float) Math.tan(Math.toRadians(fovY / 2.0));
        float pWidth = (2 * near) / (1 / tanHalfFov);
        float pHeight = (2 * near) / (1 / tanHalfFov * aspect);
        float right = pWidth / 2;
        float left = -pWidth / 2;
        float top = pHeight / 2;
        float bottom = -pHeight / 2;
        return perspective3d(left, right, bottom, top, near, far);
    }

    /**
     * Multiplies this matrix with an orthographic projection matrix given by six clipping planes.
     * 
     * @param left      left clipping plane
     * @param right     right clipping plane
     * @param bottom    bottom clipping plane
     * @param top       top clipping plane
     * @param near      near clipping plane
     * @param far       far clipping plane
     * @return          this matrix
     */
    @Override
    public Mat4 orthographic3d(float left, float right, float bottom, float top, float near, float far) {
        float l = left;
        float r = right;
        float b = bottom;
        float t = top;
        float n = near;
        float f = far;
        return this.mul(
            2 / (r - l), 0, 0, 0,
            0, 2 / (t - b), 0, 0,
            0, 0, (-2) / (f - n), 0,
            -(r + l) / (r - l), -(t + b) / (t - b),  -(f + n) / (f - n), 1
        );
    }

    /**
     * Multiplies this matrix with a oblique projection matrix given by six clipping planes and two angles.
     * 
     * @param left      left clipping plane
     * @param right     right clipping plane
     * @param bottom    bottom clipping plane
     * @param top       top clipping plane
     * @param near      near clipping plane
     * @param far       far clipping plane
     * @param alpha     angle (in degrees) between x axis and z axis in projection
     * @param beta      angle (in degrees) for the ratio between the actual length in z and the projected length in z 
     * @return          this matrix
     */
    @Override
    public Mat4 oblique3d(float left, float right, float bottom, float top, float near, float far, float alpha, float beta) {
        float cosA = (float) Math.cos(Math.toRadians(alpha));
        float sinA = (float) Math.sin(Math.toRadians(alpha));
        float tanB = (float) Math.tan(Math.toRadians(beta));
        float sinB = (float) Math.sin(Math.toRadians(beta));
        return this.orthographic3d(left, right, bottom, top, near, far).mul(
            1, 0, -cosA / tanB, 0,
            0, 1, sinA / tanB, 0, 
            0, 0, -1 / sinB, 0,
            0, 0, 0, 1
        );
    }

    /**
     * Multiplies this matrix with a cabinet projection matrix given by six clipping planes and an angle.
     * 
     * @param left      left clipping plane
     * @param right     right clipping plane
     * @param bottom    bottom clipping plane
     * @param top       top clipping plane
     * @param near      near clipping plane
     * @param far       far clipping plane
     * @param angle     angle (int degrees) between x axis and z axis in projection
     * @return          this matrix
     */
    @Override
    public Mat4 cabinet3d(float left, float right, float bottom, float top, float near, float far, float angle) {
        return this.oblique3d(left, right, bottom, top, near, far, angle, (float) Math.toDegrees(Math.atan(2)));
    }


    /**
     * Multiplies this matrix with a cavalier projection matrix given by six clipping planes and an angle.
     * 
     * @param left      left clipping plane
     * @param right     right clipping plane
     * @param bottom    bottom clipping plane
     * @param top       top clipping plane
     * @param near      near clipping plane
     * @param far       far clipping plane
     * @param angle     angle (int degrees) between x axis and z axis in projection
     * @return          this matrix
     */
    @Override
    public Mat4 cavalier3d(float left, float right, float bottom, float top, float near, float far, float angle) {
        return this.oblique3d(left, right, bottom, top, near, far, angle, (float) Math.toDegrees(Math.atan(1)));
    }


    @Override
    public String toString() {
        return this.buildString();
    }

    // STATIC METHODS TO CONSTRUCT A MATRIX

    public static Mat4 newRotation2d(float angle) {
        return new Mat4().rotation2d(angle);
    }

    public static Mat4 newRot3dAroundAxis(Vec3Readable axis, float angle) {
        return new Mat4().rot3dAroundAxis(axis, angle);
    }

    public static Mat4 newRot3dAroundAxis(float axisX, float axisY, float axisZ, float angle) {
        return new Mat4().rot3dAroundAxis(axisX, axisY, axisZ, angle);
    }

    public static Mat4 newRot3dAroundXAxis(float angle) {
        return new Mat4().rot3dAroundXAxis(angle);
    }

    public static Mat4 newRot3dAroundYAxis(float angle) {
        return new Mat4().rot3dAroundYAxis(angle);
    }

    public static Mat4 newRot3dAroundZAxis(float angle) {
        return new Mat4().rot3dAroundZAxis(angle);
    }

    public static Mat4 newRotation3d(Vec3Readable forward, Vec3Readable up, Vec3Readable right) {
        return new Mat4().rotation3d(forward, up, right);
    }
    
    public static Mat4 newRotation3d(float fX, float fY, float fZ, float uX, float uY, float uZ, float rX, float rY, float rZ) {
        return new Mat4().rotation3d(fX, fY, fZ, uX, uY, uZ, rX, rY, rZ);
    }

    public static Mat4 newRot3dFromQuaternion(QuatReadable q) {
        return new Mat4().rot3dFromQuaternion(q);
    }

    public static Mat4 newRot3dFromQuaternion(float qw, float qx, float qy, float qz) {
        return new Mat4().rot3dFromQuaternion(qw, qx, qy, qz);
    }

    public static Mat4 newTranslation2d(Vec2Readable translation) {
        return new Mat4().translation2d(translation);
    }

    public static Mat4 newTranslation2d(float dX, float dY) {
        return new Mat4().translation2d(dX, dY);
    }

    public static Mat4 newTranslation3d(Vec3Readable translation) {
        return new Mat4().translation3d(translation);
    }

    public static Mat4 newTranslation3d(float dX, float dY, float dZ) {
        return new Mat4().translation3d(dX, dY, dZ);
    }

    public static Mat4 newScale2d(Vec2Readable scale) {
        return new Mat4().scale2d(scale);
    }

    public static Mat4 newScale2d(float scaleX, float scaleY) {
        return new Mat4().scale2d(scaleX, scaleY);
    }

    public static Mat4 newScale3d(Vec3Readable scale) {
        return new Mat4().scale3d(scale);
    }

    public static Mat4 newScale3d(float scaleX, float scaleY, float scaleZ) {
        return new Mat4().scale3d(scaleX, scaleY, scaleZ);
    }

    public static Mat4 newScale4d(Vec4Readable scale) {
        return new Mat4().scale4d(scale);
    }

    public static Mat4 newScale4d(float scaleX, float scaleY, float scaleZ, float scaleW) {
        return new Mat4().scale4d(scaleX, scaleY, scaleZ, scaleW);
    }

    public static Mat4 newLookAt3d(Vec3Readable pos, Vec3Readable tgt, Vec3Readable up) {
        return new Mat4().lookAt3d(pos, tgt, up);
    }

    public static Mat4 newLookAt3d(float posX, float posY, float posZ, float tgtX, float tgtY, float tgtZ, float upX, float upY, float upZ) {
        return new Mat4().lookAt3d(posX, posY, posZ, tgtX, tgtY, tgtZ, upX, upY, upZ);
    }

    public static Mat4 newView3dFromQuaternion(Vec3Readable p, QuatReadable q) {
        return new Mat4().view3dFromQuaternion(p, q);
    }

    public static Mat4 newView3dFromQuaternion(float pX, float pY, float pZ, float qw, float qx, float qy, float qz) {
        return new Mat4().view3dFromQuaternion(pX, pY, pZ, qw, qx, qy, qz);
    }

    public static Mat4 newPerspective3d(float l, float r, float b, float t, float n, float f) {
        return new Mat4().perspective3d(l, r, b, t, n, f);
    }

    public static Mat4 newPerspective3dFov(float aspect, float near, float far, float fovY) {
        return new Mat4().perspective3dFov(aspect, near, far, fovY);
    }

    public static Mat4 newOrthographic3d(float l, float r, float b, float t, float n, float f) {
        return new Mat4().orthographic3d(l, r, b, t, n, f);
    }

    public static Mat4 newOblique3d(float l, float r, float b, float t, float n, float f, float alpha, float beta) {
        return new Mat4().oblique3d(l, r, b, t, n, f, alpha, beta);
    }

    public static Mat4 newCabinet3d(float l, float r, float b, float t, float n, float f, float angle) {
        return new Mat4().cabinet3d(l, r, b, t, n, f, angle);
    }

    public static Mat4 newCavalier3d(float l, float r, float b, float t, float n, float f, float angle) {
        return new Mat4().cavalier3d(l, r, b, t, n, f, angle);
    }
    
}
