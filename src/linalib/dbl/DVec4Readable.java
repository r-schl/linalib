package linalib.dbl;

public interface DVec4Readable extends DVecReadable {
    
    double getX();
    
    double getY();

    double getZ();

    double getW();

    double dot(DVec4Readable v);

    double dot(double vX, double vY, double vZ, double vW);
}
