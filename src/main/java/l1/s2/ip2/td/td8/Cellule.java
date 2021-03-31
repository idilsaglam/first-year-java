package l1.s2.ip2.td.td8;

public class Cellule {
    private Cellule precedent;
    private Cellule suivante;
    private Enfant enfant;

    public Cellule(Enfant enfant){
        this.suivante = this;
        this.precedent = this;
    }

    //les accesseurs
    public Cellule getSuivante(){
        return this.suivante;
    }
    public Cellule getPrecedent(){
        return this.precedent;
    }
    public void setPrecedent(Cellule precedent){
        this.precedent = precedent;
    }
    public void setSuivante(Cellule suivante){
        this.suivante = suivante;
    }
    public Enfant getEnfant(){
        return this.enfant;
    }
}
