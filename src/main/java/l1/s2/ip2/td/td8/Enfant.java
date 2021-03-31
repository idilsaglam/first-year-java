package l1.s2.ip2.td.td8;

public class Enfant {
    private final String nom;
    private int nbTobogganUtilise;

    Enfant(String nom){
        this.nom = nom;
        this.nbTobogganUtilise = 0;
    }

    //les accesseurs
    public String getNom(){
        return this.nom;
    }

    public int getNbTobogganUtilise(){
        return this.nbTobogganUtilise;
    }

    public void setNbTobogganUtilise(int nbTobogganUtilise){
        this.nbTobogganUtilise = nbTobogganUtilise;
    }
}
