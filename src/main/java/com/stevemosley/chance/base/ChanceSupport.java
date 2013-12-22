package com.stevemosley.chance.base;

import com.stevemosley.chance.ChanceSettings;

import java.util.Random;

/**
 * TODO ... this class ...
 */
public abstract class ChanceSupport {

    private final ChanceSettings settings;

    public ChanceSupport(ChanceSettings settings) {
        this.settings = settings;
    }

    protected int randomIntBetween(int min, int max) {
        // nextInt is exclusive of the top value,
        // so add 1 to make it inclusive
        return random().nextInt((max - min) + 1) + min;
    }

    protected final Random random() {
        return settings.getRandom();
    }
}
