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
    public void setEnfant(Enfant e){this.enfant = e;}

    /**
     * Question 1.4
     * Une méthode qui supprime de la file l’enfant de nom nom. On suppose qu’il y a au plus un tel enfant.
     * @param nom une chaîne de caractère signifiant le nom de l'enfant.
     */
    public void supprimer(String nom) {
        Cellule act = this;
        while (act.suivante != null){
            if(act.suivante.getEnfant().getNom().equals(nom)){
                act.setSuivante(act.suivante.suivante);
            }
        }
        if(act.getEnfant().getNom().equals(nom)){
            act.setEnfant(null);
        }
    }


    /*
     * Question 1.5:
     * Une méthode qui affiche courant et tous les enfants en queue pour glisser.
     */
    public void afficher(){
        Cellule act = this;
        while (act!=null){
            System.out.println(act.getEnfant().getNom() + "\s" + act.getEnfant().getNbTobogganUtilise());
            act = act.suivante;
        }
    }


}
