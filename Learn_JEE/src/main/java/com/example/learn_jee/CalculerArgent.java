package com.example.learn_jee;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

interface CalculerArgents {
    double CalculerMensualite(double Argent, int Dure);
}

@WebServlet(name = "CalculerArgents", value = "/CalculerArgent")
public class CalculerArgent extends HttpServlet implements CalculerArgents {
    public double montant;
    public int duree;

    public CalculerArgent(double montant, int duree) {
        this.duree = duree;
        this.montant = montant;
    }

    public double CalculerMensualite(double montant, int duree) {
        return montant / duree;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        double Montant = Double.parseDouble(req.getParameter("Montant"));
        int Duree = Integer.parseInt(req.getParameter("Duree"));

        CalculerArgent NewM = new CalculerArgent(Montant, Duree);
        req.setAttribute("argent", NewM.toString());

        // Forwarding to the correct JSP page
        req.getRequestDispatcher("CalculeArgent.jsp").forward(req, resp);
    }
    // Implementing doPost method for handling POST requests
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Call doGet method for POST requests
        doGet(req, resp);
    }
    @Override
    public String toString() {
        return "le Montant Est : " + CalculerMensualite(this.montant, this.duree);
    }
}