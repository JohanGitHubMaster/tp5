/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquejohan.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.annotation.View;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mg.itu.tpbanquejohan.ejb.GestionnaireCompte;
import mg.itu.tpbanquejohan.entities.CompteBancaire;

/**
 *
 * @author admin
 */
@Named(value = "listeCompte")
@View
public class ListeComptes implements Serializable {

    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
    }
    
    @EJB
    private GestionnaireCompte autre;
    
    public List<CompteBancaire> comptebancairelist;
    
    
    
    
    public List<CompteBancaire> getAllComptes(){  
      
            if(comptebancairelist == null)
            comptebancairelist = autre.getAllComptes();
           return comptebancairelist;          
        }
    
   
           
    
    public String supprimerLeCompte(CompteBancaire compteBancaire){
        this.autre.supprimerCompte(compteBancaire);
        return "listeComptes";
    }
    
}
