module org.easyvote {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.sql;
    requires tyrus.server;
    requires jakarta.websocket.api;

    opens org.easyvote to javafx.fxml;
    exports org.easyvote;
}