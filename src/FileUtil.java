public class FileUtil {

    public void constructMonthlyReader(int monthNumber, MonthlyReport monthlyReport) {
        Reader reader = new Reader();
        String fileName = "resources/m.20210" + monthNumber + ".csv";
        String contentOfFile = reader.readFileContentsOrNull(fileName);
        String[] lines = contentOfFile.split("\\r\\n");


        for (int i = 1; i < lines.length; i++) {
            String[] content = lines[i].split(",");


            String itemName = content[0];
            boolean isExpense = Boolean.valueOf(content[1]);
            int quantity = Integer.valueOf(content[2]);
            int sumOfOne = Integer.valueOf(content[3]);

            MonthlyRecord ourRecord = new MonthlyRecord(monthNumber, itemName, isExpense, quantity, sumOfOne);
            monthlyReport.addRecord(ourRecord);

        }


    }

    public void constructYearlyReader(String fileName, YearlyReport yearlyReport) {
        Reader reader = new Reader();

        String contentOfFile = reader.readFileContentsOrNull(fileName);
        String[] lines = contentOfFile.split("\\r\\n");


        for (int i = 1; i < lines.length; i++) {
            String[] content = lines[i].split(",");


            int monthNumber = Integer.valueOf(content[0]);
            int amount = Integer.valueOf(content[1]);
            boolean isExpense = Boolean.valueOf(content[2]);


            YearlyRecord ourRecord = new YearlyRecord(monthNumber, amount, isExpense);
            yearlyReport.addRecord(ourRecord);

        }

    }


}

