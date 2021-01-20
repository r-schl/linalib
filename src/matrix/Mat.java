package matrix;

import java.nio.FloatBuffer;

public class Mat extends Matrix {

    float[][] m;

    public Mat(int rows, int cols) {
        this.m = new float[rows][cols];
    }

    public Mat(float[][] m){
        this.m = m;
    }

    public Mat set(float[][] m) {
        this.m = m;
        return this;
    }

    public Mat set(float... values) {
        int i = 0;
        for (int r = 0; r < rowCount(); r++) {
            for (int c = 0; c < colCount(); c++){
                m[r][c] = values[i++];
            }
        }
        return this;
    }

    public Mat set(Mat mat) {
        this.m = mat.toArr();
        return this;
    }

    @Override
    public int rowCount() {
        return m.length;
    }

    @Override
    public int colCount() {
        return m[0].length;
    }

    @Override
    public float get(int row, int col) {
        if (row >= rowCount() || row < 0 || col >= colCount() || col < 0) {
            throw new IllegalArgumentException("Row and/or column out of range. " + row + " " + col);
        }
        return m[row][col];
    }

    @Override
    public int getInt(int row, int col) {
        return (int) get(row, col);
    }

    @Override
    public void set(int row, int col, float val) {
        if (row >= rowCount() || row < 0 || col >= colCount() || col < 0) {
            throw new IllegalArgumentException("Row and/or column out of range. " + row + " " + col);
        }
        this.m[row][col] = val;
    }

    @Override
    public Mat copy() {
        return new Mat(m);
    }

    @Override
    public Mat flipHor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mat flipVer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mat transpose() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mat toInt() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mat storeInside(FloatBuffer buf) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mat absElWise() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public float[][] toArr() {
        float[][] res = new float[this.rowCount()][this.colCount()];
        for (int r = 0; r < rowCount(); r++) {
            for (int c = 0; c < colCount(); c++) {
                res[r][c] = this.m[r][c];
            }
        }
        return res;
    }

    
    
}
