package th.go.rd.atm.model;

public class Customer {
    private int id; //ชื่อตัวแปร ตรงกันกับ name ของ input ใน Html
    private String name;
    private int pin;


    public Customer(int id, String name, int pin) {
        this.id = id;
        this.name = name;
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

}
