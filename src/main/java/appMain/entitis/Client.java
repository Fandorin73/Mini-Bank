package appMain.entitis;

public class Client {
     private int Id;
    private String Name;
    private int Pasport_Serial;
    private int Pasport_Number;
    private String Telephone_Number;
    private String Adress;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPasport_Serial() {
        return Pasport_Serial;
    }

    public void setPasport_Serial(int pasport_Serial) {
        Pasport_Serial = pasport_Serial;
    }

    public int getPasport_Number() {
        return Pasport_Number;
    }

    public void setPasport_Number(int pasport_Number) {
        Pasport_Number = pasport_Number;
    }

    public String getTelephone_Number() {
        return Telephone_Number;
    }

    public void setTelephone_Number(String telephone_Number) {
        Telephone_Number = telephone_Number;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }
    public Client(){

    }
    public Client(int id, String name, int pasport_Serial, int pasport_Number, String telephone_Number, String adress) {
        Id = id;
        Name = name;
        Pasport_Serial = pasport_Serial;
        Pasport_Number = pasport_Number;
        Telephone_Number = telephone_Number;
        Adress = adress;
    }


}
