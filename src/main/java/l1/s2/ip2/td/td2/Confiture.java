package l1.s2.ip2.td.td2;

public class Confiture {
    private final String fruit;
    private int proportion;
    private int cal;
    private int sucre;

    Confiture(String fruit, int proportion, int cal) {
        this.fruit = fruit;
        this.proportion = proportion;
        this.cal = cal;
        this.sucre = 387 * this.proportion / 100;
    }

    Confiture(String nature, int cal) {
        this(nature, 50, cal);
    }

    public String description(){
        return String.format(
            "Confiture de %s, %d%% de fruit, %d calories aux 100 grammes.",
                this.fruit,
                this.proportion,
                this.cal
        );
    }

    public int calculerCal(int gramme) {
        return this.cal / 100 * gramme;
    }

    public boolean egal(Confiture c){
        return (
            c.fruit.equals(this.fruit) &&
            c.proportion == this.proportion &&
            c.cal == this.cal
        );
    }
    //question 9: Famille de getter
    public String getFruit(){
        return this.fruit;
    }
    public void setCal(int cal){
        this.cal = cal;
    }

    public void setProportion(int proportion){
        this.proportion = proportion;

    }

    public int getSucre() {
        return this.sucre;
    }

}


