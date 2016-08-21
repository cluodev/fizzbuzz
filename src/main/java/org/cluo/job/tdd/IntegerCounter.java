package org.cluo.job.tdd;

import java.util.List;
import org.apache.commons.lang.NumberUtils;

import static org.apache.commons.lang.StringUtils.isNumeric;

public class IntegerCounter implements FizzbuzzCounter {


    private List<String> wordCollection;
    private int result;

    public IntegerCounter(List<String> wordCollection) {
        if (wordCollection == null) {
            throw new IllegalArgumentException("Null collection received");
        }
        this.wordCollection = wordCollection;
    }

    @Override
    public int count() {
        for (String word : wordCollection) {
            if(isNumeric(word)){
                result++;
            }
        }
        return result;
    }

    @Override
    public String showResult() {
        return String.format("integer : %d", result);
    }
}
