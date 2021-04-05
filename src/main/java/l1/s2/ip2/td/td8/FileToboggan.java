package l1.s2.ip2.td.td8;

public class FileToboggan {
    private Cellule courantCellule;
    private Enfant courant; //l'enfant qui est en train de glisser
    private int nbMax; // nombre max de fois quun enfant peut glisser

    public FileToboggan(int nbMax){
        this.nbMax = nbMax;
        this.courant = null;
    }

    //Accesseurs
    public void setCourant(Enfant e){
        this.courant = e;
    }

    /**
     * Question 1.3
     * une méthode qui ajoute un enfant de nom nom qui a glissé nb fois à la file
     * d’enfants en queue pour glisser. Attention à bien gérer le cas où la file est vide.
     * @param nom une chaîne de caractère signifiant le nom d'Enfant qye nous voulons ajouter.
     * @param nb un entier signifiant le nombre de glissage d'enfant.
     */
    public void ajouter(String nom, int nb){
        Enfant e = new Enfant(nom);
        if(this.courantCellule == null){
            this.setCourant(e);
            return;
        }
        this.courantCellule.setSuivante(new Cellule(e));
    }

    /**
     * Question 1.4
     * Une méthode qui supprime de la file l’enfant de nom nom. On suppose qu’il y a au plus un tel enfant.
     * @param nom une chaîne de caractère signifiant le nom de l'enfant.
     */
    public void supprimer(String nom){
        if(this.courantCellule == null){
            return;
        }
        this.courantCellule.supprimer(nom);
    }

    /*
     Question 1.5:
     Une méthode qui affiche courant et tous les enfants en queue pour glisser.
     */
    public void afficher(){
        if(this.courantCellule == null){
            return;
        }
        this.courantCellule.afficher();
    }

    /*public Enfant unTour(){


    }*/
}
