package io.ordi.refactoring.ch04.producer;

import io.ordi.refactoring.ch04.MockDataFactory;
import io.ordi.refactoring.ch04.Province;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Slf4j
class ProvinceTest {

    Province province;

    @BeforeEach
    void beforeEach() {
        // given
        province = MockDataFactory.sampleProvinceData();
    }

    @Test
    void getShortfall() {
        // then
        assertThat(province.getShortfall(), is(5));
        log.debug(("province={}"), province);
    }

    @Test
    void getProfit() {
        // then
        assertThat(province.getProfit(), is(230));
        log.debug(("province={}"), province);
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