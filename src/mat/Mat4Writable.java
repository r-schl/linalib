package mat;

import quat.QuatReadable;
import vec.Vec2Readable;
import vec.Vec3Readable;
import vec.Vec4Readable;

public interface Mat4Writable extends Mat4Readable, MatWritable {

    Mat4Writable set00(float val);

    Mat4Writable set01(float val);

    Mat4Writable set02(float val);

    Mat4Writable set03(float val);

    Mat4Writable set10(float val);

    Mat4Writable set11(float val);

    Mat4Writable set12(float val);

    Mat4Writable set13(float val);

    Mat4Writable set20(float val);

    Mat4Writable set21(float val);

    Mat4Writable set22(float val);

    Mat4Writable set23(float val);

    Mat4Writable set30(float val);

    Mat4Writable set31(float val);

    Mat4Writable set32(float val);

    Mat4Writable set33(float val);

    Mat4Writable set(Mat4Readable mat);

    Mat4Writable set(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33);

    Mat4Writable addElWise(Mat4Readable mat);

    Mat4Writable addElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33);

    Mat4Writable subElWise(Mat4Readable mat);

    Mat4Writable subElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33);

    Mat4Writable presubElWise(Mat4Readable mat);

    Mat4Writable presubElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11,
            float mat12, float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31,
            float mat32, float mat33);

    Mat4Writable mulElWise(Mat4Readable mat);

    Mat4Writable mulElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33);

    Mat4Writable divElWise(Mat4Readable mat);

    Mat4Writable divElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33);

    Mat4Writable predivElWise(Mat4Readable mat);

    Mat4Writable predivElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11,
            float mat12, float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31,
            float mat32, float mat33);

    Mat4Writable mul(Mat4Readable mat);

    Mat4Writable mul(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33);

    Mat4Writable premul(Mat4Readable mat);

    Mat4Writable premul(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33);

    Mat4Writable rotation2d(float angle);

    Mat4Writable rot3dAroundAxis(Vec3Readable axis, float angle);

    Mat4Writable rot3dAroundAxis(float axisX, float axisY, float axisZ, float angle);

    Mat4Writable rot3dAroundXAxis(float angle);

    Mat4Writable rot3dAroundYAxis(float angle);

    Mat4Writable rot3dAroundZAxis(float angle);

    Mat4Writable rotation3d(Vec3Readable forward, Vec3Readable up, Vec3Readable right);
    
    Mat4Writable rotation3d(float fX, float fY, float fZ, float uX, float uY, float uZ, float rX, float rY, float rZ);

    Mat4Writable rot3dFromQuaternion(QuatReadable q);

    Mat4Writable rot3dFromQuaternion(float qw, float qx, float qy, float qz);

    Mat4Writable translation2d(Vec2Readable translation);

    Mat4Writable translation2d(float dX, float dY);

    Mat4Writable translation3d(Vec3Readable translation);

    Mat4Writable translation3d(float dX, float dY, float dZ);

    Mat4Writable scale2d(Vec2Readable scale);

    Mat4Writable scale2d(float scaleX, float scaleY);

    Mat4Writable scale3d(Vec3Readable scale);

    Mat4Writable scale3d(float scaleX, float scaleY, float scaleZ);

    Mat4Writable scale4d(Vec4Readable scale);

    Mat4Writable scale4d(float scaleX, float scaleY, float scaleZ, float scaleW);

    Mat4Writable lookAt3d(Vec3Readable pos, Vec3Readable tgt, Vec3Readable up);

    Mat4Writable lookAt3d(float posX, float posY, float posZ, float tgtX, float tgtY, float tgtZ, float upX, float upY, float upZ);

    Mat4Writable view3dFromQuaternion(Vec3Readable p, QuatReadable q);

    Mat4Writable view3dFromQuaternion(float pX, float pY, float pZ, float qw, float qx, float qy, float qz);

    Mat4Writable perspective3d(float l, float r, float b, float t, float n, float f);

    Mat4Writable perspective3dFov(float aspect, float near, float far, float fovY);

    Mat4Writable orthographic3d(float l, float r, float b, float t, float n, float f);

    Mat4Writable oblique3d(float l, float r, float b, float t, float n, float f, float alpha, float beta);

    Mat4Writable cabinet3d(float l, float r, float b, float t, float n, float f, float angle);

    Mat4Writable cavalier3d(float l, float r, float b, float t, float n, float f, float angle);

}
