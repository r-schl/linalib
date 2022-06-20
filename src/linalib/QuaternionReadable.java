package linalib;

import java.nio.FloatBuffer;

public interface QuaternionReadable {
    
    float getW();
    
    float getX();

    float getY();

    float getZ();

    float getLen();

    float getLen2();

    float getNorm();

    boolean isPure();

    float[] newArr();

    void storeInBuffer(FloatBuffer buf);

    boolean contains(float r);

    float getRotAngle();

    Vec3 getRotAxis();
    
}
