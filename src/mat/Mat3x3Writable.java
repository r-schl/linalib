package mat;

import vec.Vec2Readable;
import vec.Vec3Readable;

public interface Mat3x3Writable extends Mat3x3Readable, MatWritable {
    
    Mat3x3Writable set00(float val);
    Mat3x3Writable set01(float val);
    Mat3x3Writable set02(float val);

    Mat3x3Writable set10(float val);
    Mat3x3Writable set11(float val);
    Mat3x3Writable set12(float val);

    Mat3x3Writable set20(float val);
    Mat3x3Writable set21(float val);
    Mat3x3Writable set22(float val);

    Mat3x3Writable set(Mat3x3Readable mat);

    Mat3x3Writable set(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3x3Writable addElWise(Mat3x3Readable mat);

    Mat3x3Writable addElWise(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3x3Writable subElWise(Mat3x3Readable mat);

    Mat3x3Writable subElWise(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3x3Writable presubElWise(Mat3x3Readable mat);

    Mat3x3Writable presubElWise(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3x3Writable mulElWise(Mat3x3Readable mat);

    Mat3x3Writable mulElWise(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3x3Writable divElWise(Mat3x3Readable mat);

    Mat3x3Writable divElWise(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3x3Writable predivElWise(Mat3x3Readable mat);

    Mat3x3Writable predivElWise(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3x3Writable mul(Mat3x3Readable mat);

    Mat3x3Writable mul(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3x3Writable premul(Mat3x3Readable mat);

    Mat3x3Writable premul(float mat00, float mat01, float mat02,
    float mat10, float mat11, float mat12,
    float mat20, float mat21, float mat22);

    Mat3x3Writable rotation2d(float angle);

    Mat3x3Writable rot3dAroundAxis(Vec3Readable axis, float angle);

    Mat3x3Writable rot3dAroundAxis(float axisX, float axisY, float axisZ, float angle);

    Mat3x3Writable rot3dAroundXAxis(float angle);

    Mat3x3Writable rot3dAroundYAxis(float angle);

    Mat3x3Writable rot3dAroundZAxis(float angle);

    Mat3x3Writable translation2d(Vec2Readable translation);

    Mat3x3Writable translation2d(float dX, float dY);

    Mat3x3Writable scale2d(Vec2Readable scale);

    Mat3x3Writable scale2d(float scaleX, float scaleY);

    Mat3x3Writable scale3d(Vec3Readable scale);    

    Mat3x3Writable scale3d(float scaleX, float scaleY, float scaleZ);

    


}
