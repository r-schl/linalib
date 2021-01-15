package src;

import src.mat.Mat2x2;
import src.mat.Mat3x3;
import src.mat.Mat4x4;
import src.vec.Vec2;
import src.vec.Vec3;

public class Main {

    public static void main(String... args) {


       

        Mat3x3 mat = new Mat3x3()
                        .rotation3d(1,2,2);

        Mat4x4 mat2 = new Mat4x4();

        Vec3 lol = new Vec3(1, 2, 1);

        lol.print();

        lol.mul(mat);

        lol.print();

        
    }


}