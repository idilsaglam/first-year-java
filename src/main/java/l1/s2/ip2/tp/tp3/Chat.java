package l1.s2.ip2.tp.tp3;

import javax.swing.text.StyleContext;

public class Chat {
    //Question 4.1
    private Salon[] salons;

    Chat(){
        this.salons = new Salon[Integer.MAX_VALUE];
    }

    /**
     * Question 4.1
     * @param salon est un salon que nous voulons ajouter au chat.
     */
    public void ajouterSalon(Salon salon){
        //Nous ne pouvons pas ajouter un salon null.s
        if(salon == null){
            return;
        }
        /**
         * Après avoir ajouté un salon, la taille de tableau salons va augmenter 1. C'est pour cela que nous créons un
         * nouveau tableau de taille this.salons.length+1.
         */
        Salon[] nSalon = new Salon[this.salons.length+1];

        /**
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
     * @param u est un utilisateur que nous voulons regarder s'il est présent dans un des salons du chat.
     * @return true si u est présent l'un des salons du chat sinon false.
     */

    public boolean estPresent(Utilisateur u){
        //Un utilisateur null ne sera pas présent.
        if(u == null){
            return false;
        }
        /**
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
                if(salons[i].messages[j].u.equals(u)){
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
    //public Utilisateur bavarde(){



}
