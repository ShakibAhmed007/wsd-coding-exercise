package com.solvians.showcase;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ISINGeneratorTest {

    @Test
    public void testISINGenerator() {
        String isin = ISINGenerator.generateISIN();
        assertEquals(12, isin.length());
    }
}
