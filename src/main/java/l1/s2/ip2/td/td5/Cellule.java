package l1.s2.ip2.td.td5;

import javax.swing.*;

public class Cellule {
    private int valeur;
    private Cellule suivante;

    /**
     * Question 1.3 :
     * Un constructeur pour la classe Cellule prenant seulement un argument entier
     * @param valeur un entier qui signifie la valeur de  l'attribut valeur.
     */
    public Cellule(int valeur){
        this.valeur = valeur;
    }

    /**
     * Question 1.4
     * Un constructeur qui prend en argument un entier et une cellule
     * @param valeur un entier qui signifie la valeur de  l'attribut valeur.
     * @param suivante une Cellule qui signifie la valeur de l'attribut suivante.
     */
    public Cellule(int valeur, Cellule suivante){
        this.valeur = valeur;
        this.suivante = suivante;
    }

    /**
     * Question 1.7:
     * Les accesseurs getters/setters
     */
    public Cellule getSuivante(){
        return this.suivante;
    }
    public int getValeur(){
        return this.valeur;
    }
    public void setValeur(int n){
        this.valeur = n;
    }
    public void setSuivante(Cellule suivante){
        this.suivante = suivante;
    }

    /**
     * Question 2.1 :
     * une méthode description qui renvoie une chaîne de caractères décrivant la liste d’entiers séparés par des
     * espaces, ou "la liste est vide" si c’est le cas.
     */
    public String description(){
        String res = this.valeur + "\s";
        if(this.suivante == null){
            return res;
        }
        return this.suivante.description();
    }

    public String descriptionRec(){
        //cas d'arrêt
        if(this.getSuivante() == null){
            return this.getValeur()+")";
        }
        return this.getValeur() + ";" + this.getSuivante().descriptionRec();
    }
    /**
     * Question 2.3 :
     * Une méthode taille (), sans argument, qui renvoie le nombre d’éléments de la liste.
     * @return un entier signifiant le nombre d'éléments de la liste.
     */
    //Itérative
    public int taille(){
        int res = 1;
        Cellule actuel = this;
        while (actuel.suivante!=null){
            res++;
            actuel = actuel.suivante;
        }
        return res;
    }
    //Récursive
    public int tailleRecursive(){
        if(this.suivante !=null) {
            return this.suivante.taille() + 1;
        }
        return 0;
    }

    /**
     * Question 2.3
     * Une méthode qui renvoie la somme des éléments de la liste.
     * @return un entier somme
     */
    //Itérative:
    public int somme(){
        int somme = 0;
        Cellule actuel = this;
        while(actuel!= null){
            somme+= actuel.valeur;
            actuel = actuel.suivante;
        }
        return somme;
    }
    //Récursive:
    public int sommeRec() {
        if (this.suivante != null) {
            return this.suivante.sommeRec() + this.suivante.getValeur();
        }
        return 0;
    }

    /**
     * Question 2.4
     * Une méthode qui ajoute l’entier v en position i si elle existe, sinon elle l’ajoute en interprétant
     * cet indice "au plus près" de ce qu’il peut signifier.
     * @param i
     * @param v
     */
    public void ajouterEni(int i, int v){

    }

    /**
     * Question 2.5
     * Une méthode qui supprime le i-ème élément de la liste.
     * @param i un entier signifiant la position d'un élément que nous voulons supprimer de la liste.
     * @return true s'il est supprimé, sinon false.
     */
    public boolean supprimer_en_i(int i){
       Cellule actuel = this;
       while(actuel.suivante!= null){
           if(actuel.suivante.getValeur() == i && actuel.suivante.suivante != null){
               actuel.suivante= actuel.suivante.suivante;
               return true;
           }
           if(actuel.suivante.getValeur() == i && actuel.suivante.suivante == null){
               //suprimer
           }
       }
       return  false;
    }

    public boolean supprimerEnIRecursive(int i){
        if(this.suivante.getValeur()==i){
            this.suivante = this.suivante.suivante;
            return true;
        }
        if(this.suivante == null){
            return false;
        }
        return this.suivante.supprimerEnIRecursive(i);

    }

    /**
     * Question 2.7 :
     * Une méthode qui supprimera les k premières occurrences d’un entier v.
     * Elle retournera le nombre de valeurs effectivement sup- primées.
     * @param k
     * @param v
     * @return
     */
    public int supprimer_k_premieres_occ(int k, int v){
        Cellule actuel = this;
        int counter = 0;
        while (actuel != null && counter < k){
            if (actuel.getValeur() == v) {
                actuel.suivante = actuel.suivante.suivante;
                counter++;
            }

        }
        return counter;
    }

    public int supprimer_k_premieres_occRec(int k, int v){
       if (k == 0) {
           return 0;
       }
       if (this.getSuivante().getSuivante() == null) {
           if (this.getSuivante().getValeur() == v) {
               this.setSuivante(this.getSuivante().getSuivante());
               return 1;
           }
           return 0;
       }
       if (this.getSuivante().getValeur() == v) {
            this.setSuivante(this.getSuivante().getSuivante());
           return 1 + this.getSuivante().supprimer_k_premieres_occRec(k-1,v);
       }
       return this.getSuivante().supprimer_k_premieres_occRec(k,v);
    }

    public void swap(int i,int j ){
        Cellule actuelPositionI = this;
        Cellule actuelPositionJ = this;
        for(int k=0; k<i-1; k++){
            if(actuelPositionI.suivante != null){
                actuelPositionI = actuelPositionI.suivante;
                continue;
            }
            return; //swap ne peut pas être possible
        }
        for(int k=0; k<j-1; k++){
            if(actuelPositionJ.suivante != null){
                actuelPositionJ = actuelPositionJ.suivante;
                continue;
            }
            return; //swap ne peut pas être possible
        }
        int tmp = actuelPositionI.getValeur();
        actuelPositionI.setValeur(actuelPositionJ.getValeur());
        actuelPositionJ.setValeur(tmp);

    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cellule){
            Cellule c = (Cellule) obj;
            return (this.getValeur() == c.getValeur());
        }
        return false;
    }
}



