package org.easyvote;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class WizardScreen1Controller {

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private TextField titleInput;

    @FXML
    private TextField typeInput;

    @FXML
    private Button nextButton;

    @FXML
    private Button previousButton;

    @FXML
    private void addTopic() {
        System.out.println(titleInput.getText());
        System.out.println(typeInput.getText());
    }

    @FXML
    private void switchToPreviousScreen() throws IOException {
        App.setRoot("welcome_screen");
    }
}
