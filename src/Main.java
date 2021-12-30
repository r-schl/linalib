import linalib.dbl.DMat3;
import linalib.dbl.DVec3;

public class Main {

    public static void main(String... args) {

        DVec3 a = new DVec3(1,2,3);
        
        DMat3 A = DMat3.newRot3AroundZAxis(90);

        a.premul(A);
        a.print();

        


    }



}