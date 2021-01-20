import matrix.Mat;
import vector.Vec2;
import vector.Vec3;

public class Main {

    public static void main(String... args) {

        Vec2 lol = new Vec2(1, 2);

        new Vec3(lol, 2).to(lol);
        lol.flipHor();
        lol.print();
    }

}