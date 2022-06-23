package linalib;

import java.nio.FloatBuffer;

public interface Vec3Readable {

    float getLength();

    float getLength2();

    float getMax();

    float getX();

    float getY();

    float getZ();

    boolean isVer();

    boolean isHor();

    boolean isTransposed();

    void storeInBuffer(FloatBuffer buf);

    float[][] getNewArr2();

    float[] getNewArr();

    boolean contains(float r);
    
}
