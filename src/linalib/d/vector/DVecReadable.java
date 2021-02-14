package linalib.d.vector;

import java.nio.DoubleBuffer;

public interface DVecReadable {

    double len();

    double len2();

    double get(int i);

    public default int getInt(int i) {
        return (int) get(i);
    }

    boolean isVer();

    boolean isHor();

    boolean isTransposed();

    int size();

    double max();

    DVecReadable storeInside(DoubleBuffer buf);

    double[][] newArr2();

    double[] newArr();

    boolean contains(double r);

    public default void print() {
        System.out.println(this);
    }

    default void extractTo(DVecWritable v) {
        for (int i = 0; i < this.size(); i++) {
            if (i >= v.size())
                break;
            v.set(i, this.get(i));
        }
    }

    DVecReadable to(DVecWritable v);
}
