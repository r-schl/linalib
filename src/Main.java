import linalib.Vec4;
import linalib.Vec4Readable;
import linalib.Mat4;
import linalib.Quaternion;
import linalib.Vec2;
import linalib.Vec3;

import static linalib.Mat4.*;
import static linalib.Vec3.*;
import static linalib.Vec4.*;

import linalib.Mat3;

import static linalib.Vec2.*;

public class Main {

    public static void main(String... args) {

        Vec3 v = new Vec3(1, 0, 0);
        Quaternion q = Quaternion.initRotation(new Vec3(0, 1, 0), 90);
        q.premul(Quaternion.initRotation(new Vec3(0, 1, 0), 90));

        Mat4 mat = Mat4.initRot3FromQuaternion(q);

        System.out.println(mul(mat, new Vec4(v, 1)));
        


        
        
    }

}