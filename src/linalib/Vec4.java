package linalib;

import java.nio.FloatBuffer;

public class Vec4 implements Vec4Readable {

    public float x;
    public float y;
    public float z;
    public float w;

    private boolean isTransposed;

    public Vec4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vec4(Vec3Readable vec3, float w) {
        this.x = vec3.getX();
        this.y = vec3.getY();
        this.z = vec3.getZ();
        this.w = w;
    }

    public Vec4(Vec2Readable vec2, float z, float w) {
        this.x = vec2.getX();
        this.y = vec2.getY();
        this.z = z;
        this.w = w;
    }

    public Vec4(float xyzw) {
        this(xyzw, xyzw, xyzw, xyzw);
    }

    public Vec4(Vec4Readable other) {
        this(other.getX(), other.getY(), other.getZ(), other.getW());
        if (other.isTransposed())
            this.transpose();
    }

    @Override
    public float getLength() {
        return (float) Math.sqrt(this.getLength2());
    }

    @Override
    public float getLength2() {
        return x * x + y * y + z * z + w * w;
    }

    @Override
    public float getMax() {
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
        buf.put(z);
        buf.put(w);
    }

    @Override
    public float[][] getNewArr2() {
        return this.isHor() ? new float[][] { { x, y, z, w } } : new float[][] { { x }, { y }, { z }, { w } };
    }

    @Override
    public float[] getNewArr() {
        return new float[] { x, y, z, w };
    }

    @Override
    public boolean contains(float r) {
        return this.x == r || this.y == r || this.z == r || this.w == r;
    }

    // SETTER METHODS

    public Vec4 transpose() {
        isTransposed = !isTransposed;
        return this;
    }

    public Vec4 set(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    public Vec4 set(Vec4Readable other) {
        this.x = other.getX();
        this.y = other.getY();
        this.z = other.getZ();
        this.w = other.getW();
        return this;
    }

    public Vec4 add(float r) {
        this.x = this.x + r;
        this.y = this.y + r;
        this.z = this.z + r;
        this.w = this.w + r;
        return this;
    }

    public Vec4 sub(float r) {
        this.x = this.x - r;
        this.y = this.y - r;
        this.z = this.z - r;
        this.w = this.w - r;
        return this;
    }

    public Vec4 presub(float r) {
        this.x = r - this.x;
        this.y = r - this.y;
        this.z = r - this.z;
        this.w = r - this.w;
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
        if (r == 0)
            throw new IllegalArgumentException("Cannot divide by 0");
        this.x = this.x / r;
        this.y = this.y / r;
        this.z = this.z / r;
        this.w = this.w / r;
        return this;
    }

    public Vec4 prediv(float r) {
        if (this.contains(0))
            throw new IllegalArgumentException("Cannot divide by 0");
        this.x = r / this.x;
        this.y = r / this.y;
        this.z = r / this.z;
        this.w = r / this.w;
        return this;
    }

    public Vec4 negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
        return this;
    }

    public Vec4 floor(float r) {
        this.x = (this.x - (this.x % r));
        this.y = (this.y - (this.y % r));
        this.z = (this.z - (this.z % r));
        this.w = (this.w - (this.w % r));
        return this;
    }

    public Vec4 toInt() {
        this.x = (int) this.x;
        this.y = (int) this.y;
        this.z = (int) this.z;
        this.w = (int) this.w;
        return this;
    }

    public Vec4 absElementWise() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
        return this;
    }

    public Vec4 round() {
        this.x = Math.round(x);
        this.y = Math.round(y);
        this.z = Math.round(z);
        this.w = Math.round(w);
        return this;
    }

    public Vec4 normalize() {
        return this.div(this.getLength());
    }

    public Vec4 flip() {
        if (this.isHor())
            return this.mul(Mat4.FLIP);
        return this.premul(Mat4.FLIP);
    }

    public Vec4 add(Vec4Readable v) {
        this.x = this.x + v.getX();
        this.y = this.y + v.getY();
        this.z = this.z + v.getZ();
        this.w = this.w + v.getW();
        return this;
    }

    public Vec4 sub(Vec4Readable v) {
        this.x = this.x - v.getX();
        this.y = this.y - v.getY();
        this.z = this.z - v.getZ();
        this.w = this.w - v.getW();
        return this;
    }

    public Vec4 presub(Vec4Readable v) {
        this.x = v.getX() - this.x;
        this.y = v.getY() - this.y;
        this.z = v.getZ() - this.z;
        this.w = v.getW() - this.w;
        return this;
    }

    public Vec4 mul(Mat4Readable mat) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 4x4 matrix.").printStackTrace();
            System.exit(-1);
        }
        float x = this.x * mat.get00() + this.y * mat.get10() + this.z * mat.get20()
                + this.w * mat.get30();
        float y = this.x * mat.get01() + this.y * mat.get11() + this.z * mat.get21()
                + this.w * mat.get31();
        float z = this.x * mat.get02() + this.y * mat.get12() + this.z * mat.get22()
                + this.w * mat.get32();
        float w = this.x * mat.get03() + this.y * mat.get13() + this.z * mat.get23()
                + this.w * mat.get33();
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    public Vec4 normalizeHomogeneousCoordinates() {
        this.x = x / this.w;
        this.y = y / this.w;
        this.z = z / this.w;
        this.w = w / this.w;
        return this;
    }

    public Vec4 premul(Mat4Readable mat) {
        if (isHor()) {
            new Exception("Cannot multiply a 4x4 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        float x = mat.get00() * this.x + mat.get01() * this.y + mat.get02() * this.z
                + mat.get03() * this.w;
        float y = mat.get10() * this.x + mat.get11() * this.y + mat.get12() * this.z
                + mat.get13() * this.w;
        float z = mat.get20() * this.x + mat.get21() * this.y + mat.get22() * this.z
                + mat.get23() * this.w;
        float w = mat.get30() * this.x + mat.get31() * this.y + mat.get32() * this.z
                + mat.get33() * this.w;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    public Vec4 swap(Vec4 v) {
        float tempX = this.x;
        float tempY = this.y;
        float tempZ = this.z;
        float tempW = this.w;
        this.x = v.getX();
        this.y = v.getY();
        this.z = v.getZ();
        this.w = v.getW();
        v.x = (tempX);
        v.y = (tempY);
        v.z = (tempZ);
        v.w = (tempW);
        return this;
    }

    @Override
    public String toString() {
        return (this.isHor() ? "hor" : "ver") + "(" + this.x + " " + this.y + " " + this.z + " " + this.w + ")";
    }

    public boolean equals(Object o) {
        if (o instanceof Vec4Readable) {
            Vec4Readable vec = (Vec4Readable) o;
            return this.x == vec.getX() && this.y == vec.getY() && this.z == vec.getZ() && this.w == vec.getW();
        }
        return false;
    }

    // STATIC METHODS

    public static float dot(Vec4Readable a, Vec4Readable b) {
        return a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ() + a.getW() * b.getW();
    }

    public static float angle(Vec4Readable a, Vec4Readable b) {
        return (float) Math.toDegrees(Math.acos(dot(a, b) / (a.getLength() * b.getLength())));
    }

    public static Vec4 add(Vec4Readable a, float r) {
        return new Vec4(a).add(r);
    }

    public static Vec4 sub(Vec4Readable a, float r) {
        return new Vec4(a).sub(r);
    }

    public static Vec4 sub(float r, Vec4Readable a) {
        return new Vec4(a).presub(r);
    }

    public static Vec4 mul(Vec4Readable a, float r) {
        return new Vec4(a).mul(r);
    }

    public static Vec4 div(Vec4Readable a, float r) {
        return new Vec4(a).div(r);
    }

    public static Vec4 div(float r, Vec4Readable a) {
        return new Vec4(a).prediv(r);
    }

    public static Vec4 negate(Vec4Readable a) {
        return new Vec4(a).negate();
    }

    public static Vec4 floor(Vec4Readable a, float r) {
        return new Vec4(a).floor(r);
    }

    public static Vec4 toInt(Vec4Readable a) {
        return new Vec4(a).toInt();
    }

    public static Vec4 absElementWise(Vec4Readable a) {
        return new Vec4(a).absElementWise();
    }

    public static Vec4 round(Vec4Readable a) {
        return new Vec4(a).round();
    }

    public static Vec4 normalize(Vec4Readable a) {
        return new Vec4(a).normalize();
    }

    public static Vec4 add(Vec4Readable a, Vec4Readable b) {
        return new Vec4(a).add(b);
    }

    public static Vec4 sub(Vec4Readable a, Vec4Readable b) {
        return new Vec4(a).sub(b);
    }

    public static Vec4 mul(Vec4Readable a, Mat4Readable m) {
        return new Vec4(a).mul(m);
    }

    public static Vec4 mul(Mat4Readable m, Vec4Readable a) {
        return new Vec4(a).premul(m);
    }

    public static Vec4 normalizeHomogeneousCoordinates(Vec4Readable a) {
        return new Vec4(a).normalizeHomogeneousCoordinates();
    }

}
