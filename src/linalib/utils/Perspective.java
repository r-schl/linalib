package linalib.utils;

import linalib.f.matrix.FMat4;
import linalib.f.matrix.FMat4Readable;
import linalib.f.usage.FMat4Container;

public class Perspective implements FMat4Container {

    public float left;
    public float right;
    public float bottom;
    public float top;
    public float near;
    public float far;

    private float _left;
    private float _right;
    private float _bottom;
    private float _top;
    private float _near;
    private float _far;

    private FMat4 matrix;

    public Perspective(float aspect, float near, float far, float fovY) {
        float tanHalfFov = (float) Math.tan(Math.toRadians(fovY / 2.0));
        float pWidth = (2 * near) / (1 / tanHalfFov);
        float pHeight = (2 * near) / (1 / tanHalfFov * aspect);
        this.right = pWidth / 2;
        this.left = -pWidth / 2;
        this.top = pHeight / 2;
        this.bottom = -pHeight / 2;
        this.near = near;
        this.far = far;
        this.matrix = new FMat4();
    }

    public Perspective(float left, float right, float bottom, float top, float near, float far) {
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.top = top;
        this.near = near;
        this.far = far;
        this.matrix = new FMat4();
    }

    public void update() {
        // if nothing has changed the matrix does not need to be updated
        if (left == _left && right == _right && bottom == _bottom && top == _top && near == _near && far == _far) return;
        // recalculate matrix
        this.matrix.set(FMat4.IDENTITY).mulPerspective3(left, right, bottom, top, near, far);
    }

    @Override
    public FMat4Readable matrix4() {
        this.update();
        return this.matrix;
    }
    
}
