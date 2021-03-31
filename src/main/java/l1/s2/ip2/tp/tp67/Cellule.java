package l1.s2.ip2.tp.tp67;

public class Cellule {
    private Cellule precedente;
    private Cellule suivante;
    private boolean noire;
    private boolean prochainEtat;

    /**
     * Question 1c
     * Un constructeur qui initialise l’attribut noire avec l’argument (et les deux autres attributs à null)
     * @param noire true si la Cellule est noir, sinon false
     */
    public Cellule(boolean noire) {
        this.noire = noire;
        this.precedente = null;
        this.suivante = null;
        this.prochainEtat = false;
    }

    /**
     * Question 1.b: Les accesseurs
     * Comme l'attribut 'precedente' est privé, nous ne pouvons pas y accéder depuis une autre class.
     * Pour y accéder en gardant sa visibilité privée (private), nous devons écrire les méthodes "getters"
     * @return La cellule précedente.
     */
    public Cellule getPrecedente(){
        return this.precedente;
    }

    /**
     * Comme l'attribut 'suivante' est privé, nous ne pouvons pas y accéder depuis une autre class.
     * Pour y accéder en gardant sa visibilité privée (private), nous devons écrire les méthodes "getters"
     * @return La cellule suivante.
     */
    public Cellule getSuivante(){
        return this.suivante;
    }
    public boolean getNoire(){
        return this.noire;
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

    /**
     * Question 2.3
     * Une méthode qui met prochainEtat à true si la cellule sera noire à l’instant suivant (
     * et prochainEtat à false si elle sera blanche) en suivant la règle de l’unanimité.
     */
    public void prochaineEtape(){
        boolean unanimite = false;
        if(this.precedente != null){
            unanimite = this.getPrecedente().getNoire();
        }
        unanimite = (unanimite==this.getNoire());
        if(!unanimite){
            this.prochainEtat = true;
            return;
        }
        unanimite = !this.getNoire();
        if(this.getSuivante() != null){
            unanimite = this.getNoire()==this.getSuivante().getNoire();
        }
        this.prochainEtat = !unanimite;
    }

    /**
     * Question 2.4:
     * Une méthode qui met à jour la valeur de noire en fonction de
     * celle stockée dans prochainEtat.
     */
    public void miseAJour(){
       this.setNoire(this.getProchainEtat());
    }


}
