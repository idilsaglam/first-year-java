package l1.s2.ip2.tp.tp4;

public class GroupeArray {
    private Groupe[] content;
    private int population;
    /**
     * Méthode permet de construire un GroupeArray
     * @param nbGroupe nombre de groupes
     */
    public GroupeArray(int nbGroupe) {
        this.content = new Groupe[nbGroupe];
        this.population = 0;
    }

    /**
     * Méthode retourne le contenu de groupe table
     * @return
     */
    public Groupe[] getContent() {
        return content;
    }

    /**
     * Méthode permet d'ajouter un groupe dans le tableau
     * @param g groupe à ajouter
     * @return retourne true si l'ajout est effectue false sinon
     */
    public boolean ajouter(Groupe g) {
        if (this.population >= this.content.length) {
            return false;
        }
        this.content[population] = g;
        this.population++;
        return true;
    }

    /**
     * Méthode permet de retourner l'effectif de chaque groupe sous forme d'un tableau d'entiers
     */
    public int[] effectif() {
        int[] result = new int[population];
        for (int i = 0; i<result.length; i++) {
            result[i] = this.content[i].effectif();
        }
        return result;
    }
}
