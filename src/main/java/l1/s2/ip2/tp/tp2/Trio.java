package l1.s2.ip2.tp.tp2;

/**
 * Question 2.1
 */
public class Trio {
    private final Etudiant[] membres;

    /**
     * Question 2.2
     *
     * @param e1 premier étudiant du trio
     * @param e2 deuxième étudiant du trio
     * @param e3 troisième étudiant du trio
     */
    Trio(Etudiant e1, Etudiant e2, Etudiant e3) {
        this.membres = new Etudiant[]{e1, e2, e3};
    }

    /**
     * Question 2.4
     * @return le premier étudiant qui a la meilleure note de trio
     */
    public Etudiant premier() {
        /*
         * Nous introduisons une variable note qui signifie la meilleure note
         * et nous l'initialisons à -1. Comme -1 n'est pas une note valide,
         * ceci va être remplacé automatiquement avec la note du premier étudiant non null du trio.
         */
        double note = -1;
        /*
         * Nous introduisons une autre variable indexEtudiant qui signifie l'index du premier
         * étudiant qui a la meilleure note. Nous l'initialisons à -1, pour pouvoir retourner
         * null en cas de tous les étudiants du trio soient null.
         */
        int indexEtudiant = -1;
        // Nous parcourons tous les étudiants du trio
        for (int i = 0; i < membres.length; i++) {
            if (membres[i] != null && membres[i].getNote() > note) {
                note = membres[i].getNote();
                indexEtudiant = i;
            }
        }
        /*
         * Nous retournons null si l'indexEtudiant est -1 (le cas tous les étudiants du trio est null).
         * Sinon nous retournons l'étudiant de l'index indexEtudiant
         */
        return indexEtudiant == -1 ? null : membres[indexEtudiant];
    }


    /**
     * Question 2.5
     * @param prenom le prénom de l'étudiant que nous allons regarder son classement
     * @param nom le nom de famille de l'étudiant que nous allons regarder son classement
     * @return le classement de l'étudiant passé en paramètre
     */
    public int classement(String prenom, String nom) {
        /*
         * Nous introduisons une variable indexEtudiant qui signifie l'index
         * du premier étudiant qui a le prénom et nom passé en paramètre.
         * Nous l'initialisons à -1 pour vérifier si un tel étudiant existe dans le trio
         */
        int indexEtudiant = -1;
        for (int i=0; i<this.membres.length; i++) {
            if (this.membres[i].prenom.equals(prenom) && this.membres[i].nom.equals(nom)) {
                /* Une fois que nous trouvons un tel étudiant, nous réinitialisons la valeur de
                * indexEtudiant avec l'index actuel
                */
                indexEtudiant = i;
                // Puis nous sortons de la boucle
                break;
            }
        }
        /*
         * Si l'index est toujours -1, c'est à dire qu'un tel étudiant n'existe pas dans le trio.
         * Dans ce cas nous retournons 0
        */
        if (indexEtudiant == -1) {
            return 0;
        }
        /*
         * Ensuite, nous comparons les étudiants entre eux. Pour cela nous introduisons deux variables:
         * - une variable de type int greaters qui contient le nombre d'étudiant qui est mieux classé que l'étudiant
         * courant. Nous l'initialisons avec une valeur initiale à 0.
         * - une variable comparaisonResult de type int qui contient le résultat des comparaisons. (Nous le déclarons en
         * dehors de la boucle, pour éviter de faire des déclarations successifs dans la boucle).
         */
        int greaters = 0;
        int comparaisonResult;
        for (int i = 0; i < this.membres.length; i++) {
            if (this.membres[i] == null || i == indexEtudiant) {
                /*
                 * Si l'étudiant avec qui nous comparons est null ou a le même index que l'étudiant courant
                 * nous passons à l'étudiant suivant.
                 */
                continue;
            }
            /*
             * Nous calculons la différence de note de l'étudiant courant avec la note de l'étudiant à l'index i
             * si cette variable est < 0 l'étudiant à l'index i est sûrement mieux classé que l'étudiant en cours.
             * si cette variable est > 0 l'étudiant courant est mieux classé
             * si cette variable est 0 les notes sont égaux.
             */
            comparaisonResult = (int)Math.signum(this.membres[indexEtudiant].getNote() - this.membres[i].getNote());
            if (comparaisonResult < 0) {
                /*
                 * Si la note de l'étudiant index i est supérieur à celui de l'étudiant courant.
                 * Nous incrémentons notre compteur de 1.
                 */
                greaters++;
            }
            if (comparaisonResult == 0) {
                // Si les deux étudiants ont la même note nous les comparons leurs nom de famille par ordre alphabétique
                comparaisonResult = this.membres[indexEtudiant].nom.compareTo(this.membres[i].nom);
                if(comparaisonResult == 0){
                    // Dans le cas les deux etudiants ont le meme noms de famille, nous comparons leur prénoms.
                    comparaisonResult = this.membres[indexEtudiant].prenom.compareTo(this.membres[i].prenom);
                    if(comparaisonResult == 0){
                        //Si les deux étudiants ont le meme nom & prénom, nous déterminons le classement aléatoirement.
                        greaters += Math.random() < 0.5 ? 0 : 1;
                    }
                    if(comparaisonResult > 0){
                        /*
                        * Si l'étudiant avec lequel nous comparons a un prénom plus petit que celui de l'étudiant
                        * courant.(Lexicographiquement parlant)
                        */
                        greaters++;
                    }
                }
                if(comparaisonResult > 0){
                    /*
                     * Si l'étudiant avec lequel nous comparons a un nom de famille plus petit que celui de l'étudiant
                     * courant.(Lexicographiquement parlant)
                     */
                    greaters++;
                }
            }
        }
        // S'il y a n étudiants mieux classé que l'étudiant courant, le classement de l'étudiant courant sera n+1.
        return greaters+1;
    }

    /**
     * Question 2.5 (Version alternative)
     * @param prenom le prénom de l'étudiant que nous allons regarder son classement
     * @param nom le nom de famille de l'étudiant que nous allons regarder son classement
     * @return le classement de l'étudiant passé en paramètre
     */
    public int classementBis(String prenom, String nom) {
        /*
         * Nous introduisons une variable indexEtudiant qui signifie l'index
         * de l'étudiant qui a le prénom et nom passé en paramètre.
         * Nous l'initialisons à -1 pour vérifier si un tel étudiant existe dans le trio
         */
        int indexEtudiant = -1;
        for (int i=0; i<this.membres.length; i++) {
            if (this.membres[i].prenom.equals(prenom) && this.membres[i].nom.equals(nom)) {
                indexEtudiant = i;
                break;
            }
        }
        /*
         * Si l'index est toujours -1, c'est à dire qu'un tel étudiant n'existe pas dans le trio.
         * Dans ce cas nous retournons 0
         */
        if (indexEtudiant == -1) {
            return 0;
        }
        /*
         * Ensuite, nous comparons les étudiants entre eux. Pour cela nous introduisons
         * une variable de type int greaters qui contient le nombre d'étudiant qui est mieux classé que l'étudiant
         * courant. Nous l'initialisons avec une valeur initiale à 0.
         */
        int greaters = 0;
        for (int i = 0; i<this.membres.length; i++) {
            if (this.membres[i] == null || i == indexEtudiant) {
                /*
                 * Si l'étudiant avec qui nous comparons est null ou a le même index que l'étudiant courant
                 * nous passons à l'étudiant suivant.
                 */
                continue;
            }
            /*
             * Pour comparer deux étudiants nous nous servons de la méthode compareTo que nous avons défini dans la
             * classe Etudiant. 
             */
            greaters += this.membres[indexEtudiant].compareTo(this.membres[i]) < 0 ? 1 : 0;
        }
        return greaters + 1;
    }

    /**
     * Question 2.6
     * @return la moyenne du trio.
     */
    public double moyenne() {
        //On introduit une variable nombre Etudiant pour compter les etudiants non nulls.
        int nombreEtudiant = 0;
        // On introduit une deuxième variable de type double pour faire la somme des notes des étudiants non nulls.
        double somme = 0;
        for (int i = 0; i < this.membres.length; i++) {
            if(this.membres[i] == null){
                continue;
            }
            somme += this.membres[i].getNote();
            nombreEtudiant++;
        }
        //On calcule la moyenne en divisant la somme par le nombre d'étudiants non nulls.
        return somme / nombreEtudiant;
    }

    /**
     * @return true si la moyenne du trio est supérieur ou égal à la moyenne d'étudiant; false sinon
     */
    public boolean meilleurQueLaMoyenne() {
        return (this.moyenne() >= Etudiant.moyenne());
    }
}
