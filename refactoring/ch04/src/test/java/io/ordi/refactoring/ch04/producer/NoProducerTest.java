package io.ordi.refactoring.ch04.producer;

import io.ordi.refactoring.ch04.Province;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class NoProducerTest {

    Province noProducerProvince;

    @BeforeEach
    void beforeEach() {
        noProducerProvince = new Province("No producers", Collections.emptyList(), 30, 20);
    }

    @Test
    void getShortfall() {
        assertThat(noProducerProvince.getShortfall(), is(30));
    }

    @Test
    void getProfit() {
        assertThat(noProducerProvince.getProfit(), is(0));
    }
}
