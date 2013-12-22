package com.stevemosley.chance.base;

import com.stevemosley.chance.ChanceSettings;
import org.joda.time.DateTime;

/**
 * This class ...
 */
public class DateChance extends ChanceSupport {

    public DateChance(ChanceSettings settings) {
        super(settings);
    }

    public DateTime aDateTime() {
        return new DateTime(random().nextLong());
    }

    public DateTime aDateTimeInTheFuture() {
        return null;
    }

}
