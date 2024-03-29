package l1.s2.ip2.tp.tp8;

public class CellRob {
    private CellRob suivante;
    private CellRob precedente;
    private Robot robot;

    /**
     * Exercice 2.1
     * Un constructeur qui prend en argument un Robot rob et deux CellRob suiv et prec.
     * @param rob robot
     * @param suiv la CellRob suivante
     * @param prec la CellRob precedente
     */
    public CellRob(Robot rob, CellRob suiv, CellRob prec){
        this.precedente = prec;
        this.suivante = suiv;
        this.robot = rob;
    }

    public CellRob(Robot robot){
        this.robot = robot;
        this.precedente = this;
        this.suivante = this;
    }

    // Les accesseurs
    public CellRob getSuivante(){
        return this.suivante;
    }
    public CellRob getPrecedente(){
        return this.precedente;
    }
    public void setSuivante(CellRob suivante){
        this.suivante = suivante;
    }
    public void setPrecedente(CellRob precedente){
        this.precedente = precedente;
    }
    public void setRobot(Robot r){
        this.robot = r;
    }
    public Robot getRobot(){
        return this.robot;
    }

    /**
     * Exercice 2.2
     * Une méthode qui affiche la liste des robots
     */
    public void affiche(){
       this.getRobot().description();
    }

}
