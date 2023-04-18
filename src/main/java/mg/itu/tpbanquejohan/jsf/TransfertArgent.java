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
import mg.itu.tpbanquejohan.jsf.util.Util;

/**
 *
 * @author ASUS
 */
@Named(value = "transfertArgent")
@RequestScoped
public class TransfertArgent {

    private long id;
    private long idtransfert;

    public long getIdtransfert() {
        return idtransfert;
    }

    public void setIdtransfert(long idtransfert) {
        this.idtransfert = idtransfert;
    }
    private CompteBancaire compteBancaire;
    private CompteBancaire compteBancaireaTransferer;
    private int solde;

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }
    @EJB
    private GestionnaireCompte gestionnaireCompte;

    /**
     * Creates a new instance of TransfertArgent
     */
    public TransfertArgent() {
    }

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

    public void loadCompteBancaire() {
        this.compteBancaire = gestionnaireCompte.findById(id);    
    }

    public CompteBancaire getCompteBancaireaTransferer() {
        return compteBancaireaTransferer;
    }

    public void setCompteBancaireaTransferer(CompteBancaire compteBancaireaTransferer) {
        this.compteBancaireaTransferer = compteBancaireaTransferer;
    }
    
    public String transfertargent() {
        this.compteBancaireaTransferer = gestionnaireCompte.findById(this.idtransfert);
        this.compteBancaire = gestionnaireCompte.findById(id);
        gestionnaireCompte.transferer(this.compteBancaire,this.compteBancaireaTransferer,this.solde);
        Util.addFlashInfoMessage("Mouvement transferer sur compte de " + this.compteBancaire.getNom() +" au compte de "+this.compteBancaireaTransferer.getNom());
        return "listeComptes?faces-redirect=true";
    }
}
