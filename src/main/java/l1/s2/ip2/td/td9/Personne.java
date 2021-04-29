package l1.s2.ip2.td.td9;

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
        return p.pere.equals(this.pere);
    }

    public boolean estCousinGermain(Personne p){
        // anneler kardes || babalar kardes
        return p.mere.mere.equals(this.mere.mere) || p.pere.pere.equals(this.pere.pere) || p.pere.mere.equals(this.mere.mere) || p.mere.mere.equals(this.pere.mere);
    }

    public int nbAscendantsVivants(){
        if(this.mere == null && this.pere == null){
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

    public boolean possedeCommeAscendant(Personne p){
        //TODO: p this den buyuk mu
    }

   public int distanceDAscendance(Personne p){

   }

    @Override
    public boolean equals(Object o){
        if(o instanceof Personne){
            Personne p = (Personne) o;
            return (p.prenom.equals(this.prenom) && (p.nomDeFamille.equals(this.nomDeFamille)));
        }
        return false;
    }
}
