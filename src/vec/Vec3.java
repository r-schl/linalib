package src.vec;

import src.mat.Mat3x3;
import src.mat.Matrix;

public class Vec3 extends Matrix {

    public float x;
    public float y;
    public float z;

    private int rows;
    private int columns;

    private static final int VER_ROWS = 3;
    private static final int VER_COLUMNS = 1;

    private static final int HOR_ROWS = 1;
    private static final int HOR_COLUMNS = 3;


    public Vec3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.rows = HOR_ROWS;
        this.columns = HOR_COLUMNS;
    }

    public Vec3(float[] values) {
        this.x = values[0];
        this.y = values[1];
        this.z = values[2];
        this.rows = HOR_ROWS;
        this.columns = HOR_COLUMNS;
    }

    public Vec3(float xyz) {
        this(xyz, xyz, xyz);
    }

    public float len() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public float len2() {
        return x * x + y * y + z * z;
    }

    public Vec3 normalize() {
        float len2 = this.len2();
        if (len2 == 0) return this;
        float length = (float) Math.sqrt(len2);
        this.x = this.x / length;
        this.y = this.y / length;
        this.z = this.z / length;
        return this;
    }

    public Vec3 cross(Vec3 v) {
        float x = this.y * v.z - this.z * v.y;
        float y = this.z * v.x - this.x * v.z;
        float z = this.x * v.y - this.y * v.x;
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public Vec3 crossRvs(Vec3 v) {
        float x = v.y * this.z - v.z * this.y;
        float y = v.z * this.x - v.x * this.z;
        float z = v.x * this.y - v.y * this.x;
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public float dot(Vec3 v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    public Vec3 add(Vec3 v) {
        this.x = this.x + v.x;
        this.y = this.y + v.y;
        this.z = this.z + v.z;
        return this;
    }

    public Vec3 add(float r) {
        this.x = this.x + r;
        this.y = this.y + r;
        this.z = this.z + r;
        return this;
    }

    public Vec3 sub(Vec3 v) {
        this.x = this.x - v.x;
        this.y = this.y - v.y;
        this.z = this.z - v.z;
        return this;
    }

    public Vec3 subRvs(Vec3 v) {
        this.x = v.x - this.x;
        this.y = v.y - this.y;
        this.z = v.z - this.z;
        return this;
    }

    public Vec3 sub(float r) {
        this.x = this.x - r;
        this.y = this.y - r;
        this.z = this.z - r;
        return this;
    }

    public Vec3 mul(float r) {
        this.x = this.x * r;
        this.y = this.y * r;
        this.z = this.z * r;
        return this;
    }

    public Vec3 div(float r) {
        this.x = this.x / r;
        this.y = this.y / r;
        this.z = this.z / r;
        return this;
    }

    public void swap(Vec3 v) {
        float tempX = this.x;
        float tempY = this.y;
        float tempZ = this.z;
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
        v.x = tempX;
        v.y = tempY;
        v.z = tempZ;
    }

    public Vec3 inverse() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public float max() {
        float max = this.x;
        if (this.y > max) max = this.y;
        if (this.z > max) max = this.z;
        return max;
    }

    public boolean contains(float r) {
        return this.x == r || this.y == r || this.z == r;
    }

    public void floor(float r) {
        this.x = (this.x - (this.x % r));
        this.y = (this.y - (this.y % r));
        this.z = (this.z - (this.z % r));
    }

    public void round() {
        this.x = Math.round(x);
        this.y = Math.round(y);
        this.z = Math.round(z);
    }

    @Override
    public float[][] toArr() {
        return this.isHor() ? new float[][]{{x, y, z}} : new float[][]{{x}, {y}, {z}};
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
        } else {
            if (row == 0) return x;
            else if (row == 1) return y;
            else if (row == 2) return z;
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
        } else {
            if (row == 0) x = val;
            else if (row == 1) y = val;
            else if (row == 2) z = val;
        }
    }

    public Vec3 copy() {
        return this.isHor() ? new Vec3(x, y, z) : new Vec3(x, y, z).transpose();
    }

    @Override
    public Vec3 flipHor() {
        if (!isVer()) return this.mul(Mat3x3.FLIP);
        else return this;
    }

    @Override
    public Vec3 flipVer() {
        if (!isHor()) return this.mulRvs(Mat3x3.FLIP);
        else return this;
    }

    public Vec3 mul(Mat3x3 m) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 3x3 matrix.").printStackTrace();
            System.exit(-1);
        }
        float x = this.x * m.m00 + this.y * m.m10 + this.z * m.m20;
        float y = this.x * m.m01 + this.y * m.m11 + this.z * m.m21;
        float z = this.x * m.m02 + this.y * m.m12 + this.z * m.m22;
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public Vec3 mulRvs(Mat3x3 m){
        if (m.isHor()) {
            new Exception("Cannot multiply 3x3 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        float x = m.m00 * this.x + m.m01 * this.y + m.m02 * this.z;
        float y = m.m10 * this.x + m.m11 * this.y + m.m12 * this.z;
        float z = m.m20 * this.x + m.m21 * this.y + m.m22 * this.z;
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    @Override
    public Vec3 transpose() {
        this.rows = this.rows == HOR_ROWS ? VER_ROWS : HOR_ROWS;
        this.columns = this.columns == HOR_COLUMNS ? VER_COLUMNS : HOR_COLUMNS;
        return this;
    }

    public boolean equals(Object object) {
        if (object instanceof Vec3) {
            Vec3 vec = (Vec3) object;
            return this.x == vec.x && this.y == vec.y && this.z == vec.z;
        }
        return false;
    }

    public void print() {
        System.out.println(this);
    }

    public String toString() {
        return this.isHor() ? "(" + x + " " + y + " " + z + ")" : x + "\n" + y + "\n" + z;
    }
}
