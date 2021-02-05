package vec;

import mat.Mat3x3Readable;
import quat.QuatReadable;

public interface Vec3Writable extends Vec3Readable, VecWritable {

    Vec3Writable setX(float val);

    Vec3Writable setY(float val);

    Vec3Writable setZ(float val);

    Vec3Writable set(Vec3Readable v);

    Vec3Writable set(float vX, float vY, float vZ);

    Vec3Writable set(Vec2Readable v, float z);

    Vec3Writable set(Vec4Readable v);

    Vec3Writable set(QuatReadable q);
    
    Vec3Writable cross(Vec3Readable v);

    Vec3Writable cross(float vX, float vY, float vZ);

    Vec3Writable precross(Vec3Readable v);

    Vec3Writable precross(float vX, float vY, float vZ);

    Vec3Writable add(Vec3Readable v);

    Vec3Writable add(float vX, float vY, float vZ);

    Vec3Writable sub(Vec3Readable v);

    Vec3Writable sub(float vX, float vY, float vZ);

    Vec3Writable presub(Vec3Readable v);

    Vec3Writable presub(float vX, float vY, float vZ);

    Vec3Writable mul(Mat3x3Readable mat);

    Vec3Writable mul(float mat00, float mat01, float mat02,
             float mat10, float mat11, float mat12,
             float mat20, float mat21, float mat22);

    Vec3Writable premul(Mat3x3Readable mat);

    Vec3Writable premul(float mat00, float mat01, float mat02,
                float mat10, float mat11, float mat12,
                float mat20, float mat21, float mat22);

    Vec3Writable swap(Vec3Writable v);

    Vec3Writable rotate(float angle, Vec3Readable axis);

    Vec3Writable rotate(float angle, float axisX, float axisY, float axisZ);

    Vec3Writable rotate(QuatReadable q);
    
}
