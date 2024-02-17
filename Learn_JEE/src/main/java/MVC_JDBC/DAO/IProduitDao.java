package MVC_JDBC.DAO;

import MVC_JDBC.metier.entities.Produit;

import java.util.List ;


public interface IProduitDao {
    public Produit save(Produit p);
    public List<Produit> produitParMC(String mc);
}
