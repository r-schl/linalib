package linalib.d.vector;

import java.nio.DoubleBuffer;

import linalib.d.matrix.DMat4;
import linalib.d.matrix.DMat4Readable;

public class DVec4 implements DVec4Readable, DVecWritable {
    
    
    public double x;
    public double y;
    public double z;
    public double w;

    private boolean isTransposed;

    public DVec4(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public DVec4(double[] arr) {
        this(arr[0], arr[1], arr[2], arr[3]);
    }

    public DVec4(double xyzw) {
        this(xyzw, xyzw, xyzw, xyzw);
    }

    public DVec4(DVec2Readable other, double z, double w) {
        this(other.getX(), other.getY(), z, w);
        if (other.isTransposed())
            this.transpose();
    }

    public DVec4(DVec3Readable other, double w) {
        this(other.getX(), other.getY(), other.getZ(), w);
        if (other.isTransposed())
            this.transpose();
    }

    public DVec4(DVec4Readable other) {
        this(other.getX(), other.getY(), other.getZ(), other.getW());
        if (other.isTransposed())
            this.transpose();
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public double getW() {
        return w;
    }

    @Override
    public double dot(DVec4Readable v) {
        return this.x * v.getX() + this.y * v.getY() + this.z * v.getZ() + this.w * v.getW();
    }

    @Override
    public double dot(double vX, double vY, double vZ, double vW) {
        return this.x * vX + this.y * vY + this.z * vZ + this.w * vW;
    }

    @Override
    public double len() {
        return (double) Math.sqrt(this.len2());
    }

    @Override
    public double len2() {
        return x * x + y * y + z * z + w * w;
    }

    @Override
    public double get(int i) {
        if (i == 0)
            return this.x;
        else if (i == 1)
            return this.y;
        else if (i == 2)
            return this.z;
        else if (i == 3)
            return this.w;
        else
            new Exception("Index out of range for vector dimension " + this.size());
        return -1;
    }

    @Override
    public boolean isVer() {
        return !isTransposed;
    }

    @Override
    public boolean isHor() {
        return isTransposed;
    }

    @Override
    public boolean isTransposed() {
        return isTransposed;
    }

    @Override
    public int size() {
        return 3;
    }

    @Override
    public double max() {
        double max = this.x;
        if (this.y > max)
            max = this.y;
        if (this.z > max)
            max = this.z;
        if (this.w > max)
            max = this.w;
        return max;
    }

    @Override
    public DVec4 storeInside(DoubleBuffer buf) {
        buf.put(x);
        buf.put(y);
        buf.put(z);
        buf.put(w);
        return this;
    }

    @Override
    public double[][] newArr2() {
        return this.isHor() ? new double[][] { { x, y, z, w } } : new double[][] { { x }, { y }, { z }, { w } };
    }

    @Override
    public double[] newArr() {
        return new double[] { x, y, z, w };
    }

    @Override
    public boolean contains(double r) {
        return this.x == r || this.y == r || this.z == r || this.w == r;
    }

    @Override
    public DVec4 set(int i, double val) {
        if (i == 0)
            this.x = val;
        else if (i == 1)
            this.y = val;
        else if (i == 2)
            this.z = val;
        else if (i == 3)
            this.w = val;
        return this;
    }

    @Override
    public DVec4 toInt() {
        this.x = (int) this.x;
        this.y = (int) this.y;
        this.z = (int) this.z;
        this.w = (int) this.w;
        return this;
    }

    @Override
    public DVec4 absElWise() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
        return this;
    }

    @Override
    public DVec4 add(double r) {
        this.x = this.x + r;
        this.y = this.y + r;
        this.z = this.z + r;
        this.w = this.w + r;
        return this;
    }

    @Override
    public DVec4 sub(double r) {
        this.x = this.x - r;
        this.y = this.y - r;
        this.z = this.z - r;
        this.w = this.w - r;
        return this;
    }

    @Override
    public DVec4 presub(double r) {
        this.x = r - this.x;
        this.y = r - this.y;
        this.z = r - this.z;
        this.w = r - this.w;
        return this;
    }

    @Override
    public DVec4 mul(double r) {
        this.x = this.x * r;
        this.y = this.y * r;
        this.z = this.z * r;
        this.w = this.w * r;
        return this;
    }

    @Override
    public DVec4 div(double r) {
        if (r == 0)
            throw new IllegalArgumentException("Cannot divide by 0");
        this.x = this.x / r;
        this.y = this.y / r;
        this.z = this.z / r;
        this.w = this.w / r;
        return this;
    }

    @Override
    public DVec4 prediv(double r) {
        if (this.contains(0))
            throw new IllegalArgumentException("Cannot divide by 0");
        this.x = r / this.x;
        this.y = r / this.y;
        this.z = r / this.z;
        this.w = r / this.w;
        return this;
    }

    @Override
    public DVec4 negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
        return this;
    }

    @Override
    public DVec4 floor(double r) {
        this.x = (this.x - (this.x % r));
        this.y = (this.y - (this.y % r));
        this.z = (this.z - (this.z % r));
        this.w = (this.w - (this.w % r));
        return this;
    }

    @Override
    public DVec4 round() {
        this.x = Math.round(x);
        this.y = Math.round(y);
        this.z = Math.round(z);
        this.w = Math.round(w);
        return this;
    }

    @Override
    public DVec4 normalize() {
        return this.div(this.len());
    }

    @Override
    public DVec4 flip() {
        if (this.isHor())
            return this.mul(DMat4.FLIP);
        return this.premul(DMat4.FLIP);
    }

    @Override
    public DVec4 transpose() {
        isTransposed = !isTransposed;
        return this;
    }

    public DVec4 setX(double val) {
        this.x = val;
        return this;
    }

    public DVec4 setY(double val) {
        this.y = val;
        return this;
    }

    public DVec4 setZ(double val) {
        this.z = val;
        return this;
    }

    public DVec4 setW(double val) {
        this.w = val;
        return this;
    }

    public DVec4 set(DVec4Readable v) {
        this.x = v.getX();
        this.y = v.getY();
        this.z = v.getZ();
        this.w = v.getW();
        return this;
    }

    public DVec4 set(double vX, double vY, double vZ, double vW) {
        this.x = vX;
        this.y = vY;
        this.z = vZ;
        this.w = vW;
        return this;
    }

    public DVec4 set(DVec3Readable v, double w) {
        return this.set(v.getX(), v.getY(), v.getZ(), w);
    }

    public DVec4 set(DVec2Readable v, double z, double w) {
        return this.set(v.getX(), v.getY(), z, w);
    }

    public DVec4 add(DVec4Readable v) {
        this.x = this.x + v.getX();
        this.y = this.y + v.getY();
        this.z = this.z + v.getZ();
        this.w = this.w + v.getW();
        return this;
    }

    public DVec4 add(double vX, double vY, double vZ, double vW) {
        this.x = this.x + vX;
        this.y = this.y + vY;
        this.z = this.z + vZ;
        this.w = this.w + vW;
        return this;
    }

    public DVec4 sub(DVec4Readable v) {
        this.x = this.x - v.getX();
        this.y = this.y - v.getY();
        this.z = this.z - v.getZ();
        this.w = this.w - v.getW();
        return this;
    }

    public DVec4 sub(double vX, double vY, double vZ, double vW) {
        this.x = this.x - vX;
        this.y = this.y - vY;
        this.z = this.z - vZ;
        this.w = this.w - vW;
        return this;
    }

    public DVec4 presub(DVec4Readable v) {
        this.x = v.getX() - this.x;
        this.y = v.getY() - this.y;
        this.z = v.getZ() - this.z;
        this.w = v.getW() - this.w;
        return this;
    }

    public DVec4 presub(double vX, double vY, double vZ, double vW) {
        this.x = vX - this.x;
        this.y = vY - this.y;
        this.z = vZ - this.z;
        this.w = vW - this.w;
        return this;
    }

    public DVec4 mul(DMat4Readable mat) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 3x3 matrix.").printStackTrace();
            System.exit(-1);
        }
        double x = this.x * mat.get00() + this.y * mat.get10() + this.z * mat.get20() + this.w * mat.get30();
        double y = this.x * mat.get01() + this.y * mat.get11() + this.z * mat.get21() + this.w * mat.get31();
        double z = this.x * mat.get02() + this.y * mat.get12() + this.z * mat.get22() + this.w * mat.get32();
        double w = this.x * mat.get03() + this.y * mat.get13() + this.z * mat.get23() + this.w * mat.get33();
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    public DVec4 mul(double mat00, double mat01, double mat02, double mat03, double mat10, double mat11, double mat12,
            double mat13, double mat20, double mat21, double mat22, double mat23, double mat30, double mat31, double mat32,
            double mat33) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 4x4 matrix.").printStackTrace();
            System.exit(-1);
        }
        double x = this.x * mat00 + this.y * mat10 + this.z * mat20 + this.w * mat30;
        double y = this.x * mat01 + this.y * mat11 + this.z * mat21 + this.w * mat31;
        double z = this.x * mat02 + this.y * mat12 + this.z * mat22 + this.w * mat32;
        double w = this.x * mat03 + this.y * mat13 + this.z * mat23 + this.w * mat33;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    public DVec4 premul(DMat4Readable mat) {
        if (isHor()) {
            new Exception("Cannot multiply a 4x4 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        double x = mat.get00() * this.x + mat.get01() * this.y + mat.get02() * this.z + mat.get03() * this.w;
        double y = mat.get10() * this.x + mat.get11() * this.y + mat.get12() * this.z + mat.get13() * this.w;
        double z = mat.get20() * this.x + mat.get21() * this.y + mat.get22() * this.z + mat.get23() * this.w;
        double w = mat.get30() * this.x + mat.get31() * this.y + mat.get32() * this.z + mat.get33() * this.w;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    public DVec4 premul(double mat00, double mat01, double mat02, double mat03, double mat10, double mat11, double mat12,
            double mat13, double mat20, double mat21, double mat22, double mat23, double mat30, double mat31, double mat32,
            double mat33) {
        if (isHor()) {
            new Exception("Cannot multiply a 4x4 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        double x = mat00 * this.x + mat01 * this.y + mat02 * this.z + mat03 * this.w;
        double y = mat10 * this.x + mat11 * this.y + mat12 * this.z + mat13 * this.w;
        double z = mat20 * this.x + mat21 * this.y + mat22 * this.z + mat23 * this.w;
        double w = mat30 * this.x + mat31 * this.y + mat32 * this.z + mat33 * this.w;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    public DVec4 swap(DVec4 v) {
        double tempX = this.x;
        double tempY = this.y;
        double tempZ = this.z;
        double tempW = this.w;
        this.x = v.getX();
        this.y = v.getY();
        this.z = v.getZ();
        this.w = v.getW();
        v.setX(tempX);
        v.setY(tempY);
        v.setZ(tempZ);
        v.setW(tempW);
        return this;
    }

    @Override
    public String toString() {
        return (this.isHor() ? "hor" : "ver") + "(" + this.x + " " + this.y + " " + this.z + " " + this.w + ")";
    }

    public DVec4 to(DVecWritable v) {
        this.extractTo(v);
        return this;
    }

    public DVec4 from(DVecReadable v) {
        this.extractFrom(v);
        return this;
    }

    public boolean equals(Object o) {
        if (o instanceof DVec4Readable) {
            DVec4Readable vec = (DVec4Readable) o;
            return this.x == vec.getX() && this.y == vec.getY() && this.z == vec.getZ() && this.w == vec.getW();
        }
        return false;
    }

}
