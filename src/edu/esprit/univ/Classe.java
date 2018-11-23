/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.univ;

/**
 *
 * @author Mehdi
 */
public class Classe {

    private String libelle;
    private int capacite;

    public Classe(String libelle, int capacite) {
        this.libelle = libelle;
        this.capacite = capacite;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
}
