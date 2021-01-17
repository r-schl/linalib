import matrix.Mat2x2;
import matrix.Mat3x3;

public class Main {

    public static void main(String... args) {
        Mat3x3 mat = new Mat3x3();
        Mat3x3 mat2 = new Mat3x3();
        mat.addElWise(2).print();
    }

}