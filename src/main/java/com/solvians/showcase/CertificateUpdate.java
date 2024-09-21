package com.solvians.showcase;

import java.util.concurrent.ThreadLocalRandom;

public class CertificateUpdate {
    private final long timestamp;
    private final String isin;
    private final double bidPrice;
    private final int bidSize;
    private final double askPrice;
    private final int askSize;

    public CertificateUpdate() {
        this.timestamp = System.currentTimeMillis();
        this.isin = ISINGenerator.generateISIN();
        this.bidPrice = ThreadLocalRandom.current().nextDouble(100.00, 200.01);
        this.bidSize = ThreadLocalRandom.current().nextInt(1000, 5001);
        this.askPrice = ThreadLocalRandom.current().nextDouble(100.00, 200.01);
        this.askSize = ThreadLocalRandom.current().nextInt(1000, 10001);
    }

    @Override
    public String toString() {
        return "CertificateUpdate{" +
                "timestamp=" + timestamp +
                ", isin='" + isin + '\'' +
                ", bidPrice=" + bidPrice +
                ", bidSize=" + bidSize +
                ", askPrice=" + askPrice +
                ", askSize=" + askSize +
                '}';
    }
}
