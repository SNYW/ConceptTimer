
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
    private boolean dogRunning = false;
    private boolean tripFlag1 = false;
    private boolean tripFlag2 = true;
    private int currentRun = 0;    
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
    rTimer.purge();
    racing = false;
    }
    
    public String getRaceTime() {
        return this.rTime;
    }
    
    public String trig1(){
        tripFlag1 = !tripFlag1;
        String s;
        if (dogRunning){
            s = "Crossover Fault \n"
                +dogs.get(currentDog).getName()+" faulted at "+rTime+"\n";
                return s; }
        if (currentRun != 1){
            if (tripFlag1 == tripFlag2) dogRunning = !dogRunning; }
        
        if (currentDog <= dogs.size()-1){
            s = dogs.get(currentDog).getName()+" started to run at "+rTime+"\n";
            this.currentDog++;
            this.currentRun++;
            return s;
        }else{
            s = "Last Dog has run \n";
        }
       
    return s;
    }
    public void trig2(){
        if (currentRun != 1) tripFlag2 = !tripFlag2;
        
    }
}

    

