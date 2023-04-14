/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquejohan.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import mg.itu.tpbanquejohan.ejb.GestionnaireCompte;
import mg.itu.tpbanquejohan.entities.CompteBancaire;

/**
 *
 * @author admin
 */
@Named(value = "supprimerCompte")
@RequestScoped
public class SupprimerCompte {

    /**
     * Creates a new instance of SupprimerCompte
     */
    public SupprimerCompte() {
    }
    @EJB
    private GestionnaireCompte gestionnaireCompte;
    
    private CompteBancaire compteBancaire;
    
    private long id;
    private int solde;

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
    private String nom;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CompteBancaire getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(CompteBancaire compteBancaire) {
        this.compteBancaire = compteBancaire;
    }
    
    public String supprimerLeCompte(){
        this.compteBancaire = this.gestionnaireCompte.findById(id);
        this.gestionnaireCompte.supprimerCompte(this.compteBancaire);
        return "listeComptes";
    }
    
    public void loadCompteBancaire() {
        this.compteBancaire = gestionnaireCompte.findById(id);    
    }
}
