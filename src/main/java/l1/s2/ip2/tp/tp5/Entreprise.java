package l1.s2.ip2.tp.tp5;

public class Entreprise {
    private String nom;
    private Cellule premier;

    public Entreprise(){
        this.premier = null;
        this.nom = null;
    }
    public Entreprise(String nom, Cellule premier){
        this.nom = nom;
        this.premier = premier;
    }

    public String getNom(){
        return this.nom;
    }
    public void setNom(String s){
        this.nom = s;
    }
    public Cellule getPremier(){
        return this.premier;
    }

    /**
     * Question 1.3: Méthode récursive qui décrit tout les employés.
     */
    public void affiche(){
        if(this.premier == null){
            return;
        }
        this.premier.affiche();
    }

    public void ajout(Employe emp){
        if(this.premier != null && this.premier.appartient(emp.getNom())){
            return;
        }
        Cellule root = new Cellule(emp);
        root.setSuivant(premier);
        premier = root;
    }

    /**
     * Question 1.3 : Méthode récursive qui teste la présence de l’employé de nom n dans la liste.
     * @return true si l'employé est présent, false sinon.
     */
    public boolean appartient(String m){
        if(this.premier != null){
            return this.premier.appartient(m);
        }
        return false;
    }

    /**
     * Question 1.3
     * Une méthode qui retire l’employé de nom n dans la liste.
     * (et on suppose encore qu’il n’existe pas deux employés ayant le même nom dans la liste)
     * @param n une chaîne de caractère qui signifie le nom de l'employé.
     */
    public void demission(String n){
        if(this.premier == null){
            return;
        }
        if(this.premier.getEmp().getNom().equals(n)){
           this.premier = this.premier.getSuivant();
           return;
        }
        this.premier.demission(n);
    }

    /**
     * Question 2.1
     * Méthode qui augmente l’employé nom, s’il existe, d’un montant strictement positif.
     * La méthode renvoie false si l’une des conditions n’est pas respectée.
     * @param nom une chaîne de caractère qui signifie le nom de l'employé.
     * @param montant un entier signifiant la quantité que nous voulons ajouter au salarie.
     * @return false si un des conditions n'est pas respectés. true sinon.
     */
    public boolean augmente(String nom, int montant){
        if(this.premier == null){
            return false;
        }
        return this.premier.augmente(nom,montant);
    }

    /**
     * Question 3.1
     * Une méthode qui renvoie true si et seule- ment si les salaires sont en ordre croissant dans la liste.
     * @return true s'il est croissante false sinon.
     */
    public boolean croissant(){
        if(this.premier != null){
            this.premier.croissante();
        }
        return false;
    }

    public Entreprise choixSalaire(int min,int max){
        Cellule first = null;
        if (this.premier != null) {
            first = this.premier.choixSalaire(min, max);
        }
        return new Entreprise(this.getNom(), first);
    }

    public void ajoutEmp(Employe e){

        if(this.premier == null || this.premier.getEmp().getSalarie()>e.getSalarie()){
            Cellule a = this.premier;
            this.premier = new Cellule(e);
            this.premier.setSuivant(a);
            return;
        }

        this.premier.ajoutEmp(e);
    }

    /**
     * Question 3.3
     * @param ent
     */
    public void acquisition_Version1(Entreprise ent) {
        if(ent.premier == null){
            return;
        }
        Cellule act = this.premier;
        while (act != null){
            ent.ajoutEmp(act.getEmp());
            act = act.getSuivant();
        }

    }

    public void augmente3(String nom, int montant){
        
    }

    // Une autre facon de le faire
    public void acquisition_Version(Entreprise ent){
        if(this.premier == null){
            this.premier = ent.getPremier();
        } else{
            Cellule dernier = this.getPremier();
            while(dernier.getSuivant() != null){
                dernier = dernier.getSuivant();
            }
            dernier.setSuivant(ent.getPremier());
        }
    }
    public boolean isEmpty() {
        return this.premier == null;
    }

    public Cellule removeFirst() {
        Cellule c = this.premier;
        this.premier = this.premier.getSuivant();
        c.setSuivant(null);
        return c;
    }

    public void ajouteAuDebut(Cellule c) {
        c.setSuivant(this.premier);
        this.premier = c;
    }


    public void acquisition_Version_1(Entreprise ent){
        while (!ent.isEmpty()) {
            Cellule c = ent.removeFirst();
            if (this.getPremier().getEmp().getSalarie() >= c.getEmp().getSalarie()) {
                this.ajouteAuDebut(c);
                continue;
            }
            this.premier.ajoutEnGardantOrdre(c);
        }
    }

    public void sort() {
        if (this.premier == null || this.premier.getSuivant() == null) {
            return;
        }
        while(!this.premier.croissante()) {
            if (this.premier.getEmp().getSalarie() > this.premier.getSuivant().getEmp().getSalarie()) {
                Cellule c = this.premier.getSuivant();
                this.premier.setSuivant(this.premier.getSuivant().getSuivant());
                c.setSuivant(this.premier);
                continue;
            }
            this.premier.swapFirstDecrease();
        }
    }

    /**
     * Question 3.4
     * @param nom chaîne de caractère qui signifie le nom de l'employé.
     * @param montant un entier signifiant la quantité de salarie que nous voulons augmenter.
     */
    public void augmente_Version_1(String nom, int montant){
        augmente(nom,montant);
        sort();
    }







}
