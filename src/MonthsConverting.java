public class MonthsConverting {
    static final int COUNT_MONTH_REPORTS = 3;
    public String getMonth(int monthNumber){
        switch (monthNumber) {
            case(1): return "Январь";
            case(2): return "Февраль";
            case(3): return "Март";
            default:
                return "Такого месяца не было в ТЗ";
        }
    }
}
