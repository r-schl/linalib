package linalib;

import java.nio.FloatBuffer;

public class Quaternion implements QuaternionReadable {

    public static final QuaternionReadable IDENTITY = new Quaternion(1, 0, 0, 0);

    public float w; // the scalar value
    public float x; // i
    public float y; // j
    public float z; // k

    public Quaternion() {
        this(IDENTITY);
    }

    public Quaternion(float w, float x, float y, float z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Quaternion(QuaternionReadable other) {
        this.w = other.getW();
        this.x = other.getX();
        this.y = other.getY();
        this.z = other.getZ();
    }

    @Override
    public float getW() {
        return w;
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
    public float getLength() {
        return (float) Math.sqrt(this.getLength2());
    }

    @Override
    public float getLength2() {
        return w * w + x * x + y * y + z * z;
    }

    @Override
    public float getNorm() {
        return this.getLength2();
    }

    @Override
    public boolean isPure() {
        return w == 0;
    }

    @Override
    public float[] newArr() {
        return new float[] { w, x, y, z };
    }

    @Override
    public void storeInBuffer(FloatBuffer buf) {
        buf.put(w);
        buf.put(x);
        buf.put(y);
        buf.put(z);
    }

    @Override
    public boolean contains(float r) {
        return w == r || x == r || y == r || z == r;
    }

    @Override
    public float getRotAngle() {
        return (float) Math.toDegrees(Math.acos(this.w) * 2);
    }

    @Override
    public Vec3 getRotAxis() {
        float sinHalfAngle = (float) Math.sin(Math.toRadians(this.getRotAngle()) / 2);
        return new Vec3(this.x / sinHalfAngle, this.y / sinHalfAngle, this.z / sinHalfAngle);
    }

    // SETTERS

    public Quaternion set(QuaternionReadable q) {
        this.w = q.getW();
        this.x = q.getX();
        this.y = q.getY();
        this.z = q.getZ();
        return this;
    }

    public Quaternion set(float w, float x, float y, float z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public Quaternion setRotation(Vec3Readable axis, float angle) {
        float axisX = axis.getX();
        float axisY = axis.getY();
        float axisZ = axis.getZ();
        float len = (float) Math.sqrt(axisX * axisX + axisY * axisY + axisZ * axisZ);
        axisX = axisX / len;
        axisY = axisY / len;
        axisZ = axisZ / len;
        float sinHalfAngle = (float) Math.sin(Math.toRadians(angle) / 2);
        float cosHalfAngle = (float) Math.cos(Math.toRadians(angle) / 2);
        this.w = cosHalfAngle;
        this.x = axisX * sinHalfAngle;
        this.y = axisY * sinHalfAngle;
        this.z = axisZ * sinHalfAngle;
        return this;
    }

    public Quaternion normalize() {
        float len = this.getLength();
        this.w /= len;
        this.x /= len;
        this.y /= len;
        this.z /= len;
        return this;
    }

    public Quaternion conjugate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public Quaternion mul(QuaternionReadable q) {
        final float thisW = this.getW();
        final float thisX = this.getX();
        final float thisY = this.getY();
        final float thisZ = this.getZ();
        this.w = thisW * q.getW() - thisX * q.getX() - thisY * q.getY() - thisZ * q.getZ();
        this.x = thisW * q.getX() + thisX * q.getW() + thisY * q.getZ() - thisZ * q.getY();
        this.y = thisW * q.getY() - thisX * q.getZ() + thisY * q.getW() + thisZ * q.getX();
        this.z = thisW * q.getZ() + thisX * q.getY() - thisY * q.getX() + thisZ * q.getW();
        return this;
    }

    public Quaternion premul(QuaternionReadable q) {
        final float thisW = this.getW();
        final float thisX = this.getX();
        final float thisY = this.getY();
        final float thisZ = this.getZ();
        this.w = q.getW() * thisW - q.getX() * thisX - q.getY() * thisY - q.getZ() * thisZ;
        this.x = q.getW() * thisX + q.getX() * thisW + q.getY() * thisZ - q.getZ() * thisY;
        this.y = q.getW() * thisY - q.getX() * thisZ + q.getY() * thisW + q.getZ() * thisX;
        this.z = q.getW() * thisZ + q.getX() * thisY - q.getY() * thisX + q.getZ() * thisW;
        return this;
    }

    public Quaternion mul(Vec3Readable v) {
        float thisW = this.w;
        float thisX = this.x;
        float thisY = this.y;
        float thisZ = this.z;
        this.w = -thisX * v.getX() - thisY * v.getY() - thisZ * v.getZ();
        this.x = thisW * v.getX() + thisY * v.getZ() - thisZ * v.getY();
        this.y = thisW * v.getY() + thisZ * v.getX() - thisX * v.getZ();
        this.z = thisW * v.getZ() + thisX * v.getY() - thisY * v.getX();
        return this;
    }

    public Quaternion mulThisVecConjugate(Vec3Readable v) {
        float thisW = this.w;
        float thisX = this.x;
        float thisY = this.y;
        float thisZ = this.z;
        // Quaternion vector product
        this.mul(v);
        // Quaternion conjugate product
        this.mul(new Quaternion(thisW, -thisX, -thisY, -thisZ));
        return this;
    }

    // STATIC METHODS

    public static Quaternion initRotation(Vec3Readable axis, float angle) {
        return new Quaternion().setRotation(axis, angle);
    }

    public static Quaternion normalize(QuaternionReadable q) {
        return new Quaternion(q).normalize();
    }

    public static Quaternion conjugate(QuaternionReadable q) {
        return new Quaternion(q).conjugate();
    }

    public static Quaternion mul(QuaternionReadable q1, QuaternionReadable q2) {
        return new Quaternion(q1).mul(q2);
    }

    public static Quaternion mul(QuaternionReadable q, Vec3Readable v) {
        return new Quaternion(q).mul(v);
    }

}
