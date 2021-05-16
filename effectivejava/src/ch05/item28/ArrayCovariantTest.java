package ch05.item28;

public class ArrayCovariantTest {

    public static void main(String[] args) {
        // 컴파일시 검출 불가, 런타임 에러 발생
        Object[] objectArray = new Long[1];
        objectArray[0] = "타입 달라 에러"; // ArrayStoreException
    }
}
