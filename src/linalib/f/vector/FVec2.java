package linalib.f.vector;

import java.nio.FloatBuffer;
import linalib.f.matrix.FMat2;
import linalib.f.matrix.FMat2Readable;


public class FVec2 implements FVec2Readable, FVecWritable {

    // static presets
    public static final FVec2Readable YAXIS = new FVec2(0, 1);
    public static final FVec2Readable XAXIS = new FVec2(1, 0);
    public static final FVec2Readable UP = new FVec2(YAXIS);
    public static final FVec2Readable DOWN = new FVec2(YAXIS).negate();
    public static final FVec2Readable RIGHT = new FVec2(XAXIS);
    public static final FVec2Readable LEFT = new FVec2(XAXIS).negate();

    public float x;
    public float y;

    private boolean isTransposed;

    public FVec2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public FVec2(float xy) {
        this(xy, xy);
    }

    public FVec2(FVec2Readable other) {
        this(other.getX(), other.getY());
        if (other.isTransposed()) this.transpose();
    }

    public FVec2(FVec3Readable other) {
        this(other.getX(), other.getY());
        if (other.isTransposed()) this.transpose();
    }
    
    public FVec2(FVec4Readable other) {
        this(other.getX(), other.getY());
        if (other.isTransposed()) this.transpose();
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float dot(FVec2Readable v) {
        return this.x * v.getX() + this.y * v.getY();
    }

    @Override
    public float dot(float vX, float vY) {
        return this.x * vX + this.y * vY;
    }

    @Override
    public float len() {
        return (float) Math.sqrt(len2());
    }

    @Override
    public float len2() {
        return this.x * this.x + this.y * this.y;
    }

    @Override
    public float get(int i) {
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
    public float max() {
        float max = this.x;
        if (this.y > max)
            max = this.y;
        return max;
    }

    @Override
    public FVec2 storeInside(FloatBuffer buf) {
        buf.put(x);
        buf.put(y);
        return this;
    }

    @Override
    public float[][] newArr2() {
        return this.isHor() ? new float[][] { { x, y} } : new float[][] { { x }, { y } };
    }

    @Override
    public float[] newArr() {
        return new float[] {x, y};
    }

    @Override
    public boolean contains(float r) {
        return this.x == r || this.y == r;
    }

    @Override
    public FVec2 set(int i, float val) {
        if (i == 0) this.x = val;
        else if (i == 1) this.y = val;
        return this;
    }

    @Override
    public FVec2 toInt() {
        this.x = (int) this.x;
        this.y = (int) this.y;
        return this;
    }

    @Override
    public FVec2 absElWise() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        return this;
    }

    @Override
    public FVec2 add(float r) {
        this.x = this.x + r;
        this.y = this.y + r;
        return this;
    }

    @Override
    public FVec2 sub(float r) {
        this.x = this.x - r;
        this.y = this.y - r;
        return this;
    }

    @Override
    public FVec2 presub(float r) {
        this.x = r - this.x;
        this.y = r - this.y;
        return this;
    }

    @Override
    public FVec2 mul(float r) {
        this.x = this.x * r;
        this.y = this.y * r;
        return this;
    }

    @Override
    public FVec2 div(float r) {
        if (r == 0) throw new IllegalArgumentException("Cannot divide by 0");
        this.x = this.x / r;
        this.y = this.y / r;
        return this;
    }

    @Override
    public FVec2 prediv(float r) {
        if (this.contains(0)) throw new IllegalArgumentException("Cannot divide by 0");
        this.x = r / this.x;
        this.y = r / this.y;
        return this;
    }

    @Override
    public FVec2 negate() {
        this.x = -this.x;
        this.y = -this.y;
        return this;
    }

    @Override
    public FVec2 floor(float r) {
        this.x = (this.x - (this.x % r));
        this.y = (this.y - (this.y % r));
        return this;
    }

    @Override
    public FVec2 round() {
        this.x = Math.round(x);
        this.y = Math.round(y);
        return this;
    }

    @Override
    public FVec2 normalize() {
        return this.div(this.len());
    }

    @Override
    public FVec2 flip() {
        if (this.isHor()) return this.mul(FMat2.FLIP);
        return this.premul(FMat2.FLIP);
    }

    @Override
    public FVec2 transpose() {
        isTransposed = !isTransposed;
        return this;
    }

    public FVec2 setX(float val) {
        this.x = val;
        return this;
    }

    public FVec2 setY(float val) {
        this.y = val;
        return this;
    }

    public FVec2 set(FVec2Readable v) {
        this.x = v.getX();
        this.y = v.getY();
        return this;
    }

    public FVec2 set(float vX, float vY) {
        this.x = vX;
        this.y = vY;
        return this;
    }

    public FVec2 set(FVec3Readable v) {
        return this.set(v.getX(), v.getY());
    }

    public FVec2 set(FVec4Readable v) {
        return this.set(v.getX(), v.getY());
    }
    
    public FVec2 perpendicular() {
        float tempX = this.x;
        this.x = this.y;
        this.y = -tempX;
        return this;
    }

    public FVec2 add(FVec2Readable v) {
        this.x = this.x + v.getX();
        this.y = this.y + v.getY();
        return this;
    }

    public FVec2 add(float vX, float vY) {
        this.x = this.x + vX;
        this.y = this.y + vY;
        return this;   
    }

    public FVec2 sub(FVec2Readable v) {
        this.x = this.x - v.getX();
        this.y = this.y - v.getY();
        return this;
    }

    public FVec2 sub(float vX, float vY) {
        this.x = this.x - vX;
        this.y = this.y - vY;
        return this;
    }

    public FVec2 presub(FVec2Readable v) {
        this.x = v.getX() - this.x;
        this.y = v.getY() - this.y;
        return this;
    }

    public FVec2 presub(float vX, float vY) {
        this.x = vX - this.x;
        this.y = vY - this.y;
        return this;
    }

    public FVec2 mul(FMat2Readable mat) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 2x2 matrix.").printStackTrace();
            System.exit(-1);
        }
        float x = this.x * mat.get00() + this.y * mat.get10(); 
        float y = this.x * mat.get01() + this.y * mat.get11();
        this.x = x;
        this.y = y;
        return this;
    }

    public FVec2 mul(float mat00, float mat01, float mat10, float mat11) {
        if (isVer()) {
            new Exception("Cannot multiply a vertical vector with a 2x2 matrix.").printStackTrace();
            System.exit(-1);
        }
        float x = this.x * mat00 + this.y * mat10;
        float y = this.x * mat01 + this.y * mat11;
        this.x = x;
        this.y = y;
        return this;
    }

    public FVec2 premul(FMat2Readable mat) {
        if (isHor()) {
            new Exception("Cannot multiply 2x2 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        float x = mat.get00() * this.x + mat.get01() * this.y;
        float y = mat.get10() * this.x + mat.get11() * this.y;
        this.x = x;
        this.y = y;
        return this;
    }

    public FVec2 premul(float mat00, float mat01, float mat10, float mat11) {
        if (isHor()) {
            new Exception("Cannot multiply 2x2 matrix with an horizontal vector.").printStackTrace();
            System.exit(-1);
        }
        float x = mat00 * this.x + mat01 * this.y;
        float y = mat10 * this.x + mat11 * this.y;
        this.x = x;
        this.y = y;
        return this;
    }

    public FVec2 swap(FVec2 v) {
        float tempX = this.x;
        float tempY = this.y;
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
    public FVec2 to(FVecWritable v) {
        this.extractTo(v);
        return this;
    }

    @Override
    public FVec2 from(FVecReadable v) {
        this.extractFrom(v);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof FVec2Readable) {
            FVec2Readable vec = (FVec2Readable) o;
            return this.x == vec.getX() && this.y == vec.getY();
        }
        return false;
    }

}
