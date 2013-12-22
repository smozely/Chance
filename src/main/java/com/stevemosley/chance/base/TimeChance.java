package com.stevemosley.chance.base;

import com.stevemosley.chance.ChanceSettings;
import org.joda.time.DateTime;
import org.joda.time.YearMonth;

/**
 * This class contains methods for generating random time related values.
 */
public class TimeChance extends ChanceSupport {

    public TimeChance(ChanceSettings settings) {
        super(settings);
    }

    public String ampm() {
        return random().nextBoolean() ? "am" : "pm";
    }

    public int hour12() {
        return randomIntBetween(1, 12);
    }

    public int hour24() {
        return randomIntBetween(0, 23);
    }

    public int minute() {
        return randomIntBetween(0, 59);
    }

    public int second() {
        return randomIntBetween(0, 59);
    }

    public int millisecond() {
        return randomIntBetween(0, 999);
    }

    public DateTime aDateTime() {
        return new DateTime(random().nextLong());
    }

}
