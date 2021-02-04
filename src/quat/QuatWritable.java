package quat;

import vec.Vec3Readable;

public interface QuatWritable extends QuatReadable {

    QuatWritable set(int i, float r);

    QuatWritable setW(float r);

    QuatWritable setX(float r);

    QuatWritable setY(float r);

    QuatWritable setZ(float r);

    QuatWritable set(QuatReadable q);

    QuatWritable set(float s, float q1, float q2, float q3);

    QuatWritable initRotation(float angle, Vec3Readable axis);

    QuatWritable initRotation(float angle, float axisX, float axisY, float axisZ);

    QuatWritable normalize();

    QuatWritable conjugate();

    QuatWritable mul(QuatReadable q);

    QuatWritable mul(float w, float x, float y, float z);

    QuatWritable mulRvs(QuatReadable q);

    QuatWritable mulRvs(float w, float x, float y, float z);

    QuatWritable mulThisVecConjugate(Vec3Readable v);

    QuatWritable mulThisVecConjugate(float x, float y, float z);

    QuatWritable mulWithRotation(float angle, Vec3Readable axis);

    QuatWritable mulWithRotation(float angle, float axisX, float axisY, float axisZ);

    QuatWritable mulRvsWithRotation(float angle, Vec3Readable axis);

    QuatWritable mulRvsWithRotation(float angle, float axisX, float axisY, float axisZ);

    QuatWritable mul(Vec3Readable v);

    QuatWritable mul(float x, float y, float z);
    
}
