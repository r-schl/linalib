package linalib.utils;

import linalib.mat.Mat4;
import linalib.mat.Mat4Readable;
import linalib.use.Mat4Container;

public class Orthographic implements Mat4Container {

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

    private Mat4 matrix;

    public Orthographic(float left, float right, float bottom, float top, float near, float far) {
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.top = top;
        this.near = near;
        this.far = far;
        this.matrix = new Mat4();
    }

    private void update() {
        // if nothing has changed the matrix does not need to be updated
        if (left == _left && right == _right && bottom == _bottom && top == _top && near == _near && far == _far) return;
        // recalculate matrix
        this.matrix.set(Mat4.IDENTITY);
        this.matrix.mulOrthographic3d(left, right, bottom, top, near, far);
    }

    @Override
    public Mat4Readable matrix4() {
        this.update();
        return matrix;
    }
    
}
