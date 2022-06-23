import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileUtil fileUtil = new FileUtil();
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        VerificationReports verificationReports = new VerificationReports();
        MonthsConverting monthsConverting = new MonthsConverting();

        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != 123) {
            if (userInput == 1) {
                String fileName;
                for (int monthNumber = 1; monthNumber <= monthsConverting.COUNT_MONTH_REPORTS; monthNumber++) {
                    fileUtil.constructMonthlyReader(monthNumber, monthlyReport);
                }


            } else if (userInput == 2) {
                fileUtil.constructYearlyReader("resources/y.2021.csv", yearlyReport);

            } else if (userInput == 3) {
                verificationReports.verification(monthlyReport, yearlyReport);
            } else if (userInput == 4) {
                System.out.println("Информация о всех месячных отчётах");
                monthlyReport.printMonthlyReport();
            } else if (userInput == 5) {
                System.out.println("Информация о годовом отчёте.");
                System.out.println("Отчёт за: " + yearlyReport.REPORT_YEAR + " год.");
                System.out.println("Прибыль по каждому месяцу:");
                yearlyReport.monthlyProfit();
                System.out.println("Cредний доход: " + yearlyReport.getYearlyIncomeAVG() +
                        ", средний расход: " + yearlyReport.getYearlyExpenseAVG());

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