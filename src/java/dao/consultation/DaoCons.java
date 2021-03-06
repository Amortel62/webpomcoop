package dao.consultation;
import entites.Commande;
import entites.Distributeur;
import entites.Produit;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DaoCons {

   @PersistenceContext EntityManager em;
   
   public Distributeur getLeDistributeur(String idDist){
   
        return em.find(Distributeur.class, idDist);            
   }
   
   public Commande getLaCommande(Long numcom){
   
       return em.find(Commande.class, numcom);
   }
   
   public Produit getLeProduit(String codeprod){
   
       return em.find(Produit.class, codeprod);
   }
   
}


