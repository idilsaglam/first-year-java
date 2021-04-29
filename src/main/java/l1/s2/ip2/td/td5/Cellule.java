package l1.s2.ip2.td.td5;

import l1.s2.ip2.td.td67.Element;

public class Cellule {
    private int valeur;
    private Cellule suivante;

    public Cellule(int valeur){
        this.suivante = null;
        this.valeur = valeur;
    }

    public Cellule(int valeur, Cellule suivante){
        this.valeur = valeur;
        this.suivante = suivante;
    }

    public Cellule getSuivante(){
        return this.suivante;
    }
    public int getValeur(){
        return this.valeur;
    }
    public void setSuivante(Cellule suivante){
        this.suivante = suivante;
    }
    public void setValeur(int valeur){
        this.valeur = valeur;
    }

    public void description(){
        if(this.suivante == null){
            System.out.println(" )");
            return;
        }
        System.out.printf("La valeur de la cellule est: %d",this.valeur);
        this.suivante.description();
    }

    public void description2(){
        if(this.suivante == null){
            System.out.print(this.valeur+" )");
            return;
        }
        System.out.print(this.valeur + "; ");
        this.suivante.description2();
    }
    public int taille(){
        if(this.suivante == null) {
            return 1;
        }
        return 1+this.suivante.taille();
    }

    public int somme(){
        if(this.suivante == null ){
            return this.valeur;
        }
        return this.valeur+this.suivante.somme();
    }

    public boolean isIndexExist(int a){
        Cellule act = this;
        for(int j=0; j<a; j++){
            act = act.suivante;
            if(act == null){
                return false;
            }
        }
        return true;
    }
    public void ajouter_en_i(int i, int v ){
        Cellule actuel = this;
        Cellule c = new Cellule(v);
        if(isIndexExist(i)){
            for(int h=0; h<i-1; h++){
                actuel = actuel.suivante;
            }
            Cellule tmp = actuel.suivante;
            actuel.setSuivante(c);
            c.setSuivante(tmp);

        }
    }

    public int supprimer_k_occ(int k,int v){
        Cellule act = this;
        int supprime = 0;
        while (act.suivante != null){
            if(act.suivante.valeur == v && act.suivante.suivante != null){
                act.suivante = act.suivante.suivante;
                supprime++;
            }

            if(act.suivante.valeur == v && act.suivante.suivante == null){
                //suprimeDernierElement 
                supprime++;
            }
            act = act.suivante;
        }
        return 0; //todo
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Cellule){
            Cellule c = (Cellule) o;
            return ((this.valeur==c.valeur) && (this.suivante.valeur == c.suivante.valeur));
        }
        return false;
    }
    
}
