package ch02.item03.staticfactory;

public class Elvis {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() { }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("whoa baby~ I'm outta here!");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();
    }
}
