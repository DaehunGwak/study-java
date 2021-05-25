package ch06.item39.marker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 마커 애너테이션 (아무 매개변수 없이 단순히 대상에 마킹한다는 뜻)
 * 테스트 메서드임을 선언하는 메서드
 * 매개변수 없는 정적 메서드 전용
 */
@Retention(RetentionPolicy.RUNTIME) // 메타 애너테이션
@Target(ElementType.METHOD) // 메타 에너테이션
public @interface Test {
}
