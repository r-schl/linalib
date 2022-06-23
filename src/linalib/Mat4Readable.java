package linalib;

import java.nio.FloatBuffer;

public interface Mat4Readable {
    
    float get00();

    float get01();

    float get02();

    float get03();

    float get10();

    float get11();

    float get12();

    float get13();

    float get20();

    float get21();

    float get22();

    float get23();

    float get30();

    float get31();

    float get32();

    float get33();

    float get(int r, int c);

    float[] getNewArr();

    float[][] getNewArr2();

    void storeInBuffer(FloatBuffer buf);

    float getDeterminant();

}
