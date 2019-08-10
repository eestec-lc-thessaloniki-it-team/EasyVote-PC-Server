package org.easyvote;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.easyvote.logic.Session;

import java.io.IOException;

public class WizardScreen1Controller {

    private ObservableList<Session> sessions = FXCollections.observableArrayList();

    @FXML
    private TableView<Session> sessionTable;

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
    private void addSession() {
        System.out.println(titleInput.getText());
        System.out.println(typeInput.getText());

        Session newSession = new Session(titleInput.getText(), typeInput.getText());
        sessions.add(newSession);

        sessionTable.setItems(sessions);
    }

    @FXML
    private void switchToPreviousScreen() throws IOException {
        App.setRoot("welcome_screen");
    }


}
