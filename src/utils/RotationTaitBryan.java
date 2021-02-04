package utils;

import mat.Mat3x3;
import mat.Mat3x3Readable;
import vec.Vec3;

public class RotationTaitBryan  {

    private Mat3x3 mat = new Mat3x3();

    private Vec3 angle = new Vec3(0);
    private Vec3 lastAngle = new Vec3(0);

    private Axis[] orderOfApplying;

    public RotationTaitBryan(Axis... axes) {
        this.setOrder(axes);
    }

    private void recalc() {
        if (!this.angle.equals(this.lastAngle)) {
            // recalculate the rotation matrix
            mat.set(Mat3x3.IDENTITY);
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

    public Vec3 applyOn(Vec3 v) {
        this.recalc();
        if (v.isHor())
            return v.transpose().mulRvs(mat).transpose();
        else
            return v.mulRvs(mat);
    }

    public Mat3x3Readable getMat() {
        this.recalc();
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
