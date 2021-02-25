package l1.s2.ip2.td.td4;

public class Animal{
    private String regime;
    Animal(String regime){
        this.regime = regime;
    }

    public String getRegime() {
        return regime;
    }
    public void setRegime(String s) {
       this.regime = s;
    }
    public void transformer(){
        if(this.regime.equalsIgnoreCase("herbivore")){
            this.regime = "carnivore";
        }else{
            this.regime="herbivore";
        }
    }

    public void afficher(){
        System.out.println(this.regime + "\n");
    }

}
