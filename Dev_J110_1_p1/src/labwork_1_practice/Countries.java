
package labwork_1_practice;

public class Countries {  
    
    private String countryName, capitalName;
    private int countryPopulation, capitalPopulation;
    private double countrySquare;
    
    public static final String S1 = "Название страны:";
    public static final String S2 = "Площадь страны(км.кв.):";
    public static final String S3 = "Численность населения(человек):";
    public static final String S4 = "Столица:";
    public static final String S5 = "Численность населения столицы (человек):";
    public static final String S6 = "Cтолицы нет. Эта страна - город государство.";
    public static final String S7 = "нет данных";
                    
    public Countries(String countryName, double countrySquare, int countryPopulation, String capitalName, int capitalPopulation) {
        this(countryName, countrySquare, countryPopulation);
        setCapitalName(capitalName);
        setCapitalPopulation(capitalPopulation);
    }

    public Countries(String countryName, double countrySquare, int countryPopulation) {
        setCountryName(countryName);   
        setCountrySquare(countrySquare);
        setCountryPopulation(countryPopulation);
    }
     // Третий конструктор нужен для случаев, когда нет данных о численности населения.
    public Countries(String countryName, double countrySquare, String capitalName) {
        setCountryName(countryName);
        setCapitalName(capitalName);
        setCountrySquare(countrySquare);
    }
    
    public String getCountryName() {
        return countryName;
    }

    public double getCountrySquare() {
        return countrySquare;
    }

    public int getCountryPopulation() {
        return countryPopulation;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public int getCapitalPopulation() {
        return capitalPopulation;
    }
   
    public final void setCountryName(String countryName) {
        if(countryName == null)
            throw new IllegalArgumentException("У страны должно быть название");
        this.countryName = countryName;
    }

    public final void setCountrySquare(double countrySquare) {
        if(countrySquare <= 0)
           throw new IllegalArgumentException("Значение площади должно быть больше ноля"); 
        this.countrySquare = countrySquare;
    }

    public final void setCountryPopulation(int countryPopulation) { 
        if(countryPopulation <= 0)
            throw new IllegalArgumentException("Значение численности населения, должно быть больше ноля"); 
        this.countryPopulation = countryPopulation;
    }

    public final void setCapitalName(String capitalName) {
        if(capitalName == null)
            throw new IllegalArgumentException("У столицы страны должно быть название");
        this.capitalName = capitalName;
    }

    public final void setCapitalPopulation(int capitalPopulation) {
        if(capitalPopulation <= 0)
            throw new IllegalArgumentException("Значение численности населения столицы государства, должно быть больше ноля"); 
        this.capitalPopulation = capitalPopulation;
    }
    
    public void setChangesOfCapital(String capitalName, int capitalPopulation) {
        if(capitalName == null || capitalPopulation <= 0)
            throw new IllegalArgumentException("У столицы государства должно быть название. Значение численности населения столицы государства, должно быть больше ноля"); 
                 setCapitalName(capitalName);
                 setCapitalPopulation(capitalPopulation);                 
    }
    
    public int getPopulationDensity() {

        if(countryPopulation == 0)
           throw new IllegalArgumentException("Невозможно вычислить плотность населения. Данные о численности населения отсутствуют.");
      
        return (int) Math.round((double)countryPopulation / countrySquare);
    }
    
    public void print(){

        if(capitalName == null && capitalPopulation == 0) 
            System.out.printf("%s %-10s %-10s %,-14.2f %-5s %,-20d %s %-10s %n", S1, countryName, S2, countrySquare, S3, countryPopulation, S4, S6); 
        else if(countryPopulation == 0 && capitalPopulation == 0)
            System.out.printf("%s %-10s %-10s %,-14.2f %-5s %-12s %-5s %-20s %-5s %s %n", S1, countryName, S2, countrySquare, S3, S7, S4, capitalName, S5, S7); 
        else
            System.out.printf("%s %-10s %-10s %,-14.2f %-5s %,-20d %s %-20s %-5s %,d %n", S1, countryName, S2, countrySquare, S3, countryPopulation, S4, capitalName, S5, capitalPopulation);     
    }
    
    public static void printAll(Countries[] countries) {
        for (Countries country : countries) {
            if(country.getCountryPopulation() == 0 && country.getCapitalPopulation() == 0) 
                //страна, где данные о численности населения отсутствуют
                System.out.printf("%s %-10s %-10s %,-14.2f %-5s %-12s %-5s %-20s %-5s %s %n", S1, country.getCountryName(), S2, country.getCountrySquare(), S3, S7, S4, country.getCapitalName(), S5, S7); 
            else if(country.getCapitalName() == null)
                //город-государство
                System.out.printf("%s %-10s %-10s %,-14.2f %-5s %,-20d %s %-10s %n", S1, country.getCountryName(), S2, country.getCountrySquare(), S3, country.getCountryPopulation(), S4, S6); 
            else 
                //полноценная страна
                System.out.printf("%s %-10s %-10s %,-14.2f %-5s %,-20d %s %-20s %-5s %,d %n", S1, country.getCountryName(), S2, country.getCountrySquare(), S3, country.getCountryPopulation(), S4, country.getCapitalName(), S5, country.getCapitalPopulation()); 
        }
    }
}    
   

