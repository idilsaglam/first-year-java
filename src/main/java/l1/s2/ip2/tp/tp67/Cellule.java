package l1.s2.ip2.tp.tp67;

public class Cellule {
    private Cellule precedente;
    private Cellule suivante;
    private boolean noire;
    private boolean prochainEtat;


    /**
     * Question 1.b: Les accesseurs
     * Comme l'attribut 'precedente' est privé, nous ne pouvons pas y accéder depuis une autre class.
     * Pour y accéder en gardant sa visibilité (private), nous devons écrire les méthodes "getters"
     * @return La cellule precedent.
     */
    public Cellule getPrecedente(){
        return this.precedente;
    }

    /**
     * Comme l'attribut 'suivante' est privé, nous ne pouvons pas y accéder depuis une autre class.
     * Pour y accéder en gardant sa visibilité (private), nous devons écrire les méthodes "getters"
     * @return La cellule suivante.
     */
    public Cellule getSuivante(){
        return this.suivante;
    }

    /**
     * Comme l'attribut 'precedente' est privé, nous ne pouvons pas y accéder depuis une autre class.
     * Pour changer sa valeur en gardant sa visibilité (private), nous devons écrire les méthodes "setters"
     * @param cellule Cellule que nous voulons faire precedent.
     */
    public void setPrecedente(Cellule  cellule){
        this.precedente = cellule;
    }

    /**
     * Comme l'attribut 'suivante' est privé, nous ne pouvons pas y accéder depuis une autre class.
     * Pour changer sa valeur en gardant sa visibilité (private), nous devons écrire les méthodes "setters"
     * @param cellule Cellule que nous voulons faire la suivante Cellule.
     */
    public void setSuivante(Cellule cellule){
        this.suivante = cellule;
        cellule.precedente=this;
    }

    public void setNoire(boolean noire){
        this.noire = noire;
    }
    public boolean getNoire(){
        return this.noire;
    }

    /**
     * Question 2.2
     *  Comme l'attribut 'prochainEtat' est privé, nous ne pouvons pas y accéder depuis une autre class.
     *  Pour changer sa valeur en gardant sa visibilité (private), nous devons écrire la méthode "setter"
     * @param etat true si nous voulons changer l'état avec noir, false sinon.
     */
    public void setProchainEtat(boolean etat){
        this.prochainEtat = etat;
    }

    /**
     * Question 2.2
     * Comme l'attribut 'prochainEtat' est privé, nous ne pouvons pas y accéder depuis une autre class.
     * Pour y accéder en gardant sa visibilité (private), nous devons écrire la méthode "getter"
     * @return true si la valeyr de l'attribut 'prochainEtat' est true, sinon false
     */
    public boolean getProchainEtat(){
        return this.prochainEtat;
    }

    /**
     * Question 1c
     * Un constructeur qui initialise l’attribut noire avec l’argument (et les deux autres attributs à null)
     * @param noire true si la Cellule est noir, sinon false
     */
    public Cellule(boolean noire){
        this.noire = noire;
        this.precedente = null;
        this.suivante = null;
        this.prochainEtat = false;
    }

    /**
     * Question 1d
     * Une méthode qui imprime (sans retour à la ligne) un dièse # ou un tiret - selon que noire est vraie ou fausse.
     */
    public void afficher(){
        Cellule act = this;
        while (act!=null){
            if(act.noire){
                //Pour chaque cellule noir, nous allons afficher #
                System.out.print("#");
                act = act.suivante;
                continue;
            }
            //Pour chaque cellule blanche nous allons afficher un tiret.
            System.out.print('-');
            act = act.suivante;
        }
    }

    public void prochaineEtape(){
        Cellule act = this;
        if(act != null){
            if(act.suivante != null && act.suivante.suivante != null) {
                if (act.getNoire() && act.suivante.getNoire() && act.suivante.suivante.getNoire()) {
                    act.suivante.setProchainEtat(false);
                } else {
                    act.suivante.setProchainEtat(true);
                }
                act = act.suivante;
            }
            if(act.suivante != null && act.suivante.suivante == null){

            }
        }
    }


}
