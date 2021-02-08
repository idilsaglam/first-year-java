public class Enclos {
    public Animal[] tabAnimal;
    public int population;
    Enclos (int maxSize, int population) {
        tabAnimal = new Animal[maxSize];
        this.population = population;
    }

    public boolean ajouteAnimal(Animal a){
        if (this.tabAnimal.length > this.population) {
            this.tabAnimal[this.population] = a;
            this.population++;
            return true;
        }
        return false;
    }

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

}
