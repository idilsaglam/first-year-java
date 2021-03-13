package l1.s2.ip2.td.td6_td7;

public class Liste {
    private Element premier;
    private Element dernier;

    /**
     * Question 1.1:
     * @return la longueur de la liste.
     */
    public int longueur(){
        if(this.premier == null){
            return 0;
        }
        return this.premier.longueurRec();
    }


    /**
     * Question 1.2:
     * Une méthode qui affiche la liste dans l’ordre.
     */
    public void afficher(){
        if(this.premier == null){
            return;
        }
        this.premier.afficherRec();
    }

}
