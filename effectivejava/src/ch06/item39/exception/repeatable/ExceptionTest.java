package ch06.item39.exception.repeatable;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class) // Java8
public @interface ExceptionTest {
    Class<? extends Throwable> value();
}
