
/**
 *
 * @author Дмитрий Рыжиков
 */
package labwork_1_practice;
import java.util.concurrent.TimeUnit;
        
public class Main {


    public static void main(String[] args) throws InterruptedException {
         //Заполняем массив
        Countries[] countries = new Countries[7];
        countries[0] = new Countries("Russia", 17100000, 146700000, "Moscow", 12600000);
        countries[1] = new Countries("Finland", 338000, 5500000, "Helsinki", 655000);
        countries[2] = new Countries("France", 643800, 67800000, "Paris", 2100000);
        countries[3] = new Countries("Andorra", 467, 85400, "Andorra la Vella", 22600);
        countries[4] = new Countries("Singapore", 725, 5700000);
        
        //Шестую страну добавил для теста кода в том случае, когда нет данных о населении;
        countries[6] = new Countries("Jamaica", 10991, "Kingston");
        // И еще интерсная страна - Vatican. У нее площадь < 1 км.кв. В т.ч. и поэтому поле countrySquare - double 
        countries[5] = new Countries("Vatican", .44, 825);       
     
       System.out.println("тестируем метод printAll(Countries[] countries)"); 
       System.out.println();
       
       Countries.printAll(countries); 
        
        System.out.println(); 
        System.out.println("тестируем метод print() для каждой из стран. Страны печатаются все по одной с помощью цикла");
        System.out.println();
        
        for(Countries country : countries) { 
            country.print(); 
        }
        System.out.println();
        System.out.println("еще раз printAll(Countries[] countries), чтобы посмотреть, что изменится после вызова setChangesOfCapital() для страны Франции и изменения данных ее столицы"); 
        System.out.println();
        
        Countries france = countries[2]; 
        france.setChangesOfCapital("Moscow", 12600000); 
        
        Countries.printAll(countries); 
        
        System.out.println();
        System.out.println("С помощью метода getPopulationDensity() получаем значения плотности населения для каждой из стран"); 
        System.out.println();
        
        // Это лишь для того, чтобы Exception метода getPopulationDensity() из-за страны Ямайки не портил вывод в консоль и появлялся в данном случае в самом конце, а не на второй строчке. 
        TimeUnit.SECONDS.sleep(1);         
      
        for(Countries country : countries) {                   
            System.out.println("Плотность населения страны " + country.getCountryName() + " составляет " + country.getPopulationDensity() + " человек / км.кв.");

        }
              
    }
}
    



