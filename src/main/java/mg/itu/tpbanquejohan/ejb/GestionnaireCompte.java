/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpbanquejohan.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import mg.itu.tpbanquejohan.entities.CompteBancaire;

/**
 *
 * @author ASUS
 */
@DataSourceDefinition (
    className="com.mysql.cj.jdbc.MysqlDataSource",
    name="java:app/jdbc/banque",
    serverName="localhost",
    portNumber=3306,
    user="root",              // nom et
    password="root", // mot de passe que vous avez donnés lors de la création de la base de données
    databaseName="banque",
    properties = {
      "useSSL=false",
      "allowPublicKeyRetrieval=true"
    }
)
@Stateless
@Singleton
@Startup
public class GestionnaireCompte {
    
    @PersistenceContext(unitName="banquePU")
    private EntityManager em;
  
    //@EJB
    //private GestionnaireCompte autreEJB;
    
    @PostConstruct
    public void init(){
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
        
        this.creerCompte(c1);
        this.creerCompte(c2);
        this.creerCompte(c3);
        this.creerCompte(c4);
       
    }
    
    
    
    public void creerCompte(CompteBancaire c) {
        em.persist(c);
    }
    
    public List<CompteBancaire> getAllComptes() {   
        Query query = em.createNamedQuery("CompteBancaire.findAll");
        //TypedQuery<CompteBancaire> quer = (TypedQuery<CompteBancaire>) em.createNamedQuery("CompteBanquaire.findAll");
      return query.getResultList();
    }
    
   
    
}
