package l1.s2.ip2.tp.tp9;

public class Noeud {
    private int etiquette;
    private Noeud gauche;
    private Noeud droit;

    public Noeud (int etiquette, Noeud g, Noeud d){
        this.etiquette = etiquette;
        this.gauche = g;
        this.droit = d;
    }

    public Noeud(int etiquette){
        this(etiquette,null,null);
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

    public void copier(Arbre a){
        Arbre a = new Arbre(a.getSommet());
        if(this.gauche != null){
            this.gauche = a.getSommet().gauche;
        }
        if(this.droit != null){
            this.droit = a.getSommet().droit;
        }
    }
}
