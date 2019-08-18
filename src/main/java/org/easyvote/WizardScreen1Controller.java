package org.easyvote;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.easyvote.logic.Session;

import java.io.IOException;

public class WizardScreen1Controller {

    private ObservableList<Session> sessions = FXCollections.observableArrayList();

    @FXML
    private TableView<Session> sessionTable;

    @FXML
    private TableColumn<Session, String> titleColumn;

    @FXML
    private TableColumn<Session, String> typeColumn;

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

    public WizardScreen1Controller() {

    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

        // Initialize the session table with the two columns.
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
    }

    @FXML
    private void addSession() {
        System.out.println(titleInput.getText());
        System.out.println(typeInput.getText());

        String title = titleInput.getText();
        String type = typeInput.getText();

        // check if title or type is empty
        if (title.equals("") || type.equals("")) {
            // notify user?
        } else {
            Session newSession = new Session(title, type);
            sessions.add(newSession);

            sessionTable.setItems(sessions);

            // empty the title and type input fields
            titleInput.clear();
            typeInput.clear();
        }
    }

    @FXML
    private void removeSession() {
        Session selectedSession = sessionTable.getSelectionModel().getSelectedItem();
        sessionTable.getItems().remove(selectedSession);
    }

    @FXML
    private void switchToPreviousScreen() throws IOException {
        App.setRoot("welcome_screen");
    }


}
