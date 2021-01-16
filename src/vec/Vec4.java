package src.vec;

import java.nio.FloatBuffer;

import src.mat.Mat4x4;
import src.mat.Matrix;

public class Vec4 extends Matrix {

    public float x;
    public float y;
    public float z;
    public float w;

    private int rows;
    private int columns;

    private static final int VER_ROWS = 4;
    private static final int VER_COLUMNS = 1;

    private static final int HOR_ROWS = 1;
    private static final int HOR_COLUMNS = 4;

    public Vec4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.rows = HOR_ROWS;
        this.columns = HOR_COLUMNS;
    }

    public Vec4(float[] values) {
        this.x = values[0];
        this.y = values[1];
        this.z = values[2];
        this.w = values[3];
        this.rows = HOR_ROWS;
        this.columns = HOR_COLUMNS;
    }

    public Vec4(Vec3 vec, float w) {
        this(vec.x, vec.y, vec.z, w);
    }

    public Vec4(float xyzw) {
        this(xyzw, xyzw, xyzw, xyzw);
    }

    public Vec4(float xyz, float w) {
        this(xyz, xyz, xyz, w);
    }

    public float len() {
        return (float) Math.sqrt(x * x + y * y + z * z + w * w);
    }

    public float len2() {
        return x * x + y * y + z * z + w * w;
    }

    public Vec4 normalize() {
        float len2 = this.len2();
        if (len2 == 0)
            return this;
        float length = (float) Math.sqrt(len2);
        this.x = this.x / length;
        this.y = this.y / length;
        this.z = this.z / length;
        this.w = this.w / length;
        return this;
    }

    public float dot(Vec4 v) {
        return this.x * v.x + this.y * v.y + this.z * v.z + this.w * v.w;
    }

    public float dot(float vX, float vY, float vZ, float vW) {
        return this.x * vX + this.y * vY + this.z * vZ + this.w * vW;
    }

    public Vec4 add(Vec4 v) {
        this.x = this.x + v.x;
        this.y = this.y + v.y;
        this.z = this.z + v.z;
        this.w = this.w + v.w;
        return this;
    }

    public Vec4 add(float vX, float vY, float vZ, float vW) {
        this.x = this.x + vX;
        this.y = this.y + vY;
        this.z = this.z + vZ;
        this.w = this.w + vW;
        return this;
    }

    public Vec4 add(float r) {
        this.x = this.x + r;
        this.y = this.y + r;
        this.z = this.z + r;
        this.w = this.w + r;
        return this;
    }

    public Vec4 sub(Vec4 v) {
        this.x = this.x - v.x;
        this.y = this.y - v.y;
        this.z = this.z - v.z;
        this.w = this.w - v.w;
        return this;
    }

    public Vec4 sub(float vX, float vY, float vZ, float vW) {
        this.x = this.x - vX;
        this.y = this.y - vY;
        this.z = this.z - vZ;
        this.w = this.w - vW;
        return this;
    }

    public Vec4 subRvs(Vec4 v) {
        this.x = v.x - this.x;
        this.y = v.y - this.y;
        this.z = v.z - this.z;
        this.w = v.w - this.w;
        return this;
    }

    public Vec4 subRvs(float vX, float vY, float vZ, float vW) {
        this.x = vX - this.x;
        this.y = vY - this.y;
        this.z = vZ - this.z;
        this.w = vW - this.w;
        return this;
    }

    public Vec4 sub(float r) {
        this.x = this.x - r;
        this.y = this.y - r;
        this.z = this.z - r;
        this.w = this.w - r;
        return this;
    }

    public Vec4 mul(float r) {
        this.x = this.x * r;
        this.y = this.y * r;
        this.z = this.z * r;
        this.w = this.w * r;
        return this;
    }

    public Vec4 div(float r) {
        this.x = this.x / r;
        this.y = this.y / r;
        this.z = this.z / r;
        this.w = this.w / r;
        return this;
    }

    public void swap(Vec4 v) {
        float tempX = this.x;
        float tempY = this.y;
        float tempZ = this.z;
        float tempW = this.w;
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
        this.w = v.w;
        v.x = tempX;
        v.y = tempY;
        v.z = tempZ;
        v.w = tempW;
    }

    public Vec4 inverse() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
        return this;
    }

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

    public boolean contains(float r) {
        return this.x == r || this.y == r || this.z == r || this.w == r;
    }

    public void floor(float r) {
        this.x = (this.x - (this.x % r));
        this.y = (this.y - (this.y % r));
        this.z = (this.z - (this.z % r));
        this.w = (this.w - (this.w % r));
    }

    public void round() {
        this.x = Math.round(x);
        this.y = Math.round(y);
        this.z = Math.round(z);
        this.w = Math.round(w);
    }

    @Override
    public int rowCount() {
        return rows;
    }

    @Override
    public int colCount() {
        return columns;
    }

    @Override
    public float get(int row, int col) {
        if (row >= rows || col >= columns)
            throw new IllegalArgumentException("Row and/or column out of range. " + row + " " + col);
        if (this.isHor()) {
            if (col == 0) return x;
            else if (col == 1) return y;
            else if (col == 2) return z;
            else if (col == 3) return w;
        } else {
            if (row == 0) return x;
            else if (row == 1) return y;
            else if (row == 2) return z;
            else if (row == 3) return w;
        }
        return -1;
    }

    @Override
    public void set(int row, int col, float val) {
        if (row >= rows || col >= columns)
            throw new IllegalArgumentException("Row and/or column out of range. " + row + " " + col);
        if (this.isHor()) {
            if (col == 0) x = val;
            else if (col == 1) y = val;
            else if (col == 2) z = val;
            else if (col == 3) w = val;
        } else {
            if (row == 0) x = val;
            else if (row == 1) y = val;
            else if (row == 2) z = val;
            else if (col == 3) w = val;
        }
    }

    @Override
    public Vec4 copy() {
        return this.isHor() ? new Vec4(x, y, z, w) : new Vec4(x, y, z, w).transpose();
    }

    @Override
    public Vec4 flipHor() {
        if (!isVer())
            return this.mul(Mat4x4.FLIP);
        else
            return this;
    }

    @Override
    public Vec4 flipVer() {
        if (!isHor())
            return this.mulRvs(Mat4x4.FLIP);
        else
            return this;
    }

    public Vec4 mul(Mat4x4 mat) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 3x3 matrix.").printStackTrace();
            System.exit(-1);
        }
        float x = this.x * mat.m00 + this.y * mat.m10 + this.z * mat.m20 + this.w * mat.m30;
        float y = this.x * mat.m01 + this.y * mat.m11 + this.z * mat.m21 + this.w * mat.m31;
        float z = this.x * mat.m02 + this.y * mat.m12 + this.z * mat.m22 + this.w * mat.m32;
        float w = this.x * mat.m03 + this.y * mat.m13 + this.z * mat.m23 + this.w * mat.m33;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    public Vec4 mul(float mat00, float mat01, float mat02, float mat03,
                    float mat10, float mat11, float mat12, float mat13,
                    float mat20, float mat21, float mat22, float mat23,
                    float mat30, float mat31, float mat32, float mat33) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 3x3 matrix.").printStackTrace();
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

    public Vec4 mulRvs(Mat4x4 mat) {
        if (isHor()) {
            new Exception("Cannot multiply 3x3 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        float x = mat.m00 * this.x + mat.m01 * this.y + mat.m02 * this.z + mat.m03 * this.w;
        float y = mat.m10 * this.x + mat.m11 * this.y + mat.m12 * this.z + mat.m13 * this.w;
        float z = mat.m20 * this.x + mat.m21 * this.y + mat.m22 * this.z + mat.m23 * this.w;
        float w = mat.m30 * this.x + mat.m31 * this.y + mat.m32 * this.z + mat.m33 * this.w;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    public Vec4 mulRvs(float mat00, float mat01, float mat02, float mat03,
                       float mat10, float mat11, float mat12, float mat13,
                       float mat20, float mat21, float mat22, float mat23,
                       float mat30, float mat31, float mat32, float mat33) {
        if (isHor()) {
            new Exception("Cannot multiply 3x3 matrix with an horizontal vector.").printStackTrace();
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

    @Override
    public Vec4 transpose() {
        this.rows = this.rows == HOR_ROWS ? VER_ROWS : HOR_ROWS;
        this.columns = this.columns == HOR_COLUMNS ? VER_COLUMNS : HOR_COLUMNS;
        return this;
    }

    @Override
    public Vec4 toInt() {
        this.x = (int) this.x;
        this.y = (int) this.y;
        this.z = (int) this.z;
        this.w = (int) this.w;
        return this;
    }

    @Override
    public Vec4 storeInside(FloatBuffer buf) {
        buf.put(x);
        buf.put(y);
        buf.put(z);
        buf.put(w);
        return this;
    }

    @Override
    public float[][] toArr() {
        return this.isHor() ? new float[][]{{x, y, z, w}} : new float[][]{{x}, {y}, {z}, {w}};
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Vec4) {
            Vec4 vec = (Vec4) object;
            return this.x == vec.x && this.y == vec.y && this.z == vec.z && this.w == vec.w;
        }
        return false;
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.isHor() ? "(" + x + " " + y + " " + z + " " + w + ")" : x + "\n" + y + "\n" + z + "\n" + w;
    }

    public Vec3 xyz() {
        return new Vec3(x, y, z);
    }

    public Vec2 xy() {
        return new Vec2(x, y);
    }

    public void copyTo(Vec4 v) {
        v.x = this.x;
        v.y = this.y;
        v.z = this.z;
        v.w = this.w;
    }

    public void copyTo(Vec3 v) {
        v.x = this.x;
        v.y = this.y;
        v.z = this.z;
    }

    public void copyTo(Vec2 v) {
        v.x = this.x;
        v.y = this.y;
    }


}
