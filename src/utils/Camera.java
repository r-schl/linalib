package utils;

import mat.Mat4;
import mat.Mat4Readable;
import quat.QuatReadable;
import quat.Quaternion;
import vec.Vec3;
import vec.Vec3Readable;

public class Camera {

    private Vec3 position;
    private Quaternion rotation;
    private Mat4 matrix = new Mat4();
    private Projection projection;


    public Camera(Vec3Readable position, QuatReadable q, Projection p) {
        this.position = new Vec3(position);
        this.rotation = new Quaternion(q);
    
    }
    
    private void recalculate() {
        this.matrix.set(Mat4.IDENTITY);
       // this.matrix.perspective3dFov(aspect, near, far, fovY);
        this.matrix.view3dFromQuaternion(position, rotation);
    }

    public Mat4Readable matrix() {
        recalculate();
        return matrix;
    }


    
}
