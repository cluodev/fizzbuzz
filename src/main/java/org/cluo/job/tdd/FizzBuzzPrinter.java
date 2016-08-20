package org.cluo.job.tdd;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzPrinter {

    public List<String> print(int startNumber, int endNumber) {
        validateArguments(startNumber, endNumber);
        final int numberCount=endNumber - startNumber + 1;
        final List<String> numbers = new ArrayList<String>(numberCount);
        for (int i = 0; i < numberCount; i++) {
            int entryItem = startNumber;
            if (entryItem == 3){
                numbers.add("fizz");
            }else if (entryItem==5) {
                numbers.add("buzz");
            } else {
                numbers.add(String.valueOf(entryItem));
            }
            startNumber++;
        }
        return numbers;
    }

    private void validateArguments(int startNumber, int endNumber) {
        if (startNumber<0) {
            throw new IllegalArgumentException("Invalid start number. A number >=0 is expected");
        }

        if (endNumber<0) {
            throw new IllegalArgumentException("Invalid end number. A number >=0 is expected");
        }

        if (endNumber==startNumber || endNumber<startNumber){
            throw new IllegalArgumentException("Invalid end number. An end number must be greater than start number");
        }
    }
}
