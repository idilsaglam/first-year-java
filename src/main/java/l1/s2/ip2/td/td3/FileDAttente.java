package l1.s2.ip2.td.td3;

import java.awt.color.CMMException;

public class FileDAttente {
    Client[] ClientsPossibles;

    FileDAttente(Client[] clients){
    this.ClientsPossibles = clients;
    }

    public int getTaille(){
        return this.ClientsPossibles.length;
    }

    public void ajouterClient(Client c){
        for(int i=0; i<this.ClientsPossibles.length; i++){
            if (this.ClientsPossibles[i].equals(c)) {
                return;
            }
        }
        Client[] newClientPossibles = new Client[this.ClientsPossibles.length+1];

        for(int i=0; i<newClientPossibles.length-1; i++){
            newClientPossibles[i] = this.ClientsPossibles[i];
        }
        newClientPossibles[newClientPossibles.length-1] = c;
        this.ClientsPossibles = newClientPossibles;
    }

    public void desiste(Client c){
        Client[] deleteClientPossibles = new Client[this.ClientsPossibles.length-1];
        for(int i=0; i<deleteClientPossibles.length; i++){
            if (this.ClientsPossibles[i].equals(c)) {
                continue;
            }
            deleteClientPossibles[i] = this.ClientsPossibles[i];
            this.ClientsPossibles = deleteClientPossibles;
        }
    }

    public Client extraitPremier(){
        return this.ClientsPossibles[0];
    }

    public void afficher(){
        for(int i=0; i<ClientsPossibles.length; i++){
            System.out.print(i+1 + "." + ClientsPossibles[i].toString());
        }
    }


}
