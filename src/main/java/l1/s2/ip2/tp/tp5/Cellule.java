package l1.s2.ip2.tp.tp5;

public class Cellule {
    private Employe emp;
    private Cellule suivant;

    public Cellule(Employe emp){
        this.emp = emp;
        this.suivant = null;
    }

    public Cellule (Employe emp, Cellule suiv){
        this.emp = emp;
        this.suivant = suiv;
    }

    public void setSuivant(Cellule c){
        this.suivant = c;
    }

    public Cellule getSuivant(){
        return this.suivant;
    }
    //pass recursive
    public void affiche2(){
        Cellule actuel = this;
        while (actuel.emp != null) {
            System.out.printf(
                    "Nom de l'employé(e) : %s , salaire : %d", this.emp.getNom(), this.emp.getSalarie()
            );
            actuel = actuel.suivant;
        }
    }

    /**
     * Question 1.3: Méthode récursive qui décrit tout les employés.
     */
    public void affiche(){
        Cellule actuel = this;
        if(actuel.emp != null) {
            System.out.printf(
                    "Nom de l'employé(e) : %s , salaire : %d", this.emp.getNom(), this.emp.getSalarie()
            );
            actuel = actuel.suivant;
        }
        actuel.affiche();
    }

    /**
     * Question 1.3 : Méthode récursive qui teste la présence de l’employé de nom n dans la liste.
     * @return true si l'employé est présent, false sinon.
     */
    public boolean appartient(String n){
        Cellule actuel = this;
        if(actuel.emp.getNom().equals(n)){
            return  true;
        }
        actuel = actuel.suivant;
        appartient(n);
        return false;
    }

    public boolean augmente(String nom, int montant){
        if(!appartient(nom)) {
            return false;
        }
        Cellule actuel = this;
        while (!actuel.emp.getNom().equals(nom)){
            actuel = actuel.suivant;
        }
        actuel.emp.setSalarie(actuel.emp.getSalarie()+montant);
        return true;
    }

    public Entreprise choixSalaire(int min,int max){
        Cellule actuel = this;
    }



}
