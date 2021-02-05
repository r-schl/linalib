package mat;

import vec.Vec2Readable;

public interface Mat2x2Writable extends Mat2x2Readable, MatWritable {
    
    Mat2x2Writable set00(float val);
    Mat2x2Writable set01(float val);

    Mat2x2Writable set10(float val);
    Mat2x2Writable set11(float val);

    Mat2x2Writable set(Mat2x2Writable mat);

    Mat2x2Writable set(float mat00, float mat01, float mat10, float mat11);

    Mat2x2Writable addElWise(Mat2x2Readable mat);

    Mat2x2Writable addElWise(float mat00, float mat01, float mat10, float mat11);

    Mat2x2Writable subElWise(Mat2x2Readable mat);

    Mat2x2Writable subElWise(float mat00, float mat01, float mat10, float mat11);

    Mat2x2Writable presubElWise(Mat2x2Readable mat);

    Mat2x2Writable presubElWise(float mat00, float mat01, float mat10, float mat11);

    Mat2x2Writable mulElWise(Mat2x2Readable mat);

    Mat2x2Writable mulElWise(float mat00, float mat01, float mat10, float mat11);

    Mat2x2Writable divElWise(Mat2x2Readable mat);

    Mat2x2Writable divElWise(float mat00, float mat01, float mat10, float mat11);

    Mat2x2Writable predivElWise(Mat2x2Readable mat);

    Mat2x2Writable predivElWise(float mat00, float mat01, float mat10, float mat11);

    Mat2x2Writable mul(Mat2x2Readable mat);

    Mat2x2Writable mul(float mat00, float mat01, float mat10, float mat11);

    Mat2x2Writable premul(Mat2x2Readable mat);

    Mat2x2Writable premul(float mat00, float mat01, float mat10, float mat11);

    Mat2x2Writable rotation2d(float angle);

    Mat2x2Writable scale2d(Vec2Readable scale);

    Mat2x2Writable scale2d(float scaleX, float scaleY);



}
