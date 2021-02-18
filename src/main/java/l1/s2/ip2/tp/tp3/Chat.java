public class Chat {
    // TODO: Use keywords public/private/protected !
    Salon[] salons;
    // TODO: Avoid empty constructors
    Chat(){
    }

    public void ajouterSalon(Salon salon){
        // TODO: What happens if salon==null ?
        Salon[] nSalon = new Salon[this.salons.length+1];
        for(int i=0; i<this.salons.length; i++){
            nSalon[i] = this.salons[i];
        }
        nSalon[nSalon.length-1] = salon;
        this.salons = nSalon;
    }

    public boolean estPresent(Utilisateur u){
        // TODO: What happens if u==null ?
        for(int i=0; i<this.salons.length; i++){
            if(this.salons[i].estPresent(u)){
                return true;
            }
        }
        return false;
    }

    public int nombreMessages(Utilisateur u){
        // TODO: What happens if u==null ?
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

    public Utilisateur bavarde(){
        int nb = 0;
        int index = -1;
        
    }
}
