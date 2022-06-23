package linalib;

import java.nio.FloatBuffer;

public interface Mat3Readable {

    float get00();

    float get01();

    float get02();

    float get10();

    float get11();

    float get12();

    float get20();

    float get21();

    float get22();

    float get(int r, int c);

    float[] getNewArr();

    float[][] getNewArr2();

    void storeInBuffer(FloatBuffer buf);

    float getDeterminant();
}
