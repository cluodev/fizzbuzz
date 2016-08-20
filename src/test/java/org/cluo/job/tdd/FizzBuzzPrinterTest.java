package org.cluo.job.tdd;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FizzBuzzPrinterTest {

   @Rule
   public ExpectedException expectedException = ExpectedException.none();
   
   private FizzBuzzPrinter fizzBuzzPrinter;

   @Before
   public void beforeEachTest() throws Exception {
      fizzBuzzPrinter = new FizzBuzzPrinter();
   }

   @Test
   public void print_ThrowsIllegalArgumentExceptionGivenInvalidStartNumber() throws Exception {
      expectedExceptionDetails(IllegalArgumentException.class,"Invalid start number. A number >=0 is expected" );
      fizzBuzzPrinter.print(-1, 20);
   }
   
   @Test
    public void print_ThrowsIllegalArgumentExceptionGivenInvalidEndNumber() throws Exception {
      expectedExceptionDetails(IllegalArgumentException.class,"Invalid end number. A number >=0 is expected" );
      fizzBuzzPrinter.print(1, -2);
    }
   
   @Test
    public void print_ThrowsIllegalArgumentExceptionGivenEndNumberEqualsStartNumber() throws Exception {
        expectedExceptionDetails(IllegalArgumentException.class,
                                 "Invalid end number. An end number must be greater than start number" );
        fizzBuzzPrinter.print(1, 1);
    }

    @Test
    public void print_ThrowsIllegalArgumentExceptionGivenEndNumberSmallerThanStartNumber() throws Exception {
       expectedExceptionDetails(IllegalArgumentException.class,
               "Invalid end number. An end number must be greater than start number" );
        fizzBuzzPrinter.print(5, 2);
    }

   @Test
   public void print_OutputNumbersFrom1To2() throws Exception {
      final List<String> expectedNumberRange = Arrays.asList("1","2");
      final List<String> actualNumberRange = fizzBuzzPrinter.print(1, 2);
      assertEquals("Printed numbers are not expected", actualNumberRange, expectedNumberRange);
   }
   
   @Test
   public void print_number3replacedByLucky_InNumbers1To3() throws Exception {
        final List<String> numbers = fizzBuzzPrinter.print(1, 3);
        assertThat("Output should not contain 3",numbers, not(hasItem("3")));
        assertThat("Output should contain lucky",numbers, hasItem("lucky"));
   }
    
    @Test
    public void print_number13replacedByLucky_InNumbers1To13() throws Exception {
        final List<String> numbers = fizzBuzzPrinter.print(1, 13);
        assertThat("Output should not contain 13", numbers, not(hasItem("13")));
        assertThat("Output should contain lucky", numbers, hasItem("lucky"));
    }

    @Test
    public void print_number5replacedByBuzz_InNumbers1To5() throws Exception {
        final List<String> numbers = fizzBuzzPrinter.print(1, 5);
        assertThat("Output should not contain 5", numbers, not(hasItem("5")));
        assertThat("Output should contain buzz", numbers, hasItem("buzz"));
    }
   
    @Test
    public void print_number10replacedByBuzz_InNumbers1To10() throws Exception {
        final List<String> numbers = fizzBuzzPrinter.print(1, 10);
        assertThat("Output should not contain 10", numbers, not(hasItem("10")));
        assertThat("Output should contain buzz", numbers, hasItem("buzz"));
    }

   @Test
    public void print_number6replacedByFizz_InNumbers1To6() throws Exception {
         final List<String> numbers = fizzBuzzPrinter.print(1, 6);
         assertThat("Output should not contain 6",numbers, not(hasItem("6")));
         assertThat("Output should contain fizz",numbers, hasItem("fizz"));
    }

   @Test
     public void print_number9And12replacedByFizz_15replacedByBuzz_InNumbers1To15() throws Exception {
        final List<String> numbers = fizzBuzzPrinter.print(1, 15);
        assertThat("Output should not contain 9", numbers, not(hasItem("9")));
        assertThat("Output should not contain 12", numbers, not(hasItem("12")));
        assertThat("Output should contain fizz", numbers, hasItem("fizz"));

        assertThat("Output should not contain 15", numbers, not(hasItem("15")));
        assertThat("Output should contain buzz", numbers, hasItem("buzz"));
     }

    @Test
    public void print_number15replacedByFizzbuzz_InNumbers1To15() throws Exception {
        final List<String> numbers = fizzBuzzPrinter.print(1, 15);
        assertThat("Output should not contain 15", numbers, not(hasItem("15")));
        assertThat("Output should contain fizzbuzz", numbers, hasItem("fizzbuzz"));
    }

   private void expectedExceptionDetails(Class<? extends Throwable> classType, String expectedExceptionMessage){
      expectedException.expect(classType);
      expectedException.expectMessage(expectedExceptionMessage);

   }

}
