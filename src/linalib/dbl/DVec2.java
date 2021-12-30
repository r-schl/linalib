package linalib.dbl;

import java.nio.DoubleBuffer;


public class DVec2 implements DVec2Readable, DVecWritable {

    
    /**
     * This class is an implementation of a 2 dimensional vector.
     * 
     * In mathematics, physics and engineering, a Euclidean vector or simply a vector (sometimes called a geometric vector 
     * or spatial vector[2]) is a geometric object that has magnitude (or length) and direction.
     * 
     * All methods return the object itself. All changes are in place.
     */


    
    // static presets
    public static final DVec2Readable YAXIS = new DVec2(0, 1);
    public static final DVec2Readable XAXIS = new DVec2(1, 0);
    public static final DVec2Readable UP = new DVec2(YAXIS);
    public static final DVec2Readable DOWN = new DVec2(YAXIS).negate();
    public static final DVec2Readable RIGHT = new DVec2(XAXIS);
    public static final DVec2Readable LEFT = new DVec2(XAXIS).negate();

    public double x;
    public double y;

    private boolean isTransposed;

    public DVec2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public DVec2(double xy) {
        this(xy, xy);
    }

    public DVec2(DVec2Readable other) {
        this(other.getX(), other.getY());
        if (other.isTransposed()) this.transpose();
    }

    public DVec2(DVec3Readable other) {
        this(other.getX(), other.getY());
        if (other.isTransposed()) this.transpose();
    }
    
    public DVec2(DVec4Readable other) {
        this(other.getX(), other.getY());
        if (other.isTransposed()) this.transpose();
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double dot(DVec2Readable v) {
        return this.x * v.getX() + this.y * v.getY();
    }

    @Override
    public double dot(double vX, double vY) {
        return this.x * vX + this.y * vY;
    }

    @Override
    public double len() {
        return (double) Math.sqrt(len2());
    }

    @Override
    public double len2() {
        return this.x * this.x + this.y * this.y;
    }

    @Override
    public double get(int i) {
        if (i == 0) return this.x;
        else if (i == 1) return this.y;
        else new Exception("Index out of range for vector dimension " + this.size());
        return -1;
    }

    @Override
    public boolean isVer() {
        return !isTransposed;
    }

    @Override
    public boolean isHor() {
        return isTransposed;
    }

    @Override
    public boolean isTransposed() {
        return isTransposed;
    }

    @Override
    public int size() {
        return 2;
    }

    @Override
    public double max() {
        double max = this.x;
        if (this.y > max)
            max = this.y;
        return max;
    }

    @Override
    public DVec2 storeInside(DoubleBuffer buf) {
        buf.put(x);
        buf.put(y);
        return this;
    }

    @Override
    public double[][] newArr2() {
        return this.isHor() ? new double[][] { { x, y} } : new double[][] { { x }, { y } };
    }

    @Override
    public double[] newArr() {
        return new double[] {x, y};
    }

    @Override
    public boolean contains(double r) {
        return this.x == r || this.y == r;
    }

    @Override
    public DVec2 set(int i, double val) {
        if (i == 0) this.x = val;
        else if (i == 1) this.y = val;
        return this;
    }

    @Override
    public DVec2 toInt() {
        this.x = (int) this.x;
        this.y = (int) this.y;
        return this;
    }

    @Override
    public DVec2 absElWise() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        return this;
    }

    @Override
    public DVec2 add(double r) {
        this.x = this.x + r;
        this.y = this.y + r;
        return this;
    }

    @Override
    public DVec2 sub(double r) {
        this.x = this.x - r;
        this.y = this.y - r;
        return this;
    }

    @Override
    public DVec2 presub(double r) {
        this.x = r - this.x;
        this.y = r - this.y;
        return this;
    }

    @Override
    public DVec2 mul(double r) {
        this.x = this.x * r;
        this.y = this.y * r;
        return this;
    }

    @Override
    public DVec2 div(double r) {
        if (r == 0) throw new IllegalArgumentException("Cannot divide by 0");
        this.x = this.x / r;
        this.y = this.y / r;
        return this;
    }

    @Override
    public DVec2 prediv(double r) {
        if (this.contains(0)) throw new IllegalArgumentException("Cannot divide by 0");
        this.x = r / this.x;
        this.y = r / this.y;
        return this;
    }

    @Override
    public DVec2 negate() {
        this.x = -this.x;
        this.y = -this.y;
        return this;
    }

    @Override
    public DVec2 floor(double r) {
        this.x = (this.x - (this.x % r));
        this.y = (this.y - (this.y % r));
        return this;
    }

    @Override
    public DVec2 round() {
        this.x = Math.round(x);
        this.y = Math.round(y);
        return this;
    }

    @Override
    public DVec2 normalize() {
        return this.div(this.len());
    }

    @Override
    public DVec2 flip() {
        if (this.isHor()) return this.mul(DMat2.FLIP);
        return this.premul(DMat2.FLIP);
    }

    @Override
    public DVec2 transpose() {
        isTransposed = !isTransposed;
        return this;
    }

    public DVec2 setX(double val) {
        this.x = val;
        return this;
    }

    public DVec2 setY(double val) {
        this.y = val;
        return this;
    }

    public DVec2 set(DVec2Readable v) {
        this.x = v.getX();
        this.y = v.getY();
        return this;
    }

    public DVec2 set(double vX, double vY) {
        this.x = vX;
        this.y = vY;
        return this;
    }

    public DVec2 set(DVec3Readable v) {
        return this.set(v.getX(), v.getY());
    }

    public DVec2 set(DVec4Readable v) {
        return this.set(v.getX(), v.getY());
    }
    
    public DVec2 perpendicular() {
        double tempX = this.x;
        this.x = this.y;
        this.y = -tempX;
        return this;
    }

    public DVec2 add(DVec2Readable v) {
        this.x = this.x + v.getX();
        this.y = this.y + v.getY();
        return this;
    }

    public DVec2 add(double vX, double vY) {
        this.x = this.x + vX;
        this.y = this.y + vY;
        return this;   
    }

    public DVec2 sub(DVec2Readable v) {
        this.x = this.x - v.getX();
        this.y = this.y - v.getY();
        return this;
    }

    public DVec2 sub(double vX, double vY) {
        this.x = this.x - vX;
        this.y = this.y - vY;
        return this;
    }

    public DVec2 presub(DVec2Readable v) {
        this.x = v.getX() - this.x;
        this.y = v.getY() - this.y;
        return this;
    }

    public DVec2 presub(double vX, double vY) {
        this.x = vX - this.x;
        this.y = vY - this.y;
        return this;
    }

    public DVec2 mul(DMat2Readable mat) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 2x2 matrix.").printStackTrace();
            System.exit(-1);
        }
        double x = this.x * mat.get00() + this.y * mat.get10(); 
        double y = this.x * mat.get01() + this.y * mat.get11();
        this.x = x;
        this.y = y;
        return this;
    }

    public DVec2 mul(double mat00, double mat01, double mat10, double mat11) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 2x2 matrix.").printStackTrace();
            System.exit(-1);
        }
        double x = this.x * mat00 + this.y * mat10;
        double y = this.x * mat01 + this.y * mat11;
        this.x = x;
        this.y = y;
        return this;
    }

    public DVec2 premul(DMat2Readable mat) {
        if (isHor()) {
            new Exception("Cannot multiply 2x2 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        double x = mat.get00() * this.x + mat.get01() * this.y;
        double y = mat.get10() * this.x + mat.get11() * this.y;
        this.x = x;
        this.y = y;
        return this;
    }

    public DVec2 premul(double mat00, double mat01, double mat10, double mat11) {
        if (isHor()) {
            new Exception("Cannot multiply 2x2 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        double x = mat00 * this.x + mat01 * this.y;
        double y = mat10 * this.x + mat11 * this.y;
        this.x = x;
        this.y = y;
        return this;
    }

    public DVec2 swap(DVec2 v) {
        double tempX = this.x;
        double tempY = this.y;
        this.x = v.getX();
        this.y = v.getY();
        v.setX(tempX);
        v.setY(tempY);
        return this;
    }
    
    @Override
    public String toString() {
        return (this.isHor() ? "hor" : "ver") + "(" + this.x + " " + this.y + ")";
    }

    @Override
    public DVec2 to(DVecWritable v) {
        this.extractTo(v);
        return this;
    }

    @Override
    public DVec2 from(DVecReadable v) {
        this.extractFrom(v);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof DVec2Readable) {
            DVec2Readable vec = (DVec2Readable) o;
            return this.x == vec.getX() && this.y == vec.getY();
        }
        return false;
    }

}
