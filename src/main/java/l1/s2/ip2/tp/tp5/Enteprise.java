package l1.s2.ip2.tp.tp5;

public class Enteprise {
    private String nom;
    private Cellule premier;

    public Enteprise(String nom, Cellule premier){
        this.nom = nom;
        this.premier = premier;
    }

    //getters et setters
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setPremier(Cellule cellule){
        this.premier = cellule;
    }
    public String getNom(){
        return this.nom;
    }
    public Cellule getPremier(){
        return this.premier;
    }

    public void afficher(){
        if(this.premier == null) {
            return;
        }
        this.premier.afficheRec();
    }

    public boolean appartient(String n) {
        if (this.premier == null) {
            return false;
        }
        return this.premier.appartient(n);
    }

    public void ajouteEnTete(Cellule c){
        if(this.premier == null){
            this.setPremier(c);
            return;
        }
        if(appartient(c.getEmp().getNom())){
            return;
        }
        Cellule tmp = this.premier;
        this.setPremier(c);
        c.setSuivante(tmp);
    }

    public void demission(String n){
        if(this.premier == null){
            return;
        }

        if(this.premier.getEmp().getNom().equals(n)){
            this.setPremier(this.premier.getSuivant());
            return;
        }

        this.premier.demission(n);
    }

    public boolean augmente(String nom,int montant){
        if(this.premier == null){
            return false;
        }
        if(!appartient("nom")){
            return false;
        }
       return this.premier.augmente(nom,montant);
    }

    public Enteprise choixSalaire(int min, int max){
        if(this.premier == null){
            return null;
        }
        return this.premier.choixSalaire(min,max);
    }

    public boolean croissante(){
        if(this.premier == null){
            return false;
        }
        return this.premier.croissante();
    }

    public void ajout(Employe employe){
        if(this.premier == null){
            this.premier = new Cellule(employe,null);
            return;
        }
        this.premier.ajout(employe);
    }

}
