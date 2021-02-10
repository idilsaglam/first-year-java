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

    public void afficher(){
        System.out.println(this.nom +" "+ this.prenom+": "+this.note);
    }

    public boolean estAdmis(){
    return(this.note >= 10);
    }
    public static double moyenne(){
        return sommeDesNotes/nombreDEtudiants;
    }
    public boolean meilleurQueLaMoyenne(){
        return(this.note>moyenne());
    }
    public void modifierNote(double nouvelleNote){
        this.note = nouvelleNote;
    }




}
