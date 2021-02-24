package l1.s2.ip2.tp.tp3;

/**
 * Exercice 2
 */
public class Message {
    private final Utilisateur u;
    private final String content;

    /**
     *
     * @param u est un Utilisateur en argument.
     * @param content est un chaîne de caractère qui est content du message.
     */
    Message(Utilisateur u, String content){
        this.u = u;
        this.content = content;
    }

    /**
     *Comme content est un attribut privé, pour garder son privé et prendre sa valeur en même temps, il faut que nous
     * écrivons le méthode "getter"
     * @return une chaîne de caractère qui est le content du message.
     */
    public String getContent(){
        return this.content;
    }

    /**
     * Comme Utilisateur est un attribut privé, pour garder son privé et prendre sa valeur en même temps, il faut que nous
     * écrivons le méthode "getter"
     * @return Utilisateur courant.
     */
    public Utilisateur getUtilisateur() {
        return u;
    }
}
