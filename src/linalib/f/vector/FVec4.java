package linalib.f.vector;

import java.nio.FloatBuffer;

import linalib.f.matrix.FMat4;
import linalib.f.matrix.FMat4Readable;

public class FVec4 implements FVec4Readable, FVecWritable {

    public float x;
    public float y;
    public float z;
    public float w;

    private boolean isTransposed;

    public FVec4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public FVec4(float[] arr) {
        this(arr[0], arr[1], arr[2], arr[3]);
    }

    public FVec4(float xyzw) {
        this(xyzw, xyzw, xyzw, xyzw);
    }

    public FVec4(FVec2Readable other, float z, float w) {
        this(other.getX(), other.getY(), z, w);
        if (other.isTransposed())
            this.transpose();
    }

    public FVec4(FVec3Readable other, float w) {
        this(other.getX(), other.getY(), other.getZ(), w);
        if (other.isTransposed())
            this.transpose();
    }

    public FVec4(FVec4Readable other) {
        this(other.getX(), other.getY(), other.getZ(), other.getW());
        if (other.isTransposed())
            this.transpose();
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getZ() {
        return z;
    }

    @Override
    public float getW() {
        return w;
    }

    @Override
    public float dot(FVec4Readable v) {
        return this.x * v.getX() + this.y * v.getY() + this.z * v.getZ() + this.w * v.getW();
    }

    @Override
    public float dot(float vX, float vY, float vZ, float vW) {
        return this.x * vX + this.y * vY + this.z * vZ + this.w * vW;
    }

    @Override
    public float len() {
        return (float) Math.sqrt(this.len2());
    }

    @Override
    public float len2() {
        return x * x + y * y + z * z + w * w;
    }

    @Override
    public float get(int i) {
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
    public float max() {
        float max = this.x;
        if (this.y > max)
            max = this.y;
        if (this.z > max)
            max = this.z;
        if (this.w > max)
            max = this.w;
        return max;
    }

    @Override
    public FVec4 storeInside(FloatBuffer buf) {
        buf.put(x);
        buf.put(y);
        buf.put(z);
        buf.put(w);
        return this;
    }

    @Override
    public float[][] newArr2() {
        return this.isHor() ? new float[][] { { x, y, z, w } } : new float[][] { { x }, { y }, { z }, { w } };
    }

    @Override
    public float[] newArr() {
        return new float[] { x, y, z, w };
    }

    @Override
    public boolean contains(float r) {
        return this.x == r || this.y == r || this.z == r || this.w == r;
    }

    @Override
    public FVec4 set(int i, float val) {
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
    public FVec4 toInt() {
        this.x = (int) this.x;
        this.y = (int) this.y;
        this.z = (int) this.z;
        this.w = (int) this.w;
        return this;
    }

    @Override
    public FVec4 absElWise() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
        return this;
    }

    @Override
    public FVec4 add(float r) {
        this.x = this.x + r;
        this.y = this.y + r;
        this.z = this.z + r;
        this.w = this.w + r;
        return this;
    }

    @Override
    public FVec4 sub(float r) {
        this.x = this.x - r;
        this.y = this.y - r;
        this.z = this.z - r;
        this.w = this.w - r;
        return this;
    }

    @Override
    public FVec4 presub(float r) {
        this.x = r - this.x;
        this.y = r - this.y;
        this.z = r - this.z;
        this.w = r - this.w;
        return this;
    }

    @Override
    public FVec4 mul(float r) {
        this.x = this.x * r;
        this.y = this.y * r;
        this.z = this.z * r;
        this.w = this.w * r;
        return this;
    }

    @Override
    public FVec4 div(float r) {
        if (r == 0)
            throw new IllegalArgumentException("Cannot divide by 0");
        this.x = this.x / r;
        this.y = this.y / r;
        this.z = this.z / r;
        this.w = this.w / r;
        return this;
    }

    @Override
    public FVec4 prediv(float r) {
        if (this.contains(0))
            throw new IllegalArgumentException("Cannot divide by 0");
        this.x = r / this.x;
        this.y = r / this.y;
        this.z = r / this.z;
        this.w = r / this.w;
        return this;
    }

    @Override
    public FVec4 negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
        return this;
    }

    @Override
    public FVec4 floor(float r) {
        this.x = (this.x - (this.x % r));
        this.y = (this.y - (this.y % r));
        this.z = (this.z - (this.z % r));
        this.w = (this.w - (this.w % r));
        return this;
    }

    @Override
    public FVec4 round() {
        this.x = Math.round(x);
        this.y = Math.round(y);
        this.z = Math.round(z);
        this.w = Math.round(w);
        return this;
    }

    @Override
    public FVec4 normalize() {
        return this.div(this.len());
    }

    @Override
    public FVec4 flip() {
        if (this.isHor())
            return this.mul(FMat4.FLIP);
        return this.premul(FMat4.FLIP);
    }

    @Override
    public FVec4 transpose() {
        isTransposed = !isTransposed;
        return this;
    }

    public FVec4 setX(float val) {
        this.x = val;
        return this;
    }

    public FVec4 setY(float val) {
        this.y = val;
        return this;
    }

    public FVec4 setZ(float val) {
        this.z = val;
        return this;
    }

    public FVec4 setW(float val) {
        this.w = val;
        return this;
    }

    public FVec4 set(FVec4Readable v) {
        this.x = v.getX();
        this.y = v.getY();
        this.z = v.getZ();
        this.w = v.getW();
        return this;
    }

    public FVec4 set(float vX, float vY, float vZ, float vW) {
        this.x = vX;
        this.y = vY;
        this.z = vZ;
        this.w = vW;
        return this;
    }

    public FVec4 set(FVec3Readable v, float w) {
        return this.set(v.getX(), v.getY(), v.getZ(), w);
    }

    public FVec4 set(FVec2Readable v, float z, float w) {
        return this.set(v.getX(), v.getY(), z, w);
    }

    public FVec4 add(FVec4Readable v) {
        this.x = this.x + v.getX();
        this.y = this.y + v.getY();
        this.z = this.z + v.getZ();
        this.w = this.w + v.getW();
        return this;
    }

    public FVec4 add(float vX, float vY, float vZ, float vW) {
        this.x = this.x + vX;
        this.y = this.y + vY;
        this.z = this.z + vZ;
        this.w = this.w + vW;
        return this;
    }

    public FVec4 sub(FVec4Readable v) {
        this.x = this.x - v.getX();
        this.y = this.y - v.getY();
        this.z = this.z - v.getZ();
        this.w = this.w - v.getW();
        return this;
    }

    public FVec4 sub(float vX, float vY, float vZ, float vW) {
        this.x = this.x - vX;
        this.y = this.y - vY;
        this.z = this.z - vZ;
        this.w = this.w - vW;
        return this;
    }

    public FVec4 presub(FVec4Readable v) {
        this.x = v.getX() - this.x;
        this.y = v.getY() - this.y;
        this.z = v.getZ() - this.z;
        this.w = v.getW() - this.w;
        return this;
    }

    public FVec4 presub(float vX, float vY, float vZ, float vW) {
        this.x = vX - this.x;
        this.y = vY - this.y;
        this.z = vZ - this.z;
        this.w = vW - this.w;
        return this;
    }

    public FVec4 mul(FMat4Readable mat) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 3x3 matrix.").printStackTrace();
            System.exit(-1);
        }
        float x = this.x * mat.get00() + this.y * mat.get10() + this.z * mat.get20() + this.w * mat.get30();
        float y = this.x * mat.get01() + this.y * mat.get11() + this.z * mat.get21() + this.w * mat.get31();
        float z = this.x * mat.get02() + this.y * mat.get12() + this.z * mat.get22() + this.w * mat.get32();
        float w = this.x * mat.get03() + this.y * mat.get13() + this.z * mat.get23() + this.w * mat.get33();
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    public FVec4 mul(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 4x4 matrix.").printStackTrace();
            System.exit(-1);
        }
        float x = this.x * mat00 + this.y * mat10 + this.z * mat20 + this.w * mat30;
        float y = this.x * mat01 + this.y * mat11 + this.z * mat21 + this.w * mat31;
        float z = this.x * mat02 + this.y * mat12 + this.z * mat22 + this.w * mat32;
        float w = this.x * mat03 + this.y * mat13 + this.z * mat23 + this.w * mat33;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    public FVec4 premul(FMat4Readable mat) {
        if (isHor()) {
            new Exception("Cannot multiply a 4x4 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        float x = mat.get00() * this.x + mat.get01() * this.y + mat.get02() * this.z + mat.get03() * this.w;
        float y = mat.get10() * this.x + mat.get11() * this.y + mat.get12() * this.z + mat.get13() * this.w;
        float z = mat.get20() * this.x + mat.get21() * this.y + mat.get22() * this.z + mat.get23() * this.w;
        float w = mat.get30() * this.x + mat.get31() * this.y + mat.get32() * this.z + mat.get33() * this.w;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    public FVec4 premul(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33) {
        if (isHor()) {
            new Exception("Cannot multiply a 4x4 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        float x = mat00 * this.x + mat01 * this.y + mat02 * this.z + mat03 * this.w;
        float y = mat10 * this.x + mat11 * this.y + mat12 * this.z + mat13 * this.w;
        float z = mat20 * this.x + mat21 * this.y + mat22 * this.z + mat23 * this.w;
        float w = mat30 * this.x + mat31 * this.y + mat32 * this.z + mat33 * this.w;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    public FVec4 swap(FVec4 v) {
        float tempX = this.x;
        float tempY = this.y;
        float tempZ = this.z;
        float tempW = this.w;
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

    public FVec4 to(FVecWritable v) {
        this.extractTo(v);
        return this;
    }

    public FVec4 from(FVecReadable v) {
        this.extractFrom(v);
        return this;
    }

    public boolean equals(Object o) {
        if (o instanceof FVec4Readable) {
            FVec4Readable vec = (FVec4Readable) o;
            return this.x == vec.getX() && this.y == vec.getY() && this.z == vec.getZ() && this.w == vec.getW();
        }
        return false;
    }

}
