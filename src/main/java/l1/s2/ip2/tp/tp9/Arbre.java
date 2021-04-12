package l1.s2.ip2.tp.tp9;

public class Arbre {
    private Noeud sommet;
    public Arbre(Noeud sommet){
        this.sommet = sommet;
    }

    public Arbre(){
        this(null);
    }



    //getters et setters
    public Noeud getSommet(){
        return this.sommet;
    }
    public void setSommet(Noeud n){
        this.sommet = n;
    }

    public void afficheInfixe(){
        if(this.sommet == null){
            System.out.print("vide");
            return;
        }
        this.sommet.afficheInfixe();
        System.out.println("");
    }

    public void afficheSuffixe(){
        if(this.sommet == null){
            System.out.println("vide");
            return;
        }
        this.sommet.afficheSuffixe();
        System.out.println("");
    }

    public int nbDeNoeuds(){
        if(this.sommet == null){
            return 0;
        }
        return this.sommet.nbDeNoeuds();
    }

    public int somme(){
        if(this.sommet == null){
            return 0;
        }
        return this.sommet.somme();
    }

    public int profondeur(){
        if(this.sommet == null){
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
