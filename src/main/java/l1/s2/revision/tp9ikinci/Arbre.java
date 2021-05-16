package l1.s2.revision.tp9ikinci;

public class Arbre {
    private Noeud sommet;

    public Arbre(Noeud sommet){
        this.sommet = sommet;
    }

    public Arbre(){
        this(null);
    }

    public void afficheInfixe(){
        if(this.sommet==null){
            return;
        }
        this.sommet.afficheInfixe();
    }
    public void afficheSuffixe(){
        if(this.sommet==null){
            return;
        }
        this.sommet.afficheSuffixe();
    }
    public void affichePrefixe(){
        if(this.sommet==null){
            return;
        }
        this.sommet.affichePrefixe();
    }
    public int nbDeNoeuds(){
        if(this.sommet == null){
           return 0;
        }
        return this.sommet.nbDeNoeuds();
    }
    public int somme(){
        if(this.sommet==null){
            return 0;
        }
        return this.sommet.somme();
    }

    public int profondeur(){
        if(this.sommet== null){
            return 0;
        }
        return this.sommet.profondeur();
    }

    public boolean recherche(int e){
        if(this.sommet == null){
            return false;
        }
        return this.sommet.recherche(e);
    }

}
