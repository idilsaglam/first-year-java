package l1.s2.revision.tp9ikinci;

import javax.swing.*;

public class Noeud {
    private int etiquette;
    private Noeud gauche;
    private Noeud droit;

    public Noeud(int etiquette,Noeud g, Noeud d){
        this.etiquette = etiquette;
        this.gauche = g;
        this.droit = d;
    }

    public Noeud(int etiquette){
        this.etiquette = etiquette;
    }

    public void afficheInfixe(){
        if(this.gauche!=null){
            this.gauche.afficheInfixe();
        }
        System.out.print(this.etiquette+" ");
        if(this.droit!=null){
            this.droit.afficheInfixe();
        }
    }

    public void affichePrefixe(){
        System.out.print(this.etiquette+" ");
        if(this.gauche!=null){
            this.gauche.affichePrefixe();
        }
        if(this.droit!=null){
            this.droit.affichePrefixe();
        }
    }

    public void afficheSuffixe(){
        if(this.gauche!=null){
            this.gauche.afficheSuffixe();
        }
        if(this.droit!=null){
            this.droit.afficheSuffixe();
        }
        System.out.print(this.etiquette+" ");
    }

    public int nbDeNoeuds(){
        int nbD=0,nbG=0;
        if(this.gauche!=null){
            nbG = this.gauche.nbDeNoeuds();
        }
        if(this.droit!=null){
            nbD = this.droit.nbDeNoeuds();
        }
        return 1+nbD+nbG;
    }

    public int somme(){
        int somme=this.etiquette;
        if(this.gauche!=null){
            somme+=this.gauche.somme();
        }
        if(this.droit!=null){
            somme+= this.droit.somme();
        }
        return somme;
    }

    public int profondeur(){
        int nbG=0, nbD=0;
        if(this.gauche!=null){
            nbG += this.gauche.profondeur();
        }
        if(this.droit!=null){
            nbD += this.droit.profondeur();
        }
        return 1+Math.max(nbD,nbG);
    }

    public boolean recherche(int e){
        if(this.etiquette == e) {
            return true;
        }
        boolean resG=false,resD=false;
        if (this.gauche!=null){
            resG = this.gauche.recherche(e);
        }
        if(this.droit!=null){
           resD = this.droit.recherche(e);
        }
        return resD||resG;
    }
}
