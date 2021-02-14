package linalib.d.vector;

import java.nio.DoubleBuffer;

import linalib.d.matrix.DMat3Readable;
import linalib.d.matrix.DMat3;
import linalib.d.quaternion.DQuaternionReadable;


public class DVec3 implements DVec3Readable, DVecWritable {

     // static presets
     public static final DVec3Readable XAXIS = new DVec3(1, 0, 0);
     public static final DVec3Readable YAXIS = new DVec3(0, 1, 0);
     public static final DVec3Readable ZAXIS = new DVec3(0, 0, 1);
     public static final DVec3Readable UP = new DVec3(YAXIS);
     public static final DVec3Readable DOWN = new DVec3(YAXIS).negate();
     public static final DVec3Readable RIGHT = new DVec3(XAXIS);
     public static final DVec3Readable LEFT = new DVec3(XAXIS).negate();
     public static final DVec3Readable FORWARD = new DVec3(ZAXIS);
     public static final DVec3Readable BACKWARD = new DVec3(ZAXIS).negate();
 
 
     public double x;
     public double y;
     public double z;
 
     private boolean isTransposed;
 
     public DVec3(double x, double y, double z) {
         this.x = x;
         this.y = y;
         this.z = z;
     }
 
     public DVec3(double xyz) {
         this(xyz, xyz, xyz);
     }
 
     public DVec3(DVec2Readable other, double z) {
         this(other.getX(), other.getY(), z);
         if (other.isTransposed())
             this.transpose();
     }
 
     public DVec3(DVec3Readable other) {
         this(other.getX(), other.getY(), other.getZ());
         if (other.isTransposed())
             this.transpose();
     }
 
     public DVec3(DVec4Readable other) {
         this(other.getX(), other.getY(), other.getZ());
         if (other.isTransposed())
             this.transpose();
     }
 
     public DVec3(DQuaternionReadable quat) {
         this(quat.getX(), quat.getY(), quat.getZ());
     }
 
     @Override
     public double getX() {
         return x;
     }
 
     @Override
     public double getY() {
         return y;
     }
 
     @Override
     public double getZ() {
         return z;
     }
 
     @Override
     public double dot(DVec3Readable v) {
         return this.x * v.getX() + this.y * v.getY() + this.z * v.getZ();
     }
 
     @Override
     public double dot(double vX, double vY, double vZ) {
         return this.x * vX + this.y * vY + this.z * vZ;
     }
 
     @Override
     public double len() {
         return (double) Math.sqrt(this.len2());
     }
 
     @Override
     public double len2() {
         return x * x + y * y + z * z;
     }
 
     @Override
     public double get(int i) {
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
     public double max() {
         double max = this.x;
         if (this.y > max)
             max = this.y;
         if (this.z > max)
             max = this.z;
         return max;
     }
 
     @Override
     public DVec3 storeInside(DoubleBuffer buf) {
         buf.put(x);
         buf.put(y);
         buf.put(z);
         return this;
     }
 
     @Override
     public double[][] newArr2() {
         return this.isHor() ? new double[][] { { x, y, z } } : new double[][] { { x }, { y }, { z } };
     }
 
     @Override
     public double[] newArr() {
         return new double[] { x, y, z };
     }
 
     @Override
     public boolean contains(double r) {
         return this.x == r || this.y == r || this.z == r;
     }
 
     @Override
     public DVec3 set(int i, double val) {
         if (i == 0)
             this.x = val;
         else if (i == 1)
             this.y = val;
         else if (i == 2)
             this.z = val;
         return this;
     }
 
     @Override
     public DVec3 toInt() {
         this.x = (int) this.x;
         this.y = (int) this.y;
         this.z = (int) this.z;
         return this;
     }
 
     @Override
     public DVec3 absElWise() {
         this.x = Math.abs(this.x);
         this.y = Math.abs(this.y);
         this.z = Math.abs(this.z);
         return this;
     }
 
     @Override
     public DVec3 add(double r) {
         this.x = this.x + r;
         this.y = this.y + r;
         this.z = this.z + r;
         return this;
     }
 
     @Override
     public DVec3 sub(double r) {
         this.x = this.x - r;
         this.y = this.y - r;
         this.z = this.z - r;
         return this;
     }
 
     @Override
     public DVec3 presub(double r) {
         this.x = r - this.x;
         this.y = r - this.y;
         this.z = r - this.z;
         return this;
     }
 
     @Override
     public DVec3 mul(double r) {
         this.x = this.x * r;
         this.y = this.y * r;
         this.z = this.z * r;
         return this;
     }
 
     @Override
     public DVec3 div(double r) {
         if (r == 0)
             throw new IllegalArgumentException("Cannot divide by 0");
         this.x = this.x / r;
         this.y = this.y / r;
         this.z = this.z / r;
         return this;
     }
 
     @Override
     public DVec3 prediv(double r) {
         if (this.contains(0))
             throw new IllegalArgumentException("Cannot divide by 0");
         this.x = r / this.x;
         this.y = r / this.y;
         this.z = r / this.z;
         return this;
     }
 
     @Override
     public DVec3 negate() {
         this.x = -this.x;
         this.y = -this.y;
         this.z = -this.z;
         return this;
     }
 
     @Override
     public DVec3 floor(double r) {
         this.x = (this.x - (this.x % r));
         this.y = (this.y - (this.y % r));
         this.z = (this.z - (this.z % r));
         return this;
     }
 
     @Override
     public DVec3 round() {
         this.x = Math.round(x);
         this.y = Math.round(y);
         this.z = Math.round(z);
         return this;
     }
 
     @Override
     public DVec3 normalize() {
         return this.div(this.len());
     }
 
     @Override
     public DVec3 flip() {
         if (this.isHor())
             return this.mul(DMat3.FLIP);
         return this.premul(DMat3.FLIP);
     }
 
     @Override
     public DVec3 transpose() {
         isTransposed = !isTransposed;
         return this;
     }
 
     public DVec3 setX(double val) {
         this.x = val;
         return this;
     }
 
     public DVec3 setY(double val) {
         this.y = val;
         return this;
     }
 
     public DVec3 setZ(double val) {
         this.z = val;
         return this;
     }
 
     public DVec3 set(DVec3Readable v) {
         this.x = v.getX();
         this.y = v.getY();
         this.z = v.getZ();
         return this;
     }
 
     public DVec3 set(double vX, double vY, double vZ) {
         this.x = vX;
         this.y = vY;
         this.z = vZ;
         return this;
     }
 
     public DVec3 set(DVec2Readable v, double z) {
         return this.set(v.getX(), v.getY(), z);
     }
 
     public DVec3 set(DVec4Readable v) {
         return this.set(v.getX(), v.getY(), v.getZ());
     }
 
     public DVec3 set(DQuaternionReadable q) {
         return this.set(q.getX(), q.getY(), q.getZ());
     }
 
     public DVec3 cross(DVec3Readable v) {
         double x = this.y * v.getZ() - this.z * v.getY();
         double y = this.z * v.getX() - this.x * v.getZ();
         double z = this.x * v.getY() - this.y * v.getX();
         this.x = x;
         this.y = y;
         this.z = z;
         return this;
     }
 
     public DVec3 cross(double vX, double vY, double vZ) {
         double x = this.y * vZ - this.z * vY;
         double y = this.z * vX - this.x * vZ;
         double z = this.x * vY - this.y * vX;
         this.x = x;
         this.y = y;
         this.z = z;
         return this;
     }
 
     public DVec3 precross(DVec3Readable v) {
         double x = v.getY() * this.z - v.getZ() * this.y;
         double y = v.getZ() * this.x - v.getX() * this.z;
         double z = v.getX() * this.y - v.getY() * this.x;
         this.x = x;
         this.y = y;
         this.z = z;
         return this;
     }
 
     public DVec3 precross(double vX, double vY, double vZ) {
         double x = vY * this.z - vZ * this.y;
         double y = vZ * this.x - vX * this.z;
         double z = vX * this.y - vY * this.x;
         this.x = x;
         this.y = y;
         this.z = z;
         return this;
     }
 
     public DVec3 add(DVec3Readable v) {
         this.x = this.x + v.getX();
         this.y = this.y + v.getY();
         this.z = this.z + v.getZ();
         return this;
     }
 
     public DVec3 add(double vX, double vY, double vZ) {
         this.x = this.x + vX;
         this.y = this.y + vY;
         this.z = this.z + vZ;
         return this;
     }
 
     public DVec3 sub(DVec3Readable v) {
         this.x = this.x - v.getX();
         this.y = this.y - v.getY();
         this.z = this.z - v.getZ();
         return this;
     }
 
     public DVec3 sub(double vX, double vY, double vZ) {
         this.x = this.x - vX;
         this.y = this.y - vY;
         this.z = this.z - vZ;
         return this;
     }
 
     public DVec3 presub(DVec3Readable v) {
         this.x = v.getX() - this.x;
         this.y = v.getY() - this.y;
         this.z = v.getZ() - this.z;
         return this;
     }
 
     public DVec3 presub(double vX, double vY, double vZ) {
         this.x = vX - this.x;
         this.y = vY - this.y;
         this.z = vZ - this.z;
         return this;
     }
 
     public DVec3 mul(DMat3Readable mat) {
         if (isVer()) {
             new Exception("Cannot multiply a vertical vector with a 3x3 matrix.").printStackTrace();
             System.exit(-1);
         }
         double x = this.x * mat.get00() + this.y * mat.get10() + this.z * mat.get20();
         double y = this.x * mat.get01() + this.y * mat.get11() + this.z * mat.get21();
         double z = this.x * mat.get02() + this.y * mat.get12() + this.z * mat.get22();
         this.x = x;
         this.y = y;
         this.z = z;
         return this;
     }
 
     public DVec3 mul(double mat00, double mat01, double mat02, double mat10, double mat11, double mat12, double mat20,
             double mat21, double mat22) {
         if (isVer()) {
             new Exception("Cannot multiply a vertical vector with a 3x3 matrix.").printStackTrace();
             System.exit(-1);
         }
         double x = this.x * mat00 + this.y * mat10 + this.z * mat20;
         double y = this.x * mat01 + this.y * mat11 + this.z * mat21;
         double z = this.x * mat02 + this.y * mat12 + this.z * mat22;
         this.x = x;
         this.y = y;
         this.z = z;
         return this;
     }
 
     public DVec3 premul(DMat3Readable mat) {
         if (isHor()) {
             new Exception("Cannot multiply 3x3 matrix with an horizontal vector.").printStackTrace();
             System.exit(-1);
         }
         double x = mat.get00() * this.x + mat.get01() * this.y + mat.get02() * this.z;
         double y = mat.get10() * this.x + mat.get11() * this.y + mat.get12() * this.z;
         double z = mat.get20() * this.x + mat.get21() * this.y + mat.get22() * this.z;
         this.x = x;
         this.y = y;
         this.z = z;
         return this;
     }
 
     public DVec3 premul(double mat00, double mat01, double mat02, double mat10, double mat11, double mat12, double mat20,
             double mat21, double mat22) {
         if (isHor()) {
             new Exception("Cannot multiply 3x3 matrix with an horizontal vector.").printStackTrace();
             System.exit(-1);
         }
         double x = mat00 * this.x + mat01 * this.y + mat02 * this.z;
         double y = mat10 * this.x + mat11 * this.y + mat12 * this.z;
         double z = mat20 * this.x + mat21 * this.y + mat22 * this.z;
         this.x = x;
         this.y = y;
         this.z = z;
         return this;
     }
 
     public DVec3 swap(DVec3 v) {
         double tempX = this.x;
         double tempY = this.y;
         double tempZ = this.z;
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
 
     public DVec3 to(DVecWritable v) {
         this.extractTo(v);
         return this;
     }
 
     public DVec3 from(DVecReadable v) {
         this.extractFrom(v);
         return this;
     }
 
     public boolean equals(Object o) {
         if (o instanceof DVec3Readable) {
             DVec3Readable vec = (DVec3Readable) o;
             return this.x == vec.getX() && this.y == vec.getY() && this.z == vec.getZ();
         }
         return false;
     }
 
     public DVec3 rotateAngleAxis(double angle, DVec3Readable axis) {
         return this.rotateAngleAxis(angle, axis.getX(), axis.getY(), axis.getZ());
     }
 
     public DVec3 rotateAngleAxis(double angle, double axisX, double axisY, double axisZ) {
         angle = (double) Math.toRadians(angle);
         // normalize axis vector
         double len = (double) Math.sqrt(axisX * axisX + axisY * axisY + axisZ * axisZ);
         double aX = axisX / len;
         double aY = axisY / len;
         double aZ = axisZ / len;
         // Rodrigues' rotation formula
         DVec3 p2 = new DVec3(aX, aY, aZ).cross(this).mul((double) Math.sin(angle));
         DVec3 k = new DVec3(aX, aY, aZ);
         DVec3 p3 = k.mul(k.dot(this)).mul((double) (1 - Math.cos(angle)));
         this.mul((double) Math.cos(angle));
         return this.add(p2).add(p3);
     }
 
     public DVec3 rotateQuaternion(DQuaternionReadable q) {
          // Multiply the quaternion with this vector and store result in temporary variables.
          double tw = -q.getX() * this.x - q.getY() * this.y - q.getZ() * this.z;
          double tx =  q.getW() * this.x + q.getY() * this.z - q.getZ() * this.y;
          double ty =  q.getW() * this.y + q.getZ() * this.x - q.getX() * this.z;
          double tz =  q.getW() * this.z + q.getX() * this.y - q.getY() * this.x;
          // Extract values from the quaternion and conjugate them.
          double conjW = q.getW();
          double conjX = -q.getX();
          double conjY = -q.getY();
          double conjZ = -q.getZ();
          // Multiply temporary result with the conjugate of the quaternion.
          double resX = tw * conjX + tx * conjW + ty * conjZ - tz * conjY;
          double resY = tw * conjY - tx * conjZ + ty * conjW + tz * conjX;
          double resZ = tw * conjZ + tx * conjY - ty * conjX + tz * conjW;
          return this.set(resX, resY, resZ);
     }

    public DVec3 rotateQuaternion(double qw, double qx, double qy, double qz) {
         // Multiply the quaternion with this vector and store result in temporary variables.
         double tw = -qx * this.x - qy * this.y - qz * this.z;
         double tx =  qw * this.x + qy * this.z - qz * this.y;
         double ty =  qw * this.y + qz * this.x - qx * this.z;
         double tz =  qw * this.z + qx * this.y - qy * this.x;
         // Extract values from the quaternion and conjugate them.
         double conjW = qw;
         double conjX = -qx;
         double conjY = -qy;
         double conjZ = -qz;
         // Multiply temporary result with the conjugate of the quaternion.
         double resX = tw * conjX + tx * conjW + ty * conjZ - tz * conjY;
         double resY = tw * conjY - tx * conjZ + ty * conjW + tz * conjX;
         double resZ = tw * conjZ + tx * conjY - ty * conjX + tz * conjW;
         return this.set(resX, resY, resZ);
    }
}
