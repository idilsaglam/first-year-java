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

    private Temperature conversionKC(){
        if(this.unite.equals("Kelvin")){
            return  new Temperature(this.temp - 273.15,"Celsius");
        }
        return null;
    }

    private Temperature conversionFC(){
        if(this.unite.equals("Fahrenheit")){
            return new Temperature(5./9 * (this.temp - 32),"Celsius");
        }
        return null;
    }

    private Temperature conversationFK(){
        if(this.unite.equals("Fahrenheit")){
            return new Temperature((((this.temp-32) * 5) / 9) + 273.15,"Kelvin");
        }
        return null;
    }

    private Temperature conversationKF(){
        if(this.unite.equals("Kelvin")){
            return new Temperature((this.temp-273.15)*1.8000,"Fahrenheit");
        }
        return null;
    }
    private Temperature conversationCF(){
        if(this.unite.equals("Celcius")){
            return new Temperature((this.temp*1.8000+32.00),"Fahrenheit");
        }
        return null;
    }

    private Temperature conversationCK(){
        if(this.unite.equals("Celcius")){
            return new Temperature(this.temp+273.15,"Kelvin");
        }
        return null;
    }

    public double read(String unite){
        if(this.unite.equals(unite)){
            return this.temp;
        }
        if(unite.equals("Celcius") && this.unite.equals("Fahrenheit")){
            return conversionFC().temp;
        }
        if(unite.equals("Celcius") && this.unite.equals("Kelvin")){
            return conversionKC().temp;
        }
        if(unite.equals("Fahrenheit") && this.unite.equals("Kelvin")){
            return conversationKF().temp;
        }
        if(unite.equals("Kelvin") && this.unite.equals("Fahrenheit")){
            return conversationFK().temp;
        }
        if(unite.equals("Celcius") && this.unite.equals("Fahrenheit")){
            return conversationCF().temp;
        }
        return conversationCK().temp;
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
        if(this.unite.equals(t.unite)) {
            return(this.temp < t.temp);
        }
        return (this.read(t.unite) < t.temp);
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
