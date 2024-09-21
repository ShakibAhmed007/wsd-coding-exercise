package com.solvians.showcase;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CertificateUpdateCallableTest {

    @Test
    public void testCallableGeneratesCorrectFormat() throws Exception {
        CertificateUpdateCallable callable = new CertificateUpdateCallable();
        String result = callable.call();

        String[] results = result.split(",");
        assertTrue(results.length == 6, "Should have 6 comma-separated values");

        long timestamp = Long.parseLong(results[0]);
        assertTrue(timestamp > 0, "Timestamp should be greater than 0");

        assertTrue(results[1].matches("[A-Z]{2}[A-Z0-9]{9}[0-9]"), "ISIN format is incorrect");

        double bidPrice = Double.parseDouble(results[2]);
        assertTrue(bidPrice >= 100.00 && bidPrice <= 200.00, "Bid price is out of range");

        int bidSize = Integer.parseInt(results[3]);
        assertTrue(bidSize >= 1000 && bidSize <= 5000, "Bid size is out of range");

        double askPrice = Double.parseDouble(results[4]);
        assertTrue(askPrice >= 100.00 && askPrice <= 200.00, "Ask price is out of range");

        int askSize = Integer.parseInt(results[5]);
        assertTrue(askSize >= 1000 && askSize <= 10000, "Ask size is out of range");
    }
}
