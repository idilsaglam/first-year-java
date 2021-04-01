package l1.s2.ip2.tp.tp6bis;

public class Memoire {
    private Memoire precedente;
    private Memoire suivante;
    private int nb;

    /**
     * Exercice 1.2
     * Un constructeur qui ne prend aucun paramètre, initialise les deux références à null et valeur à 0.
     */
    public Memoire(){
        this.precedente = null;
        this.suivante = null;
        this.nb = 0;
    }

    /**
     * Exercice 1.3
     * Un constructeur qui prend la taille de la mémoire en paramètre. La case mémoire à construire doit être la première.
     * @param taille un entier signifiant
     */
    public Memoire(int taille){

    }

    /**
     * Exercice 1.4:
     * Des getters pour les 3 attributs privés, et un setter pour valeur.
     */
    public Memoire getSuivante(){
        return this.suivante;
    }
    public Memoire getPrecedente(){
        return this.precedente;
    }
    public int getNb(){
        return this.nb;
    }
    public void setNb(int nb){
        this.nb = nb;
    }

    public void afficher(){

    }
}
