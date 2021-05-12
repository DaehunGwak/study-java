package ch02.item03.enumset;

public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("asdlfkjasdflkjasdf");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
