package io.ordi.refactoring.ch04;

import io.ordi.refactoring.ch04.MockDataFactory;
import io.ordi.refactoring.ch04.Producer;
import io.ordi.refactoring.ch04.Province;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class ProducerTest {

    Province province;

    @BeforeEach
    void beforeEach() {
        // given
        province = MockDataFactory.sampleProvinceData();
    }

    @Test
    void setProduction() {
        // when
        List<Producer> producers = province.getProducers();
        producers.get(0).setProduction(20);

        // then
        assertThat(province.getShortfall(), is(-6));
        assertThat(province.getProfit(), is(292));
    }
}