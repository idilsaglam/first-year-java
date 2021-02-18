package l1.s2.ip2.tp.tp3;

public class Utilisateur{
/**
 * Question 1.1
 *On déclare les attributs donné en question.
 */
private String pseudo;
private String motDePasse;
private final String adresseMail;

/**
 * Question 1.2
 */

Utilisateur(String pseudo, String motDePasse, String adresseMail){
    this.pseudo = pseudo;
    this.motDePasse = motDePasse;
    this.adresseMail = adresseMail;
}

/**
 * Question 1.2
 * @param m une chaîne de caractère(un mot de passe);
 */

public boolean testMotDePasse(String m){
    /**
     * En utilisant le méthode equals(),nous vérifions si l'argument 'm' est identique au mot de passe actuel
     */
    return(this.motDePasse.equals(m));
}

public void changeMotDePasse(String mo, String m){
    if(testMotDePasse(mo)){
        this.motDePasse = m;
    }
    return;
}

/**
 * Question 1.4
 * Comme l'attribut 'pseudo' est un type privé, nous ne pouvons pas accéder d'un autre class.
 * Pour pouvoir garder le type privé et prendre sa valeur en meme temps, il faut que nous écrivons le méthode
 * 'getter'.
 * @return la valeur de 'pseudo' actuel.
 */

public String getPseudonyme(){
    return this.pseudo;
}

/**
 * Question 1.4
 * Comme l'attribut 'pseudo' est un type privé, nous ne pouvons pas le modifier dans une autre class.
 * Pour pouvoir garder le type privé et modifier sa valeur en meme temps, il faut que nous écrivons le méthode
 * 'setter'.
 * @param  s nouveau pseudo qu'on veut changer avec le pseudo actuel.
 */

public void setPseudonyme(String s){
    this.pseudo = s;
}

/**
 * Pour pouvoir comparer les deux Utilisateurs, il faut que nous déterminons dans le Classe Object
 * @param o
 * @return true si argument est identique au Utilisateur actuel false sinon.
 */

@Override
public boolean equals(Object o){
    if(o instanceof Utilisateur){
        Utilisateur u = (Utilisateur)o;
        /**
         * Pour pouvoir dire que 2 Utilisateur sont identiques, il faut que toutes les
         * valeurs des attributes soient les memes.
         */
        return(
            this.pseudo.equals(u.pseudo) &&
            this.motDePasse == u.motDePasse &&
            this.adresseMail.equals(u.adresseMail));
    }
    return false;
}

}