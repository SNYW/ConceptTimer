package concepttimer.UI;

import concepttimer.ConceptTimer;
import concepttimer.Race;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;


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
    
    private boolean racing = false;
    Race r = new Race(); 
   
    @FXML
     private void startTimer() throws InterruptedException{
      
        if (!racing){  
           
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
            infoArea.appendText("Yellow Light");
            r.startRace();
            t.scheduleAtFixedRate(tt, 0, 10);
        } else {r.stopRace();}
        
    } 
     
     @FXML
     private void stopTimer(Race r){
     r.stopRace();
     }
  public void updateClock(String r){
  
   clockField.setText(r);
      
  }
}
