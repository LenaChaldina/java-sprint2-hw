import java.util.ArrayList;
import java.util.List;

//умеет загружать отчеты, хранить их у себя, верифицировать их, а также статистику выводить
//нужно сделать так, чтобы печать происходила только в Main классе, а
// остальные классы будут просто предоставлять данные по требованию со стороны Main.
public class Manager {
    //хранение
    FileUtil fileUtil = new FileUtil();
    MonthlyReport monthlyReport = new MonthlyReport();
    YearlyReport yearlyReport = new YearlyReport();
    MonthsConverting monthsConverting = new MonthsConverting();
    VerificationReports verificationReports = new VerificationReports();
    //загрузка
    public void getMonthlyReport() {
        String fileName;
        for (int monthNumber = 1; monthNumber <= monthsConverting.COUNT_MONTH_REPORTS; monthNumber++) {
            fileUtil.constructMonthlyReader(monthNumber, monthlyReport);
        }
    }
    //верификация
    public void getYearlyReport() {
        fileUtil.constructYearlyReader("resources/y.2021.csv", yearlyReport);
    }
    public List<Integer> verificationMonthlyIncome(){
        return verificationReports.verificationIncome(monthlyReport, yearlyReport);
    }
    public List<Integer> verificationMonthlyExpense(){
        return verificationReports.verificationExpense(monthlyReport, yearlyReport);
    }
    // месячная статистика
    public ArrayList<ArrayList<String>> getMonthlyReports() {
        return monthlyReport.getMonthlyReports();
    }
    //годовая статистика
    public ArrayList<ArrayList<String>> getMonthlyProfit() {
        return yearlyReport.monthlyProfit();
    }
    public int getYearlyIncomeAVG() {
        return yearlyReport.getYearlyIncomeAVG();
    }
    public int getYearlyExpenseAVG() {
        return yearlyReport.getYearlyExpenseAVG();
    }
}
