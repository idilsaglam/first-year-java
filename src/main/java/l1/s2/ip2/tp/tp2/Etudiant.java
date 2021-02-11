package l1.s2.ip2.tp.tp2;

/*
* Question 2.5 (Version alternative): Nous ajoutons implements Comparable<Etudiant>
* et ensuite redéfinissons le méthode compareTo(Etudiant o) dans cette classe.
*/
public class Etudiant implements Comparable<Etudiant> {
    private static int nombreDEtudiants = 0;
    private static double sommeDesNotes = 0;
    final String prenom;
    final String nom;
    private double note;

    /**
     * Question 1.3
     *
     * @param prenom le prénom de de l'étudiant
     * @param nom    le nom de famille de l'étudiant
     * @param note   la note de l'étudiant
     */
    Etudiant(String prenom, String nom, double note) {
        this.prenom = prenom;
        this.nom = nom;
        this.note = note;
        // Nous incrémentons la valeur nombreDEtudiants de 1
        nombreDEtudiants++;
        // Nous ajoutons la note de l'étudiant à la variable sommeDesNotes
        sommeDesNotes += this.note;
    }

    /**
     * Question 1.4
     *
     * @return la valeur numérique de l'attribut statique nombreDEtudiants
     */
    public static int getNombreDEtudiants() {
        return nombreDEtudiants;
    }

    /**
     * Question 1.7
     *
     * @param e Etudiant à afficher
     */
    public static void afficher2(Etudiant e) {
        e.afficher();
    }

    /**
     * Question 1.9
     * Fonction retourne la moyenne de tous les étudiants.
     *
     * @return double la moyenne de tous les étudiants
     */
    public static double moyenne() {
        return sommeDesNotes / nombreDEtudiants;
    }

    /**
     * Question 1.12
     * Pour éviter que l'attribut sommeDesNotes soient modifiable en dehors de cette classe
     * nous le transformons à un attribut privé. Et pour que cet attribut soient accessible
     * en dehors de cette classe nous ajoutons une méthode statique de type getter qui retourne
     * la valeur de cet attribut statisque.
     *
     * @return la valeur numérique de l'attribut statique sommeDesNotes
     */
    public static double getSommeDesNotes() {
        return sommeDesNotes;
    }

    /**
     * Question 1.6
     * Cette méthode affiche les informations relative à
     * l’étudiant courant sous le format "<nom> <prenom> : <note>"
     */
    public void afficher() {
        System.out.println(this.nom + " " + this.prenom + ": " + this.note);
    }

    /**
     * Question 1.8
     *
     * @return true si la note d'étudiant courant est supérieur ou égale à 10, false sinon
     */
    public boolean estAdmis() {
        return (this.note >= 10);
    }

    /**
     * Question 1.10
     * Fonction teste si la note de l'étudiant courant est strictement supérieur à la moyenne de tous les étudiants
     *
     * @return true if la note de l'étudiant courant est strictement supérieur à la moyenne de tous les étudiants
     */
    public boolean meilleurQueLaMoyenne() {
        return (this.note > moyenne());
    }

    /**
     * Question 1.11
     *
     * @param nouvelleNote la nouvelle note de l'étudiant
     */
    public void modifierNote(double nouvelleNote) {
        /**
         *  Nous vérifions si la nouvelle note est supérieur ou égale à 0
         *  et strictement inférieur à 21
         */
        if (nouvelleNote >= 0 && nouvelleNote < 21) {
            // Si c'est la cas nous enlevons d'abord l'ancienne note de somme des notes
            sommeDesNotes -= this.note;
            // Puis nous changeons la note avec la nouvelle note
            this.note = nouvelleNote;
            // Finalement, nous ajoutons la nouvelle note à la somme des notes
            sommeDesNotes += nouvelleNote;
        }
    }

    public double getNote() {
        return note;
    }

    /**
     * Méthode compare deux étudiants
     * @param o Autre étudiant avec lequel nous comparons étudiant en cours.
     * @return une valeur négative si l'étudiant o
     * est mieux classé que l'étudiant en cours, une valeur positif sinon
     */
    @Override
    public int compareTo(Etudiant o) {
        // Nous faisons d'abord une simple comparaison des deux doubles
        int comparaisonResult = Double.compare(this.note, o.note);
        // Si le résultat de ce comparaison est 0 c.à.d que les deux étudiants ont le même note
        if (comparaisonResult == 0) {
            // Dans ce cas nous comparons leurs noms de familles
            comparaisonResult = this.nom.compareTo(o.nom);
            if(comparaisonResult > 0) {
                /*
                * Si le nom de famille de l'étudiant o dans l'ordre alphabétique est  avant que celui de l'étudiant courant.
                * Nous considérons que l'étudiant o est mieux classé que l'étudiant courant.
                */
                return -1;
            }
            if (comparaisonResult == 0) {
                // Si les deux étudiants ont la même note et le même de nom famille nous comparons leurs prénoms
                comparaisonResult = this.prenom.compareTo(o.prenom);
                if (comparaisonResult > 0) {
                    /*
                     * De même manière de les noms de familles, dans l'ordre alphabétique si le prénom de l'étudiant o
                     * vient avant que celui de l'étudiant en cours. Nous considérons que l'étudiant o est mieux classé
                     */
                    return -1;
                }
                if(comparaisonResult == 0) {
                    /*
                     * Si les deux étudiants ont le même nom, même prénom et même note.
                     * Alors la comparaison sera faite de manière aléatoire
                     */
                    return (Math.random()< 0.5 ? -1 : 1);
                }
                /*
                 * Dans l'ordre alphabétique si le prénom de l'étudiant courant est avant de celui de l'étudiant o. Nous
                 * retournons un entier positif
                 */
                return comparaisonResult;
            }
            /*
             * Dans l'ordre alphabétique si le nom de famille de l'étudiant courant est avant de celui de l'étudiant o. Nous
             * retournons un entier positif
             */
            return comparaisonResult;
        }
        // Si la note des deux étudiants sont différents, nous retournons le résultat de comparaison.
        return comparaisonResult;
    }
}
