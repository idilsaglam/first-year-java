package l1.s2.revision.partiel;

public class Ballon {
    private final static int pressionMaximum = 30; // Disons que la pression maximal de toutes les ballons est 30
    private int airDansLeBallon = 0;
    private boolean estEclate=false;
    private final static int airPourEchaper = 1; // Pour faire un noeud, on a besion minimum 1 air
    private boolean estAttachee = false;

    public Ballon(){
        this.airDansLeBallon = 0;
        this.estEclate = false;
        this.estAttachee = false;
    }

    public int getAirDansLeBallon(){
        return this.airDansLeBallon;
    }

    public void gonfler(int air ){

        if(this.airDansLeBallon < Ballon.pressionMaximum) {
            this.airDansLeBallon +=air;
            return;
        }
        estEclate = true;
    }

    public void laisserDairPourEchaper(){
        if(this.airDansLeBallon > 28){
            this.airDansLeBallon = 28; // pression max - air pour échapper = 30 -2 = 28
        }
    }

    public void faireUnNeoud(){
        this.estAttachee = true;
    }

    public void eclater(){
        this.airDansLeBallon = 0;
        this.estEclate = true;
    }

    public void affichage() {
        if (this.airDansLeBallon <= 30) {
            System.out.printf("Air dans le ballon est %d \n", this.airDansLeBallon);
            return;
        }
        System.out.println("Ballon est éclaté.");
    }
}
