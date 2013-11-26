package com.stevemosley.chance;

import java.util.Random;

/**
 * This class ...
 */
public class ChanceSettings {

    private final Random randy;

    ChanceSettings(Random randy) {
        this.randy = randy;
    }

    public Random getRandom() {
        return randy;
    }
}
