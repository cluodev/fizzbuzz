package org.cluo.job.tdd;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.cluo.job.tdd.FizzBuzzPrinter.INVALID_ARGUMENT_END_NUMBER;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class FizzBuzzRunnerTest {

    private PrintStream originalSystemOut;
    private PrintStream originalSystemErr;

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private ByteArrayOutputStream error = new ByteArrayOutputStream();


    @Before
    public void setUp() throws Exception {
        originalSystemOut = System.out;
        originalSystemErr = System.err;

        System.setOut(new PrintStream(output));
        System.setErr(new PrintStream(error));

    }

    @After
    public void tearDown() throws Exception {
        System.out.close();
        System.err.close();
        System.setOut(originalSystemOut);
        System.setErr(originalSystemErr);

    }
    
    @Test
    public void main_outputsWarning_noArguments() throws Exception {
        final String[] arguments = new String[]{};
        FizzBuzzRunner.main(arguments);
        assertThat("Output is not expected", output.toString(),
                    is("Two arguments [start] and [end] are required\n"));
    }

    @Test
    public void main_outputsWarning_wrongArgumentCount() throws Exception {
        final String[] arguments = new String[] {"1","2","5"};
        FizzBuzzRunner.main(arguments);
        assertThat("Output is not expected", output.toString(),
                    is("Two arguments [start] and [end] are required\n"));
    }
    
    @Test
    public void main_outputsWarning_1stArgumentWrongDataType() throws Exception {
        final String[] arguments = new String[] { "abc", "2"};
        FizzBuzzRunner.main(arguments);
        assertThat("Output is not expected", output.toString(),
                    is("Argument is not of number\n"));
    }

    @Test
    public void main_outputsWarning_2ndArgumentWrongDataType() throws Exception {
        final String[] arguments = new String[] { "1", "mn" };
        FizzBuzzRunner.main(arguments);
        assertThat("Output is not expected", output.toString(), is("Argument is not of number\n"));
    }

    @Test
    public void main_outputsWarning_FizzbuzzPrinterThrowsException() throws Exception {
        final String[] arguments = new String[] { "5", "2" };
        FizzBuzzRunner.main(arguments);
        assertThat("Output is not expected", error.toString(), is(INVALID_ARGUMENT_END_NUMBER+"\n"));
    }

    @Test
    public void main_outputsExpectedFizzbuzzCollection_inNumbers1To20() throws Exception {
        final String[] arguments = new String[] { "1", "20"};
        FizzBuzzRunner.main(arguments);
        assertThat("Output is not expected", output.toString(), is(buildExpectedResults()));
    }

    private String buildExpectedResults() {
        return buildExpectedResultForFizzbuzzAndLucky() + buildExpectedResultForCountingWordsAndInteger();
    }

    private String buildExpectedResultForCountingWordsAndInteger() {
        return  "fizz : 4\n" +
                "buzz : 3\n" +
                "fizzbuzz : 1\n" +
                "lucky : 2\n" +
                "integer : 10\n";
    }

    private String buildExpectedResultForFizzbuzzAndLucky() {
        return "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz\n";
    }

}