package linalib;

import java.nio.FloatBuffer;

public class Vec3 implements Vec3Readable {

    public static final Vec3Readable XAXIS = new Vec3(1, 0, 0);
    public static final Vec3Readable YAXIS = new Vec3(0, 1, 0);
    public static final Vec3Readable ZAXIS = new Vec3(0, 0, 1);

    /*
     * LinALib uses a right-handed coordinate system. The y-axis is directed
     * upwards, the x-axis to the right and the z-axis to the front.
     */

    public static final Vec3Readable UP = new Vec3(YAXIS);
    public static final Vec3Readable DOWN = new Vec3(YAXIS).negate();
    public static final Vec3Readable RIGHT = new Vec3(XAXIS);
    public static final Vec3Readable LEFT = new Vec3(XAXIS).negate();
    public static final Vec3Readable FORWARD = new Vec3(ZAXIS);
    public static final Vec3Readable BACKWARD = new Vec3(ZAXIS).negate();

    public float x;
    public float y;
    public float z;

    private boolean isTransposed;

    public Vec3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3(Vec2 vec2, float z) {
        this.x = vec2.getX();
        this.y = vec2.getY();
        this.z = z;
    }

    public Vec3(float xyz) {
        this(xyz, xyz, xyz);
    }

    public Vec3(Vec4Readable v) {
        this(v.getX(), v.getY(), v.getZ());
    }

    public Vec3(Vec3Readable other) {
        this(other.getX(), other.getY(), other.getZ());
        if (other.isTransposed())
            this.transpose();
    }

    public float getLength() {
        return (float) Math.sqrt(this.getLength2());
    }

    public float getLength2() {
        return x * x + y * y + z * z;
    }

    public float getMax() {
        float max = this.x;
        if (this.y > max)
            max = this.y;
        if (this.z > max)
            max = this.z;
        return max;
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
    }

    @Override
    public float[][] getNewArr2() {
        return this.isHor() ? new float[][] { { x, y, z } } : new float[][] { { x }, { y }, { z } };
    }

    @Override
    public float[] getNewArr() {
        return new float[] { x, y, z };
    }

    @Override
    public boolean contains(float r) {
        return this.x == r || this.y == r || this.z == r;
    }

    @Override
    public float getX() {
        return this.x;
    }

    @Override
    public float getY() {
        return this.y;
    }

    @Override
    public float getZ() {
        return this.z;
    }

    // SETTER METHODS

    public Vec3 transpose() {
        isTransposed = !isTransposed;
        return this;
    }

    public Vec3 set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public Vec3 set(Vec3Readable other) {
        this.x = other.getX();
        this.y = other.getY();
        this.z = other.getZ();
        return this;
    }

    public Vec3 add(float r) {
        this.x = this.x + r;
        this.y = this.y + r;
        this.z = this.z + r;
        return this;
    }

    public Vec3 sub(float r) {
        this.x = this.x - r;
        this.y = this.y - r;
        this.z = this.z - r;
        return this;
    }

    public Vec3 presub(float r) {
        this.x = r - this.x;
        this.y = r - this.y;
        this.z = r - this.z;
        return this;
    }

    public Vec3 mul(float r) {
        this.x = this.x * r;
        this.y = this.y * r;
        this.z = this.z * r;
        return this;
    }

    public Vec3 div(float r) {
        if (r == 0)
            throw new IllegalArgumentException("Cannot divide by 0");
        this.x = this.x / r;
        this.y = this.y / r;
        this.z = this.z / r;
        return this;
    }

    public Vec3 prediv(float r) {
        if (this.contains(0))
            throw new IllegalArgumentException("Cannot divide by 0");
        this.x = r / this.x;
        this.y = r / this.y;
        this.z = r / this.z;
        return this;
    }

    public Vec3 negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public Vec3 floor(float r) {
        this.x = (this.x - (this.x % r));
        this.y = (this.y - (this.y % r));
        this.z = (this.z - (this.z % r));
        return this;
    }

    public Vec3 toInt() {
        this.x = (int) this.x;
        this.y = (int) this.y;
        this.z = (int) this.z;
        return this;
    }

    public Vec3 absElementWise() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        return this;
    }

    public Vec3 round() {
        this.x = Math.round(x);
        this.y = Math.round(y);
        this.z = Math.round(z);
        return this;
    }

    public Vec3 normalize() {
        return this.div(this.getLength());
    }

    public Vec3 cross(Vec3Readable v) {
        float x = this.y * v.getZ() - this.z * v.getY();
        float y = this.z * v.getX() - this.x * v.getZ();
        float z = this.x * v.getY() - this.y * v.getX();
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public Vec3 precross(Vec3Readable v) {
        float x = v.getY() * this.z - v.getZ() * this.y;
        float y = v.getZ() * this.x - v.getX() * this.z;
        float z = v.getX() * this.y - v.getY() * this.x;
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public Vec3 add(Vec3Readable v) {
        this.x = this.x + v.getX();
        this.y = this.y + v.getY();
        this.z = this.z + v.getZ();
        return this;
    }

    public Vec3 sub(Vec3Readable v) {
        this.x = this.x - v.getX();
        this.y = this.y - v.getY();
        this.z = this.z - v.getZ();
        return this;
    }

    public Vec3 presub(Vec3Readable v) {
        this.x = v.getX() - this.x;
        this.y = v.getY() - this.y;
        this.z = v.getZ() - this.z;
        return this;
    }

    public Vec3 mul(Mat3Readable mat) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 3x3 matrix.").printStackTrace();
            System.exit(-1);
        }
        float x = this.x * mat.get00() + this.y * mat.get10() + this.z * mat.get20();
        float y = this.x * mat.get01() + this.y * mat.get11() + this.z * mat.get21();
        float z = this.x * mat.get02() + this.y * mat.get12() + this.z * mat.get22();
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public Vec3 normalizeHomogeneousCoordinates() {
        this.x = x / this.z;
        this.y = y / this.z;
        this.z = z / this.z;
        return this;
    }

    public Vec3 premul(Mat3Readable mat) {
        if (isHor()) {
            new Exception("Cannot multiply 3x3 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        float x = mat.get00() * this.x + mat.get01() * this.y + mat.get02() * this.z;
        float y = mat.get10() * this.x + mat.get11() * this.y + mat.get12() * this.z;
        float z = mat.get20() * this.x + mat.get21() * this.y + mat.get22() * this.z;
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public Vec3 swap(Vec3 v) {
        float tempX = this.x;
        float tempY = this.y;
        float tempZ = this.z;
        this.x = v.getX();
        this.y = v.getY();
        this.z = v.getZ();
        v.x = tempX;
        v.y = tempY;
        v.z = tempZ;
        return this;
    }

    @Override
    public String toString() {
        return (this.isHor() ? "hor" : "ver") + "(" + this.x + " " + this.y + " " + this.z + ")";
    }

    public boolean equals(Object o) {
        if (o instanceof Vec3Readable) {
            Vec3Readable vec = (Vec3Readable) o;
            return this.x == vec.getX() && this.y == vec.getY() && this.z == vec.getZ();
        }
        return false;
    }

    /*
     * public Vec3 flip() {
     * if (this.isHor())
     * return this.mul(Mat3.FLIP);
     * return this.premul(Mat3.FLIP);
     * }
     */

    public Vec3 rotateByAxisAngle(Vec3Readable axis, float angle) {
        float axisX = axis.getX();
        float axisY = axis.getY();
        float axisZ = axis.getZ();

        angle = (float) Math.toRadians(angle);
        // normalize axis vector
        float len = (float) Math.sqrt(axisX * axisX + axisY * axisY + axisZ * axisZ);
        float aX = axisX / len;
        float aY = axisY / len;
        float aZ = axisZ / len;
        // Rodrigues' rotation formula
        Vec3 p2 = new Vec3(aX, aY, aZ).cross(this).mul((float) Math.sin(angle));
        Vec3 k = new Vec3(aX, aY, aZ);
        Vec3 p3 = k.mul(dot(k, this)).mul((float) (1 - Math.cos(angle)));
        this.mul((float) Math.cos(angle));
        return this.add(p2).add(p3);
    }

    public Vec3 rotateByQuaternion(QuaternionReadable q) {
        // Multiply the quaternion with this vector and store result in temporary
        // variables.
        float tw = -q.getX() * this.x - q.getY() * this.y - q.getZ() * this.z;
        float tx = q.getW() * this.x + q.getY() * this.z - q.getZ() * this.y;
        float ty = q.getW() * this.y + q.getZ() * this.x - q.getX() * this.z;
        float tz = q.getW() * this.z + q.getX() * this.y - q.getY() * this.x;
        // Extract values from the quaternion and conjugate them.
        float conjW = q.getW();
        float conjX = -q.getX();
        float conjY = -q.getY();
        float conjZ = -q.getZ();
        // Multiply temporary result with the conjugate of the quaternion.
        float resX = tw * conjX + tx * conjW + ty * conjZ - tz * conjY;
        float resY = tw * conjY - tx * conjZ + ty * conjW + tz * conjX;
        float resZ = tw * conjZ + tx * conjY - ty * conjX + tz * conjW;
        return this.set(resX, resY, resZ);
    }

    // STATIC METHODS

    public static float dot(Vec3Readable a, Vec3Readable b) {
        return a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ();
    }

    public static float angle(Vec3Readable a, Vec3Readable b) {
        return (float) Math.toDegrees(Math.acos(dot(a, b) / (a.getLength() * b.getLength())));
    }

    public static Vec3 add(Vec3Readable a, float r) {
        return new Vec3(a).add(r);
    }

    public static Vec3 sub(Vec3Readable a, float r) {
        return new Vec3(a).sub(r);
    }

    public static Vec3 sub(float r, Vec3Readable a) {
        return new Vec3(a).presub(r);
    }

    public static Vec3 mul(Vec3Readable a, float r) {
        return new Vec3(a).mul(r);
    }

    public static Vec3 div(Vec3Readable a, float r) {
        return new Vec3(a).div(r);
    }

    public static Vec3 div(float r, Vec3Readable a) {
        return new Vec3(a).prediv(r);
    }

    public static Vec3 negate(Vec3Readable a) {
        return new Vec3(a).negate();
    }

    public static Vec3 floor(Vec3Readable a, float r) {
        return new Vec3(a).floor(r);
    }

    public static Vec3 round(Vec3Readable a) {
        return new Vec3(a).round();
    }

    public static Vec3 normalize(Vec3Readable a) {
        return new Vec3(a).normalize();
    }

    public static Vec3 toInt(Vec3Readable a) {
        return new Vec3(a).toInt();
    }

    public static Vec3 absElementWise(Vec3Readable a) {
        return new Vec3(a).absElementWise();
    }

    public static Vec3 cross(Vec3Readable a, Vec3Readable b) {
        return new Vec3(a).cross(b);
    }

    public static Vec3 add(Vec3Readable a, Vec3Readable b) {
        return new Vec3(a).add(b);
    }

    public static Vec3 sub(Vec3Readable a, Vec3Readable b) {
        return new Vec3(a).sub(b);
    }

    public static Vec3 rotateAxisAngle(Vec3Readable a, Vec3Readable axis, float angle) {
        return new Vec3(a).rotateByAxisAngle(axis, angle);
    }

    public static Vec3 rotateByQuaternion(Vec3Readable v, QuaternionReadable q) {
        return new Vec3(v).rotateByQuaternion(q);
    }

    public static Vec3 mul(Vec3Readable v, Mat3Readable m) {
        return new Vec3(v).mul(m);
    }

    public static Vec3 mul(Mat3Readable m, Vec3Readable v) {
        return new Vec3(v).premul(m);
    }

    public static Vec3 normalizeHomogeneousCoordinates(Vec3Readable a) {
        return new Vec3(a).normalizeHomogeneousCoordinates();
    }

}
