package linalib.dbl;

import java.nio.DoubleBuffer;

public class DMat3 implements DMat3Readable, DMatWritable {

    public static final DMat3 IDENTITY = new DMat3(1, 0, 0, 0, 1, 0, 0, 0, 1);

    public static final DMat3 FLIP = new DMat3(0, 0, 1, 0, 1, 0, 1, 0, 0);

    public double m00, m01, m02;
    public double m10, m11, m12;
    public double m20, m21, m22;

    private final int rowCount = 3;
    private final int colCount = 3;

    public DMat3() {
        this.set(IDENTITY);
    }

    public DMat3(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22) {
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

    public DMat3(DMat3Readable other) {
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
    public double get00() {
        return this.m00;
    }

    @Override
    public double get01() {
        return this.m01;
    }

    @Override
    public double get02() {
        return this.m02;
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
    public double get12() {
        return this.m12;
    }

    @Override
    public double get20() {
        return this.m20;
    }

    @Override
    public double get21() {
        return this.m21;
    }

    @Override
    public double get22() {
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
    public double get(int r, int c) {
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
    public double[] newArr() {
        return new double[] {
            m00, m01, m02,
            m10, m11, m12,
            m20, m21, m22
        };
    }

    @Override
    public double[][] newArr2() {
        return new double[][] {
            {m00, m01, m02},
            {m10, m11, m12},
            {m20, m21, m22}
        };
    }

    @Override
    public DMat3 storeInside(DoubleBuffer buf) {
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
    public DMat3 to(DMatWritable mat) {
        this.extractTo(mat);
        return this;
    }

    @Override
    public DMat3 transpose() {
        double tm01 = m01;
        m01 = m10;
        double tm02 = m02;
        m02 = m20;
        m10 = tm01;
        double tm12 = m12;
        m12 = m21;
        m20 = tm02;
        m21 = tm12;
        return this;
    }

    @Override
    public DMat3 flipHor() {
        return this.mul(DMat3.FLIP);
    }

    @Override
    public DMat3 flipVer() {
        return this.premul(DMat3.FLIP);
    }

    @Override
    public DMat3 set(int r, int c, double val) {
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
    public DMat3 roundElWise() {
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
    public DMat3 floorElWise(double r) {
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
    public DMat3 negateElWise() {
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
    public DMat3 toInt() {
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
    public DMat3 absElWise() {
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
    public DMat3 addElWise(double r) {
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
    public DMat3 subElWise(double r) {
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
    public DMat3 presubElWise(double r) {
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
    public DMat3 mulElWise(double r) {
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
    public DMat3 divElWise(double r) {
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
    public DMat3 predivElWise(double r) {
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
    public DMat3 from(DMatReadable mat) {
        this.extractFrom(mat);
        return this;
    }

    public DMat3 set00(double val) {
        this.m00 = val;
        return this;
    }

    public DMat3 set01(double val) {
        this.m01 = val;
        return this;
    }

    public DMat3 set02(double val) {
        this.m02 = val;
        return this;
    }

    public DMat3 set10(double val) {
        this.m10 = val;
        return this;
    }

    public DMat3 set11(double val) {
        this.m11 = val;
        return this;
    }

    public DMat3 set12(double val) {
        this.m12 = val;
        return this;
    }

    public DMat3 set20(double val) {
        this.m20 = val;
        return this;
    }

    public DMat3 set21(double val) {
        this.m21 = val;
        return this;
    }

    public DMat3 set22(double val) {
        this.m22 = val;
        return this;
    }

    public DMat3 set(DMat3Readable mat) {
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

    public DMat3 set(double mat00, double mat01, double mat02,
    double mat10, double mat11, double mat12,
    double mat20, double mat21, double mat22) {
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

    public DMat3 addElWise(DMat3Readable mat) {
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

    public DMat3 addElWise(double mat00, double mat01, double mat02, double mat10, double mat11, double mat12,
            double mat20, double mat21, double mat22) {
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

    public DMat3 subElWise(DMat3Readable mat) {
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

    public DMat3 subElWise(double mat00, double mat01, double mat02, double mat10, double mat11, double mat12,
            double mat20, double mat21, double mat22) {
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

    public DMat3 presubElWise(DMat3Readable mat) {
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

    public DMat3 presubElWise(double mat00, double mat01, double mat02, double mat10, double mat11, double mat12,
            double mat20, double mat21, double mat22) {
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

    public DMat3 mulElWise(DMat3Readable mat) {
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

    public DMat3 mulElWise(double mat00, double mat01, double mat02, double mat10, double mat11, double mat12,
            double mat20, double mat21, double mat22) {
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

    public DMat3 divElWise(DMat3Readable mat) {
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

    public DMat3 divElWise(double mat00, double mat01, double mat02, double mat10, double mat11, double mat12,
            double mat20, double mat21, double mat22) {
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

    public DMat3 predivElWise(DMat3Readable mat) {
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

    public DMat3 predivElWise(double mat00, double mat01, double mat02, double mat10, double mat11, double mat12,
            double mat20, double mat21, double mat22) {
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

    public DMat3 mul(DMat3Readable mat) {
        double m00 = this.m00 * mat.get00() + this.m01 * mat.get10() + this.m02 * mat.get20();
        double m01 = this.m00 * mat.get01() + this.m01 * mat.get11() + this.m02 * mat.get21();
        double m02 = this.m00 * mat.get02() + this.m01 * mat.get12() + this.m02 * mat.get22();
        double m10 = this.m10 * mat.get00() + this.m11 * mat.get10() + this.m12 * mat.get20();
        double m11 = this.m10 * mat.get01() + this.m11 * mat.get11() + this.m12 * mat.get21();
        double m12 = this.m10 * mat.get02() + this.m11 * mat.get12() + this.m12 * mat.get22();
        double m20 = this.m20 * mat.get00() + this.m21 * mat.get10() + this.m22 * mat.get20();
        double m21 = this.m20 * mat.get01() + this.m21 * mat.get11() + this.m22 * mat.get21();
        double m22 = this.m20 * mat.get02() + this.m21 * mat.get12() + this.m22 * mat.get22();
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

    public DMat3 mul(double mat00, double mat01, double mat02, double mat10, double mat11, double mat12, double mat20,
            double mat21, double mat22) {
        double m00 = this.m00 * mat00 + this.m01 * mat10 + this.m02 * mat20;
        double m01 = this.m00 * mat01 + this.m01 * mat11 + this.m02 * mat21;
        double m02 = this.m00 * mat02 + this.m01 * mat12 + this.m02 * mat22;
        double m10 = this.m10 * mat00 + this.m11 * mat10 + this.m12 * mat20;
        double m11 = this.m10 * mat01 + this.m11 * mat11 + this.m12 * mat21;
        double m12 = this.m10 * mat02 + this.m11 * mat12 + this.m12 * mat22;
        double m20 = this.m20 * mat00 + this.m21 * mat10 + this.m22 * mat20;
        double m21 = this.m20 * mat01 + this.m21 * mat11 + this.m22 * mat21;
        double m22 = this.m20 * mat02 + this.m21 * mat12 + this.m22 * mat22;
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

    public DMat3 premul(DMat3Readable mat) {
        double m00 = mat.get00() * this.m00 + mat.get01() * this.m10 + mat.get02() * this.m20;
        double m01 = mat.get00() * this.m01 + mat.get01() * this.m11 + mat.get02() * this.m21;
        double m02 = mat.get00() * this.m02 + mat.get01() * this.m12 + mat.get02() * this.m22;
        double m10 = mat.get10() * this.m00 + mat.get11() * this.m10 + mat.get12() * this.m20;
        double m11 = mat.get10() * this.m01 + mat.get11() * this.m11 + mat.get12() * this.m21;
        double m12 = mat.get10() * this.m02 + mat.get11() * this.m12 + mat.get12() * this.m22;
        double m20 = mat.get20() * this.m00 + mat.get21() * this.m10 + mat.get22() * this.m20;
        double m21 = mat.get20() * this.m01 + mat.get21() * this.m11 + mat.get22() * this.m21;
        double m22 = mat.get20() * this.m02 + mat.get21() * this.m12 + mat.get22() * this.m22;
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

    public DMat3 premul(double mat00, double mat01, double mat02, double mat10, double mat11, double mat12,
            double mat20, double mat21, double mat22) {
        double m00 = mat00 * this.m00 + mat01 * this.m10 + mat02 * this.m20;
        double m01 = mat00 * this.m01 + mat01 * this.m11 + mat02 * this.m21;
        double m02 = mat00 * this.m02 + mat01 * this.m12 + mat02 * this.m22;
        double m10 = mat10 * this.m00 + mat11 * this.m10 + mat12 * this.m20;
        double m11 = mat10 * this.m01 + mat11 * this.m11 + mat12 * this.m21;
        double m12 = mat10 * this.m02 + mat11 * this.m12 + mat12 * this.m22;
        double m20 = mat20 * this.m00 + mat21 * this.m10 + mat22 * this.m20;
        double m21 = mat20 * this.m01 + mat21 * this.m11 + mat22 * this.m21;
        double m22 = mat20 * this.m02 + mat21 * this.m12 + mat22 * this.m22;
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

    public DMat3 mulRotation2(double angle) {
        double cosA = (double) Math.cos(Math.toRadians(-angle));
        double sinA = (double) Math.sin(Math.toRadians(-angle));
        return this.mul(
            cosA, -sinA, 0,
            sinA, cosA, 0,
            0,0,1
        );
    }

    public DMat3 mulRot3AroundAxis(DVec3Readable axis, double angle) {
        return mulRot3AroundAxis(axis.getX(), axis.getY(), axis.getZ(), angle);
    }

    public DMat3 mulRot3AroundAxis(double axisX, double axisY, double axisZ, double angle) {
        double a = (double) Math.toRadians(angle);
        double sinA = (double) Math.sin(a);
        double cosA = (double) Math.cos(a);
        return this.mul(
            axisX * axisX * (1 - cosA) + cosA, axisX * axisY * (1 - cosA) - axisZ * sinA, axisX * axisZ * (1 - cosA) + axisY * sinA,
            axisY * axisX * (1 - cosA) + axisZ * sinA, axisY * axisY * (1 - cosA) + cosA, axisY * axisZ * (1 - cosA) - axisX * sinA,
            axisZ * axisX * (1 - cosA) - axisY * sinA, axisZ * axisY * (1 - cosA) + axisX * sinA, axisZ * axisZ * (1 - cosA) + cosA
        );
    }

    public DMat3 mulRot3AroundXAxis(double angle) {
        double cos = (double) Math.cos(Math.toRadians(angle));
        double sin = (double) Math.sin(Math.toRadians(angle));
        return this.mul(
            1, 0, 0,
            0, cos, -sin,
            0, sin, cos
        );
    }

    public DMat3 mulRot3AroundYAxis(double angle) {
        double cos = (double) Math.cos(Math.toRadians(angle));
        double sin = (double) Math.sin(Math.toRadians(angle));
        return this.mul(
            cos, 0, sin,
            0, 1, 0,
            -sin, 0, cos
        );
    }

    public DMat3 mulRot3AroundZAxis(double angle) {
        double cos = (double) Math.cos(Math.toRadians(angle));
        double sin = (double) Math.sin(Math.toRadians(angle));
        // rotation around z axis
        return this.mul(
            cos, -sin, 0,
            sin, cos, 0, 
            0, 0, 1
        );
    }

    public DMat3 mulRotation3(DVec3Readable forward, DVec3Readable up, DVec3Readable right) {
        return mulRotation3(forward.getX(), forward.getY(), forward.getZ(), up.getX(), up.getY(), up.getZ(), right.getX(), right.getY(), right.getZ());
    }

    public DMat3 mulRotation3(double fX, double fY, double fZ, double uX, double uY, double uZ, double rX, double rY, double rZ) {
        return this.mul(
            rX, rY, rZ,
            uX, uY, uZ,
            fX, fY, fZ
        );
    }

    public DMat3 mulRot3FromQuaternion(DQuaternionReadable q) {
        return mulRot3FromQuaternion(q.getW(), q.getX(), q.getY(), q.getZ());
    }

    public DMat3 mulRot3FromQuaternion(double qw, double qx, double qy, double qz) {
        // normalize the quaternion
        double len = (double) Math.sqrt(qw * qw + qx * qx + qy * qy + qz * qz);
        double w = qw / len;
        double x = qx / len;
        double y = qy / len;
        double z = qz / len;

        return this.mul(
            (1.0 - (2.0 * ((y * y) + (z * z)))), (2.0 * ((x * y) - (z * w))), (double) (2.0 * ((x * z) + (y * w))),
            (2.0 * ((x * y) + (z * w))), (1.0 - (2.0 * ((x * x) + (z * z)))), (double) (2.0 * ((y * z) - (x * w))),
            (double) (2.0 * ((x * z) - (y * w))), (double) (2.0 * ((y * z) + (x * w))), (double) (1.0 - (2.0 * ((x * x) + (y * y))))
        );
    }

    public DMat3 mulTranslation2(DVec2Readable v) {
        return mulTranslation2(v.getX(), v.getY());
    }

    public DMat3 mulTranslation2(double dX, double dY) {
        return this.mul(
            1, 0, dX,
            0, 1, dY,
            0, 0, 1
        );
    }

    public DMat3 mulScale2(DVec2Readable v) {
        return mulScale2(v.getX(), v.getY());
    }

    public DMat3 mulScale2(double scaleX, double scaleY) {
        return this.mul(
            scaleX, 0, 0,
            0, scaleY, 0,
            0, 0, 1
        );
    }

    public DMat3 mulScale3(DVec3Readable v) {
        return mulScale3(v.getX(), v.getY(), v.getZ());
    }
    
    public DMat3 mulScale3(double scaleX, double scaleY, double scaleZ) {
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

    public static DMat3 newRotation2(double angle) {
        return new DMat3(IDENTITY).mulRotation2(angle);
    }

    public static DMat3 newRot3AroundAxis(DVec3Readable axis, double angle) {
        return new DMat3(IDENTITY).mulRot3AroundAxis(axis, angle);
    }

    public static DMat3 newRot3AroundAxis(double axisX, double axisY, double axisZ, double angle) {
        return new DMat3(IDENTITY).mulRot3AroundAxis(axisX, axisY, axisZ, angle);
    }

    public static DMat3 newRot3AroundXAxis(double angle) {
        return new DMat3(IDENTITY).mulRot3AroundXAxis(angle);
    }

    public static DMat3 newRot3AroundYAxis(double angle) {
        return new DMat3(IDENTITY).mulRot3AroundYAxis(angle);
    }

    public static DMat3 newRot3AroundZAxis(double angle) {
        return new DMat3(IDENTITY).mulRot3AroundZAxis(angle);
    }

    public static DMat3 newRotation3(DVec3Readable forward, DVec3Readable up, DVec3Readable right) {
        return new DMat3(IDENTITY).mulRotation3(forward, up, right);
    }
    
    public static DMat3 newRotation3(double fX, double fY, double fZ, double uX, double uY, double uZ, double rX, double rY, double rZ) {
        return new DMat3(IDENTITY).mulRotation3(fX, fY, fZ, uX, uY, uZ, rX, rY, rZ);
    }

    public static DMat3 newRot3FromQuaternion(DQuaternionReadable q) {
        return new DMat3(IDENTITY).mulRot3FromQuaternion(q);
    }

    public static DMat3 newRot3FromQuaternion(double qw, double qx, double qy, double qz) {
        return new DMat3(IDENTITY).mulRot3FromQuaternion(qw, qx, qy, qz);
    }

    public static DMat3 newTranslation2(DVec2Readable translation) {
        return new DMat3(IDENTITY).mulTranslation2(translation);
    }

    public static DMat3 newTranslation2(double dX, double dY) {
        return new DMat3(IDENTITY).mulTranslation2(dX, dY);
    }

    public static DMat3 newScale2(DVec2Readable scale) {
        return new DMat3(IDENTITY).mulScale2(scale);
    }

    public static DMat3 newScale2(double scaleX, double scaleY) {
        return new DMat3(IDENTITY).mulScale2(scaleX, scaleY);
    }

    public static DMat3 newScale3(DVec3Readable scale) {
        return new DMat3(IDENTITY).mulScale3(scale);
    }

    public static DMat3 newScale3(double scaleX, double scaleY, double scaleZ) {
        return new DMat3(IDENTITY).mulScale3(scaleX, scaleY, scaleZ);
    }

}
