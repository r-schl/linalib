package src;

import src.mat.Mat2x2;
import src.vec.Vec3;

public class Main {

    public static void main(String... args) {

        Vec3 vec0 = new Vec3(1, 2, 3);
        Vec3 vec1 = new Vec3(4, 5, 6);

        Vec3 res = vec0.copy().subRvs(vec1); // vec0 = vec1 - vec0

        vec0.print();
        vec1.print();
        res.print();


        Mat2x2 mat = new Mat2x2(
            3,4,
            5,6
        );

        Mat2x2 mat2 = new Mat2x2(
            0,0,
            0,0
        );

        mat.mul(mat2);


        mat.print();

        

        
    }


}