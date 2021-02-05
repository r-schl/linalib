package utils;

import mat.Mat2x2;
import vec.Vec2;

public class Rotation2d {

    private float angle;
    private float lastAngle;
    private Mat2x2 mat = new Mat2x2();

    public Rotation2d(float angle) {
        this.angle = angle;
    }

    public Rotation2d() {
        this(0);
    }

    private void recalculate() {
        if (this.angle == this.lastAngle) return;
        mat.set(Mat2x2.IDENTITY);
        mat.rotation2d(this.angle);
        this.lastAngle = this.angle;
    }

    public Vec2 apply(Vec2 v) {
        this.recalculate();
        if (v.isHor()) return v.transpose().premul(mat).transpose();
        else return v.premul(mat);
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
    
}