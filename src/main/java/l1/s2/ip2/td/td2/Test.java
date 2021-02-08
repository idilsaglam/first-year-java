package l1.s2.ip2.td.td2;

public class Test {

    public static void main(String[] args){

        Confiture c1 = new Confiture("fraise",50,120);
        Confiture c2 = new Confiture("fraise",50,120);
        System.out.println(c1.egal(c2));
        System.out.println(c1==c2); // Réponse; non car ils ont les address mémoires different.
        //System.out.println(c1.fruit); Ceci ne marche pas car fruit est un variable qui est privé.


        Confiture confiture = new Confiture("Fraise",50,120);
        confiture.description();

    }
}
