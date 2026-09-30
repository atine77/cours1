package org.example;

// On indique qu'un Etudiant est comparable avec un autre Etudiant
public class Etudiant implements Comparable<Etudiant> {
    String nom;
    int note;

    public Etudiant(String nom, int note) {
        this.nom = nom;
        this.note = note;
    }

    // Redéfinition de la méthode compareTo
    @Override
    public int compareTo(Etudiant autre) {
        // On compare les notes :
        // - Négatif si ma note est plus petite (je passe avant)
        // - Positif si ma note est plus grande (je passe après)
        // - Zéro si les notes sont égales
        return this.note - autre.note;
    }
}