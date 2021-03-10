package l1.s2.ip2.td.td4;

public class Cellule {
    private Animal animal;
    private Cellule suivant;

    /**
     * Question 1.1
     * un constructeur recevant un argument de type String, et permet-
     * tant d’intégrer un nouvel animal ayant ce régime.
     * @param regime une chaîne de caractère qui signifie régime d'animal.
     */
    public Cellule(String regime){
        this.animal = new Animal(regime);
    }

    public Cellule getSuivant() {
        return suivant;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setSuivant(Cellule suivant) {
        this.suivant = suivant;
    }

    /**
     * Question 1.4
     * Une méthode pour compter le nombre d'animaux.
     * @return res qui est le nombre d'animaux.
     */
    public int compteAnimal(){
        Cellule actuel = this;
        int res = 0;
        while(actuel.suivant != null){
            res++;
            actuel = actuel.suivant;
        }
        return res;
    }

    /**
     * Question 1.5
     *  une méthode transformant tous les animaux carnivores en herbivore et réciproquement.
     */
    public void transformer(){
        Cellule actuel = this;
        while(actuel.animal != null) {
            actuel.animal.transformer();
            actuel = actuel.suivant;
        }
    }

    /**
     * Question 1.6
     * Écrivez une méthode affichant le régime de tous les animaux de la liste (dans l’ordre qui vous convient).
     */
    public void afficher(){
        Cellule actuel = this;
        while(actuel.animal != null){
            actuel.animal.afficher();
            actuel = actuel.suivant;
        }
    }

    /*
     * Question 2.1
     * Donnez l’évolution de l’enclos lors des trois premiers tours de jeu sur les deux exemples:
     * 1. tout herbivore ayant commencé le tour à côté d’un carnivore est mangé (et retiré de la liste)
     * 2. une fois la règle précédente appliquée, si deux herbivores sont côte à côte, un nouvel herbivore
     * est placé entre les deux, disponible pour le tour suivant.
     */
    //TODO:
    public void evolution(){
        Cellule actuel = this;
        while (actuel.suivant != null){
            if(actuel.animal.getRegime().equals("carnivore") && actuel.suivant.animal.getRegime().equals("herbivore")){
                // actuel.suivant.anmal i cikar
            }
            actuel = actuel.suivant;
        }
    }


}
