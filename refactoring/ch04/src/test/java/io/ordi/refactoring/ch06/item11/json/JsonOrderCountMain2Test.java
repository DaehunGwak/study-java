package io.ordi.refactoring.ch06.item11.json;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class JsonOrderCountMain2Test {

    @Test
    void run() throws IOException {
        // given
        String[] args = {"-r", "src/test/resources/ch06/item11/Orders.json"};

        // when
        long status = JsonOrderCountMain2.run(args);

        // then
        assertThat(status, greaterThan(0L));
        log.info("status={}", status);
    }

    @Test
    void run_r옵션_미포함() throws IOException {
        // given
        String[] args = {"src/test/resources/ch06/item11/Orders.json"};

        // when
        long status = JsonOrderCountMain2.run(args);

        // then
        assertThat(status, greaterThan(0L));
        log.info("status={}", status);
    }

    @Test
    void run_파일명미입력() throws IOException {
        // given
        String[] args = {};

        // when & then
        assertThrows(RuntimeException.class, () -> {
            JsonOrderCountMain2.run(args);
        });
    }
}