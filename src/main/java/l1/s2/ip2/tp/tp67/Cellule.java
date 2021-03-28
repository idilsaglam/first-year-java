package l1.s2.ip2.tp.tp67;

import javax.swing.*;
import java.awt.image.CropImageFilter;

public class Cellule {
    private Cellule precedente;
    private Cellule suivante;
    private boolean noire;
    private boolean prochainEtat;

    public boolean getProchainEtat(){
        return this.prochainEtat;
    }
    public void setProchainEtat(boolean etat){
        this.prochainEtat = etat;
    }

    /**
     * Question 1b: Les accesseurs
     */
    public Cellule getPrecedente(){
        return this.precedente;
    }
    public Cellule getSuivante(){
        return this.suivante;
    }
    public boolean getNoir(){
        return this.noire;
    }
    public void setPrecedente(Cellule precedente){
        this.precedente = precedente;
    }
    public void setSuivante(Cellule suivante){
        this.suivante = suivante;
    }
    public void setNoire(boolean noire){
        this.noire = noire;
    }

    /**
     * Question 1c: constructeur
     * @param noire true si le Cellule est noir, sinon false
     */
    public Cellule(boolean noire){
        this.noire = noire;
        this.suivante = null;
        this.precedente = null;
        this.prochainEtat = false;
    }

    /**
     * Question 1d: qui imprime (sans retour à la ligne) un dièse # ou un tiret - selon que noire est vraie ou fausse.
     */
    public void afficher(){
        if(this.noire){
            System.out.print("#");
        }else{
            System.out.print("-");
        }
    }

    public void ajouteALaFin(Cellule cellule){
        Cellule act = this;
        while(act.getSuivante() != null){
            act = act.suivante;
        }
        act.setSuivante(cellule);
    }

    public Cellule changeStatus(){
        Cellule res = new Cellule(true);
        if (this.getSuivante() == null) {
            return new Cellule(false);
        }
       if(this.getPrecedente() == null){
           res.setNoire(this.getSuivante().getNoir());
       }
       Cellule act = this.suivante;
       while (act.suivante != null){
           /*if(act.getPrecedente().getNoir() && act.getSuivante().getNoir() ||
                   (!act.getPrecedente().getNoir()) && (!act.getSuivante().getNoir())){
               res.ajouteALaFin((new Cellule(false)));
               act = act.suivante;
               continue;
           }
           res.ajouteALaFin(new Cellule(true));*/
           res.ajouteALaFin(new Cellule(
                   act.getPrecedente().getNoir() != act.getSuivante().getNoir()
           ));
           act = act.suivante;
       }
       res.ajouteALaFin((new Cellule (this.getPrecedente().getNoir())));
       return res;

    }

    public void prochaineEtape(){
        Cellule act = this.suivante;
        while (act.suivante != null){
            this.setProchainEtat(act.getPrecedente().getNoir() != act.getSuivante().getNoir());
            act = act.suivante;
        }

    }

    public void miseAJour(){
        Cellule act = this;
        while (act != null){
            act.setNoire(act.getProchainEtat());
            act = act.suivante;
        }
    }


}
