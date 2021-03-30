package l1.s2.ip2.tp.tp67;

public class Test {
   public static void main(String[] args){
       /*
        * Question 1.3:
        *  testez votre code en définissant une séquence correspondant à la première ligne de la figure ci dessous.
        */

       //Nous créons une automate.
       Automate a = new Automate();

       //Nous définissions les cellules que nous allons ajouter à l'automate
       Cellule c = new Cellule(true);
       Cellule d = new Cellule(false);
       Cellule g = new Cellule(true);
       Cellule f = new Cellule(false);

       //Nous les ajoutons un par un.
       a.ajouteAuDebut(c);
       a.ajouteAuDebut(d);
       a.ajouteAuDebut(g);
       a.ajouteAuDebut(f);

       //Ceci doit afficher '-#-#' car chaque cellule noir signifie '#' et chaque cellule blanche signifie '-'
       a.afficher();
   }
}
