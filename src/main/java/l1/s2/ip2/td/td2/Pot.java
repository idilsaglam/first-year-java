package l1.s2.ip2.td.td2;

public class Pot {
    Confiture confiture;
    int quantiteConfiture;

    Pot(Confiture confiture,int quantiteConfiture){
        this.confiture = confiture;
        this.quantiteConfiture = quantiteConfiture;
    }
    public void description(Confiture c){
       c.description();
    }
    //TODO: Question 3-4-5
}
