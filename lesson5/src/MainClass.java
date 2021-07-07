public class MainClass {

    public static void main(String[] args) {

        // Возведение в степень
        new Exponentiation(2,3).run(); // общий случай возведения в степень
        new Exponentiation(2,1).run(); // частный случай: любое число в степени 1 = число
        new Exponentiation(2,0).run(); // частный случай: любое число в степени 0 = 1
        new Exponentiation(3, -5).run(); // частный случай: выдаём ошибку

        // Задача с рюкзаком
        Begpack testBegpack = new Begpack(5);
        Staff[] staffs = {
            new Staff("Книга", 1, 600),
            new Staff("Бинокль", 2, 5000),
            new Staff("Аптечка",4,1500),
            new Staff("Ноутбук",2,40000),
            new Staff("Котелок",1,500),
        };
        testBegpack.bestPacking(staffs);

    }


}
