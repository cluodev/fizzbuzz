package org.cluo.job.tdd;

import java.util.Collections;
import java.util.List;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class IntegerCounterTest extends FizzbuzzTestSupport {

    @Test
    public void constructor_throwsIllegalArgumentException_nullCollectionGiven() throws Exception {
        expectedExceptionDetails(IllegalArgumentException.class, "Null collection received");
        new IntegerCounter(null);
    }

    @Test
    public void count_returnsZero_emptyCollectionGiven() throws Exception {
        IntegerCounter counter = new IntegerCounter(Collections.<String>emptyList());
        assertEquals("the number of integers appears in the collection is wrong",0, counter.count());
    }

    @Test
    public void count_returnsZero_collectionHasNoneInteger() throws Exception {
        IntegerCounter counter = new IntegerCounter(buildAWordCollection("ab", "xy"));
        assertEquals("the number of integers appears in the collection is wrong", 0, counter.count());
    }
    
    @Test
    public void count_returns2_collectionHasTwoIntegers() throws Exception {
        IntegerCounter counter = new IntegerCounter(buildAWordCollection("ab", "3","5","xy"));
        assertEquals("the number of integers appears in the collection is wrong", 2, counter.count());
    }
    
    @Test
    public void showResult_returnsCorrectResult() throws Exception {
        List<String> wordList = buildAWordCollection("fizz", "5", "lucky");
        IntegerCounter integerCounter = new IntegerCounter(wordList);
        integerCounter.count();
        assertThat("result shown is not expected", integerCounter.showResult(), is("integer : 1"));
    }
    
}