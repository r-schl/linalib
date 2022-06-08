package linalib.flt;

import java.nio.FloatBuffer;

public class Vec3 implements Vec3Readable, VecWritable {

    // static presets
    public static final Vec3Readable XAXIS = new Vec3(1, 0, 0);
    public static final Vec3Readable YAXIS = new Vec3(0, 1, 0);
    public static final Vec3Readable ZAXIS = new Vec3(0, 0, 1);
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

    public Vec3(float xyz) {
        this(xyz, xyz, xyz);
    }

    public Vec3(Vec2Readable other, float z) {
        this(other.getX(), other.getY(), z);
        if (other.isTransposed())
            this.transpose();
    }

    public Vec3(Vec3Readable other) {
        this(other.getX(), other.getY(), other.getZ());
        if (other.isTransposed())
            this.transpose();
    }

    public Vec3(Vec4Readable other) {
        this(other.getX(), other.getY(), other.getZ());
        if (other.isTransposed())
            this.transpose();
    }

    public Vec3(QuaternionReadable quat) {
        this(quat.getX(), quat.getY(), quat.getZ());
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

 /*    @Override
    public float dot(Vec3Readable v) {
        return this.x * v.getX() + this.y * v.getY() + this.z * v.getZ();
    }

    @Override
    public float dot(float vX, float vY, float vZ) {
        return this.x * vX + this.y * vY + this.z * vZ;
    }
 */
    @Override
    public float len() {
        return (float) Math.sqrt(this.len2());
    }

    @Override
    public float len2() {
        return x * x + y * y + z * z;
    }

    @Override
    public float get(int i) {
        if (i == 0)
            return this.x;
        else if (i == 1)
            return this.y;
        else if (i == 2)
            return this.z;
        else
            new Exception("Index out of range for vector dimension " + this.size()).printStackTrace();;
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
        return max;
    }

    @Override
    public Vec3 storeInside(FloatBuffer buf) {
        buf.put(x);
        buf.put(y);
        buf.put(z);
        return this;
    }

    @Override
    public float[][] newArr2() {
        return this.isHor() ? new float[][] { { x, y, z } } : new float[][] { { x }, { y }, { z } };
    }

    @Override
    public float[] newArr() {
        return new float[] { x, y, z };
    }

    @Override
    public boolean contains(float r) {
        return this.x == r || this.y == r || this.z == r;
    }

    @Override
    public Vec3 set(int i, float val) {
        if (i == 0)
            this.x = val;
        else if (i == 1)
            this.y = val;
        else if (i == 2)
            this.z = val;
        return this;
    }

    @Override
    public Vec3 toInt() {
        this.x = (int) this.x;
        this.y = (int) this.y;
        this.z = (int) this.z;
        return this;
    }

    @Override
    public Vec3 absElWise() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        return this;
    }

    @Override
    public Vec3 add(float r) {
        this.x = this.x + r;
        this.y = this.y + r;
        this.z = this.z + r;
        return this;
    }

    @Override
    public Vec3 sub(float r) {
        this.x = this.x - r;
        this.y = this.y - r;
        this.z = this.z - r;
        return this;
    }

    @Override
    public Vec3 presub(float r) {
        this.x = r - this.x;
        this.y = r - this.y;
        this.z = r - this.z;
        return this;
    }

    @Override
    public Vec3 mul(float r) {
        this.x = this.x * r;
        this.y = this.y * r;
        this.z = this.z * r;
        return this;
    }

    @Override
    public Vec3 div(float r) {
        if (r == 0)
            throw new IllegalArgumentException("Cannot divide by 0");
        this.x = this.x / r;
        this.y = this.y / r;
        this.z = this.z / r;
        return this;
    }

    @Override
    public Vec3 prediv(float r) {
        if (this.contains(0))
            throw new IllegalArgumentException("Cannot divide by 0");
        this.x = r / this.x;
        this.y = r / this.y;
        this.z = r / this.z;
        return this;
    }

    @Override
    public Vec3 negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    @Override
    public Vec3 floor(float r) {
        this.x = (this.x - (this.x % r));
        this.y = (this.y - (this.y % r));
        this.z = (this.z - (this.z % r));
        return this;
    }

    @Override
    public Vec3 round() {
        this.x = Math.round(x);
        this.y = Math.round(y);
        this.z = Math.round(z);
        return this;
    }

    @Override
    public Vec3 normalize() {
        return this.div(this.len());
    }

    @Override
    public Vec3 flip() {
        if (this.isHor())
            return this.mul(Mat3.FLIP);
        return this.premul(Mat3.FLIP);
    }

    @Override
    public Vec3 transpose() {
        isTransposed = !isTransposed;
        return this;
    }

    public Vec3 setX(float val) {
        this.x = val;
        return this;
    }

    public Vec3 setY(float val) {
        this.y = val;
        return this;
    }

    public Vec3 setZ(float val) {
        this.z = val;
        return this;
    }

    public Vec3 set(Vec3Readable v) {
        this.x = v.getX();
        this.y = v.getY();
        this.z = v.getZ();
        return this;
    }

    public Vec3 set(float vX, float vY, float vZ) {
        this.x = vX;
        this.y = vY;
        this.z = vZ;
        return this;
    }

    public Vec3 set(Vec2Readable v, float z) {
        return this.set(v.getX(), v.getY(), z);
    }

    public Vec3 set(Vec4Readable v) {
        return this.set(v.getX(), v.getY(), v.getZ());
    }

    public Vec3 set(QuaternionReadable q) {
        return this.set(q.getX(), q.getY(), q.getZ());
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

    public Vec3 cross(float vX, float vY, float vZ) {
        float x = this.y * vZ - this.z * vY;
        float y = this.z * vX - this.x * vZ;
        float z = this.x * vY - this.y * vX;
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

    public Vec3 precross(float vX, float vY, float vZ) {
        float x = vY * this.z - vZ * this.y;
        float y = vZ * this.x - vX * this.z;
        float z = vX * this.y - vY * this.x;
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

    public Vec3 add(float vX, float vY, float vZ) {
        this.x = this.x + vX;
        this.y = this.y + vY;
        this.z = this.z + vZ;
        return this;
    }

    public Vec3 sub(Vec3Readable v) {
        this.x = this.x - v.getX();
        this.y = this.y - v.getY();
        this.z = this.z - v.getZ();
        return this;
    }

    public Vec3 sub(float vX, float vY, float vZ) {
        this.x = this.x - vX;
        this.y = this.y - vY;
        this.z = this.z - vZ;
        return this;
    }

    public Vec3 presub(Vec3Readable v) {
        this.x = v.getX() - this.x;
        this.y = v.getY() - this.y;
        this.z = v.getZ() - this.z;
        return this;
    }

    public Vec3 presub(float vX, float vY, float vZ) {
        this.x = vX - this.x;
        this.y = vY - this.y;
        this.z = vZ - this.z;
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

    public Vec3 mul(float mat00, float mat01, float mat02, float mat10, float mat11, float mat12, float mat20,
            float mat21, float mat22) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 3x3 matrix.").printStackTrace();
            System.exit(-1);
        }
        float x = this.x * mat00 + this.y * mat10 + this.z * mat20;
        float y = this.x * mat01 + this.y * mat11 + this.z * mat21;
        float z = this.x * mat02 + this.y * mat12 + this.z * mat22;
        this.x = x;
        this.y = y;
        this.z = z;
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

    public Vec3 premul(float mat00, float mat01, float mat02, float mat10, float mat11, float mat12, float mat20,
            float mat21, float mat22) {
        if (isHor()) {
            new Exception("Cannot multiply 3x3 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        float x = mat00 * this.x + mat01 * this.y + mat02 * this.z;
        float y = mat10 * this.x + mat11 * this.y + mat12 * this.z;
        float z = mat20 * this.x + mat21 * this.y + mat22 * this.z;
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
        v.setX(tempX);
        v.setY(tempY);
        v.setZ(tempZ);
        return this;
    }

    @Override
    public String toString() {
        return (this.isHor() ? "hor" : "ver") + "(" + this.x + " " + this.y + " " + this.z + ")";
    }

    public Vec3 to(VecWritable v) {
        this.extractTo(v);
        return this;
    }

    public Vec3 from(VecReadable v) {
        this.extractFrom(v);
        return this;
    }

    public boolean equals(Object o) {
        if (o instanceof Vec3Readable) {
            Vec3Readable vec = (Vec3Readable) o;
            return this.x == vec.getX() && this.y == vec.getY() && this.z == vec.getZ();
        }
        return false;
    }

    public Vec3 rotateAxisAngle(float angle, Vec3Readable axis) {
        return this.rotateAxisAngle(angle, axis.getX(), axis.getY(), axis.getZ());
    }

    public Vec3 rotateAxisAngle(float angle, float axisX, float axisY, float axisZ) {
        angle = (float) Math.toRadians(angle);
        // normalize axis vector
        float len = (float) Math.sqrt(axisX * axisX + axisY * axisY + axisZ * axisZ);
        float aX = axisX / len;
        float aY = axisY / len;
        float aZ = axisZ / len;
        // Rodrigues' rotation formula
        Vec3 p2 = new Vec3(aX, aY, aZ).cross(this).mul((float) Math.sin(angle));
        Vec3 k = new Vec3(aX, aY, aZ);
        Vec3 p3 = k.mul(k.dot(this)).mul((float) (1 - Math.cos(angle)));
        this.mul((float) Math.cos(angle));
        return this.add(p2).add(p3);
    }

    public Vec3 rotateQuaternion(QuaternionReadable q) {
         // Multiply the quaternion with this vector and store result in temporary variables.
         float tw = -q.getX() * this.x - q.getY() * this.y - q.getZ() * this.z;
         float tx =  q.getW() * this.x + q.getY() * this.z - q.getZ() * this.y;
         float ty =  q.getW() * this.y + q.getZ() * this.x - q.getX() * this.z;
         float tz =  q.getW() * this.z + q.getX() * this.y - q.getY() * this.x;
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

    public Vec3 rotateQuaternion(float qw, float qx, float qy, float qz) {
        // Multiply the quaternion with this vector and store result in temporary variables.
        float tw = -qx * this.x - qy * this.y - qz * this.z;
        float tx =  qw * this.x + qy * this.z - qz * this.y;
        float ty =  qw * this.y + qz * this.x - qx * this.z;
        float tz =  qw * this.z + qx * this.y - qy * this.x;
        // Extract values from the quaternion and conjugate them.
        float conjW = qw;
        float conjX = -qx;
        float conjY = -qy;
        float conjZ = -qz;
        // Multiply temporary result with the conjugate of the quaternion.
        float resX = tw * conjX + tx * conjW + ty * conjZ - tz * conjY;
        float resY = tw * conjY - tx * conjZ + ty * conjW + tz * conjX;
        float resZ = tw * conjZ + tx * conjY - ty * conjX + tz * conjW;
        return this.set(resX, resY, resZ);
   }


   public static float dot(Vec3Readable a, Vec3Readable b) {
       return a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ();
   }



}