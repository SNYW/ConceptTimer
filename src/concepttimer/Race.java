
package concepttimer;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;



public class Race {
    public boolean racing = false;
    private String rTime = "00:00";
    private Long startTime;
    private int ms;
    private int currentDog = 0;
    private final List<Dog> dogs;
   Timer rTimer = new Timer(); 
  
    public Race(List d) {
    
        this.dogs = d;
        
    }
    
    TimerTask rTimerTask = new TimerTask() {
        @Override
        public void run() {
        Long r = (System.currentTimeMillis() -  startTime);
        if (ms<99) {ms++;}else{ms=00;}
        
        rTime = String.format("%02d:%02d:%02d", 
                TimeUnit.MILLISECONDS.toMinutes(r),
                TimeUnit.MILLISECONDS.toSeconds(r) - 
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(r)),
                ms); 
        
        
        } 
    };
    
    public void startRace(){
        racing = true;
        rTimer.scheduleAtFixedRate(rTimerTask, 10, 10);
        startTime = System.currentTimeMillis();
    }
    
    public void stopRace(){
    rTimer.cancel();
    }
    
    public String getRaceTime() {
        return this.rTime;
    }
    
    public String trig1(){
        String s = dogs.get(currentDog).getName()+" has started to run at "+rTime;
        this.currentDog++;
        return s;
        
    }
    public void trig2(){
        
    }
}

    

