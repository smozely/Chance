package com.stevemosley.chance.base;


import static com.stevemosley.chance.ChanceSettingsBuilder.aChanceSettings;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class TimeChanceTest {

    private final TimeChance underTest = new TimeChance(aChanceSettings().build());

    @Test
    @Repeat(10)
    public void testAMPM() {
        assertThat(underTest.ampm(), is(anyOf(equalTo("am"), equalTo("pm"))));
    }

    @Test
    @Repeat(100)
    public void testHour12() {
        assertThat(underTest.hour12(), allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(12)));

    }

    @Test
    @Repeat(100)
    public void testHour24() {
        assertThat(underTest.hour24(), allOf(greaterThanOrEqualTo(0), lessThanOrEqualTo(23)));
    }

    @Test
    @Repeat(100)
    public void testMinute() {
        assertThat(underTest.minute(), allOf(greaterThanOrEqualTo(0), lessThanOrEqualTo(59)));
    }

    @Test
    @Repeat(100)
    public void testSecond() {
        assertThat(underTest.second(), allOf(greaterThanOrEqualTo(0), lessThanOrEqualTo(59)));
    }

    @Test
    @Repeat(1000)
    public void testMillisecond() {
        assertThat(underTest.millisecond(), allOf(greaterThanOrEqualTo(0), lessThanOrEqualTo(999)));
    }


}
