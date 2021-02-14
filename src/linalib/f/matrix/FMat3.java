package linalib.f.matrix;

import java.nio.FloatBuffer;

import linalib.f.quaternion.FQuaternionReadable;
import linalib.f.vector.FVec2Readable;
import linalib.f.vector.FVec3Readable;

public class FMat3 implements FMat3Readable, FMatWritable {

    public static final FMat3 IDENTITY = new FMat3(1, 0, 0, 0, 1, 0, 0, 0, 1);

    public static final FMat3 FLIP = new FMat3(0, 0, 1, 0, 1, 0, 1, 0, 0);

    public float m00, m01, m02;
    public float m10, m11, m12;
    public float m20, m21, m22;

    private final int rowCount = 3;
    private final int colCount = 3;

    public FMat3() {
        this.set(IDENTITY);
    }

    public FMat3(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
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

    public FMat3(FMat3Readable other) {
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
        else if (r == 1 && c == 0) return m10;
        else if (r == 1 && c == 1) return m11;
        else if (r == 1 && c == 2) return m12;
        else if (r == 2 && c == 0) return m20;
        else if (r == 2 && c == 1) return m21;
        else if (r == 2 && c == 2) return m22;
        else throw new IllegalArgumentException("Row and/or column out of range " + rowCount() + "x" +  colCount() + ". " + r + " " + c);
    }

    @Override
    public float[] newArr() {
        return new float[] {
            m00, m01, m02,
            m10, m11, m12,
            m20, m21, m22
        };
    }

    @Override
    public float[][] newArr2() {
        return new float[][] {
            {m00, m01, m02},
            {m10, m11, m12},
            {m20, m21, m22}
        };
    }

    @Override
    public FMat3 storeInside(FloatBuffer buf) {
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

    @Override
    public FMat3 to(FMatWritable mat) {
        this.extractTo(mat);
        return this;
    }

    @Override
    public FMat3 transpose() {
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
    public FMat3 flipHor() {
        return this.mul(FMat3.FLIP);
    }

    @Override
    public FMat3 flipVer() {
        return this.premul(FMat3.FLIP);
    }

    @Override
    public FMat3 set(int r, int c, float val) {
        if (r == 0 && c == 0) this.m00 = val;
        else if (r == 0 && c == 1) this.m01 = val;
        else if (r == 0 && c == 2) this.m02 = val;
        else if (r == 1 && c == 0) this.m10 = val;
        else if (r == 1 && c == 1) this.m11 = val;
        else if (r == 1 && c == 2) this.m12 = val;
        else if (r == 2 && c == 0) this.m20 = val;
        else if (r == 2 && c == 1) this.m21 = val;
        else if (r == 2 && c == 2) this.m22 = val;
        else throw new IllegalArgumentException("Row and/or column out of range " + rowCount() + "x" +  colCount() + ". " + r + " " + c);
        return this;
    }

    @Override
    public FMat3 roundElWise() {
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

    @Override
    public FMat3 floorElWise(float r) {
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

    @Override
    public FMat3 negateElWise() {
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

    @Override
    public FMat3 toInt() {
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
    public FMat3 absElWise() {
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

    @Override
    public FMat3 addElWise(float r) {
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

    @Override
    public FMat3 subElWise(float r) {
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

    @Override
    public FMat3 presubElWise(float r) {
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

    @Override
    public FMat3 mulElWise(float r) {
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

    @Override
    public FMat3 divElWise(float r) {
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

    @Override
    public FMat3 predivElWise(float r) {
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

    @Override
    public FMat3 from(FMatReadable mat) {
        this.extractFrom(mat);
        return this;
    }

    public FMat3 set00(float val) {
        this.m00 = val;
        return this;
    }

    public FMat3 set01(float val) {
        this.m01 = val;
        return this;
    }

    public FMat3 set02(float val) {
        this.m02 = val;
        return this;
    }

    public FMat3 set10(float val) {
        this.m10 = val;
        return this;
    }

    public FMat3 set11(float val) {
        this.m11 = val;
        return this;
    }

    public FMat3 set12(float val) {
        this.m12 = val;
        return this;
    }

    public FMat3 set20(float val) {
        this.m20 = val;
        return this;
    }

    public FMat3 set21(float val) {
        this.m21 = val;
        return this;
    }

    public FMat3 set22(float val) {
        this.m22 = val;
        return this;
    }

    public FMat3 set(FMat3Readable mat) {
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

    public FMat3 set(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22) {
        this.m00 = mat00;
        this.m01 = mat01;
        this.m02 = mat02;
        this.m10 = mat10;
        this.m11 = mat11;
        this.m12 = mat12;
        this.m20 = mat20;
        this.m21 = mat21;
        this.m22 = mat22;
        return this;
    }

    public FMat3 addElWise(FMat3Readable mat) {
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

    public FMat3 addElWise(float mat00, float mat01, float mat02, float mat10, float mat11, float mat12,
            float mat20, float mat21, float mat22) {
        this.m00 = this.m00 + mat00;
        this.m01 = this.m01 + mat01;
        this.m02 = this.m02 + mat02;
        this.m10 = this.m10 + mat10;
        this.m11 = this.m11 + mat11;
        this.m12 = this.m12 + mat12;
        this.m20 = this.m20 + mat20;
        this.m21 = this.m21 + mat21;
        this.m22 = this.m22 + mat22;
        return this;
    }

    public FMat3 subElWise(FMat3Readable mat) {
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

    public FMat3 subElWise(float mat00, float mat01, float mat02, float mat10, float mat11, float mat12,
            float mat20, float mat21, float mat22) {
        this.m00 = this.m00 - mat00;
        this.m01 = this.m01 - mat01;
        this.m02 = this.m02 - mat02;
        this.m10 = this.m10 - mat10;
        this.m11 = this.m11 - mat11;
        this.m12 = this.m12 - mat12;
        this.m20 = this.m20 - mat20;
        this.m21 = this.m21 - mat21;
        this.m22 = this.m22 - mat22;
        return this;
    }

    public FMat3 presubElWise(FMat3Readable mat) {
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

    public FMat3 presubElWise(float mat00, float mat01, float mat02, float mat10, float mat11, float mat12,
            float mat20, float mat21, float mat22) {
        this.m00 = mat00 - this.m00;
        this.m01 = mat01 - this.m01;
        this.m02 = mat02 - this.m02;
        this.m10 = mat10 - this.m10;
        this.m11 = mat11 - this.m11;
        this.m12 = mat12 - this.m12;
        this.m20 = mat20 - this.m20;
        this.m21 = mat21 - this.m21;
        this.m22 = mat22 - this.m22;
        return this;
    }

    public FMat3 mulElWise(FMat3Readable mat) {
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

    public FMat3 mulElWise(float mat00, float mat01, float mat02, float mat10, float mat11, float mat12,
            float mat20, float mat21, float mat22) {
        this.m00 = this.m00 * mat00;
        this.m01 = this.m01 * mat01;
        this.m02 = this.m02 * mat02;
        this.m10 = this.m10 * mat10;
        this.m11 = this.m11 * mat11;
        this.m12 = this.m12 * mat12;
        this.m20 = this.m20 * mat20;
        this.m21 = this.m21 * mat21;
        this.m22 = this.m22 * mat22;
        return this;
    }

    public FMat3 divElWise(FMat3Readable mat) {
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

    public FMat3 divElWise(float mat00, float mat01, float mat02, float mat10, float mat11, float mat12,
            float mat20, float mat21, float mat22) {
        this.m00 = this.m00 / mat00;
        this.m01 = this.m01 / mat01;
        this.m02 = this.m02 / mat02;
        this.m10 = this.m10 / mat10;
        this.m11 = this.m11 / mat11;
        this.m12 = this.m12 / mat12;
        this.m20 = this.m20 / mat20;
        this.m21 = this.m21 / mat21;
        this.m22 = this.m22 / mat22;
        return this;
    }

    public FMat3 predivElWise(FMat3Readable mat) {
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

    public FMat3 predivElWise(float mat00, float mat01, float mat02, float mat10, float mat11, float mat12,
            float mat20, float mat21, float mat22) {
        this.m00 = mat00 / this.m00;
        this.m01 = mat01 / this.m01;
        this.m02 = mat02 / this.m02;
        this.m10 = mat10 / this.m10;
        this.m11 = mat11 / this.m11;
        this.m12 = mat12 / this.m12;
        this.m20 = mat20 / this.m20;
        this.m21 = mat21 / this.m21;
        this.m22 = mat22 / this.m22;
        return this;
    }

    public FMat3 mul(FMat3Readable mat) {
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

    public FMat3 mul(float mat00, float mat01, float mat02, float mat10, float mat11, float mat12, float mat20,
            float mat21, float mat22) {
        float m00 = this.m00 * mat00 + this.m01 * mat10 + this.m02 * mat20;
        float m01 = this.m00 * mat01 + this.m01 * mat11 + this.m02 * mat21;
        float m02 = this.m00 * mat02 + this.m01 * mat12 + this.m02 * mat22;
        float m10 = this.m10 * mat00 + this.m11 * mat10 + this.m12 * mat20;
        float m11 = this.m10 * mat01 + this.m11 * mat11 + this.m12 * mat21;
        float m12 = this.m10 * mat02 + this.m11 * mat12 + this.m12 * mat22;
        float m20 = this.m20 * mat00 + this.m21 * mat10 + this.m22 * mat20;
        float m21 = this.m20 * mat01 + this.m21 * mat11 + this.m22 * mat21;
        float m22 = this.m20 * mat02 + this.m21 * mat12 + this.m22 * mat22;
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

    public FMat3 premul(FMat3Readable mat) {
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

    public FMat3 premul(float mat00, float mat01, float mat02, float mat10, float mat11, float mat12,
            float mat20, float mat21, float mat22) {
        float m00 = mat00 * this.m00 + mat01 * this.m10 + mat02 * this.m20;
        float m01 = mat00 * this.m01 + mat01 * this.m11 + mat02 * this.m21;
        float m02 = mat00 * this.m02 + mat01 * this.m12 + mat02 * this.m22;
        float m10 = mat10 * this.m00 + mat11 * this.m10 + mat12 * this.m20;
        float m11 = mat10 * this.m01 + mat11 * this.m11 + mat12 * this.m21;
        float m12 = mat10 * this.m02 + mat11 * this.m12 + mat12 * this.m22;
        float m20 = mat20 * this.m00 + mat21 * this.m10 + mat22 * this.m20;
        float m21 = mat20 * this.m01 + mat21 * this.m11 + mat22 * this.m21;
        float m22 = mat20 * this.m02 + mat21 * this.m12 + mat22 * this.m22;
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

    public FMat3 mulRotation2(float angle) {
        float cosA = (float) Math.cos(Math.toRadians(-angle));
        float sinA = (float) Math.sin(Math.toRadians(-angle));
        return this.mul(
            cosA, -sinA, 0,
            sinA, cosA, 0,
            0,0,1
        );
    }

    public FMat3 mulRot3AroundAxis(FVec3Readable axis, float angle) {
        return mulRot3AroundAxis(axis.getX(), axis.getY(), axis.getZ(), angle);
    }

    public FMat3 mulRot3AroundAxis(float axisX, float axisY, float axisZ, float angle) {
        float a = (float) Math.toRadians(angle);
        float sinA = (float) Math.sin(a);
        float cosA = (float) Math.cos(a);
        return this.mul(
            axisX * axisX * (1 - cosA) + cosA, axisX * axisY * (1 - cosA) - axisZ * sinA, axisX * axisZ * (1 - cosA) + axisY * sinA,
            axisY * axisX * (1 - cosA) + axisZ * sinA, axisY * axisY * (1 - cosA) + cosA, axisY * axisZ * (1 - cosA) - axisX * sinA,
            axisZ * axisX * (1 - cosA) - axisY * sinA, axisZ * axisY * (1 - cosA) + axisX * sinA, axisZ * axisZ * (1 - cosA) + cosA
        );
    }

    public FMat3 mulRot3AroundXAxis(float angle) {
        float cos = (float) Math.cos(Math.toRadians(angle));
        float sin = (float) Math.sin(Math.toRadians(angle));
        return this.mul(
            1, 0, 0,
            0, cos, -sin,
            0, sin, cos
        );
    }

    public FMat3 mulRot3AroundYAxis(float angle) {
        float cos = (float) Math.cos(Math.toRadians(angle));
        float sin = (float) Math.sin(Math.toRadians(angle));
        return this.mul(
            cos, 0, sin,
            0, 1, 0,
            -sin, 0, cos
        );
    }

    public FMat3 mulRot3AroundZAxis(float angle) {
        float cos = (float) Math.cos(Math.toRadians(angle));
        float sin = (float) Math.sin(Math.toRadians(angle));
        // rotation around z axis
        return this.mul(
            cos, -sin, 0,
            sin, cos, 0, 
            0, 0, 1
        );
    }

    public FMat3 mulRotation3(FVec3Readable forward, FVec3Readable up, FVec3Readable right) {
        return mulRotation3(forward.getX(), forward.getY(), forward.getZ(), up.getX(), up.getY(), up.getZ(), right.getX(), right.getY(), right.getZ());
    }

    public FMat3 mulRotation3(float fX, float fY, float fZ, float uX, float uY, float uZ, float rX, float rY, float rZ) {
        return this.mul(
            rX, rY, rZ,
            uX, uY, uZ,
            fX, fY, fZ
        );
    }

    public FMat3 mulRot3FromQuaternion(FQuaternionReadable q) {
        return mulRot3FromQuaternion(q.getW(), q.getX(), q.getY(), q.getZ());
    }

    public FMat3 mulRot3FromQuaternion(float qw, float qx, float qy, float qz) {
        // normalize the quaternion
        float len = (float) Math.sqrt(qw * qw + qx * qx + qy * qy + qz * qz);
        float w = qw / len;
        float x = qx / len;
        float y = qy / len;
        float z = qz / len;

        return this.mul(
            (1.0f - (2.0f * ((y * y) + (z * z)))), (2.0f * ((x * y) - (z * w))), (float) (2.0f * ((x * z) + (y * w))),
            (2.0f * ((x * y) + (z * w))), (1.0f - (2.0f * ((x * x) + (z * z)))), (float) (2.0f * ((y * z) - (x * w))),
            (float) (2.0f * ((x * z) - (y * w))), (float) (2.0f * ((y * z) + (x * w))), (float) (1.0f - (2.0f * ((x * x) + (y * y))))
        );
    }

    public FMat3 mulTranslation2(FVec2Readable v) {
        return mulTranslation2(v.getX(), v.getY());
    }

    public FMat3 mulTranslation2(float dX, float dY) {
        return this.mul(
            1, 0, dX,
            0, 1, dY,
            0, 0, 1
        );
    }

    public FMat3 mulScale2(FVec2Readable v) {
        return mulScale2(v.getX(), v.getY());
    }

    public FMat3 mulScale2(float scaleX, float scaleY) {
        return this.mul(
            scaleX, 0, 0,
            0, scaleY, 0,
            0, 0, 1
        );
    }

    public FMat3 mulScale3(FVec3Readable v) {
        return mulScale3(v.getX(), v.getY(), v.getZ());
    }
    
    public FMat3 mulScale3(float scaleX, float scaleY, float scaleZ) {
        return this.mul(
            scaleX, 0, 0,
            0, scaleY, 0,
            0, 0, scaleZ
        );
    }

    @Override
    public String toString() {
        return this.buildString();
    }


    // STATIC METHODS TO CONSTRUCT A MATRIX

    public static FMat3 newRotation2(float angle) {
        return new FMat3(IDENTITY).mulRotation2(angle);
    }

    public static FMat3 newRot3AroundAxis(FVec3Readable axis, float angle) {
        return new FMat3(IDENTITY).mulRot3AroundAxis(axis, angle);
    }

    public static FMat3 newRot3AroundAxis(float axisX, float axisY, float axisZ, float angle) {
        return new FMat3(IDENTITY).mulRot3AroundAxis(axisX, axisY, axisZ, angle);
    }

    public static FMat3 newRot3AroundXAxis(float angle) {
        return new FMat3(IDENTITY).mulRot3AroundXAxis(angle);
    }

    public static FMat3 newRot3AroundYAxis(float angle) {
        return new FMat3(IDENTITY).mulRot3AroundYAxis(angle);
    }

    public static FMat3 newRot3AroundZAxis(float angle) {
        return new FMat3(IDENTITY).mulRot3AroundZAxis(angle);
    }

    public static FMat3 newRotation3(FVec3Readable forward, FVec3Readable up, FVec3Readable right) {
        return new FMat3(IDENTITY).mulRotation3(forward, up, right);
    }
    
    public static FMat3 newRotation3(float fX, float fY, float fZ, float uX, float uY, float uZ, float rX, float rY, float rZ) {
        return new FMat3(IDENTITY).mulRotation3(fX, fY, fZ, uX, uY, uZ, rX, rY, rZ);
    }

    public static FMat3 newRot3FromQuaternion(FQuaternionReadable q) {
        return new FMat3(IDENTITY).mulRot3FromQuaternion(q);
    }

    public static FMat3 newRot3FromQuaternion(float qw, float qx, float qy, float qz) {
        return new FMat3(IDENTITY).mulRot3FromQuaternion(qw, qx, qy, qz);
    }

    public static FMat3 newTranslation2(FVec2Readable translation) {
        return new FMat3(IDENTITY).mulTranslation2(translation);
    }

    public static FMat3 newTranslation2(float dX, float dY) {
        return new FMat3(IDENTITY).mulTranslation2(dX, dY);
    }

    public static FMat3 newScale2(FVec2Readable scale) {
        return new FMat3(IDENTITY).mulScale2(scale);
    }

    public static FMat3 newScale2(float scaleX, float scaleY) {
        return new FMat3(IDENTITY).mulScale2(scaleX, scaleY);
    }

    public static FMat3 newScale3(FVec3Readable scale) {
        return new FMat3(IDENTITY).mulScale3(scale);
    }

    public static FMat3 newScale3(float scaleX, float scaleY, float scaleZ) {
        return new FMat3(IDENTITY).mulScale3(scaleX, scaleY, scaleZ);
    }

}
