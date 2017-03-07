package concepttimer.UI;

import concepttimer.Dog;
import concepttimer.Race;
import concepttimer.RaceFault;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;


public class FXMLController extends Thread {
    @FXML
    private Circle yb1;
    @FXML
    private Circle yb2;
    @FXML
    private Circle yb3;
    @FXML
    private Circle gb1;
    @FXML
    private Circle faultb;
    @FXML
    private TextArea infoArea;
    @FXML
    public Text clockField;
    @FXML
    public TextArea reportArea;
    
    List<Dog> d = new ArrayList();
    Dog d1 = new Dog("Sonny", 1);
    Dog d2 = new Dog("Rohit", 1);
    Dog d3 = new Dog("Will", 1);
    
    private boolean racing = false;
    Race r = new Race(d); 
   
    @FXML
     private void startTimer() throws InterruptedException{
      
        if (!racing){  
            d.add(d1);
            d.add(d2);
            d.add(d3);
            racing = true;
            Timer t = new Timer();
            TimerTask tt = new TimerTask() {
        @Override
        public void run() {
               Platform.runLater(() -> {
                   updateClock(r.getRaceTime());
               });
        }
        };
            System.out.println("Race Started");
            infoArea.clear();
            infoArea.appendText("Race has started\n");
            r.startRace();
            t.scheduleAtFixedRate(tt, 0, 10);
        } else {}
        
    } 
     
     @FXML
     private void stopTimer(){
     if (r.racing) {r.stopRace();
     racing = false; }
     
     infoArea.appendText("Race has Stopped \n");
     for(RaceFault r : r.faults){
         reportArea.appendText(r.toString()+"\n");
     }
     }
     
     @FXML
     private void trig1(){
        infoArea.appendText(r.trig1());
     }  
     
     @FXML
     private void trig2(){
         r.trig2();
     }
    public void updateClock(String r){
  
        clockField.setText(r);
      
  }
}
