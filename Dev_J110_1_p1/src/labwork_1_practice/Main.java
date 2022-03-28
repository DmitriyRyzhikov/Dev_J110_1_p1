/**
 *
 * @author Дмитрий Рыжиков
 */
package labwork_1_practice;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        //Создайте массив из нескольких стран, заполните его следующими данными:
        Countries[] countries = new Countries[7];
        countries[0] = new Countries("Russia", 17100000, 146700000, "Moscow", 12600000);
        countries[1] = new Countries("Finland", 338000, 5500000, "Helsinki", 655000);
        countries[2] = new Countries("France", 643800, 67800000, "Paris", 2100000);
        countries[3] = new Countries("Andorra", 467, 85400, "Andorra la Vella", 22600);
        countries[4] = new Countries("Singapore", 725, 5700000);

        //Шестую страну добавил для теста кода в том случае, когда нет данных о населении;
        countries[6] = new Countries("Jamaica", 10991, "Kingston");
        // И еще интерсная страна - Vatican. У нее площадь < 1 км.кв. 
        countries[5] = new Countries("Vatican", .44, 825);

        //Распечатайте содержимое массива при помощи подходящих методов класса.(статический метод printAll(Countries[] countries) )
        Countries.printAll(countries);
        
        System.out.println();
        
        //Распечатайте содержимое массива при помощи подходящих методов класса.(метод print())
        for (Countries country : countries) {
            country.print();
        }
    }
}
