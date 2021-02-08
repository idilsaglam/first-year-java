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

    public boolean ajouteAnimal(Animal animal) {
        for (int i = 0; i<this.contenu.length; i++) {
            Enclos e = this.contenu[i];
            if (e.ajouteAnimal(animal)) {
                return true;
            }
        }
        return false;
    }

    public static void nourrir(Zoo zoo){
        for (int i = 0; i < zoo.contenu.length; i++) {
            for (int j = 0; j < zoo.contenu[i].tabAnimal.length; j++) {
                if ( zoo.contenu[i].tabAnimal[j].faim > 5) {
                    zoo.contenu[i].tabAnimal[j].nourrir();
                }
            }
        }
    }
    private void tueAnimal(Animal animal) {
        for(int i=0; i<this.contenu.length; i++){
            for(int j=0; j<this.contenu[i].tabAnimal.length; j++){
                if(this.contenu[i].tabAnimal[j].equals(animal)){
                    this.contenu[i].tueAnimal(animal);
                }
            }
        }
    }
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

}
