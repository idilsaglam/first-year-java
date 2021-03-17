package l1.s2.ip2.td.td6_td7;

public class Element {
    private int valeur;
    private Element suivant;
    private Element precedent;


    public Element(int valeur, Element suivant, Element precedent) {
        this.valeur = valeur;
        this.suivant = suivant;
        this.precedent = precedent;
    }

    public void setPrecedent(Element p) {
        this.precedent = p;
        p.suivant = this;
    }

    public void setSuivant(Element s) {
        this.suivant = s;
        s.precedent = this;
    }

    public Element getSuivant() {
        return this.suivant;
    }

    public Element getPrecedent() {
        return this.precedent;
    }

    public int getValeur() {
        return this.valeur;
    }

    /**
     * Question 1.1
     * Une méthode qui renvoie la longueur de la liste.
     *
     * @return counter un entier signifiant le nombre de la longueur de la liste.
     */
    //Itérative
    public int longueur() {
        Element actuel = this;
        int counter = 1;
        while (actuel.suivant != null) {
            counter++;
            actuel = actuel.suivant;
        }
        return counter;
    }
    //Récursive
    public int longueurRec() {
        // cas d'arrêt.
        if (this.suivant == null) {
            return 1;
        }
        return 1 + this.suivant.longueurRec();
    }

    /**
     * Question 1.2:
     * Une méthode qui affiche la liste dans l’ordre.
     */
    //Itérative
    public void afficher() {
        Element actuel = this;
        while (actuel != null) {
            System.out.print(actuel.valeur + "\s");
            actuel = actuel.suivant;
        }
        System.out.println();
    }

    //Récursive
    public void afficherRec() {
        System.out.print(this.valeur + "\s");
        if (this.suivant == null) {
            System.out.println();
            return;
        }
        this.suivant.afficherRec();
    }

    /**
     * Question 1.3
     * Une méthode qui affiche la liste dans l’ordre inverse.
     */
    //Itérative
    public void afficherInverse() {
        Element lastElement = this;
        if (lastElement.precedent == null) {
            // Si ce méthode a été appelé par le premier élément de la liste
            // normalement il suffit de l'appeler sur le dernier élément
            while (lastElement.suivant != null) {
                lastElement = this.suivant;
            }
        }
        while (lastElement.precedent != null) {
            System.out.print(lastElement.valeur + "\s");
            lastElement = lastElement.precedent;
        }
    }

    //autre facon de le faire
    public void afficherInverse2() {
        Element lastElement = this;
        String s = "";
        while (lastElement.suivant != null) {
            s = lastElement.valeur + " " + s;
            lastElement = this.suivant;
        }
        System.out.println(s);
    }

    //Récursion
    public void afficherInverseRec() {

    }

    /**
     * Question 1.6
     * Une méthode qui  ajoute un nouvel élément à dans la liste juste avant la première occurrence de e.
     * Si e ne se trouve pas dans la liste, ne rien faire.
     *
     * @param e
     * @param valeur
     */
    //Itérative
    public void ajouterAvant(Element e, int valeur) {
        Element firstE = this;
        while (firstE.equals(e)) {
            firstE = firstE.suivant;
        }
        Element a = new Element(valeur, firstE, firstE.precedent);
        firstE.precedent = a;
        a.suivant = firstE;
    }

    //Récursive
    public void ajouterAvantRec(Element e, int valeur) {
        //TODO:
    }

    /***
     * Question 1.7 :
     * Une méthode qui supprime élément spécifiée.
     * @param e
     */
    //Itérative
    public void supprimer(Element e) {
        Element actuel = this;
        while (!actuel.suivant.equals(e)){
            actuel = actuel.suivant;
        }
        actuel.suivant.suivant.precedent = actuel;
        actuel.suivant = actuel.suivant.suivant;
    }
    //Une autre facon de le faire (voir le setter)
    public void supprimer2(Element e) {
        Element actuel = this;
        while (!actuel.suivant.equals(e)){
            actuel = actuel.suivant;
        }
        actuel.setSuivant(actuel.suivant.suivant);
    }
    //Récursive
    public void supprimerRec(Element e){
        if(this.suivant.equals(e)){
            this.setSuivant(this.suivant.suivant);
            return;
        }
        if(this.suivant == null){
            return;
        }
        this.suivant.supprimerRec(e);
    }

    /**
     * Question 1.9:
     * Une méthode qui calcule la somme des éléments de la liste de manière récursive.
     * @return
     */
    //Itérative
    public int somme(){
        Element e = this;
        int res = 0;
        while (e != null){
            res++;
        }
        return res;
    }

    //Récursive
    public int somme2(){
        if(this.suivant == null){
            return this.getValeur();
        }
        return this.getValeur() +this.suivant.somme();
    }

    /**
     * Question 1.10
     * Une méthode qui teste si la liste est triée dans l’ordre croissant de manière récursive.
     * @return true s'il est triee false sinon.
     */
    //Itérative
    public boolean estTriee(){
        Element e = this;
        while (e.suivant != null){
            if(e.getValeur() > e.suivant.getValeur()){
                return false;
            }
        }
        return true;
    }
    //Récursive
    public boolean estTrieeRec(){
        if(this.getValeur() > this.suivant.getValeur()){
            return false;
        }
        if(this.suivant == null){
            return true;
        }
        return this.suivant.estTrieeRec();
    }

    /**
     * Question 2.1
     * Une méthode qui inverse la position dans la liste de e et de l’élément qui le suit directement.
     * Si e est le dernier élément, ne rien faire.
     * @param e
     */
    //Itératif
    public void inverser(Element e){
        Element firstE = this;
        while (!firstE.suivant.equals(e)) {
            firstE = firstE.suivant;
        }
        firstE.suivant = firstE.suivant.suivant;
        firstE.precedent = firstE;
    }

    //Récursive
    public void inverserRec(Element e){

    }
    //Itératif
    public boolean verifContrainte(){
        Element actuel = this;
        while (actuel.suivant != null){
            if(actuel.precedent.getValeur() / actuel.suivant.getValeur() == actuel.precedent.getValeur() + actuel.getValeur()){
                return false;
            }
        }
        return true;
    }
    public boolean contains(Element e){
        Element act = this;
        while (act != null){
            if(e.equals(act)){
                return true;
            }
            act = act.suivant;
        }
        return false;
    }
    public void add(Element e){
        Element act = this;
        act.getDernier().setSuivant(e);

    }
    public Element annuleRedondances(){
        Element e = new Element(this.valeur,null,null);
        Element act = this;
        while (act != null){
            if(!e.contains(act)){
                e.add(act);
            }
            act = act.suivant;
        }
        return e;
    }

    public Element getDernier(){
        Element act = this;
        while (act.suivant != null){
            act = act.suivant;
        }
        return act;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Element){
            Element e = (Element) o;
            return (this.getValeur() == e.getValeur());
        }
        return false;
    }


}
