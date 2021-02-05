package mat;

import quat.QuatReadable;
import vec.Vec2Readable;
import vec.Vec3Readable;

public interface Mat3Writable extends Mat3Readable, MatWritable {
    
    Mat3Writable set00(float val);
    Mat3Writable set01(float val);
    Mat3Writable set02(float val);

    Mat3Writable set10(float val);
    Mat3Writable set11(float val);
    Mat3Writable set12(float val);

    Mat3Writable set20(float val);
    Mat3Writable set21(float val);
    Mat3Writable set22(float val);

    Mat3Writable set(Mat3Readable mat);

    Mat3Writable set(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3Writable addElWise(Mat3Readable mat);

    Mat3Writable addElWise(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3Writable subElWise(Mat3Readable mat);

    Mat3Writable subElWise(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3Writable presubElWise(Mat3Readable mat);

    Mat3Writable presubElWise(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3Writable mulElWise(Mat3Readable mat);

    Mat3Writable mulElWise(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3Writable divElWise(Mat3Readable mat);

    Mat3Writable divElWise(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3Writable predivElWise(Mat3Readable mat);

    Mat3Writable predivElWise(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3Writable mul(Mat3Readable mat);

    Mat3Writable mul(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3Writable premul(Mat3Readable mat);

    Mat3Writable premul(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3Writable rotation2d(float angle);

    Mat3Writable rot3dAroundAxis(Vec3Readable axis, float angle);

    Mat3Writable rot3dAroundAxis(float axisX, float axisY, float axisZ, float angle);

    Mat3Writable rot3dAroundXAxis(float angle);

    Mat3Writable rot3dAroundYAxis(float angle);

    Mat3Writable rot3dAroundZAxis(float angle);

    Mat3Writable rotation3d(Vec3Readable forward, Vec3Readable up, Vec3Readable right);
    
    Mat3Writable rotation3d(float fX, float fY, float fZ, float uX, float uY, float uZ, float rX, float rY, float rZ);

    Mat3Writable rot3dFromQuaternion(QuatReadable q);

    Mat3Writable rot3dFromQuaternion(float qw, float qx, float qy, float qz);

    Mat3Writable translation2d(Vec2Readable translation);

    Mat3Writable translation2d(float dX, float dY);

    Mat3Writable scale2d(Vec2Readable scale);

    Mat3Writable scale2d(float scaleX, float scaleY);

    Mat3Writable scale3d(Vec3Readable scale);    

    Mat3Writable scale3d(float scaleX, float scaleY, float scaleZ);



}
