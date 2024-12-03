public class ExpenseData {
    int ExpenseCode;
    String Description;
    Double Balance;
    static int counter=0001;

    ExpenseData( String Description, Double Balance){
        this.Balance=Balance;
        this.Description=Description;
        this.ExpenseCode=counter;
        counter ++;
    }
}
