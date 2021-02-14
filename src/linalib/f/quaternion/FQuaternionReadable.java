package linalib.f.quaternion;

import java.nio.FloatBuffer;


public interface FQuaternionReadable {

    float get(int i);

    float getW();
    
    float getX();

    float getY();

    float getZ();

    float len();

    float len2();

    float norm();

    boolean isPure();

    float[] newArr();

    FQuaternionReadable storeInside(FloatBuffer buf);

    boolean contains(float r);

    default void print() {
        System.out.println(this);
    }

    float getRotAngle();

    float getRotAxisX();

    float getRotAxisY();

    float getRotAxisZ();
    
}
