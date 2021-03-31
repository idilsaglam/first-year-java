package l1.s2.ip2.td.td8;

public class FileToboggan {
    private Cellule debut;
    private Cellule fin;
    private Enfant courant;
    private int nbMax;

    public FileToboggan(int nbMax){
        this.courant = null;
        this.nbMax = nbMax;
    }

    public void ajouter(String nom,int nb){
        if(this.debut == null){
            this.debut = new Cellule(new Enfant(nom,nb));
            return;
        }
        this.fin.setSuivant(new Cellule(new Enfant(nom,nb)));
        this.fin = this.fin.getSuivant();
    }

    public void supprimer(String nom){
        if(this.debut == null){
            return;
        }
        if(this.debut.getEnfant().getNom().equals(nom)){
            this.debut = this.debut.getSuivant();
            return;
        }
        if(this.fin.getEnfant().getNom().equals(nom)){
            this.fin = this.fin.getPrecedent();
            return;
        }
        this.debut.supprimer(nom);
    }

    public void afficher(){
        if(this.debut == null){
            return;
        }
        this.courant.affiche();
        this.debut.afficher();
    }

    public Enfant unTour(){
        this.courant.affiche();
        int newNb = this.courant.getNombre()+1;
        this.courant.setNombre(newNb);
        supprimer(courant.getNom());
        if(newNb < this.nbMax) {
            ajouter(courant.getNom(), courant.getNombre());
            return null;
        }
        return this.courant;
    }
}
