package l1.s2.ip2.td.td6_td7;

public class Liste{
    private Element premier;
    private Element dernier;

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

    public void afficherInverse(){
        if(this.dernier == null){
            return;
        }
        this.dernier.afficherInverse();
    }

    public void ajouterDebut(int valeur){
        if(this.premier == null){
            Element e = new Element(valeur,null,null);
            this.premier = e;
            this.dernier = e;
            return;
        }
        Element tmp = this.premier;
        this.premier = new Element(valeur,tmp,null);
    }

    public void ajouterFin(int valeur){
        if(this.dernier == null){
            Element e = new Element(valeur,null,null);
            this.premier = e;
            this.dernier = e;
            return;
        }
        Element tmp = this.dernier;
        this.dernier = new Element(valeur,null,tmp);
    }

    public void ajouterAvant(Element e, int valeur){
        if(this.premier == null){
            return;
        }
        this.premier.ajouterAvant(e,valeur);
    }

    public void supprimer(Element e){
        if(this.premier == null){
            return;
        }
        if(this.premier.equals(e) && this.premier.getSuivant() != null){
            this.premier = this.premier.getSuivant();
            return;
        }
        if(this.premier.equals(e) && this.premier.getSuivant() == null){
            this.premier = null;
            this.dernier = null;
            return;
        }

        this.premier.supprimer(e);
    }

    public void supprimer(int valeur){
        if(this.premier == null){
            return;
        }
        this.premier.supprimer(valeur);
    }

}
