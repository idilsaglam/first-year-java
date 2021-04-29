package l1.s2.ip2.td.td8;

public class Cellule {
    private Cellule suivant;
    private Cellule precedent;
    private Enfant enfant;

    public Cellule(Enfant e ){
        this.precedent = this;
        this.suivant = this;
        this.enfant = e;

    }

    public Cellule(Cellule suivant,Cellule precedent, Enfant e){
        this.precedent = precedent;
        this.suivant = suivant;
        this.enfant = e;
    }

    //getter et setters
    public void setPrecedent(Cellule precedent){
        this.precedent = precedent;
    }
    public void setSuivant(Cellule suivant){
        this.suivant = suivant;
        suivant.precedent = this;
    }
    public Cellule getPrecedent(){
        return this.precedent;
    }
    public Cellule getSuivant(){
        return this.suivant;
    }
    public Enfant getEnfant(){
        return this.enfant;
    }
    public void setEnfant(Enfant e){
        this.enfant = e;
    }

    //TODO:
    public void supprimer(String nom){
        if(this.suivant.enfant.getNom().equals(nom)){
            this.setSuivant(this.suivant.suivant);
            this.suivant.setPrecedent(this);
            return;
        }
        this.suivant.supprimer(nom);
    }



}
