package entites;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import web.services.xml.adaptateurs.DateAdaptateur;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Commande implements Serializable {
    
    @XmlAttribute
    @Id
    private Long id;
    
    private int     quantite;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @XmlJavaTypeAdapter(DateAdaptateur.class)
    private Date    dateEnvoi;
     
    @ManyToOne
    private Distributeur leDistributeur;
    
    @ManyToOne
    private Produit      leProduit;

    public boolean enCours(){ return dateEnvoi==null;}

    @Transient
    private Float montantCommande;
    
    public  Float montantCommande(){return this.quantite*leProduit.getPrixUnitaire();}
    
    //<editor-fold defaultstate="collapsed" desc="get set">
    
    public Float getMontantCommande() {
        return montantCommande;
    }

    public void setMontantCommande(Float montantCommande) {
        this.montantCommande = montantCommande;
    }
    
    
    
    public Distributeur getLeDistributeur() {
        return leDistributeur;
    }

    public void setLeDistributeur(Distributeur leDistributeur) {
        this.leDistributeur = leDistributeur;
    }
    
    
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Produit getLeProduit() {
        return leProduit;
    }

    public void setLeProduit(Produit leProduit) {
        this.leProduit = leProduit;
    }
    
    

   

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }


    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }
    
    
    
    
    //</editor-fold>
}
