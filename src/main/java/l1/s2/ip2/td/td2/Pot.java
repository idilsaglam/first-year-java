package l1.s2.ip2.td.td2;

public class Pot {
    private static int COUNTER = 0;
    Confiture confiture;
    int quantiteConfiture;
    final int id;
    Pot(Confiture confiture,int quantiteConfiture){
        this.confiture = confiture;
        this.quantiteConfiture = quantiteConfiture;
        COUNTER++;
        this.id = COUNTER;
    }
    public String description(){
       return String.format(
               "Pot de %d grammes contient %s",
               this.quantiteConfiture,
               this.confiture.description()
       );
    }
    public static int dernierNumero(){
        return COUNTER;
    }
}
