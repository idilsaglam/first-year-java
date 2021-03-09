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
     * Constructor permet de construire un groupe avec le chef de file passé en paramètre
     */
    public Groupe(Cellule chef) {
        this.chefDeFile = chef;
    }

    /**
     * Question 2.4 :
     * Une méthode qui teste si le robot r a un nom correct et si oui le place en position d’être leader du groupe.
     * L’ancien chef de file, s’il existait, est maintenant juste après lui.
     */
    public void prendreTete(Robot r) {
        if (r == null) {
            // Si le robot passé en paramètre est null nous faisons rien
            return;
        }
        if (r.nomCorrect()) {
            // Créons une nouvelle cellule avec le robot passé en paramètre
            Cellule newRoot = new Cellule(r);
            if (this.chefDeFile == null) {
                // S'il n'y a pas encore de chef de file nous initialisons la nouvelle cellule étant chef de file
                this.chefDeFile = newRoot;
                return;
            }
            // S'il y a déjà une chef de file. Nous l'ajoutons à la suite de la nouvelle cellule.
            newRoot.setSuivant(this.chefDeFile);
            // On remplace le chef de file avec la nouvelle cellule.
            this.chefDeFile = newRoot;
        }
        return;
    }

    /**
     * Question 3.1 : Une méthode qui permet d'afficher la description de tout le groupe.
     */
    public void affiche(){
        if(this.chefDeFile == null){
            System.out.println("Groupe vide");
            return;
        }
        this.chefDeFile.affiche();
    }

    /**
     * Question 3.2
     * Méthode permet d'ajouter un nouveau robot en fin du groupe l'ajout n'a lieu que si le nom du robot est correct
     * @param robot robot à ajouter
     */
    public void ajouteNouveau(Robot robot){
        if (robot == null || !robot.nomCorrect()) {
            // Si le robot est null ou son nom n'est pas correct nous faisons rien
            return;
        }
        if( this.chefDeFile == null){
            // S'il n'y a pas de chef de file nous créons une nouvelle cellule et le met en chef de file
            this.chefDeFile = new Cellule(robot);
            return;
        }
        // Sinon on appelle le méthode ajouteNouveau de la classe cellule sur le chef de file
        this.chefDeFile.ajouteNouveau(robot);
    }

    public String bandName(){
        if (this.chefDeFile != null) {
            return null;
        }
        return this.chefDeFile.bandName();
    }

    /**
     * Question 3.6: Méthode fait chanter tous les robots un par un
     */
    public void chantez(){
        if (this.chefDeFile == null) {
            return;
        }
        this.chefDeFile.chantez();
    }

    /**
     * Question 4.1: Méthode élimine tous les robots qui sont derrière le premier robot dont le nom
     * est précisé.
     * @param nom Nom du robot à partir de quelle ça va être coupé
     * @return les celleules ont été enlevé sous forme d'un groupe
     */
    public Groupe couperAPartirDe(char nom){
        if (this.chefDeFile == null) {
            return new Groupe();
        }
        return new Groupe(this.chefDeFile.couperAPartirDe(nom));
    }

    public Groupe prendrePause(){
        if (this.chefDeFile == null) {
            return new Groupe();
        }
        if (chefDeFile.besoinDePause()) {
            Cellule c = this.chefDeFile;
            this.chefDeFile = this.chefDeFile.getSuivant();
            Groupe g = new Groupe(c);
            g.merge(this.prendrePause());
            return g;
        }
        return new Groupe(this.chefDeFile.prendrePause());
    }

    /**
     * Méthode permet d'ajouter tous les élément d'un groupe à la fin du groupe actuel
     * @param g le groupe à ajouter
     */
    public void merge(Groupe g) {
        if (this.chefDeFile == null) {
            this.chefDeFile = g.chefDeFile;
            return;
        }
        this.chefDeFile.ajouteCellule(g.chefDeFile);
    }

    /**
     * Question 3.3
     * @return la somme des valeurs lettres de noms des robots, le tout modulo 9
     */
    public int numerologie() {
        if (this.chefDeFile == null ) {
            return 0;
        }
        return this.chefDeFile.numerologie();
    }

    /**
     * Question 5.3
     * @return effectif d'un groupe
     */
    public int effectif() {
        if (this.chefDeFile == null) {
            return 0;
        }
        return this.chefDeFile.effectif();
    }
}

