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

        Mat4 mat = new Mat4(
                5, 3, 2, 10,
                4, 5, 2, 8,
                64, 7, 2, 7,
                4, 9, 2, 5);

        System.out.println(Mat4.getDeterminant(mat));

        Vec3 lol = new Vec3(0, 0, 1);
        System.out.println(lol.getLength());


    }

}