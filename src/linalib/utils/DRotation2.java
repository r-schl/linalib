package linalib.utils;

import linalib.d.matrix.DMat2;
import linalib.d.matrix.DMat2Readable;
import linalib.d.usage.DMat2Container;
import linalib.d.vector.DVec2;

public class DRotation2 implements DMat2Container {

    private double angle;
    private double lastAngle;
    private DMat2 mat = new DMat2();

    public DRotation2(double angle) {
        this.angle = angle;
    }

    public DRotation2() {
        this(0);
    }

    @Override
    public void update() {
        if (this.angle == this.lastAngle)
            return;
        mat.set(DMat2.IDENTITY);
        mat.mulRotation2(this.angle);
        this.lastAngle = this.angle;
    }

    public DVec2 apply(DVec2 v) {
        this.update();
        if (v.isHor())
            return v.transpose().premul(mat).transpose();
        else
            return v.premul(mat);
    }

    public void rotate(DRotation2 r) {
        this.angle += r.angle;
    }

    public void rotate(double angle) {
        this.angle += angle;
    }

    public void set(double angle) {
        this.angle = angle;
    }

    public void reset() {
        this.angle = 0;
    }

    @Override
    public DMat2Readable matrix2() {
        this.update();
        return mat;
    }
    
}
