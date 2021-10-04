package io.ordi.refactoring.ch04.producer;

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

    @Test
    void zeroDemand() {
        // when
        province.setDemand(0);

        // then
        assertThat(province.getShortfall(), is(-25));
        assertThat(province.getProfit(), is(0));
    }

    /**
     * 경계 조건 검사 하다 잘못된 전제를 발견한 케이스
     */
    @Test
    void negativeDemand() {
        // when
        province.setDemand(-1); // 요구량이 -1 인게 말이 되는가?

        // then
        assertThat(province.getShortfall(), is(-26)); // 재고량이 -26이 말이 되는가?
        assertThat(province.getProfit(), is(-10)); // 수익이 -10 인게 말이 되는가? 음 빚도 있다면 말이 되긴 하겠다
    }
}