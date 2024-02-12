package com.example.learn_jee;



interface CalculerArgents {
    double CalculerMensualite(double Argent, int Dure);
};
public class CreditMetier implements CalculerArgents {
    public CreditMetier(){

    }
    public double CalculerMensualite(double montant, int duree) {
        return montant / duree;
    }

}
