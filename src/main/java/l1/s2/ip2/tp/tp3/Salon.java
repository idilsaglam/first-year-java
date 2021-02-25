package l1.s2.ip2.tp.tp3;

public class Salon {
    Utilisateur[] utilisateurs;
    Message[] messages;

    Salon(Utilisateur[] utilisateurs) {
        this.messages = new Message[0];
        this.utilisateurs = utilisateurs;
    }

    Salon() {
        this.utilisateurs = new Utilisateur[0];
        this.messages = new Message[0];
    }

    /**
     * Question 3.2
     * Méthode permet d'ajouter utilisateur u dans le salon actuel
     * si l'utilisateur est déjà dans le salon ça n'a aucun effet
     *
     * @param u Utilisateur que nous voulons ajouter au tableau utilisateurs.
     */
    public void ajouterUtilisateur(Utilisateur u) {

        /*
         * Si u est un utilisateur null, nous ne pouvons pas l'ajouter.
         */
        if (u == null) {
            return;
        }

        /*
         * Si l'utilisateur est déjà dans le Salon nous ne pouvons pas l'ajouter encore.
         */
        for (int i = 0; i < this.utilisateurs.length; i++) {
            if (this.utilisateurs[i].equals(u)) {
                return;
            }
        }

        /*
         * Après avoir contrôlé les deux cas, nous pouvons ajouter utilisateur u dans le tableau utilisateurs.
         * Comme la taille du nouveau tableau va augmenter 1, il faut que nous créons un nouveau tableau avec un taille
         * +1 que l'ancienne.
         */
        Utilisateur[] newU = new Utilisateur[this.utilisateurs.length + 1];

        //D'abord nous mettons des utilisateurs qui étaient déjà dans le tableau utilisateurs.

        for (int i = 0; i < this.utilisateurs.length; i++) {
            newU[i] = this.utilisateurs[i];
        }

        //Et après, nous ajoutons le dernier utilisateur du tableau newU (qui est Utilisateur u)
        newU[newU.length - 1] = u;

        // Je remplace le tableau utilisateurs avec le nouveau tableau newU;
        this.utilisateurs = newU;
    }

    /**
     * Question 3.3
     * Méthode permet de vérifier si l'utilisateur est présent dans le salon
     *
     * @param u Utilisateur que nous regardons s'il est présent dans le salon ou non.
     * @return true si Utilisateur u est présent dans le salon, false sinon.
     */
    public boolean estPresent(Utilisateur u) {

        // Si Utilisateur u est null, il ne peut pas etre présent.
        if (u == null) {
            return false;
        }

        /*
         * Nous regardons chaque utilisateur qui est dans le salon, si un utilisateur du salon est identique au
         * Utilisateur u,nous pouvons dire qu'il est présent.
         */
        for (int i = 0; i < this.utilisateurs.length; i++) {
            if (this.utilisateurs[i].equals(u)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Question 3.4
     * Méthode permet d'ajouter une message dans le salon
     *
     * @param m Un message que nous voulons ajouter au salon si son utilisateur est présent.
     */
    public void ajouterMessage(Message m) {
        // Si Message m est null, nous ne pouvons pas l'ajouter.
        if (m == null) {
            return;
        }

        /*
         * Si l'utilisateur de message m est présent, nous l'ajoutons au Salon.
         */
        if (estPresent(m.getUtilisateur())) {
            Message[] newM = new Message[this.messages.length + 1];
            for (int i = 0; i < this.messages.length; i++) {
                newM[i] = this.messages[i];
            }
            newM[newM.length - 1] = m;
            this.messages = newM;
        }
    }

    /**
     * Question 3.5
     * Méthode permet d'afficher le salon actuel dans le flux de sortie standard
     */
    public void afficher() {
        for (int i = 0; i < this.messages.length; i++) {
            System.out.printf(
                    "%s : %s",
                    this.messages[i].getUtilisateur().getPseudonyme(),
                    this.messages[i].getContent()
            );
        }
    }

    /**
     * Question 3.7
     * Méthode permet d'exclure un utilisateur du salon. L'utilisateur sera donc supprimé
     * du tableau des utilisateurs et ses messages sera aussi supprimés
     *
     * @param u est un utilisateur que nous voulons exclure de salon.
     */
    public void exclusUtilisateur(Utilisateur u) {
        // Nous ne pouvons pas exclure un utilisateur null.
        // Ainsi nous ne pouvons pas exclure un utilisateur qui n'est pas dans le salon
        if (!estPresent(u) || u == null) {
            return;
        }
        // Nous initialisons une variable counter pour compter les utilisateur différents que l'utilisateur u
        int counter = 0;
        // Comme nous allons exclure un utilisateur, la taille de tableau utilisateur va décrémenter de 1.
        Utilisateur[] nUtilisateurs = new Utilisateur[this.utilisateurs.length - 1];

        //Nous regardons chaque utilisateur du Salon, sauf utilisateur qui est identique au m, nous allons remettre
        //dans le nouveau tableau nUtilisateurs.
        for (int i = 0; i < this.utilisateurs.length; i++) {
            if (this.utilisateurs[i].equals(u)) {
                // si utilisateur est identique au u, nous passons à l'élément suivant.
                continue;
            }
            nUtilisateurs[counter] = this.utilisateurs[i];
            counter++;
        }
        this.utilisateurs = nUtilisateurs;
        /*
            Nous réinitialisons la valeur du counter pour compter les messages pour créer le tableau des messages dont
            lesquelles nous avons exclu les message de l'utilisateur u
         */
        counter = 0;
        for (int i = 0; i < this.messages.length; i++) {
            if (this.messages[i].getUtilisateur().equals(u)) {
                counter++;
            }
        }
        Message[] nmessages = new Message[this.messages.length - counter];
        // Nous réinitialisons la valeur du counter pour compter à nouveau les messages
        counter = 0;
        for (int i = 0; i < this.messages.length; i++) {
            if (this.messages[i].getUtilisateur().equals(u)) {
                continue;
            }
            nmessages[counter] = this.messages[i];
            counter++;
        }
    }

}
