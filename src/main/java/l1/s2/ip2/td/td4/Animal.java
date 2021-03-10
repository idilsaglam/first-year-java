package l1.s2.ip2.td.td4;

public class Animal {
    private String regime;

    public Animal(String regime){
        this.regime = regime;
    }
    public String getRegime(){
        return this.regime;
    }
    public void setRegime(String regime){
        this.regime = regime;
    }

    /**
     * Question 1.5
     *  une méthode transformant tous les animaux carnivores en herbivore et réciproque- ment.
     */
    public void transformer(){
        if(this.regime.equals("herbivore")) {
            this.regime = "carnivore";
            return;
        }
        this.regime = "herbivore";
    }

    /**
     * Question 1.6
     *  une méthode affichant le régime de tous les animaux de la liste (dans l’ordre qui vous convient).
     */
    public void afficher(){
        System.out.printf("Régime d'animal est %s",this.regime);
    }


}
