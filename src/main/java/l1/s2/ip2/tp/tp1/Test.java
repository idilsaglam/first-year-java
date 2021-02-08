public class Test {

    public static void main(String[] args) {
        Fruit f = new Fruit("pamplemousse", 330);
        Fruit g = new Fruit("pamplemousse", 330);
        Fruit h = f;
        System.out.println("Test termine");
        Fruit.afficher(f);
        Fruit.afficher(Fruit.hybridation(new Fruit("Pomme", 10), new Fruit("Banane", 2)));

        Panier p1 = new Panier(
                new Fruit[]{
                        new Fruit("Pomme", 20),
                        new Fruit("Poire", 30)
                }
        );
        Panier p2 = new Panier(h, p1);
        Panier p3 = new Panier();

        // Ceci doit afficher le panier construit d'une pomme de 20 grammes et d'une poire de 30 grammes
        Panier.afficher(p1);
        // Ceci doit afficher le panier contient les mêmes fruits que le précédent et une pamplemousse de 330 grammes
        Panier.afficher(p2);
        // Ceci doit afficher une panier vide
        Panier.afficher(p3);
        Fruit banane = new Fruit("Banane", 10);
        Panier p4 = new Panier(new Fruit[]{
                new Fruit("Ananas", 40),
                new Fruit("Poire", 20),
                new Fruit("Pomme", 10)}
        );
        // Ceci doit afficher le panier à l'issue d'dhbyridation de p4 et la banane
        Panier.afficher(Panier.hybridePanier(banane, p4));
    }
}


