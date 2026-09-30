package org.example;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.BatchUpdateException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. La liste de données observables
        ObservableList<Potion> listePotions = FXCollections.observableArrayList(
                new Potion("Soin", 50),
                new Potion("Mana", 40),
                new Potion("Force", 100)
        );
        // 2. Création de la TableView
        TableView<Potion> table = new TableView<>();
        Button button = new Button("ajouter");

        // 3. Création des colonnes
        TableColumn<Potion, String> colNom = new TableColumn<>("Nom");
        // On lie la colonne à 'nomProperty()'
        colNom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        //Cette ligne sert à lier dynamiquement la largeur de la colonne (colPrix) à la largeur totale de la table (table),
        // de façon à ce qu'elle occupe toujours exactement 50 % (la moitié) de l'espace disponible.
        colNom.prefWidthProperty().bind(table.widthProperty().multiply(0.5));

        TableColumn<Potion, Number> colPrix = new TableColumn<>("Prix (Gold)");
        // On lie la colonne à 'prixProperty()'
        colPrix.setCellValueFactory(cellData -> cellData.getValue().prixProperty());
        //Associer la largeur des colonnes à celle du TableView :

        colPrix.prefWidthProperty().bind(table.widthProperty().multiply(0.5));

        // 4. Ajouter les colonnes au tableau et fournir les données
        table.getColumns().addAll(colNom, colPrix);
        table.setItems(listePotions);

        button.setOnAction(e -> System.out.println("Bouton cliqué !"));

        // Affichage
        VBox root = new VBox(10, table);
        root.setPadding(new Insets(15));

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setTitle("Exemple TableView");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}