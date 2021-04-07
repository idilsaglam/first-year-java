package l1.s2.ip2.tp.tp8;

public class TableRonde {
    private CellRob courant;

    /**
     * Exercice 2.1
     * Un constructeur qui prend en argument un Robot et va créer une liste d’un seul élément
     * @param robot
     */
    public TableRonde(Robot robot){
        this.courant = new CellRob(robot);
    }

    public CellRob getCourant(){
        return this.courant;
    }
    public void setCourant(CellRob c){
        this.courant =c;
    }
    /**
     * Exercice 2.2
     * Une méthode qui affiche la liste des robots
     */
    public void affiche(){
        if(this.courant == null){
            return;
        }
        int iid =this.courant.getRobot().getId();
        CellRob act = this.courant;
        do{
           act.affiche();
           act = act.getSuivante();
        }while(iid != act.getRobot().getId());


    }

    /**
     * Exercice 2.3
     * Une méthode qui ajoute un nouveau robot dans la liste, qui sera le dernier robot à
     * prendre la parole
     * @param r Robot à ajouter
     */
    public void ajouteRob(Robot r){
        if(this.courant == null){
            this.courant = new CellRob(r);
            return;
        }
        CellRob c = new CellRob(r,this.courant,this.courant.getPrecedente());
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
        // On contrôle si la liste est vide
        if(this.courant == null){
            return false;
        }
        // On contrôle si la liste contient un seul élément et cet élément c'est élément qu'on cherche
        if (
                this.courant.getRobot().getId() == this.courant.getSuivante().getRobot().getId() &&
                this.courant.getRobot().getId() == this.courant.getPrecedente().getRobot().getId() &&
                this.courant.getRobot().getId() == id
        ) {
            this.courant = null;
            return true;
        }

        if(this.courant.getRobot().getId() == id){
            this.courant.getPrecedente().setSuivante(this.courant.getSuivante());
            this.courant.getSuivante().setPrecedente(this.courant.getPrecedente());
            this.courant = this.courant.getSuivante();
            return true;
        }

        int iid = this.courant.getRobot().getId();
        CellRob act = this.courant;

        while(act.getRobot().getId() != iid){
            if (act.getRobot().getId() == id) {
                // si on trouve le robot à supprimer
                act.getPrecedente().setSuivante(act.getSuivante());
                act.getSuivante().setPrecedente(act.getPrecedente());
                return true;
            }
            // Si on n'a pas encore trouvé, on passé à la suivante
            act = act.getSuivante();
        }
        return false;
    }

    /**
     * Exercice 2.5
     * Une méthode qui supprime le robot dont le nom est donné en paramètre
     * @param nom une caractère signifiant le nom du robot
     * @return true si robot est supprimé sinon false
     */
    public boolean supprimer(char nom){
        // On contrôle si la liste est vide
        if(this.courant == null){
            return false;
        }

        // On contrôle si la liste contient un seul élément et cet élément c'est élément qu'on cherche
        if (
                this.courant.getRobot().getId() == this.courant.getSuivante().getRobot().getId() &&
                this.courant.getRobot().getId() == this.courant.getPrecedente().getRobot().getId() &&
                this.courant.getRobot().getNom() == nom
        ) {
            this.courant = null;
            return true;
        }

        // On contrôle si l'élément courant contient le robot qu'on veut supprimer
        if(this.courant.getRobot().getNom() == nom){
            this.courant.getPrecedente().setSuivante(this.courant.getSuivante());
            this.courant.getSuivante().setPrecedente(this.courant.getPrecedente());
            // Comme on vient de supprimer la cellule courant de la liste, nous allons déplacer son pointeur à la
            // cellule suivante
            this.courant = this.courant.getSuivante();
            return true;
        }

        int iid = this.courant.getRobot().getId();
        CellRob act = this.courant;

        while(act.getRobot().getId() != iid){
            if (act.getRobot().getNom() == nom) {
                // si on trouve le robot à supprimer
                act.getPrecedente().setSuivante(act.getSuivante());
                act.getSuivante().setPrecedente(act.getPrecedente());
                return true;
            }
            // Si on n'a pas encore trouvé, on passé à la suivante
            act = act.getSuivante();
        }
        return false;

    }

    /**
     * Exercice 2.6
     */
    public void parle5Paroles(){
        if(this.courant == null){
            return;
        }

        while (this.courant != null){
            this.courant.getRobot().parle(5);
            if(this.courant.getRobot().getNp() == 0){
                supprimer(this.courant.getRobot().getId());
            }
            if(this.courant != null) {
                this.courant = this.courant.getSuivante();
            }
        }
    }

}
