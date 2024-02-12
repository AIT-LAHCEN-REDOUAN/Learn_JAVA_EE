package com.example.learn_jee;

public class CreditModel {

    private double montant;
    private int duree;

    private double Monsualite ;

    public double getMonsualite() {
        return this.Monsualite;
    }

    public void setMonsualite(double monsualite) {
        this.Monsualite = monsualite;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
