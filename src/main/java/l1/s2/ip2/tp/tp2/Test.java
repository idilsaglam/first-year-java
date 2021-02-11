package l1.s2.ip2.tp.tp2;

public class Test {
    public static void main (String[] args){
    // TODO: Question 2:
    Etudiant e1 = new Etudiant("Luke","Skywalker",8.25);
    Etudiant e2 = new Etudiant("Leia","Organa",11.75);
    System.out.println("nb d'etudiants: " + Etudiant.nombreDEtudiants);
    System.out.println("somme des notes: " + Etudiant.sommeDesNotes);

    Etudiant idil = new Etudiant("Idil","Saglam",20.00);
    System.out.printf("nb d'étudiants : %d somme des notes : %f\n",Etudiant.nombreDEtudiants,Etudiant.sommeDesNotes);

    e1.afficher();

    e2.afficher();
    System.out.println("Note is modified to 19.5");
    e2.modifierNote(19.5);
    System.out.println("moyene : "+Etudiant.moyenne());

    System.out.println(e1.estAdmis());
    System.out.println(e2.estAdmis());
    System.out.println(Etudiant.moyenne());
    System.out.println(idil.meilleurQueLaMoyenne());
    System.out.println(e1.meilleurQueLaMoyenne());

    Trio trio = new Trio(e1,e2,idil);
    trio.premier().afficher();

    }
}
