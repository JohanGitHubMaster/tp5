/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquejohan.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import mg.itu.tpbanquejohan.ejb.GestionnaireCompte;
import mg.itu.tpbanquejohan.entities.CompteBancaire;

/**
 *
 * @author ASUS
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompte {

    @EJB
   private GestionnaireCompte gestionnaireCompte;
   private CompteBancaire nouveauCompte;
   private int solde;
   private String nom;

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public CompteBancaire getNouveauCompte() {
        return nouveauCompte;
    }

    public void setNouveauCompte(CompteBancaire nouveauCompte) {
        this.nouveauCompte = nouveauCompte;
    }
    /**
     * Creates a new instance of AjoutCompte
     */
    public String ajoutNouveauCompte()
    {
        this.nouveauCompte = new CompteBancaire();
        this.nouveauCompte.setNom(this.nom);
        this.nouveauCompte.setSolde(this.solde);
        gestionnaireCompte.creerCompte(this.nouveauCompte);
        return "listeComptes";
    }
    public AjoutCompte() {
    }
    
}
