package concepttimer;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class ConceptTimer extends Application {
       private Stage primaryStage;
       private Pane mainLayout;
       
        @Override
        public void start (Stage primaryStage) throws IOException{
           this.primaryStage = primaryStage;
           this.primaryStage.setTitle("Concept Timer");
           this.primaryStage.setOnCloseRequest(e -> Platform.exit());
           primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
});
           showUI();
        }
        private void showUI() throws IOException
        {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ConceptTimer.class.getResource("UI/FXML.fxml"));
        mainLayout = loader.load();
        Scene timerInterface = new Scene(mainLayout);
        primaryStage.setScene(timerInterface);
        primaryStage.show();
                      
        }
        
               
        public static void main (String[] args){
            launch(args);
        }
    }
    

