package linalib.dbl;

public interface DVec3Readable extends DVecReadable {

    double getX();
       
    double getY();

    double getZ();

    double dot(DVec3Readable v);

    double dot(double vX, double vY, double vZ);
}
