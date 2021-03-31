package appMain.entitis;

import java.util.Date;

public class Transactions {
    private long Bill_Id;
    private long Transaction_Id;
    private double Sum_Transaction;
    private Date Data_Transaction;

    public Transactions(long bill_Id, long transaction_Id, double sum_Transaction, Date data_Transaction) {
        Bill_Id = bill_Id;
        Transaction_Id = transaction_Id;
        Sum_Transaction = sum_Transaction;
        Data_Transaction = data_Transaction;
    }
    public Transactions(){

    }
    public long getBill_Id() {
        return Bill_Id;
    }

    public void setBill_Id(long bill_Id) {
        Bill_Id = bill_Id;
    }

    public long getTransaction_Id() {
        return Transaction_Id;
    }

    public void setTransaction_Id(long transaction_Id) {
        Transaction_Id = transaction_Id;
    }

    public double getSum_Transaction() {
        return Sum_Transaction;
    }

    public void setSum_Transaction(double sum_Transaction) {
        Sum_Transaction = sum_Transaction;
    }

    public Date getData_Transaction() {
        return Data_Transaction;
    }

    public void setData_Transaction(Date data_Transaction) {
        Data_Transaction = data_Transaction;
    }
}
