package MVC_JDBC.DAO;

import MVC_JDBC.metier.entities.Produit;

import java.util.List;

public class TestDao {
    public static void main(String[] Args){
        ProduitDaoImpl dao = new ProduitDaoImpl() ;
        Produit p1 = dao.save(new Produit("HP 6500",900,45));
        Produit p2 = dao.save(new Produit("Imprimande Epson 760",1000,15));
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println("Chercher Des Produits");
        List<Produit> prods = dao.produitParMC("%H%");
        for (Produit p :prods){
            System.out.println(p.toString());
        }
    }
}
