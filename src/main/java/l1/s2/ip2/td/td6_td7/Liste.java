package l1.s2.ip2.td.td6_td7;

public class Liste {
    private Element premier;
    private Element dernier;

    /**
     * Question 1.1:
     * @return la longueur de la liste.
     */
    public int longueur(){
        if(this.premier == null){
            return 0;
        }
        return this.premier.longueur();
    }


    /**
     * Question 1.2:
     * Une méthode qui affiche la liste dans l’ordre.
     */
    public void afficher(){
        if(this.premier == null){
            return;
        }
        this.premier.afficherRec();
    }

    /**
     * Question 1.3
     *Une méthode qui affiche la liste dans l’ordre inverse.
     */
    public void afficheInverse(){
        if(this.dernier == null){
            return;
        }
        this.dernier.afficherInverse();
    }

    /**
     * Question 1.4
     * Une méthode qui ajoute un élément au début de la liste.
     * @param valeur
     */
    public void ajouterDebut(int valeur){
        Element e = new Element(valeur,this.premier,null);
        this.premier.setPrecedent(e);
        this.premier = e;
    }

    /**
     * Question 1.5
     * Une méthode qui ajoute un élément à la fin de la liste.
     * @param valeur
     */
    public void ajouterFin(int valeur){
        Element e = new Element(valeur,null,this.dernier);
        this.dernier.setSuivant(e);
        this.dernier = e;
    }

    /**
     * Question 1.6
     * Une méthode qui  ajoute un nouvel élément à dans la liste juste avant la première occurrence de e.
     * Si e ne se trouve pas dans la liste, ne rien faire.
     * @param e
     * @param valeur
     */
    public void ajouterAvant(Element e, int valeur){
        if(this.premier == null){
            return;
        }
        this.premier.ajouterAvant(e,valeur);
    }

    /***
     * Question 1.7 :
     * Une méthode qui supprime élément spécifiée.
     * @param e
     */
    public void supprimerRec(Element e){
        if(this.premier == null){
            return;
        }
        this.premier.supprimerRec(e);
    }

    /**
     * Question 1.9:
     * Une méthode qui calcule la somme des éléments de la liste de manière récursive.
     * @return
     */
    public int somme(){
        if(this.premier == null){
            return -1;
        }
        return this.premier.somme();
    }

    public void annuleRedondance(){
        if(this.premier == null){
            return;
        }
        Liste list = new Liste();
        list.premier = this.premier.annuleRedondances();
        list.dernier = list.premier.getDernier();
        this.premier = list.premier;
        this.dernier = list.dernier;
    }

}
