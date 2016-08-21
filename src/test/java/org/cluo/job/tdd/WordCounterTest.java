package org.cluo.job.tdd;

import java.util.Collections;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class WordCounterTest extends CounterTestSupport {

    @Test
    public void constructor_throwsIllegalArgumentException_nullListIsGiven() throws Exception {
        expectedExceptionDetails(IllegalArgumentException.class, "Null word collection received");
        new WordCounter(null, "word");
    }
    
    @Test
    public void constructor_throwsIllegalArgumentException_nullWordGiven() throws Exception {
        expectedExceptionDetails(IllegalArgumentException.class, "Invalid word received");
        new WordCounter(Collections.<String>emptyList(), null);
    }
    
    @Test
    public void constructor_throwsIllegalArgumentException_emptyWordGiven() throws Exception {
        expectedExceptionDetails(IllegalArgumentException.class, "Invalid word received");
        new WordCounter(Collections.<String> emptyList(), "");
    }    

    @Test
    public void count_returnsZero_anEmptyWordListIsGiven() throws Exception {
        List<String> wordList = emptyList();
        WordCounter wordCounter = new WordCounter(wordList,"a");
        assertEquals("the number of times word 'a' appears in the collection is wrong",0, wordCounter.count());
    }
    
    @Test
    public void count_returnsOne_onlyOneWordAppearsInTheCollection() throws Exception {
        List<String> wordList = buildAWordCollection("ab","cd");
        WordCounter wordCounter = new WordCounter(wordList, "ab");
        assertEquals("the number of times word 'ab' appears in the collection is wrong", 1, wordCounter.count());
    }
   
    @Test
    public void count_returnsZero_wordIsNotIncludedInTheCollection() throws Exception {
        List<String> wordList = buildAWordCollection("ab","cd");
        WordCounter wordCounter = new WordCounter(wordList, "a");
        assertEquals("the number of times word 'a' appears in the collection is wrong", 0, wordCounter.count());
    }
    
    @Test
    public void showResult_returnsCorrectResult() throws Exception {
        List<String> wordList = buildAWordCollection("fizz","fizz", "lucky");
        WordCounter wordCounter = new WordCounter(wordList, "fizz");
        wordCounter.count();
        assertThat("Result shown is not expected", wordCounter.showResult(), is("fizz : 2"));
    }

}