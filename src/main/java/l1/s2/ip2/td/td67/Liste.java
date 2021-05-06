package l1.s2.ip2.td.td67;

public class Liste {
    private Element premier;
    private Element dernier;

    //getters et setters

    public void setDernier(Element dernier) {
        this.dernier = dernier;
    }

    public Element getDernier() {
        return dernier;
    }

    public Element getPremier() {
        return premier;
    }

    public void setPremier(Element premier) {
        this.premier = premier;
    }

    public int longueur(){
        if(this.premier == null){
            return 0;
        }
        return this.premier.longueur();
    }

    public void afficher(){
        if(this.premier == null){
            return;
        }
        this.premier.afficher();
    }

    public void afficheInverseIt(){
        if(this.dernier == null){
            return;
        }
        this.dernier.afficheInverseIt();
    }

    public void afficheInverseRec(){
        if(this.dernier == null){
            return;
        }
        this.dernier.afficheInverseRec();
    }

    public void ajouterAuDebut(int valeur){
        if(this.premier == null){
            this.setPremier(new Element(valeur,null,null));
            this.setDernier(new Element(valeur,null,null));
            return;
        }
        Element tmp = this.premier;
        this.setPremier(new Element(valeur,tmp,null));
    }

    public void ajouterFin(int valeur){
        if(this.dernier == null){
            this.setPremier(new Element(valeur,null,null));
            this.setDernier(new Element(valeur,null,null));
            return;
        }
        Element tmp = this.dernier;
        this.setDernier(new Element(valeur,null,tmp));
    }

    /*public void ajouterAvant(Element e, int valeur){
        if(this.premier == null){
            return;
        }
        if(this.dernier.equals(e)){

        }
        this.premier.ajouterAvant(e,valeur);
    }*/

    public void supprimer(Element e){
        if(this.premier == null){
            return;
        }
        this.premier.supprimer(e);
    }


}
