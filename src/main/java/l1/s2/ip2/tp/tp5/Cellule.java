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

    public Employe getEmp() {
        return  this.emp;
    }

    public void setSuivant(Cellule c){
        this.suivant = c;
    }

    public Cellule getSuivant(){
        return this.suivant;
    }

    //iterative.
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

    public boolean appartientRec(String n){
        if(this.emp.getNom().equals(n)){
            return true;
        }
        while (this.suivant != null){
            this.suivant.appartientRec(n);
        }

    }

    /**
     * Une méthode qui retire l’employé de nom n dans la liste.
     * (et on suppose encore qu’il n’existe pas deux employés ayant le même nom dans la liste)
     * @param n une chaîne de caractère qui signifie le nom de l'employé.
     */
    public void demission(String n){
        if(!appartient(n)){
            return;
        }
        Cellule actuel = this;
        while (!actuel.suivant.emp.getNom().equals(n)){
            actuel = actuel.suivant;
        }
        actuel.suivant = actuel.suivant.suivant;
    }

    public void demissionRec(String n){
        if(!appartient(n)){
            return;
        }
        if(this.suivant !=null && this.suivant.emp.getNom().equals(n)){
            this.suivant = this.suivant.suivant;
            return;
        }
        this.suivant.demissionRec(n);
    }

    /**
     * Méthode qui augmente l’employé nom, s’il existe, d’un montant strictement positif.
     * La méthode renvoie false si l’une des conditions n’est pas respectée.
     * @param nom une chaîne de caractère qui signifie le nom de l'employé.
     * @param montant un entier signifiant la quantité que nous voulons ajouter au salarie.
     * @return false si un des conditions n'est pas respectés. true sinon.
     */
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

    public boolean augmenteRecursive(String nom, int montant){
        if(!appartient(nom)){
            return false;
        }
        if(this.emp.getNom().equals(nom)){
            this.emp.setSalarie(this.emp.getSalarie()+montant);
            return true;
        }
        this.suivant.augmenteRecursive(nom,montant);
        return false;
    }

    /**
     * Question 2.1
     * Une méthode qui renvoie la partie de l’entreprise constituée des Employes dont le salaire est compris
     * entre min et max, au sens large.
     * @param min un entier qui signifie un interval minimum.
     * @param max un entier qui signifie un interval maximum
     * @return Entreprise
     */

    //TODO:
    public Entreprise choixSalaire(int min,int max){
        Cellule actuel = this;
    }

    /**
     * Question 3.1
     * Une méthode qui renvoie true si et seulement si les salaires sont en ordre croissant dans la liste.
     * @return true s'il est croissante false sinon.
     */
    public boolean croissante(){
        Cellule actuel = this;
        while(actuel != null){
            if(actuel.emp.getSalarie() > actuel.suivant.emp.getSalarie()){
                return false;
            }
            actuel = actuel.suivant;
        }
        return true;
    }

    public boolean croissanteRecursive(){
        if(this.suivant != null && this.emp.getSalarie() > this.suivant.emp.getSalarie()){
            return false;
        }
        this.suivant.croissanteRecursive();
        return true;
    }

    public void swapFirstDecrease() {
        if (this.getSuivant() == null || this.getSuivant().getSuivant() == null) {
            return;
        }
        if (
                this.getSuivant().getEmp().getSalarie() >
                this.getSuivant().getSuivant().getEmp().getSalarie()
        ) {
            Cellule c = this.getSuivant();
            this.setSuivant(this.getSuivant().getSuivant());
            this.getSuivant().setSuivant(c);
        }
        this.getSuivant().swapFirstDecrease();
    }

    public void ajoutEnGardantOrdre(Cellule c) {
        Cellule actuel = this;
        while(
                actuel.getSuivant() != null &&
                actuel.getSuivant().getEmp().getSalarie() < c.getEmp().getSalarie()
        ) {
            actuel = actuel.getSuivant();
        }
        c.setSuivant(actuel.getSuivant());
        actuel.setSuivant(c);
    }

    /**
     * Question 3.2
     * Reprenez le code de ajout(Employe emp), qui doit maintenant placer l’employé emp après un employé qui gagne moins
     * ou autant, et avant un employé qui gagne plus.
     * Si de tels employés n’existent pas, placez le en début ou fin de liste, selon les cas.
     * (Pour simplifier et se concentrer sur le problème de l’ordre, on ne testera pas le fait qu’un employé de même
     * nom est ou n’est pas déjà présent)
     * @param emp qui est un employé que nous voulons ajouter.
     */
    public void ajoute2(Employe emp){
        if(!appartient(emp.getNom())){
            //TODO: basa ya da sona ekle
        }
        Cellule actuel = this;
        while(actuel!=null){
            if(emp.getSalarie() >= actuel.emp.getSalarie() && emp.getSalarie() < actuel.suivant.emp.getSalarie()){
                Cellule as = actuel.suivant;
                actuel.suivant = new Cellule(emp);
                actuel.suivant.suivant = as;
                return;
            }
            actuel = actuel.suivant;
        }
    }





}
