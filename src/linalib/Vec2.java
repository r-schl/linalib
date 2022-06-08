package linalib;

import java.nio.FloatBuffer;

public class Vec2 implements Vec2Readable {

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
        if (other.isTransposed())
            this.transpose();
    }

    @Override
    public float getLen() {
        return (float) Math.sqrt(this.getLen2());
    }

    @Override
    public float getLen2() {
        return x * x + y * y;
    }

    @Override
    public float getMax() {
        float max = this.x;
        if (this.y > max)
            max = this.y;
        return max;
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
    public void storeInBuffer(FloatBuffer buf) {
        buf.put(x);
        buf.put(y);
    }

    @Override
    public float[][] getNewArr2() {
        return this.isHor() ? new float[][] { { x, y } } : new float[][] { { x }, { y } };
    }

    @Override
    public float[] getNewArr() {
        return new float[] { x, y };
    }

    @Override
    public boolean contains(float r) {
        return this.x == r || this.y == r;
    }

    // SETTER METHODS

    public Vec2 transpose() {
        isTransposed = !isTransposed;
        return this;
    }

    public Vec2 set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vec2 add(float r) {
        this.x = this.x + r;
        this.y = this.y + r;
        return this;
    }

    public Vec2 sub(float r) {
        this.x = this.x - r;
        this.y = this.y - r;
        return this;
    }

    public Vec2 presub(float r) {
        this.x = r - this.x;
        this.y = r - this.y;
        return this;
    }

    public Vec2 mul(float r) {
        this.x = this.x * r;
        this.y = this.y * r;
        return this;
    }

    public Vec2 div(float r) {
        if (r == 0)
            throw new IllegalArgumentException("Cannot divide by 0");
        this.x = this.x / r;
        this.y = this.y / r;
        return this;
    }

    public Vec2 prediv(float r) {
        if (this.contains(0))
            throw new IllegalArgumentException("Cannot divide by 0");
        this.x = r / this.x;
        this.y = r / this.y;
        return this;
    }

    public Vec2 negate() {
        this.x = -this.x;
        this.y = -this.y;
        return this;
    }

    public Vec2 floor(float r) {
        this.x = (this.x - (this.x % r));
        this.y = (this.y - (this.y % r));
        return this;
    }

    public Vec2 toInt() {
        this.x = (int) this.x;
        this.y = (int) this.y;
        return this;
    }

    public Vec2 absElementWise() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        return this;
    }

    public Vec2 round() {
        this.x = Math.round(x);
        this.y = Math.round(y);
        return this;
    }

    public Vec2 normalize() {
        return this.div(this.getLen());
    }

    /*
     * public Vec2 flip() {
     * if (this.isHor()) return this.mul(Mat2.FLIP);
     * return this.premul(Mat2.FLIP);
     * }
     */

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

    public Vec2 sub(Vec2Readable v) {
        this.x = this.x - v.getX();
        this.y = this.y - v.getY();
        return this;
    }

    public Vec2 presub(Vec2Readable v) {
        this.x = v.getX() - this.x;
        this.y = v.getY() - this.y;
        return this;
    }

    /*
     * public Vec2 mul(Mat2Readable mat) {
     * if (isVer()) {
     * new Exception("Cannot multiply a vertical vector with a 2x2 matrix.").
     * printStackTrace();
     * System.exit(-1);
     * }
     * float x = this.x * mat.get00() + this.y * mat.get10();
     * float y = this.x * mat.get01() + this.y * mat.get11();
     * this.x = x;
     * this.y = y;
     * return this;
     * }
     */

    /*
     * public Vec2 premul(Mat2Readable mat) {
     * if (isHor()) {
     * new Exception("Cannot multiply 2x2 matrix with an horizontal vector.").
     * printStackTrace();
     * System.exit(-1);
     * }
     * float x = mat.get00() * this.x + mat.get01() * this.y;
     * float y = mat.get10() * this.x + mat.get11() * this.y;
     * this.x = x;
     * this.y = y;
     * return this;
     * }
     */

    public Vec2 swap(Vec2 v) {
        float tempX = this.x;
        float tempY = this.y;
        this.x = v.getX();
        this.y = v.getY();
        v.x = tempX;
        v.y = tempY;
        return this;
    }

    @Override
    public String toString() {
        return (this.isHor() ? "hor" : "ver") + "(" + this.x + " " + this.y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vec2Readable) {
            Vec2Readable vec = (Vec2Readable) o;
            return this.x == vec.getX() && this.y == vec.getY();
        }
        return false;
    }

    // STATIC METHODS

    public static float dot(Vec2Readable a, Vec2Readable b) {
        return a.getX() * b.getX() + a.getY() * b.getY();
    }

    public static float angle(Vec2Readable a, Vec2Readable b) {
        return (float) Math.toDegrees(Math.acos(dot(a, b) / (a.getLen() * b.getLen())));
    }

    public static Vec2 add(Vec2Readable a, float r) {
        return new Vec2(a).add(r);
    }

    public static Vec2 sub(Vec2Readable a, float r) {
        return new Vec2(a).sub(r);
    }

    public static Vec2 sub(float r, Vec2Readable a) {
        return new Vec2(a).presub(r);
    }

    public static Vec2 mul(Vec2Readable a, float r) {
        return new Vec2(a).mul(r);
    }

    public static Vec2 div(Vec2Readable a, float r) {
        return new Vec2(a).div(r);
    }

    public static Vec2 div(float r, Vec2Readable a) {
        return new Vec2(a).prediv(r);
    }

    public static Vec2 negate(Vec2Readable a) {
        return new Vec2(a).negate();
    }

    public static Vec2 floor(Vec2Readable a, float r) {
        return new Vec2(a).floor(r);
    }

    public static Vec2 round(Vec2Readable a) {
        return new Vec2(a).round();
    }

    public static Vec2 normalize(Vec2Readable a) {
        return new Vec2(a).normalize();
    }

    public static Vec2 toInt(Vec2Readable a) {
        return new Vec2(a).toInt();
    }

    public static Vec2 absElementWise(Vec2Readable a) {
        return new Vec2(a).absElementWise();
    }

    public static Vec2 perpendicular(Vec2Readable a) {
        return new Vec2(a).perpendicular();
    }

    public static Vec2 add(Vec2Readable a, Vec2Readable b) {
        return new Vec2(a).add(b);
    }

    public static Vec2 sub(Vec2Readable a, Vec2Readable b) {
        return new Vec2(a).sub(b);
    }

}
