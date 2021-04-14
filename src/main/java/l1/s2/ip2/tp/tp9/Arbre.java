package l1.s2.ip2.tp.tp9;

public class Arbre {
    private Noeud sommet;
    public Arbre(Noeud sommet){
        this.sommet = sommet;
    }

    public Arbre(){
       this.sommet = null;
    }

    public Arbre(Arbre a){
        if(a.sommet == null){
           this.sommet = null;
           return;
        }
        this.sommet = new Noeud(a.sommet);
    }

    public Arbre(int[] tab){
        for
    }

    //getters et setters
    public Noeud getSommet(){
        return this.sommet;
    }
    public void setSommet(Noeud n){
        this.sommet = n;
    }

    /**
     * Exercice 1.1:
     * Une méthode qui permettent d’afficher un arbre dans l’ordre infixe.
     */
    public void afficheInfixe(){
        if(this.sommet == null){
            System.out.print("vide");
            return;
        }
        this.sommet.afficheInfixe();
        System.out.println("");
    }

    /**
     * Exercice 1.3
     * Une méthode qui permettent d’afficher un arbre dans l’ordre suffixe.
     */
    public void afficheSuffixe(){
        if(this.sommet == null){
            System.out.println("vide");
            return;
        }
        this.sommet.afficheSuffixe();
        System.out.println("");
    }

    /**
     * Exercice 1.4
     * @return le nombre de nœuds d’un arbre
     */
    public int nbDeNoeuds(){
        if(this.sommet == null){
            return 0;
        }
        return this.sommet.nbDeNoeuds();
    }

    /**
     * Exercice 1.5
     * @return la somme des étiquettes d’un arbre.
     */
    public int somme(){
        if(this.sommet == null){
            return 0;
        }
        return this.sommet.somme();
    }

    /**
     * Exercice 1.6
     * @return la profondeur d’un arbre
     */
    public int profondeur(){
        if(this.sommet == null){
            return 0;
        }
        return this.sommet.profondeur();
    }

    /**
     * Exercice 1.7
     * @param e le noeud que nous cherchons dans l'arbre
     * @return true si le noeud est existe, false sinon
     */
    public boolean recherche(int e){
        if(this.sommet == null){
            return false;
        }
        return this.sommet.recherche(e);
    }
}
