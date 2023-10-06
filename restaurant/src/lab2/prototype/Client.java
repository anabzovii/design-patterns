package lab2.prototype;

public class Client implements Cloneable {
    private String name;
    private int paidPrice;

    public Client(String name, int paidPrice) {
        this.name = name;
        this.paidPrice = paidPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(int paidPrice) {
        this.paidPrice = paidPrice;
    }

    @Override
    public Object clone() {
        //crearea unui obiect nou cu parametrii precedenti
        return new Client(getName(), getPaidPrice());
    }
}
