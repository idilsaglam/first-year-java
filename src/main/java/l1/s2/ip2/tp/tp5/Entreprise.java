package l1.s2.ip2.tp.tp5;

public class Entreprise {
    private String nom;
    private Cellule premier;

    public Entreprise(String nom, Cellule premier){
        this.nom = nom;
        this.premier = premier;
    }

    public void affiche(){
        this.premier.affiche();
    }

    public void ajout(Employe emp){
        if(premier.appartient(emp.getNom())){
            return;
        }
        Cellule root = new Cellule(emp);
        root.setSuivant(premier);
        premier = root;
    }

    //TODO: demission







}
