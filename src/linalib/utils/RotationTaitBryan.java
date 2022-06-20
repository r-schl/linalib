package linalib.utils;

import linalib.Mat3;
import linalib.Mat3Readable;
import linalib.Mat4Readable;
import linalib.Vec3;

public class RotationTaitBryan {

    private Mat3 matrix = new Mat3();
    private Vec3 angle = new Vec3(0);
    private Vec3 lastAngle = new Vec3(0);

    private Axis[] orderOfApplying;

    public RotationTaitBryan(Axis... axes) {
        this.setOrder(axes);
    }

    public void update() {
        if (!this.angle.equals(this.lastAngle)) {
            // recalculate the rotation matrix
            matrix.set(Mat3.IDENTITY);
            for (Axis a : orderOfApplying) {
                if (a == Axis.X)
                    matrix.mul(Mat3.initRot3AroundAxis(Vec3.XAXIS, angle.x)); // around x axis
                if (a == Axis.Y)
                    matrix.mul(Mat3.initRot3AroundAxis(Vec3.YAXIS, angle.y)); // around y axis
                if (a == Axis.Z)
                    matrix.mul(Mat3.initRot3AroundAxis(Vec3.ZAXIS, angle.z)); // around z axis
            }
            this.lastAngle.set(this.angle);
        }
    }

    public Vec3 apply(Vec3 v) {
        this.update();
        if (v.isHor())
            return v.transpose().premul(matrix).transpose();
        else
            return v.premul(matrix);
    }

    public RotationTaitBryan set(float angleX, float angleY, float angleZ) {
        this.angle.set(angleX, angleY, angleZ);
        return this;
    }

    public RotationTaitBryan increase(float dAngleX, float dAngleY, float dAngleZ) {
        this.angle.add(new Vec3(dAngleX, dAngleY, dAngleZ));
        return this;
    }

    public Vec3 getAngles() {
        return angle;
    }

    public RotationTaitBryan reset() {
        this.angle.set(0, 0, 0);
        return this;
    }

    public void setOrder(Axis... axes) {
        this.orderOfApplying = axes;
    }

    public Mat3Readable matrix3() {
        this.update();
        return matrix;
    }

}
