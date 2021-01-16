package src;

import src.mat.Mat2x2;
import src.mat.Mat3x3;
import src.mat.Mat4x4;
import src.vec.Vec2;
import src.vec.Vec3;
import src.vec.Vec4;

public class Main {

    public static void main(String... args) {

        Mat4x4 mat = new Mat4x4().rotation3d(0, 0, 90).translation3d(50, 50, 50);

        Vec3 pos = new Vec3(0, 5, 0);

        pos.print();

        new Vec4(pos, 1).mul(mat).copyTo(pos);

        pos.print();

        
    }


}