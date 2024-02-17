package MVC_JDBC.DAO;

import MVC_JDBC.metier.entities.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImpl implements IProduitDao {
    @Override
    public Produit save(Produit p) {
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO produits (DESIGNATION,PRIX,QUANTITE) VALUES (?,?,?)");
            ps.setString(1, p.getDesignation());
            ps.setDouble(2, p.getPrix());
            ps.setInt(3, p.getQuantite());
            ps.executeUpdate();
            ps.close(); // Close the first PreparedStatement

            PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM produits");
            ResultSet rs = ps2.executeQuery();
            if (rs.next()) {
                p.setId(rs.getLong("MAX_ID"));
            }
            ps2.close(); // Close the second PreparedStatement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Produit> produitParMC(String mc) {
        List<Produit> produits = new ArrayList<>();
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM produits WHERE DESIGNATION LIKE ?");
            ps.setString(1, mc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getLong("ID"));
                p.setDesignation(rs.getString("DESIGNATION"));
                p.setPrix(rs.getDouble("PRIX"));
                p.setQuantite(rs.getInt("QUANTITE"));
                produits.add(p);
            }
            ps.close(); // Close the PreparedStatement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

}
