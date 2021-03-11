package l1.s2.ip2.td.td5;

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
    public void description(){
        System.out.println(this.valeur + "\s");
        if(this.suivante != null){
            this.suivante.description();
        }
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
        int res = 0;
        return this.suivante.taille() + 1;

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
    public int sommeRec(){
        //TODO:
    }

    /**
     * Question 2.4
     * Une méthode qui supprime le i-ème élément de la liste.
     * @param i un entier signifiant la position d'un élément que nous voulons supprimer de la liste.
     * @return true s'il est supprimé, sinon false.
     */
    public boolean supprimer_en_i(int i){
        Cellule actuel = this;
        for(int j= 0; j<i-1; j++){
            if(actuel.suivante != null){
            actuel = actuel.suivante;
            }else{
                return false;
            }
        }
        actuel.suivante = actuel.suivante.suivante;
        return true;
    }

    public boolean supprimerEnIRecursive(int i){
        //TODO:
    }

    /**
     * Question 2.6 :
     * Une méthode qui teste l’égalité de deux listes simplement chaînées
     * @param arg est un type ListeEntiers
     * @return true si les deux listes sont égaux sinon false.
     */
    public boolean egal(ListeEntiers arg){

    }





}



