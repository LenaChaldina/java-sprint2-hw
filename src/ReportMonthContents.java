public class ReportMonthContents {
    String reportMonthName;
    boolean is_expense;
    Integer quantity;
    Integer sumOfName;

    ReportMonthContents (boolean is_expense, Integer quantity, Integer sumOfName) {
        this.reportMonthName = "m.202001.csv";
        this.is_expense = is_expense;
        this.quantity = quantity;
        this.sumOfName = sumOfName;
    }


}
