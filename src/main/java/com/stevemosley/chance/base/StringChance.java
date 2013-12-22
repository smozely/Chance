package com.stevemosley.chance.base;

import static com.stevemosley.chance.ChancePools.*;

import com.google.common.primitives.Chars;
import com.stevemosley.chance.ChanceSettings;

/**
 * TODO ... this class ...
 */
public class StringChance extends ChanceSupport {


    public StringChance(ChanceSettings settings) {
        super(settings);
    }

    public char aChar() {
        return aChar(ALPHA_NUMERIC_CHARS);
    }

    public char aChar(char[] pool) {
        return pool[random().nextInt(pool.length)];
    }

    public String aString(int length, char[] pool) {
        char[] resultChars = new char[length];

        for (int i = 0; i < resultChars.length; i++) {
            resultChars[i] = aChar(pool);
        }

        return new String(resultChars);
    }

    public String aString(int length) {
        return aString(length, ALPHA_NUMERIC_CHARS);
    }

    public String aString(char[] pool) {
        return aString(randomIntBetween(5, 20), pool);
    }

    public String aString() {
        return aString(randomIntBetween(5, 20), ALPHA_NUMERIC_CHARS);
    }

}
