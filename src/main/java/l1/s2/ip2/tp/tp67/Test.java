package l1.s2.ip2.tp.tp67;

public class Test {
   public static void main(String[] args){
       /*
        * Question 1.3:
        *  testez votre code en définissant une séquence correspondant à la première ligne de la figure ci dessous.
        */

       //Nous créons une automate.
       Automate a = new Automate();


       //Exercice 1.3
       a.ajouteAuDebut(true);
       a.ajouteAuDebut(true);
       a.ajouteAuDebut(true);

       a.ajouteALaFin(false);
       a.ajouteALaFin(false);
       a.ajouteALaFin(false);

       a.ajouteALaFin(true);

       a.ajouteALaFin(false);
       a.ajouteALaFin(false);
       a.ajouteALaFin(false);
       a.ajouteALaFin(false);

       System.out.println("**************");
       System.out.println("* Exercice 1 *");
       System.out.println("* Question 3 *");
       System.out.println("**************");
       System.out.println();
       //Ceci doit afficher '###---#----' car chaque cellule noir signifie '#' et chaque cellule blanche signifie '-'
       a.afficher();

       System.out.println();
       System.out.println("**************");
       System.out.println("* Exercice 2 *");
       System.out.println("* Question 7 *");
       System.out.println("**************");
       System.out.println();
       //Question 2.7
       a.nEtapes(4, Regle.UNANIMITE);

       System.out.println();

       System.out.println("**************");
       System.out.println("* Exercice 2 *");
       System.out.println("* Question 9 *");
       System.out.println("**************");
       System.out.println();

       //Question 2.9
       Automate automate = new Automate("----#----");
       automate.afficher();

       System.out.println();
       Automate av = new Automate("##--#--");
       av.afficher();

       System.out.println();
       System.out.println("**************");
       System.out.println("* Initialisation *");
       System.out.println("**************");
       System.out.println();
       Automate b = new Automate();
       b.initialisation();
       b.afficher();
       System.out.println();

       System.out.println();
       System.out.println("**************");
       System.out.println("* Exercice 2 *");
       System.out.println("* Question 10 *");
       System.out.println("**************");
       System.out.println();

       a.nEtapes(4, Regle.MAJORITE);
       System.out.println();
   }
}
