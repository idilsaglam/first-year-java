package l1.s2.ip2.td.td6_td7;

public class Element {
    private int valeur;
    private Element suivant;
    private Element precedent;

    public Element(int valeur, Element suivant, Element precedent){
        this.valeur = valeur;
        this.suivant = suivant;
        this.precedent = precedent;
    }

    /**
     * Question 1.1
     * Une méthode qui renvoie la longueur de la liste.
     * @return counter un entier signifiant le nombre de la longueur de la liste.
     */
    //Itérative
    public int longueur(){
        Element actuel = this;
        int counter = 1;
        while (actuel.suivant != null){
            counter++;
            actuel= actuel.suivant;
        }
        return counter;
    }

    public int longueurRec(){
        // cas d'arrêt.
        if(this.suivant == null){
            return 1;
        }
        return 1+this.suivant.longueurRec();
    }

    /**
     * Question 1.2:
     * Une méthode qui affiche la liste dans l’ordre.
     */
    //Itérative
    public void afficher(){
        Element actuel = this;
        while(actuel != null){
            System.out.print(actuel.valeur + "\s");
            actuel = this.suivant;
        }
    }

    //Récursive
    public void afficherRec(){
        System.out.print(this.valeur + "\s");
        if(this.suivant == null){
            System.out.println();
            return;
        }
        this.suivant.afficherRec();
    }
}
