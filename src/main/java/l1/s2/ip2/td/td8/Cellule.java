package l1.s2.ip2.td.td8;

public class Cellule {
    private Cellule precedent;
    private Cellule suivant;
    private Enfant enfant;

    public void setPrecedent(Cellule c){
        this.precedent = c;
    }
    public void setSuivant(Cellule c){
        this.suivant = c;
        c.setPrecedent(this);
    }
    public Cellule getSuivant(){
        return this.suivant;
    }
    public Cellule getPrecedent(){
        return this.precedent;
    }
    public Enfant getEnfant(){return this.enfant;}
    public Cellule(Enfant enfant){
        this.enfant = enfant;
        this.precedent = this;
        this.suivant = this;
    }

    public void supprimer(String nom){
        Cellule act = this;
        while (act.suivant!= null){
            if(act.suivant.enfant.getNom().equals(nom)){
                act.suivant = act.suivant.suivant;
                act.suivant.precedent = act;
            }
            act=act.suivant;
        }

    }

    public void afficher(){
        Cellule act = this;
        while (act!= null){
            act.enfant.affiche();
            act= act.suivant;
        }
    }


}
