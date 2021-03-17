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
    public void afficheIt(){
        Cellule actuel = this;
        while (actuel != null) {
            if(actuel.emp != null) {
               System.out.println(actuel.emp);
            }
            actuel = actuel.suivant;
        }
    }

    /**
     * Question 1.3: Méthode récursive qui décrit tout les employés.
     */
    public void affiche(){
        if(this.emp != null) {
            System.out.println(this.emp);
        }
        if(this.suivant == null){
            return;
        }
        this.suivant.affiche();
    }

    /**
     * Question 1.3 : Méthode récursive qui teste la présence de l’employé de nom n dans la liste.
     * @return true si l'employé est présent, false sinon.
     */
    //Itérative
    public boolean appartient(String n){
        Cellule actuel = this;
        while (actuel != null){
            if(actuel.emp != null && actuel.emp.getNom().equals(n)){
                return true;
            }
            actuel = actuel.suivant;
        }
        return false;
    }

    //récursive
    public boolean appartientRec(String n){
        if(this.emp != null && this.emp.getNom().equals(n)){
            return true;
        }
        if(this.suivant == null){
            return false;
        }
        return this.suivant.appartientRec(n);

    }

    // récursive méthode 2
    public boolean appartientRec2(String n){
        return (this.emp != null && this.emp.getNom().equals(n)) || (this.suivant != null && this.suivant.appartientRec2(n));
    }

    /**
     * Une méthode qui retire l’employé de nom n dans la liste.
     * (et on suppose encore qu’il n’existe pas deux employés ayant le même nom dans la liste)
     * @param n une chaîne de caractère qui signifie le nom de l'employé.
     */
    //Itérative
    public void demission(String n){
        Cellule actuel = this;
        while (actuel != null){
            if(actuel.getSuivant() != null && actuel.getSuivant().getEmp() != null && actuel.getSuivant().getEmp().getNom().equals(n)){
                actuel.setSuivant(actuel.getSuivant().getSuivant());
                return;
            }
            actuel = actuel.getSuivant();
        }

    }
    //récursive
    public void demissionRec(String n){
        // Cas d'arrêt 1
        if (this.getSuivant() == null) {
            return;
        }

        // Cas d'arrêt 2
        if(this.getSuivant().getEmp() != null && this.getSuivant().getEmp().getNom().equals(n)){
            this.setSuivant(this.getSuivant().getSuivant());
            return;
        }
        this.getSuivant().demissionRec(n);
    }

    /**
     * Méthode qui augmente l’employé nom, s’il existe, d’un montant strictement positif.
     * La méthode renvoie false si l’une des conditions n’est pas respectée.
     * @param nom une chaîne de caractère qui signifie le nom de l'employé.
     * @param montant un entier signifiant la quantité que nous voulons ajouter au salarie.
     * @return false si un des conditions n'est pas respectés. true sinon.
     */
    public boolean augmente(String nom, int montant){
        Cellule actuel = this;
        while (actuel != null){
            if(actuel.getEmp() != null && actuel.getEmp().getNom().equals(nom)){
                actuel.emp.setSalarie(actuel.emp.getSalarie()+montant);
                return true;
            }
            actuel = actuel.suivant;
        }
        return false;
    }

    public boolean augmenteRecursive(String nom, int montant){
        if(this.emp != null && this.emp.getNom().equals(nom)){
            this.emp.setSalarie(this.emp.getSalarie()+montant);
            return true;
        }
        if(this.suivant == null){
            return false;
        }
        return this.suivant.augmenteRecursive(nom, montant);

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
    public Cellule choixSalaire(int min,int max){
        Cellule minExtremum = null, maxExtremum = null, courant = (Cellule) this.clone();
        while(courant.getSuivant() != null && (minExtremum == null || maxExtremum == null)) {
            if (minExtremum == null) {
                // Si on n'a pas encore trouvé l'extremum minimum
                if (courant.getEmp() != null && courant.getEmp().getSalarie() >= min) {
                    minExtremum = courant;
                }
            }
            if (maxExtremum == null) {
                if (courant.getSuivant().getEmp() != null && courant.getSuivant().getEmp().getSalarie() > max) {
                    maxExtremum = courant;
                    maxExtremum.setSuivant(null);
                }
            }
            courant = courant.getSuivant();
        }
        if (minExtremum == null) {
            if (courant.getEmp().getSalarie() >= min) {
               return courant;
            }
            return null;
        }
        return minExtremum;
    }

    /**
     * Question 3.1
     * Une méthode qui renvoie true si et seulement si les salaires sont en ordre croissant dans la liste.
     * @return true s'il est croissante false sinon.
     */
    //itérative
    public boolean croissante(){
        Cellule actuel = this;
        while(actuel.getSuivant() != null){
            if(actuel.getEmp() != null && actuel.getSuivant().getEmp() != null && actuel.emp.getSalarie() >= actuel.suivant.emp.getSalarie()){
                return false;
            }
            actuel = actuel.suivant;
        }
        return true;
    }
    //récursive
    public boolean croissanteRecursive(){
        if(this.suivant == null){
            return true;
        }
        if(this.emp.getSalarie() >= this.suivant.emp.getSalarie()){
            return false;
        }
       return this.suivant.croissanteRecursive();
    }

    //Une autre méthode de le faire
    public boolean croissanteRecursive2(){
        return (this.emp != null && this.suivant.emp != null && this.emp.getSalarie() >= this.suivant.emp.getSalarie()) || (this.suivant != null && this.suivant.croissanteRecursive());
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
    public void ajoutEmp(Employe emp){
        Cellule act = this;
        while (act.suivant != null){
            if( act.suivant.getEmp() != null && act.suivant.getEmp().getSalarie() > emp.getSalarie()){
              Cellule tmp = act.suivant;
              act.setSuivant(new Cellule(emp));
              act.getSuivant().setSuivant(tmp);
              return;
            }
            act = act.suivant;
        }
        act.setSuivant(new Cellule(emp));
    }

    public void recAjoutEmp(Employe emp){
        // cas d'arrêt.
        if(this.suivant == null){
            this.setSuivant(new Cellule(emp));
            return;
        }
        if(this.suivant.getEmp() != null && this.suivant.getEmp().getSalarie() > emp.getSalarie()){
            Cellule tmp = this.suivant;
            this.setSuivant(new Cellule(emp));
            this.getSuivant().setSuivant(tmp);
            return;
        }

        this.suivant.recAjoutEmp(emp);

    }


    @Override
    protected Object clone() {
        if (this.getSuivant() == null) {
            return new Cellule(
                    this.getEmp(),
                    null
            );
        }
        return new Cellule(
            this.getEmp(),
            (Cellule) this.getSuivant().clone()
        );
    }
}
