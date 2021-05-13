package l1.s2.revision.td10;

public class Arbre {
    private Noeud racine;
    public Arbre(){
        this.racine = null;
    }
    public Arbre(Noeud n){
        this.racine = n;
    }

    public void bourgeons(){
        if(this.racine == null){
            return;
        }
        this.racine.bourgeons();
    }

    public Arbre sousArbreRec(String chemin) {
        if(this.racine == null){
            return null;
        }

        return new Arbre(this.racine.sousArbreRec(chemin));
    }}
