package linalib.f.matrix;

public interface FMatWritable extends FMatReadable {

    FMatWritable transpose();

    FMatWritable flipHor();

    FMatWritable flipVer();

    FMatWritable set(int r, int c, float val);

    FMatWritable roundElWise();

    FMatWritable floorElWise(float r);

    FMatWritable negateElWise();

    FMatWritable toInt();

    FMatWritable absElWise();

    FMatWritable addElWise(float r);

    FMatWritable subElWise(float r);

    FMatWritable presubElWise(float r);

    FMatWritable mulElWise(float r);

    FMatWritable divElWise(float r);

    FMatWritable predivElWise(float r);
    
    default FMatWritable rotate(int n) {
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

    default void extractFrom(FMatReadable mat) {
        for (int r = 0; r < this.rowCount(); r++) {
            for (int c = 0; c < this.colCount(); c++) {
                if (r >= mat.rowCount() || c >= mat.colCount()) continue;
                this.set(r, c, mat.get(r, c));
            }
        }
    }

    FMatWritable from(FMatReadable mat);
}
