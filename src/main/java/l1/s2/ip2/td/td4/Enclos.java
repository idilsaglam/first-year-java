package l1.s2.ip2.td.td4;

public class Enclos{
    Cellule debut;
    Enclos() {
        this.debut = null;
    }

    public void ajouter(String regime) {
        if (this.debut == null) {
            // L'enclos est vide
            this.debut = new Cellule(regime);
            return;
        }
        // Si l'enclos n'est pas vide
        this.debut.ajouter(regime);
    }

    public void CompteAnimaux(){
        if(this.debut == null){
            return;
        }
        this.debut.compteNombre();
    }

    public void transformer(){
        if(this.debut == null){
            return;
        }
        this.debut.transformer();
    }

    public void afficher(){
        if(this.debut == null){
            return;
        }
        this.debut.afficher();
    }


}
