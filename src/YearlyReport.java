import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class YearlyReport {
    MonthsConverting monthsConverting = new MonthsConverting();

    private List<YearlyRecord> YearlyRecords;
    static final int REPORT_YEAR = 2021;

    YearlyReport() {
        this.YearlyRecords = new ArrayList<>();
    }

    public void addRecord(YearlyRecord record) {
        this.YearlyRecords.add(record);
    }

    public HashMap yearlyIncome(){
        HashMap <Integer, Integer> yearlyIncome = new HashMap<>();
        for(YearlyRecord yearly: YearlyRecords) {
            if(yearly.isExpense == false) {
                yearlyIncome.put(yearly.monthNumber,yearly.amount);
            }
        }
        return yearlyIncome;
    }

    public HashMap yearlyExpense(){
        HashMap <Integer, Integer> yearlyExpense = new HashMap();
        for(YearlyRecord yearly: YearlyRecords) {
            if(yearly.isExpense == true) {
                yearlyExpense.put(yearly.monthNumber,yearly.amount);
            }
        }
        return yearlyExpense;
    }
   /* Информация о годовом отчёте
    При вызове этой функции программа должна выводить следующие данные:
    Рассматриваемый год;
    Прибыль по каждому месяцу. Прибыль — это разность доходов и расходов;
    Средний расход за все месяцы в году;
    Средний доход за все месяцы в году.
*/
    //прибыль по каждому месяцу
    public void monthlyProfit() {
        for(int i=1; i<=monthsConverting.COUNT_MONTH_REPORTS; i++) {
            int monthlyIncome = 0;
            int monthlyExpense = 0;
            for(YearlyRecord yearly: YearlyRecords) {
                if(yearly.monthNumber == i && yearly.isExpense == false) {
                    monthlyIncome += yearly.amount;
                } else if(yearly.monthNumber == i && yearly.isExpense == true) {
                    monthlyExpense += yearly.amount;
                }
            }
            System.out.println("Месяц: " + monthsConverting.getMonth(i) + ", " + (monthlyIncome - monthlyExpense));
        }
    }
    public int getYearlyIncomeAVG(){
        int sumYearlyIncome = 0;
        int avgYearlyIncome = 0;
        int k = 0; //счётчик итераций...прастити
        for(YearlyRecord yearly: YearlyRecords) {
            if(yearly.isExpense == false) {
                sumYearlyIncome += yearly.amount;
                k+=1;
            }
        }
        avgYearlyIncome = sumYearlyIncome/k;
        return avgYearlyIncome;
    }

    public int getYearlyExpenseAVG(){
        int sumYearlyExpense = 0;
        int avgYearlyExpense = 0;
        int k = 0;
        for(YearlyRecord yearly: YearlyRecords) {
            if(yearly.isExpense == true) {
                sumYearlyExpense += yearly.amount;
                k+=1;
            }
        }
        avgYearlyExpense = sumYearlyExpense/k;
        return avgYearlyExpense;
    }

}
