package l1.s2.ip2.td.td8;

public class Enfant {
    private String nom;
    private int nombre; //nb de fois où ils ont utilisé un toboggan.

    public Enfant(String nom, int nombre){
        this.nom = nom;
        this.nombre = nombre;
    }

    //getter et setters
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setNombre(int nombre){
        this.nombre = nombre;
    }

    public String getNom(){
        return this.nom;
    }

    public int getNombre(){
        return this.nombre;
    }

    public void affiche(){
        System.out.println(this.nom +"\s"+this.nombre);
    }
}