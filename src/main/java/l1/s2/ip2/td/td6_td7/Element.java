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

    public int getValeur(){
        return this.valeur;
    }
    public Element getPrecedent(){
        return this.precedent;
    }
    public Element getSuivant(){
        return this.suivant;
    }

    public void setSuivant(Element suivant) {
        this.suivant = suivant;
    }

    public void setPrecedent(Element precedent) {
        this.precedent = precedent;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    //Itérative
    public int longueur(){
        int somme = 0;
        Element act = this;
        while (act != null){
            somme += 1;
            act = act.suivant;
        }
        return somme;
    }
    // Récursive
    public int longueurRec(){

      return 1+this.suivant.longueurRec();
    }

    public void afficher(){
        Element act = this;
        while (act != null){
            System.out.println(act.valeur);
            act = act.suivant;
        }
    }

    public void afficherInverse(){
        Element act = this;
        while (act != null){
            System.out.println(act.valeur);
            act = act.precedent;
        }
    }

    public void ajouterAvant(Element e, int valeur){
        Element act = this;
        while (act != null){
            if(act.equals(e)){
                act.setSuivant(new Element(valeur,act.suivant,act));
            }
            act = act.suivant;
        }
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Element){
            Element e = (Element) o;
            return (e.valeur==this.valeur);
       }
        return false;
    }

    public void supprimer(Element e){
        Element act = this;
        while (act.suivant != null){
            if(act.suivant.equals(e) && act.suivant.suivant != null){
                act.suivant = act.suivant.suivant;
                act.suivant.suivant.precedent = act;
                return;
            }

        }
    }

    public void supprimer(int valeur){
        Element act = this;
        while (act.suivant != null){
            if(act.suivant.getValeur() == valeur){
                act.suivant = act.suivant.suivant;
            }
        }
    }
}
