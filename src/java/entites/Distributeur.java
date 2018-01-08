package entites;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"nomDist","adrDist","lesCommandes"})
@Entity
public class Distributeur implements Serializable {
    
    @XmlAttribute(name="id")
    @Id
    private String id;

    @XmlElement(name="nom")
    private String nomDist;
    @XmlElement(name="adresse")
    private String adrDist;
    
    @OneToMany(mappedBy = "leDistributeur")
    public List<Commande> lesCommandes=new LinkedList<Commande>();
    
    public List<Commande> commandesEnCours(){
    
       List listeCom= new LinkedList<Commande>();
       
       for (Commande cmd : lesCommandes){
       
         if ( cmd.enCours()) { listeCom.add(cmd);}
       }
       return listeCom;
    }  
    
    //<editor-fold defaultstate="collapsed" desc="get set">
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public List<Commande> getLesCommandes() {
        return lesCommandes;
    }

    public void setLesCommandes(List<Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
    }
     public String getNomDist() {
        return nomDist;
    }

    public void setNomDist(String nomDist) {
        this.nomDist = nomDist;
    }

    public String getAdrDist() {
        return adrDist;
    }

    public void setAdrDist(String adrDist) {
        this.adrDist = adrDist;
    }
    
    
    
    //</editor-fold>   
}


