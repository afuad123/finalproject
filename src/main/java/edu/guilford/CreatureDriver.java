package edu.guilford;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class CreatureDriver extends Application {

    private static Scene scene;
    private int sceneWidth = 600;
    private int sceneHeight = 600;

    @Override
    public void start(Stage stage) throws IOException {
        SimulationPane root = new SimulationPane();
        scene = new Scene(root, sceneWidth, sceneHeight);
        stage.setTitle("Creature Simulation");
        stage.setX(875);
        stage.setY(150);
        stage.setScene(scene);
        stage.show();

       
        //window for controls
        Stage controlStage = new Stage();
        //build an FXMLLoader object that will load the FXML file and interact with the controller class
        FXMLLoader loader = new FXMLLoader(getClass().getResource("control.fxml"));
        Parent controlRoot = loader.load();
        ControlController controlController = loader.getController();
        // pass the shapepane object to the controlcontroller object
        controlController.setSimulationPane(root);
        
        Scene controlScene = new Scene(controlRoot, 600, 600);
        controlStage.setTitle("Controls");
        //set x and y position of the control window
        controlStage.setX(225);
        controlStage.setY(150);
        controlStage.setScene(controlScene);
        controlStage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CreatureDriver.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}