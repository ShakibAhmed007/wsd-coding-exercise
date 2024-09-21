package com.solvians.showcase;

import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException("Expect at least number of threads and number of quotes. But got: " + args);
        }

        int threads = Integer.parseInt(args[0]);
        int quotes = Integer.parseInt(args[1]);
        CertificateUpdateGenerator certificateUpdateGenerator = new CertificateUpdateGenerator(threads, quotes);
        List<CertificateUpdate> certificateUpdates = certificateUpdateGenerator
                .generateQuotes()
                .collect(Collectors.toList());
        certificateUpdates.forEach(System.out::println);
    }
}
