package scheduler;

import dao.ApplicationDao;

import java.util.Timer;
import java.util.TimerTask;

public class SchedulingOccurrence {

    public class dailyTimer {
        private final Timer timer = new Timer();
        private final long day;

        public dailyTimer(int day) {
            this.day = day;
        }

        public void start() {
            timer.schedule(new TimerTask() {
                public void run() {
                    runProgramCheck();
                    timer.cancel();
                }
                private void runProgramCheck() {


                    // Start a new thread to play a sound...
                }
            },  day *60*60*24);
        }

        public void main(String[] args) {
            dailyTimer dailyTimer1 = new dailyTimer(1);
            dailyTimer1.start();
        }

    }
}
