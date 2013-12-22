package com.stevemosley.chance.base;

import static com.google.common.base.Preconditions.checkArgument;

import com.stevemosley.chance.ChanceSettings;

/**
 * This class ...
 */
public class BooleanChance extends ChanceSupport {

    public BooleanChance(ChanceSettings settings) {
        super(settings);
    }

    public boolean aBool() {
        return random().nextBoolean();
    }

    public boolean aBool(int likelihood) {
        checkArgument(likelihood > 0 && likelihood < 100, "likelihood must be between 0 and 100 (exclusive)");

        int random = randomIntBetween(1, 100);
        return !(random > likelihood);
    }
}
