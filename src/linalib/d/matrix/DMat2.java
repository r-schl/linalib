package linalib.d.matrix;

import java.nio.DoubleBuffer;

import linalib.d.vector.DVec2Readable;

public class DMat2 implements DMat2Readable, DMatWritable {

    public static final DMat2 IDENTITY = new DMat2(1, 0, 0, 1);

    public static final DMat2 FLIP = new DMat2(0, 1, 1, 0);

    public double m00, m01;
    public double m10, m11;

    private final int rowCount = 2;
    private final int colCount = 2;

    public DMat2() {
        this.set(IDENTITY);
    }

    public DMat2(double m00, double m01, double m10, double m11) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
    }

    public DMat2(DMat2 other) {
        this.m00 = other.m00;
        this.m01 = other.m01;
        this.m10 = other.m10;
        this.m11 = other.m11;
    }

    @Override
    public double get00() {
        return this.m00;
    }

    @Override
    public double get01() {
        return this.m01;
    }

    @Override
    public double get10() {
        return this.m10;
    }

    @Override
    public double get11() {
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
    public double get(int r, int c) {
        if (r == 0 && c == 0) return m00;
        else if (r == 0 && c == 1) return m01;
        else if (r == 1 && c == 0) return m10;
        else if (r == 1 && c == 1) return m11;
        else throw new IllegalArgumentException("Row and/or column out of range " + rowCount() + "x" +  colCount() + ". " + r + " " + c);
    }

    @Override
    public double[] newArr() {
        return new double[] {
            m00, m01,
            m10, m11
        };
    }

    @Override
    public double[][] newArr2() {
        return new double[][] {
            {m00, m01},
            {m10, m11}
        };
    }

    @Override
    public DMat2 storeInside(DoubleBuffer buf) {
        buf.put(m00);
        buf.put(m01);
        buf.put(m10);
        buf.put(m11);
        return this;
    }

    @Override
    public DMat2 to(DMatWritable mat) {
        this.extractTo(mat);
        return this;
    }

    @Override
    public DMat2 transpose() {
        double tm01 = m01;
        m01 = m10;
        m10 = tm01;
        return null;
    }

    @Override
    public DMat2 flipHor() {
        return this.mul(DMat2.FLIP);
    }

    @Override
    public DMat2 flipVer() {
        return this.premul(DMat2.FLIP);
    }

    @Override
    public DMat2 set(int r, int c, double val) {
        if (r == 0 && c == 0) this.m00 = val;
        else if (r == 0 && c == 1) this.m01 = val;
        else if (r == 1 && c == 0) this.m10 = val;
        else if (r == 1 && c == 1) this.m11 = val;
        else throw new IllegalArgumentException("Row and/or column out of range " + rowCount() + "x" +  colCount() + ". " + r + " " + c);
        return this;
    }

    @Override
    public DMat2 roundElWise() {
        this.m00 = Math.round(this.m00);
        this.m01 = Math.round(this.m01);
        this.m10 = Math.round(this.m10);
        this.m11 = Math.round(this.m11);
        return this;
    }

    @Override
    public DMat2 floorElWise(double r) {
        this.m00 = (this.m00 - (this.m00 % r));
        this.m01 = (this.m01 - (this.m00 % r));
        this.m10 = (this.m10 - (this.m00 % r));
        this.m11 = (this.m11 - (this.m00 % r));
        return this;
    }

    @Override
    public DMat2 negateElWise() {
        this.m00 = -this.m00;
        this.m01 = -this.m01;
        this.m10 = -this.m10;
        this.m11 = -this.m11;
        return this;
    }

    @Override
    public DMat2 toInt() {
        this.m00 = (int) m00;
        this.m01 = (int) m01;
        this.m10 = (int) m10;
        this.m11 = (int) m11;
        return this;
    }

    @Override
    public DMat2 absElWise() {
        this.m00 = Math.abs(m00);
        this.m01 = Math.abs(m01);
        this.m10 = Math.abs(m10);
        this.m11 = Math.abs(m11);
        return this;
    }

    @Override
    public DMat2 addElWise(double r) {
        this.m00 = m00 + r;
        this.m01 = m01 + r;
        this.m10 = m10 + r;
        this.m11 = m11 + r;
        return this;
    }

    @Override
    public DMat2 subElWise(double r) {
        this.m00 = m00 - r;
        this.m01 = m01 - r;
        this.m10 = m10 - r;
        this.m11 = m11 - r;
        return this;
    }

    @Override
    public DMat2 presubElWise(double r) {
        this.m00 = r - this.m00;
        this.m01 = r - this.m01;
        this.m10 = r - this.m10;
        this.m11 = r - this.m11;
        return this;
    }

    @Override
    public DMat2 mulElWise(double r) {
        this.m00 = m00 * r;
        this.m01 = m01 * r;
        this.m10 = m10 * r;
        this.m11 = m11 * r;
        return this;
    }

    @Override
    public DMat2 divElWise(double r) {
        this.m00 = m00 / r;
        this.m01 = m01 / r;
        this.m10 = m10 / r;
        this.m11 = m11 / r;
        return this;
    }

    @Override
    public DMat2 predivElWise(double r) {
        this.m00 = r / this.m00;
        this.m01 = r / this.m01;
        this.m10 = r / this.m10;
        this.m11 = r / this.m11;
        return this;
    }

    public DMat2 from(DMatReadable mat) {
        this.extractFrom(mat);
        return this;
    }

    public DMat2 set00(double val) {
        this.m00 = val;
        return this;
    }

    public DMat2 set01(double val) {
        this.m01 = val;
        return this;
    }

    public DMat2 set10(double val) {
        this.m10 = val;
        return this;
    }

    public DMat2 set11(double val) {
        this.m11 = val;
        return this;
    }

    public DMat2 set(DMat2Readable mat) {
        this.m00 = mat.get00();
        this.m01 = mat.get01();
        this.m10 = mat.get10();
        this.m11 = mat.get11();
        return this;
    }

    public DMat2 set(double mat00, double mat01, double mat10, double mat11) {
        this.m00 = mat00;
        this.m01 = mat01;
        this.m10 = mat10;
        this.m11 = mat11;
        return this;
    }

    public DMat2 addElWise(DMat2Readable mat) {
        this.m00 = this.m00 + mat.get00();
        this.m01 = this.m01 + mat.get01();
        this.m10 = this.m10 + mat.get10();
        this.m11 = this.m11 + mat.get11();
        return this;
    }

    public DMat2 addElWise(double mat00, double mat01, double mat10, double mat11) {
        this.m00 = this.m00 + mat00;
        this.m01 = this.m01 + mat01;
        this.m10 = this.m10 + mat10;
        this.m11 = this.m11 + mat11;
        return this;
    }

    public DMat2 subElWise(DMat2Readable mat) {
        this.m00 = this.m00 - mat.get00();
        this.m01 = this.m01 - mat.get01();
        this.m10 = this.m10 - mat.get10();
        this.m11 = this.m11 - mat.get11();
        return this;
    }

    public DMat2 subElWise(double mat00, double mat01, double mat10, double mat11) {
        this.m00 = this.m00 - mat00;
        this.m01 = this.m01 - mat01;
        this.m10 = this.m10 - mat10;
        this.m11 = this.m11 - mat11;
        return this;
    }

    public DMat2 presubElWise(DMat2Readable mat) {
        this.m00 = mat.get00() - this.m00;
        this.m01 = mat.get01() - this.m01;
        this.m10 = mat.get10() - this.m10;
        this.m11 = mat.get11() - this.m11;
        return this;
    }

    public DMat2 presubElWise(double mat00, double mat01, double mat10, double mat11) {
        this.m00 = mat00 - this.m00;
        this.m01 = mat01 - this.m01;
        this.m10 = mat10 - this.m10;
        this.m11 = mat11 - this.m11;
        return this;
    }

    public DMat2 mulElWise(DMat2Readable mat) {
        this.m00 = this.m00 * mat.get00();
        this.m01 = this.m01 * mat.get01();
        this.m10 = this.m10 * mat.get10();
        this.m11 = this.m11 * mat.get11();
        return this;
    }

    public DMat2 mulElWise(double mat00, double mat01, double mat10, double mat11) {
        this.m00 = this.m00 * mat00;
        this.m01 = this.m01 * mat01;
        this.m10 = this.m10 * mat10;
        this.m11 = this.m11 * mat11;
        return this;
    }

    public DMat2 divElWise(DMat2Readable mat) {
        this.m00 = this.m00 / mat.get00();
        this.m01 = this.m01 / mat.get01();
        this.m10 = this.m10 / mat.get10();
        this.m11 = this.m11 / mat.get11();
        return this;
    }

    public DMat2 divElWise(double mat00, double mat01, double mat10, double mat11) {
        this.m00 = this.m00 / mat00;
        this.m01 = this.m01 / mat01;
        this.m10 = this.m10 / mat10;
        this.m11 = this.m11 / mat11;
        return this;
    }

    public DMat2 predivElWise(DMat2Readable mat) {
        this.m00 = mat.get00() / this.m00;
        this.m01 = mat.get01() / this.m01;
        this.m10 = mat.get10() / this.m10;
        this.m11 = mat.get11() / this.m11;
        return this;
    }

    public DMat2 predivElWise(double mat00, double mat01, double mat10, double mat11) {
        this.m00 = mat00 / this.m00;
        this.m01 = mat01 / this.m01;
        this.m10 = mat10 / this.m10;
        this.m11 = mat11 / this.m11;
        return this;
    }

    public DMat2 mul(DMat2Readable mat) {
        double m00 = this.m00 * mat.get00() + this.m01 * mat.get10();
        double m01 = this.m00 * mat.get01() + this.m01 * mat.get11();
        double m10 = this.m10 * mat.get00() + this.m11 * mat.get10();
        double m11 = this.m10 * mat.get01() + this.m11 * mat.get11();
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
        return this;
    }

    public DMat2 mul(double mat00, double mat01, double mat10, double mat11) {
        double m00 = this.m00 * mat00 + this.m01 * mat10;
        double m01 = this.m00 * mat01 + this.m01 * mat11;
        double m10 = this.m10 * mat00 + this.m11 * mat10;
        double m11 = this.m10 * mat01 + this.m11 * mat11;
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
        return this;
    }

    public DMat2 premul(DMat2Readable mat) {
        double m00 = mat.get00() * this.m00 + mat.get01() * this.m10;
        double m01 = mat.get00() * this.m01 + mat.get01() * this.m11;
        double m10 = mat.get10() * this.m00 + mat.get11() * this.m10;
        double m11 = mat.get10() * this.m01 + mat.get11() * this.m11;
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
        return this;
    }

    public DMat2 premul(double mat00, double mat01, double mat10, double mat11) {
        double m00 = mat00 * this.m00 + mat01 * this.m10;
        double m01 = mat00 * this.m01 + mat01 * this.m11;
        double m10 = mat10 * this.m00 + mat11 * this.m10;
        double m11 = mat10 * this.m01 + mat11 * this.m11;
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
        return this;
    }

    public DMat2 mulRotation2(double angle) {
        double cosA = (double) Math.cos(Math.toRadians(-angle));
        double sinA = (double) Math.sin(Math.toRadians(-angle));
        return this.mul(
            cosA, -sinA,
            sinA, cosA
        );
    }

    public DMat2 mulScale2(DVec2Readable v) {
        return mulScale2(v.getX(), v.getY());
    }

    public DMat2 mulScale2(double scaleX, double scaleY) {
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

     public static DMat2 newRotation2(double angle) {
        return new DMat2().mulRotation2(angle);
    }

    public static DMat2 newScale2(DVec2Readable scale) {
        return new DMat2().mulScale2(scale);
    }

    public static DMat2 newScale2(double scaleX, double scaleY) {
        return new DMat2().mulScale2(scaleX, scaleY);
    }

    
}
