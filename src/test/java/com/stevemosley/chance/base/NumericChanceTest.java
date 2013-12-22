package com.stevemosley.chance.base;

import static com.stevemosley.chance.ChanceSettingsBuilder.aChanceSettings;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Most of these tests are pretty pointless, just exercising the code more than testing logic.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class NumericChanceTest {

    private final NumericChance underTest = new NumericChance(aChanceSettings(1234567890).build());

    @Test
    @Repeat(1000)
    public void testNaturalReturnsAnPositiveInt() {
        // GIVEN

        // WHEN
        int result = underTest.aNatural();

        // THEN
        assertThat(result, is(allOf(greaterThanOrEqualTo(0), lessThan(Integer.MAX_VALUE))));
    }

    @Test
    @Repeat(1000)
    public void testIntegerReturnsAnInt() {
        // GIVEN

        // WHEN
        int result = underTest.aInteger();

        // THEN
        assertThat(result, is(allOf(greaterThanOrEqualTo(Integer.MIN_VALUE), lessThanOrEqualTo(Integer.MAX_VALUE))));
    }

    @Test
    @Repeat(1000)
    public void testLongReturnsAnLong() {
        // GIVEN

        // WHEN
        long result = underTest.aLong();

        // THEN
        assertThat(result, is(allOf(greaterThanOrEqualTo(Long.MIN_VALUE), lessThanOrEqualTo(Long.MAX_VALUE))));
    }

    @Test
    @Repeat(1000)
    public void testFloatReturnsAFloat() throws Exception {

        // GIVEN

        // WHEN
        float result = underTest.aFloat();

        // THEN
        assertThat(result, is(allOf(greaterThanOrEqualTo(Float.MIN_VALUE), lessThanOrEqualTo(Float.MAX_VALUE))));

    }

    @Test
    @Repeat(1000)
    public void testDoubleReturnsADouble() throws Exception {

        // GIVEN

        // WHEN
        double result = underTest.aDouble();

        // THEN
        assertThat(result, is(allOf(greaterThanOrEqualTo(Double.MIN_VALUE), lessThanOrEqualTo(Double.MAX_VALUE))));

    }

}
