package ch02.item08;

import java.lang.ref.Cleaner;

public class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    private static class State implements Runnable {
        int numJunkPiles;  // Room 안의 쓰레기 수

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("방 청소");
            numJunkPiles = 0;
        }
    }

    private final State state;
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);  // cleaner를 통해 state 런을 JVM 스레드에서 실행할 수 있게 등록
    }

    @Override
    public void close() {
        cleanable.clean();  // AutoCloseable 을 통한 cleaner 강제 클린 하기
    }
}
