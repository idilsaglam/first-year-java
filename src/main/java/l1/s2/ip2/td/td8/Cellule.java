package l1.s2.ip2.td.td8;

public class Cellule {
    Cellule precedent;
    Cellule suivant;
    Enfant enfant;

    public Cellule(Enfant enfant){
        this.enfant = enfant;
        this.precedent = null;
        this.suivant = null;
    }



}
