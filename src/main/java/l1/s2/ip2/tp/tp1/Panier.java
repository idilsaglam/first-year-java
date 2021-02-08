import java.util.Arrays;

public class Panier {
    public Fruit[] tabFruit;

    Panier(Fruit[] fruits) {

        this.tabFruit = fruits;
    }

    Panier(Fruit fruit, Panier panier) {
        tabFruit = new Fruit[panier.tabFruit.length + 1];

        for (int i = 0; i < panier.tabFruit.length; i++) {
            tabFruit[i] = panier.tabFruit[i];
        }
        tabFruit[tabFruit.length - 1] = fruit;
    }

    Panier() {
        this.tabFruit = new Fruit[0];
    }

    public static void afficher(Panier p) {
        for (int i = 0; i < p.tabFruit.length; i++) {
            Fruit.afficher(p.tabFruit[i]);
        }
    }

    public static Panier hybridePanier(Fruit f, Panier p) {
        for (int i = 0; i < p.tabFruit.length; i++) {
            p.tabFruit[i] = Fruit.hybridation(f, p.tabFruit[i]);
        }
        return p;
    }

    @Override
    public String toString() {
        return String.format("Panier: size= %d\nfruits: %s", this.tabFruit.length, Arrays.toString(this.tabFruit));

    }
}
