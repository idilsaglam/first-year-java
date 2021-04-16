package l1.s2.ip2.tp.tp5;

import java.util.Map;

public class Cellule {
    private Employe emp;
    private Cellule suivant;

    public Cellule(Employe emp, Cellule suivant){
        this.emp = emp;
        this.suivant = suivant;
    }
    public void setSuivante(Cellule suivant){
        this.suivant = suivant;
    }
    public Cellule getSuivant(){
        return this.suivant;
    }
    public void setEmp(Employe e){
        this.emp = e;
    }
    public Employe getEmp(){
        return this.emp;
    }

    //Itérative
    public void affiche(){
        Cellule act = this;
        while (act!= null){
            act.getEmp().affiche();
            act = act.suivant;
        }
    }

    //Récursive
    public void afficheRec(){
        // cas d'arrêt.
        if(this.suivant == null){
            this.emp.affiche();
            return;
        }
        this.emp.affiche();
        this.suivant.afficheRec();
    }

    //Récursion
    public boolean appartient(String n){
        //cas d'arrêt
        if(this.emp.getNom().equals(n)){
            return true;
        }
        if(this.suivant == null){
            return false;
        }
        return this.suivant.appartient(n);
    }

    public void demission(String n){
        if(this.suivant == null){
            return;
        }

        if(this.suivant.emp.getNom().equals(n)){
            this.setSuivante(this.suivant.suivant);
            return;
        }

        this.suivant.demission(n);
    }

    public boolean augmente(String nom, int montant){
        if(this.emp.getNom().equals(nom) && this.emp.getSalarie() < montant){
            this.emp.setSalarie(montant);
            return true;
        }
        if(this.suivant == null){
            return false;
        }
        return this.suivant.augmente(nom,montant);
    }

    public boolean croissante(){
        if(this.suivant == null){
            return true;
        }
        if(this.emp.getSalarie() > this.suivant.emp.getSalarie()){
            return false;
        }
        return this.suivant.croissante();
    }

    public void ajout(Employe employe){
        Cellule act = this;
        while (act.suivant != null){
            if(employe.getSalarie() > act.emp.getSalarie() &&
            employe.getSalarie() < act.suivant.emp.getSalarie()){
                act.suivant = new Cellule(employe,act.suivant);
                return;
            }
            act = act.suivant;
        }
    }

    public Enteprise choixSalaire(int min, int max){
        Cellule act = this;
        Enteprise e = new Enteprise("",null);
        while (act != null){
            if(act.emp.getSalarie() == min){
                e.setNom(act.emp.getNom());
                e.setPremier(act);
            }
            if(act.emp.getSalarie() < max && act.emp.getSalarie() > min){
                e.ajouteEnTete(act);
            }
            act = act.suivant;
        }
        return e;
    }



}
