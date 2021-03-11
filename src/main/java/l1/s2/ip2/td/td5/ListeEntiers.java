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



}
