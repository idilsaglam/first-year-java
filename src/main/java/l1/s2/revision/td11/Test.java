package l1.s2.revision.td11;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Noeud a = new Noeud('B');
        a.ajouteUnMot("Bonjour");
        a.ajouteUnMot("Bond");
        a.ajouteUnMot("Bon");
        a.ajouteUnMot("Bord");
        a.ajouteUnMot("Bien");
        a.ajouteUnMot("Boreale");
        ArrayList<String> l = a.afficheSorted();
        for (int i = 0; i<l.size(); i++) {
            System.out.println(l.get(i));
        }
        System.out.println(a.aPourEnfant('n').character);
        System.out.println(a.appartient("Bien"));
        System.out.println(a.appartient("idil"));

    }
}
