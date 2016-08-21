package org.cluo.job.tdd;

import java.util.List;

public class WordCounter implements FizzbuzzCounter {
    private List<String> wordList;
    private String wordToBeCounted;
    private int result;

    public WordCounter(List<String> wordList, String wordToBeCounted) {
        validateArguments(wordList, wordToBeCounted);

        this.wordList = wordList;
        this.wordToBeCounted = wordToBeCounted;
    }

    private void validateArguments(List<String> wordList, String wordToBeCounted) {
        if (wordList==null) {
            throw new IllegalArgumentException("Null word collection received");
        }

        if (wordToBeCounted == null || "".equals(wordToBeCounted)) {
            throw new IllegalArgumentException("Invalid word received");
        }
    }

    @Override
    public int count() {
        if (wordList.isEmpty()){
            return 0;
        }
        for (String word : wordList) {
           if (wordToBeCounted.equals(word)){
               result += 1;
           }
        }
        return result;
    }

    @Override
    public String showResult() {
        return String.format("%s : %d", wordToBeCounted, result);
    }
}
