package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExempleListView extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. La liste de données réactive (ObservableList)
        ObservableList<String> fruits = FXCollections.observableArrayList("Pomme", "Banane", "Orange");
        // 2. La ListView (composant visuel) liée à nos données
        ListView<String> listView = new ListView<>(fruits);
        listView.setOrientation(Orientation.HORIZONTAL);
        // 3. Un champ texte et un bouton pour ajouter des éléments
        TextField input = new TextField();
        Button btnAjouter = new Button("Ajouter");
        // Action du bouton : ajouter le texte saisi à la liste
        btnAjouter.setOnAction(e -> {
            if (!input.getText().isEmpty()) {
                fruits.add(input.getText()); // On modifie SEULEMENT la liste de données
                input.clear();
            }
        });
        // Mise en page
        VBox root = new VBox(10, input, btnAjouter, listView);
        root.setPadding(new Insets(15));

        primaryStage.setScene(new Scene(root, 250, 300));
        primaryStage.setTitle("Exemple ListView");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}