package com.stevemosley.chance.base;

import com.stevemosley.chance.ChanceSettings;

/**
 * TODO
 */
public class NumericChance extends ChanceSupport {

    public NumericChance(ChanceSettings settings) {
        super(settings);
    }

    public int aInteger() {
        return random().nextInt();
    }

    public int aInteger(int max) {
        return randomIntBetween(0, max);
    }

    public int aInteger(int min, int max) {
        return randomIntBetween(min, max);
    }

    public int aNatural() {
        return random().nextInt(Integer.MAX_VALUE);
    }

    public long aLong() {
        return random().nextLong();
    }

    public float aFloat() {
        return random().nextFloat();
    }

    public double aDouble() {
        return random().nextDouble();
    }

}
