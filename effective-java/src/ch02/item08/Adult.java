package ch02.item08;

public class Adult {
    public static void main(String[] args) {
        // AutoCloseable + try-with-resources 활용
        try (Room myRoom = new Room(7)) {
            System.out.println("안녕!");
        }
    }
}
