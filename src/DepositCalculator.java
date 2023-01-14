import java.util.Scanner;
//Вот здесь, кажется, не нужно столько строк пропускать. Но я не ручаюсь - вопрос к обсуждению, как это в Практикуме заведено.

public class DepositCalculator {
    double calculateComplexPercent(double a, double y, int d ) {
        //Строка 5: я бы имена параметрам метода раздал. Очень похожий метод calculateSimplePercent, я из него взял.
        double pay = a * Math.pow((1 + y / 12), 12 * d);

        return round (pay, 2);
    }
// Строка 9: после round не нужен пробел.
    double calculateSimplePercent (double amount, double yearRate, int depositPeriod) {
        return round (amount+amount * yearRate *depositPeriod, 2);
    }
// Строка 11: после calculateSimplePercent не нужен пробел.
// Строка 12: После round не нужен пробел. А вот арифметические действия через пробелы.
    double round (double value, int places) {
        double scaLe= Math.pow(10, places);

        return Math.round(value * scaLe) / scaLe;
    }
// Строка 17: после round пробел лишний.
// Строка 18: равно через пробелы =)
    void calculateDeposit()    {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
// Инициализацию scanner, мне кажется, нужно наверх ко всем инициализациям - она самая общая. я обчно иду от общего к частному, так вроде бы понятнее.
        int amount = scanner.nextInt();
// Строка 31: ну знаю, как насчёт строки 31, я вынес инициализацию переменной к остальным в методе. Можно пообсуждать.
        System.out.println("Введите срок вклада в годах:") ;

        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");

        action = scanner.nextInt();
        double result = 0;

        if (action == 1) {
            result = calculateSimplePercent (amount, 0.06, period);
        } else if (action == 2) {
            result = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }
// В calculateDeposit пробелов многовато и не совсем прослеживается логика их расстановки. Возможно, я оказался непонятливым.
    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }

}

// В целом - код вполне себе понятный. Имена переменных, методов понятные.
// Расскажу маленький лайфхак. Когда откроешь этот код, прежде чем что-то менять - нажми сочетание Ctrl + Alt + L.