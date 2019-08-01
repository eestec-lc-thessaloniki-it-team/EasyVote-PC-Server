package org.easyvote;

import java.io.IOException;
import javafx.fxml.FXML;

public class WelcomeScreenController {

    @FXML
    private void switchToWizardScreen() throws IOException {
        App.setRoot("wizard_screen_1");
    }
}
