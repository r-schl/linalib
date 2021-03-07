package linalib.dbl;

import java.nio.DoubleBuffer;

public class DMat4 implements DMat4Readable, DMatWritable {

    public static final DMat4Readable IDENTITY = new DMat4(
        1, 0, 0, 0,
        0, 1, 0, 0,
        0, 0, 1, 0,
        0, 0, 0, 1
    );

    public static final DMat4Readable FLIP = new DMat4(
        0, 0, 0, 1,
        0, 0, 1, 0,
        0, 1, 0, 0,
        1, 0, 0, 0
    );

    public static final DMat4Readable ZEROS = new DMat4(
        0, 0, 0, 0,
        0, 0, 0, 0,
        0, 0, 0, 0,
        0, 0, 0, 0
    );

    public static final DMat4Readable ONES = new DMat4(
        1, 1, 1, 1,
        1, 1, 1, 1,
        1, 1, 1, 1,
        1, 1, 1, 1
    );

    public double m00, m01, m02, m03;
    public double m10, m11, m12, m13;
    public double m20, m21, m22, m23;
    public double m30, m31, m32, m33;

    private final int rowCount = 4;
    private final int colCount = 4;

    public DMat4() {
        this.set(IDENTITY);
    }

    public DMat4(double m00, double m01, double m02, double m03,
                  double m10, double m11, double m12, double m13,
                  double m20, double m21, double m22, double m23,
                  double m30, double m31, double m32, double m33) {
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

    public DMat4(DMat4Readable other) {
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
    public double get00() {
        return m00;
    }

    @Override
    public double get01() {
        return m01;
    }

    @Override
    public double get02() {
        return m02;
    }

    @Override
    public double get03() {
        return m03;
    }

    @Override
    public double get10() {
        return m10;
    }

    @Override
    public double get11() {
        return m11;
    }

    @Override
    public double get12() {
        return m12;
    }

    @Override
    public double get13() {
        return m13;
    }

    @Override
    public double get20() {
        return m20;
    }

    @Override
    public double get21() {
        return m21;
    }

    @Override
    public double get22() {
        return m22;
    }

    @Override
    public double get23() {
        return m23;
    }

    @Override
    public double get30() {
        return m30;
    }

    @Override
    public double get31() {
        return m31;
    }

    @Override
    public double get32() {
        return m32;
    }

    @Override
    public double get33() {
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
    public double get(int r, int c) {
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
    public double[] newArr() {
        return new double[] {
            m00, m01, m02, m03,
            m10, m11, m12, m13,
            m20, m21, m22, m23,
            m30, m31, m32, m33
        };
    }

    @Override
    public double[][] newArr2() {
        return new double[][]{
            {m00, m01, m02, m03},
            {m10, m11, m12, m13},
            {m20, m21, m22, m23},
            {m30, m31, m32, m33}
        };
    }

    @Override
    public DMat4 storeInside(DoubleBuffer buf) {
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
    public DMat4 to(DMatWritable mat) {
        this.extractTo(mat);
        return this;
    }

    @Override
    public DMat4 transpose() {
        double tm01 = m01;
        m01 = m10;
        double tm02 = m02;
        m02 = m20;
        double tm03 = m03;
        m03 = m30;
        m10 = tm01;
        double tm12 = m12;
        m12 = m21;
        double tm13 = m13;
        m13 = m31;
        m20 = tm02;
        m21 = tm12;
        double tm23 = m23;
        m23 = m32;
        m30 = tm03;
        m31 = tm13;
        m32 = tm23;
        return this;
    }

    @Override
    public DMat4 flipHor() {
        return this.mul(DMat4.FLIP);
    }

    @Override
    public DMat4 flipVer() {
        return this.premul(DMat4.FLIP);
    }

    @Override
    public DMat4 set(int r, int c, double val) {
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
    public DMat4 roundElWise() {
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
    public DMat4 floorElWise(double r) {       
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
    public DMat4 negateElWise() {
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
    public DMat4 toInt() {
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
    public DMat4 absElWise() {
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
    public DMat4 addElWise(double r) {
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
    public DMat4 subElWise(double r) {
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
    public DMat4 presubElWise(double r) {
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
    public DMat4 mulElWise(double r) {
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
    public DMat4 divElWise(double r) {
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
    public DMat4 predivElWise(double r) {
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
    public DMat4 from(DMatReadable mat) {
        this.extractFrom(mat);
        return this;
    }

    public DMat4 set00(double val) {
        this.m00 = val;
        return this;
    }

    public DMat4 set01(double val) {
        this.m01 = val;
        return this;
    }

    public DMat4 set02(double val) {
        this.m02 = val;
        return this;
    }

    public DMat4 set03(double val) {
        this.m03 = val;
        return this;
    }

    public DMat4 set10(double val) {
        this.m10 = val;
        return this;
    }

    public DMat4 set11(double val) {
        this.m11 = val;
        return this;
    }

    public DMat4 set12(double val) {
        this.m12 = val;
        return this;
    }

    public DMat4 set13(double val) {
        this.m13 = val;
        return this;
    }

    public DMat4 set20(double val) {
        this.m20 = val;
        return this;
    }

    public DMat4 set21(double val) {
        this.m21 = val;
        return this;
    }

    public DMat4 set22(double val) {
        this.m22 = val;
        return this;
    }

    public DMat4 set23(double val) {
        this.m23 = val;
        return this;
    }

    public DMat4 set30(double val) {
        this.m30 = val;
        return this;
    }

    public DMat4 set31(double val) {
        this.m31 = val;
        return this;
    }

    public DMat4 set32(double val) {
        this.m32 = val;
        return this;
    }

    public DMat4 set33(double val) {
        this.m33 = val;
        return this;
    }

    public DMat4 set(DMat4Readable mat) {
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

    public DMat4 set(double mat00, double mat01, double mat02, double mat03,
    double mat10, double mat11, double mat12, double mat13,
    double mat20, double mat21, double mat22, double mat23,
    double mat30, double mat31, double mat32, double mat33) {
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

    public DMat4 addElWise(DMat4Readable mat) {
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

    public DMat4 addElWise(double mat00, double mat01, double mat02, double mat03, double mat10, double mat11,
            double mat12, double mat13, double mat20, double mat21, double mat22, double mat23, double mat30, double mat31,
            double mat32, double mat33) {
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

    public DMat4 subElWise(DMat4Readable mat) {
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

    public DMat4 subElWise(double mat00, double mat01, double mat02, double mat03, double mat10, double mat11,
            double mat12, double mat13, double mat20, double mat21, double mat22, double mat23, double mat30, double mat31,
            double mat32, double mat33) {
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

    public DMat4 presubElWise(DMat4Readable mat) {
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

    public DMat4 presubElWise(double mat00, double mat01, double mat02, double mat03, double mat10, double mat11,
            double mat12, double mat13, double mat20, double mat21, double mat22, double mat23, double mat30, double mat31,
            double mat32, double mat33) {
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

    public DMat4 mulElWise(DMat4Readable mat) {
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

    public DMat4 mulElWise(double mat00, double mat01, double mat02, double mat03, double mat10, double mat11,
            double mat12, double mat13, double mat20, double mat21, double mat22, double mat23, double mat30, double mat31,
            double mat32, double mat33) {
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

    public DMat4 divElWise(DMat4Readable mat) {
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

    public DMat4 divElWise(double mat00, double mat01, double mat02, double mat03, double mat10, double mat11,
            double mat12, double mat13, double mat20, double mat21, double mat22, double mat23, double mat30, double mat31,
            double mat32, double mat33) {
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

    public DMat4 predivElWise(DMat4Readable mat) {
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

    public DMat4 predivElWise(double mat00, double mat01, double mat02, double mat03, double mat10, double mat11,
            double mat12, double mat13, double mat20, double mat21, double mat22, double mat23, double mat30, double mat31,
            double mat32, double mat33) {
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

    public DMat4 mul(DMat4Readable mat) {
        // row 1
        double m00 = this.m00 * mat.get00() + this.m01 * mat.get10() + this.m02 * mat.get20() + this.m03 * mat.get30();
        double m01 = this.m00 * mat.get01() + this.m01 * mat.get11() + this.m02 * mat.get21() + this.m03 * mat.get31();
        double m02 = this.m00 * mat.get02() + this.m01 * mat.get12() + this.m02 * mat.get22() + this.m03 * mat.get32();
        double m03 = this.m00 * mat.get03() + this.m01 * mat.get13() + this.m02 * mat.get23() + this.m03 * mat.get33();
        // row 2
        double m10 = this.m10 * mat.get00() + this.m11 * mat.get10() + this.m12 * mat.get20() + this.m13 * mat.get30();
        double m11 = this.m10 * mat.get01() + this.m11 * mat.get11() + this.m12 * mat.get21() + this.m13 * mat.get31();
        double m12 = this.m10 * mat.get02() + this.m11 * mat.get12() + this.m12 * mat.get22() + this.m13 * mat.get32();
        double m13 = this.m10 * mat.get03() + this.m11 * mat.get13() + this.m12 * mat.get23() + this.m13 * mat.get33();
        // row 3
        double m20 = this.m20 * mat.get00() + this.m21 * mat.get10() + this.m22 * mat.get20() + this.m23 * mat.get30();
        double m21 = this.m20 * mat.get01() + this.m21 * mat.get11() + this.m22 * mat.get21() + this.m23 * mat.get31();
        double m22 = this.m20 * mat.get02() + this.m21 * mat.get12() + this.m22 * mat.get22() + this.m23 * mat.get32();
        double m23 = this.m20 * mat.get03() + this.m21 * mat.get13() + this.m22 * mat.get23() + this.m23 * mat.get33();
        // row 4
        double m30 = this.m30 * mat.get00() + this.m31 * mat.get10() + this.m32 * mat.get20() + this.m33 * mat.get30();
        double m31 = this.m30 * mat.get01() + this.m31 * mat.get11() + this.m32 * mat.get21() + this.m33 * mat.get31();
        double m32 = this.m30 * mat.get02() + this.m31 * mat.get12() + this.m32 * mat.get22() + this.m33 * mat.get32();
        double m33 = this.m30 * mat.get03() + this.m31 * mat.get13() + this.m32 * mat.get23() + this.m33 * mat.get33();
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

    public DMat4 mul(double mat00, double mat01, double mat02, double mat03, double mat10, double mat11, double mat12,
            double mat13, double mat20, double mat21, double mat22, double mat23, double mat30, double mat31, double mat32,
            double mat33) {
        // row 1
        double m00 = this.m00 * mat00 + this.m01 * mat10 + this.m02 * mat20 + this.m03 * mat30;
        double m01 = this.m00 * mat01 + this.m01 * mat11 + this.m02 * mat21 + this.m03 * mat31;
        double m02 = this.m00 * mat02 + this.m01 * mat12 + this.m02 * mat22 + this.m03 * mat32;
        double m03 = this.m00 * mat03 + this.m01 * mat13 + this.m02 * mat23 + this.m03 * mat33;
        // row 2
        double m10 = this.m10 * mat00 + this.m11 * mat10 + this.m12 * mat20 + this.m13 * mat30;
        double m11 = this.m10 * mat01 + this.m11 * mat11 + this.m12 * mat21 + this.m13 * mat31;
        double m12 = this.m10 * mat02 + this.m11 * mat12 + this.m12 * mat22 + this.m13 * mat32;
        double m13 = this.m10 * mat03 + this.m11 * mat13 + this.m12 * mat23 + this.m13 * mat33;
        // row 3
        double m20 = this.m20 * mat00 + this.m21 * mat10 + this.m22 * mat20 + this.m23 * mat30;
        double m21 = this.m20 * mat01 + this.m21 * mat11 + this.m22 * mat21 + this.m23 * mat31;
        double m22 = this.m20 * mat02 + this.m21 * mat12 + this.m22 * mat22 + this.m23 * mat32;
        double m23 = this.m20 * mat03 + this.m21 * mat13 + this.m22 * mat23 + this.m23 * mat33;
        // row 4
        double m30 = this.m30 * mat00 + this.m31 * mat10 + this.m32 * mat20 + this.m33 * mat30;
        double m31 = this.m30 * mat01 + this.m31 * mat11 + this.m32 * mat21 + this.m33 * mat31;
        double m32 = this.m30 * mat02 + this.m31 * mat12 + this.m32 * mat22 + this.m33 * mat32;
        double m33 = this.m30 * mat03 + this.m31 * mat13 + this.m32 * mat23 + this.m33 * mat33;
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

    public DMat4 premul(DMat4Readable mat) {
         // row 1
         double m00 = mat.get00() * this.m00 + mat.get01() * this.m10 + mat.get02() * this.m20 + mat.get03() * this.m30;
         double m01 = mat.get00() * this.m01 + mat.get01() * this.m11 + mat.get02() * this.m21 + mat.get03() * this.m31;
         double m02 = mat.get00() * this.m02 + mat.get01() * this.m12 + mat.get02() * this.m22 + mat.get03() * this.m32;
         double m03 = mat.get00() * this.m03 + mat.get01() * this.m13 + mat.get02() * this.m23 + mat.get03() * this.m33;
         // row 2
         double m10 = mat.get10() * this.m00 + mat.get11() * this.m10 + mat.get12() * this.m20 + mat.get13() * this.m30;
         double m11 = mat.get10() * this.m01 + mat.get11() * this.m11 + mat.get12() * this.m21 + mat.get13() * this.m31;
         double m12 = mat.get10() * this.m02 + mat.get11() * this.m12 + mat.get12() * this.m22 + mat.get13() * this.m32;
         double m13 = mat.get10() * this.m03 + mat.get11() * this.m13 + mat.get12() * this.m23 + mat.get13() * this.m33;
         // row 3
         double m20 = mat.get20() * this.m00 + mat.get21() * this.m10 + mat.get22() * this.m20 + mat.get23() * this.m30;
         double m21 = mat.get20() * this.m01 + mat.get21() * this.m11 + mat.get22() * this.m21 + mat.get23() * this.m31;
         double m22 = mat.get20() * this.m02 + mat.get21() * this.m12 + mat.get22() * this.m22 + mat.get23() * this.m32;
         double m23 = mat.get20() * this.m03 + mat.get21() * this.m13 + mat.get22() * this.m23 + mat.get23() * this.m33;
         // row 4
         double m30 = mat.get30() * this.m00 + mat.get31() * this.m10 + mat.get32() * this.m20 + mat.get33() * this.m30;
         double m31 = mat.get30() * this.m01 + mat.get31() * this.m11 + mat.get32() * this.m21 + mat.get33() * this.m31;
         double m32 = mat.get30() * this.m02 + mat.get31() * this.m12 + mat.get32() * this.m22 + mat.get33() * this.m32;
         double m33 = mat.get30() * this.m03 + mat.get31() * this.m13 + mat.get32() * this.m23 + mat.get33() * this.m33;
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

    public DMat4 premul(double mat00, double mat01, double mat02, double mat03, double mat10, double mat11,
            double mat12, double mat13, double mat20, double mat21, double mat22, double mat23, double mat30, double mat31,
            double mat32, double mat33) {
         // row 1
         double m00 = mat00 * this.m00 + mat01 * this.m10 + mat02 * this.m20 + mat03 * this.m30;
         double m01 = mat00 * this.m01 + mat01 * this.m11 + mat02 * this.m21 + mat03 * this.m31;
         double m02 = mat00 * this.m02 + mat01 * this.m12 + mat02 * this.m22 + mat03 * this.m32;
         double m03 = mat00 * this.m03 + mat01 * this.m13 + mat02 * this.m23 + mat03 * this.m33;
         // row 2
         double m10 = mat10 * this.m00 + mat11 * this.m10 + mat12 * this.m20 + mat13 * this.m30;
         double m11 = mat10 * this.m01 + mat11 * this.m11 + mat12 * this.m21 + mat13 * this.m31;
         double m12 = mat10 * this.m02 + mat11 * this.m12 + mat12 * this.m22 + mat13 * this.m32;
         double m13 = mat10 * this.m03 + mat11 * this.m13 + mat12 * this.m23 + mat13 * this.m33;
         // row 3
         double m20 = mat20 * this.m00 + mat21 * this.m10 + mat22 * this.m20 + mat23 * this.m30;
         double m21 = mat20 * this.m01 + mat21 * this.m11 + mat22 * this.m21 + mat23 * this.m31;
         double m22 = mat20 * this.m02 + mat21 * this.m12 + mat22 * this.m22 + mat23 * this.m32;
         double m23 = mat20 * this.m03 + mat21 * this.m13 + mat22 * this.m23 + mat23 * this.m33;
         // row 4
         double m30 = mat30 * this.m00 + mat31 * this.m10 + mat32 * this.m20 + mat33 * this.m30;
         double m31 = mat30 * this.m01 + mat31 * this.m11 + mat32 * this.m21 + mat33 * this.m31;
         double m32 = mat30 * this.m02 + mat31 * this.m12 + mat32 * this.m22 + mat33 * this.m32;
         double m33 = mat30 * this.m03 + mat31 * this.m13 + mat32 * this.m23 + mat33 * this.m33;
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

    public DMat4 mulRotation2(double angle) {
        double cosA = (double) Math.cos(Math.toRadians(-angle));
        double sinA = (double) Math.sin(Math.toRadians(-angle));
        return this.mul(
            cosA, -sinA, 0, 0,
            sinA, cosA, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1
        );
    }

    public DMat4 mulRot3AroundAxis(DVec3Readable axis, double angle) {
        return mulRot3AroundAxis(axis.getX(), axis.getY(), axis.getZ(), angle);
    }

    public DMat4 mulRot3AroundAxis(double axisX, double axisY, double axisZ, double angle) {
        double a = (double) Math.toRadians(angle);
        double sinA = (double) Math.sin(a);
        double cosA = (double) Math.cos(a);
        return this.mul(
            axisX * axisX * (1 - cosA) + cosA, axisX * axisY * (1 - cosA) - axisZ * sinA, axisX * axisZ * (1 - cosA) + axisY * sinA, 0,
            axisY * axisX * (1 - cosA) + axisZ * sinA, axisY * axisY * (1 - cosA) + cosA, axisY * axisZ * (1 - cosA) - axisX * sinA, 0,
            axisZ * axisX * (1 - cosA) - axisY * sinA, axisZ * axisY * (1 - cosA) + axisX * sinA, axisZ * axisZ * (1 - cosA) + cosA, 0,
            0, 0, 0, 1
        );
    }

    public DMat4 mulRot3AroundXAxis(double angle) {
        double cos = (double) Math.cos(Math.toRadians(angle));
        double sin = (double) Math.sin(Math.toRadians(angle));
        return this.mul(
            1, 0, 0, 0,
            0, cos, -sin, 0,
            0, sin, cos, 0,
            0, 0, 0, 1
        );
    }

    public DMat4 mulRot3AroundYAxis(double angle) {
        double cos = (double) Math.cos(Math.toRadians(angle));
        double sin = (double) Math.sin(Math.toRadians(angle));
        return this.mul(
            cos, 0, sin, 0,
            0, 1, 0, 0,
            -sin, 0, cos, 0,
            0, 0, 0, 1
        );
    }

    public DMat4 mulRot3AroundZAxis(double angle) {
        double cos = (double) Math.cos(Math.toRadians(angle));
        double sin = (double) Math.sin(Math.toRadians(angle));
        // rotation around z axis
        return this.mul(
            cos, -sin, 0, 0,
            sin, cos, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1
        );
    }

    public DMat4 mulRotation3(DVec3Readable forward, DVec3Readable up, DVec3Readable right) {
        return mulRotation3(forward.getX(), forward.getY(), forward.getZ(), up.getX(), up.getY(), up.getZ(), right.getX(), right.getY(), right.getZ());
    }

    public DMat4 mulRotation3(double fX, double fY, double fZ, double uX, double uY, double uZ, double rX, double rY, double rZ) {
        return this.mul(
            rX, rY, rZ, 0,
            uX, uY, uZ, 0,
            fX, fY, fZ, 0,
            0, 0, 0, 1
        );
    }

    public DMat4 mulRot3FromQuaternion(DQuaternionReadable q) {
        return mulRot3FromQuaternion(q.getW(), q.getX(), q.getY(), q.getZ());
    }

    public DMat4 mulRot3FromQuaternion(double qw, double qx, double qy, double qz) {
        // normalize the quaternion
        double len = (double) Math.sqrt(qw * qw + qx * qx + qy * qy + qz * qz);
        double w = qw / len;
        double x = qx / len;
        double y = qy / len;
        double z = qz / len;
        return this.mul(
            (1.0f - (2.0f * ((y * y) + (z * z)))), (2.0f * ((x * y) - (z * w))), (double) (2.0f * ((x * z) + (y * w))), 0,
            (2.0f * ((x * y) + (z * w))), (1.0f - (2.0f * ((x * x) + (z * z)))), (double) (2.0f * ((y * z) - (x * w))), 0,
            (double) (2.0f * ((x * z) - (y * w))), (double) (2.0f * ((y * z) + (x * w))), (double) (1.0f - (2.0f * ((x * x) + (y * y)))), 0,
            0, 0, 0, 1
        );
    }

    public DMat4 mulTranslation2(DVec2Readable v) {
        return mulTranslation2(v.getX(), v.getY());
    }

    public DMat4 mulTranslation2(double dX, double dY) {
        return this.mul(
            1, 0, 0, dX,
            0, 1, 0, dY,
            0, 0, 1, 0,
            0, 0, 0, 1
        );
    }

    public DMat4 mulTranslation3(DVec3Readable v) {
        return mulTranslation3(v.getX(), v.getY(), v.getZ());
    }

    public DMat4 mulTranslation3(double dX, double dY, double dZ) {
        return this.mul(
            1, 0, 0, dX,
            0, 1, 0, dY,
            0, 0, 1, dZ,
            0, 0, 0, 1
        );
    }

    public DMat4 mulScale2(DVec2Readable v) {
        return mulScale2(v.getX(), v.getY());
    }

    public DMat4 mulScale2(double scaleX, double scaleY) {
        return this.mul(
            scaleX, 0, 0, 0,
            0, scaleY, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1
        );
    }

    public DMat4 mulScale3(DVec3Readable v) {
        return mulScale3(v.getX(), v.getY(), v.getZ());
    }

    public DMat4 mulScale3(double scaleX, double scaleY, double scaleZ) {
        return this.mul(
            scaleX, 0, 0, 0,
            0, scaleY, 0, 0,
            0, 0, scaleZ, 0,
            0, 0, 0, 1
        );
    }

    public DMat4 mulScale4(DVec4Readable v) {
        return mulScale4(v.getX(), v.getY(), v.getZ(), v.getW());
    }

    public DMat4 mulScale4(double scaleX, double scaleY, double scaleZ, double scaleW) {
        return this.mul(
            scaleX, 0, 0, 0,
            0, scaleY, 0, 0,
            0, 0, scaleZ, 0,
            0, 0, 0, scaleW
        );
    }

    public DMat4 mulLookAt3(DVec3Readable pos, DVec3Readable tgt, DVec3Readable up) {
        return mulLookAt3(pos.getX(), pos.getY(), pos.getZ(), tgt.getX(), tgt.getY(), tgt.getZ(), up.getX(), up.getY(), up.getZ());
    }

    public DMat4 mulLookAt3(double posX, double posY, double posZ, double tgtX, double tgtY, double tgtZ, double upX, double upY, double upZ) {
        DVec3 zAxis = new DVec3(tgtX, tgtY, tgtZ).sub(posX, posY, posZ).normalize();
        DVec3 xAxis = new DVec3(upX, upY, upZ).cross(zAxis).normalize();
        DVec3 yAxis = new DVec3(zAxis).cross(xAxis);

        this.mul(
            xAxis.x, yAxis.x, zAxis.x, -posX,
            xAxis.y, yAxis.y, zAxis.y, -posY,
            xAxis.z, yAxis.z, zAxis.z, -posZ,
            0, 0, 0, 1
        );
        return this;
    }

    public DMat4 mulView3FromQuaternion(DVec3Readable p, DQuaternionReadable q) {
        return this.mulView3FromQuaternion(p.getX(), p.getY(), p.getZ(), q.getW(), q.getX(), q.getY(), q.getZ());
    }

    public DMat4 mulView3FromQuaternion(double pX, double pY, double pZ, double qw, double qx, double qy, double qz) {
        this.mulRot3FromQuaternion(qw, qx, qy, qz);
        double t03 = -(pX * this.m00 + pY * this.m10 + pZ * this.m20);
        double t13 = -(pX * this.m01 + pY * this.m11 + pZ * this.m21);
        double t23 = -(pX * this.m02 + pY * this.m12 + pZ * this.m22);
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
    public DMat4 mulPerspective3(double left, double right, double bottom, double top, double near, double far) {
        double l = left;
        double r = right;
        double b = bottom;
        double t = top;
        double n = near;
        double f = far;
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
    public DMat4 mulPerspective3Fov(double aspect, double near, double far, double fovY) {
        double tanHalfFov = (double) Math.tan(Math.toRadians(fovY / 2.0));
        double pWidth = (2 * near) / (1 / tanHalfFov);
        double pHeight = (2 * near) / (1 / tanHalfFov * aspect);
        double right = pWidth / 2;
        double left = -pWidth / 2;
        double top = pHeight / 2;
        double bottom = -pHeight / 2;
        return mulPerspective3(left, right, bottom, top, near, far);
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
    public DMat4 mulOrthographic3(double left, double right, double bottom, double top, double near, double far) {
        double l = left;
        double r = right;
        double b = bottom;
        double t = top;
        double n = near;
        double f = far;
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
    public DMat4 mulOblique3(double left, double right, double bottom, double top, double near, double far, double alpha, double beta) {
        double cosA = (double) Math.cos(Math.toRadians(alpha));
        double sinA = (double) Math.sin(Math.toRadians(alpha));
        double tanB = (double) Math.tan(Math.toRadians(beta));
        double sinB = (double) Math.sin(Math.toRadians(beta));
        return this.mulOrthographic3(left, right, bottom, top, near, far).mul(
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
    public DMat4 mulCabinet3(double left, double right, double bottom, double top, double near, double far, double angle) {
        return this.mulOblique3(left, right, bottom, top, near, far, angle, (double) Math.toDegrees(Math.atan(2)));
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
    public DMat4 mulCavalier3(double left, double right, double bottom, double top, double near, double far, double angle) {
        return this.mulOblique3(left, right, bottom, top, near, far, angle, (double) Math.toDegrees(Math.atan(1)));
    }


    @Override
    public String toString() {
        return this.buildString();
    }

    // STATIC METHODS TO CONSTRUCT A MATRIX

    public static DMat4 newRotation2(double angle) {
        return new DMat4(IDENTITY).mulRotation2(angle);
    }

    public static DMat4 newRot3AroundAxis(DVec3Readable axis, double angle) {
        return new DMat4(IDENTITY).mulRot3AroundAxis(axis, angle);
    }

    public static DMat4 newRot3AroundAxis(double axisX, double axisY, double axisZ, double angle) {
        return new DMat4(IDENTITY).mulRot3AroundAxis(axisX, axisY, axisZ, angle);
    }

    public static DMat4 newRot3AroundXAxis(double angle) {
        return new DMat4(IDENTITY).mulRot3AroundXAxis(angle);
    }

    public static DMat4 newRot3AroundYAxis(double angle) {
        return new DMat4(IDENTITY).mulRot3AroundYAxis(angle);
    }

    public static DMat4 newRot3AroundZAxis(double angle) {
        return new DMat4(IDENTITY).mulRot3AroundZAxis(angle);
    }

    public static DMat4 newRotation3(DVec3Readable forward, DVec3Readable up, DVec3Readable right) {
        return new DMat4(IDENTITY).mulRotation3(forward, up, right);
    }
    
    public static DMat4 newRotation3(double fX, double fY, double fZ, double uX, double uY, double uZ, double rX, double rY, double rZ) {
        return new DMat4(IDENTITY).mulRotation3(fX, fY, fZ, uX, uY, uZ, rX, rY, rZ);
    }

    public static DMat4 newRot3FromQuaternion(DQuaternionReadable q) {
        return new DMat4(IDENTITY).mulRot3FromQuaternion(q);
    }

    public static DMat4 newRot3FromQuaternion(double qw, double qx, double qy, double qz) {
        return new DMat4(IDENTITY).mulRot3FromQuaternion(qw, qx, qy, qz);
    }

    public static DMat4 newTranslation2(DVec2Readable translation) {
        return new DMat4(IDENTITY).mulTranslation2(translation);
    }

    public static DMat4 newTranslation2(double dX, double dY) {
        return new DMat4(IDENTITY).mulTranslation2(dX, dY);
    }

    public static DMat4 newTranslation3(DVec3Readable translation) {
        return new DMat4(IDENTITY).mulTranslation3(translation);
    }

    public static DMat4 newTranslation3(double dX, double dY, double dZ) {
        return new DMat4(IDENTITY).mulTranslation3(dX, dY, dZ);
    }

    public static DMat4 newScale2(DVec2Readable scale) {
        return new DMat4(IDENTITY).mulScale2(scale);
    }

    public static DMat4 newScale2(double scaleX, double scaleY) {
        return new DMat4(IDENTITY).mulScale2(scaleX, scaleY);
    }

    public static DMat4 newScale3(DVec3Readable scale) {
        return new DMat4(IDENTITY).mulScale3(scale);
    }

    public static DMat4 newScale3(double scaleX, double scaleY, double scaleZ) {
        return new DMat4(IDENTITY).mulScale3(scaleX, scaleY, scaleZ);
    }

    public static DMat4 newScale4(DVec4Readable scale) {
        return new DMat4(IDENTITY).mulScale4(scale);
    }

    public static DMat4 newScale4(double scaleX, double scaleY, double scaleZ, double scaleW) {
        return new DMat4(IDENTITY).mulScale4(scaleX, scaleY, scaleZ, scaleW);
    }

    public static DMat4 newLookAt3(DVec3Readable pos, DVec3Readable tgt, DVec3Readable up) {
        return new DMat4(IDENTITY).mulLookAt3(pos, tgt, up);
    }

    public static DMat4 newLookAt3(double posX, double posY, double posZ, double tgtX, double tgtY, double tgtZ, double upX, double upY, double upZ) {
        return new DMat4(IDENTITY).mulLookAt3(posX, posY, posZ, tgtX, tgtY, tgtZ, upX, upY, upZ);
    }

    public static DMat4 newView3FromQuaternion(DVec3Readable p, DQuaternionReadable q) {
        return new DMat4(IDENTITY).mulView3FromQuaternion(p, q);
    }

    public static DMat4 newView3FromQuaternion(double pX, double pY, double pZ, double qw, double qx, double qy, double qz) {
        return new DMat4(IDENTITY).mulView3FromQuaternion(pX, pY, pZ, qw, qx, qy, qz);
    }

    public static DMat4 newPerspective3(double l, double r, double b, double t, double n, double f) {
        return new DMat4(IDENTITY).mulPerspective3(l, r, b, t, n, f);
    }

    public static DMat4 newPerspective3Fov(double aspect, double near, double far, double fovY) {
        return new DMat4(IDENTITY).mulPerspective3Fov(aspect, near, far, fovY);
    }

    public static DMat4 newOrthographic3(double l, double r, double b, double t, double n, double f) {
        return new DMat4(IDENTITY).mulOrthographic3(l, r, b, t, n, f);
    }

    public static DMat4 newOblique3(double l, double r, double b, double t, double n, double f, double alpha, double beta) {
        return new DMat4(IDENTITY).mulOblique3(l, r, b, t, n, f, alpha, beta);
    }

    public static DMat4 newCabinet3(double l, double r, double b, double t, double n, double f, double angle) {
        return new DMat4(IDENTITY).mulCabinet3(l, r, b, t, n, f, angle);
    }

    public static DMat4 newCavalier3(double l, double r, double b, double t, double n, double f, double angle) {
        return new DMat4(IDENTITY).mulCavalier3(l, r, b, t, n, f, angle);
    }
    
}
