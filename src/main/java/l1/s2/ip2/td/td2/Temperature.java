package l1.s2.ip2.td.td2;

public class Temperature {
    double temp;
    String unite;

    Temperature(){
       this.temp = 0;
       this.unite = "Kelvin";
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
    @Override
    public String toString(){
        return String.format("%f %s",this.temp, this.unite);
    }

    private Temperature conversionKC(Temperature temperature){
        if(temperature.unite.equals("Kelvin")){
            return  new Temperature(temperature.temp - 273.15,"Celsius");
        }
        return null;
    }

    private Temperature conversionFC(Temperature temperature){
        if(temperature.unite.equals("Fahrenheit")){
            return new Temperature(5./9 * (temperature.temp - 32),"Celsius");
        }
        return null;
    }

    public double read(String unite){
        if(this.unite.equals(unite)){
            return this.temp;
        }
        return Double.NEGATIVE_INFINITY;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Temperature){
            Temperature to = (Temperature)o;
            return (to.unite.equals(this.unite) && to.temp == this.temp);
        }
        return false;
    }

    public boolean plusBasseQue(Temperature t) {
        if(!this.unite.equals(t.unite)) {
            Temperature t1, t2;
            switch (t.unite.toLowerCase()) {
                case "kelvin":
                    t2 = conversionKC(t);
                case "fahrenheit":
                    t2 = conversionFC(t);
                default:
                    t2 = t;
            }
            switch (this.unite.toLowerCase()) {
                case "kelvin":
                    t1 = conversionKC(this);
                case "fahrenheit":
                    t1 = conversionFC(this);
                default:
                    t1 = t;
            }
            return t1.temp < t2.temp;
        }
        return(this.temp < t.temp);
    }

    public double getTemp() {
        return temp;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}
