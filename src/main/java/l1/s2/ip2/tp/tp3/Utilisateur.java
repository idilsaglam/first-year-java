package l1.s2.ip2.tp.tp3;

public class Utilisateur {

    /**
     * Question 1.1
     * On déclare les attributs donné en question.
     */
    private String pseudo;
    private String motDePasse;
    private final String adresseMail;


    /**
     * Question 1.2
     */
    Utilisateur(String pseudo, String motDePasse, String adresseMail) {
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.adresseMail = adresseMail;
    }

    /**
     * Question 1.2
     * @param m une chaîne de caractère (un mot de passe);
     */
    public boolean testMotDePasse(String m) {
        /**
         * En utilisant le méthode equals(), nous vérifions si l'argument 'm' est identique au mot de passe actuel
         */
        return (this.motDePasse.equals(m));
    }

    /**
     * Question 1.3
     * Méthode permet de changer le mot de passe si le mot de passe actuel est correct
     * @param mo Le mot de passe courant
     * @param m le nouveau mot de passe
     */
    public void changeMotDePasse(String mo, String m) {
        // Nous vérifions si le mot de passe courant passé en paramètre est correct
        if (testMotDePasse(mo)) {
            // Si c'est le cas nous le remplaçons par le nouveau
            this.motDePasse = m;
        }
        return;
    }

    /**
     * Question 1.4
     * Comme l'attribut 'pseudo' est un propriété privé, nous ne pouvons pas y accéder dans une autre classe.
     * Pour pouvoir garder le propriété privé et prendre sa valeur en même temps, il faut que nous écrivons le méthode
     * 'getter'.
     * @return la valeur de 'pseudo' actuel.
     */
    public String getPseudonyme() {
        return this.pseudo;
    }

    /**
     * Question 1.4
     * Comme l'attribut 'pseudo' est un propriété privé, nous ne pouvons pas le modifier dans une autre classe.
     * Pour pouvoir garder la propriété privé et modifier sa valeur en même temps, il faut que nous écrivons le méthode
     * 'setter'.
     * @param s nouveau pseudo qu'on veut changer avec le pseudo actuel.
     */
    public void setPseudonyme(String s) {
        if (s == null) {
            return;
        }
        this.pseudo = s;
    }

    /**
     * Pour pouvoir comparer les deux Utilisateurs, il faut que nous redéfinissons la méthode equals de la classe
     * Object pour la classe Utilisateur.
     * @param o Autre objet (l'objet avec lequel on va comparer l'utilisateur courant)
     * @return true si argument est identique au Utilisateur actuel false sinon.
     */
    @Override
    public boolean equals(Object o) {
        /*
         * Nous vérifions que l'objet passé en paramètre est bien une instance de la classe Utilisateur
         */
        if (o instanceof Utilisateur) {
            // Si c'est le cas nous le stockons dans une variable de type Utilisateur pour faciliter la comparaison
            Utilisateur u = (Utilisateur)o;
            /*
             * Pour pouvoir dire que 2 Utilisateur sont identiques, il faut que toutes les
             * valeurs des attributes soient les memes.
             */
            return (
                    this.pseudo.equals(u.pseudo) &&
                    this.motDePasse == u.motDePasse &&
                    this.adresseMail.equals(u.adresseMail)
            );
        }
        // Si l'objet passé en paramètre n'est pas une instance de la classe Utilisateur, nous retournons false
        return false;
    }

    @Override
    public String toString(){
        return this.getPseudonyme();
    }

}