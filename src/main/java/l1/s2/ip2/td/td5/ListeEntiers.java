package l1.s2.ip2.td.td5;

public class ListeEntiers {
    private Cellule premier;

    /**
     * Question 1.5
     * Un constructeur qui construit la liste vide
     */
    public ListeEntiers(){
        this.premier = null;
    }

    /**
     * Les accesseurs getters/setters
     */
    public void setPremier(Cellule premier) {
        this.premier = premier;
    }

    public Cellule getPremier() {
        return premier;
    }

    /**
     * Question 1.6 :
     * Une méthode qui ajoute en tête de liste
     * @param x un entier que nous voulons ajouter au tête de la Liste.
     */
    public void add(int x){
        if(this.premier == null){
            this.premier = new Cellule(x);
            return;
        }
        Cellule ancienPremier = this.premier;
        this.premier = new Cellule(x);
        this.premier.setSuivante(ancienPremier);
    }

    /**
     * Question 1.1 :
     * une méthode description qui renvoie une chaîne de caractères décrivant la liste d’entiers séparés par des
     * espaces, ou "la liste est vide" si c’est le cas.
     */
    public void description(){
        if(this.getPremier() == null){
            System.out.println("La liste est vide");
            return;
        }
        this.premier.description();
    }


    /**
     * Question 2.6 :
     * Une méthode qui teste l’égalité de deux listes simplement chaînées
     * @param arg est un type ListeEntiers
     * @return true si les deux listes sont égaux sinon false.
     */
    //itérative
    public boolean egal(ListeEntiers arg){
        if(this.getPremier() != arg.getPremier()){
            return false;
        }
        Cellule listeActuel = this.premier;
        Cellule argListe = arg.premier;

        while (listeActuel.getValeur() == argListe.getValeur()){
            listeActuel = listeActuel.getSuivante();
            argListe = argListe.getSuivante();
        }
        return false;
    }

    //recursive
    public boolean egalRec(ListeEntiers arg){


    }



}
