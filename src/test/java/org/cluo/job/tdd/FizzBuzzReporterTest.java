package org.cluo.job.tdd;

import java.util.List;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzReporterTest extends FizzbuzzTestSupport {

    @Test
    public void report_throwsIllegalArgumentException_nullCollectionIsGiven() throws Exception {
        expectedExceptionDetails(IllegalArgumentException.class, "At least one Fizzbuzz counter is required");
        new FizzBuzzReporter(null);
    }
    
    @Test
    public void report_showsCorrectResultForCountingFizz_givenAFizzWordCounter() throws Exception {
        List<String> wordCollection = buildAWordCollection("fizz","abc");
        FizzBuzzReporter fizzBuzzReporter= new  FizzBuzzReporter(new WordCounter(wordCollection,"fizz"));
        assertThat("Wrong result produced by Fizz word counter", fizzBuzzReporter.report(), is("fizz : 1\n"));
    }
    
    @Test
    public void report_showsCorrectResultForCountingInteger_givenAIntegerCounter() throws Exception {
        List<String> wordCollection = buildAWordCollection("fizz", "45","abc");
        FizzBuzzReporter fizzBuzzReporter = new FizzBuzzReporter(new IntegerCounter(wordCollection));
        assertThat("Number of integers is wrong", fizzBuzzReporter.report(), is("integer : 1\n"));
    }
    
    @Test
    public void report_showsCorrectResultForCountingFizzAndInteger_givenFizzAndIntegerCounter() throws Exception {
        List<String> wordCollection = buildAWordCollection("fizz", "45", "abc");
        FizzBuzzReporter fizzBuzzReporter = new FizzBuzzReporter(
                                                       new IntegerCounter(wordCollection),
                                                       new WordCounter(wordCollection,"fizz"));
        assertThat("Report details are wrong", fizzBuzzReporter.report(), is("integer : 1\nfizz : 1\n"));
    }
    
}