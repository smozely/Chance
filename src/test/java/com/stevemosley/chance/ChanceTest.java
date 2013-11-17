package com.stevemosley.chance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Random;

/**
 * All tests here using a fixed seed number so tests are repeatable.
 */
public class ChanceTest {

    private Chance underTest = new Chance(1234567890);

    @Test
    public void testWithDefaultConstructor() throws Exception {
        Chance constructed = new Chance();

        // Just ensure that the Chance instance can be used
        constructed.bool();
    }

    @Test
    public void testWithSeedConstructor() throws Exception {
        Chance constructed = new Chance(1);

        // Since this has been created with a fixed seed result will always be the same
        assertEquals(true, constructed.bool());
    }

    @Test
    public void testWithRandomConstructor() throws Exception {
        Chance constructed = new Chance(new Random(1));

        // Since this has been created with a fixed seed result will always be the same
        assertEquals(true, constructed.bool());
    }

    @Test
    public void testGUID() throws Exception {

        // GIVEN

        // WHEN / THEN
        assertEquals("998a9913-a54a-483a-82c5-d96a1c6cca7c", underTest.guid());
        assertEquals("14477b2e-955e-43b8-8eff-83cbbce9d72f", underTest.guid());
    }

    @Test
    public void testBool() throws Exception {

        // GIVEN

        // WHEN / THEN
        assertEquals(true, underTest.bool());
        assertEquals(true, underTest.bool());
        assertEquals(true, underTest.bool());
        assertEquals(false, underTest.bool());
        assertEquals(true, underTest.bool());
        assertEquals(false, underTest.bool());
    }
}
