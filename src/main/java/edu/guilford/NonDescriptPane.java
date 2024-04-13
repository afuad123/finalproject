package edu.guilford;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

public class NonDescriptPane {

    /**
     * A reference to the image that is controlled by this controller
     */
    @FXML
    private ImageView image;

    /**
     * A button that reveals the image
     */
    @FXML
    private Button button;

    /**
     * A method that reveals the image
     */
    @FXML
    public void revealImage() {
        image.setVisible(true);

    }

    /**
     * A method that makes the image disappear
     */
    public void makeImageDisappear() {
        image.setVisible(false);
    }
    
}
