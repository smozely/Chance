package com.stevemosley.chance.base;

import static com.stevemosley.chance.ChanceSettingsBuilder.aChanceSettings;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.apache.commons.math3.random.JDKRandomGenerator;
import org.hamcrest.Matcher;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class DateChanceTest {

    private static final Matcher ANY_MONTH_SHORT_NAME = anyOf(equalTo(DateChance.Month.JAN.getShortName()),
                                                              equalTo(DateChance.Month.FEB.getShortName()),
                                                              equalTo(DateChance.Month.MAR.getShortName()),
                                                              equalTo(DateChance.Month.APR.getShortName()),
                                                              equalTo(DateChance.Month.MAY.getShortName()),
                                                              equalTo(DateChance.Month.JUN.getShortName()),
                                                              equalTo(DateChance.Month.JUL.getShortName()),
                                                              equalTo(DateChance.Month.AUG.getShortName()),
                                                              equalTo(DateChance.Month.SEP.getShortName()),
                                                              equalTo(DateChance.Month.OCT.getShortName()),
                                                              equalTo(DateChance.Month.NOV.getShortName()),
                                                              equalTo(DateChance.Month.DEC.getShortName()));

    private static final Matcher ANY_MONTH_LONG_NAME = anyOf(equalTo(DateChance.Month.JAN.getLongName()),
            equalTo(DateChance.Month.FEB.getLongName()),
            equalTo(DateChance.Month.MAR.getLongName()),
            equalTo(DateChance.Month.APR.getLongName()),
            equalTo(DateChance.Month.MAY.getLongName()),
            equalTo(DateChance.Month.JUN.getLongName()),
            equalTo(DateChance.Month.JUL.getLongName()),
            equalTo(DateChance.Month.AUG.getLongName()),
            equalTo(DateChance.Month.SEP.getLongName()),
            equalTo(DateChance.Month.OCT.getLongName()),
            equalTo(DateChance.Month.NOV.getLongName()),
            equalTo(DateChance.Month.DEC.getLongName()));

    private final DateChance underTest = new DateChance(aChanceSettings().build());



    @Test
    @Repeat(100)
    public void testMonthInt() {
        assertThat(underTest.monthInt(), allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(12)));
    }

    @Test
    @Repeat(100)
    public void testMonthShort() {
        assertThat(underTest.monthShort(), is(ANY_MONTH_SHORT_NAME));
    }

    @Test
    @Repeat(100)
    public void testMonthLong() {
        assertThat(underTest.monthLong(), is(ANY_MONTH_LONG_NAME));
    }

    @Test
    @Repeat(100)
    public void testYearMinMax() {
        assertThat(underTest.year(1900, 1950), allOf(greaterThanOrEqualTo(1900), lessThanOrEqualTo(1950)));
    }

    @Test
    @Repeat(100)
    public void testYear() {
        int currentYear = DateTime.now().getYear();
        assertThat(underTest.year(), allOf(greaterThanOrEqualTo(currentYear), lessThanOrEqualTo(currentYear + 100)));
    }

}
