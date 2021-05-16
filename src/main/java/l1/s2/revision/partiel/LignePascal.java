package l1.s2.revision.partiel;

public class LignePascal {
    private static int COUNTER = -1;
    private Cellule premier;
    private final int NbLigne;

    public LignePascal(){
        LignePascal.COUNTER++;
        this.NbLigne = LignePascal.COUNTER;
        this.premier=null;
    }
    public LignePascal(Cellule cellule){
        LignePascal.COUNTER++;
        this.NbLigne = LignePascal.COUNTER;
        this.premier=cellule;
    }

    public int getNbLigne(){
        return this.NbLigne;
    }

    public Cellule getPremier(){
        return this.premier;
    }

    public void setPremier(Cellule cellule){
        this.premier = cellule;
    }

    //TODO
    public void buildNextLine(){
        Cellule c = this.premier;
        this.setPremier(new Cellule(1));
        this.premier.setSuivante(c);
    }




}