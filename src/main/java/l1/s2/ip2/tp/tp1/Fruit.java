public class Fruit {
    public String nom;
    public int poids;

    public Fruit(String n, int p) {
        nom = n;
        poids = p;
    }

    public static void afficher(Fruit f) {
        System.out.printf(
                "Ce fruit est un(e) %s et pèse %d grammes\n",
                f.nom,
                f.poids * 1000
        );
    }

    public static Fruit hybridation(Fruit f1, Fruit f2) {
        String newName = f1.nom + f2.nom;
        int newPoids = f1.poids + f2.poids;
        return new Fruit(newName, newPoids);
    }

    @Override
    public String toString() {
        // Pour afficher proprement,nous devons redéfinir la méthode toString() héritée de la classe java.lang.Object
        return String.format("Name: %s Poids: %d\n", this.nom, this.poids);
    }
}
