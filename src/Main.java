import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final int REPORT_YEAR = 2021;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();

        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != 123) {
            if (userInput == 1) {
                manager.getMonthlyReport();
            } else if (userInput == 2) {
                manager.getYearlyReport();
            } else if (userInput == 3) {
                if (manager.verificationMonthlyIncome().isEmpty() && manager.verificationMonthlyExpense().isEmpty()) {
                    System.out.println("Операция успешно завершена");
                } else if (!manager.verificationMonthlyIncome().isEmpty() && manager.verificationMonthlyExpense().isEmpty()) {
                    for (Integer income : manager.verificationMonthlyIncome()) {
                        System.out.println("Обнаружено несоответствие в доходах в месяце: " + income);
                    }
                    System.out.println(manager.verificationMonthlyIncome());
                } else if (manager.verificationMonthlyIncome().isEmpty() && !manager.verificationMonthlyExpense().isEmpty()) {
                    for (Integer expense : manager.verificationMonthlyExpense()) {
                        System.out.println("Обнаружено несоответствие в расходах в месяце: " + expense);
                    }
                } else {
                    for (Integer income : manager.verificationMonthlyIncome()) {
                        System.out.println("Обнаружено несоответствие в доходах в месяце: " + income);
                    }
                    for (Integer expense : manager.verificationMonthlyExpense()) {
                        System.out.println("Обнаружено несоответствие в расходах в месяце: " + expense);
                    }
                }
            } else if (userInput == 4) {
                System.out.println("Информация о всех месячных отчётах:");
                for (ArrayList<String> reports : manager.getMonthlyReports()) {
                    for (String report : reports) {
                        System.out.println(report);
                    }
                }
            } else if (userInput == 5) {
                System.out.println("Информация о годовом отчёте.");
                System.out.println("Отчёт за: " + REPORT_YEAR + " год.");
                System.out.println("Прибыль по каждому месяцу:");
                for (ArrayList<String> reports : manager.getMonthlyProfit()) {
                    for (String report : reports) {
                        System.out.println(report);
                    }
                }
                System.out.println("Cредний доход: " + manager.getYearlyIncomeAVG() + ", средний расход: " + manager.getYearlyExpenseAVG());

            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");

    }


    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("123 - Выйти из приложения");
    }

}