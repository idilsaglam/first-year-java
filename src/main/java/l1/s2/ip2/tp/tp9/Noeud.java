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

    //Ex 1.3
    public void afficheInfixe(){
        if(this.gauche != null) {
            this.gauche.afficheInfixe();
        }
        System.out.print(this.etiquette + " ");
        if(this.droit != null){
            this.droit.afficheInfixe();
        }
    }

    //Ex 1.3
    //TODO
    public void afficheSuffixe(){
        if(this.gauche != null){
            this.gauche.afficheSuffixe();
        }
        if(this.droit != null){
            this.droit.afficheSuffixe();
        }
        System.out.print(this.etiquette + " ");
    }

    // Ex 1.4
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
    //TODO:

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

    public boolean estFeuille(){
        return ((this.gauche == null) && (this.droit == null));
    }
    public int profondeur(){
        if(estFeuille()){
            return 1;
        }
        int hg=0;
        int hd=0;
        if(this.gauche != null){
            hg= this.gauche.profondeur();
        }
        if(this.droit != null){
            hg = this.droit.profondeur();
        }
        return 1+Math.max(hg,hd);
    }

    public boolean recherche(int e){
        if(this.etiquette == e){
            return true;
        }
        if(this.droit != null){
            this.droit.recherche(e);
        }
        if(this.gauche != null){
            this.gauche.recherche(e);
        }
        return false;
    }
}
