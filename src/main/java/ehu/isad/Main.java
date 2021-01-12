package ehu.isad;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception{

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample.fxml"));
    Parent root = (Parent) loader.load();

    Controller controller = loader.getController();
    //controller.setMainApp(this);

    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }



  public static void main(String[] args) {
    launch(args);
  }
}
