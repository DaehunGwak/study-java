package io.ordi.refactoring.ch04;

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
}