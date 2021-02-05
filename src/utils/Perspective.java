package utils;

import mat.Mat4;
import mat.Mat4Readable;

public class Perspective extends Projection {

    public float l;
    public float r;
    public float b;
    public float t;
    public float n;
    public float f;

    private Mat4 matrix;

    public Perspective(float aspect, float near, float far, float fovY) {
        float tanHalfFov = (float) Math.tan(Math.toRadians(fovY / 2.0));
        float pWidth = (2 * near) / (1 / tanHalfFov);
        float pHeight = (2 * near) / (1 / tanHalfFov * aspect);
        this.r = pWidth / 2;
        this.l = -pWidth / 2;
        this.t = pHeight / 2;
        this.b = -pHeight / 2;
        this.n = near;
        this.f = far;
        this.matrix = new Mat4();
    }

    public Perspective(float l, float r, float b, float t, float n, float f) {
        this.l = l;
        this.r = r;
        this.b = b;
        this.t = t;
        this.n = n;
        this.f = f;
        this.matrix = new Mat4();
    }

    private void calculate() {
        // TODO: Check if recalculation is necessary
        this.matrix.set(Mat4.IDENTITY);
        this.matrix.perspective3d(l, r, b, t, n, f);       
    }

    public Mat4Readable matrix() {
        this.calculate();
        return this.matrix();
    }
    
}
