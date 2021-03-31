package appMain.entitis;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Bills {

    private long Client_Id;
    private long Num_Bill;
    private double Sum_Bills;
    private Date Data_Begin;
    private Date Data_End;

    public void setClient_Id(int client_Id) {
        Client_Id = client_Id;
    }

    public long getNum_Bill() {
        return Num_Bill;
    }

    public void setNum_Bill(long num_Bill) {
        Num_Bill = num_Bill;
    }

    public double getSum_Bills() {
        return Sum_Bills;
    }

    public void setSum_Bills(double sum_Bills) {
        Sum_Bills = sum_Bills;
    }

    public Date getData_Begin() {
        return Data_Begin;
    }

    public void setData_Begin(Date data_Begin) {
        Data_Begin = data_Begin;
    }

    public Date getData_End() {
        return Data_End;
    }

    public void setData_End(Date data_End) {
        Data_End = data_End;
    }

    public Bills(int client_Id, long num_Bill, double sum_Bills, Date data_Begin, Date data_End) {
        Client_Id = client_Id;
        Num_Bill = num_Bill;
        Sum_Bills = sum_Bills;
        Data_Begin = data_Begin;
        Data_End = data_End;
    }
    public Bills(){
    }
}
