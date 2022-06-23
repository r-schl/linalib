package linalib.utils;

public class GameLoop {

    boolean isRunning = true;
    double ups;
    double fps;
    double timeU;
    double timeF;
    int ticks;
    int frames;
    int seconds;

    public GameLoop(int ups, int fps) {
        this.fps = fps;
        this.ups = ups;
    }

    public void run(Runnable onUpdate, Runnable onRender) {
        // for information
        long timer = System.currentTimeMillis(); // for information
        double lastTime = System.nanoTime();
        ticks = 0;
        frames = 0;
        seconds = 0;
        double deltaU = 0;
        double deltaF = 0;
        timeF = 1000000000 / fps;
        timeU = 1000000000 / ups;

        while (isRunning) {
            long now = System.nanoTime();
            deltaU += (now - lastTime) / timeU;
            deltaF += (now - lastTime) / timeF;
            lastTime = now;

            if (deltaU >= 1) {
                onUpdate.run();
                ticks++;
                deltaU--;
            }

            if (deltaF >= 1) {
                onRender.run();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                seconds++;
                // do something here

                frames = 0;
                ticks = 0;
            }
        }

    }

}
