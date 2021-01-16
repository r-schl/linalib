package vector;

import matrix.Mat2x2;
import matrix.Matrix;

import java.nio.FloatBuffer;

public class Vec2 extends Matrix {

    public float x;
    public float y;

    private int rows;
    private int columns;

    private final int VER_ROWS = 2;
    private final int VER_COLUMNS = 1;

    private final int HOR_ROWS = 1;
    private final int HOR_COLUMNS = 2;

    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
        this.rows = HOR_ROWS;
        this.columns = HOR_COLUMNS;
    }

    public Vec2(float[] values) {
        this.x = values[0];
        this.y = values[1];
        this.rows = HOR_ROWS;
        this.columns = HOR_COLUMNS;
    }

    public Vec2(float xy) {
        this(xy, xy);
    }

    public Vec2(Vec2 vec) {
        this(vec.x, vec.y);
    }

    public Vec2(Vec3 vec) {
        this(vec.x, vec.y);
    }

    public Vec2(Vec4 vec) {
        this(vec.x, vec.y);
    }

    public float len() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public float len2() {
        return x * x + y * y;
    }

    public Vec2 normalize() {
        float len2 = this.len2();
        if (len2 == 0)
            return this;
        float length = (float) Math.sqrt(len2);
        this.x = this.x / length;
        this.y = this.y / length;
        return this;
    }

    public Vec2 perpendicular() {
        float tempX = this.x;
        this.x = this.y;
        this.y = -tempX;
        return this;
    }

    public float dot(Vec2 v) {
        return this.x * v.x + this.y * v.y;
    }

    public float dot(float vX, float vY) {
        return this.x * vX + this.y * vY;
    }

    public Vec2 add(Vec2 v) {
        this.x = this.x + v.x;
        this.y = this.y + v.y;
        return this;
    }

    public Vec2 add(float vX, float vY) {
        this.x = this.x + vX;
        this.y = this.y + vY;
        return this;   
    }

    public Vec2 add(float r) {
        this.x = this.x + r;
        this.y = this.y + r;
        return this;
    }

    public Vec2 sub(Vec2 v) {
        this.x = this.x - v.x;
        this.y = this.y - v.y;
        return this;
    }

    public Vec2 sub(float vX, float vY) {
        this.x = this.x - vX;
        this.y = this.y - vY;
        return this;
    }

    public Vec2 subRvs(Vec2 v) {
        this.x = v.x - this.x;
        this.y = v.y - this.y;
        return this;
    }

    public Vec2 sub(float r) {
        this.x = this.x - r;
        this.y = this.y - r;
        return this;
    }

    public Vec2 mul(float r) {
        this.x = this.x * r;
        this.y = this.y * r;
        return this;
    }

    public Vec2 div(float r) {
        this.x = this.x / r;
        this.y = this.y / r;
        return this;
    }

    public void swap(Vec2 v) {
        float tempX = this.x;
        float tempY = this.y;
        this.x = v.x;
        this.y = v.y;
        v.x = tempX;
        v.y = tempY;
    }

    public Vec2 inverse() {
        this.x = -this.x;
        this.y = -this.y;
        return this;
    }

    public float max() {
        float max = this.x;
        if (this.y > max)
            max = this.y;
        return max;
    }

    public boolean contains(float r) {
        return this.x == r || this.y == r;
    }

    public void floor(float r) {
        this.x = (this.x - (this.x % r));
        this.y = (this.y - (this.y % r));
    }

    public void round() {
        this.x = Math.round(x);
        this.y = Math.round(y);
    }

    public float[][] toArr() {
        return this.isHor() ? new float[][] { { x, y } } : new float[][] { { x }, { y } };
    }

    public Vec2 mul(Mat2x2 m) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 2x2 matrix.").printStackTrace();
            System.exit(-1);
        }
        float x = this.x * m.m00 + this.y * m.m10;
        float y = this.x * m.m01 + this.y * m.m11;
        this.x = x;
        this.y = y;
        return this;
    }

    public Vec2 mul(float mat00, float mat01,
                    float mat10, float mat11) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 2x2 matrix.").printStackTrace();
            System.exit(-1);
        }
        float x = this.x * mat00 + this.y * mat10;
        float y = this.x * mat01 + this.y * mat11;
        this.x = x;
        this.y = y;
        return this;
    }

    public Vec2 mulRvs(Mat2x2 m) {
        if (isHor()) {
            new Exception("Cannot multiply 2x2 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        float x = m.m00 * this.x + m.m01 * this.y;
        float y = m.m10 * this.x + m.m11 * this.y;
        this.x = x;
        this.y = y;
        return this;
    }

    public Vec2 mulRvs(float mat00, float mat01,
                       float mat10, float mat11) {
        if (isHor()) {
            new Exception("Cannot multiply 2x2 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        float x = mat00 * this.x + mat01 * this.y;
        float y = mat10 * this.x + mat11 * this.y;
        this.x = x;
        this.y = y;
        return this;
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
            if (col == 0)
                return x;
            else if (col == 1)
                return y;
        } else {
            if (row == 0)
                return x;
            else if (row == 1)
                return y;
        }
        return -1;
    }

    @Override
    public void set(int row, int col, float val) {
        if (row >= rows || col >= columns)
            throw new IllegalArgumentException("Row and/or column out of range. " + row + " " + col);
        if (this.isHor()) {
            if (col == 0)
                x = val;
            else if (col == 1)
                y = val;
        } else {
            if (row == 0)
                x = val;
            else if (row == 1)
                y = val;
        }
    }

    public Vec2 copy() {
        return this.isHor() ? new Vec2(x, y) : new Vec2(x, y).transpose();
    }

    @Override
    public Vec2 flipHor() {
        if (!isVer())
            return this.mul(Mat2x2.FLIP);
        else
            return this;
    }

    @Override
    public Vec2 flipVer() {
        if (!isHor())
            return this.mulRvs(Mat2x2.FLIP);
        else
            return this;
    }

    @Override
    public Vec2 transpose() {
        this.rows = this.rows == HOR_ROWS ? VER_ROWS : HOR_ROWS;
        this.columns = this.columns == HOR_COLUMNS ? VER_COLUMNS : HOR_COLUMNS;
        return this;
    }

    public boolean equals(Object object) {
        if (object instanceof Vec2) {
            Vec2 vec = (Vec2) object;
            return this.x == vec.x && this.y == vec.y;
        }
        return false;
    }

    public void print() {
        System.out.println(this);
    }

    public String toString() {
        return this.isHor() ? "(" + x + " " + y + ")" : x + "\n" + y;
    }

    @Override
    public Vec2 toInt() {
        this.x = (int) this.x;
        this.y = (int) this.y;
        return this;
    }

    @Override
    public Matrix storeInside(FloatBuffer buf) {
        buf.put(x);
        buf.put(y);
        return this;
    }

    public void copyTo(Vec2 v) {
        v.x = this.x;
        v.y = this.y;
    }

    public void copyTo(Vec3 v) {
        v.x = this.x;
        v.y = this.y;
    }

    public void copyTo(Vec4 v) {
        v.x = this.x;
        v.y = this.y;
    }

}