/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpbanquejohan.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import java.util.List;
import mg.itu.tpbanquejohan.entities.CompteBancaire;
import mg.itu.tpbanquejohan.jsf.ListeComptes;

/**
 *
 * @author admin
 */
@Singleton
@Startup
public class InsertCompteBancaire {

    @EJB
    private GestionnaireCompte autreEJB;

    @PostConstruct
    public void init() {

        if (autreEJB.nbComptes() == 0) {

            CompteBancaire c1 = new CompteBancaire();
            c1.setNom("John Lennon");
            c1.setSolde(150000);

            CompteBancaire c2 = new CompteBancaire();
            c2.setNom("Paul McCartney");
            c2.setSolde(950000);

            CompteBancaire c3 = new CompteBancaire();
            c3.setNom("Ringo Starr");
            c3.setSolde(20000);

            CompteBancaire c4 = new CompteBancaire();
            c4.setNom("Georges Harrisson");
            c4.setSolde(100000);

            autreEJB.creerCompte(c1);
            autreEJB.creerCompte(c2);
            autreEJB.creerCompte(c3);
            autreEJB.creerCompte(c4);
        }

    }
}
