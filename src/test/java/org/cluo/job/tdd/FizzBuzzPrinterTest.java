package org.cluo.job.tdd;

import java.util.ArrayList;
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
      final List<String> expectedNumberRange = Arrays.asList(new String[]{"1","2"});
      final List<String> actualNumberRange = fizzBuzzPrinter.print(1, 2);
      assertEquals("Printed numbers are not expected", actualNumberRange, expectedNumberRange);
   }
   
   @Test
   public void print_number3replacedByFizzInNumbers1To3() throws Exception {
        final List<String> numbers = fizzBuzzPrinter.print(1, 3);
        assertThat("Output should not contain 3",numbers, not(hasItem("3")));
        assertThat("Output should contain fizz",numbers, hasItem("fizz"));
   }

   @Test
     public void print_number5replacedByBuzzInNumbers1To5() throws Exception {
          final List<String> numbers = fizzBuzzPrinter.print(1, 5);
          assertThat("Output should not contain 5",numbers, not(hasItem("5")));
          assertThat("Output should contain buzz",numbers, hasItem("buzz"));
     }


   private void expectedExceptionDetails(Class<? extends Throwable> classType, String expectedExceptionMessage){
      expectedException.expect(classType);
      expectedException.expectMessage(expectedExceptionMessage);

   }

}
