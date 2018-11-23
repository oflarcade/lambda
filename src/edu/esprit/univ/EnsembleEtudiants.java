/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.univ;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author Mehdi
 */
public class EnsembleEtudiants implements IEtudiantService<Etudiant> {

    public Set<Etudiant> etudiants;

    public EnsembleEtudiants() {
        etudiants = new HashSet();
    }

    @Override
    public void ajouterEtudiant(Etudiant e) {
        etudiants.add(e);
    }

    @Override
    public void supprimerEtudiant(Etudiant e) {
        etudiants.remove(e);
    }

    @Override
    public boolean chercherEtudiant(Etudiant e) {
        return etudiants.contains(e);
    }

    @Override
    public boolean chercherEtudiant(int cin) {
        for (Etudiant e : etudiants) {
            if (e.getCin() == cin) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void afficher() {
        etudiants.forEach(System.out::println);
    }

    @Override
    public TreeSet<Etudiant> trierEtudiantsNom() {
        //  Set<Etudiant> etudiants = new TreeSet<>(Comparator.comparing(Etudiant::getNom));
      /*  TreeSet<Etudiant> etudiants = new TreeSet<>((e1,e2)->e1.getNom().compareTo(e2.getNom()));
         etudiants.addAll(this.etudiants);
         return etudiants;*/

        return etudiants.stream()
                .collect(Collectors
                        .toCollection(() -> new TreeSet<>((e1, e2) -> e1.getNom().compareTo(e2.getNom()))));
    }

    public double sommeDesMoyennes() {
        //return etudiants.stream().map(Etudiant::getMoyenne).reduce(0.0, (m1, m2) -> m1 + m2);
        return etudiants.stream().mapToDouble(Etudiant::getMoyenne).sum();
    }
}
