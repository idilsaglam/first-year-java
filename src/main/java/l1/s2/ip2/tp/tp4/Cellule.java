package l1.s2.ip2.tp.tp4;

public class Cellule {
    private Robot rob;
    private Cellule suivant;


    /**
     * Question 2.2 :
     * Un constructeur de Cellule qui prend un argument de type Robot et un argument de type Cellule
     * @param rob est un Robot
     * @param suivant est un Cellule
     */
    public Cellule(Robot rob, Cellule suivant){
        this.rob = rob;
        this.suivant = suivant;
    }

    /**
     * Question 2.3 :
     * Un constructeur de Cellule qui prend seulement un argument de type Robot, et qui s’écrit
     * en faisant appel au constructeur précédent.
     * @param rob est un robot qui a le type Robot
     */
    public Cellule(Robot rob){
        this(rob,null);
    }

    /**
     * Question 2.4 :
     * Une méthode qui teste si le robot r a un nom correct et si oui le place en position d’être leader du groupe.
     * L’ancien chef de file, s’il existait, est maintenant juste après lui.
     */
    //TODO:
    public void prendreTete(Robot r) {

    }

    /**
     * Question 3.1 : Une méthode qui permet d'afficher la description de tout le cellule.
     */
    public void affiche () {
        System.out.println(this.rob.description());
        if (this.suivant != null) {
            this.suivant.affiche();
        }else{
            System.out.println("Groupe vide");
        }
    }

    /**
     * Question 3.2 : Écrivez une méthode ajouteNouveau qui ajoute un robot en fin de groupe,
     * l’ajout n’a lieu que si le nom du robot est correct.
     */
    public void ajouteNouveau(Robot r){
        Cellule current = this;
        while(current.suivant != null){
            current = current.suivant;
        }
        current = new Cellule(r);
    }

    /**
     * Question 3.3
     * @return la somme des valeurs lettres de noms des robots, le tout modulo 9
     */
    public int numerologie(){
        Cellule current = this;
        int somme = 0;
        while (current.suivant!= null){
            somme += (current.rob.getNom() - 'a');
            current = current.suivant;
        }
        return (somme % 9) ;
    }

    /**
     * Question 3.4 :
     * @return une chaîne de caractère res qui est la concaténation de tous les noms des robots pris dans l'ordre.
     */
    public String bandName(){
        String res = "";
        Cellule current = this;
        while (current != null){
            res+= this.rob.getNom();
            current = current.suivant;
        }
        return res;
    }

    /**
     * Question 3.5
     * @return une chaîne de caractère res qui est la concaténation de la chanson selon la valeur de leur noms.
     */
    public String chante(){
        this.rob.chante();
        String res = "" + this.rob.getTexte();
        for(int i=0; i<this.rob.getNom() - 'a'; i++){
            res+= this.rob.getTexte();
        }
        return res;
    }

    public void chantez(){
        Cellule actuel = this;
        while (actuel != null){
            chante();
            actuel = actuel.suivant;
        }
    }
    //TODO: Question 4.1
    public Cellule couperAPartirDe(char nom){
        if(this.rob.getNom() == nom){
            return new Cellule();
        }
        Cellule premier = this;
        Cellule actuel = this;
        while(actuel.suivant.rob.getNom() != nom){
            actuel = actuel.suivant;
        }
        return premier;
    }

    public Cellule getSuivant(){
        return this.suivant;
    }

    public void setSuivant(Cellule cellule){
        this.suivant = cellule;
    }
}
