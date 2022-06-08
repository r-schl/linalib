package linalib.flt;

public interface Vec4Readable extends VecReadable {

    float getX();
    
    float getY();

    float getZ();

    float getW();

    float dot(Vec4Readable v);

    float dot(float vX, float vY, float vZ, float vW);
}
