package linalib.utils;

import linalib.f.matrix.FMat2;
import linalib.f.matrix.FMat2Readable;
import linalib.f.usage.FMat2Container;
import linalib.f.vector.FVec2;

public class FRotation2 implements FMat2Container {

    private float angle;
    private float lastAngle;
    private FMat2 mat = new FMat2();

    public FRotation2(float angle) {
        this.angle = angle;
    }

    public FRotation2() {
        this(0);
    }

    @Override
    public void update() {
        if (this.angle == this.lastAngle)
            return;
        mat.set(FMat2.IDENTITY);
        mat.mulRotation2(this.angle);
        this.lastAngle = this.angle;
    }

    public FVec2 apply(FVec2 v) {
        this.update();
        if (v.isHor())
            return v.transpose().premul(mat).transpose();
        else
            return v.premul(mat);
    }

    public void rotate(FRotation2 r) {
        this.angle += r.angle;
    }

    public void rotate(float angle) {
        this.angle += angle;
    }

    public void set(float angle) {
        this.angle = angle;
    }

    public void reset() {
        this.angle = 0;
    }

    @Override
    public FMat2Readable matrix2() {
        this.update();
        return mat;
    }
    
}
