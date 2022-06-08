package linalib;

import java.nio.FloatBuffer;

public interface Vec2Readable {

    float getLen();

    float getLen2();

    float getMax();

    float getX();

    float getY();

    boolean isVer();

    boolean isHor();

    boolean isTransposed();

    void storeInBuffer(FloatBuffer buf);

    float[][] getNewArr2();

    float[] getNewArr();

    boolean contains(float r);

}