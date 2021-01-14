package src.utils;

import src.mat.Mat2x2;
import src.mat.Mat3x3;
import src.vec.Vec2;
import src.vec.Vec3;

public class MatUtils {

    public static void mul(Vec3 a, Mat3x3 b, Vec3 res) {
        if (a.isVer()) {
            new Exception("Cannot multiply a vertical vector with a 3x3 matrix.").printStackTrace();
            System.exit(-1);
        }
        float x = a.x * b.m00 + a.y * b.m10 + a.z * b.m20;
        float y = a.x * b.m01 + a.y * b.m11 + a.z * b.m21;
        float z = a.x * b.m02 + a.y * b.m12 + a.z * b.m22;
        res.x = x;
        res.y = y;
        res.z = z;
    }

    public static void mul(Mat3x3 a, Vec3 b, Vec3 res) {
        if (a.isHor()) {
            new Exception("Cannot multiply 3x3 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        float x = a.m00 * b.x + a.m01 * b.y + a.m02 * b.z;
        float y = a.m10 * b.x + a.m11 * b.y + a.m12 * b.z;
        float z = a.m20 * b.x + a.m21 * b.y + a.m22 * b.z;
        res.x = x;
        res.y = y;
        res.z = z;
    }

    public static void mul(Vec2 a, Mat2x2 b, Vec2 res) {
        if (a.isVer()) {
            new Exception("Cannot multiply a vertical vector with a 2x2 matrix.").printStackTrace();
            System.exit(-1);
        }
        float x = a.x * b.m00 + a.y * b.m10;
        float y = a.x * b.m01 + a.y * b.m11;
        res.x = x;
        res.y = y;
    }

    public static void mul(Mat2x2 a, Vec2 b, Vec2 res) {
        if (a.isHor()) {
            new Exception("Cannot multiply 2x2 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        float x = a.m00 * b.x + a.m01 * b.y;
        float y = a.m10 * b.x + a.m11 * b.y;
        res.x = x;
        res.y = y;
    }
}
