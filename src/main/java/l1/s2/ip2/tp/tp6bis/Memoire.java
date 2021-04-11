
public class Memoire {
    private Memoire precedente;
    private Memoire suivante;
    private int valeur;

    /**
     * Exercice 1.2
     * Un constructeur qui ne prend aucun paramètre, initialise les deux références à null et valeur à 0.
     */
    public Memoire(){
        this.precedente = null;
        this.suivante = null;
        this.valeur = 0;
    }

    /**
     * Exercice 1.3
     * Un constructeur qui prend la taille de la mémoire en paramètre. La case mémoire à construire doit être la première.
     * @param taille un entier signifiant
     */
    public Memoire(int taille){
        // Initialisons la première case de la mémoire
        this();
        // Nous ajoutons les cases (taille - 1 cases) restant avec une boucle for
        for (int i = 0; i<(taille-1); i++) {
            // Créons une case mémoire vide
            Memoire m = new Memoire();
            // Nous ajoutons cette case de mémoire vide à la fin de notre la case mémoire courant
            // à l'aide de la méthode add(Memoire c) que nous allons implémenté en dessous
            this.add(m);
        }
    }

    private void add(Memoire c) {
        Memoire act = this;
        // Itérons jusqu'à la dernière case de mémoire
        while (act.suivante != null) {
            act = act.suivante;
        }
        // Ajoutons à la fin de la dernière case mémoire
        act.suivante = c;
        // La dernière case mémoire doit être la case précédente de la case c
        c.precedente = act;
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
    public int getValeur(){
        return this.valeur;
    }
    public void setValeur(int valeur){
        this.valeur = valeur;
    }

    private String inspectLeft() {
        Memoire act = this.getPrecedente();
        StringBuilder res = new StringBuilder();
        while (act != null) {
            res.append(" ").append(act.getValeur());
            act = act.getPrecedente();
        }
        return res.toString().trim();
    }
    private String inspectRight() {
        Memoire act = this.getSuivante();
        StringBuilder res = new StringBuilder();
        while (act != null) {
            res.append(" ").append(act.getValeur());
            act = act.getSuivante();
        }
        return res.toString().trim();
    }
    public void inspecte() {
        String left = this.inspectLeft();
        String right = this.inspectRight();
        String val = this.getValeur() + "";
        String valueLine = "";
        if (left.length() != 0) {
            valueLine += left + " ";
        }
        valueLine += val;
        if (right.length() != 0) {
            valueLine += " " + right;
        }
        String dashedLine = "-".repeat(valueLine.length());
        String indicatorLine = " ".repeat((left.length() == 0) ? 0 : (left.length() + 1)) + "^";
        System.out.println(dashedLine);
        System.out.println(valueLine);
        System.out.println(indicatorLine);
        System.out.println(dashedLine);
    }

    public void incrementValeur() {
        this.valeur++;
    }
    public void decrimentValeur() {
        this.valeur--;
    }


}
