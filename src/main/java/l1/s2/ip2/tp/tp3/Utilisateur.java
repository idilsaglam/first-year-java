package l1.s2.ip2.tp.tp3;

import jdk.jshell.execution.Util;

public class Utilisateur {
    private String pseudo;
    private String motDePasse;
    private final String adresseMail;

    //Constructeur
    Utilisateur(String pseudo, String motDePasse, String adresseMail){
        this.adresseMail = adresseMail;
        this.motDePasse = motDePasse;
        this.pseudo = pseudo;
    }
    public boolean testMotDePasse(String s){
        return(s.equals(motDePasse));
    }
    public void changerMotDePasse(String motDePasse,String nouveauMotDePasse){
        if(testMotDePasse(motDePasse)){
            this.motDePasse = nouveauMotDePasse;
        }else {
            System.out.println("Wrong password");
        }
    }

    public String getPseudo(){
        return this.pseudo;
    }
    public void setPseudo(String pseudo){
        this.pseudo = pseudo;
    }


}
