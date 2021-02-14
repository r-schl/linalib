package linalib.f.vector;

public interface FVec2Readable extends FVecReadable {
    
    float getX();
    
    float getY();

    float dot(FVec2Readable v);

    float dot(float vX, float vY);

}
