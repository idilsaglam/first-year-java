package l1.s2.ip2.td.td9;

import l1.s2.ip2.tp.tp10.Main;

import java.util.ArrayList;

public class Personne {
    private final String prenom, nomDeFamille;
    private Personne mere, pere;

    public Personne(String prenom, String nomDeFamille){
        this.nomDeFamille = nomDeFamille;
        this.prenom = prenom;
    }

    public Personne(String prenom, String nomDeFamille,Personne pere,Personne mere){
        this.prenom = prenom;
        this.nomDeFamille = nomDeFamille;
        this.pere = pere;
        this.mere = mere;
    }

    public boolean estFrereOuSoeur(Personne p){
        if(p == null || p==this || this.mere == null || this.pere== null) {
            return false;
        }
        return p.pere.equals(this.pere);
    }

    public boolean estCousinGermain(Personne p){
        if(p == null || p==this || this.mere == null || this.pere== null) {
            return false;
        }
        return p.mere.mere.equals(this.mere.mere) || p.pere.pere.equals(this.pere.pere) || p.pere.mere.equals(this.mere.mere) || p.mere.mere.equals(this.pere.mere);
    }

    //TODO:
    public int nbAscendantsVivants(){
        if(this.mere == null && this.pere == null){ //feuille
            return 1;
        }
        int nbM=0,nbP=0;
        if(this.mere != null){
            nbM = this.mere.nbAscendantsVivants();
        }
        if(this.pere != null){
            nbP = this.pere.nbAscendantsVivants();
        }
        return nbM+nbP;
    }

    public int nbAscendantsVivants2(){
        int resp =0, respm =0;
        if(this.pere != null){
            resp= this.pere.nbAscendantsVivants2();
        }
        if(this.mere != null){
            respm = this.mere.nbAscendantsVivants2();
        }
        return 1+resp+respm;
    }

    public boolean possedeCommeAscendant(Personne p){
        if(this == p){
            return true;
        }
        boolean resp = false,resm = false;
        if(this.pere != null){
            resp = this.pere.possedeCommeAscendant(p);
        }
        if(this.mere != null){
            resm = this.mere.possedeCommeAscendant(p);
        }
        return (resm || resp);
    }
    //TODO:
   public int distanceDAscendance(Personne p){
        if(this == p){
            return 0;
        }
        int resp = -1, resm = -1;
        if(this.pere != null){
            resp = this.pere.distanceDAscendance(p);
        }
        if(this.mere != null){
            resm = this.mere.distanceDAscendance(p);
        }
        if(resp == -1 && resm == -1){
            return-1;
        }
        return Math.max(1+resp,1+resm);
   }

   public void afficheAscendantUn(Personne p){
        if(this == p){
            System.out.println(this.prenom+" "+this.nomDeFamille);
            return;
        }
        if(this.pere != null && this.pere.possedeCommeAscendant(p)){
            System.out.print(this.prenom+" "+this.nomDeFamille+", enfant de");
            this.pere.afficheAscendantUn(p);
            return;
        }
       if(this.mere != null && this.mere.possedeCommeAscendant(p)){
           System.out.print(this.prenom+" "+this.nomDeFamille+", enfant de");
           this.mere.afficheAscendantUn(p);
           return;
       }
   }

   //UNE AUTRE SOLUTION
    public void afficheAscendantUnR(Personne p,String s){
        if(this == p){
            System.out.println(s+this.prenom+" "+this.nomDeFamille);
            return;
        }
        if(this.pere != null){
            this.pere.afficheAscendantUnR(p,s+this.prenom+" "+this.nomDeFamille+" ,enfant de");
        }
        if(this.mere != null){
            this.mere.afficheAscendantUnR(p,s+this.prenom+" "+this.nomDeFamille+",enfant de");
        }
    }

    public void afficheAscendantUnbis(Personne p){
        this.afficheAscendantUnR(p,"");
    }

    public int nbGenerations(){
        int resp=0,resm=0;

        if(this.pere != null){
            resp=1+this.pere.nbGenerations();
        }
        if(this.mere != null){
            resm=1+this.mere.nbGenerations();
        }
        return Math.max(resp,resm);
    }

    public boolean verification(Personne pere){
        if(this.nbGenerations() != pere.nbGenerations()){
            return false;
        }
        return (pere.mere.estFrereOuSoeur(pere.pere) || pere.mere.estCousinGermain(pere.pere) || this.mere.estFrereOuSoeur(this.pere) || this.mere.estFrereOuSoeur(this.pere));
    }

    //public ArrayList<Personne> getTousLesAscendants(){ }

    @Override
    public boolean equals(Object o){
        if(o instanceof Personne){
            Personne p = (Personne) o;
            return (p.prenom.equals(this.prenom) && (p.nomDeFamille.equals(this.nomDeFamille)));
        }
        return false;
    }
}
