package linalib.utils;

import linalib.flt.Mat3;
import linalib.flt.Mat3Readable;
import linalib.flt.Vec3;

public class FRotTaitBryan implements Mat3Container {

    private Mat3 matrix = new Mat3();
    private Vec3 angle = new Vec3(0);
    private Vec3 lastAngle = new Vec3(0);

    private Axis[] orderOfApplying;

    public FRotTaitBryan(Axis... axes) {
        this.setOrder(axes);
    }

    @Override
    public void update() {
        if (!this.angle.equals(this.lastAngle)) {
            // recalculate the rotation matrix
            matrix.set(Mat3.IDENTITY);
            for (Axis a : orderOfApplying) {
                if (a == Axis.X)
                    matrix.mulRot3AroundXAxis(angle.x); // around x axis
                if (a == Axis.Y)
                    matrix.mulRot3AroundYAxis(angle.y); // around y axis
                if (a == Axis.Z)
                    matrix.mulRot3AroundZAxis(angle.z); // around z axis
            }
            this.lastAngle.from(this.angle);
        }
    }

    public Vec3 apply(Vec3 v) {
        this.update();
        if (v.isHor())
            return v.transpose().premul(matrix).transpose();
        else
            return v.premul(matrix);
    }

    public FRotTaitBryan set(float angleX, float angleY, float angleZ) {
        this.angle.set(angleX, angleY, angleZ);
        return this;
    }

    public FRotTaitBryan increase(float dAngleX, float dAngleY, float dAngleZ) {
        this.angle.add(dAngleX, dAngleY, dAngleZ);
        return this;
    }

    public Vec3 getAngles() {
        return angle;
    }

    public FRotTaitBryan reset() {
        this.angle.set(0, 0, 0);
        return this;
    }

    public void setOrder(Axis... axes) {
        this.orderOfApplying = axes;
    }

    @Override
    public Mat3Readable matrix3() {
        this.update();
        return matrix;
    }

}
