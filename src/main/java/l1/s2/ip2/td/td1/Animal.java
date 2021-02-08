public class Animal {
    public String nom;
    public char sexe;
    public int age;
    public int poids;
    public String espece;
    public int faim;

    Animal(String nom, char sexe, int age, int poids, String espece) {
        this.nom = nom;
        // Nous voulons que sexe soit 'm' ou 'f'
        assert sexe == 'm' || sexe == 'f';
        this.sexe = sexe;
        this.age = age;
        this.poids = poids;
        this.espece = espece;
    }

    /* Dans l'exercices précedents (l'exercice 3) il me demande de créer des animaux sans préciser le niveau de faim. Pour pouvoir ajouter un attribut 'faim'
       et pour ne pas impecter les exercices précedents au lieu de ajouter un attribut 'faim' dans le constructeur j'ai crée deuxiéme constructeur.
     */
    Animal(String nom, char sexe, int age, int poids, String espece, int faim) {
        this.nom = nom;
        // Nous voulons que sexe soit 'm' ou 'f'
        assert sexe == 'm' || sexe == 'f';
        this.sexe = sexe;
        this.age = age;
        this.poids = poids;
        this.espece = espece;
        // Attribut faim doivent être compris entre 0 et 10. Le modulo 11 nous permet de garder cette valeur entre [0, 10]
        this.faim = (faim % 11);
    }

    public static void description(Animal animal) {
        // Nous partons d'une sexe femelle et une suffix féminine
        String sex = "femelle";
        String suffix = "e";
        if (animal.sexe == 'm') {
            // Si le sexe n'est pas féminine, nous changeons tout avec masculin
            sex = "male";
            suffix = "";
        }
        System.out.printf(
                "Je m'appelle %s Je suis un %s %s %s ,j'ai %d jours et je pese %d kg.\n",
                animal.nom,
                suffix,
                animal.espece,
                sex,
                animal.age,
                animal.poids
        );
    }

    public static void descriptionBis(Animal animal) {
        // Nous partons d'une sexe femelle et une suffix féminine
        String sex = "femelle";
        String suffix = "e";
        if (animal.sexe == 'm') {
            sex = "male";
            suffix = "";
        }
        System.out.printf(
                "Je m'appelle %s Je suis un %s %s %s, j'ai %d ans %d jours et je pese %d kg.\n",
                animal.nom,
                suffix,
                animal.espece,
                sex,
                (animal.age / 365),
                (animal.age % 365),
                animal.poids
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Animal) {
            Animal otherAnimal = (Animal) o;
            return (
                this.faim == otherAnimal.faim &&
                this.poids == otherAnimal.poids &&
                this.sexe == otherAnimal.sexe &&
                this.espece.equals(otherAnimal.espece) &&
                this.nom.equals(otherAnimal.nom) &&
                this.age == otherAnimal.age
            );
        }
        return false;
    }
    
    public void nourrir(){
        if(this.faim == 0) {
            this.poids += this.poids / 10;
            return;
        }
        this.faim--;
    }

    public static Animal reproduction(Animal a, Animal b){
        if(
                a.sexe != b.sexe &&
                        a.faim <= 5 &&
                        b.faim <= 5 &&
                        a.espece.equals(b.espece)
        ){
            return new Animal(
                    String.format("(%s%s)", a.nom, b.nom),
                    (Math.random() < 0.5 ? 'm': 'f'),
                    0,
                    (int)(Math.random() * Math.abs(a.poids - b.poids) + (Math.min(a.poids, b.poids) + 1)),
                    a.espece
            );
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format(
                "Animal:\tnom: %s\tâge: %d\tpoids: %d\tsexe: %c\tespèce: %s\tfaim: %d",
                this.nom,
                this.age,
                this.poids,
                this.sexe,
                this.espece,
                this.faim
        );
    }
}