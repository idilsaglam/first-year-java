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
        CellRob act = this;
        while (act != null){
            act.getRobot().description();
            act = act.suivante;
        }
    }

    /**
     * Exercice 2.4
     * Une méthode qui supprime le robot d’identifiant id (le retire de la liste)
     * @param id un entier signifiant id
     * @return true si robot est supprimé sinon false
     */
    public boolean supprimer(int id){
        CellRob c = this;
        while (c.suivante != null){
            if(c.suivante.getRobot().getId() == id){
                c.setSuivante(c.suivante.suivante);
                c.suivante.suivante.precedente = this;
                return true;
            }
            c=c.suivante;
        }
        return false;
    }

    /**
     * Exercice 2.5
     * Une méthode qui supprime le robot dont le nom est donné en paramètre
     * @param nom une chaîne de caractère signifiant le nom du robot
     * @return true si robot est supprimé sinon false
     */
    public boolean supprimer(char nom){
        CellRob c = this;
        while (c.suivante != null){
            if(c.suivante.getRobot().getNom() == nom){
                c.setSuivante(c.suivante.suivante);
                c.suivante.suivante.precedente = this;
                return true;
            }
            c=c.suivante;
        }
        return false;
    }


    public void DiscussionEntreRobots(){
        CellRob act = this;
        while (act != null){
            act.getRobot().parle(5);
            act = act.suivante;
        }






    }

}
