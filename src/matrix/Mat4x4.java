package matrix;

import vector.Vec2;
import vector.Vec3;

import java.nio.FloatBuffer;


public class Mat4x4 extends Matrix {

    public static final Mat4x4 IDENTITY = new Mat4x4(
        1, 0, 0, 0,
        0, 1, 0, 0,
        0, 0, 1, 0,
        0, 0, 0, 1
    );

    public static final Mat4x4 FLIP = new Mat4x4(
        0, 0, 0, 1,
        0, 0, 1, 0,
        0, 1, 0, 0,
        1, 0, 0, 0
    );

    public float m00, m01, m02, m03;
    public float m10, m11, m12, m13;
    public float m20, m21, m22, m23;
    public float m30, m31, m32, m33;

    private final int rows = 4;
    private final int columns = 4;

 
    public Mat4x4() {
        this.set(IDENTITY);
    }

    public Mat4x4(float m00, float m01, float m02, float m03,
                  float m10, float m11, float m12, float m13,
                  float m20, float m21, float m22, float m23,
                  float m30, float m31, float m32, float m33) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m30 = m30;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
    }

    public Mat4x4(Mat4x4 other) {
        this.m00 = other.m00;
        this.m01 = other.m01;
        this.m02 = other.m02;
        this.m03 = other.m03;
        this.m10 = other.m10;
        this.m11 = other.m11;
        this.m12 = other.m12;
        this.m13 = other.m13;
        this.m20 = other.m20;
        this.m21 = other.m21;
        this.m22 = other.m22;
        this.m23 = other.m23;
        this.m30 = other.m30;
        this.m31 = other.m31;
        this.m32 = other.m32;
        this.m33 = other.m33;
    }


    public Mat4x4 set(float m00, float m01, float m02, float m03,
                    float m10, float m11, float m12, float m13,
                    float m20, float m21, float m22, float m23,
                    float m30, float m31, float m32, float m33) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m30 = m30;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        return this;
    }

    public Mat4x4 set(Mat4x4 mat) {
        this.m00 = mat.m00;
        this.m01 = mat.m01;
        this.m02 = mat.m02;
        this.m03 = mat.m03;
        this.m10 = mat.m10;
        this.m11 = mat.m11;
        this.m12 = mat.m12;
        this.m13 = mat.m13;
        this.m20 = mat.m20;
        this.m21 = mat.m21;
        this.m22 = mat.m22;
        this.m23 = mat.m23;
        this.m30 = mat.m30;
        this.m31 = mat.m31;
        this.m32 = mat.m32;
        this.m33 = mat.m33;
        return this;
    }

    @Override
    public float get(int row, int col) {
        if (row >= this.rows || col >= this.columns) {
            throw new IllegalArgumentException("Row and/or column out of range. " + row + " " + col);
        }
        if (row == 0) {
            if (col == 0) {
                return m00;
            } else if (col == 1) {
                return m01;
            } else if (col == 2) {
                return m02;
            } else if (col == 3) {
                return m03;
            }
        } else if (row == 1) {
            if (col == 0) {
                return m10;
            } else if (col == 1) {
                return m11;
            } else if (col == 2) {
                return m12;
            } else if (col == 3) {
                return m13;
            }
        } else if (row == 2) {
            if (col == 0) {
                return m20;
            } else if (col == 1) {
                return m21;
            } else if (col == 2) {
                return m22;
            } else if (col == 3) {
                return m23;
            }
        } else if (row == 3) {
            if (col == 0) {
                return m30;
            } else if (col == 1) {
                return m31;
            } else if (col == 2) {
                return m32;
            } else if (col == 3) {
                return m33;
            }
        }
        throw new IllegalArgumentException("Row and/or column out of range. " + row + " " + col);
    }

    @Override
    public int getInt(int row, int col) {
        if (row >= this.rows || col >= this.columns) {
            throw new IllegalArgumentException("Row and/or column out of range. " + row + " " + col);
        }
        if (row == 0) {
            if (col == 0) {
                return (int) m00;
            } else if (col == 1) {
                return (int) m01;
            } else if (col == 2) {
                return (int) m02;
            } else if (col == 3) {
                return (int) m03;
            }
        } else if (row == 1) {
            if (col == 0) {
                return (int) m10;
            } else if (col == 1) {
                return (int) m11;
            } else if (col == 2) {
                return (int) m12;
            } else if (col == 3) {
                return (int) m13;
            }
        } else if (row == 2) {
            if (col == 0) {
                return (int) m20;
            } else if (col == 1) {
                return (int) m21;
            } else if (col == 2) {
                return (int) m22;
            } else if (col == 3) {
                return (int) m23;
            }
        } else if (row == 3) {
            if (col == 0) {
                return (int) m30;
            } else if (col == 1) {
                return (int) m31;
            } else if (col == 2) {
                return (int) m32;
            } else if (col == 3) {
                return (int) m33;
            }
        }
        throw new IllegalArgumentException("Row and/or column out of range. " + row + " " + col);
    }

    @Override
    public void set(int row, int col, float val) {
        if (row == 0) {
            if (col == 0) {
                m00 = val;
                return;
            } else if (col == 1) {
                m01 = val;
                return;
            } else if (col == 2) {
                m02 = val;
                return;
            } else if (col == 3) {
                m03 = val;
                return;
            }
        } else if (row == 1) {
            if (col == 0) {
                m10 = val;
                return;
            } else if (col == 1) {
                m11 = val;
                return;
            } else if (col == 2) {
                m12 = val;
                return;
            } else if (col == 3) {
                m13 = val;
                return;
            }
        } else if (row == 2) {
            if (col == 0) {
                m20 = val;
                return;
            } else if (col == 1) {
                m21 = val;
                return;
            } else if (col == 2) {
                m22 = val;
                return;
            } else if (col == 3) {
                m23 = val;
                return;
            }
        } else if (row == 3) {
            if (col == 0) {
                m30 = val;
                return;
            } else if (col == 1) {
                m31 = val;
                return;
            } else if (col == 2) {
                m32 = val;
                return;
            } else if (col == 3) {
                m33 = val;
                return;
            }
        }
        throw new IllegalArgumentException("Row and/or column out of range. " + row + " " + col);
    }

    @Override
    public int rowCount() {
        return rows;
    }

    @Override
    public int colCount() {
        return columns;
    }

    @Override
    public Mat4x4 copy() {
        return new Mat4x4(this);
    }

    @Override
    public Mat4x4 flipHor() {
        return this.mul(Mat4x4.FLIP);
    }

    @Override
    public Mat4x4 flipVer() {
        return this.mulRvs(Mat4x4.FLIP);
    }

    @Override
    public Mat4x4 transpose() {
        float tm01 = m01;
        m01 = m10;
        float tm02 = m02;
        m02 = m20;
        float tm03 = m03;
        m03 = m30;
        m10 = tm01;
        float tm12 = m12;
        m12 = m21;
        float tm13 = m13;
        m13 = m31;
        m20 = tm02;
        m21 = tm12;
        float tm23 = m23;
        m23 = m32;
        m30 = tm03;
        m31 = tm13;
        m32 = tm23;
        return this;
    }

    public Mat4x4 mul(Mat4x4 mat) {
        // row 1
        float m00 = this.m00 * mat.m00 + this.m01 * mat.m10 + this.m02 * mat.m20 + this.m03 * mat.m30;
        float m01 = this.m00 * mat.m01 + this.m01 * mat.m11 + this.m02 * mat.m21 + this.m03 * mat.m31;
        float m02 = this.m00 * mat.m02 + this.m01 * mat.m12 + this.m02 * mat.m22 + this.m03 * mat.m32;
        float m03 = this.m00 * mat.m03 + this.m01 * mat.m13 + this.m02 * mat.m23 + this.m03 * mat.m33;
        // row 2
        float m10 = this.m10 * mat.m00 + this.m11 * mat.m10 + this.m12 * mat.m20 + this.m13 * mat.m30;
        float m11 = this.m10 * mat.m01 + this.m11 * mat.m11 + this.m12 * mat.m21 + this.m13 * mat.m31;
        float m12 = this.m10 * mat.m02 + this.m11 * mat.m12 + this.m12 * mat.m22 + this.m13 * mat.m32;
        float m13 = this.m10 * mat.m03 + this.m11 * mat.m13 + this.m12 * mat.m23 + this.m13 * mat.m33;
        // row 3
        float m20 = this.m20 * mat.m00 + this.m21 * mat.m10 + this.m22 * mat.m20 + this.m23 * mat.m30;
        float m21 = this.m20 * mat.m01 + this.m21 * mat.m11 + this.m22 * mat.m21 + this.m23 * mat.m31;
        float m22 = this.m20 * mat.m02 + this.m21 * mat.m12 + this.m22 * mat.m22 + this.m23 * mat.m32;
        float m23 = this.m20 * mat.m03 + this.m21 * mat.m13 + this.m22 * mat.m23 + this.m23 * mat.m33;
        // row 4
        float m30 = this.m30 * mat.m00 + this.m31 * mat.m10 + this.m32 * mat.m20 + this.m33 * mat.m30;
        float m31 = this.m30 * mat.m01 + this.m31 * mat.m11 + this.m32 * mat.m21 + this.m33 * mat.m31;
        float m32 = this.m30 * mat.m02 + this.m31 * mat.m12 + this.m32 * mat.m22 + this.m33 * mat.m32;
        float m33 = this.m30 * mat.m03 + this.m31 * mat.m13 + this.m32 * mat.m23 + this.m33 * mat.m33;
        // set values
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m30 = m30;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        return this;
    }

    public Mat4x4 mul(float mat00, float mat01, float mat02, float mat03,
                      float mat10, float mat11, float mat12, float mat13,
                      float mat20, float mat21, float mat22, float mat23,
                      float mat30, float mat31, float mat32, float mat33) {
        // row 1
        float m00 = this.m00 * mat00 + this.m01 * mat10 + this.m02 * mat20 + this.m03 * mat30;
        float m01 = this.m00 * mat01 + this.m01 * mat11 + this.m02 * mat21 + this.m03 * mat31;
        float m02 = this.m00 * mat02 + this.m01 * mat12 + this.m02 * mat22 + this.m03 * mat32;
        float m03 = this.m00 * mat03 + this.m01 * mat13 + this.m02 * mat23 + this.m03 * mat33;
        // row 2
        float m10 = this.m10 * mat00 + this.m11 * mat10 + this.m12 * mat20 + this.m13 * mat30;
        float m11 = this.m10 * mat01 + this.m11 * mat11 + this.m12 * mat21 + this.m13 * mat31;
        float m12 = this.m10 * mat02 + this.m11 * mat12 + this.m12 * mat22 + this.m13 * mat32;
        float m13 = this.m10 * mat03 + this.m11 * mat13 + this.m12 * mat23 + this.m13 * mat33;
        // row 3
        float m20 = this.m20 * mat00 + this.m21 * mat10 + this.m22 * mat20 + this.m23 * mat30;
        float m21 = this.m20 * mat01 + this.m21 * mat11 + this.m22 * mat21 + this.m23 * mat31;
        float m22 = this.m20 * mat02 + this.m21 * mat12 + this.m22 * mat22 + this.m23 * mat32;
        float m23 = this.m20 * mat03 + this.m21 * mat13 + this.m22 * mat23 + this.m23 * mat33;
        // row 4
        float m30 = this.m30 * mat00 + this.m31 * mat10 + this.m32 * mat20 + this.m33 * mat30;
        float m31 = this.m30 * mat01 + this.m31 * mat11 + this.m32 * mat21 + this.m33 * mat31;
        float m32 = this.m30 * mat02 + this.m31 * mat12 + this.m32 * mat22 + this.m33 * mat32;
        float m33 = this.m30 * mat03 + this.m31 * mat13 + this.m32 * mat23 + this.m33 * mat33;
        // set values
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m30 = m30;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        return this;
    }

    public Mat4x4 mulRvs(Mat4x4 mat) {
        // row 1
        float m00 = mat.m00 * this.m00 + mat.m01 * this.m10 + mat.m02 * this.m20 + mat.m03 * this.m30;
        float m01 = mat.m00 * this.m01 + mat.m01 * this.m11 + mat.m02 * this.m21 + mat.m03 * this.m31;
        float m02 = mat.m00 * this.m02 + mat.m01 * this.m12 + mat.m02 * this.m22 + mat.m03 * this.m32;
        float m03 = mat.m00 * this.m03 + mat.m01 * this.m13 + mat.m02 * this.m23 + mat.m03 * this.m33;
        // row 2
        float m10 = mat.m10 * this.m00 + mat.m11 * this.m10 + mat.m12 * this.m20 + mat.m13 * this.m30;
        float m11 = mat.m10 * this.m01 + mat.m11 * this.m11 + mat.m12 * this.m21 + mat.m13 * this.m31;
        float m12 = mat.m10 * this.m02 + mat.m11 * this.m12 + mat.m12 * this.m22 + mat.m13 * this.m32;
        float m13 = mat.m10 * this.m03 + mat.m11 * this.m13 + mat.m12 * this.m23 + mat.m13 * this.m33;
        // row 3
        float m20 = mat.m20 * this.m00 + mat.m21 * this.m10 + mat.m22 * this.m20 + mat.m23 * this.m30;
        float m21 = mat.m20 * this.m01 + mat.m21 * this.m11 + mat.m22 * this.m21 + mat.m23 * this.m31;
        float m22 = mat.m20 * this.m02 + mat.m21 * this.m12 + mat.m22 * this.m22 + mat.m23 * this.m32;
        float m23 = mat.m20 * this.m03 + mat.m21 * this.m13 + mat.m22 * this.m23 + mat.m23 * this.m33;
        // row 4
        float m30 = mat.m30 * this.m00 + mat.m31 * this.m10 + mat.m32 * this.m20 + mat.m33 * this.m30;
        float m31 = mat.m30 * this.m01 + mat.m31 * this.m11 + mat.m32 * this.m21 + mat.m33 * this.m31;
        float m32 = mat.m30 * this.m02 + mat.m31 * this.m12 + mat.m32 * this.m22 + mat.m33 * this.m32;
        float m33 = mat.m30 * this.m03 + mat.m31 * this.m13 + mat.m32 * this.m23 + mat.m33 * this.m33;
        // set values
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m30 = m30;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        return this;
    }

    public Mat4x4 mulRvs(float mat00, float mat01, float mat02, float mat03,
                         float mat10, float mat11, float mat12, float mat13,
                         float mat20, float mat21, float mat22, float mat23,
                         float mat30, float mat31, float mat32, float mat33) {
        // row 1
        float m00 = mat00 * this.m00 + mat01 * this.m10 + mat02 * this.m20 + mat03 * this.m30;
        float m01 = mat00 * this.m01 + mat01 * this.m11 + mat02 * this.m21 + mat03 * this.m31;
        float m02 = mat00 * this.m02 + mat01 * this.m12 + mat02 * this.m22 + mat03 * this.m32;
        float m03 = mat00 * this.m03 + mat01 * this.m13 + mat02 * this.m23 + mat03 * this.m33;
        // row 2
        float m10 = mat10 * this.m00 + mat11 * this.m10 + mat12 * this.m20 + mat13 * this.m30;
        float m11 = mat10 * this.m01 + mat11 * this.m11 + mat12 * this.m21 + mat13 * this.m31;
        float m12 = mat10 * this.m02 + mat11 * this.m12 + mat12 * this.m22 + mat13 * this.m32;
        float m13 = mat10 * this.m03 + mat11 * this.m13 + mat12 * this.m23 + mat13 * this.m33;
        // row 3
        float m20 = mat20 * this.m00 + mat21 * this.m10 + mat22 * this.m20 + mat23 * this.m30;
        float m21 = mat20 * this.m01 + mat21 * this.m11 + mat22 * this.m21 + mat23 * this.m31;
        float m22 = mat20 * this.m02 + mat21 * this.m12 + mat22 * this.m22 + mat23 * this.m32;
        float m23 = mat20 * this.m03 + mat21 * this.m13 + mat22 * this.m23 + mat23 * this.m33;
        // row 4
        float m30 = mat30 * this.m00 + mat31 * this.m10 + mat32 * this.m20 + mat33 * this.m30;
        float m31 = mat30 * this.m01 + mat31 * this.m11 + mat32 * this.m21 + mat33 * this.m31;
        float m32 = mat30 * this.m02 + mat31 * this.m12 + mat32 * this.m22 + mat33 * this.m32;
        float m33 = mat30 * this.m03 + mat31 * this.m13 + mat32 * this.m23 + mat33 * this.m33;
        // set values
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m03 = m03;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m30 = m30;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        return this;
    }

    public Mat4x4 rotation2d(float angle) {
        float cosA = (float) Math.cos(Math.toRadians(angle));
        float sinA = (float) Math.sin(Math.toRadians(angle));
        return this.mul(
            cosA, sinA, 0, 0,
            sinA, cosA, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1
        );
    }

    public Mat4x4 rotation3dAxis(Vec3 axis, float angle) {
        return rotation3dAxis(axis.x, axis.y, axis.z, angle);
    }

    public Mat4x4 rotation3dAxis(float axisX, float axisY, float axisZ, float angle) {
        float a = (float) Math.toRadians(angle);
        float sinA = (float) Math.sin(a);
        float cosA = (float) Math.cos(a);
        return this.mul(
            axisX * axisX * (1 - cosA) + cosA, axisX * axisY * (1 - cosA) - axisZ * sinA, axisX * axisZ * (1 - cosA) + axisY * sinA, 0,
            axisY * axisX * (1 - cosA) + axisZ * sinA, axisY * axisY * (1 - cosA) + cosA, axisY * axisZ * (1 - cosA) - axisX * sinA, 0,
            axisZ * axisX * (1 - cosA) - axisY * sinA, axisZ * axisY * (1 - cosA) + axisX * sinA, axisZ * axisZ * (1 - cosA) + cosA, 0,
            0, 0, 0, 1
        );
    }

    public Mat4x4 rotation3d(Vec3 angle) {
        return rotation3d(angle.x, angle.y, angle.z);
    }

    public Mat4x4 rotation3d(float rotX, float rotY, float rotZ) {
        float cosX = (float) Math.cos(Math.toRadians(rotX));
        float sinX = (float) Math.sin(Math.toRadians(rotX));
        float cosY = (float) Math.cos(Math.toRadians(rotY));
        float sinY = (float) Math.sin(Math.toRadians(rotY));
        float cosZ = (float) Math.cos(Math.toRadians(rotZ));
        float sinZ = (float) Math.sin(Math.toRadians(rotZ));
        // rotation around x axis
        this.mul(
            1, 0, 0, 0,
            0, cosX, sinX, 0,
            0, -sinX, cosX, 0,
            0, 0, 0, 1
        );
        // rotation around y axis
        this.mul(
            cosY, 0, sinY, 0,
            0, 1, 0, 0,
            -sinY, 0, cosY, 0,
            0, 0, 0, 1
        );
        // rotation around z axis
        this.mul(
            cosZ, -sinZ, 0, 0,
            sinZ, cosZ, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1
        );
        return this;
    }

    public Mat4x4 translation3d(Vec3 translation) {
        return translation3d(translation.x, translation.y, translation.z);
    }

    public Mat4x4 translation3d(float dX, float dY, float dZ) {
        return this.mul(
            1, 0, 0, 0,
            0, 1, 0, 0,
            0, 0, 1, 0,
            dX, dY, dZ, 1
        );
    }
    
    public Mat4x4 scale2d(Vec2 scale) {
        return scale2d(scale.x, scale.y);
    }

    public Mat4x4 scale2d(float scaleX, float scaleY) {
        return this.mul(
            scaleX, 0, 0, 0,
            0, scaleY, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1
        );
    }

    public Mat4x4 scale3d(Vec3 scale) {
        return scale3d(scale.x, scale.y, scale.z);
    }

    public Mat4x4 scale3d(float scaleX, float scaleY, float scaleZ) {
        return this.mul(
            scaleX, 0, 0, 0,
            0, scaleY, 0, 0,
            0, 0, scaleZ, 0,
            0, 0, 0, 1
        );
    }

    public Mat4x4 projection3d(float aspectRatio, float zNear, float zFar, float fov) {
        float tanHalfFOV = (float) Math.tan(Math.toRadians(fov / 2.0));
        float yScale = (float) (1.0 / tanHalfFOV * aspectRatio);
        float xScale = yScale / aspectRatio;
        float frustumLength = zFar - zNear;
        return this.mul(
            xScale, 0, 0, 0,
            0, yScale, 0, 0,
            0, 0, -((zFar + zNear) / frustumLength), -1,
            0, 0, -((2 * zNear * zFar) / frustumLength), 0
        );
    }

    @Override
    public Mat4x4 toInt() {
        this.m00 = (int) m00;
        this.m01 = (int) m01;
        this.m02 = (int) m02;
        this.m03 = (int) m03;
        this.m10 = (int) m10;
        this.m11 = (int) m11;
        this.m12 = (int) m12;
        this.m13 = (int) m13;
        this.m20 = (int) m20;
        this.m21 = (int) m21;
        this.m22 = (int) m22;
        this.m23 = (int) m23;
        this.m30 = (int) m30;
        this.m31 = (int) m31;
        this.m32 = (int) m32;
        this.m33 = (int) m33;
        return this;
    }

    @Override
    public Mat4x4 storeInside(FloatBuffer buf) {
        buf.put(m00);
        buf.put(m01);
        buf.put(m02);
        buf.put(m03);
        buf.put(m10);
        buf.put(m11);
        buf.put(m12);
        buf.put(m13);
        buf.put(m20);
        buf.put(m21);
        buf.put(m22);
        buf.put(m23);
        buf.put(m30);
        buf.put(m31);
        buf.put(m32);
        buf.put(m33);
        return this;
    }

    @Override
    public float[][] toArr() {
        return new float[][]{
            {m00, m01, m02, m03},
            {m10, m11, m12, m13},
            {m20, m21, m22, m23},
            {m30, m31, m32, m33}
        };
    }

    @Override
    public Mat4x4 absElWise() {
        this.m00 = Math.abs(m00);
        this.m01 = Math.abs(m01);
        this.m02 = Math.abs(m02);
        this.m03 = Math.abs(m03);
        this.m10 = Math.abs(m10);
        this.m11 = Math.abs(m11);
        this.m12 = Math.abs(m12);
        this.m13 = Math.abs(m13);
        this.m20 = Math.abs(m20);
        this.m21 = Math.abs(m21);
        this.m22 = Math.abs(m22);
        this.m23 = Math.abs(m23);
        this.m30 = Math.abs(m30);
        this.m31 = Math.abs(m31);
        this.m32 = Math.abs(m32);
        this.m33 = Math.abs(m33);
        return this;
    }

    public Mat4x4 addElWise(Mat4x4 mat) {
        this.m00 = this.m00 + mat.m00;
        this.m01 = this.m01 + mat.m01;
        this.m02 = this.m02 + mat.m02;
        this.m03 = this.m03 + mat.m03;
        this.m10 = this.m10 + mat.m10;
        this.m11 = this.m11 + mat.m11;
        this.m12 = this.m12 + mat.m12;
        this.m13 = this.m13 + mat.m13;
        this.m20 = this.m20 + mat.m20;
        this.m21 = this.m21 + mat.m21;
        this.m22 = this.m22 + mat.m22;
        this.m23 = this.m23 + mat.m23;
        this.m30 = this.m30 + mat.m30;
        this.m31 = this.m31 + mat.m31;
        this.m32 = this.m32 + mat.m32;
        this.m33 = this.m33 + mat.m33;
        return this;
    }

    public Mat4x4 subElWise(Mat4x4 mat) {
        this.m00 = this.m00 - mat.m00;
        this.m01 = this.m01 - mat.m01;
        this.m02 = this.m02 - mat.m02;
        this.m03 = this.m03 - mat.m03;
        this.m10 = this.m10 - mat.m10;
        this.m11 = this.m11 - mat.m11;
        this.m12 = this.m12 - mat.m12;
        this.m13 = this.m13 - mat.m13;
        this.m20 = this.m20 - mat.m20;
        this.m21 = this.m21 - mat.m21;
        this.m22 = this.m22 - mat.m22;
        this.m23 = this.m23 - mat.m23;
        this.m30 = this.m30 - mat.m30;
        this.m31 = this.m31 - mat.m31;
        this.m32 = this.m32 - mat.m32;
        this.m33 = this.m33 - mat.m33;
        return this;
    }

    public Mat4x4 mulElWise(Mat4x4 mat) {
        this.m00 = this.m00 * mat.m00;
        this.m01 = this.m01 * mat.m01;
        this.m02 = this.m02 * mat.m02;
        this.m03 = this.m03 * mat.m03;
        this.m10 = this.m10 * mat.m10;
        this.m11 = this.m11 * mat.m11;
        this.m12 = this.m12 * mat.m12;
        this.m13 = this.m13 * mat.m13;
        this.m20 = this.m20 * mat.m20;
        this.m21 = this.m21 * mat.m21;
        this.m22 = this.m22 * mat.m22;
        this.m23 = this.m23 * mat.m23;
        this.m30 = this.m30 * mat.m30;
        this.m31 = this.m31 * mat.m31;
        this.m32 = this.m32 * mat.m32;
        this.m33 = this.m33 * mat.m33;
        return this;
    }

    public Mat4x4 divElWise(Mat4x4 mat) {
        this.m00 = this.m00 / mat.m00;
        this.m01 = this.m01 / mat.m01;
        this.m02 = this.m02 / mat.m02;
        this.m03 = this.m03 / mat.m03;
        this.m10 = this.m10 / mat.m10;
        this.m11 = this.m11 / mat.m11;
        this.m12 = this.m12 / mat.m12;
        this.m13 = this.m13 / mat.m13;
        this.m20 = this.m20 / mat.m20;
        this.m21 = this.m21 / mat.m21;
        this.m22 = this.m22 / mat.m22;
        this.m23 = this.m23 / mat.m23;
        this.m30 = this.m30 / mat.m30;
        this.m31 = this.m31 / mat.m31;
        this.m32 = this.m32 / mat.m32;
        this.m33 = this.m33 / mat.m33;
        return this;
    }

    @Override
    public Mat4x4 addElWise(float r) {
        this.m00 = this.m00 + r;
        this.m01 = this.m01 + r;
        this.m02 = this.m02 + r;
        this.m03 = this.m03 + r;
        this.m10 = this.m10 + r;
        this.m11 = this.m11 + r;
        this.m12 = this.m12 + r;
        this.m13 = this.m13 + r;
        this.m20 = this.m20 + r;
        this.m21 = this.m21 + r;
        this.m22 = this.m22 + r;
        this.m23 = this.m23 + r;
        this.m30 = this.m30 + r;
        this.m31 = this.m31 + r;
        this.m32 = this.m32 + r;
        this.m33 = this.m33 + r;
        return this;
    }

    @Override
    public Matrix subElWise(float r) {
        this.m00 = this.m00 - r;
        this.m01 = this.m01 - r;
        this.m02 = this.m02 - r;
        this.m03 = this.m03 - r;
        this.m10 = this.m10 - r;
        this.m11 = this.m11 - r;
        this.m12 = this.m12 - r;
        this.m13 = this.m13 - r;
        this.m20 = this.m20 - r;
        this.m21 = this.m21 - r;
        this.m22 = this.m22 - r;
        this.m23 = this.m23 - r;
        this.m30 = this.m30 - r;
        this.m31 = this.m31 - r;
        this.m32 = this.m32 - r;
        this.m33 = this.m33 - r;
        return this;
    }

    @Override
    public Matrix mulElWise(float r) {
        this.m00 = this.m00 * r;
        this.m01 = this.m01 * r;
        this.m02 = this.m02 * r;
        this.m03 = this.m03 * r;
        this.m10 = this.m10 * r;
        this.m11 = this.m11 * r;
        this.m12 = this.m12 * r;
        this.m13 = this.m13 * r;
        this.m20 = this.m20 * r;
        this.m21 = this.m21 * r;
        this.m22 = this.m22 * r;
        this.m23 = this.m23 * r;
        this.m30 = this.m30 * r;
        this.m31 = this.m31 * r;
        this.m32 = this.m32 * r;
        this.m33 = this.m33 * r;
        return this;
    }

    @Override
    public Matrix divElWise(float r) {
        this.m00 = this.m00 / r;
        this.m01 = this.m01 / r;
        this.m02 = this.m02 / r;
        this.m03 = this.m03 / r;
        this.m10 = this.m10 / r;
        this.m11 = this.m11 / r;
        this.m12 = this.m12 / r;
        this.m13 = this.m13 / r;
        this.m20 = this.m20 / r;
        this.m21 = this.m21 / r;
        this.m22 = this.m22 / r;
        this.m23 = this.m23 / r;
        this.m30 = this.m30 / r;
        this.m31 = this.m31 / r;
        this.m32 = this.m32 / r;
        this.m33 = this.m33 / r;
        return this;
    }
    
}
