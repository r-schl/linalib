package linalib.flt;

import java.nio.FloatBuffer;

public class FMat2 implements FMat2Readable, FMatWritable {

    public static final FMat2 IDENTITY = new FMat2(1, 0, 0, 1);

    public static final FMat2 FLIP = new FMat2(0, 1, 1, 0);

    public float m00, m01;
    public float m10, m11;

    private final int rowCount = 2;
    private final int colCount = 2;

    public FMat2() {
        this.set(IDENTITY);
    }

    public FMat2(float m00, float m01, float m10, float m11) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
    }

    public FMat2(FMat2 other) {
        this.m00 = other.m00;
        this.m01 = other.m01;
        this.m10 = other.m10;
        this.m11 = other.m11;
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
        else if (r == 1 && c == 0) return m10;
        else if (r == 1 && c == 1) return m11;
        else throw new IllegalArgumentException("Row and/or column out of range " + rowCount() + "x" +  colCount() + ". " + r + " " + c);
    }

    @Override
    public float[] newArr() {
        return new float[] {
            m00, m01,
            m10, m11
        };
    }

    @Override
    public float[][] newArr2() {
        return new float[][] {
            {m00, m01},
            {m10, m11}
        };
    }

    @Override
    public FMat2 storeInside(FloatBuffer buf) {
        buf.put(m00);
        buf.put(m01);
        buf.put(m10);
        buf.put(m11);
        return this;
    }

    @Override
    public FMat2 to(FMatWritable mat) {
        this.extractTo(mat);
        return this;
    }

    @Override
    public FMat2 transpose() {
        float tm01 = m01;
        m01 = m10;
        m10 = tm01;
        return null;
    }

    @Override
    public FMat2 flipHor() {
        return this.mul(FMat2.FLIP);
    }

    @Override
    public FMat2 flipVer() {
        return this.premul(FMat2.FLIP);
    }

    @Override
    public FMat2 set(int r, int c, float val) {
        if (r == 0 && c == 0) this.m00 = val;
        else if (r == 0 && c == 1) this.m01 = val;
        else if (r == 1 && c == 0) this.m10 = val;
        else if (r == 1 && c == 1) this.m11 = val;
        else throw new IllegalArgumentException("Row and/or column out of range " + rowCount() + "x" +  colCount() + ". " + r + " " + c);
        return this;
    }

    @Override
    public FMat2 roundElWise() {
        this.m00 = Math.round(this.m00);
        this.m01 = Math.round(this.m01);
        this.m10 = Math.round(this.m10);
        this.m11 = Math.round(this.m11);
        return this;
    }

    @Override
    public FMat2 floorElWise(float r) {
        this.m00 = (this.m00 - (this.m00 % r));
        this.m01 = (this.m01 - (this.m00 % r));
        this.m10 = (this.m10 - (this.m00 % r));
        this.m11 = (this.m11 - (this.m00 % r));
        return this;
    }

    @Override
    public FMat2 negateElWise() {
        this.m00 = -this.m00;
        this.m01 = -this.m01;
        this.m10 = -this.m10;
        this.m11 = -this.m11;
        return this;
    }

    @Override
    public FMat2 toInt() {
        this.m00 = (int) m00;
        this.m01 = (int) m01;
        this.m10 = (int) m10;
        this.m11 = (int) m11;
        return this;
    }

    @Override
    public FMat2 absElWise() {
        this.m00 = Math.abs(m00);
        this.m01 = Math.abs(m01);
        this.m10 = Math.abs(m10);
        this.m11 = Math.abs(m11);
        return this;
    }

    @Override
    public FMat2 addElWise(float r) {
        this.m00 = m00 + r;
        this.m01 = m01 + r;
        this.m10 = m10 + r;
        this.m11 = m11 + r;
        return this;
    }

    @Override
    public FMat2 subElWise(float r) {
        this.m00 = m00 - r;
        this.m01 = m01 - r;
        this.m10 = m10 - r;
        this.m11 = m11 - r;
        return this;
    }

    @Override
    public FMat2 presubElWise(float r) {
        this.m00 = r - this.m00;
        this.m01 = r - this.m01;
        this.m10 = r - this.m10;
        this.m11 = r - this.m11;
        return this;
    }

    @Override
    public FMat2 mulElWise(float r) {
        this.m00 = m00 * r;
        this.m01 = m01 * r;
        this.m10 = m10 * r;
        this.m11 = m11 * r;
        return this;
    }

    @Override
    public FMat2 divElWise(float r) {
        this.m00 = m00 / r;
        this.m01 = m01 / r;
        this.m10 = m10 / r;
        this.m11 = m11 / r;
        return this;
    }

    @Override
    public FMat2 predivElWise(float r) {
        this.m00 = r / this.m00;
        this.m01 = r / this.m01;
        this.m10 = r / this.m10;
        this.m11 = r / this.m11;
        return this;
    }

    public FMat2 from(FMatReadable mat) {
        this.extractFrom(mat);
        return this;
    }

    public FMat2 set00(float val) {
        this.m00 = val;
        return this;
    }

    public FMat2 set01(float val) {
        this.m01 = val;
        return this;
    }

    public FMat2 set10(float val) {
        this.m10 = val;
        return this;
    }

    public FMat2 set11(float val) {
        this.m11 = val;
        return this;
    }

    public FMat2 set(FMat2Readable mat) {
        this.m00 = mat.get00();
        this.m01 = mat.get01();
        this.m10 = mat.get10();
        this.m11 = mat.get11();
        return this;
    }

    public FMat2 set(float mat00, float mat01, float mat10, float mat11) {
        this.m00 = mat00;
        this.m01 = mat01;
        this.m10 = mat10;
        this.m11 = mat11;
        return this;
    }

    public FMat2 addElWise(FMat2Readable mat) {
        this.m00 = this.m00 + mat.get00();
        this.m01 = this.m01 + mat.get01();
        this.m10 = this.m10 + mat.get10();
        this.m11 = this.m11 + mat.get11();
        return this;
    }

    public FMat2 addElWise(float mat00, float mat01, float mat10, float mat11) {
        this.m00 = this.m00 + mat00;
        this.m01 = this.m01 + mat01;
        this.m10 = this.m10 + mat10;
        this.m11 = this.m11 + mat11;
        return this;
    }

    public FMat2 subElWise(FMat2Readable mat) {
        this.m00 = this.m00 - mat.get00();
        this.m01 = this.m01 - mat.get01();
        this.m10 = this.m10 - mat.get10();
        this.m11 = this.m11 - mat.get11();
        return this;
    }

    public FMat2 subElWise(float mat00, float mat01, float mat10, float mat11) {
        this.m00 = this.m00 - mat00;
        this.m01 = this.m01 - mat01;
        this.m10 = this.m10 - mat10;
        this.m11 = this.m11 - mat11;
        return this;
    }

    public FMat2 presubElWise(FMat2Readable mat) {
        this.m00 = mat.get00() - this.m00;
        this.m01 = mat.get01() - this.m01;
        this.m10 = mat.get10() - this.m10;
        this.m11 = mat.get11() - this.m11;
        return this;
    }

    public FMat2 presubElWise(float mat00, float mat01, float mat10, float mat11) {
        this.m00 = mat00 - this.m00;
        this.m01 = mat01 - this.m01;
        this.m10 = mat10 - this.m10;
        this.m11 = mat11 - this.m11;
        return this;
    }

    public FMat2 mulElWise(FMat2Readable mat) {
        this.m00 = this.m00 * mat.get00();
        this.m01 = this.m01 * mat.get01();
        this.m10 = this.m10 * mat.get10();
        this.m11 = this.m11 * mat.get11();
        return this;
    }

    public FMat2 mulElWise(float mat00, float mat01, float mat10, float mat11) {
        this.m00 = this.m00 * mat00;
        this.m01 = this.m01 * mat01;
        this.m10 = this.m10 * mat10;
        this.m11 = this.m11 * mat11;
        return this;
    }

    public FMat2 divElWise(FMat2Readable mat) {
        this.m00 = this.m00 / mat.get00();
        this.m01 = this.m01 / mat.get01();
        this.m10 = this.m10 / mat.get10();
        this.m11 = this.m11 / mat.get11();
        return this;
    }

    public FMat2 divElWise(float mat00, float mat01, float mat10, float mat11) {
        this.m00 = this.m00 / mat00;
        this.m01 = this.m01 / mat01;
        this.m10 = this.m10 / mat10;
        this.m11 = this.m11 / mat11;
        return this;
    }

    public FMat2 predivElWise(FMat2Readable mat) {
        this.m00 = mat.get00() / this.m00;
        this.m01 = mat.get01() / this.m01;
        this.m10 = mat.get10() / this.m10;
        this.m11 = mat.get11() / this.m11;
        return this;
    }

    public FMat2 predivElWise(float mat00, float mat01, float mat10, float mat11) {
        this.m00 = mat00 / this.m00;
        this.m01 = mat01 / this.m01;
        this.m10 = mat10 / this.m10;
        this.m11 = mat11 / this.m11;
        return this;
    }

    public FMat2 mul(FMat2Readable mat) {
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

    public FMat2 mul(float mat00, float mat01, float mat10, float mat11) {
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

    public FMat2 premul(FMat2Readable mat) {
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

    public FMat2 premul(float mat00, float mat01, float mat10, float mat11) {
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

    public FMat2 mulRotation2(float angle) {
        float cosA = (float) Math.cos(Math.toRadians(-angle));
        float sinA = (float) Math.sin(Math.toRadians(-angle));
        return this.mul(
            cosA, -sinA,
            sinA, cosA
        );
    }

    public FMat2 mulScale2(FVec2Readable v) {
        return mulScale2(v.getX(), v.getY());
    }

    public FMat2 mulScale2(float scaleX, float scaleY) {
        return this.mul(
            scaleX, 0,
            0, scaleY
        );
    }

    @Override
    public String toString() {
        return buildString();
    }

     // STATIC METHODS TO CONSTRUCT A MATRIX

     public static FMat2 newRotation2(float angle) {
        return new FMat2().mulRotation2(angle);
    }

    public static FMat2 newScale2(FVec2Readable scale) {
        return new FMat2().mulScale2(scale);
    }

    public static FMat2 newScale2(float scaleX, float scaleY) {
        return new FMat2().mulScale2(scaleX, scaleY);
    }

    
}
