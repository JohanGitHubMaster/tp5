/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpbanquejohan.jsf;

import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import mg.itu.tpbanquejohan.ejb.GestionnaireCompte;
import mg.itu.tpbanquejohan.entities.CompteBancaire;


/**
 *
 * @author admin
 */
@FacesConverter(value = "compteBancaireConverter", managed=true)
public class CompteBancaireConverter implements Converter<CompteBancaire>{
 @EJB
  private GestionnaireCompte gestionnaireCompte;

  /**
   * Convertit une String en Discount.
   *
     * @param context
     * @param component
   * @param value valeur à convertir
     * @return 
   */
  @Override
  public CompteBancaire getAsObject(FacesContext context, UIComponent component, String value) {
    if (value == null) return null;
    return gestionnaireCompte.findById(Integer.parseInt(value));
  }

  /**
   * Convertit un Discount en String.
   *
     * @param context
     * @param component
     * @param compteBancaire
     * @return 
   */
  @Override
  public String getAsString(FacesContext context, UIComponent component, CompteBancaire compteBancaire) {
    if (compteBancaire == null) return "";
    return compteBancaire.getId().toString();
  }
}

