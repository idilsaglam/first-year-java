package l1.s2.revision.partiel;

public class Cellule {
    private Cellule suivante;
    private int nb;

    public void setSuivante(Cellule s){
        this.suivante = s;
    }

    public Cellule getSuivante(){
        return this.suivante;
    }
    public Cellule(int nb){
        this.nb = nb;
        this.suivante = null;
    }

    public Cellule(int nb,Cellule c){
        this.nb = nb;
        this.suivante = c;
    }



    @Override
    public String toString(){
        return String.format("%s %s", this.nb, this.suivante == null ? "" : this.suivante.toString());
    }
}
