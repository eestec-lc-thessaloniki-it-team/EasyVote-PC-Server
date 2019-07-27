module org.eestec {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.easyvote to javafx.fxml;
    exports org.easyvote;
}