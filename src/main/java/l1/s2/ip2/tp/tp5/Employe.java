package l1.s2.ip2.tp.tp5;

public class Employe {
    private final String nom;
    private int salarie;

    public Employe(String nom, int salarie){
        this.nom = nom;
        this.salarie = salarie;
    }

    //getters et setters
    public int getSalarie(){
        return this.salarie;
    }
    public void setSalarie(int salarie){
        this.salarie = salarie;
    }

    public String getNom(){
        return this.nom;
    }

    public void affiche(){
        System.out.printf("Nom de l'employé est %s et son salarie est %d\n",this.nom,this.salarie);
    }
}
