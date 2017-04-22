package concepttimer;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Race {

    public boolean racing = false;
    private String rTime = "00:00:00";
    private Long startTime;
    private int ms;
    private int currentDog = 0;
    private List<Dog> dogs = null;
    private int trig1count, trig2count = 0;
    private List<RaceFault> faults = new ArrayList<RaceFault>();
    Timer rTimer = new Timer();
    private Boolean useFault = null;

    private int currentRun = 0;

    public Race(List d) {

        this.dogs = d;

    }

    TimerTask rTimerTask = new TimerTask() {
        @Override
        public void run() {
            Long r = (System.currentTimeMillis() - startTime);
            if (ms < 99) {
                ms++;
            } else {
                ms = 00;
            }

            rTime = String.format("%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(r),
                    TimeUnit.MILLISECONDS.toSeconds(r)
                    - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(r)),
                    ms);

        }
    };

    public void startRace() {
        currentDog = 0;
        trig1count = 0;
        trig2count = 0;
        rTime = "00:00:00";
        rTimer = new Timer();
        racing = true;
        rTimer.scheduleAtFixedRate(rTimerTask = new TimerTask() {
            @Override
            public void run() {
                Long r = (System.currentTimeMillis() - startTime);
                if (ms < 99) {
                    ms++;
                } else {
                    ms = 00;
                }

                rTime = String.format("%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(r),
                        TimeUnit.MILLISECONDS.toSeconds(r)
                        - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(r)),
                        ms);

            }
        }, 10, 10);

        startTime = System.currentTimeMillis();
    }

    public void stopRace() {
        rTimer.cancel();
        // rTimer.purge();
        racing = false;
        //rTime = "00:00:00";
        currentDog = 0;
        trig1count = 0;
        trig2count = 0;

    }

    public String getRaceTime() {
        return this.rTime;
    }

    public String trig1() {
        if (useFault){
             if (trig1count > trig2count) {
                RaceFault f = new RaceFault(rTime, getDogs().get(getCurrentDog()));
                getFaults().add(f);
                System.out.println(f.toString());
            }
        }
        String retStr = getDogs().get(getCurrentDog()).getName() + " started a Run \n @ " + rTime + "\n";
        currentDog++;
        trig1count++;
        return retStr;

    }

    public void trig2() {
        trig2count++;

    }

    /**
     * @return the currentDog
     */
    public int getCurrentDog() {
        return currentDog;
    }

    /**
     * @return the dogs
     */
    public List<Dog> getDogs() {
        return dogs;
    }

    /**
     * @param dogs the dogs to set
     */
    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    /**
     * @return the faults
     */
    public List<RaceFault> getFaults() {
        return faults;
    }

    /**
     * @return the currentRun
     */
    public int getCurrentRun() {
        return currentRun;
    }

    /**
     * @param currentDog the currentDog to set
     */
    public void setCurrentDog(int currentDog) {
        this.currentDog = currentDog;
    }
    
    public void setUseFault(Boolean f){
        this.useFault = f;
    }
}
