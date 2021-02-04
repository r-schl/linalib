package vec;

import mat.Mat2x2Readable;

public interface Vec2Writable extends Vec2Readable, VecWritable {
    
    Vec2Writable setX(float val);

    Vec2Writable setY(float val);

    Vec2Writable set(Vec2Readable v);

    Vec2Writable set(float vX, float vY);

    Vec2Writable set(Vec3Readable v);

    Vec2Writable set(Vec4Readable v);

    Vec2Writable perpendicular();

    Vec2Writable add(Vec2Readable v);

    Vec2Writable add(float vX, float vY);

    Vec2Writable sub(Vec2Readable v);

    Vec2Writable sub(float vX, float vY);

    Vec2Writable subRvs(Vec2Readable v);

    Vec2Writable subRvs(float vX, float vY);

    Vec2Writable mul(Mat2x2Readable mat);

    Vec2Writable mul(float mat00, float mat01,
                float mat10, float mat11);

    Vec2Writable mulRvs(Mat2x2Readable mat);

    Vec2Writable mulRvs(float mat00, float mat01,
                float mat10, float mat11);

    Vec2Writable swap(Vec2Writable v);


}
