package org.cluo.job.tdd;

public class FizzBuzzReporter {

    private FizzbuzzCounter[] counters;

    public FizzBuzzReporter(FizzbuzzCounter... aCounter) {
        if (aCounter == null) {
            throw new IllegalArgumentException("At least one Fizzbuzz counter is required");
        }
        counters = aCounter;
    }

    public String report() {
        StringBuilder details = new StringBuilder();
        for (FizzbuzzCounter counter : counters) {
            counter.count();
            details.append(counter.showResult()).append("\n");
        }
        return details.toString();
    }
}
