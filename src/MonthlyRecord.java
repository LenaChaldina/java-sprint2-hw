public class MonthlyRecord {
        int monthNumber;
        String itemName;
        boolean isExpense;
        int quantity;
        int sumOfOne;

    MonthlyRecord(int monthNumber, String itemName, boolean isExpense,  int quantity , int sumOfOne){
            this.monthNumber = monthNumber;
            this.itemName = itemName;
            this.isExpense = isExpense;
            this.quantity = quantity;
            this.sumOfOne = sumOfOne;
        }

        @Override
        public String toString() {
            return "MonthlyReport{" +
                    "monthNumber: " + monthNumber +
                    "itemName: " + itemName +
                    ", isExpense: " + isExpense +
                    ", quantity: " + quantity +
                    ", sumOfOne: " + sumOfOne +
                    '}';
        }





}
