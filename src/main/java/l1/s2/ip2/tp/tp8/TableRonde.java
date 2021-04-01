package l1.s2.ip2.tp.tp8;

public class TableRonde {
    private CellRob courant;

    /**
     * Exercice 2.1
     * Un constructeur qui prend en argument un Robot et va créer une liste d’un seul élément
     * @param robot
     */
    public TableRonde(Robot robot){
        this.courant = new CellRob(robot,null,null);
    }

    /**
     * Exercice 2.2
     * Une méthode qui affiche la liste des robots
     */
    public void affiche(){
        if(this.courant == null){
            return;
        }
        this.courant.affiche();
    }

    /**
     * Exercice 2.3
     * Une méthode qui ajoute un nouveau robot dans la liste, qui sera le dernier robot à
     * prendre la parole
     * @param r Robot à ajouter
     */
    public void ajouteRob(Robot r){
        if(this.courant == null){
            this.courant = new CellRob(r,null,null);
            return;
        }
        CellRob c = new CellRob(r,this.courant,this.courant.getPrecedente().getPrecedente());
        this.courant.setPrecedente(c);
        c.getPrecedente().setSuivante(c);
    }

    /**
     * Exercice 2.4
     * Une méthode qui supprime le robot d’identifiant id (le retire de la liste)
     * @param id un entier signifiant id
     * @return true si robot est supprimé sinon false
     */
    public boolean supprimer(int id){
        if(this.courant == null){
            return false;
        }

        if(this.courant.getRobot().getId()==id){
            this.courant = null;
            return true;
        }

        return this.courant.supprimer(id);
    }

    /**
     * Exercice 2.5
     * Une méthode qui supprime le robot dont le nom est donné en paramètre
     * @param nom une chaîne de caractère signifiant le nom du robot
     * @return true si robot est supprimé sinon false
     */
    public boolean supprimer(char nom){
        if(this.courant == null){
            return false;
        }
        if(this.courant.getRobot().getNom() == nom){
            this.courant = null;
            return true;
        }
        return this.courant.supprimer(nom);
    }



}
