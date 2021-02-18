public class Salon {
    Utilisateur[] utilisateurs;
    Message[] messages;

    Salon(Utilisateur[] utilisateurs){
        this.utilisateurs = utilisateurs;
    }

    public void ajouterUtilisateur(Utilisateur u){
        // TODO: What happen if user already exists in the room ?
        // TODO: What happens if u==null ?
        Utilisateur[] newU = new Utilisateur[this.utilisateurs.length+1];
        for(int i=0; i<this.utilisateurs.length; i++){
            newU[i] = this.utilisateurs[i];
        }
        newU[newU.length-1] = u;
        this.utilisateurs = newU;
    }

    public boolean estPresent(Utilisateur u){
        // TODO: What happens if u==null ?
        for(int i=0; i<this.utilisateurs.length; i++){
            // FIXME: == won't work need to use .equals instead
            if(this.utilisateurs[i] == u){
                return true;
            }
        }
        return false;
    }

    public void ajouterMessage(Message m){
        // TODO: What happen if message already exists in the room ?
        // TODO: What happens if m==null ?
        if(estPresent(m.u)){
            Message[] newM = new Message[this.messages.length+1];
            for(int i=0; i<this.messages.length; i++){
                newM[i] = this.messages[i];
            }
            newM[newM.length-1] = m;
            this.messages = newM;
        }
    }

    public void afficher(){
        for(int i=0; i<this.messages.length; i++){
            // TODO: System.out.printf
            System.out.println(
                this.messages[i].u.getPseudonyme() +
                ": " +
                this.messages[i].context
            );
        }
    }
    
    public void exclusUtilisateur(Utilisateur u){
        // TODO: What happens if u==null ?
        int counter = 0;
        Utilisateur[] nUtilisateurs = new Utilisateur[this.utilisateurs.length-1];
        for(int i=0; i<this.utilisateurs.length; i++){
            if(this.utilisateurs[i].equals(u)) {
                continue;
            }
            nUtilisateurs[counter] = this.utilisateurs[i];
            counter++;
        }
        this.utilisateurs = nUtilisateurs;
        // FIXME: You need to delete all messages associated to this user
    }

}
