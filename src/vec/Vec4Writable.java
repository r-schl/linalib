package vec;

import mat.Mat4x4Readable;

public interface Vec4Writable extends Vec4Readable, VecWritable {

    Vec4Writable setX(float val);

    Vec4Writable setY(float val);

    Vec4Writable setZ(float val);

    Vec4Writable setW(float val);

    Vec4Writable set(Vec4Readable v);

    Vec4Writable set(float vX, float vY, float vZ, float vW);

    Vec4Writable set(Vec3Readable v, float w);

    Vec4Writable set(Vec2Readable v, float z, float w);

    Vec4Writable add(Vec4Readable v);

    Vec4Writable add(float vX, float vY, float vZ, float vW);

    Vec4Writable sub(Vec4Readable v);

    Vec4Writable sub(float vX, float vY, float vZ, float vW);

    Vec4Writable subRvs(Vec4Readable v);

    Vec4Writable subRvs(float vX, float vY, float vZ, float vW);

    Vec4Writable mul(Mat4x4Readable mat);

    Vec4Writable mul(float mat00, float mat01, float mat02, float mat03,
             float mat10, float mat11, float mat12, float mat13,
             float mat20, float mat21, float mat22, float mat23,
             float mat30, float mat31, float mat32, float mat33);

    Vec4Writable mulRvs(Mat4x4Readable mat);

    Vec4Writable mulRvs(float mat00, float mat01, float mat02, float mat03,
             float mat10, float mat11, float mat12, float mat13,
             float mat20, float mat21, float mat22, float mat23,
             float mat30, float mat31, float mat32, float mat33);

    Vec4Writable swap(Vec4Writable v);

}
