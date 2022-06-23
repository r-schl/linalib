package linalib;

import java.nio.FloatBuffer;

public interface Mat2Readable {

    float get00();

    float get01();

    float get10();

    float get11();

    float get(int r, int c);

    float[] getNewArr();

    float[][] getNewArr2();

    void storeInBuffer(FloatBuffer buf);

    float getDeterminant();
}
