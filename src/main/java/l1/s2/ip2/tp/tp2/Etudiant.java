package l1.s2.ip2.tp.tp2;

public class Etudiant {
    final String prenom ;
    final String nom ;
    double note ;
    static int nombreDEtudiants = 0;
    static double sommeDesNotes = 0;

    Etudiant(String prenom, String nom,double note){
        this.prenom = prenom;
        this.nom = nom;
        this.note = note;
        nombreDEtudiants++;
        sommeDesNotes += this.note;
    }

}
