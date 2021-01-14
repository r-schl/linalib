package src;

import src.vec.Vec3;

public class Main {

    public static void main(String... args) {

        Vec3 vec0 = new Vec3(1, 2, 3);
        Vec3 vec1 = new Vec3(4, 5, 6);

        Vec3 res = vec0.copy().subRvs(vec1); // vec0 = vec1 - vec0

        vec0.print();
        vec1.print();
        res.print();

        

        
    }


}