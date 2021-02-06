package linalib.vec;

import java.nio.FloatBuffer;

public interface VecReadable {

    float len();

    float len2();

    float get(int i);

    public default int getInt(int i) {
        return (int) get(i);
    }

    boolean isVer();

    boolean isHor();

    boolean isTransposed();

    int size();

    float max();

    VecReadable storeInside(FloatBuffer buf);

    float[][] newArr2();

    float[] newArr();

    boolean contains(float r);

    public default void print() {
        System.out.println(this);
    }

    default void extractTo(VecWritable v) {
        for (int i = 0; i < this.size(); i++) {
            if (i >= v.size())
                break;
            v.set(i, this.get(i));
        }
    }

    VecReadable to(VecWritable v);

}