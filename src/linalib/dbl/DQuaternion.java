package linalib.dbl;

import java.nio.DoubleBuffer;


public class DQuaternion implements DQuaternionReadable {

    public static final DQuaternionReadable IDENTITY = new DQuaternion(1, 0, 0, 0);

    public double w; // the scalar value
    public double x; // i
    public double y; // j
    public double z; // k

    public static DQuaternion newRotation(double angle, DVec3Readable axis) {
        return new DQuaternion().initRotation(angle, axis);
    }

    public DQuaternion(double w, double x, double y, double z) {
        this.set(w, x, y, z);
    }

    public DQuaternion(DQuaternionReadable other) {
        this.set(other);
    }

    public DQuaternion() {
        this.set(IDENTITY);
    }

    @Override
    public double get(int i) {
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
    public double getW() {
        return this.w;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public double getZ() {
        return this.z;
    }

    @Override
    public double len() {
        return (double) Math.sqrt(len2());
    }

    @Override
    public double len2() {
        return w * w + x * x + y * y + z * z;
    }

    @Override
    public double norm() {
        return w * w + x * x + y * y + z * z;
    }

    @Override
    public boolean isPure() {
        return w == 0;
    }

    @Override
    public double[] newArr() {
        return new double[] { w, x, y, z };
    }

    @Override
    public DQuaternion storeInside(DoubleBuffer buf) {
        buf.put(w);
        buf.put(x);
        buf.put(y);
        buf.put(z);
        return this;
    }

    @Override
    public boolean contains(double r) {
        return w == r || x == r || y == r || z == r;
    }

    public DQuaternion set(int i, double r) {
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

    public DQuaternion setW(double r) {
        this.w = r;
        return this;
    }

    public DQuaternion setX(double r) {
        this.x = r;
        return this;
    }

    public DQuaternion setY(double r) {
        this.y = r;
        return this;
    }

    public DQuaternion setZ(double r) {
        this.z = r;
        return this;
    }

    public DQuaternion set(DQuaternionReadable q) {
        this.w = q.getW();
        this.x = q.getX();
        this.y = q.getY();
        this.z = q.getZ();
        return this;
    }

    public DQuaternion set(double w, double x, double y, double z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public DQuaternion initRotation(double angle, DVec3Readable axis) {
        return this.initRotation(angle, axis.getX(), axis.getY(), axis.getZ());
    }

    public DQuaternion initRotation(double angle, double axisX, double axisY, double axisZ) {
        double len = (double) Math.sqrt(axisX * axisX + axisY * axisY + axisZ * axisZ);
        axisX = axisX / len;
        axisY = axisY / len;
        axisZ = axisZ / len;
        double sinHalfAngle = (double)Math.sin(Math.toRadians(angle) / 2);
        double cosHalfAngle = (double)Math.cos(Math.toRadians(angle) / 2);
        this.set(cosHalfAngle, axisX * sinHalfAngle, axisY * sinHalfAngle, axisZ * sinHalfAngle);
        return this;
    }

    @Override
    public double getRotAngle() {
        return (double) Math.toDegrees(Math.acos(this.w) * 2);
    }

    @Override
    public double getRotAxisX() {
        double sinHalfAngle = (double) Math.sin(Math.toRadians(this.getRotAngle()) / 2);
        return this.x / sinHalfAngle;
    }

    @Override
    public double getRotAxisY() {
        double sinHalfAngle = (double) Math.sin(Math.toRadians(this.getRotAngle()) / 2);
        return this.y / sinHalfAngle;
    }

    @Override
    public double getRotAxisZ() {
        double sinHalfAngle = (double) Math.sin(Math.toRadians(this.getRotAngle()) / 2);
        return this.z / sinHalfAngle;
    }

    public DQuaternion normalize() {
        double len = this.len();
        this.w /= len;
        this.x /= len;
        this.y /= len;
        this.z /= len;
        return this;
    }

    public DQuaternion conjugate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public DQuaternion mul(DQuaternionReadable q) {
        final double thisW = this.getW();
        final double thisX = this.getX();
        final double thisY = this.getY();
        final double thisZ = this.getZ();
        this.w = thisW * q.getW() - thisX * q.getX() - thisY * q.getY() - thisZ * q.getZ();
        this.x = thisW * q.getX() + thisX * q.getW() + thisY * q.getZ() - thisZ * q.getY();
        this.y = thisW * q.getY() - thisX * q.getZ() + thisY * q.getW() + thisZ * q.getX();
        this.z = thisW * q.getZ() + thisX * q.getY() - thisY * q.getX() + thisZ * q.getW();
        return this;
    }

    public DQuaternion mul(double w, double x, double y, double z) {
        final double thisW = this.w;
        final double thisX = this.x;
        final double thisY = this.y;
        final double thisZ = this.z;
        this.w = thisW * w - thisX * x - thisY * y - thisZ * z;
        this.x = thisW * x + thisX * w + thisY * z - thisZ * y;
        this.y = thisW * y - thisX * z + thisY * w + thisZ * x;
        this.z = thisW * z + thisX * y - thisY * x + thisZ * w;
        return this;
    }

    public DQuaternion premul(DQuaternionReadable q) {
        final double thisW = this.getW();
        final double thisX = this.getX();
        final double thisY = this.getY();
        final double thisZ = this.getZ();
        this.w = q.getW() * thisW - q.getX() * thisX - q.getY() * thisY - q.getZ() * thisZ;
        this.x = q.getW() * thisX + q.getX() * thisW + q.getY() * thisZ - q.getZ() * thisY;
        this.y = q.getW() * thisY - q.getX() * thisZ + q.getY() * thisW + q.getZ() * thisX;
        this.z = q.getW() * thisZ + q.getX() * thisY - q.getY() * thisX + q.getZ() * thisW;
        return this;
    }

    public DQuaternion premul(double w, double x, double y, double z) {
         final double thisW = this.getW();
         final double thisX = this.getX();
         final double thisY = this.getY();
         final double thisZ = this.getZ();
         this.w = w * thisW - x * thisX - y * thisY - z * thisZ;
         this.x = w * thisX + x * thisW + y * thisZ - z * thisY;
         this.y = w * thisY - x * thisZ + y * thisW + z * thisX;
         this.z = w * thisZ + x * thisY - y * thisX + z * thisW;
         return this;
    }

    public DQuaternion mulThisVecConjugate(DVec3Readable v) {
        double thisW = this.w;
        double thisX = this.x;
        double thisY = this.y;
        double thisZ = this.z;
        // Quaternion vector product
        this.mul(v);
        // Quaternion conjugate product
        this.mul(thisW, -thisX, -thisY, -thisZ);
        return this;
    }

    public DQuaternion mulThisVecConjugate(double x, double y, double z) {
        double thisW = this.w;
        double thisX = this.x;
        double thisY = this.y;
        double thisZ = this.z;
        this.mul(x, y, z);
        return this.mul(thisW, -thisX, -thisY, -thisZ);
    }

    public DQuaternion mulWithRotation(double angle, DVec3Readable axis) {
        double sinHalfAngle = (double) Math.sin(Math.toRadians(angle) / 2);
        double cosHalfAngle = (double) Math.cos(Math.toRadians(angle) / 2);
        return this.mul(cosHalfAngle, axis.getX() * sinHalfAngle, axis.getY() * sinHalfAngle, axis.getZ() * sinHalfAngle);
    }

    public DQuaternion mulWithRotation(double angle, double axisX, double axisY, double axisZ) {
        double sinHalfAngle = (double) Math.sin(Math.toRadians(angle) / 2);
        double cosHalfAngle = (double) Math.cos(Math.toRadians(angle) / 2);
        return this.mul(cosHalfAngle, axisX * sinHalfAngle, axisY * sinHalfAngle, axisZ * sinHalfAngle);
    }

    public DQuaternion premulWithRotation(double angle, DVec3Readable axis) {
        double sinHalfAngle = (double) Math.sin(Math.toRadians(angle) / 2);
        double cosHalfAngle = (double) Math.cos(Math.toRadians(angle) / 2);
        return this.premul(cosHalfAngle, axis.getX() * sinHalfAngle, axis.getY() * sinHalfAngle, axis.getZ() * sinHalfAngle);
    }

    public DQuaternion premulWithRotation(double angle, double axisX, double axisY, double axisZ) {
        double sinHalfAngle = (double) Math.sin(Math.toRadians(angle) / 2);
        double cosHalfAngle = (double) Math.cos(Math.toRadians(angle) / 2);
        return this.premul(cosHalfAngle, axisX * sinHalfAngle, axisY * sinHalfAngle, axisZ * sinHalfAngle);
    }

    public DQuaternion mul(DVec3Readable v) {
        double thisW = this.w;
        double thisX = this.x;
        double thisY = this.y;
        double thisZ = this.z;
        this.w = -thisX * v.getX() - thisY * v.getY() - thisZ * v.getZ();
		this.x =  thisW * v.getX() + thisY * v.getZ() - thisZ * v.getY();
		this.y =  thisW * v.getY() + thisZ * v.getX() - thisX * v.getZ();
		this.z =  thisW * v.getZ() + thisX * v.getY() - thisY * v.getX();
        return this;
    }

    public DQuaternion mul(double x, double y, double z) {
        double thisW = this.w;
        double thisX = this.x;
        double thisY = this.y;
        double thisZ = this.z;
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
