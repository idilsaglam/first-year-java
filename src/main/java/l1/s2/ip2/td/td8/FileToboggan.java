package l1.s2.ip2.td.td8;

import java.io.File;
import java.rmi.StubNotFoundException;

public class FileToboggan {
    private Cellule courant;
    private int nbMax; // nb maximal de fois qu'un enfant peut glisser.

    public FileToboggan(int nbMax){
        this.nbMax = nbMax;
        this.courant = null;
    }

    //getter et setters
    public void setCourant(Cellule courant){
        this.courant = courant;
    }
    public void setNbMax(int nbMax){
        this.nbMax = nbMax;
    }
    public Cellule getCourant(){
        return this.courant;
    }
    public int getNbMax(){
        return this.nbMax;
    }

    public void ajouter(String nom, int nb){
        if(this.courant == null ){
            this.setCourant(new Cellule(new Enfant(nom,nb)));
            return;
        }
        Cellule tmp = this.courant.getSuivant();
        this.courant.setSuivant(new Cellule(tmp,this.courant,new Enfant(nom,nb)));
    }

    public void supprimer(String nom){
        if(this.courant == null){
            return;
        }
        this.courant.supprimer(nom);
    }

    public void affiche(){
        if(this.courant == null){
            return;
        }
        Cellule c = this.courant;
        do{
            c.getEnfant().affiche();
            c = c.getSuivant();
        } while (c!= this.courant);
    }

    public void ajouterALaFin(Cellule cellule){
        Cellule c = this.courant;
        do{
            c = c.getSuivant();
        } while (c!= this.courant.getPrecedent().getPrecedent());
        Cellule tmp = c.getSuivant();
        c.setSuivant(cellule);
        c.getSuivant().setPrecedent(tmp);
        tmp.setSuivant(c);

    }
    public Enfant unTour(){
        System.out.println(this.courant.getEnfant().getNom());
        int newNombre = this.courant.getEnfant().getNombre()+1;
        this.courant.getEnfant().setNombre(newNombre);
        Cellule enfantglisse = this.courant;
        supprimer(this.courant.getEnfant().getNom());
        if(newNombre <= this.nbMax){
            ajouterALaFin(enfantglisse);
            return null;
        }
        return enfantglisse.getEnfant();
    }




}
