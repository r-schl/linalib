package linalib.dbl;
import java.nio.DoubleBuffer;

public interface DMatReadable {

    int rowCount();

    int colCount();

    default int elmCount() {
        return rowCount() * colCount();
    }

    double get(int r, int c);

    default int getInt(int r, int c) {
        return (int) get(r, c);
    }

    default boolean isVer() {
        return rowCount() > colCount();
    }

    default boolean isHor() {
        return colCount() > rowCount();
    }

    default boolean isSqr() {
        return rowCount() == colCount();
    }

    double[] newArr();

    double[][] newArr2();

    DMatReadable storeInside(DoubleBuffer buf);

    default boolean hasSameSize(DMatReadable mat) {
        return mat.rowCount() == this.rowCount() && mat.colCount() == this.colCount();
    }

    default String buildString() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < this.rowCount(); row++) {
            for (int col = 0; col < this.colCount(); col++) {
                builder.append(this.get(row, col));
                builder.append(" ");
            }
            if (row != this.rowCount() - 1) builder.append("\n");
        }
        return String.valueOf(builder);
    }

    default void print() {
        System.out.println(this);
    }

    default void extractTo(DMatWritable mat) {
        for (int r = 0; r < this.rowCount(); r++) {
            for (int c = 0; c < this.colCount(); c++) {
                if (r >= mat.rowCount() || c >= mat.colCount()) continue;
                mat.set(r, c, this.get(r, c));
            }
        }
    }

    DMatReadable to(DMatWritable mat);
    
}