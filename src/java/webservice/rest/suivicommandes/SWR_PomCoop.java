package webservice.rest.suivicommandes;
import dao.consultation.DaoCons;
import dao.maj.DaoMaj;
import entites.Commande;
import entites.Distributeur;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("gpc")
public class SWR_PomCoop {
    
   @Inject DaoCons daoCons; 
   @Inject DaoMaj  daoMaj;
     
   @GET
   @Path("commandesencours/{idDist}")
   
   @Produces({"application/xml"})
   public List<Commande> commandesEncours( @PathParam("idDist")  String idDist) {
    
      Distributeur dist= daoCons.getLeDistributeur(idDist);
      
     
      for ( Commande cmd : dist.commandesEnCours()){
      
             
          
              // il faut donner une valeur au champ calculé montantcommande 
              cmd.setMontantCommande(cmd.montantCommande());
             
              // il ne faut pas repercuter les annulations des champs qui  suivent ci-dessous  dans la BDD
              daoMaj.detacherEntite(cmd);
              
              // on supprime les liens inverses qui provoqueraient des boucles lors de la sérialisation en xml
              cmd.setLeDistributeur(null);
              cmd.getLeProduit().setLesCommandes(null);
      }
      
      return dist.commandesEnCours();
   } 
   
   @GET
   @Path("commande/{numcom}")
   
   @Produces({"application/xml"})
   public Commande uneCommande(@PathParam ("numcom") Long numcom){
   
       Commande c = daoCons.getLaCommande(numcom);
   
       c.getLeDistributeur().setLesCommandes(null);
       c.getLeProduit().setLesCommandes(null);
       
       return c;
   
   
   }
   
}


