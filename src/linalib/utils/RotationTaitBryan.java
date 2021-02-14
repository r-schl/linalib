package linalib.utils;

import linalib.f.matrix.FMat3;
import linalib.f.matrix.FMat3Readable;
import linalib.f.usage.FMat3Container;
import linalib.f.vector.FVec3;

public class RotationTaitBryan implements FMat3Container {

    private FMat3 matrix = new FMat3();
    private FVec3 angle = new FVec3(0);
    private FVec3 lastAngle = new FVec3(0);

    private Axis[] orderOfApplying;

    public RotationTaitBryan(Axis... axes) {
        this.setOrder(axes);
    }

    @Override
    public void update() {
        if (!this.angle.equals(this.lastAngle)) {
            // recalculate the rotation matrix
            matrix.set(FMat3.IDENTITY);
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

    public FVec3 apply(FVec3 v) {
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
        this.angle.add(dAngleX, dAngleY, dAngleZ);
        return this;
    }

    public FVec3 getAngles() {
        return angle;
    }

    public RotationTaitBryan reset() {
        this.angle.set(0, 0, 0);
        return this;
    }

    public void setOrder(Axis... axes) {
        this.orderOfApplying = axes;
    }

    @Override
    public FMat3Readable matrix3() {
        this.update();
        return matrix;
    }

}
