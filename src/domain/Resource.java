package domain;

public class Resource {
    private int iD;
    private int data;
    
    public Resource() {
        this.iD = 0;
        this.data = 0;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ID: " + this.iD + " Data: " + this.data;
    }
}
