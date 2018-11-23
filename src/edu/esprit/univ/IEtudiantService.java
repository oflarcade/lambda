/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.univ;

import java.util.TreeSet;

/**
 *
 * @author Mehdi
 */
public interface IEtudiantService<T> {

    public void ajouterEtudiant(T t);

    public void supprimerEtudiant(T t);

    public boolean chercherEtudiant(Etudiant e);

    public boolean chercherEtudiant(int cin);

    public void afficher();

    public TreeSet<Etudiant> trierEtudiantsNom();
}
