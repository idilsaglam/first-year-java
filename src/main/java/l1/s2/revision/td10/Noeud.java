package l1.s2.revision.td10;

import java.util.concurrent.SynchronousQueue;

public class Noeud {
    private Noeud gauche;
    private Noeud droit;
    public Noeud(Noeud g, Noeud d){
        this.gauche = g;
        this.droit = d;
    }

    //ajoute une génération de feuilles.
    public void bourgeons(){
        if(this.gauche == null && this.droit == null){
            this.gauche = new Noeud(null,null);
            this.droit = new Noeud(null,null);
        }
        if(this.gauche != null){
            this.gauche.bourgeons();
        }
        if(this.droit != null){
            this.droit.bourgeons();
        }
    }

    //supprime toutes les feuilles de this.
    public void elagage(){
        if(this.gauche!=null){
            if(this.gauche.gauche==null && this.gauche.droit==null){
                this.gauche = null;
            }else{
                this.gauche.elagage();
            }

            if(this.droit != null){
                if(this.droit.droit==null && this.droit.gauche==null){
                    this.droit=null;
                }else{
                    this.droit.elagage();
                }
            }
        }
    }

    public void croissance(){
        if(this.gauche != null){
            this.gauche.croissance();
            this.gauche = new Noeud(this.gauche,null);
        }
        if(this.droit != null){
            this.droit.croissance();
            this.droit = new Noeud(null,droit);
        }
    }

    public void decroissance(){
        if(this.gauche!=null){
            this.gauche = this.gauche.gauche;
            if(this.gauche!=null){
                this.gauche.decroissance();
            }
        }

        if(this.droit!=null){
            this.droit = this.droit.droit;
            if(this.droit!=null){
                this.droit.decroissance();
            }
        }
    }

    //TODO: QUESTION 5

    public int nbNoeuds(){
        int nbD=0,nbG=0;
        if(this.gauche!=null){
            nbG = this.gauche.nbNoeuds();
        }
        if(this.droit!=null){
            nbD = this.droit.nbNoeuds();
        }
        return 1+nbD+nbG;
    }

    public Noeud sousArbre(String chemin){
        Noeud result = this;
        for(int i=0; i<chemin.length(); i++){
            if(chemin.charAt(i) == 'g' ){
                if(this.gauche == null){
                    return null;
                }
                result = result.gauche;
            }
            if(chemin.charAt(i) == 'd'){
                if(this.droit == null){
                    return null;
                }
                result = result.droit;
            }
        }
        return result;
    }

    public Noeud sousArbreRec(String chemin) {
        if(chemin.length()==0){
            return this; // Chemin bossa hicbir yere gitmeyiip kendisini donuyosun
        }
        char c =chemin.charAt(0);
        switch (c){
            case 'g': return this.gauche == null ? null : this.gauche.sousArbreRec(chemin.substring(0));
            case 'd': return this.droit == null ? null : this.droit.sousArbreRec(chemin.substring(0));
            default: return null;
        }

    }

   public void greffe(Arbre a, String chemin){

   }

    public void echange(String chemin1,String chemin2){

    }
}
