package l1.s2.ip2.td.td8;

public class FileToboggan {
    private Cellule courantCellule;
    private Enfant courant; //l'enfant qui est en train de glisser
    private int nbMax; // nombre max de fois quun enfant peut glisser

    public FileToboggan(int nbMax){
        this.nbMax = nbMax;
        this.courant = null;
    }

    //Accesseurs
    public void setCourant(Enfant e){
        this.courant = e;
    }

    public void ajouter(String nom, int nb){
        Enfant e = new Enfant(nom);
        if(this.courant == null){
            this.setCourant(e);
            return;
        }
        this.courantCellule.setSuivante(e)

    }

}
