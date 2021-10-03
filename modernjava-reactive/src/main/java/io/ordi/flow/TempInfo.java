package io.ordi.flow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

/**
 * 원격 온도계 정보
 */
@Getter
@AllArgsConstructor
@ToString
public class TempInfo {

    public static final Random random = new Random();

    private final String town;
    private final int temp; // 온도 화씨

    public static TempInfo fetch(String town) {
        if (random.nextInt(10) == 0)
            throw new RuntimeException("Error!"); // 10% 확률 발생
        return new TempInfo(town, random.nextInt(100));
    }
}
