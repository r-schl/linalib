package linalib.dbl;

public interface DVec2Readable extends DVecReadable {

    double getX();
    
    double getY();

    double dot(DVec2Readable v);

    double dot(double vX, double vY);
    
}
