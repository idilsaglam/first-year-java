package l1.s2.ip2.tp.tp67;

public class Automate {
    private Cellule debut;
    private Cellule fin;

    public Automate(){
        this.debut = null;
        this.fin = null;
    }

    /**
     * Comme l'attribut 'debut' est privé, nous ne pouvons pas accéder sa valeur depuis une autre classe.
     * Pour y accéder en gardant sa visibilité(private), nous devons écrire une méthode getter.
     */
    public Cellule getDebut(){
        return this.debut;
    }

    /**
     * Comme l'attribut 'fin' est privé, nous ne pouvons pas accéder sa valeur depuis une autre classe.
     * Pour y accéder en gardant sa visibilité(private), nous devons écrire une méthode getter.
     */
    public Cellule getFin(){
        return this.fin;
    }

    public void initialisation(){
        Cellule c = new Cellule(true);
        Cellule c2 = new Cellule(true);
        Cellule c3 = new Cellule(true);

        Cellule c4 = new Cellule(false);
        Cellule c5 = new Cellule(false);
        Cellule c6 = new Cellule(false);

        Cellule c7 = new Cellule(true);

        Cellule c8 = new Cellule(false);
        Cellule c9 = new Cellule(false);
        Cellule c10 = new Cellule(false);
        Cellule c11 = new Cellule(false);

        this.debut = c;
        this.debut.setSuivante(c2);
        c2.setSuivante(c3);
        c3.setSuivante(c4);
        c4.setSuivante(c5);
        c5.setSuivante(c6);
        c6.setSuivante(c7);
        c7.setSuivante(c8);
        c8.setSuivante(c9);
        c9.setSuivante(c10);
        c10.setSuivante(c11);
        this.fin = c11;

    }
    /**
     * Question 1.2: Une méthode qui permet d'ajouter une Cellule à la fin de la liste.
     * @param c Cellule que nous voulons ajouter.
     */
    public void ajouteALaFin(Cellule c){
        if(this.debut == null){
            this.debut = c;
            this.fin = c;
            return;
        }
        this.fin.setSuivante(c);
        this.fin = c;
    }

    /**
     * Question 1.2: Une méthode qui permet d'ajouter une Cellule au debut da la liste.
     * @param c Cellule que nous voulons ajouter
     */
    public void ajouteAuDebut(Cellule c){
        if(this.debut == null){
            this.debut = c;
            this.fin = c;
            return;
        }
        c.setSuivante(this.debut);
        this.debut = c;
    }

    /**
     * Question 1.3: Une méthode d'affichage.
     */
    public void afficher(){
        if(this.debut == null){
            return;
        }
        this.debut.afficher();
    }



}
