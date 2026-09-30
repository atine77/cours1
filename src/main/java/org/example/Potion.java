package org.example;

import javafx.beans.property.*;

public class Potion {
    private final StringProperty nom = new SimpleStringProperty();
    private final IntegerProperty prix = new SimpleIntegerProperty();

    public Potion(String nom, int prix) {
        this.nom.set(nom);
        this.prix.set(prix);
    }

    // Properties (pour la TableView)
    public StringProperty nomProperty() { return nom; }
    //En JavaFX, prixProperty() ne renvoie pas un objet générique Integer, mais un type héritant de Number
    public IntegerProperty prixProperty() { return prix; }

    // Getters

    //On utilise nom.get() parce que la méthode getNom() doit retourner une chaîne de caractères primitive (String),
    // alors que la variable nom est un objet enveloppeur (StringProperty).
    public String getNom() { return nom.get(); }
    public int getPrix() { return prix.get(); }


}

