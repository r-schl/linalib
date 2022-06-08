package linalib;

import java.nio.FloatBuffer;

public interface Vec4Readable {

    float getLen();

    float getLen2();

    float getMax();

    float getX();

    float getY();

    float getZ();

    float getW();

    boolean isVer();

    boolean isHor();

    boolean isTransposed();

    void storeInBuffer(FloatBuffer buf);

    float[][] getNewArr2();

    float[] getNewArr();

    boolean contains(float r);
}
