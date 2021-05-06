package l1.s2.ip2.td.td67;

import javax.management.modelmbean.ModelMBean;

public class Element {
    private int valeur;
    private Element suivant;
    private Element precedent;

    public Element(int valeur, Element suivant, Element precedent){
        this.valeur = valeur;
        this.precedent = precedent;
        this.suivant = suivant;
    }

    //getters et setters
    public void setValeur(int valeur){
        this.valeur = valeur;
    }
    public void setSuivant(Element suivant){
        this.suivant = suivant;
    }
    public void setPrecedent(Element precedent){
        this.precedent = precedent;
    }
    public Element getSuivant(){
        return this.suivant;
    }
    public Element getPrecedent(){
        return this.precedent;
    }
    public int getValeur(){
        return this.valeur;
    }

    public int longueur(){
        if(this.suivant == null){
            return 1;
        }
        return 1+this.suivant.longueur();
    }

    public void afficher(){
        if(this.suivant == null){
            System.out.println(this.valeur);
            return;
        }
        System.out.println(this.valeur);
        this.suivant.afficher();
    }

    public void afficheInverseRec(){
        if(this.precedent == null){
            System.out.println(this.valeur);
            return;
        }
        System.out.println(this.valeur);
        this.precedent.afficheInverseRec();
    }

    public void afficheInverseIt(){
        Element act = this;
        while (act.precedent != null){
            System.out.println(act.valeur);
            act = act.precedent;
        }
        System.out.println(act.valeur);
    }

    public boolean isExists(Element e){
        if(this.suivant == null){
            return false;
        }
        if(this.equals(e)){
            return true;
        }
        return this.suivant.isExists(e);
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Element){
            Element e = (Element) object;
            return (this.valeur == e.valeur);
        }
        return false;
    }

    /*public void ajouterAvant(Element e, int valeur){
        if(!isExists(e)){
            return;
        }
        Element act = this;
        while (act.suivant!=null){
            if(act.suivant == e){
                act.setSuivant(new Element(valeur,act.suivant,act));
                break;
            }
            act = act.suivant;
        }
    }*/

    public void supprimer(Element e){
        if(this.suivant == null){
            return;
        }
        if(this.suivant.equals(e)){
            this.setSuivant(this.suivant.suivant);
            this.suivant.setPrecedent(this);
            return;
        }
        this.suivant.supprimer(e);
    }

    public void supprimer(int valeur){
        Element act = this;
        while (act != null){
            if(act.valeur == valeur){
                supprimer(act);
            }
            act = act.suivant;
        }
    }

    public int somme(){
        if(this.suivant == null){
            return this.valeur;
        }
        return this.valeur+this.suivant.somme();
    }

    public boolean estTriee(){
        if(this.suivant == null){
            return true;
        }
        if(this.valeur > this.suivant.valeur){
            return false;
        }
        return this.suivant.estTriee();
    }
}
