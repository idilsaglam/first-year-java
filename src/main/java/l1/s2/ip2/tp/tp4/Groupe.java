package l1.s2.ip2.tp.tp4;

public class Groupe {
    private Cellule chefDeFile;

    /**
     * Question 2.1: Un constructeur qui crée un groupe vide
     */
    public Groupe(){
        this.chefDeFile = null;
    }

    /**
     * Question 3.1 : Une méthode qui permet d'afficher la description de tout le groupe.
     */
    public void afficher(){
        if(this.chefDeFile == null){
            System.out.println("Group vide");
        }
        this.chefDeFile.affiche();
    }

    public void ajouteNouveau(Robot robot){
        if( this.chefDeFile == null){
            this.chefDeFile = new Cellule(robot);
            return;
        }
        this.chefDeFile.ajouteNouveau(robot);

    }

    public void bandName(){
        this.chefDeFile.bandName();
    }

    public void chante(){
        this.chefDeFile.chante();
    }

    // Question 3.6
    public void chantez(){
        this.chefDeFile.chantez();
    }

    public Groupe APartirDe(char nom){
        this.chefDeFile.couperAPartirDe(nom);
        Groupe groupe = new Groupe();
    }

    public Groupe prendrePause(){

    }
}

