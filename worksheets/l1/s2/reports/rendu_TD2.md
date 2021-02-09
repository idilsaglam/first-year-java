# TD2
**Idil SAGLAM**
Groupe 4
Numéro étudiant: 22015094

## 1. Manipuler des confitures
### Question 1 :
Écrivez la classe `Confiture` avec un constructeur public adapté.
### Réponse 1 :
Nous créons le constructeur dans la classe `Confiture` qui prendre des paramètres dans le même ordre donnée en question.
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
On peut utiliser `this` pour appeler un constructeur qui a été deja construit dans le même classe.
```java
Confiture(String nature,int cal){
    this(nature, 50, cal);
}
```
### Question 3 :
Écrivez une méthode publique d’objet (c.à.d non statique) `description()` et qui renvoie
une chaîne de caractères le décrivant (par exemple : ”Confiture de fraise, 50% de fruit, 120
calories aux 100 grammes”).

### Réponse 3 :
```java
public String description(){
    return String.format(
        "Confiture de %s, %d%% de fruit, %d calories aux 100 grammes.",
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
        System.out.println(confiture.description());
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
    return this.cal / 100 * gramme;
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
5éme ligne ne compile pas car `fruit` est un variable qui est `privé.`

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

```java
public void setCal(int cal){
    this.cal = cal;
}
```
### Question 10 :
En fait la valeur calorique dépend principalement de la quantité de sucre, qui est de 387 Kca
pour 100 g, la valeur calorique du fruit est négligeable. Stockez cette valeur dans une variable
adéquate

### Réponse 10 :
On va ajouter un attribut `int sucre` et on va ajouter aux constructeurs cette ligne suivante:

```java
this.sucre = 387 * this.proportion /100;

```
### Question 11 :
Écrivez un modifieur de proportion en précisant son domaine d’utilisation.

### Réponse 11 :

```java
public void setProportion(int proportion){
    this.proportion = proportion;
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
public String description(){
    return String.format(
        "Pot de %d grammes contient %s",
        this.quantiteConfiture,
        this.confiture.description()
    );
}
```
### Question 3 :
On veut numéroter les pots de confitures, à partir de 1, dans l’ordre de leur création. Cette
numérotation doit se faire de manière transparente, c'est-à-dire que l’utilisateur n’aura pas à
intervenir : les numéros seront affectés de manière automatique à la création des pots. Mettez
en place ce mécanisme.

```java
private static int COUNTER = 0;
final int id;
```

Dans le constructeur; j'ai ajouté les lignes suivantes:

```java
COUNTER++;
this.id = COUNTER;
```
### Question 4 :
Écrivez une méthode qui retourne le dernier numéro attribué. Cette méthode est-elle statique ou non statique ?

### Réponse 4 :
Dans le classe `Pot`
```java
public static int dernierNumero(){
    return COUNTER;
}
```

### Question 5 :
Dans votre classe Test créez plusieurs instances de Pot, affichez leurs descriptions, puis
affichez le dernier numéro attribué.

### Réponse 5 :

```java
Pot pot = new Pot(new Confiture("Fraise",50,120),50);
System.out.printf("Dernier numéro de pot après création d'un premier pot %d\n", Pot.dernierNumero());
Pot pot2 = new Pot(new Confiture("fraise",50,120),20);
System.out.printf("Dernier numéro de pot après création d'un second pot: %d\n", Pot.dernierNumero());
Pot pot3 = new Pot(new Confiture("Orange",90,1040),40);
System.out.printf("Dernier numéro de pot après création d'un troisième pot: %d\n", Pot.dernierNumero());
```
## 2. Témperature

### Question 1 :
Définissez une classe `Temperature`, décrite par un double représentant la température, et un `String` représentant l’unité.

### Réponse 1 :

```java
public class Temperature {
    double temp;
    String unite;
```

### Question 2 :
Définissez un constructeur sans arguments qui lorsqu’il est utilisé produit un objet Temperature à zéro Kelvin.

### Réponse 2 :

```java
Temperature(){
    this.temp = 0;
    this.unite = "Kelvin";
}
```
### Question 3 :
Définissez un deuxième constructeur prenant en argument un `double` et un `String` (Si l’unité n’est pas reconnue elle sera interprétée en Kelvin).

### Réponse 3 :

```java
Temperature(double temp, String unite){
    this.temp = temp;
    switch(unite.toLowerCase()){
        case "celcius":
            this.unite="Celcius";
            break;
        case "fahrenheit":
            this.unite="Fahrenheit";
            break;
        default:
            this.unite = "Kelvin";
            break;
    }
}
```

### Question 4 :
Définissez un troisième constructeur prenant en argument une Temperature et réalisant une copie de celle-ci.

### Réponse 4 :

```java 
Temperature(Temperature t) {
    this.temp = t.temp;
    this.unite = t.unite;
}
```
### Question 5 :
Définissez des méthodes permettant d’afficher et de modifier chaque élément d’une Temperature (sans vous poser de questions de conversions, c’est abordé dans la suite).

### Réponse 5 :

```java
public double getTemp() {
    return temp;
}

public String getUnite() {
    return unite;
}

public void setUnite(String unite) {
    this.unite = unite;
}

public void setTemp(double temp) {
    this.temp = temp;
}
```

### Question 6 :
Définissez une méthode privée conversionKC, non statique, produisant un nouvel objet Temperature. Lorsque this est bien en Kelvin le résultat sera sa conversion en Celsius, sinon elle ne produira pas de nouvel objet. On rappelle la formule TC = TK − 273.15 .

### Réponse 6 :
```java
private Temperature conversionKC(Temperature temperature){
    if(temperature.unite.equals("Kelvin")){
        return  new Temperature(temperature.temp - 273.15,"Celsius");
    }
    return null;
}
```

### Question 7 :
Supposons que l’on ait écrit suffisamment de méthodes de conversions sur le modèle de la précédente (on rappelle par exemple la formule TF = 9/5∗TC +32). Écrivez une méthode read qui prend en argument une unité et renvoie la valeur numérique d’un objet Temperature dans l’unité spécifiée en argument.

### Réponse 7 :
Pour le méthode FC
```java 
private Temperature conversionFC(Temperature temperature){
    if(temperature.unite.equals("Fahrenheit")){
        return new Temperature(5./9 * (temperature.temp - 32),"Celsius";
    }
    return null;
 }
```
Pour le méthode `read`
```java
public double read(String unite){
    if(this.unite.equals(unite)){
        return this.temp;
    }
    return Double.NEGATIVE_INFINITY;
}
```

### Question 8 :
Comment tester l’égalité de deux objets Temperatures ?

### Réponse 8 :

```java
@Override
    public boolean equals(Object o){
        if(o instanceof Temperature){
            Temperature to = (Temperature)o;
            return (to.unite.equals(this.unite) && to.temp == this.temp);
        }
        return false;
    }
```

### Question 9 :
Définir une méthode plusBasseQue permettant de comparer deux Temperatures.

### Réponse 9 :

```java
public boolean plusBasseQue(Temperature t) {
    if(!this.unite.equals(t.unite)) {
        Temperature t1, t2;
        switch (t.unite.toLowerCase()) {
             case "kelvin":
                t2 = conversionKC(t);
            case "fahrenheit":
                 t2 = conversionFC(t);
            default:
                 t2 = t;
        }
           
        switch (this.unite.toLowerCase()) {
            case "kelvin":
                t1 = conversionKC(this);
            case "fahrenheit":
                t1 = conversionFC(this);
            default:
                t1 = t;
        }
        return t1.temp < t2.temp;
    }
    return(this.temp < t.temp);
}
```