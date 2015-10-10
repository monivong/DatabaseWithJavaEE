package com.samnang.entites;

public class Personne {
        // attribut(s)
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private double taille;
    private boolean isAlive;    
        // methode(s)
    // constructeur(s)
    public Personne() {
        this(1, "tempNom", "tempPrenom", 1, 1, true);
    }
    public Personne(int id, String nom, String prenom, int age, double taille, boolean isAlive) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.taille = taille;
        this.isAlive = isAlive;
    }
    // accesseur(s)
    public int getId() {
        return this.id;        
    }            
    public String getNom() {
        return this.nom;        
    }
    public String getPrenom() {
        return this.prenom;
    }
    public int getAge() {
        return this.age;
    }
    public double getTaille() {
        return this.taille;
    }
    public boolean getIsAlive() {
        return this.isAlive;
    }
    // mutateur(s)
    public boolean setId(int id) {
        this.id = id;
        return true;
    }
    public boolean setNom(String nom) {
        this.nom = nom;
        return true;
    }
    public boolean setPrenom(String prenom) {
        this.prenom = prenom;
        return true;
    }
    public boolean setAge(int age) {
        this.age= age;
        return true;
    }
    public boolean setTaille(double taille) {
        this.taille = taille;
        return true;
    }
    public boolean setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
        return true;
    }
    // autre(s)
    public String toString() {
        return this.id + "::" + this.nom + "::" + this.prenom + "::" + this.age + "::" + this.taille + "::" + this.isAlive;
    }
}