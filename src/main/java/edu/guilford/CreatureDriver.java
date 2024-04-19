package edu.guilford;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is the main driver for the Creature Simulation program. It creates
 * the main window, the control window, and instruction window
 * @author A.Fuad
 * @version 4/18/24
 */
public class CreatureDriver extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        //main window
        SimulationModel model = new SimulationModel();
        SimulationPane root = new SimulationPane();
        scene = new Scene(root, 800, 600);
        stage.setTitle("Creature Simulation");
        stage.setX(775);
        stage.setY(100);
        stage.setScene(scene);
        stage.show();

       
        //window for controls
        Stage controlStage = new Stage();
        //build an FXMLLoader object that will load the FXML file and interact with the controller class
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("control.fxml"));
        Parent controlRoot1 = loader1.load();
        ControlController controlController = loader1.getController();
        // pass the simulationpane object to the controlcontroller object
        controlController.setSimulationPane(root);
        controlController.setModel(model);
        Scene controlScene = new Scene(controlRoot1, 600, 600);
        controlStage.setTitle("Controls");
        //set x and y position of the control window
        controlStage.setX(150);
        controlStage.setY(100);
        controlStage.setScene(controlScene);
        controlStage.show();

        //repeat but for the instruction pane
        Stage instructionStage = new Stage();
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("instrux.fxml"));
        Parent controlRoot2 = loader2.load();
        // InstructionPane instructionPane = loader2.getController();
        Scene instructionScene = new Scene(controlRoot2, 600, 250);
        instructionStage.setX(475);
        instructionStage.setY(1200);
        instructionStage.setTitle("Instructions");
        instructionStage.setScene(instructionScene);
        instructionStage.show();

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