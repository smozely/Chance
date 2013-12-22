package com.stevemosley.chance.base;

import static com.stevemosley.chance.ChanceSettingsBuilder.aChanceSettings;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BooleanChanceTest {

    private final BooleanChance underTest = new BooleanChance(aChanceSettings().build());

    @Test
    public void testBoolReturns() throws Exception {
        assertThat(underTest.aBool(), anyOf(equalTo(true), equalTo(false)));
    }

    @Test
    public void testBoolRelativelyRandom() throws Exception {

        // GIVEN

        // WHEN
        int trueCount = 0;

        for (int i = 0; i < 10000; i++) {
            if (underTest.aBool()) {
                trueCount++;
            }
        }

        // THEN
        assertThat(trueCount, allOf(greaterThan(4750), lessThan(5250)));
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
