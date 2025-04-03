package cps;


import java.util.Timer;
import java.util.TimerTask;
import frame.Frame;

public class Cps {

    private int clicks = 0;
    private int timeLeft = 5;
    private boolean running = false;
    private Timer timer;
    private Frame frame;

    public Cps(Frame frame) {
        this.frame = frame;
    }

    public void handleClick() {
        if (!running) {
            startTimer();
        }
        clicks++;
        frame.updateClickLabel(clicks);
    }

    private void startTimer() {
        running = true;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeLeft--;
                frame.updateTimerLabel(timeLeft);
                if (timeLeft <= 0) {
                    timer.cancel();
                    running = false;
                    double cps = clicks / 5.0;
                    frame.showResult(cps);
                }
            }
        }, 1000, 1000);
    }

    public void resetTest() {
        if (timer != null) {
            timer.cancel();
        }
        clicks = 0;
        timeLeft = 5;
        running = false;
        frame.updateClickLabel(0);
        frame.updateTimerLabel(5);
    }
}
