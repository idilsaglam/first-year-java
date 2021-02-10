package l1.s2.ip2.tp.tp2;

public class Trio {
    Etudiant[] membres;

    Trio(Etudiant e1, Etudiant e2, Etudiant e3){
        Etudiant[] tabEtudiant = new Etudiant[]{e1,e2,e3};
        for(int i=0; i<tabEtudiant.length; i++){
            membres[i] = tabEtudiant[i];
        }
    }

    public Etudiant premier(){
        double note = -1;
        int indexEtudiant = -1;
        for(int i=0; i<membres.length; i++){
            if (membres[i].note > note) {
                note = membres[i].note;
                indexEtudiant = i;
            }
        }
        return membres[indexEtudiant];
    }

    public int classement(String prenom, String nom){
        return -1;
    }

    public double moyenne(){
        int nombreEtudiant = 0;
        double somme= 0;
        for(int i=0; i<membres.length; i++){
            somme += membres[i].note;
            nombreEtudiant ++;
        }
        return somme/nombreEtudiant;
    }

    public boolean meilleurQueLaMoyenne(){
        return true;
    }
}
