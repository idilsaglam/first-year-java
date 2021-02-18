public class Utilisateur{
private String pseudo;
private String motDePasse;
private final String adresseMail;

Utilisateur(String pseudo, String motDePasse, String adresseMail){
    this.pseudo = pseudo;
    this.motDePasse = motDePasse;
    this.adresseMail = adresseMail;
}
public boolean testMotDePasse(String m){
    return(this.motDePasse.equals(m));
}

public void changeMotDePasse(String mo, String m){
    if(testMotDePasse(mo)){
        this.motDePasse = m;
    }
    return;
}

public String getPseudonyme(){
    return this.pseudo;
}

public void setPseudonyme(String s){
    this.pseudo = s;
}

@Override
public boolean equals(Object o){
    if(o instanceof Utilisateur){
        Utilisateur u = (Utilisateur)o;
        return(
            this.pseudo.equals(u.pseudo) &&
            this.motDePasse == u.motDePasse &&
            this.adresseMail.equals(u.adresseMail));
    }
    return false;
}

}