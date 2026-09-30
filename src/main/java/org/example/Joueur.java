package org.example;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Joueur {

    // La Property qui contient le nom
    private StringProperty nom = new SimpleStringProperty();

    // Méthode pour accéder à la Property
    public StringProperty nomProperty() {
        return nom;
    }

    // Setter classique
    public void setNom(String nouveauNom) {
        this.nom.set(nouveauNom);
    }
}
