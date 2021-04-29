package l1.s2.ip2.tp.tp10;

import java.util.LinkedList;

public class Noeud {
    private int etiquette;
    private Noeud gauche;
    private Noeud droit;


    public Noeud(int etiquette, Noeud g, Noeud d){
        this.etiquette = etiquette;
        this.gauche = g;
        this.droit = d;
    }

    public Noeud(int etiquette){
        this(etiquette,null,null);
    }

    public Noeud(Noeud noeud){
        this(noeud.etiquette);
        if(noeud.gauche != null){
            this.gauche = new Noeud(noeud.gauche);
        }
        if(noeud.droit != null){
            this.droit = new Noeud(noeud.droit);
        }
    }

    //getters et setters
    public int getEtiquette(){
        return this.etiquette;
    }

    public Noeud getDroit() {
        return droit;
    }

    public Noeud getGauche() {
        return gauche;
    }

    public void setDroit(Noeud droit) {
        this.droit = droit;
    }

    public void setEtiquette(int etiquette) {
        this.etiquette = etiquette;
    }

    public void setGauche(Noeud gauche) {
        this.gauche = gauche;
    }

    /**
     * Exercice 1.1:
     * Une méthode qui permettent d’afficher un arbre dans l’ordre infixe.
     */
    public void afficheInfixe(){
        if(this.gauche != null) {
            this.gauche.afficheInfixe();
        }
        System.out.print(this.etiquette + " ");
        if(this.droit != null){
            this.droit.afficheInfixe();
        }
    }

    /**
     * Exercice 1.3
     * Une méthode qui permettent d’afficher un arbre dans l’ordre suffixe.
     */
    public void afficheSuffixe(){
        if(this.gauche != null){
            this.gauche.afficheSuffixe();
        }
        if(this.droit != null){
            this.droit.afficheSuffixe();
        }
        System.out.print(this.etiquette + " ");
    }

    /**
     * Exercice 1.4
     * @return le nombre de nœuds d’un arbre
     */
    public int nbDeNoeuds(){
        int result = 1;
        if(this.gauche != null){
            result += this.gauche.nbDeNoeuds();
        }
        if(this.droit != null){
            result += this.droit.nbDeNoeuds();
        }
        return result;

    }

    /**
     * Exercice 1.5
     * @return la somme des étiquettes d’un arbre.
     */
    public int somme(){
      int res =  0;
      res+= this.etiquette;
      if(this.gauche != null){
          res+= this.gauche.somme();
      }
      if(this.droit != null){
          res+= this.droit.somme();
      }
      return res;
    }

    /**
     * @return true si le noeud est un feuille, sinon false
     */
    public boolean estFeuille(){
        return ((this.gauche == null) && (this.droit == null));
    }

    /**
     * Exercice 1.6
     * @return la profondeur d’un arbre
     */
    public int profondeur(){
        if(estFeuille()){
            return 1;
        }
        int result=0;
        if(this.gauche != null){
            result= this.gauche.profondeur();
        }
        if(this.droit != null){
            int t = this.droit.profondeur();
            if (t > result) {
                result = t;
            }
        }
        return 1+result;
    }

    /**
     * Exercice 1.7
     * @param e le noeud que nous cherchons dans l'arbre
     * @return true si le noeud est existe, false sinon
     */

    public boolean recherche(int e){
        boolean res = false;
        if(this.etiquette == e){
            return true;
        }
        if(this.droit != null){
            res = this.droit.recherche(e);
        }
        if(res){
            return res;
        }
        if(this.gauche != null){
            res = this.gauche.recherche(e);
        }
        return (res) ;
    }

    // ************************************ TP10 *******************************

    /**
     * Exercice 2a
     * Une méthode qui affiche n espaces
     */
    public void espaces(int n){
        String s = "";
        for(int i=0; i<n; i++){
            s += "\s";
        }
        System.out.print(s);
    }

    /**
     * Exercice 2b
     * Une méthode qui fait affichage du sous arbre issu du noeud courant
     * @param p profondeur
     */
    public void affiche(int p){
        if (this.droit != null) {
            this.droit.affiche(p+1);
        }
        this.espaces(p);
        System.out.println(this.etiquette);
        if (this.gauche != null) {
            this.gauche.affiche(p+1);
        }
    }


    public void affichageEnLargeur() {
        LinkedList<Noeud> l = new LinkedList<Noeud>();
        l.offer(this);
        do {
            Noeud e = l.poll();
            if (e != null) {
                System.out.print(e.etiquette);
                l.offer(e.gauche);
                l.offer(e.droit);
            }
        } while (!l.isEmpty());
    }

    public void affichageLargeurBis() {
        LinkedList<Paire> l = new LinkedList<Paire>();
        l.offer(new Paire(this));
        Paire buffer = null;
        do {
            Paire e = l.poll();
            if (buffer != null && buffer.getValue() != e.getValue()) {
                System.out.println();
            }
            buffer = e;
            if (e != null) {
                int v = e.getValue() - 1;
                if (e.getNode() == null) {
                    System.out.print(" ");
                } else {
                    if (e.getNode().gauche == null) {
                        System.out.print("");
                    } else {
                        System.out.print(" ".repeat(e.getNode().gauche.nbNodes()));
                    }
                }

                if (e.getNode() != null) {
                    System.out.print(e.getNode().etiquette + " ".repeat((e.getNode().droit != null ? e.getNode().droit.nbNodes() : 0) + 1));
                    l.offer(new Paire(v,e.getNode().gauche));
                    l.offer(new Paire(v,e.getNode().droit));
                }

            }
        } while (!l.isEmpty());
    }

    public int nbNodes() {
        int result = 1;
        if (this.gauche != null) {
            result += this.gauche.nbNodes();
        }
        if (this.droit != null) {
            result += this.droit.nbNodes();
        }
        return result;
    }

    public int hauteur() {
        int result = 0;
        if (this.droit != null) {
            result += this.droit.hauteur();
        }
        if (this.gauche != null) {
            int a = this.gauche.hauteur();
            if (result < a) {
                result = a;
            }
        }
        return result + 1;
    }

}
