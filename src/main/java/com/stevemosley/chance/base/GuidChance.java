package com.stevemosley.chance.base;

import com.stevemosley.chance.ChanceSettings;

import java.util.UUID;

/**
 * This class ...
 */
public class GuidChance extends ChanceSupport {

    public GuidChance(ChanceSettings settings) {
        super(settings);
    }

    public String aGuid() {
        byte[] randomBytes = new byte[16];
        random().nextBytes(randomBytes);
        randomBytes[6] &= 0x0f;  /* clear version        */
        randomBytes[6] |= 0x40;  /* set to version 4     */
        randomBytes[8] &= 0x3f;  /* clear variant        */
        randomBytes[8] |= 0x80;  /* set to IETF variant  */

        long msb = 0;
        long lsb = 0;
        for (int i = 0; i < 8; i++)
            msb = (msb << 8) | (randomBytes[i] & 0xff);
        for (int i = 8; i < 16; i++)
            lsb = (lsb << 8) | (randomBytes[i] & 0xff);

        return new UUID(msb, lsb).toString();
    }
}
