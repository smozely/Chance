package com.stevemosley.chance.base;

import static com.stevemosley.chance.ChanceSettingsBuilder.aChanceSettings;
import static org.junit.Assert.assertEquals;

import com.stevemosley.chance.Chance;
import org.junit.Test;

public class GuidChanceTest {

    private final GuidChance underTest = new GuidChance(aChanceSettings(1234567890).build());

    @Test
    public void testGUID() throws Exception {

        // GIVEN

        // WHEN / THEN
        assertEquals("998a9913-a54a-483a-82c5-d96a1c6cca7c", underTest.aGuid());
        assertEquals("14477b2e-955e-43b8-8eff-83cbbce9d72f", underTest.aGuid());
    }

}
