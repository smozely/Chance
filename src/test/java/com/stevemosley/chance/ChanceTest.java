package com.stevemosley.chance;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Random;

/**
 * All tests here using a fixed seed number so tests are repeatable.
 */
public class ChanceTest {

    private final Chance underTest = new Chance(1234567890);

    @Test
    public void testWithDefaultConstructor() throws Exception {
        Chance constructed = new Chance();

        // Just ensure that the Chance instance can be used
        constructed.aBool();
    }

    @Test
    public void testWithSeedConstructor() throws Exception {
        Chance constructed = new Chance(1);

        // Since this has been created with a fixed seed result will always be the same
        assertEquals(true, constructed.aBool());
    }

    @Test
    public void testWithRandomConstructor() throws Exception {
        Chance constructed = new Chance(new Random(1));

        // Since this has been created with a fixed seed result will always be the same
        assertEquals(true, constructed.aBool());
    }

    @Test
    public void testGUID() throws Exception {

        // GIVEN

        // WHEN / THEN
        assertEquals("998a9913-a54a-483a-82c5-d96a1c6cca7c", underTest.aGuid());
        assertEquals("14477b2e-955e-43b8-8eff-83cbbce9d72f", underTest.aGuid());
    }

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

    /**
     * Pretty pointless, just executing the code, but not really proving anything (trusting that the random works)
     */
    @Test
    public void testNaturalReturnsAnPositiveInt() {
        // GIVEN

        // WHEN
        int result = underTest.aNatural();

        // THEN
        assertThat(result, is(allOf(greaterThanOrEqualTo(0), lessThan(Integer.MAX_VALUE))));
    }

    /**
     * Pretty pointless, just executing the code, but not really proving anything (trusting that the random works)
     */
    @Test
    public void testIntegerReturnsAnInt() {
        // GIVEN

        // WHEN
        int result = underTest.aInteger();

        // THEN
        assertThat(result, is(allOf(greaterThanOrEqualTo(Integer.MIN_VALUE), lessThanOrEqualTo(Integer.MAX_VALUE))));
    }

    /**
     * Pretty pointless, just executing the code, but not really proving anything (trusting that the random works)
     */
    @Test
    public void testFloatReturnsAFloat() throws Exception {

        // GIVEN


        float result = underTest.aFloat();

        // THEN
        assertThat(result, is(allOf(greaterThanOrEqualTo(Float.MIN_VALUE), lessThanOrEqualTo(Float.MAX_VALUE))));

    }

    /**
     * Pretty pointless, just executing the code, but not really proving anything (trusting that the random works)
     */
    @Test
    public void testDoubleReturnsADouble() throws Exception {

        // GIVEN


        double result = underTest.aDouble();

        // THEN
        assertThat(result, is(allOf(greaterThanOrEqualTo(Double.MIN_VALUE), lessThanOrEqualTo(Double.MAX_VALUE))));

    }
}
