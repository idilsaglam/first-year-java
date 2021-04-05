package l1.s2.ip2.tp.tp67;

public class Automate {
    private Cellule debut;
    private Cellule fin;

    public Automate(){
        this.debut = null;
        this.fin = null;
    }

    /**
     * Question 2.8
     * Un constructeur qui prend une chaîne de caractères constituée
     * de ’#’ et de ’-’, et crée l’automate correspondant.
     * @param str une chaîne de caractère contient des '#' et tirets.
     */
    public Automate(String str){
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '#'){
                this.ajouteALaFin(new Cellule(true));
                continue;
            }
            this.ajouteALaFin(new Cellule(false));
        }
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
        if(c.getSuivante() == null) {
            c.setSuivante(this.debut);
        }
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

    /**
     * Question 2.5:
     * Une méthode qui  qui parcourt la liste deux fois, la première fois en calculant le prochain état,
     * puis en faisant la mise à jour.
     */
    public void uneEtape(){
        if(this.debut == null){
            return;
        }
        Cellule act = this.debut;
        while (act != null) {
            act.prochaineEtape();
            act = act.getSuivante();
        }
        act = this.debut;
        while (act != null) {
            act.miseAJour();
            act = act.getSuivante();
        }
    }

    /**
     * Question 2.6:
     * qui affiche d’abord l’état courant, puis effectue n étapes
     * successives, en affichant les étapes intermédiaires.
     * @param n
     */
    public void nEtapes(int n){
        if(this.debut == null){
            return;
        }
        this.debut.afficher();
        for(int i=0; i<n; i++){
            uneEtape();
            debut.afficher();

        }
    }

}
