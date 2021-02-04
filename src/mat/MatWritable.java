package mat;

public interface MatWritable extends MatReadable {

    MatWritable transpose();

    MatWritable flipHor();

    MatWritable flipVer();

    MatWritable set(int r, int c, float val);

    MatWritable roundElWise();

    MatWritable floorElWise(float r);

    MatWritable negateElWise();

    MatWritable toInt();

    MatWritable absElWise();

    MatWritable addElWise(float r);

    MatWritable subElWise(float r);

    MatWritable subElWiseRvs(float r);

    MatWritable mulElWise(float r);

    MatWritable divElWise(float r);

    MatWritable divElWiseRvs(float r);
    
    default MatWritable rotate(int n) {
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

    default void extractFrom(MatReadable mat) {
        for (int r = 0; r < this.rowCount(); r++) {
            for (int c = 0; c < this.colCount(); c++) {
                if (r >= mat.rowCount() || c >= mat.colCount()) continue;
                this.set(r, c, mat.get(r, c));
            }
        }
    }

    MatWritable from(MatReadable mat);
}
