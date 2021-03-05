package l1.s2.ip2.tp.tp3;

public class Chat {
    //Question 4.1
    private Salon[] salons;

    Chat(){
        this.salons = new Salon[0];
    }

    /**
     * Question 4.1
     * Méthode permet d'ajouter un salon au chat
     * @param salon est un salon que nous voulons ajouter au chat.
     */
    public void ajouterSalon(Salon salon){
        //Nous ne pouvons pas ajouter un salon null.s
        if(salon == null){
            return;
        }
        /*
         * Après avoir ajouté un salon, la taille de tableau salons va augmenter 1. C'est pour cela que nous créons un
         * nouveau tableau de taille this.salons.length+1.
         */
        Salon[] nSalon = new Salon[this.salons.length+1];

        /*
         * D'abord, on va ajouter des salons qui étaient déjà dans le salon au nouveau tableau nSalon
         */
        for(int i=0; i<this.salons.length; i++){
            nSalon[i] = this.salons[i];
        }
        // Après on initialise le dernier élément du nSalon avec salon qui est donnée comme argument.
        nSalon[nSalon.length-1] = salon;
        this.salons = nSalon;
    }

    /**
     * Question 4.2
     *
     * @param u est un utilisateur que nous voulons regarder s'il est présent dans un des salons du chat.
     * @return true si u est présent l'un des salons du chat sinon false.
     */
    public boolean estPresent(Utilisateur u){
        //Un utilisateur null ne sera pas présent.
        if(u == null){
            return false;
        }
        /*
         * Nous regardons chaque salons et vérifier si utilisateur u est dans le salon actuel.
         */
        for(int i=0; i<this.salons.length; i++){
            if(this.salons[i].estPresent(u)){
                return true;
            }
        }
        return false;
    }

    /**
     * Question 4.3
     * @param u est un Utilisateur que nous voulons le nombre total de messages.
     * @return le nombre total de messages d'utilisateur u
     */
    public int nombreMessages(Utilisateur u){
        // Comme un utilisateur null ne peut pas avoir un message il faut retourner 0.
        if(u == null){
            return 0;
        }
        /**
         * Nous regardons chaque salon, et dans chaque salons nous regardons chaque messages. Si l'utilisateur d'un
         * message est le meme avec u, nous allons modifier la valeur nb par incrémenter 1.
         */
        int nb = 0;
        for(int i=0; i<this.salons.length; i++){
            for(int j=0; j<this.salons[i].messages.length; j++){
                if(salons[i].messages[j].getUtilisateur().equals(u)){
                    nb++;
                }
            }
        }
        return nb;
    }

    /**
     * Question 4.5
     * @return l'utilisateur qui a plus de messages sur les salons au total.
     */
    public Utilisateur bavarde() {

        // Le tableau uniqueUsers représente les utilisateurs uniques
        Utilisateur[] uniqueUsers = new Utilisateur[0];
        // La variable nbUniqueUtilisateur représente le nombre d'utilisateurs unique

        for(int i=0; i<this.salons.length; i++){
            for(int j=0; j<this.salons[i].utilisateurs.length; j++){
                int g = 0;
                // Nous vérifions d'abord si l'utilisateur existe dans le tableau uniqueUsers
                for(g=0; g < uniqueUsers.length; g++){
                    if (this.salons[i].utilisateurs[j].equals(uniqueUsers[g])) {
                        /*
                         * Si l'utilisateur existe déjà dans le tableau des utilisateurs unique
                         *  nous quittons cette boucle
                         */
                        break;
                    }
                }
                if (g == uniqueUsers.length) {
                    /*
                     * Si la valeur de g est égale au nombre d'utilisateurs unique
                     * C'est à dire que l'utilisateur n'existe pas dans le tableau uniqueUsers
                    */
                    Utilisateur[] nUtililisateurs = new Utilisateur[uniqueUsers.length + 1];
                    for (int w = 0; w < uniqueUsers.length; w++) {
                        nUtililisateurs[w] = uniqueUsers[w];
                    }
                    nUtililisateurs[nUtililisateurs.length - 1] = this.salons[i].utilisateurs[j];
                    uniqueUsers = nUtililisateurs;
                }
            }
        }

        // Nous déclarons un second tableau pour conserver le nombre total des messages par chaque unique utilisateur
        int[] nMessages = new int[uniqueUsers.length];

        // Nous parcourons tous les messages de tous les salons
        for(int i=0; i<this.salons.length; i++){
            for(int j=0; j<this.salons[i].messages.length; j++) {
                Message message = this.salons[i].messages[j];
                int k = 0;
                for (k=0; k< uniqueUsers.length; k++) {
                    if (uniqueUsers[k].equals(message.getUtilisateur())) {
                        /*
                         * Quand on trouve l'utilisateur émis cette message
                         * nous arrêtons la recherche
                         */
                        break;
                    }
                }
                // Nous incrémentons le nombre total de message de l'utilisateur de 1
                nMessages[k]++;
            }
        }

        // Nous parcourons le tableau nMessages pour récupérer l'index de l'élément maximum
        int maxValue = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i<nMessages.length; i++) {
            if (maxValue < nMessages[i]) {
                maxIndex = i;
                maxValue = nMessages[i];
            }
        }
        /*
         * Nous retournons null si maxIndex est égale à -1 (dans le cas il n'y a aucun uti^^lisateur dans les salons)
         * sinon nous retournons l'utilisateur à l'index maxIndex du tableau uniqueUsers.
         */
        return (maxIndex == -1 ? null : uniqueUsers[maxIndex]);

    }


}
