package com.stevemosley.chance.base;

import static com.stevemosley.chance.ChanceSettingsBuilder.aChanceSettings;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BooleanChanceTest {

    private final BooleanChance underTest = new BooleanChance(aChanceSettings(1234567890).build());

    @Test
    public void testBoolReturns() throws Exception {

        // GIVEN

        // WHEN
        boolean result = underTest.aBool();

        // THEN
        assertEquals(true, result);
    }

    @Test
    public void testBoolRelativelyRandom() throws Exception {

        // GIVEN

        // WHEN
        int trueCount = 0;

        for (int i = 0; i < 1000; i++) {
            if (underTest.aBool()) {
                trueCount++;
            }
        }

        // THEN
        assertThat(trueCount, allOf(greaterThan(475), lessThan(525)));
    }

    @Test
    public void testBoolWithLikelihoodAppropriatelyRandom() throws Exception {

        // GIVEN

        // WHEN
        int trueCount = 0;

        for (int i = 0; i < 100000; i++) {
            if (underTest.aBool(30)) {
                trueCount++;
            }
        }

        // THEN
        assertThat(trueCount, allOf(greaterThan(29500), lessThan(30500)));
    }


}
