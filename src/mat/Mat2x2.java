package mat;

import java.nio.FloatBuffer;

import vec.Vec2Readable;

public class Mat2x2 implements Mat2x2Writable {

    public static final Mat2x2 IDENTITY = new Mat2x2(1, 0, 0, 1);

    public static final Mat2x2 FLIP = new Mat2x2(0, 1, 1, 0);

    public float m00, m01;
    public float m10, m11;

    private final int rowCount = 2;
    private final int colCount = 2;

    public Mat2x2() {
        this.set(IDENTITY);
    }

    public Mat2x2(float m00, float m01, float m10, float m11) {
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
    public Mat2x2 storeInside(FloatBuffer buf) {
        buf.put(m00);
        buf.put(m01);
        buf.put(m10);
        buf.put(m11);
        return this;
    }

    @Override
    public Mat2x2 to(MatWritable mat) {
        this.extractTo(mat);
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
    public Mat2x2 flipHor() {
        return this.mul(Mat2x2.FLIP);
    }

    @Override
    public Mat2x2 flipVer() {
        return this.mulRvs(Mat2x2.FLIP);
    }

    @Override
    public Mat2x2 set(int r, int c, float val) {
        if (r == 0 && c == 0) this.m00 = val;
        else if (r == 0 && c == 1) this.m01 = val;
        else if (r == 1 && c == 0) this.m10 = val;
        else if (r == 1 && c == 1) this.m11 = val;
        else throw new IllegalArgumentException("Row and/or column out of range " + rowCount() + "x" +  colCount() + ". " + r + " " + c);
        return this;
    }

    @Override
    public Mat2x2 roundElWise() {
        this.m00 = Math.round(this.m00);
        this.m01 = Math.round(this.m01);
        this.m10 = Math.round(this.m10);
        this.m11 = Math.round(this.m11);
        return this;
    }

    @Override
    public Mat2x2 floorElWise(float r) {
        this.m00 = (this.m00 - (this.m00 % r));
        this.m01 = (this.m01 - (this.m00 % r));
        this.m10 = (this.m10 - (this.m00 % r));
        this.m11 = (this.m11 - (this.m00 % r));
        return this;
    }

    @Override
    public Mat2x2 negateElWise() {
        this.m00 = -this.m00;
        this.m01 = -this.m01;
        this.m10 = -this.m10;
        this.m11 = -this.m11;
        return this;
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
    public Mat2x2 absElWise() {
        this.m00 = Math.abs(m00);
        this.m01 = Math.abs(m01);
        this.m10 = Math.abs(m10);
        this.m11 = Math.abs(m11);
        return this;
    }

    @Override
    public Mat2x2 addElWise(float r) {
        this.m00 = m00 + r;
        this.m01 = m01 + r;
        this.m10 = m10 + r;
        this.m11 = m11 + r;
        return this;
    }

    @Override
    public Mat2x2 subElWise(float r) {
        this.m00 = m00 - r;
        this.m01 = m01 - r;
        this.m10 = m10 - r;
        this.m11 = m11 - r;
        return this;
    }

    @Override
    public Mat2x2 subElWiseRvs(float r) {
        this.m00 = r - this.m00;
        this.m01 = r - this.m01;
        this.m10 = r - this.m10;
        this.m11 = r - this.m11;
        return this;
    }

    @Override
    public Mat2x2 mulElWise(float r) {
        this.m00 = m00 * r;
        this.m01 = m01 * r;
        this.m10 = m10 * r;
        this.m11 = m11 * r;
        return this;
    }

    @Override
    public Mat2x2 divElWise(float r) {
        this.m00 = m00 / r;
        this.m01 = m01 / r;
        this.m10 = m10 / r;
        this.m11 = m11 / r;
        return this;
    }

    @Override
    public Mat2x2 divElWiseRvs(float r) {
        this.m00 = r / this.m00;
        this.m01 = r / this.m01;
        this.m10 = r / this.m10;
        this.m11 = r / this.m11;
        return this;
    }

    @Override
    public Mat2x2 from(MatReadable mat) {
        this.extractFrom(mat);
        return this;
    }

    @Override
    public Mat2x2 set00(float val) {
        this.m00 = val;
        return this;
    }

    @Override
    public Mat2x2 set01(float val) {
        this.m01 = val;
        return this;
    }

    @Override
    public Mat2x2 set10(float val) {
        this.m10 = val;
        return this;
    }

    @Override
    public Mat2x2 set11(float val) {
        this.m11 = val;
        return this;
    }

    @Override
    public Mat2x2 set(Mat2x2Writable mat) {
        this.m00 = mat.get00();
        this.m01 = mat.get01();
        this.m10 = mat.get10();
        this.m11 = mat.get11();
        return this;
    }

    @Override
    public Mat2x2 set(float mat00, float mat01, float mat10, float mat11) {
        this.m00 = mat00;
        this.m01 = mat01;
        this.m10 = mat10;
        this.m11 = mat11;
        return this;
    }

    @Override
    public Mat2x2 addElWise(Mat2x2Readable mat) {
        this.m00 = this.m00 + mat.get00();
        this.m01 = this.m01 + mat.get01();
        this.m10 = this.m10 + mat.get10();
        this.m11 = this.m11 + mat.get11();
        return this;
    }

    @Override
    public Mat2x2 addElWise(float mat00, float mat01, float mat10, float mat11) {
        this.m00 = this.m00 + mat00;
        this.m01 = this.m01 + mat01;
        this.m10 = this.m10 + mat10;
        this.m11 = this.m11 + mat11;
        return this;
    }

    @Override
    public Mat2x2 subElWise(Mat2x2Readable mat) {
        this.m00 = this.m00 - mat.get00();
        this.m01 = this.m01 - mat.get01();
        this.m10 = this.m10 - mat.get10();
        this.m11 = this.m11 - mat.get11();
        return this;
    }

    @Override
    public Mat2x2 subElWise(float mat00, float mat01, float mat10, float mat11) {
        this.m00 = this.m00 - mat00;
        this.m01 = this.m01 - mat01;
        this.m10 = this.m10 - mat10;
        this.m11 = this.m11 - mat11;
        return this;
    }

    @Override
    public Mat2x2 subElWiseRvs(Mat2x2Readable mat) {
        this.m00 = mat.get00() - this.m00;
        this.m01 = mat.get01() - this.m01;
        this.m10 = mat.get10() - this.m10;
        this.m11 = mat.get11() - this.m11;
        return this;
    }

    @Override
    public Mat2x2 subElWiseRvs(float mat00, float mat01, float mat10, float mat11) {
        this.m00 = mat00 - this.m00;
        this.m01 = mat01 - this.m01;
        this.m10 = mat10 - this.m10;
        this.m11 = mat11 - this.m11;
        return this;
    }

    @Override
    public Mat2x2 mulElWise(Mat2x2Readable mat) {
        this.m00 = this.m00 * mat.get00();
        this.m01 = this.m01 * mat.get01();
        this.m10 = this.m10 * mat.get10();
        this.m11 = this.m11 * mat.get11();
        return this;
    }

    @Override
    public Mat2x2 mulElWise(float mat00, float mat01, float mat10, float mat11) {
        this.m00 = this.m00 * mat00;
        this.m01 = this.m01 * mat01;
        this.m10 = this.m10 * mat10;
        this.m11 = this.m11 * mat11;
        return this;
    }

    @Override
    public Mat2x2 divElWise(Mat2x2Readable mat) {
        this.m00 = this.m00 / mat.get00();
        this.m01 = this.m01 / mat.get01();
        this.m10 = this.m10 / mat.get10();
        this.m11 = this.m11 / mat.get11();
        return this;
    }

    @Override
    public Mat2x2 divElWise(float mat00, float mat01, float mat10, float mat11) {
        this.m00 = this.m00 / mat00;
        this.m01 = this.m01 / mat01;
        this.m10 = this.m10 / mat10;
        this.m11 = this.m11 / mat11;
        return this;
    }

    @Override
    public Mat2x2 divElWiseRvs(Mat2x2Readable mat) {
        this.m00 = mat.get00() / this.m00;
        this.m01 = mat.get01() / this.m01;
        this.m10 = mat.get10() / this.m10;
        this.m11 = mat.get11() / this.m11;
        return this;
    }

    @Override
    public Mat2x2 divElWiseRvs(float mat00, float mat01, float mat10, float mat11) {
        this.m00 = mat00 / this.m00;
        this.m01 = mat01 / this.m01;
        this.m10 = mat10 / this.m10;
        this.m11 = mat11 / this.m11;
        return this;
    }

    @Override
    public Mat2x2 mul(Mat2x2Readable mat) {
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

    @Override
    public Mat2x2 mul(float mat00, float mat01, float mat10, float mat11) {
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

    @Override
    public Mat2x2 mulRvs(Mat2x2Readable mat) {
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
    public Mat2x2 mulRvs(float mat00, float mat01, float mat10, float mat11) {
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

    @Override
    public Mat2x2 rotation2d(float angle) {
        float cosA = (float) Math.cos(Math.toRadians(-angle));
        float sinA = (float) Math.sin(Math.toRadians(-angle));
        return this.mul(
            cosA, -sinA,
            sinA, cosA
        );
    }

    @Override
    public Mat2x2 scale2d(Vec2Readable v) {
        return scale2d(v.getX(), v.getY());
    }

    @Override
    public Mat2x2 scale2d(float scaleX, float scaleY) {
        return this.mul(
            scaleX, 0,
            0, scaleY
        );
    }

    @Override
    public String toString() {
        return buildString();
    }
    
}
