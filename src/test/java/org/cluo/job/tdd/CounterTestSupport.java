package org.cluo.job.tdd;


import java.util.Arrays;
import java.util.List;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CounterTestSupport {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    protected List<String> buildAWordCollection(String... word) {
        return Arrays.asList(word);
    }

    protected void expectedExceptionDetails(Class<? extends Throwable> classType, String expectedExceptionMessage) {
        expectedException.expect(classType);
        expectedException.expectMessage(expectedExceptionMessage);
    }
}
