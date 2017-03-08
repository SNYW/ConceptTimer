
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
    public List<RaceFault> faults = new ArrayList<RaceFault>();
    
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
    // rTimer.purge();
    racing = false;
    rTime = "00:00:00";
    
    }
    
    public String getRaceTime() {
        return this.rTime;
    }
    
    public String trig1(){
        if (trig1count > trig2count){
            RaceFault f = new RaceFault(rTime, dogs.get(currentDog));
            faults.add(f);
            System.out.println(f.toString());
        }
        String retStr = dogs.get(currentDog).getName()+" started a Run \n @ "+rTime+"\n";
        currentDog++;
        trig1count++;
        return retStr;
        
        
       
    
    }
    public void trig2(){
       trig2count++;
       if (currentDog == dogs.size())
       {
           stopRace();
       }
        
    }
}

    

