package linalib.f.vector;

public interface FVec3Readable extends FVecReadable {

    float getX();
    
    float getY();

    float getZ();

    float dot(FVec3Readable v);

    float dot(float vX, float vY, float vZ);
    
}
