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
     * @param rob
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
    public void prendreTete(Robot r){
        if(!r.Correct()){
            return;
        }

    }

}
