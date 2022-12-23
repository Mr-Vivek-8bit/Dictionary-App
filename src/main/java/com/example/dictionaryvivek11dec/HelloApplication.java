package com.example.dictionaryvivek11dec;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



import java.io.IOException;

public class HelloApplication extends Application {
    Label meaningLabel;
    Button searchButton;
    TextField wordTextField;

    DictionaryUsingHashMap dictionaryUsingHashMap = new DictionaryUsingHashMap();
    Pane createContent(){
        Pane root = new Pane();

         root.setPrefSize(400,600);

         wordTextField = new TextField();
         wordTextField.setTranslateX(20);
        wordTextField.setTranslateY(30);

        searchButton = new Button("Search");
        searchButton.setTranslateX(200);
        searchButton.setTranslateY(30);
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//             meaningLabel.setText("Button is clicked.");
             String word = wordTextField.getText();
             if(word.isBlank() || word.isEmpty()){
                 meaningLabel.setText("Please enter a word ! ");
                 meaningLabel.setTextFill(Color.RED);
             }
             else {
                 String meaning = dictionaryUsingHashMap.getMeaning(word);
                 meaningLabel.setText(meaning);
                 meaningLabel.setTextFill(Color.BLACK);
             }
            }
        });

        meaningLabel = new Label();
        meaningLabel.setTranslateX(80);
        meaningLabel.setTranslateY(100);


        root.getChildren().addAll(wordTextField,searchButton,meaningLabel);
        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
      //  FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Dictionary!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}