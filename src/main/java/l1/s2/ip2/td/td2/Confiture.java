package l1.s2.ip2.td.td2;

public class Confiture {
    private final String fruit;
    private final int proportion;
    private final int cal;
    private final int sucre;

    Confiture(String fruit, int proportion, int cal){
        this.fruit = fruit;
        this.proportion = proportion;
        this.cal = cal;
        this.sucre = 387 / 100 * this.proportion;
    }

    Confiture(String nature,int cal){
        this.fruit = nature;
        this.cal = cal;
        proportion = 50;
        this.sucre = 387 / 100 * this.proportion;
    }
    public void description(){
        System.out.printf(
                "Confiture de %s, %d%% de fruit, %d calories aux 100 grammes.\n",
                this.fruit,
                this.proportion,
                this.cal
        );
    }
    public int calculerCal(int gramme){
        return (gramme*100)/50;
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

    public int setProportion(){
        return this.proportion;
    }

}
