package l1.s2.ip2.tp.tp8;

public class Robot {
    private static int nbRob=0;
    private int id;
    private int np; //nombre de paroles restantes à prononcer
    private char nom;

    /**
     * Exercice 1.2
     * Un constructeur qui prenne en argument un nom et un texte, qui gère correctement l’identifiant unique,
     * et qui initialise np avec le nombre de lettres dans texte.
     * @param nom un char signifiant le nom du robot.
     * @param texte une chaîne de caractère signifiant les paroles que le robot va prononcer.
     */
    public Robot(char nom, String texte){
        Robot.nbRob++;
        this.id = nbRob;
        this.np=texte.length();
        this.nom = nom;
    }

    public int getId(){
        return this.id;
    }
    public char getNom(){return this.nom;}
    public int getNp(){return this.np;}

    /**
     * Exercice 1.3
     * Une méthode qui renvoie un booléen indiquant si le robot a fini de parler
     * @return true si le robot a fini de parler sinon false
     */
    public boolean finitDeParler() {
        return (this.np == 0);
    }


    /**
     * Exercice
     * @param n un entier signifiant de nombre des lettres qu'ils vont prononcer par le robot
     * @return le nombre de lettres restants à prononcer.
     */
    public int parle(int n){
        int newNb = this.np - n;
        if(newNb < 0){
            this.np = 0;
            return 0;
        }
        this.np = newNb;
        return newNb;
    }

    /**
     * Exercice 2.2
     */
    public void description(){
        System.out.printf("id du robot est: %d et le nombre de paroles restantes à prononcer: %d \n ",this.id,this.np);
    }


}
