import java.util.HashMap;

public class VerificationReports {
    HashMap<Integer,Integer> monthlyIncome;
    HashMap<Integer, Integer> monthlyExpense;
    HashMap<Integer, Integer> yearlyIncome;
    HashMap<Integer, Integer> yearlyExpense;

    public void verification(MonthlyReport monthlyReport,YearlyReport yearlyReport ){
        int countDifference = 0;

        monthlyIncome = monthlyReport.monthlyIncome();
        yearlyIncome = yearlyReport.yearlyIncome();

        for(int i=1; i<4; i++) {
           if (!monthlyIncome.getOrDefault(i, 0).equals(yearlyIncome.getOrDefault(i, 0))) {
              System.out.println("Обнаружено несоответствие в доходах месяце: " + i);
               countDifference += 1;
           }
        }
        monthlyExpense = monthlyReport.monthlyExpense();
        yearlyExpense = yearlyReport.yearlyExpense();
        for(int i=1; i<4; i++) {
            if (!monthlyExpense.getOrDefault(i, 0).equals(yearlyExpense.getOrDefault(i, 0))) {
                System.out.println("Обнаружено несоответствие в расходах месяце: " + i);
                countDifference += 1;

            }
        }

        if (countDifference == 0) {
            System.out.println("Операция успешно завершена");
        }



    }

}
