public class Expense {
    int DocumentNo;
    int LineNo;
    String ExpensesCode;
    String Type;
    String PaymentType ;
    int BankAccount;
    String PostingDate;
    Double Amount;

    Expense(int DocumentNo,int LineNo, String ExpensesCode,String Type,String PaymentType, int BankAccount,String PostingDate,Double Amount){
        this.DocumentNo=DocumentNo;
        this.LineNo=LineNo;
        this.ExpensesCode=ExpensesCode;
        this.Type=Type;
        this.PaymentType=PaymentType ;
        this.BankAccount=BankAccount;
        this.PostingDate=PostingDate;
        this.Amount=Amount;

    }}
