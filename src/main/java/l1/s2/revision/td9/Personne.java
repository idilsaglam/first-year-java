package l1.s2.revision.td9;

public class Personne {
    private final String prenom, nomDeFamille;
    private Personne mere,pere;

    public Personne(String prenom,String nomDeFamille){
        this.prenom = prenom;
        this.nomDeFamille = nomDeFamille;
    }

    public Personne(String prenom, String nomDeFamille,Personne pere,Personne mere){
        this.prenom = prenom;
        this.nomDeFamille = nomDeFamille;
        this.pere = pere;
        this.mere = mere;
    }

    /**
     * Une fonction qui teste si la personne courante est un frère ou un soeur.
     * @param p une personne p
     * @return true si la personne courante est un frère ou un soeur sinon false
     */
    public boolean estFrereOuSoeur(Personne p){
        if(p == null || this.mere == null || this.pere == null){
            return false;
        }
        return this.mere.equals(p.mere) && this.pere.equals(p.pere);
    }

    /**
     * Une fonction qui teste la personne courante est cousin germain de p.
     * @param p une personne p
     * @return true si la personne courante est cousin germain de p sinon false
     */
    public boolean estCousinGermain(Personne p){
        if(p == null || this.mere == null || this.pere == null){
            return false;
        }
        return this.mere.estFrereOuSoeur(p.mere) || this.mere.estFrereOuSoeur(p.pere) ||  this.pere.estFrereOuSoeur(this.mere) || this.pere.estFrereOuSoeur(this.pere);
    }

    /**
     * Une fonction qui renvoie
     * @return le nombre d'ascendants de this.
     */
    public int nbAscendantVivants(){
        int nbP =0, nbM = 0;
        if(this.pere != null){
            nbP = this.pere.nbAscendantVivants();
        }
        if(this.mere != null){
            nbM = this.mere.nbAscendantVivants();
        }
        return 1+ nbP+nbM;
    }

    /**
     * Une fonction qui teste si la personne courant a pour ascendant p.
     * @param p une personne p
     * @return true si la personne courant a pour ascendant p false sinon
     */
    public boolean possedeCommeAscendant(Personne p){
        if(this.equals(p)) {
            return true;
        }
        boolean pm=false,mp=false;
        if(this.pere!=null){
            pm = this.pere.possedeCommeAscendant(p);
        }
        if(this.mere != null){
            mp = this.mere.possedeCommeAscendant(p);
        }
        return mp||pm;
    }


}
