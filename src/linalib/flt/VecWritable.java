package linalib.flt;


public interface VecWritable extends VecReadable {

    VecWritable set(int i, float val);

    VecWritable toInt();

    VecWritable absElWise();

    VecWritable add(float r);

    VecWritable sub(float r);

    VecWritable presub(float r);

    VecWritable mul(float r);

    VecWritable div(float r);

    VecWritable prediv(float r);

    VecWritable negate();

    VecWritable floor(float r);

    VecWritable round();

    VecWritable normalize();

    VecWritable flip();

    default VecWritable flipHor() {
        if (isHor()) flip();
        return this;
    }

    default VecWritable flipVer() {
        if (isVer()) flip();
        return this;
    }

    VecWritable transpose();

    default VecWritable rotate(int n) {
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

    default void extractFrom(VecReadable v) {
        for(int i = 0; i< this.size(); i++) {
            if (i >= v.size()) break;
            this.set(i, v.get(i));
        }
    }

    VecWritable from(VecReadable v);

}