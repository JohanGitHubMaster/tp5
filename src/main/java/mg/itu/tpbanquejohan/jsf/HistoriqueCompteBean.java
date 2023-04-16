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
@Named(value = "historiqueCompteBean")
@RequestScoped
public class HistoriqueCompteBean {
    @EJB
    private GestionnaireCompte gestionnaireCompte;
    
    private long id;
    private CompteBancaire compte;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }
    /**
     * Creates a new instance of HistoriqueCompteBean
     */
    public HistoriqueCompteBean() {
        
    }
    
    public void loadCompte() {
    compte = gestionnaireCompte.findById(id);
  }
    
}
