package l1.s2.revision.tp11;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args){

        Noeud arbre = new Noeud("-");
        Noeud n4 = new Noeud("2"),
            n3 = new Noeud("1"),
            n2 = new Noeud("+"),
            n1 = new Noeud("*"),
            n5 = new Noeud("-"),
            n6 = new Noeud("/"),
            n7 = new Noeud("6"),
            n8 = new Noeud("3"),
            n9 = new Noeud("4");
        arbre.addFils(n1);

        n1.addFils(n2);
        n1.addFils(n5);

        n2.addFils(n3);
        n2.addFils(n4);

        n5.addFils(n6);
        n5.addFils(n9);

        n6.addFils(n7);
        n6.addFils(n8);

        arbre.afficheInfixe();
        System.out.println();
        arbre.afficheExpression();
        System.out.println();
    }
}
