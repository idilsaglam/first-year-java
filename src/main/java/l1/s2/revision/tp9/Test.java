package l1.s2.revision.tp9;
    public class Test {
        public static void main ( String [] args ){
            Noeud a = new Noeud (6 , null , new Noeud (8));
            Noeud b = new Noeud (9 , new Noeud (2) , a );
            Noeud c = new Noeud (5 , b , null );
            Noeud d = new Noeud (1 , new Noeud (4) , null );
            Noeud e = new Noeud (7 , new Noeud (0) , d );
            Noeud f = new Noeud (3 , c , e );
            Arbre g = new Arbre ( f );
           System.out.println("Infixe "); g . afficheInfixe ();
                System.out.println("Suffixe "); g . afficheSuffixe ();
            System.out.println("Prefixe "); g . affichePrefixe ();

            System.out.println("Nb de noeuds:"); System.out.println(g.nbDeNoeuds());

            System.out.println("Somme"); System.out.println(g.somme());

            System.out.println("is 4 exists"); System.out.println(g.recherche(4));
            System.out.println("is 12 exists"); System.out.println(g.recherche(12));

            g.affiche(0); System.out.println("  ");
            g.affichePenchee();
            g.afficheLargeur(); System.out.println();

            int[] tab={6,1,2,3,7,5};
            Arbre h = new Arbre(tab);
            h.afficheInfixe(); System.out.println();
            h.affichePrefixe();
        }
    }

