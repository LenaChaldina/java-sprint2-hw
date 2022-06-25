import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class MonthlyReport {
    MonthsConverting monthsConverting = new MonthsConverting();
public List<MonthlyRecord> monthlyRecords;
    MonthlyReport() {
        this.monthlyRecords = new ArrayList<>();
    }
    public void addRecord(MonthlyRecord record) {
       this.monthlyRecords.add(record);
    }
     //список общих доходов по каждому из месяцев
    public HashMap monthlyIncome(){
        HashMap<Integer, Integer> monthlyIncome = new HashMap<>();
        for(int i=1;i<=monthsConverting.COUNT_MONTH_REPORTS;i++) {
            int sumMonthlyIncome = 0;
            for(MonthlyRecord monthly: monthlyRecords) {
                if (monthly.isExpense == false && monthly.monthNumber == i) {
                    sumMonthlyIncome += monthly.quantity * monthly.sumOfOne;
                }
            }
            monthlyIncome.put(i,sumMonthlyIncome);
        }
        return monthlyIncome;
    }

    //список общих расходов по каждому из месяцев
    public HashMap monthlyExpense(){
        HashMap <Integer, Integer> monthlyExpense = new HashMap<>();
        for(int i=1;i<=monthsConverting.COUNT_MONTH_REPORTS;i++) {
            int sumMonthlyExpense = 0;
            for(MonthlyRecord monthly: monthlyRecords) {
                if (monthly.isExpense == true && monthly.monthNumber == i) {
                    sumMonthlyExpense += monthly.quantity * monthly.sumOfOne;
                }
            }
            monthlyExpense.put(i,sumMonthlyExpense);
        }
        return monthlyExpense;
    }
  /*  Информация о всех месячных отчётах
    Название месяца;
    Самый прибыльный товар, то есть товар для которого is_expense == false, а произведение количества
            (quantity) на сумму (sum_of_one) максимально. Вывести название товара и сумму;
    Самую большую трату. Вывести название товара и сумму.
    Эта информация должна выводиться по каждому из месяцев. */
    public ArrayList<ArrayList<String>> getMonthlyReports() {
        ArrayList<String> consistMonthlyReport = new ArrayList<>();
        ArrayList<ArrayList<String>> consistMonthlyReports = new ArrayList<>();
        for(int i=1;i<=monthsConverting.COUNT_MONTH_REPORTS;i++) {
            int maxMonthlyIncome = 0;
            int monthlyIncome = 0;
            String maxItemNameIncome = "";
            int maxMonthlyExpense = 0;
            int monthlyExpense = 0;
            String maxItemNameExpense = "";
            //месячные доходы
            for(MonthlyRecord monthly: monthlyRecords) {
                if (monthly.isExpense == false && monthly.monthNumber == i) {
                    monthlyIncome = monthly.quantity * monthly.sumOfOne;
                    if(monthlyIncome>maxMonthlyIncome) {
                        maxMonthlyIncome = monthlyIncome;
                        maxItemNameIncome = monthly.itemName;
                    }
                }
            }
            //месячные траты
            for(MonthlyRecord monthly: monthlyRecords) {
                if (monthly.isExpense == true && monthly.monthNumber == i) {
                    monthlyExpense = monthly.quantity * monthly.sumOfOne;
                    if(monthlyExpense>maxMonthlyExpense) {
                        maxMonthlyExpense = monthlyExpense;
                        maxItemNameExpense = monthly.itemName;
                    }
                }
            }
            consistMonthlyReport.add("Месяц: ");
            consistMonthlyReport.add(monthsConverting.getMonth(i));
            consistMonthlyReport.add("Самый прибыльный товар: ");
            consistMonthlyReport.add(maxItemNameIncome);
            consistMonthlyReport.add("Сумма: ");
            consistMonthlyReport.add(Integer.toString(maxMonthlyIncome));
            consistMonthlyReport.add("Самая большая трата: ");
            consistMonthlyReport.add(maxItemNameExpense);
            consistMonthlyReport.add("Сумма: ");
            consistMonthlyReport.add(Integer.toString(maxMonthlyExpense));
        }
        consistMonthlyReports.add(consistMonthlyReport);
        return consistMonthlyReports;
    }



}
