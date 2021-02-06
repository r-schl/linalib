package utils;

import mat.Mat2;
import mat.Mat2Readable;
import use.Mat2Container;
import vec.Vec2;

public class Rotation2d implements Mat2Container {

    private float angle;
    private float lastAngle;
    private Mat2 mat = new Mat2();

    public Rotation2d(float angle) {
        this.angle = angle;
    }

    public Rotation2d() {
        this(0);
    }

    private void update() {
        if (this.angle == this.lastAngle)
            return;
        mat.set(Mat2.IDENTITY);
        mat.mulRotation2d(this.angle);
        this.lastAngle = this.angle;
    }

    public Vec2 apply(Vec2 v) {
        this.update();
        if (v.isHor())
            return v.transpose().premul(mat).transpose();
        else
            return v.premul(mat);
    }

    public void rotate(Rotation2d r) {
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
    public Mat2Readable matrix2() {
        this.update();
        return mat;
    }
    
}
