package concepttimer.UI;

import concepttimer.Dog;
import concepttimer.Race;
import concepttimer.RaceFault;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    @FXML
    public TextField addDogField;
    @FXML
    public TextArea addDogArea;

    List<Dog> dogList = new ArrayList();
    Dog d1 = new Dog("Sonny", 1);
    Dog d2 = new Dog("Rohit", 1);
    Dog d3 = new Dog("Will", 1);

    private boolean racing = false;
    Race r = new Race(dogList);

    @FXML
    private void startTimer() throws InterruptedException {

        if (!racing) {
            dogList.clear();

            String[] dogArray = addDogArea.getText().split(",");
            for (int ii = 0; ii < dogArray.length; ii++) {
                Dog addDog = new Dog(null, 1);
                addDog.setName(dogArray[ii].trim().replaceAll("\n", ""));

                if (!dogArray[ii].trim().isEmpty()) {

                    dogList.add(addDog);

                }
            }

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
            r.setDogs(dogList);
            infoArea.clear();
            infoArea.appendText("Race has started\n");
            r.startRace();
            t.scheduleAtFixedRate(tt, 0, 10);
        } else {
        }

    }

    @FXML
    private void stopTimer() {

        reportArea.clear();
        if (r.racing) {
            reportArea.appendText("Total Time = " + r.getRaceTime() + " with [" + r.getDogs().size() + "] Dogs and [" + r.getFaults().size() + "] Faults \n");
            r.stopRace();
            racing = false;
        }

        infoArea.appendText("Race has Stopped \n");
        for (RaceFault r : r.getFaults()) {
            reportArea.appendText(r.toString() + "\n");
        }
    }

    @FXML
    private void trig1() {
        if (racing) {
            infoArea.appendText(r.trig1());
            if (r.getCurrentDog() >= r.getDogs().size()) {
                stopTimer();
            }
        }
    }

    @FXML
    private void trig2() {
        if (racing) {
            if (r.getCurrentDog() >= r.getDogs().size()) {
                stopTimer();
            } else {
                r.trig2();
            }
        }
    }

    @FXML
    private void addDogButton() {
        System.out.println(addDogField.getText());
        if (!addDogField.getText().trim().isEmpty()) {
            addDogArea.appendText(addDogField.getText() + ", \n");
            addDogField.clear();
            addDogField.setPromptText("Add New Dog Name");

        }
    }

    @FXML
    private void addDogClear() {
        addDogArea.clear();
    }

    public void updateClock(String r) {

        clockField.setText(r);

    }
}
