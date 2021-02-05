package mat;

import vec.Vec2Readable;

public interface Mat2Writable extends Mat2Readable, MatWritable {
    
    Mat2Writable set00(float val);
    Mat2Writable set01(float val);

    Mat2Writable set10(float val);
    Mat2Writable set11(float val);

    Mat2Writable set(Mat2Writable mat);

    Mat2Writable set(float mat00, float mat01, float mat10, float mat11);

    Mat2Writable addElWise(Mat2Readable mat);

    Mat2Writable addElWise(float mat00, float mat01, float mat10, float mat11);

    Mat2Writable subElWise(Mat2Readable mat);

    Mat2Writable subElWise(float mat00, float mat01, float mat10, float mat11);

    Mat2Writable presubElWise(Mat2Readable mat);

    Mat2Writable presubElWise(float mat00, float mat01, float mat10, float mat11);

    Mat2Writable mulElWise(Mat2Readable mat);

    Mat2Writable mulElWise(float mat00, float mat01, float mat10, float mat11);

    Mat2Writable divElWise(Mat2Readable mat);

    Mat2Writable divElWise(float mat00, float mat01, float mat10, float mat11);

    Mat2Writable predivElWise(Mat2Readable mat);

    Mat2Writable predivElWise(float mat00, float mat01, float mat10, float mat11);

    Mat2Writable mul(Mat2Readable mat);

    Mat2Writable mul(float mat00, float mat01, float mat10, float mat11);

    Mat2Writable premul(Mat2Readable mat);

    Mat2Writable premul(float mat00, float mat01, float mat10, float mat11);

    Mat2Writable rotation2d(float angle);

    Mat2Writable scale2d(Vec2Readable scale);

    Mat2Writable scale2d(float scaleX, float scaleY);



}
