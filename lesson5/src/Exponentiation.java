public class Exponentiation {

    private int number; // число
    private int exponent; // степень
    private int expNumber;


    public Exponentiation(int number, int exponent) {
        this.number = number;
        this.exponent = exponent;
        this.expNumber = 1;
    }

    public void run() { // для более читабельного отображения
        System.out.print(number + "^" + exponent + " = ");
        doExponentiation(number, exponent);
        System.out.println(number);
    }


    public void doExponentiation (int number, int exponent) {
        if(exponent < 0) { // допущение: возводим только в неотрицательные степени
            System.out.println("Не умеем возводить в отрицательную степень :(");
            return;
        }
        if (exponent == 0) {
            this.number = expNumber;
            return;
        }
        exponent--;
        expNumber = expNumber * number;
        doExponentiation(number, exponent);
    }


}
