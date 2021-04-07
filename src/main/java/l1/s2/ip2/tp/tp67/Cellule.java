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
        System.out.println();
    }

    /**
     * Question 2.3
     * Une méthode qui met prochainEtat à true si la cellule sera noire à l’instant suivant (
     * et prochainEtat à false si elle sera blanche) en suivant la règle de l’unanimité.
     */
    public void prochaineEtape(Regle regle){
        boolean[] bTab = new boolean[3];
        if(this.precedente != null){
            bTab[0] = this.precedente.getNoire();
        }
        bTab[1] = this.getNoire();
        if(this.suivante != null){
            bTab[2] =  this.suivante.getNoire();
        }
        switch (regle) {
            case UNANIMITE:
                this.setProchainEtat(!(bTab[0] == bTab[1] && bTab[1] == bTab[2]));
                break;
            case MAJORITE:
                int sum = (bTab[0] ? 1 : 0) + (bTab[1] ? 1 : 0) + (bTab[2] ? 1 : 0);
                this.setProchainEtat(sum>=2);
                break;
            default:
                break;
        }
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
