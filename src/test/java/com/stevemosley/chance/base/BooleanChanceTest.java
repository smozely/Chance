package com.stevemosley.chance.base;

import static com.stevemosley.chance.ChanceSettingsBuilder.aChanceSettings;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class BooleanChanceTest {

    private final BooleanChance underTest = new BooleanChance(aChanceSettings().build());

    @Test
    @Repeat(1000)
    public void testBoolReturns() throws Exception {
        assertThat(underTest.aBool()).isNotNull().isIn(true, false);
    }

    @Test
    public void testBoolRelativelyRandom() throws Exception {

        // GIVEN

        // WHEN
        int trueCount = 0;

        for (int i = 0; i < 100000; i++) {
            if (underTest.aBool()) {
                trueCount++;
            }
        }

        // THEN
        assertThat(trueCount).isGreaterThan(47500).isLessThan(52500);
    }

    @Test
    public void testBoolWithLikelihoodAppropriatelyRandom() throws Exception {

        // GIVEN

        // WHEN
        int trueCount = 0;

        for (int i = 0; i < 1000000; i++) {
            if (underTest.aBool(30)) {
                trueCount++;
            }
        }

        // THEN
        assertThat(trueCount).isGreaterThan(295000).isLessThan(305000);
    }


}
