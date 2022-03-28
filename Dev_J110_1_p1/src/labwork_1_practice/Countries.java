package labwork_1_practice;

public class Countries {

    private String countryName;
    private String capitalName;
    private int countryPopulation;
    private int capitalPopulation;
    private double countrySquare;

/*  *Доработайте класс так, чтобы он мог обрабатывать случай, когда население страны (и столицы, если она есть) неизвестно. 
    Доработайте метод print, чтобы он корректно выводил информацию о стране в этом случае (метод доработан ниже).
    
    конструктор используем для случаев, когда нет данных о численности населения.
*/    
    public Countries(String countryName, double countrySquare, String capitalName) {
        setCountryName(countryName);
        setCapitalName(capitalName);
        setCountrySquare(countrySquare);
    }

    // второй конструктор - (для городов-государств) принимает только название, площадь и население страны, оставляя данные о столице пустыми;
    public Countries(String countryName, double countrySquare, int countryPopulation) {
        setCountryName(countryName);
        setCountrySquare(countrySquare);
        setCountryPopulation(countryPopulation);
    }

    // конструктор, принимающий значения всех атрибутов;
    public Countries(String countryName, double countrySquare, int countryPopulation, String capitalName, int capitalPopulation) {
        this(countryName, countrySquare, countryPopulation);
        setCapitalName(capitalName);
        setCapitalPopulation(capitalPopulation);
    }

    //гетеры для поей классса:
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

    //сеттеры для полей класса, Стринги проверяем на null, на лишние пробелы перед и до имени и на пустую строку
    public final void setCountryName(String countryName) {
        if (countryName != null && !countryName.trim().isEmpty()) 
            this.countryName = countryName.trim();
        else
            throw new IllegalArgumentException("У страны должно быть название");
    }

    public final void setCountrySquare(double countrySquare) {
        if (countrySquare > 0) 
            this.countrySquare = countrySquare;
        else
            throw new IllegalArgumentException("Значение площади должно быть больше ноля");
    }

    public final void setCountryPopulation(int countryPopulation) {
        if (countryPopulation > 0) 
            this.countryPopulation = countryPopulation;
        else
            throw new IllegalArgumentException("Значение численности населения, должно быть больше ноля");
    }

    public final void setCapitalName(String capitalName) {
        if (capitalName != null && !capitalName.trim().isEmpty()) 
            this.capitalName = capitalName.trim();
        else
            throw new IllegalArgumentException("У столицы страны должно быть название");
    }

    public final void setCapitalPopulation(int capitalPopulation) {
        if (capitalPopulation > 0) 
            this.capitalPopulation = capitalPopulation;
        else
            throw new IllegalArgumentException("Значение численности населения столицы государства, должно быть больше ноля");     
    }
    
    //метод, задающий/сбрасывающий данные о столице
    public void setChangesOfCapital(String capitalName, int capitalPopulation) {
            setCapitalName(capitalName);
            setCapitalPopulation(capitalPopulation); 
    }

    //get-метод, возвращающий значение плотности населения страны;
    public int getPopulationDensity() {
        if (countryPopulation != 0) 
            return (int) Math.round((double) countryPopulation / countrySquare);
        else
            throw new IllegalArgumentException("Невозможно вычислить плотность населения. Данные о численности населения отсутствуют.");
    }
    
    //метод print, печатающий данные о стране (название, площадь, население) и о столице, если она есть;
    public void print() {
        String S1 = "Название страны:";
        String S2 = "Площадь страны(км.кв.):";
        String S3 = "Численность населения(человек):";
        String S4 = "Столица:";
        String S5 = "Численность населения столицы (человек):";
        String S6 = "Cтолицы нет. Эта страна - город государство.";
        String S7 = "нет данных";

        if (capitalName == null && capitalPopulation == 0) {
            System.out.printf("%s %-10s %-10s %,-14.2f %-5s %,-12d %s %-10s %n", S1, countryName, S2, countrySquare, S3, countryPopulation, S4, S6);
        } else if (countryPopulation == 0 && capitalPopulation == 0) {
            System.out.printf("%s %-10s %-10s %,-14.2f %-5s %-12s %-5s %-16s %-5s %s %n", S1, countryName, S2, countrySquare, S3, S7, S4, capitalName, S5, S7);
        } else {
            System.out.printf("%s %-10s %-10s %,-14.2f %-5s %,-12d %s %-16s %-5s %,d %n", S1, countryName, S2, countrySquare, S3, countryPopulation, S4, capitalName, S5, capitalPopulation);
        }
    }
    
    //статический метод printAll, печатающий данные о странах в заданном массиве.
    public static void printAll(Countries[] countries) {
        String S1 = "Название страны:";
        String S2 = "Площадь страны(км.кв.):";
        String S3 = "Численность населения(человек):";
        String S4 = "Столица:";
        String S5 = "Численность населения столицы (человек):";
        String S6 = "Cтолицы нет. Эта страна - город государство.";
        String S7 = "нет данных";
        
        for (Countries country : countries) {
            //страна, где данные о численности населения отсутствуют 
            if (country.getCountryPopulation() == 0 && country.getCapitalPopulation() == 0)           
                System.out.printf("%s %-10s %-10s %,-14.2f %-5s %-12s %-5s %-16s %-5s %s %n", S1, country.getCountryName(), S2, country.getCountrySquare(), S3, S7, S4, country.getCapitalName(), S5, S7);
            
            //город-государство  
             else if (country.getCapitalName() == null)            
                System.out.printf("%s %-10s %-10s %,-14.2f %-5s %,-12d %s %-10s %n", S1, country.getCountryName(), S2, country.getCountrySquare(), S3, country.getCountryPopulation(), S4, S6);
             
             //страна, где известны все данные
             else 
                System.out.printf("%s %-10s %-10s %,-14.2f %-5s %,-12d %s %-16s %-5s %,d %n", S1, country.getCountryName(), S2, country.getCountrySquare(), S3, country.getCountryPopulation(), S4, country.getCapitalName(), S5, country.getCapitalPopulation());           
        }
    }
}
