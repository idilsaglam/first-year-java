# TD1 : Objects, attributs et constructeurs 
**Idil SAGLAM** 
Groupe 4 
Numéro étudiant: 22015094

## 1. Des Animaux
### Question 1 :
Écrivez une classe `Animal` permettant de modéliser nos animaux selon la description faite.

### Réponse 1 : 

```java
public class Animal {
    public String nom;
    public char sexe;
    public int age;
    public int poids;
    public String espece;
}
```

### Question 2 :

Écrivez un constructeur prenant des arguments (dans l’ordre décrit plus haut) permettant
d’initialiser les attributs au moment de la création de l’objet.

### Réponse 2 : 

Nous créons le constructeur dans la classe `Animal` qui prendre des paramètres dans le même ordre donnée en question. Ainsi, comme indiqué dans la question la variable `sexe` peut être uniquement `'m'` ou `'f'`.

Comme dans Java nous n'avons pas de mécanisme pour préciser quelques valeurs parmi tous les valeurs d'une type (les types unions). Nous contrôlons si la valeur du paramètre `sexe` est une des valeurs autorisés, en utilisant la méthode `assert`.

```java
Animal(String nom, char sexe, int age, int poids, String espece) {
    this.nom = nom;
    // Nous voulons que sexe soit 'm' ou 'f'
    assert sexe == 'm' || sexe == 'f';
    this.sexe = sexe;
    this.age = age;
    this.poids = poids;
    this.espece = espece;
}
```

### Question 3 :

Que doit-on écrire pour créer un zèbre mâle de 5 ans, pesant 300 kg s’appelant Marti? un hippopotame femelle de 7 ans, d’une tonne et demie s’appelant Gloria ?

### Réponse 3:

En utilisant le constructeur défini à la question précédente, on crée deux objets `marti` et `gloria` de type `Animal`. Pour calculer l'age de ces animaux on multiplie l'âge en année par 365.

Pour créer un zèbre mâle de 5 ans, de 300 kg s’appelant Marti:
```java
Animal marti = new Animal("Marti",'m',5*365,300,"zebre");
```

Pour créer un hippopotame femelle de 7 ans, d’une tonne et demie s’appelant Gloria:
```java
Animal gloria = new Animal("Gloria",'f',7*365,1500,"hippopotame");
```

### Question 4 :

Que doit-on écrire pour diminuer le poids de Gloria de 50 kg ?

### Réponse 4 :

Pour diminuer le poids de Gloria de 50 kg, on décrémente l'attribut `poids` de la variable `gloria` de 50.

```java
gloria.poids -= 50;
```

### Question 5 :

Que va afficher le code suivant ?

### Réponse 5:

Ce code affiche le poids de la variable `a` qui pointe sur la variable `b`. Donc la valeur 950
```java
Animal a = new Animal("Melman",'m',1230,998,"girafe",0);
Animal b = a;
b.poids= 950;
System.out.println(a.poids);
```

### Question 6 :

Écrivez une méthode **statique** `description` qui prend en argument `Animal` et qui renvoie une chaîne de caractères le décrivant ("_Je m'appelle Rico,je suis un manchot male,j'ai 1129 jours et je pèse 30 kg_")

### Réponse 6 :

Pour afficher la description d'animal passé en paramètre, dans un première temps, nous avons besoin de son `sexe`. 
En fonction de son sexe nous déterminons le suffix de l'article de l'animal utilisé dans l'affichage (la variable `suffix`) ainsi que son sexe en lettres (la variable `sexe`). 
Nous partons en hypothèse que l'animal est une femelle, et nous contrôlons son sexe pour savoir si c'est le cas. Si ce n'est pas le cas, nous changeons les valeurs des variables `sexe` et `suffix` pour le `sexe` mâle. 
Pour l'affichage, nous avons utilisé la fonction `System.out.printf` qui nous permet d'afficher une chaîne de caractères avec des formateurs passé en paramètres pour les raisons de performance. (Pour éviter des multiples concaténations)

```java
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
            "Je m'appelle %s Je suis un%s %s %s ,j'ai %d jours et je pese %d kg.\n",
            animal.nom,
            suffix,
            animal.espece,
            sex,
            animal.age,
            animal.poids
    );
}
```
### Question 7 :

Écrivez une méthode `descriptionBis`, similaire à la précédente, qui exprimera plus lisiblement l'âge en nombre d'années complêtes et en nombre de jours restant. Pour l'exemple précédent on aurait donc : ("_Je m'appelle Rico,je suis un manchot male,j'ai 3 ans et 34 jours et je pèse 30 kg_")

### Réponse 7 :

Nous faisons le même travail que la question précédente, mais cette fois-ci nous affichons avec une reformulation différente.

```java
public static void descriptionBis(Animal animal) {
    // Nous partons d'une sexe femelle et une suffix féminine
    String sex = "femelle";
    String suffix = "e";
    if (animal.sexe == 'm') {
        sex = "male";
        suffix = "";
    }
    System.out.printf(
            "Je m'appelle %s Je suis un %s %s %s, j'ai %d ans %d jours et je pèse %d kg.\n",
            animal.nom,
            suffix,
            animal.espece,
            sex,
            (animal.age / 365),
            (animal.age % 365),
            animal.poids
    );
}
```

### Question 8 :

On ajoute un attribut `faim` à cette classe pour représenter l'état de l'animal. Il sera compris entre 0 et 10: à 0 il n'a pas faim, à 10 il est mort de faim. Modifiez le constructeur précédent pour qu'il prenne ce paramètre dans ses arguments. Vous tronquerez la valeur donnée pour qu'elle reste comprise dans l'intervalle de définition. 

### Réponse 8:

Nous repartons [du constructeur précédente de la classe Animal](#réponse-2). Nous ajoutons un paramètre `faim` de type `int`. Ainsi nous allons ajouter un attribut `int faim;` à [la définition de la classe Animal fait précédemment](#réponse-1) Pour que la valeur de faim reste dans l'intervalle `[0,10]` nous prenons le modulo 11 de la valeur de ce paramètre.

```java
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
```

### Question 9 :

Écrivez une méthode `nourrir` qui diminue le degré de faim d'un animal de 1 unité. De plus, nourrir un animal qui n'avait pas faim le fera grossir de 10%.

### Réponse 9 :

Dans classe `Animal` nous ajoutons la méthode suivante:

```java
 public void nourrir(){
    if(this.faim == 0) {
        this.poids += this.poids / 10;
        return;
    }
    this.faim--;
}
```
### Question 10 :

Écrivez une méthode `lePlusGros` qui prend en argument un tableau d'animaux et qui en renvoie un de poids maximal. Testez là sur un tableau au moins trois animaux.

### Réponse 10 :

La fonction `lePlusGros` renvoie l'animal qui a le poids maximal parmi une liste des animaux. Si deux animaux ont le même poids et ils sont les plus gros de la liste, cette fonction renvoie celui en premier. 

```java
public static Animal lePlusGros(Animal[] tab) {
    int max = Integer.MIN_VALUE, maxIndex = -1;
    for(int i=0; i<tab.length; i++){
        if(tab[i].poids > max) {
            max = tab[i].poids;
            maxIndex = i;
        }
    }
    return (
            maxIndex == -1 ?
                    null :
                    tab[maxIndex]
    );
}
```

Pour tester cette fonction, dans le classe `Main` il faut qu'on affiche le résultat du fonction `lePlusGros` en donnant les paramètres nécessaires. 

Normalement, pour les types non primitives, la fonction d'affichage `System.out.println` affiche l'adresse mémoire de paramètre. Cette adresse mémoire vient d'un appel du méthode `toString()` qui est défini dans la classe `Object` (la classe dont laquelle tous les classes héritent par défaut). Donc pour avoir une affichage correcte, nous devons redéfinir le méthode `toString()` dans la classe `Animal`. 

```java
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
```

Une fois que nous avons redéfini le méthode `toString()` dans la classe `Animal` nous pouvons utiliser `System.out.println()` avec un paramètre de type `Animal` comme suivant:

```java
System.out.println(lePlusGros(
    new Animal[]{
        new Animal("lolo", 'f', 300, 20, "girafe", 3),
        new Animal("tutu", 'm', 2000, 6500, "manchot", 2),
        new Animal("lala", 'f', 900, 204, "zebre", 5),
    })
);
```

### Question 11 :

Écrivez une méthode `reproduction`, prenant en argument deux animaux et qui,s'ils sont de sexes opposés, de la même espèce et si leurs niveaux de faim sont tous deux inférieurs à 5, renvoie un nouvel animal de la même espèce et de sexe tiré aléatoirement. 
Le poids sera un nombre aléatoire situé entre les poids des deux parents. Le nom sera la concaténation des deux noms des parents, mis en parenthèses. Quel est le résultat de la reproduction dans le cas où les conditions ne sont pas remplis?

### Réponse 11 : 

Nous contrôlons si les deux animaux ont des sexes opposés, ont le faim plus petit ou égale à 5 et qui sont de même espèce. Si ces conditions sont vérifiées nous créons un nouveau animal avec les propriétés donnés en question.
Si les conditions ne sont pas remplis,cette function retourne `null`.

Alors dans la classe `Animal` nous ajoutons le méthode suivante:

```java
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
```

## 2. Des Zoos

### Question 1 : 

Définissez une classe `Enclos`, dont les objects sont destinés à contenir un ensemble d'animaux:vous utiliserez un attribut de type tableau d'animaux dont la capacité sera donnée en argument au constructeur, et un attribut entier dont la valeur indiquera sa population actuelle.

### Réponse 1 :

La classe `Enclos` peut s'écrire comme ceci:

```java
public class Enclos {
    public Animal[] tabAnimal;
    public int population;
    Enclos (int maxSize, int population) {
        tabAnimal = new Animal[maxSize];
        this.population = population;
    }
}
```

### Question 2 : 

Écrivez une méthode pour ajouter un animal à un enclos. Elle retournera `vrai` ou `faux` selon que l'ajout a été possible ou non.

### Réponse 2 :

Si la capacité d'enclos est strictement supérieur à la population, nous pouvons ajouter un animal dans cet enclos. 

Alors dans la classe `Enclos` nous ajoutons la fonction suivante:

```java
public boolean ajouteAnimal(Animal a){
    if (this.tabAnimal.length > this.population) {
        this.tabAnimal[this.population] = a;
        this.population++;
        return true;
    }
    return false;
}
```

### Question 3 : 

Définissez la classe `Zoo`, qui possède comme attributs une ville de type chaîne de caractères et un contenu de type tableau d'`Enclos`. Le constructeur d'un zoo prendra en argument son nom,un entier précisant le nombre d'enclos et un second entier précisant la taille de ses enclos, ils seront initialement vides.

### Réponse 3.1 : 

Nous créons la classe `Zoo` avec deux attributs `ville` et `contenu` et avec un constructeur qui ont des paramètres `nom`, `nombreEnclos`
 et `tailleEnclos`. Nous initialisons la valeur de l'attribut `ville` avec la valeur du paramètre `nom`. Et nous initialisons l'attribut `contenu` avec une liste des `Enclos` de taille `nombreEnclos` dont chaque un des enclos ont de taille `tailleEnclos` et une population initiale 0.
 

```java
public class Zoo {
    public String ville;
    public Enclos[] contenu;

    Zoo(String nom, int nombreEnclos, int tailleEnclos){
        this.ville = nom;
        this.contenu = new Enclos[nombreEnclos];
        for (int i = 0; i < this.contenu.length; i++) {
            this.contenu[i] = new Enclos(tailleEnclos, 0);
        }
    }
}
```

### Question 4 :

Écrivez une méthode permettant d'ajouter un animal au zoo s'il existe un enclos dans lequel on peut l'insérer. Elle retournera vrai ou faux si l'ajout à été possible ou non. 

### Réponse 4 : 

Pour ajouter une animal dans le zoo, nous parcourons tous les enclos un par un et dans chaque enclos nous essayons d'ajouter l'animal passé en paramètre et si on arrive à y ajouter, nous retournons `true`. Si nous pouvons ajouter à aucun enclos nous retournons `false`.

Alors dans la classe `Zoo` nous ajoutons la méthode suivante:

```java
public boolean ajouteAnimal(Animal animal) {
    for (int i = 0; i<this.contenu.length; i++) {
        Enclos e = this.contenu[i];
        if (e.ajouteAnimal(animal)) {
            return true;
        }
    }
    return false;
}
```

### Question 5:

Écrivez une méthode qui nourrira tous les animaux du zoo qui ont plus de 5 en faim.

### Réponse 5:

Nous ajoutons une méthode `nourrir` dans la classe `Zoo` pour nourrir tous les animaux dans chaque `Enclos`. 

```java
public void nourrir(){
    for (int i = 0; i < zoo.contenu.length; i++) {
        for (int j = 0; j < zoo.contenu[i].tabAnimal.length; j++) {
            if ( zoo.contenu[i].tabAnimal[j].faim > 5) {
                zoo.contenu[i].tabAnimal[j].nourrir();
            }
        }
    }
}
```

Pour ce faire, nous parcourons le tableau des enclos et pour chaque enclos nous parcourons les animaux dans l'enclos. Dans chaque animal nous appelons la méthode `nourrir` que nous avons défini dans la classe `Animal`.

```java
public void nourrir(){
    if(this.faim == 0) {
        this.poids += this.poids / 10;
        return;
    }
    this.faim--;
}
```

### Question 6 :
Écrivez une méthode `unJourPasseAuZoo` qui fait que tous les animaux vieillissent un peu,voient leur faim augmenter de 2, et ceux pour qui elle atteint 10 disparaissent.


### Réponse 6

Dans un première temps nous avons besoin de deux méthodes `tueAnimal` dans les classes `Zoo` et `Enclos` qui prend un `Animal` en paramètre. Ces fonctions vont tuer l'animal passé en paramètre. 

Nous devons donc trouver l'enclos auquel l'animal appartient, et puis appeler `tueAnimal` sur cet enclos avec le même animal en paramètre. 

Pour trouver l'animal dans enclos, nous allons besoin d'un méthode pour tester l'égalité. Nous ne pouvons pas utiliser l'opérateur `==` qui teste l'égalité en fonction de l'adresse mémoire. Nous allons s'en servir du méthode `equals` qui est définit dans la classe `Object`. Pour cela, dans la classe `Animal` nous ajoutons le méthode `equals` comme suivant:

```java
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
```

Ici le décorateur `@Override` indique la redéfinition du méthode `equals` dans la classe mère. Comme en Java tous les classe sont automatiquement hérité de la classe `Object`, il s'agit de redéfinition du méthode `equals(Object o)` de la classe `Object`. Nous devons donc garder le même signature pour la fonction (donc le paramètre doit rester en type `Object`). Et nous commençons par tester si le paramètre o est bien de type `Animal`. Si ce n'est pas le cas, il n'y aucun moyen que ça soit égale à un Animal. Si c'est la cas, nous contrôlons égalité pour chaque un des attributs.

Nous pouvons maintenant définir le méthode `tueAnimal` dans la classe `Zoo`.

```java
private void tueAnimal(Animal animal) {
    for(int i=0; i<this.contenu.length; i++){
        for(int j=0; j<this.contenu[i].tabAnimal.length; j++){
            if(this.contenu[i].tabAnimal[j].equals(animal)){
                this.contenu[i].tueAnimal(animal);
            }
        }
    }
}
```

Ainsi dans la classe `Enclos`:

```java
public void tueAnimal(Animal animal) {
    int index = -1;

    for (int i=0; i<this.tabAnimal.length; i++) {
        if (this.tabAnimal[i].equals(animal)) {
            index=i;
            break;
        }
    }

    if (index == -1) {
        return;
    }

    for(int i=index; i<this.tabAnimal.length-1; i++){
        this.tabAnimal[i] = this.tabAnimal[i+1];
    }
    this.tabAnimal[this.tabAnimal.length-1] = null;
    this.population--;
}
```

Comme nous allons de s'en servir de la méthode `tueAnimal` de la classe `Zoo` uniquement dans la classe `Zoo` nous allons le rendre `private`.

Une fois que nous avons la méthode `tueAnimal(Animal animal)` nous pouvons définir le méthode `unJourPasseAuZoo`. Nous allons parcourir chaque animal dans chaque enclos du zoo. Pour chaque animal, nous allons le vieillir d'un jour et augmenter son faim de 2. Et puis pour tous les animaux qui ont le `faim` supérieur ou égale à 10, nous allons les tuer avec le méthode `tueAnimal(Animal animal)` défini précédemment.

```java
public void unJourPasseAuZoo(){
    for (int i = 0; i < this.contenu.length; i++) {
        for (int j = 0; j < this.contenu[i].tabAnimal.length; j++) {
            this.contenu[i].tabAnimal[j].age++;
            this.contenu[i].tabAnimal[j].faim += 2;
            if(this.contenu[i].tabAnimal[j].faim >= 10){
                tueAnimal(this.contenu[i].tabAnimal[i]);
            }
        }
    }
}
```
### Question 7 :
Complétez la méthode précédente pour que si une reproduction au sein d’un enclos est possible alors elle ait lieu (dans la limite de la place disponible). Une femelle ne donnera qu’un descendant par jour. Les nouveaux nés seront féconds dès le lendemain.

### Réponse 7 :

Nous avons maintenant besoin d'un méthode `reproduction` pour modéliser la reproduction en une journée au sein d'un enclos dans la classe `Enclos`. Les contraintes posés par la question est comme suivant:

- Une femelle ne donnera qu'un descendant par jour
- Les nouveaux nés seront féconds dès le lendemain. (Donc, pour pouvoir reproduire il faut avoir au moins 1 jour)

Nous devons donc séparer les femelles fécondes et les mâles féconds au sein de même enclos, sous forme de deux tableaux (une tableau `tabMale` pour les mâles féconds , un tableau `tabFemelle` pour les femelles fécondes).

Une fois que l'isolation est faite, tant que possible, pour chaque femelle nous allons choisir de manière aléatoire un mâle parmi les mâles féconds. Si le mâle choisi n'est pas compatible (le méthode `Animal.reproduction(Animal a1, Animal a2)` retourne `null`) avec la femelle nous choisissons un autre animal mâle fécond. 

```java
public void reproduction(){
    int male = 0;
    int femelle = 0;
    for(int i=0; i<this.tabAnimal.length; i++){
        if (this.tabAnimal[i].age > 0) {
            if (this.tabAnimal[i].sexe == 'm') {
                male++;
                continue;
            }
            femelle++;
        }
    }
    Animal[] tabFemelle = new Animal[femelle];
    Animal[] tabMale = new Animal[male];
    femelle = 0;
    male = 0;
    for(int i=0; i<this.tabAnimal.length; i++){
        if (this.tabAnimal[i].age > 0) {
            if (this.tabAnimal[i].sexe == 'm') {
                tabMale[male] = this.tabAnimal[i];
                male++;
                continue;
            }
            tabFemelle[femelle] = this.tabAnimal[i];
            femelle++;
        }
    }
    while (this.tabAnimal.length > this.population) {
        for (int i = 0; i < tabFemelle.length; i++) {
            Animal bebeAnimal;
            do {
                bebeAnimal=Animal.reproduction(tabFemelle[i], tabMale[(int)(Math.random() * tabMale.length)]);
            } while(bebeAnimal == null);
            this.ajouteAnimal(bebeAnimal);
        }
    }
}
```  

Uns fois que nous avons défini la méthode pour modéliser la reproduction au sein d'un enclos en une journée, nous allons donc l'appeler dans la méthode `unJourPasseAuZoo()` de la classe `Zoo` après la disparation et la vieillissement des animaux. 

```java
public void unJourPasseAuZoo(){
    for (int i = 0; i < this.contenu.length; i++) {
        for (int j = 0; j < this.contenu[i].tabAnimal.length; j++) {
            this.contenu[i].tabAnimal[j].age++;
            this.contenu[i].tabAnimal[j].faim += 2;
            if(this.contenu[i].tabAnimal[j].faim >= 10){
                tueAnimal(this.contenu[i].tabAnimal[i]);
            }
        }
        this.contenu[i].reproduction();
    }
}
```