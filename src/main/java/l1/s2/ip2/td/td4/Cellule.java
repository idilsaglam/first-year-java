package l1.s2.ip2.td.td4;

public class Cellule {
    private Animal content;
    private Cellule suivant;

    public Cellule(String regime) {
        // Intégrer un nouvel animal ayant un regime qui est passé en paramètre.
        this.content = new Animal(regime);

        this.suivant = null;
    }


    public void ajouter2(String regime) {
        // Ce n'est pas la dernière cellule de l'enclos
        Cellule c = this;
        while (c.suivant != null) {
            c = c.suivant;
        }
        c.suivant = new Cellule(regime);
    }

    public void ajouter(String regime) {
        if (this.suivant == null) {
            this.suivant = new Cellule(regime);
            return;
        }
        this.suivant.ajouter(regime);
    }

    public int compteNombre(){
        if(this.suivant == null){
            return 1;
        }
        return this.suivant.compteNombre() + 1;
    }

    public void transformer(){
        this.content.transformer();
        if(this.suivant == null){
            return;
        }
        this.suivant.transformer();
    }

    public void afficher(){
        this.content.afficher();
        if(this.suivant == null){
            return;
        }
        this.suivant.afficher();
    }

    //TODO:
    public void afficherDetail(){

        this.content.afficher();
        if(this.suivant == null){
            return;
        }
        this.suivant.afficher();
    }




}
