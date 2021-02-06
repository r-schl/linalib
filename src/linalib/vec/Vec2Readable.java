package linalib.vec;

public interface Vec2Readable extends VecReadable {
    
    float getX();
    
    float getY();

    float dot(Vec2Readable v);

    float dot(float vX, float vY);

}
