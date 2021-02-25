package l1.s2.ip2.td.td4;

public class Test {
    public static void main(String[] args) {
        //Ex 1.3
        Enclos enclos = new Enclos();
        enclos.ajouter("herbivore");
        enclos.ajouter("herbivore");
        enclos.ajouter("carnivore");

        Enclos enclos2 = new Enclos();
        enclos2.ajouter("herbivore");
        enclos2.ajouter("herbivore");
        enclos2.ajouter("herbivore");
        enclos2.ajouter("carnivore");
    }

}
