package l1.s2.ip2.td.td2;

public class Temperature {
    double temp;
    String unite;

    Temperature(){
        Temperature temperature = new Temperature(0,"Kelvin");
    }

    Temperature(double temp, String unite){
        this.temp = temp;
        switch(unite.toLowerCase()){
            case "celcius":
                this.unite="Celcius";
                break;
            case "fahrenheit":
                this.unite="Fahrenheit";
                break;
            default:
                this.unite = "Kelvin";
                break;
        }
    }

    Temperature(Temperature t) {
        this.temp = t.temp;
        this.unite = t.unite;
    }

    public void afficher(){
        System.out.println(this.temp + " " + this.unite);
    }

    private void conversionKC(Temperature temperature){
        if(!temperature.unite.equals("Kelvin")){
            return;
        }
        temperature.temp -= 273.15;
    }

    private void conversionFC(Temperature temperature){
        if(!temperature.unite.equals("Fahrenheit")){
            return;
        }
        temperature.temp = 9./5 * temperature.temp + 32;
    }

    public double read(String unite){
        if(this.unite.equals(unite)){
            return this.temp;
        }
        return Double.NEGATIVE_INFINITY;
    }

    public boolean isEqual(Temperature t, Temperature t2){
        if(t.temp == t2.temp && t.unite.equals(t2.unite)){
            return true;
        }
        return false;
    }

    public Temperature plusBasseQue(Temperature t, Temperature t2){
        if(isEqual(t,t2)){
            return t;
        };
        if (t.unite.equals("Kelvin")) {
            conversionKC(t);
        }
        if(t2.unite.equals("Kelvin")){
            conversionKC(t2);
        }
        if(t.unite.equals("Fahrenheit")){
            conversionFC(t);
        }
        if(t2.unite.equals("Fahrenheit")){
            conversionFC(t2);
        }
        if(t.temp > t2.temp){
            return t;
        }
        return t2;
    }


}
