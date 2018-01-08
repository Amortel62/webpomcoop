package entites;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

//<editor-fold defaultstate="collapsed" desc="Annotations annotations pour XML et la persistance à indiquer">
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
//</editor-fold>

public class Produit implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="Definir tous les champs avec les annotations nécessaires">
    @XmlAttribute(name="id")
    @Id
    private String   codeprod;
    
    private String   variete;
    private String   designation;
    private String   conditionnement;
    private Float    prixUnitaire;
    
    @OneToMany(mappedBy = "leProduit")
    private List<Commande> lesCommandes= new LinkedList();
    
    @Transient
    private Float   chiffreDAffairesProduit;
    //</editor-fold>
    
    public  Float   chiffreDAffairesProduit(){
        
        Float caProd =0f;
      
        for(Produit p : )
        
        
        return caProd;
      
    }
    
    //<editor-fold defaultstate="collapsed" desc="gets sets">
    
    public Float getChiffreDAffairesProduit() {
        return chiffreDAffairesProduit;
    }

    public void setChiffreDAffairesProduit(Float chiffreDAffairesProduit) {
        this.chiffreDAffairesProduit = chiffreDAffairesProduit;
    }
    
    public String getCodeprod() {
        return codeprod;
    }

    public void setCodeprod(String codeprod) {
        this.codeprod = codeprod;
    }
    
    public Float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    
    public String getConditionnement() {
        return conditionnement;
    }

    public void setConditionnement(String conditionnement) {
        this.conditionnement = conditionnement;
    }
    
    public String getVariete() {
        return variete;
    }
    
    public void setVariete(String variete) {
        this.variete = variete;
    }
    
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public List<Commande> getLesCommandes() {
        return lesCommandes;
    }

    public void setLesCommandes(List<Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
    }
    
    //</editor-fold>  
}


