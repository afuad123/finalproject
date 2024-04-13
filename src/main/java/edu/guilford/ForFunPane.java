package edu.guilford;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

public class ForFunPane {

    @FXML
    private ImageView image;

    @FXML
    private Button button;

    @FXML
    //make a method that allows the user to click a button and reveal an image
    public void revealImage() {
        image.setVisible(true);

    }

    public void makeImageDisappear() {
        image.setVisible(false);
    }
    
}
