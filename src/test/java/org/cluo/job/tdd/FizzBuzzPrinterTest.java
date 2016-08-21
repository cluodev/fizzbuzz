package org.cluo.job.tdd;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
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
        assertThat("Output list is not expected",numbers,
                is(Arrays.asList("1","2","lucky")));
   }
    
    @Test
    public void print_number13replacedByLucky_InNumbers1To13() throws Exception {
        final List<String> numbers = fizzBuzzPrinter.print(1, 13);
        assertThat("Output should not contain 13", numbers, not(hasItem("13")));
        //3,13
        assertThat("Occurrences of 'lucky' is wrong", countOccurrences(numbers, "lucky"), is(2));
    }

    @Test
    public void print_number30replacedByLucky_InNumbers1To30() throws Exception {
        final List<String> numbers = fizzBuzzPrinter.print(1, 30);
        assertThat("Output should not contain 30", numbers, not(hasItem("30")));
         //3,13,23,30
        assertThat("Occurrences of 'lucky' is wrong", countOccurrences(numbers, "lucky"), is(4));
    }

    @Test
    public void print_number5replacedByBuzz_InNumbers1To5() throws Exception {
        final List<String> numbers = fizzBuzzPrinter.print(1, 5);
        assertThat("Output should not contain 5", numbers, not(hasItem("5")));
        assertThat("Occurrences of 'buzz' is wrong", countOccurrences(numbers, "buzz"), is(1));
    }


    @Test
    public void print_number10replacedByBuzz_InNumbers1To10() throws Exception {
        final List<String> numbers = fizzBuzzPrinter.print(1, 10);
        assertThat("Output should not contain 10", numbers, not(hasItem("10")));
        //5,10 replaced
        assertThat("Occurrences of 'buzz' is wrong", countOccurrences(numbers, "buzz"), is(2));
    }

   @Test
    public void print_number6replacedByFizz_InNumbers1To6() throws Exception {
         final List<String> numbers = fizzBuzzPrinter.print(1, 6);
         assertThat("Output should not contain 6",numbers, not(hasItem("6")));
         assertThat("Occurrences of 'fizz' is wrong", countOccurrences(numbers, "fizz"), is(1));
    }

    @Test
    public void print_number9And12replacedByFizz_15replacedByFizzbuzz_InNumbers1To15() throws Exception {
        final List<String> numbers = fizzBuzzPrinter.print(1, 15);
        assertThat("Output should not contain 9", numbers, not(hasItem("9")));
        assertThat("Output should not contain 12", numbers, not(hasItem("12")));
        //6,9,12 replaced
        assertThat("Occurrences of 'fizz' is wrong", countOccurrences(numbers, "fizz"), is(3));

        //5,10 replaced
        assertThat("Occurrences of 'buzz' is wrong", countOccurrences(numbers, "buzz"), is(2));

        assertThat("Output should not contain 15", numbers, not(hasItem("15")));
        assertThat("Occurrences of 'fizzbuzz' is wrong", countOccurrences(numbers, "fizzbuzz"), is(1));
    }

    private int countOccurrences(List<String> entries, String entryToBeCounted) {
        int count=0;
        for (String entry : entries) {
            if (entryToBeCounted.equals(entry)){
                count++;
            }
        }
        return count;
    }

   private void expectedExceptionDetails(Class<? extends Throwable> classType, String expectedExceptionMessage){
      expectedException.expect(classType);
      expectedException.expectMessage(expectedExceptionMessage);

   }

}
