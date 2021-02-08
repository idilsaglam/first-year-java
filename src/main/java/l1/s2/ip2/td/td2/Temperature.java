package l1.s2.ip2.td.td2;

import java.util.Locale;

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

}
