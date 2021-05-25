package ch06.item39.exception.array;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunExceptionArrayTests {

    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(args[0]);

        // 올바른 예외 테스트
        for (Method m : testClass.getDeclaredMethods()) {
            if (!m.isAnnotationPresent(ExceptionArrayTest.class))
                continue;
            tests++;
            try {
                m.invoke(null);
                System.out.printf("테스트 %s 실패: 예외를 던지지 않음%n", m);
            } catch (InvocationTargetException wrappedExc) {
                Throwable exc = wrappedExc.getCause();
                int oldPassed = passed;
                Class<? extends Throwable>[] excTypes = m.getAnnotation(ExceptionArrayTest.class).value();
                for (Class<? extends Throwable> excType : excTypes) {
                    if (excType.isInstance(exc)) {
                        passed++;
                        break;
                    }
                }
                if (passed == oldPassed) {
                    System.out.printf("테스트 %s 실패: %s%n", m, exc);
                }
            } catch (Exception exc) {
                System.out.println("잘못 사용한 @ExceptionTest: " + m);
            }
        }

        System.out.printf("성공: %d, 실패: %d%n", passed, tests - passed);
    }
}
