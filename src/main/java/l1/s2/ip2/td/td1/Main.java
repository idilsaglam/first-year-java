public class Main {


    // Exercice 7 yi yapmadim daha ona bakcam bir daha

    /*
     *****************
     *  Question 10  *
     *****************
     */
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



    public static void main(String[] args){
        /*
         ****************
         *  Question 3  *
         ****************
         */
        // Créer un zèbre mâle de 5 ans, pesant 300 kg s’appelant Marti
        Animal marti = new Animal("Marti",'m',5*365,300,"zebre");

        // Hippopotame femelle de 7 ans, d’une tonne et demie s’appelant Gloria
        Animal gloria = new Animal("Gloria",'f',7*365,1500,"hippopotame");

        /*
         ****************
         *  Question 4  *
         ****************
         */
        // Pour diminiuer le poids de Gloria de 50 kg
        gloria.poids -= 50;

        /*
         ****************
         *  Question 5  *
         ****************
         */
        Animal a = new Animal("Melman",'m',1230,998,"girafe",0);
        Animal b = a;
        b.poids= 950;
        System.out.println(a.poids);
        // Réponse: Ce code affiche le poids de a qui est le même que celui de b donc 950kg.

        Animal.description(new Animal("Rico",'m',1129,30,"manchot",0));
        Animal.descriptionBis(new Animal("Rico",'m',1129,30,"manchot",0));
        System.out.println(lePlusGros(
                new Animal[]{
                        new Animal("lolo", 'f', 300, 20, "girafe", 3),
                        new Animal("tutu", 'm', 2000, 6500, "manchot", 2),
                        new Animal("lala", 'f', 900, 204, "zebre", 5),
                           })
        );

        Zoo zoo = new Zoo("Paris",2,2);

        Zoo.nourrir(zoo);



    }



}
