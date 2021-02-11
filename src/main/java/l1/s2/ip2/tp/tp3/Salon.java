package l1.s2.ip2.tp.tp3;

public class Salon {
    Utilisateur[] utilisateurs;
    Message[] messages;

    Salon(Utilisateur[] utilisateurs){
        this.utilisateurs = utilisateurs;
    }

    public void ajouterUtilisateur(Utilisateur u){
        Utilisateur[] ajouteUtilisateurs = new Utilisateur[this.utilisateurs.length+1];
        for(int i=0; i<this.utilisateurs.length; i++){
            ajouteUtilisateurs[i] = this.utilisateurs[i];
        }
        ajouteUtilisateurs[this.utilisateurs.length+1] = u;
        this.utilisateurs = ajouteUtilisateurs;
    }

    public boolean estPresent(Utilisateur u){
        for(int i=0; i<this.utilisateurs.length; i++){
            if(this.utilisateurs[i].getPseudo().equals(u.getPseudo())){
                return true;
            }
        }
        return false;
    }

    public void ajouterMessage(Message message){
        if(estPresent(message.utilisateur)){
            Message[] updatedMessage = new Message[this.messages.length+1];
            for(int i=0; i<this.messages.length; i++){
                updatedMessage[i] = this.messages[i];
            }
            updatedMessage[this.messages.length+1] = message;
            this.messages =updatedMessage;
        }
    }

    public void afficher(){
        for(int i=0; i<messages.length; i++){
            System.out.println(
                    messages[i].utilisateur + ":" + messages[i].message
            );
        }
    }

}
