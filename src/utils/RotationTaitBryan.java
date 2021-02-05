package utils;

import mat.Mat3;
import mat.Mat3Readable;
import vec.Vec3;

public class RotationTaitBryan  {

    private Mat3 mat = new Mat3();

    private Vec3 angle = new Vec3(0);
    private Vec3 lastAngle = new Vec3(0);

    private Axis[] orderOfApplying;

    public RotationTaitBryan(Axis... axes) {
        this.setOrder(axes);
    }

    private void recalculate() {
        if (!this.angle.equals(this.lastAngle)) {
            // recalculate the rotation matrix
            mat.set(Mat3.IDENTITY);
            for (Axis a : orderOfApplying) {
                if (a == Axis.X)
                    mat.rot3dAroundXAxis(angle.x); // around x axis
                if (a == Axis.Y)
                    mat.rot3dAroundYAxis(angle.y); // around y axis
                if (a == Axis.Z)
                    mat.rot3dAroundZAxis(angle.z); // around z axis
            }
            this.lastAngle.from(this.angle);
        }
    }

    public Vec3 apply(Vec3 v) {
        this.recalculate();
        if (v.isHor())
            return v.transpose().premul(mat).transpose();
        else
            return v.premul(mat);
    }

    public Mat3Readable getMat() {
        this.recalculate();
        return mat;
    }

    public RotationTaitBryan  set(float angleX, float angleY, float angleZ) {
        this.angle.set(angleX, angleY, angleZ);
        return this;
    }

    public RotationTaitBryan  increase(float dAngleX, float dAngleY, float dAngleZ) {
        this.angle.add(dAngleX, dAngleY, dAngleZ);
        return this;
    }

    public Vec3 getAngles() {
        return angle;
    }

    public RotationTaitBryan  reset() {
        this.angle.set(0, 0, 0);
        return this;
    }

    public void setOrder(Axis... axes) {
        this.orderOfApplying = axes;
    }

    public void from(Vec3 forward, Vec3 upward) {
        // TODO
    }

}
