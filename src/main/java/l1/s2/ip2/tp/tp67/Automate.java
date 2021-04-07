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
                this.ajouteALaFin(true);
                continue;
            }
            this.ajouteALaFin(false);
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

    /**
     * Exercice 2.1
     * Une méthode qui fixe l’état de l’automate comme représenté à la figure précédente à t = 0
     */
    public void initialisation(){
        this.debut = null;
        this.fin = null;
        boolean[] tab = {true,true,true,false,false,false,true,false,false,false,false};

        for(int i=0; i< tab.length;i++){
            this.ajouteALaFin(tab[i]);
        }

    }
    /**
     * Question 1.2: Une méthode qui permet d'ajouter une Cellule à la fin de la liste.
     * @param b la couleur de la cellule à ajouter
     */
    public void ajouteALaFin(boolean b){
        Cellule c = new Cellule(b);
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
     * @param b la couleur de la cellule à ajouter
     */
    public void ajouteAuDebut(boolean b){
        Cellule c = new Cellule(b);
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

    public void prochainEtape(Regle regle){
        if(this.debut == null){
            return;
        }
        Cellule act = this.debut;
        while (act != null) {
            act.prochaineEtape(regle);
            act = act.getSuivante();
        }
    }

    public void miseAJour(){
        if(this.debut == null){
            return;
        }
        Cellule act = this.debut;
        while (act != null) {
            act.miseAJour();
            act = act.getSuivante();
        }
    }
    /**
     * Question 2.5:
     * Une méthode qui  qui parcourt la liste deux fois, la première fois en calculant le prochain état,
     * puis en faisant la mise à jour.
     */
    public void uneEtape(Regle regle){
        if(this.debut == null){
            return;
        }
        this.prochainEtape(regle);
        this.miseAJour();
    }

    /**
     * Question 2.6:
     * qui affiche d’abord l’état courant, puis effectue n étapes
     * successives, en affichant les étapes intermédiaires.
     * @param n
     */
    public void nEtapes(int n, Regle r){
        if(this.debut == null){
            return;
        }
        this.afficher();
        for(int i=0; i<n; i++){
            uneEtape(r);
            this.afficher();
        }
    }

}
