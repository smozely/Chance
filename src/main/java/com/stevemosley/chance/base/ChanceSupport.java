package com.stevemosley.chance.base;

import com.stevemosley.chance.ChanceSettings;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.joda.time.DateTime;

import java.util.Random;

/**
 * TODO ... this class ...
 */
public abstract class ChanceSupport {

    private final ChanceSettings settings;

    public ChanceSupport(ChanceSettings settings) {
        this.settings = settings;
    }

    protected RandomGenerator random() {
        return settings.getGenerator();
    }

    protected int randomIntBetween(int min, int max) {
        return settings.getDataGenerator().nextInt(min, max);
    }

    protected long randomLongBetween(long min, long max) {
        return settings.getDataGenerator().nextLong(min, max);
    }

    protected long getTimestamp() {
        return settings.getTimestamp();
    }

    protected DateTime getTimestampDateTime() {
        return settings.getTimestampDateTime();
    }
}
