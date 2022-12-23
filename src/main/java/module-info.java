module com.example.dictionaryvivek11dec {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dictionaryvivek11dec to javafx.fxml;
    exports com.example.dictionaryvivek11dec;
}