# TD2
**Idil SAGLAM**
Groupe 4
Numéro étudiant: 22015094

## 1. Manipuler des confitures
### Question 1 :
Écrivez la classe `Confiture avec un constructeur public adapté.
### Réponse 1 :

```java
public class Confiture {
    private String fruit;
    private int proportion;
    private int cal;

    Confiture(String fruit, int proportion, int cal){
        this.fruit = fruit;
        this.proportion = proportion;
        this.cal = cal;
    }
}
```
### Question 2 :
Écrivez un deuxième constructeur qui ne prend en argument que la nature du fruit et le
nombre de calories ; la proportion sera initialisée à 50. (Pensez que vous pouvez réutiliser le
premier constructeur en fixant un paramètre)

### Réponse 2 :
```java
 Confiture(String nature,int cal){
        this.fruit = nature;
        this.cal = cal;
        proportion = 50;
 }
```
### Question 3 :
Écrivez une méthode publique d’objet (c.à.d non statique) `description() et qui renvoie
une chaîne de caractères le décrivant (par exemple : ”Confiture de fraise, 50% de fruit, 120
calories aux 100 grammes”).

### Réponse 3 :
```java
public void description(){
    System.out.printf(
            "Confiture de %s, %d%% de fruit, %d calories aux 100 grammes.\n",
            this.fruit,
            this.proportion,
            this.cal
    );
}
```
### Question 4 :
Dans une méthode `main` située dans une nouvelle classe `Test, créez un objet de type `Confiture
et affichez sa description`

### Réponse 4 :

```java
public class Test {
    public static void main(String[] args) {
        Confiture confiture = new Confiture("Fraise", 50, 120);
        confiture.description();
    }
}
```
### Question 5 :
Dans la classe `Confiture`, écrivez une méthode publique d’objet qui prend en argument une
quantité en grammes, et donne le nombre de calories correspondant à cette quantité pour
cette confiture. (Il faut simplement faire un calcul qui respecte les proportions)

### Réponse 5 :

```java
public int calculerCal(int gramme){
    return (gramme*100)/50;
}
   
```
### Question 6 :
Écrivez une méthode de signature `public boolean egal(Confiture c)` qui s’adresse à une
confiture courante et qui regarde si oui ou non elle a les mêmes attributs que la confiture
c. (pour savoir si deux objets s1 et s2 de type String sont égaux, utilisez de préférence
l’expression `s1.equals(s2)` qui est fournie par java et retourne un booléen)

### Réponse 6 :

```java
public boolean egal(Confiture c){
    return (
        c.fruit.equals(this.fruit) &&
        c.proportion == this.proportion &&
        c.cal == this.cal
    );
}
```

### Question 7 :
On écrit le bout de code suivant situé dans la méthode `main` de la classe `Test.
Quelles lignes ne compilent pas, que produisent les autres ?
```java
Confiture c1 = new Confiture ("fraise", 50 , 120);
Confiture c2 = new Confiture ("fraise", 50 , 120);
System.out.println(c1.egal(c2));
System.out.println(c1 == c2 ;
System.out.println(c1.fruit);
```
### Réponse 7 :
5éme ligne ne compile pas car `fruit est un variable qui est privé.`

### Question 8 :
On voudrait que l’attribut `fruit` ne puisse pas être modifié, même par une méthode de la
classe `Confiture`; comment faire ?

### Réponse 8 :
Pour pouvoir déclarer un attribut qu'on ne peut pas modifier, il faut qu'on ajoute `final` devant le 

### Question 9 :
Écrivez une méthode qui retourne la valeur de l’attribut `fruit`. Écrivez-en une qui permet
de modifier l’attribut `cal`. De quelles familles sont ces méthodes ?

### Réponse 9 :
La famille de getter
```java
public String getFruit(){
    return this.fruit;
}
```
### Question 10 :
En fait la valeur calorique dépend principalement de la quantité de sucre, qui est de 387 Kca
pour 100 g, la valeur calorique du fruit est négligeable. Stockez cette valeur dans une variable
adéquate

### Réponse 10 :
On va ajouter un attribut `int sucre` et on va ajouter aux constructeurs cette ligne suivante:

```java
this.sucre = 387 / 100 * this.proportion;
```
### Question 11 :
Écrivez un modifieur de proportion en précisant son domaine d’utilisation.

### Réponse 11 :

```java
public int setProportion(){
    return this.proportion;
}
```

## 1.2 Mettre les confitures en pots
### Question 1 :
Écrivez la classe Pot avec un constructeur public adapté
### Réponse 1 :
```java
public class Pot {
    Confiture confiture;
    int quantiteConfiture;
}
```

### Question 2 :
Écrivez une méthode publique `description` qui renvoie une chaîne de caractères le décrivant.
Remarquez qu’il n’y a pas d’ambiguïté avec la méthode description de `Confiture`, et que
vous pouvez l’utiliser pour définir celle-ci.

### Réponse 2 :
```java
public void description(Confiture c){
c.description();
}
```
### Question 3 :
On veut numéroter les pots de confitures, à partir de 1, dans l’ordre de leur création. Cette
numérotation doit se faire de manière transparente, c'est-à-dire que l’utilisateur n’aura pas à
intervenir : les numéros seront affectés de manière automatique à la création des pots. Mettez
en place ce mécanisme.



