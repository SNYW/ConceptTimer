/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concepttimer;
import concepttimer.UI.FXMLController;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Race {
    public boolean racing = false;
    private String rTime = "00:00";
    private Long startTime;
    private int ms;
    private int currentDog;
   Timer rTimer = new Timer(); 
  
    
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
    

    
}
