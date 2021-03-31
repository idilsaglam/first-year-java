package l1.s2.ip2.td.td8;

public class Enfant {
    private final String nom;
    private int nombre;

    public String getNom(){
        return this.nom;
    }

   public int getNombre(){
        return this.nombre;
   }
   public void setNombre(int n){this.nombre = n;}
    public Enfant(String nom,int nombre){
        this.nom = nom;
        this.nombre = nombre;
    }
    public void affiche(){
        System.out.println(this.nom + " " + this.nombre);
    }
}
