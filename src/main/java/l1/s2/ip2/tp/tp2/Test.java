package l1.s2.ip2.tp.tp2;

public class Test {
    public static void main (String[] args){
    // TODO: Question 2:
    /**
     * Question 1.4
     * Nous ne voulons pas que la variable statique nombreDEtudiant de la classe
     * Etudiant soit modifiable en dehors de la classe Etudiant. Pour cela nous ajoutons
     * le mot clé private devant la déclaration de cette variable dans la classe Etudiant.
     * Ainsi, pour que sa valeur soit accessible en dehors de la classe Etudiant, nous introduisons
     * une méthode publique statique de type getter qui retourne la valeur de la variable nombreDEtudiant
     * dans la classe Etudiant (public static int getNombreDEtudiant()).
     */
    Etudiant e1 = new Etudiant("Luke","Skywalker",8.25);
    Etudiant e2 = new Etudiant("Leia","Organa",11.75);
    System.out.println("nb d'etudiants: " + Etudiant.getNombreDEtudiants());
    System.out.println("somme des notes: " + Etudiant.getSommeDesNotes());
    /**
     * Question 1.5
    */
    Etudiant idil = new Etudiant("Idil","Saglam",20.00);
    System.out.printf(
            "nb d'étudiants : %d somme des notes : %f\n",
            Etudiant.getNombreDEtudiants(),
            Etudiant.getSommeDesNotes()
    );
    /**
     * Question 1.7
     * La méthode afficher2 de la classe Etudiant a le signature suivant:
     * public static void afficher2(Etudiant e)
     */
    e1.afficher();
    e2.afficher();
    Etudiant.afficher2(e1);
    Etudiant.afficher2(e2);

    /**
     * Question 1.8
     * Le premier va afficher false
     * Le deuxième va afficher true
    */
    System.out.println(e1.estAdmis());
    System.out.println(e2.estAdmis());


    /**
     * Question 1.9
     */
    System.out.println("moyenne : " + Etudiant.moyenne());

    /**
     * Question 1.10
     */
    System.out.println(idil.meilleurQueLaMoyenne());
    System.out.println(e1.meilleurQueLaMoyenne());

    /**
     * Question 1.11
     * Nous testons le méthode modifier note sur l'étudiant e2
     */
    System.out.printf("La moyenne avant la modification %f\n", Etudiant.moyenne());
    e2.modifierNote(9.5);
    // Après la modification la méthode estAdmis() appelé sur l'étudiant e2 doit retourner false:
    System.out.println(e2.estAdmis());
    // Ainsi la moyenne doivent être modifié
    System.out.println(Etudiant.moyenne());

    /* Exercice 2 */
    /**
     * Question 2.3
     */
    Trio trio = new Trio(e1,e2,idil);
    /**
     * Question 2.4
     */
    trio.premier().afficher();
    System.out.printf(
        "Si nous appelons la méthode premier sur un trio où tous les étudiants sont null. Le résultat est null %b\n",
        ((new Trio(null, null, null)).premier() == null)
    );
    }
}
