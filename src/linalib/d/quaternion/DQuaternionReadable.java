package linalib.d.quaternion;

import java.nio.DoubleBuffer;


public interface DQuaternionReadable {

    double get(int i);

    double getW();
    
    double getX();

    double getY();

    double getZ();

    double len();

    double len2();

    double norm();

    boolean isPure();

    double[] newArr();

    DQuaternionReadable storeInside(DoubleBuffer buf);

    boolean contains(double r);

    default void print() {
        System.out.println(this);
    }

    double getRotAngle();

    double getRotAxisX();

    double getRotAxisY();

    double getRotAxisZ();
    
}
