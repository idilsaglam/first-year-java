package l1.s2.ip2.td.td3;

public class Client {
    private String nom;
    private String prenom;

    Client(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    @Override
    public String toString(){
        return this.prenom + " "+ this.nom;
    }


}
