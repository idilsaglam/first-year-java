package l1.s2.ip2.tp.tp4;

public class Robot {
    private final char nom; //lettre entre 'a' et 'z'.
    private int energie;
    private final String texte;

    /**
     * @param  nom est un caractère qui signifie le nom de robot^
     * @param paroles est une chaîne de caractère, il signifie les paroles de robot.
     */
    public Robot(char nom, String paroles){
        this.nom = nom;
        //on donne une énergie entre 10 et 20
        this.energie = 10 + (int)(Math.random()*11);
        this.texte = paroles;
    }

    /**
     * Question 1.1 : Une méthode qui permets de décrire un robot.
     * @return le description du robot(son nom, sa énergie et ses paroles).
     */
    public String description(){
        return (
                "Robot " +
                this.nom +
                " dit " +
                this.texte +
                " quand il parle et a " +
                this.energie + " points d'énergie."
                );
    }

    /**
     * Question 1.2 : Une méthode qui vérifie qu'un robot a bien comme nom une
     * lettre de l’alphabet minuscule ou pas.
     * @return true si elle est une lettre de l'alphabet minuscule, false sinon.
     */
    public boolean nomCorrect(){
        return(this.nom >= 'a' && this.nom <= 'z');
    }

    /**
     * Question 1.3: Une méthode permettant de récupérer les valeurs différents attributs de Robot
     * Comme les attributs (nom et texte ) sont privés, on ne peut pas les accéder dans les autres classes.
     * Pour pouvoir les accéder et garder ses visibilités "private" en même temps, il faut que nous écrivons
     * les méthodes des 'getter'
     * @return la valeur de l'attribut privé.
     */
    public char getNom(){
        return this.nom;
    }

    /**
     * Méthode retourne l'énergie du robot actuel
     * @return energie du robot
     */
    public int getEnergie(){
        return this.energie;
    }

    /**
     * Méthode retourne le texte associé au robot
     * @return texte associe au robot
     */
    public String getTexte(){
        return this.texte;
    }

    /**
     * Comme l'attribut 'énergie' est privé, on ne peut pas y modifier dans les autres classes.
     * Pour pouvoir le modifier et garder son visibilité "private" en même temps, il faut que nous écrivons
     * le méthode 'setter'
     */
    public void setEnergie(int energie){
        this.energie = energie;
    }

    /**
     * Question 3.5 : Après avoir chanté il perdra 10 points d’énergie (sans pouvoir passer en dessous de zéro).
     */
    public String chante(){
        String res = "";
        for(int i=0; i<this.getNum(); i++){
            res+= this.getTexte();
        }
        if(this.energie - 10 >= 0){
            this.energie -= 10;
        } else {
            this.energie = 0;
        }
        return res;
    }

    /**
     * Méthode retourne la valeur entière pour le nom du robot
     * @returns l'entier correspondant au numéro du robot
     */
    public int getNum() {
        return this.nom - 'a' + 1;
    }
}
