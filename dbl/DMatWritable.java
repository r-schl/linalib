package linalib.dbl;

public interface DMatWritable extends DMatReadable {

    DMatWritable transpose();

    DMatWritable flipHor();

    DMatWritable flipVer();

    DMatWritable set(int r, int c, double val);

    DMatWritable roundElWise();

    DMatWritable floorElWise(double r);

    DMatWritable negateElWise();

    DMatWritable toInt();

    DMatWritable absElWise();

    DMatWritable addElWise(double r);

    DMatWritable subElWise(double r);

    DMatWritable presubElWise(double r);

    DMatWritable mulElWise(double r);

    DMatWritable divElWise(double r);

    DMatWritable predivElWise(double r);
    
    default DMatWritable rotate(int n) {
        if (n == 0) return this;
        if (n > 0) {
            // clockwise
            for (int i = 0; i < n; i++) {
                this.transpose();
                this.flipHor();
            }
        }
        if (n < 0) {
            // anti clockwise
            for (int i = 0; i < Math.abs(n); i++) {
                this.transpose();
                this.flipVer();
            }
        }
        return this;
    }

    default void extractFrom(DMatReadable mat) {
        for (int r = 0; r < this.rowCount(); r++) {
            for (int c = 0; c < this.colCount(); c++) {
                if (r >= mat.rowCount() || c >= mat.colCount()) continue;
                this.set(r, c, mat.get(r, c));
            }
        }
    }

    DMatWritable from(DMatReadable mat);
}
