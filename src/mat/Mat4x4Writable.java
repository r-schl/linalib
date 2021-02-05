package mat;

import quat.QuatReadable;
import vec.Vec2Readable;
import vec.Vec3Readable;
import vec.Vec4Readable;

public interface Mat4x4Writable extends Mat4x4Readable, MatWritable {

    Mat4x4Writable set00(float val);

    Mat4x4Writable set01(float val);

    Mat4x4Writable set02(float val);

    Mat4x4Writable set03(float val);

    Mat4x4Writable set10(float val);

    Mat4x4Writable set11(float val);

    Mat4x4Writable set12(float val);

    Mat4x4Writable set13(float val);

    Mat4x4Writable set20(float val);

    Mat4x4Writable set21(float val);

    Mat4x4Writable set22(float val);

    Mat4x4Writable set23(float val);

    Mat4x4Writable set30(float val);

    Mat4x4Writable set31(float val);

    Mat4x4Writable set32(float val);

    Mat4x4Writable set33(float val);

    Mat4x4Writable set(Mat4x4Readable mat);

    Mat4x4Writable set(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33);

    Mat4x4Writable addElWise(Mat4x4Readable mat);

    Mat4x4Writable addElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33);

    Mat4x4Writable subElWise(Mat4x4Readable mat);

    Mat4x4Writable subElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33);

    Mat4x4Writable presubElWise(Mat4x4Readable mat);

    Mat4x4Writable presubElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11,
            float mat12, float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31,
            float mat32, float mat33);

    Mat4x4Writable mulElWise(Mat4x4Readable mat);

    Mat4x4Writable mulElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33);

    Mat4x4Writable divElWise(Mat4x4Readable mat);

    Mat4x4Writable divElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33);

    Mat4x4Writable predivElWise(Mat4x4Readable mat);

    Mat4x4Writable predivElWise(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11,
            float mat12, float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31,
            float mat32, float mat33);

    Mat4x4Writable mul(Mat4x4Readable mat);

    Mat4x4Writable mul(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33);

    Mat4x4Writable premul(Mat4x4Readable mat);

    Mat4x4Writable premul(float mat00, float mat01, float mat02, float mat03, float mat10, float mat11, float mat12,
            float mat13, float mat20, float mat21, float mat22, float mat23, float mat30, float mat31, float mat32,
            float mat33);

    Mat4x4Writable rotation2d(float angle);

    Mat4x4Writable rot3dAroundAxis(Vec3Readable axis, float angle);

    Mat4x4Writable rot3dAroundAxis(float axisX, float axisY, float axisZ, float angle);

    Mat4x4Writable rot3dAroundXAxis(float angle);

    Mat4x4Writable rot3dAroundYAxis(float angle);

    Mat4x4Writable rot3dAroundZAxis(float angle);

    Mat4x4Writable translation2d(Vec2Readable translation);

    Mat4x4Writable translation2d(float dX, float dY);

    Mat4x4Writable translation3d(Vec3Readable translation);

    Mat4x4Writable translation3d(float dX, float dY, float dZ);

    Mat4x4Writable scale2d(Vec2Readable scale);

    Mat4x4Writable scale2d(float scaleX, float scaleY);

    Mat4x4Writable scale3d(Vec3Readable scale);

    Mat4x4Writable scale3d(float scaleX, float scaleY, float scaleZ);

    Mat4x4Writable scale4d(Vec4Readable scale);

    Mat4x4Writable scale4d(float scaleX, float scaleY, float scaleZ, float scaleW);

    Mat4x4Writable lookAt3d(Vec3Readable pos, Vec3Readable tgt, Vec3Readable up);

    Mat4x4Writable lookAt3d(float posX, float posY, float posZ, float tgtX, float tgtY, float tgtZ, float upX, float upY, float upZ);

    Mat4x4Writable view3dFromQuaternion(Vec3Readable p, QuatReadable q);

    Mat4x4Writable view3dFromQuaternion(float pX, float pY, float pZ, float qw, float qx, float qy, float qz);

    Mat4x4Writable perspective3d(float r, float l, float t, float b, float n, float f);

    Mat4x4Writable orthographic3d(float r, float l, float t, float b, float n, float f);

    Mat4x4Writable oblique3d(float r, float l, float t, float b, float n, float f, float alpha, float beta);

    Mat4x4Writable cabinet3d(float r, float l, float t, float b, float n, float f, float angle);

    Mat4x4Writable cavalier3d(float r, float l, float t, float b, float n, float f, float angle);

}
