package linalib.f.vector;


public interface FVecWritable extends FVecReadable {

    FVecWritable set(int i, float val);

    FVecWritable toInt();

    FVecWritable absElWise();

    FVecWritable add(float r);

    FVecWritable sub(float r);

    FVecWritable presub(float r);

    FVecWritable mul(float r);

    FVecWritable div(float r);

    FVecWritable prediv(float r);

    FVecWritable negate();

    FVecWritable floor(float r);

    FVecWritable round();

    FVecWritable normalize();

    FVecWritable flip();

    default FVecWritable flipHor() {
        if (isHor()) flip();
        return this;
    }

    default FVecWritable flipVer() {
        if (isVer()) flip();
        return this;
    }

    FVecWritable transpose();

    default FVecWritable rotate(int n) {
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

    default void extractFrom(FVecReadable v) {
        for(int i = 0; i< this.size(); i++) {
            if (i >= v.size()) break;
            this.set(i, v.get(i));
        }
    }

    FVecWritable from(FVecReadable v);

}