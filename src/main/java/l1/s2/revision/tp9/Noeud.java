package l1.s2.revision.tp9;

import java.util.Stack;

public class Noeud {
    private int etiquette;
    private Noeud gauche;
    private Noeud droit;

    public Noeud(int etiquette, Noeud g,Noeud d){
        this.etiquette = etiquette;
        this.gauche = g;
        this.droit = d;
    }

    public Noeud(int etiquette){
        this(etiquette,null,null);
    }
    // getter et setters

    public void setGauche(Noeud gauche) {
        this.gauche = gauche;
    }

    public void setEtiquette(int etiquette) {
        this.etiquette = etiquette;
    }

    public void setDroit(Noeud droit) {
        this.droit = droit;
    }

    public Noeud getGauche() {
        return gauche;
    }

    public Noeud getDroit() {
        return droit;
    }

    public int getEtiquette() {
        return etiquette;
    }

    public void afficheInfixe(){
        if(this.gauche != null){
            this.gauche.afficheInfixe();
        }
        System.out.print(this.etiquette+" ");
        if(this.droit != null){
            this.droit.afficheInfixe();
        }
    }

    public void afficheSuffixe(){
        if(this.gauche != null){
            this.gauche.afficheSuffixe();
        }
        if(this.droit!=null){
            this.droit.afficheSuffixe();
        }
        System.out.print(this.etiquette+"\s");
    }

    public void affichePrefixe(){
        System.out.print(this.etiquette+"\s");
        if(this.gauche != null){
            this.gauche.affichePrefixe();
        }
        if(this.droit!=null){
            this.droit.affichePrefixe();
        }
    }

    public int nbDeNoeuds(){
        int nd=0, ng=0;
        if(this.gauche!=null){
            ng = this.gauche.nbDeNoeuds();
        }
        if(this.droit!=null){
            nd =this.droit.nbDeNoeuds();
        }
        return 1+nd+ng;
    }

    public int somme(){
        int somme=this.etiquette;
        if(this.gauche!=null){
            somme+= this.gauche.somme();
        }
        if(this.droit!=null){
            somme+=this.droit.somme();
        }
        return somme;
    }

    //TODO
    public int profondeur(){
        int nG=0,nD=0;
        if(this.gauche!=null){
            nG=this.gauche.profondeur();
        }
        if(this.droit!=null){
            nD=this.droit.profondeur();
        }
        return 1+Math.max(nG,nD);
    }

    public boolean recherche(int e){
        if(this.etiquette==e){
            return true;
        }
        boolean bg=false,bd=false;
        if(this.gauche!=null){
            bg=this.gauche.recherche(e);
        }
        if(this.droit!=null){
            bd=this.droit.recherche(e);
        }
        return bg||bd;
    }

    //TODO: ex 8,9

    public Noeud copie()  {
        if(this.gauche==null && this.droit==null){
            return new Noeud(this.etiquette);
        }
        Noeud g = null, d = null;
        if(this.gauche != null){
            g=this.gauche.copie();
        }
        if(this.droit!=null){
            d=this.droit.copie();
        }
        return new Noeud(this.etiquette,g,d);
    }

    // *************************TP10******************************

    public void espace(int n){
        System.out.print(" ".repeat(n));
    }

    public void affiche(int p){
        if(this.droit!=null){
            this.droit.affiche(p+1); // sag icin profondeur 1 fazla
        }
        espace(p);
        System.out.println(this.etiquette);
        if(this.gauche!=null){
            this.gauche.affiche(p+1);
        }
    }}



    //TODO 2 SEKILLI CIKARMA








