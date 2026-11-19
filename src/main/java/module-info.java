module com.mycompany.assignment02_benjamin {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.mycompany.assignment02_benjamin to javafx.fxml;
    exports com.mycompany.assignment02_benjamin;
    requires javafx.mediaEmpty;
}
