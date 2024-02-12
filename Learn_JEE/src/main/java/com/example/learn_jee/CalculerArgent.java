package com.example.learn_jee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;



@WebServlet(name = "CalculerArgent", value = "/CalculerArgent")
public class CalculerArgent extends HttpServlet  {

    private CalculerArgents metier ;
    private CreditModel modelCredit;
    @Override
    public void  init() throws ServletException{
        metier =  new CreditMetier();
        modelCredit = new CreditModel();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        double Montant = Double.parseDouble(req.getParameter("Montant"));
        int Duree = Integer.parseInt(req.getParameter("Duree"));


        modelCredit.setDuree(Duree);
        modelCredit.setMontant(Montant);

        double res =  metier.CalculerMensualite(modelCredit.getMontant(),modelCredit.getDuree());

        modelCredit.setMonsualite(res);

        req.setAttribute("creditModel",new CreditModel());

        req.setAttribute("argent", modelCredit);

        // Forwarding to the correct JSP page
        req.getRequestDispatcher("CalculeArgent.jsp").forward(req, resp);
    }
}
