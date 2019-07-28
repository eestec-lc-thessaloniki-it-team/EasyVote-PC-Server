module org.easyvote {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.sql;

    opens org.easyvote to javafx.fxml;
    exports org.easyvote;
}