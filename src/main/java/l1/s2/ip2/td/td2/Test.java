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

        Confiture c3 = new Confiture("Orange",90,1040);

        Pot pot = new Pot(confiture,50);
        System.out.println(Pot.dernierNumero());
        Pot pot2 = new Pot(c1,20);
        System.out.println(Pot.dernierNumero());
        Pot pot3 = new Pot(c3,40);
        System.out.println(Pot.dernierNumero());

        pot.description(confiture);
        pot2.description(c1);
        pot3.description(c3);


        Temperature temperature = new Temperature(5,"Fahrenheit");
        Temperature t2 = new Temperature(8,"Fahrenheit");

        temperature.afficher();
        System.out.println(temperature.read(temperature.unite));


    }
}
