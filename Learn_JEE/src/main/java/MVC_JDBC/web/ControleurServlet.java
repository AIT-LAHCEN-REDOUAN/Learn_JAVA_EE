package MVC_JDBC.web;


import MVC_JDBC.DAO.IProduitDao;
import MVC_JDBC.DAO.ProduitDaoImpl;
import MVC_JDBC.metier.entities.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "cs",urlPatterns ={"*.do"})
public class ControleurServlet extends HttpServlet {
   private IProduitDao metier ;
   @Override
    public void init() throws ServletException {
       metier = new ProduitDaoImpl();
   }
   @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
      String path = req.getServletPath();
      if (path.equals("/index.do")){
         req.getRequestDispatcher("produits.jsp").forward(req,resp);
      }else if (path.equals("/Chercher.do")){
          String motCle = req.getParameter("motCle");
          ProduitModel model= new ProduitModel();
          model.setMotCle(motCle);
          List<Produit> produits = metier.produitParMC("%"+motCle+"%");
          model.setProduits(produits);
          req.setAttribute("model",model);
          req.getRequestDispatcher("produits.jsp").forward(req,resp);

      }else {
          resp.sendError(resp.SC_NOT_FOUND);
      }
   }

   @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{
           doGet(req,resp);
   }
}
