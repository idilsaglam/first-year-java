package l1.s2.ip2.tp.tp8;

public class Test {
    public static void main(String[] args){
        Robot r = new Robot('a',"Pancake");
        Robot r2 = new Robot('v',"Broccoli");
        Robot r3 = new Robot('m',"ame");

        TableRonde t = new TableRonde(r);
        t.ajouteRob(r2);
        t.ajouteRob(r3);
        t.affiche();
        System.out.println();
        System.out.println();

        r.parle(3);
        r2.parle(1);
        r3.parle(6);
        t.affiche();
        //Ceci doit afficher true car le robot r3 est fini de parler.
        System.out.println(r3.finitDeParler());


        System.out.println();
        System.out.println();

        t.supprimer(r.getId());
        t.affiche();

        System.out.println();
        System.out.println();

        t.supprimer('v');
        t.affiche();
        System.out.println();
        System.out.println();

        t.supprimer('g');
        t.affiche();

    }

}
