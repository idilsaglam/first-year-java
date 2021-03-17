package l1.s2.ip2.tp.tp5;

public class Employe {
    private final String nom;
    private int salarie;

    public Employe(String nom, int salarie) {
        this.nom = nom;
        this.salarie = salarie;
    }

    public int getSalarie() {
        return this.salarie;
    }

    public String getNom(){
        return this.nom;
    }

    public void setSalarie(int n){
        this.salarie = n;
    }

    @Override
    public String toString(){
        return String.format("Nom de l'employé(e) : %s , salaire : %d", this.getNom(), this.getSalarie());
    }
}
