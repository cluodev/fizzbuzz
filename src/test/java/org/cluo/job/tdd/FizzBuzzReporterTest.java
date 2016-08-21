package org.cluo.job.tdd;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FizzBuzzReporterTest {

    private FizzBuzzReporter fizzBuzzReporter;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void beforeEachTest() throws Exception {
        fizzBuzzReporter =  new FizzBuzzReporter();
    }

    @Test
    public void report_throwsIllegalArgumentException_emptyListIsGiven() throws Exception {

    }


    private void expectedExceptionDetails(Class<? extends Throwable> classType, String expectedExceptionMessage){
       expectedException.expect(classType);
       expectedException.expectMessage(expectedExceptionMessage);
    }

}