/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.univ;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 *
 * @author Mehdi
 */
public class University {

    private String nom;
    private Map<Classe, EnsembleEtudiants> map;

    public University() {
        map = new HashMap<>();
    }

    public void ajouterClasse(Classe c) {
        map.put(c, new EnsembleEtudiants());

    }

    public void ajouterEtudiant(Classe c, Etudiant e) {
        if (!map.containsKey(c)) {
            ajouterClasse(c);
        }
        map.get(c).ajouterEtudiant(e);
    }

    public void deplacerEtudiant(Etudiant e, Classe classeDestination) {
        for (Map.Entry<Classe, EnsembleEtudiants> entry : map.entrySet()) {
            if (entry.getValue().chercherEtudiant(e)) {
                entry.getValue().supprimerEtudiant(e);
                ajouterEtudiant(classeDestination, e);
                return;
            }
        }
        System.out.println("Etudiant n'existe pas!!!");

        /*  map.forEach((k, v) -> {
         if (v.chercherEtudiant(e)) {
         v.supprimerEtudiant(e);
         ajouterEtudiant(classeDestination, e);
         return;
         }
         });*/
    }

    public void permuterEtudiant(Etudiant e1, Etudiant e2) {
        Classe c1 = null, c2 = null;
        for (Map.Entry<Classe, EnsembleEtudiants> entry : map.entrySet()) {
            if (entry.getValue().chercherEtudiant(e1)) {
                c1 = entry.getKey();
            }
            if (entry.getValue().chercherEtudiant(e2)) {
                c2 = entry.getKey();
            }
            if (c1 != null && c2 != null) {
                break;
            }
        }

        if (c1 != null && c2 != null) {
            deplacerEtudiant(e1, c2);
            deplacerEtudiant(e2, c1);
        } else {
            System.out.println("l'un des etudiant n'existe pas");
        }
    }

    public void afficherUniversity() {
        map.forEach((k, v) -> {
            System.out.println(k);
            v.afficher();
        });
    }

    public void afficherNomEtudiantsAge(Classe c) {
        map.get(c).etudiants.stream().filter(e -> e.getAge() > 20 && e.getAge() < 23)
                .forEach(e -> System.out.println(e.getNom()));
    }

    public List<Etudiant> meilleursEtudiants() {
        return map.values().stream().map(ee -> ee.etudiants)
                .reduce((s1, s2) -> {
                    s1.addAll(s2);
                    return s1;
                }).get().stream()
                .sorted(Comparator.comparing(Etudiant::getMoyenne))
                .limit(10)
                .collect(Collectors.toList());
    }

}
