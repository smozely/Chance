package com.stevemosley.chance.base;


import static com.stevemosley.chance.ChanceSettingsBuilder.aChanceSettings;

import org.joda.time.DateTime;
import org.junit.Test;

public class DateChanceTest {

    private final DateChance underTest = new DateChance(aChanceSettings(1234567890).build());

    // TODO
    @Test
    public void testDateTime() throws Exception {

        // GIVEN
        System.out.println(new DateTime(Long.MIN_VALUE));
        System.out.println(new DateTime(2273327300317L));
        System.out.println(new DateTime(Long.MAX_VALUE));

        // WHEN


        // THEN

    }

}
