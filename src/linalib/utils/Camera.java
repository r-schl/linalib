package linalib.utils;

import linalib.mat.Mat4;
import linalib.mat.Mat4Readable;
import linalib.quat.Quaternion;
import linalib.use.Mat4Container;
import linalib.vec.Vec3;

public class Camera implements Mat4Container {

    private Vec3 position;
    private Quaternion rotation;
    private Mat4 matrix = new Mat4();
    private Mat4Container projection;

    public Camera(Vec3 pos, Quaternion quat, Mat4Container proj) {
        this.position = pos;
        this.rotation = quat;
        this.projection = proj;
    }
    
    private void update() {
        this.matrix.set(Mat4.IDENTITY);
        this.matrix.mul(this.projection.matrix4());
        this.matrix.mulView3dFromQuaternion(position, rotation);
    }

    @Override
    public Mat4Readable matrix4() {
        this.update();
        return matrix;
    }


    
}