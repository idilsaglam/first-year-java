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

    //get the size of the list
    public int taille(){
        int taille = 0;
        Cellule act = this.premier;
        while(act != null){
            taille++;
            act = act.getSuivante();
        }
        return taille;
    }

    /**
     * Question 2.6 :
     * Une méthode qui teste l’égalité de deux listes simplement chaînées
     * @param arg est un type ListeEntiers
     * @return true si les deux listes sont égaux sinon false.
     */
    //itérative
    public boolean egal(ListeEntiers arg){
        if(arg == null){
            return false;
        }
       Cellule actListe = this.getPremier();
       Cellule actArgliste = arg.getPremier();

       while (actListe != null && actArgliste != null){
           //if(!actListe.getValeur() != actArgListe.getValeur())
           if(!actListe.equals(actArgliste)){
               return false;
           }
           actListe = actListe.getSuivante();
           actArgliste = actArgliste.getSuivante();
       }

       return  (actListe==null && actArgliste==null);
    }

    //recursive
    public boolean egalRec(ListeEntiers arg){
        Cellule actArgListe = arg.getPremier();
        return true;

    }

    public String descriptionRec(){
        if(this.premier == null){
            return "()";
        }
        return "(" + this.getPremier().descriptionRec();
    }

    public int supprimer_k_premieres_occRec(int k, int v){
        if (this.premier == null ) {
            return 0;
        }
        if (k == 0) {
            return 0;
        }
        if (this.premier.getValeur() == v) {
            this.premier = this.premier.getSuivante();
            return 1 + this.supprimer_k_premieres_occRec(k-1, v);
        }
        return this.premier.supprimer_k_premieres_occRec(k, v);
    }



}
