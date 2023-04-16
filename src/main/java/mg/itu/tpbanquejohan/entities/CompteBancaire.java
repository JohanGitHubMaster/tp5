/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpbanquejohan.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "CompteBancaire.findAll", query = "SELECT c FROM CompteBancaire c"),})
public class CompteBancaire implements Serializable {
  
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")

    private Long id;

    @Column(name = "SOLDE")
    private int solde;

    @Column(name = "NOM")             
    private String nom;   
    
    @OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER)
    private List<OperationBancaire> operations = new ArrayList<OperationBancaire>();

    public List<OperationBancaire> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationBancaire> operations) {
        this.operations = operations;
    }
    public CompteBancaire(){

    }
    
    

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteBancaire)) {
            return false;
        }
        CompteBancaire other = (CompteBancaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mg.itu.tpbanquejohan.entities.CompteBancaire[ id=" + id + " ]";
    }
 

    /**
     * Get the value of solde
     *
     * @return the value of solde
     */
    public int getSolde() {
        return solde;
    }

    /**
     * Set the value of solde
     *
     * @param solde new value of solde
     */
    public void setSolde(int solde) {
        this.solde = solde;
    }

    
  public CompteBancaire(String nom, int solde) {  
  this.nom = nom;  
  this.solde = solde;  
  this.operations.add(new OperationBancaire("Création du compte",solde));
}  

    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


public void deposer(int montant) {  
  solde += montant;  
}  
                  
public void retirer(int montant) {  
  if (montant < solde) {  
    solde -= montant;  
  } else {
    solde = 0;
  }  
}
    
}
