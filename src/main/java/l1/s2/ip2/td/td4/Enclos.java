package l1.s2.ip2.td.td4;

public class Enclos {
    private Cellule debut;

    /**
     * Question 1.1 :
     * Un constructeur donnant un enclos vide.
     */
    public Enclos(){
        this.debut = null;
    }

    /**
     * Question 1.2
     * une méthode ajouter qui prend en argument un régime alimentaire et qui ajoute un
     * Animal au début d’un enclos.
     * @param regime une chaîne de caractère qui signifie une regime d"un animal.
     */
    public void ajouter(String regime){
        //Pour ne pas perdre le cellule actuel, on va le garder dans un attribut.
        Cellule c = this.debut;
        this.debut = new Cellule(regime);
        this.debut.setSuivant(c);
    }

    /**
     * Question 1.4
     * une méthode ajouter qui prend en argument un régime alimentaire et qui ajoute un
     * Animal au début d’un enclos.
     * @return le nombre d'animal.
     */
    public int compteAnimal(){
        if(this.debut == null){
            return -1;
        }
        return this.debut.compteAnimal();
    }

    /**
     * Question 1.5
     * une méthode transformant tous les animaux carnivores en herbivore et réciproque- ment.
     */
    public void transformer(){
        if(this.debut == null){
            return;
        }
        this.debut.transformer();
    }

    public void afficher(){
        if(this.debut == null){
            return;
        }
        this.debut.afficher();
    }

}
