package org.cluo.job.tdd;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzPrinter {

    public List<String> print(int startNumber, int endNumber) {
        validateArguments(startNumber, endNumber);
        final int numberCount=endNumber - startNumber + 1;
        final List<String> items = new ArrayList<String>(numberCount);
        for (int i = 0; i < numberCount; i++) {
            replaceNumberWithFizzbuzzOrLucky(items, startNumber);
            startNumber++;
        }
        return items;
    }

    private void replaceNumberWithFizzbuzzOrLucky(final List<String> collection, final int entryItem) {
        if (isMultipleOf15(entryItem)){
           collection.add("fizzbuzz");
        } else if (isMultipleOf3(entryItem)){
            if (itemContains3(entryItem)){
                collection.add("lucky");
            } else {
                collection.add("fizz");
            }
        } else if (isMultipleOf5(entryItem)) {
           collection.add("buzz");
        }
        else {
            if (itemContains3(entryItem)){
                collection.add("lucky");
            } else {
                collection.add(String.valueOf(entryItem));
            }
        }
    }

    private boolean itemContains3(int entryItem) {
        String entryStr = String.valueOf(entryItem);
        char[] chars = entryStr.toCharArray();
        for (char aChar : chars) {
            if ('3'==aChar){
                return true;
            }
        }
        return false;
    }

    private boolean isMultipleOf5(final int entryItem) {
        return entryItem % 5 == 0;
    }

    private boolean isMultipleOf3(final int entryItem) {
        return entryItem % 3 == 0;
    }

    private boolean isMultipleOf15(int entryItem) {
        return entryItem % 15 == 0;
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
