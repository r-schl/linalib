package linalib.dbl;

public interface DVecWritable extends DVecReadable {
    
    DVecWritable set(int i, double val);

    DVecWritable toInt();

    DVecWritable absElWise();

    DVecWritable add(double r);

    DVecWritable sub(double r);

    DVecWritable presub(double r);

    DVecWritable mul(double r);

    DVecWritable div(double r);

    DVecWritable prediv(double r);

    DVecWritable negate();

    DVecWritable floor(double r);

    DVecWritable round();

    DVecWritable normalize();

    DVecWritable flip();

    default DVecWritable flipHor() {
        if (isHor()) flip();
        return this;
    }

    default DVecWritable flipVer() {
        if (isVer()) flip();
        return this;
    }

    DVecWritable transpose();

    default DVecWritable rotate(int n) {
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

    default void extractFrom(DVecReadable v) {
        for(int i = 0; i< this.size(); i++) {
            if (i >= v.size()) break;
            this.set(i, v.get(i));
        }
    }

    DVecWritable from(DVecReadable v);
}
