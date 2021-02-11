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
     * @return
     */
    public int classement(String prenom, String nom) {
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
         * Nous comptons ensuite les valeurs négatives et les valeurs nulles dans le tableau comparaisonResult
         * pour cela nous introduisons une variables greaters pour compter ces valeurs
         */
        int greaters = 0;
        int comparaisonResult;
        for (int i = 0; i < this.membres.length; i++) {
            if (this.membres[i] == null || i == indexEtudiant) {
                continue;
            }
            comparaisonResult = this.membres[indexEtudiant].compareTo(this.membres[i]);
            if (comparaisonResult < 0) {
                greaters++;
                continue;
            }
            if (comparaisonResult == 0) {
                // Si les deux étudiants ont la même note nous les comparons leurs nom de famille par ordre alphabétique
                comparaisonResult = this.membres[indexEtudiant].nom.compareTo(this.membres[i].nom);
                if(comparaisonResult == 0){
                    // Dans le cas les deux etudiants ont le meme noms de famille, nous comparons leur prénoms.
                    comparaisonResult = this.membres[indexEtudiant].prenom.compareTo(this.membres[i].prenom);
                    if(comparaisonResult == 0){
                        //Si les deux étudiants ont le meme nom & prenom, nous determinons le classement aléatoirement.
                        greaters += Math.random() < 0.5 ? 0 : 1;
                    }
                    if(comparaisonResult > 0){
                        /* Si l'étudiant avec lequel nous comparons a un prénom plus petit que celui de l'étudiant
                        * courant.(Lexicographiquement parlant)
                        */
                        greaters++;
                    }
                }
                if(comparaisonResult > 0){
                    /* Si l'étudiant avec lequel nous comparons a un nom de famille plus petit que celui de l'étudiant
                     * courant.(Lexicographiquement parlant)
                     */
                    greaters++;
                }
            }
        }
        return greaters+1;
    }

    public double moyenne() {
        // FIXME: nombreEtudiant == membres.length
        int nombreEtudiant = 0;
        double somme = 0;
        for (int i = 0; i < membres.length; i++) {
            somme += membres[i].getNote();
            nombreEtudiant++;
        }
        return somme / nombreEtudiant;
    }

    public boolean meilleurQueLaMoyenne() {
        return true;
    }
}
