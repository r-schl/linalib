package linalib.utils;

import linalib.f.matrix.FMat4;
import linalib.f.matrix.FMat4Readable;
import linalib.f.quaternion.FQuaternion;
import linalib.f.usage.FMat4Container;
import linalib.f.vector.FVec3;

public class Camera implements FMat4Container {

    private FVec3 position;
    private FQuaternion rotation;
    private FMat4 matrix = new FMat4();
    private FMat4Container projection;

    public Camera(FVec3 pos, FQuaternion quat, FMat4Container proj) {
        this.position = pos;
        this.rotation = quat;
        this.projection = proj;
    }
    
    public void update() {
        this.matrix.set(FMat4.IDENTITY);
        this.matrix.mul(this.projection.matrix4());
        this.matrix.mulView3FromQuaternion(position, rotation);
    }

    @Override
    public FMat4Readable matrix4() {
        this.update();
        return matrix;
    }


    
}
