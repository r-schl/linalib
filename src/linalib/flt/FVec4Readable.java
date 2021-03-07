package linalib.flt;

public interface FVec4Readable extends FVecReadable {

    float getX();
    
    float getY();

    float getZ();

    float getW();

    float dot(FVec4Readable v);

    float dot(float vX, float vY, float vZ, float vW);
}
