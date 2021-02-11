package l1.s2.ip2.td.td3;

import java.io.File;

public class Article {
    private static int COUNTER = 0;
    final String description;
    Client client;
    FileDAttente file;
    final int identifiant;

    Article(String description){
        this.description = description;
        this.file = new FileDAttente(new Client[]{});
        COUNTER++;
        this.identifiant= COUNTER;
        this.client = null;
    }
    public void ajouterAuPanierDe(Client client){
        if(this.client != null){
            this.client = client;
        }else{
            this.file.ajouterClient(client);
        }
    }
    public void retirerDuPanier(Client client){
        if(this.client == client){
            this.client = null;
        }else{
            this.file.desiste(client);
        }
    }

}
