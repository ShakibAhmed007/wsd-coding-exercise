package com.solvians.showcase;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class CertificateUpdateCallable implements Callable<String> {

    @Override
    public String call() {
        long timestamp = System.currentTimeMillis();
        String isin = ISINGenerator.generateISIN();
        double bidPrice = ThreadLocalRandom.current().nextDouble(100.00, 200.01);
        int bidSize = ThreadLocalRandom.current().nextInt(1000, 5001);
        double askPrice = ThreadLocalRandom.current().nextDouble(100.00, 200.01);
        int askSize = ThreadLocalRandom.current().nextInt(1000, 10001);

        return String.format("%d,%s,%.2f,%d,%.2f,%d",
                timestamp, isin, bidPrice, bidSize, askPrice, askSize);
    }

}
