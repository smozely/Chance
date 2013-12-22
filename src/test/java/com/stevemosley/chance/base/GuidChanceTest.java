package com.stevemosley.chance.base;

import static com.stevemosley.chance.ChanceSettingsBuilder.aChanceSettings;
import static org.junit.Assert.assertEquals;

import com.stevemosley.chance.Chance;
import org.junit.Test;

public class GuidChanceTest {

    private final GuidChance underTest = new GuidChance(aChanceSettings(1234567890).build());

    @Test
    public void testGUID() throws Exception {
        assertEquals("ea6addb7-2596-428e-8a77-acf9a43797b3", underTest.aGuid());
        assertEquals("4b58fcf1-a036-4cf3-9ec0-4f2620d015d0", underTest.aGuid());
    }

}
