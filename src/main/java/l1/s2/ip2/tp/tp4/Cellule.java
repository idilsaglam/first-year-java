package l1.s2.ip2.tp.tp4;

public class Cellule {
    private Robot rob;
    private Cellule suivant;


    /**
     * Question 2.2:
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
     * Question 3.1 : Une méthode qui permet d'afficher la description de tout le cellule.
     */
    public void affiche () {
        if (this.rob != null) {
            System.out.println(this.rob.description());
        }
        if (this.suivant == null) {
            return;
        }
        this.suivant.affiche();
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
        current.setSuivant(new Cellule(r));
    }

    /**
     * Question 3.3
     * @return la somme des valeurs lettres de noms des robots, le tout modulo 9
     */
    public int numerologie(){
        Cellule current = this;
        int somme = 0;
        while (current != null){
            somme += (current.rob.getNum());
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
     * Méthode fait chanter tous les robots un par un
     * @return le string
     */
    public void chantez(){
        Cellule actuel = this;
        while (actuel != null){
            if (actuel.rob != null) {
                System.out.println(actuel.rob.chante());
            }
            actuel = actuel.suivant;
        }
    }
    //TODO: Question 4.1
    public Cellule couperAPartirDe(char nom){
        if (this.rob.getNom() == nom) {
           return this;
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

    public boolean besoinDePause() {
        return this.rob.getEnergie() == 0;
    }

    /**
     * Méthode permet d'ajouter la cellule c à la fin
     * @param c la cellule à ajouter
     */
    public void ajouteCellule(Cellule c) {
        Cellule current = this;
        while(current.suivant != null) {
            current = current.suivant;
        }
        current.suivant = c;
    }

    /**
     * Méthode permet de réinitialiser la cellule suivante d'une cellule
     * @param cellule c
     */
    public void setSuivant(Cellule cellule){
        this.suivant = cellule;
    }

    /**
     * Méthode permet d'enlever tous les cellules dont l'énergie 0
     * @return les cellules à enlever
     */
    public Cellule prendrePause() {
        Cellule result = null;
        Cellule current = this;
        while(current.suivant != null) {
            if (current.suivant.besoinDePause()) {
                if (result == null) {
                    result = current;
                } else {
                    result.ajouteCellule(current);
                }
                current.suivant = current.suivant.suivant;
            }
            current = current.suivant;
        }
        return result;
    }

    /**
     * Question 5.3
     * @return effectif d'une cellule
     */
    public int effectif() {
        if (this.suivant == null) {
            return 1;
        }
        return 1 + this.suivant.effectif();
    }
}
