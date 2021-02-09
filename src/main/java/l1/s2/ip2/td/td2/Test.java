package l1.s2.ip2.td.td2;

public class Test {

    public static void main(String[] args){
        Confiture c1 = new Confiture("fraise",50,120);
        Confiture c2 = new Confiture("fraise",50,120);
        System.out.println(c1.egal(c2));
        System.out.println(c1==c2); // Réponse; non car ils ont les address mémoires different.
        //System.out.println(c1.fruit); Ceci ne marche pas car fruit est un variable qui est privé.


        Confiture confiture = new Confiture("Fraise",50,120);
        System.out.println(confiture.description());

        Confiture c3 = new Confiture("Orange",90,1040);
        System.out.printf("Quantité sucre dans c3 %d\n", c3.getSucre());
        c3.setProportion(900);
        System.out.printf("Quantité sucre dans c3 après changement %d\n", c3.getSucre());

        Pot pot = new Pot(confiture,50);
        System.out.printf("Dernier numéro de pot après création d'un premier pot %d\n", Pot.dernierNumero());
        Pot pot2 = new Pot(c1,20);
        System.out.printf("Dernier numéro de pot après création d'un second pot: %d\n", Pot.dernierNumero());
        Pot pot3 = new Pot(c3,40);
        System.out.printf("Dernier numéro de pot après création d'un troisième pot: %d\n", Pot.dernierNumero());

        System.out.println(pot.description());
        System.out.println(pot2.description());
        System.out.println(pot3.description());

        Temperature temperature = new Temperature(5,"Fahrenheit");
        Temperature t2 = new Temperature(8,"Fahrenheit");
        Temperature t3 = new Temperature(200, "Kelvin");
        System.out.println(temperature);

        System.out.println(t2);
        System.out.println(t3);
        System.out.printf("t2 plus bas que t3 ? %b\n",t2.plusBasseQue(t3));
        System.out.println(t2);
        System.out.println(t3);

        System.out.println(temperature.read(temperature.unite));


    }
}
