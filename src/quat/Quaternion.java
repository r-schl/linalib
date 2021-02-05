package quat;

import java.nio.FloatBuffer;

import vec.Vec3Readable;


public class Quaternion implements QuatWritable {

    public static final QuatReadable IDENTITY = new Quaternion(1, 0, 0, 0);

    public float w; // the scalar value
    public float x; // i
    public float y; // j
    public float z; // k

    public static Quaternion newRotation(float angle, Vec3Readable axis) {
        return new Quaternion().initRotation(angle, axis);
    }

    public Quaternion(float w, float x, float y, float z) {
        this.set(w, x, y, z);
    }

    public Quaternion(Quaternion other) {
        this.set(other);
    }

    public Quaternion() {
        this.set(IDENTITY);
    }

    @Override
    public float get(int i) {
        if (i == 0)
            return w;
        else if (i == 1)
            return x;
        else if (i == 2)
            return y;
        else if (i == 3)
            return z;
        else
            new Exception("Index out of range for quaternion dimension").printStackTrace();
        return -1;
    }

    @Override
    public float getW() {
        return this.w;
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

    @Override
    public float len() {
        return (float) Math.sqrt(len2());
    }

    @Override
    public float len2() {
        return w * w + x * x + y * y + z * z;
    }

    @Override
    public float norm() {
        return w * w + x * x + y * y + z * z;
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
    public Quaternion storeInside(FloatBuffer buf) {
        buf.put(w);
        buf.put(x);
        buf.put(y);
        buf.put(z);
        return this;
    }

    @Override
    public boolean contains(float r) {
        return w == r || x == r || y == r || z == r;
    }

    @Override
    public Quaternion set(int i, float r) {
        if (i == 0)
            this.w = r;
        else if (i == 1)
            this.x = r;
        else if (i == 2)
            this.y = r;
        else if (i == 3)
            this.z = r;
        return this;
    }

    @Override
    public Quaternion setW(float r) {
        this.w = r;
        return this;
    }

    @Override
    public Quaternion setX(float r) {
        this.x = r;
        return this;
    }

    @Override
    public Quaternion setY(float r) {
        this.y = r;
        return this;
    }

    @Override
    public Quaternion setZ(float r) {
        this.z = r;
        return this;
    }

    @Override
    public Quaternion set(QuatReadable q) {
        this.w = q.getW();
        this.x = q.getX();
        this.y = q.getY();
        this.z = q.getZ();
        return this;
    }

    @Override
    public Quaternion set(float w, float x, float y, float z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    @Override
    public Quaternion initRotation(float angle, Vec3Readable axis) {
        return this.initRotation(angle, axis.getX(), axis.getY(), axis.getZ());
    }

    @Override
    public Quaternion initRotation(float angle, float axisX, float axisY, float axisZ) {
        float len = (float) Math.sqrt(axisX * axisX + axisY * axisY + axisZ * axisZ);
        axisX = axisX / len;
        axisY = axisY / len;
        axisZ = axisZ / len;
        float sinHalfAngle = (float)Math.sin(Math.toRadians(angle) / 2);
        float cosHalfAngle = (float)Math.cos(Math.toRadians(angle) / 2);
        this.set(cosHalfAngle, axisX * sinHalfAngle, axisY * sinHalfAngle, axisZ * sinHalfAngle);
        return this;
    }

    @Override
    public float getRotAngle() {
        return (float) Math.toDegrees(Math.acos(this.w) * 2);
    }

    @Override
    public float getRotAxisX() {
        float sinHalfAngle = (float) Math.sin(Math.toRadians(this.getRotAngle()) / 2);
        return this.x / sinHalfAngle;
    }

    @Override
    public float getRotAxisY() {
        float sinHalfAngle = (float) Math.sin(Math.toRadians(this.getRotAngle()) / 2);
        return this.y / sinHalfAngle;
    }

    @Override
    public float getRotAxisZ() {
        float sinHalfAngle = (float) Math.sin(Math.toRadians(this.getRotAngle()) / 2);
        return this.z / sinHalfAngle;
    }

    @Override
    public Quaternion normalize() {
        float len = this.len();
        this.w /= len;
        this.x /= len;
        this.y /= len;
        this.z /= len;
        return this;
    }

    @Override
    public Quaternion conjugate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    @Override
    public Quaternion mul(QuatReadable q) {
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

    @Override
    public Quaternion mul(float w, float x, float y, float z) {
        final float thisW = this.w;
        final float thisX = this.x;
        final float thisY = this.y;
        final float thisZ = this.z;
        this.w = thisW * w - thisX * x - thisY * y - thisZ * z;
        this.x = thisW * x + thisX * w + thisY * z - thisZ * y;
        this.y = thisW * y - thisX * z + thisY * w + thisZ * x;
        this.z = thisW * z + thisX * y - thisY * x + thisZ * w;
        return this;
    }

    @Override
    public Quaternion premul(QuatReadable q) {
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

    @Override
    public Quaternion premul(float w, float x, float y, float z) {
         final float thisW = this.getW();
         final float thisX = this.getX();
         final float thisY = this.getY();
         final float thisZ = this.getZ();
         this.w = w * thisW - x * thisX - y * thisY - z * thisZ;
         this.x = w * thisX + x * thisW + y * thisZ - z * thisY;
         this.y = w * thisY - x * thisZ + y * thisW + z * thisX;
         this.z = w * thisZ + x * thisY - y * thisX + z * thisW;
         return this;
    }

    @Override
    public Quaternion mulThisVecConjugate(Vec3Readable v) {
        float thisW = this.w;
        float thisX = this.x;
        float thisY = this.y;
        float thisZ = this.z;
        // Quaternion vector product
        this.mul(v);
        // Quaternion conjugate product
        this.mul(thisW, -thisX, -thisY, -thisZ);
        return this;
    }

    @Override
    public Quaternion mulThisVecConjugate(float x, float y, float z) {
        float thisW = this.w;
        float thisX = this.x;
        float thisY = this.y;
        float thisZ = this.z;
        this.mul(x, y, z);
        return this.mul(thisW, -thisX, -thisY, -thisZ);
    }

    /**
     * This method multiplies this quaternion with another quaternion constructed by an angle and and rotation axis.
     * 
     * @param angle angle of rotation (in Degrees)
     * @param axis  rotation axis
     * @return
     */
    @Override
    public Quaternion mulWithRotation(float angle, Vec3Readable axis) {
        float sinHalfAngle = (float) Math.sin(Math.toRadians(angle) / 2);
        float cosHalfAngle = (float) Math.cos(Math.toRadians(angle) / 2);
        return this.mul(cosHalfAngle, axis.getX() * sinHalfAngle, axis.getY() * sinHalfAngle, axis.getZ() * sinHalfAngle);
    }

    @Override
    public Quaternion mulWithRotation(float angle, float axisX, float axisY, float axisZ) {
        float sinHalfAngle = (float) Math.sin(Math.toRadians(angle) / 2);
        float cosHalfAngle = (float) Math.cos(Math.toRadians(angle) / 2);
        return this.mul(cosHalfAngle, axisX * sinHalfAngle, axisY * sinHalfAngle, axisZ * sinHalfAngle);
    }

    @Override
    public Quaternion premulWithRotation(float angle, Vec3Readable axis) {
        float sinHalfAngle = (float) Math.sin(Math.toRadians(angle) / 2);
        float cosHalfAngle = (float) Math.cos(Math.toRadians(angle) / 2);
        return this.premul(cosHalfAngle, axis.getX() * sinHalfAngle, axis.getY() * sinHalfAngle, axis.getZ() * sinHalfAngle);
    }

    @Override
    public Quaternion premulWithRotation(float angle, float axisX, float axisY, float axisZ) {
        float sinHalfAngle = (float) Math.sin(Math.toRadians(angle) / 2);
        float cosHalfAngle = (float) Math.cos(Math.toRadians(angle) / 2);
        return this.premul(cosHalfAngle, axisX * sinHalfAngle, axisY * sinHalfAngle, axisZ * sinHalfAngle);
    }

    @Override
    public Quaternion mul(Vec3Readable v) {
        float thisW = this.w;
        float thisX = this.x;
        float thisY = this.y;
        float thisZ = this.z;
        this.w = -thisX * v.getX() - thisY * v.getY() - thisZ * v.getZ();
		this.x =  thisW * v.getX() + thisY * v.getZ() - thisZ * v.getY();
		this.y =  thisW * v.getY() + thisZ * v.getX() - thisX * v.getZ();
		this.z =  thisW * v.getZ() + thisX * v.getY() - thisY * v.getX();
        return this;
    }

    @Override
    public Quaternion mul(float x, float y, float z) {
        float thisW = this.w;
        float thisX = this.x;
        float thisY = this.y;
        float thisZ = this.z;
        this.w = -thisX * x - thisY * y - thisZ * z;
		this.x =  thisW * x + thisY * z - thisZ * y;
		this.y =  thisW * y + thisZ * x - thisX * z;
		this.z =  thisW * z + thisX * y - thisY * x;
        return this;
    }


    @Override
    public String toString() {
        return "q( " + w + " " + x + "i " + y + "j " + z + "k )";
    }

}
