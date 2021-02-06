package linalib.vec;

import java.nio.FloatBuffer;
import linalib.mat.Mat2;
import linalib.mat.Mat2Readable;


public class Vec2 implements Vec2Readable, VecWritable {

    // static presets
    public static final Vec2Readable YAXIS = new Vec2(0, 1);
    public static final Vec2Readable XAXIS = new Vec2(1, 0);
    public static final Vec2Readable UP = new Vec2(YAXIS);
    public static final Vec2Readable DOWN = new Vec2(YAXIS).negate();
    public static final Vec2Readable RIGHT = new Vec2(XAXIS);
    public static final Vec2Readable LEFT = new Vec2(XAXIS).negate();

    public float x;
    public float y;

    private boolean isTransposed;

    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vec2(float xy) {
        this(xy, xy);
    }

    public Vec2(Vec2Readable other) {
        this(other.getX(), other.getY());
        if (other.isTransposed()) this.transpose();
    }

    public Vec2(Vec3Readable other) {
        this(other.getX(), other.getY());
        if (other.isTransposed()) this.transpose();
    }
    
    public Vec2(Vec4Readable other) {
        this(other.getX(), other.getY());
        if (other.isTransposed()) this.transpose();
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
    public float dot(Vec2Readable v) {
        return this.x * v.getX() + this.y * v.getY();
    }

    @Override
    public float dot(float vX, float vY) {
        return this.x * vX + this.y * vY;
    }

    @Override
    public float len() {
        return (float) Math.sqrt(len2());
    }

    @Override
    public float len2() {
        return this.x * this.x + this.y * this.y;
    }

    @Override
    public float get(int i) {
        if (i == 0) return this.x;
        else if (i == 1) return this.y;
        else new Exception("Index out of range for vector dimension " + this.size());
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
        return 2;
    }

    @Override
    public float max() {
        float max = this.x;
        if (this.y > max)
            max = this.y;
        return max;
    }

    @Override
    public Vec2 storeInside(FloatBuffer buf) {
        buf.put(x);
        buf.put(y);
        return this;
    }

    @Override
    public float[][] newArr2() {
        return this.isHor() ? new float[][] { { x, y} } : new float[][] { { x }, { y } };
    }

    @Override
    public float[] newArr() {
        return new float[] {x, y};
    }

    @Override
    public boolean contains(float r) {
        return this.x == r || this.y == r;
    }

    @Override
    public Vec2 set(int i, float val) {
        if (i == 0) this.x = val;
        else if (i == 1) this.y = val;
        return this;
    }

    @Override
    public Vec2 toInt() {
        this.x = (int) this.x;
        this.y = (int) this.y;
        return this;
    }

    @Override
    public Vec2 absElWise() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        return this;
    }

    @Override
    public Vec2 add(float r) {
        this.x = this.x + r;
        this.y = this.y + r;
        return this;
    }

    @Override
    public Vec2 sub(float r) {
        this.x = this.x - r;
        this.y = this.y - r;
        return this;
    }

    @Override
    public Vec2 presub(float r) {
        this.x = r - this.x;
        this.y = r - this.y;
        return this;
    }

    @Override
    public Vec2 mul(float r) {
        this.x = this.x * r;
        this.y = this.y * r;
        return this;
    }

    @Override
    public Vec2 div(float r) {
        if (r == 0) throw new IllegalArgumentException("Cannot divide by 0");
        this.x = this.x / r;
        this.y = this.y / r;
        return this;
    }

    @Override
    public Vec2 prediv(float r) {
        if (this.contains(0)) throw new IllegalArgumentException("Cannot divide by 0");
        this.x = r / this.x;
        this.y = r / this.y;
        return this;
    }

    @Override
    public Vec2 negate() {
        this.x = -this.x;
        this.y = -this.y;
        return this;
    }

    @Override
    public Vec2 floor(float r) {
        this.x = (this.x - (this.x % r));
        this.y = (this.y - (this.y % r));
        return this;
    }

    @Override
    public Vec2 round() {
        this.x = Math.round(x);
        this.y = Math.round(y);
        return this;
    }

    @Override
    public Vec2 normalize() {
        return this.div(this.len());
    }

    @Override
    public Vec2 flip() {
        if (this.isHor()) return this.mul(Mat2.FLIP);
        return this.premul(Mat2.FLIP);
    }

    @Override
    public Vec2 transpose() {
        isTransposed = !isTransposed;
        return this;
    }

    public Vec2 setX(float val) {
        this.x = val;
        return this;
    }

    public Vec2 setY(float val) {
        this.y = val;
        return this;
    }

    public Vec2 set(Vec2Readable v) {
        this.x = v.getX();
        this.y = v.getY();
        return this;
    }

    public Vec2 set(float vX, float vY) {
        this.x = vX;
        this.y = vY;
        return this;
    }

    public Vec2 set(Vec3Readable v) {
        return this.set(v.getX(), v.getY());
    }

    public Vec2 set(Vec4Readable v) {
        return this.set(v.getX(), v.getY());
    }
    
    public Vec2 perpendicular() {
        float tempX = this.x;
        this.x = this.y;
        this.y = -tempX;
        return this;
    }

    public Vec2 add(Vec2Readable v) {
        this.x = this.x + v.getX();
        this.y = this.y + v.getY();
        return this;
    }

    public Vec2 add(float vX, float vY) {
        this.x = this.x + vX;
        this.y = this.y + vY;
        return this;   
    }

    public Vec2 sub(Vec2Readable v) {
        this.x = this.x - v.getX();
        this.y = this.y - v.getY();
        return this;
    }

    public Vec2 sub(float vX, float vY) {
        this.x = this.x - vX;
        this.y = this.y - vY;
        return this;
    }

    public Vec2 presub(Vec2Readable v) {
        this.x = v.getX() - this.x;
        this.y = v.getY() - this.y;
        return this;
    }

    public Vec2 presub(float vX, float vY) {
        this.x = vX - this.x;
        this.y = vY - this.y;
        return this;
    }

    public Vec2 mul(Mat2Readable mat) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 2x2 matrix.").printStackTrace();
            System.exit(-1);
        }
        float x = this.x * mat.get00() + this.y * mat.get10(); 
        float y = this.x * mat.get01() + this.y * mat.get11();
        this.x = x;
        this.y = y;
        return this;
    }

    public Vec2 mul(float mat00, float mat01, float mat10, float mat11) {
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

    public Vec2 premul(Mat2Readable mat) {
        if (isHor()) {
            new Exception("Cannot multiply 2x2 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        float x = mat.get00() * this.x + mat.get01() * this.y;
        float y = mat.get10() * this.x + mat.get11() * this.y;
        this.x = x;
        this.y = y;
        return this;
    }

    public Vec2 premul(float mat00, float mat01, float mat10, float mat11) {
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

    public Vec2 swap(Vec2 v) {
        float tempX = this.x;
        float tempY = this.y;
        this.x = v.getX();
        this.y = v.getY();
        v.setX(tempX);
        v.setY(tempY);
        return this;
    }
    
    @Override
    public String toString() {
        return (this.isHor() ? "hor" : "ver") + "(" + this.x + " " + this.y + ")";
    }

    @Override
    public Vec2 to(VecWritable v) {
        this.extractTo(v);
        return this;
    }

    @Override
    public Vec2 from(VecReadable v) {
        this.extractFrom(v);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vec2Readable) {
            Vec2Readable vec = (Vec2Readable) o;
            return this.x == vec.getX() && this.y == vec.getY();
        }
        return false;
    }

}
