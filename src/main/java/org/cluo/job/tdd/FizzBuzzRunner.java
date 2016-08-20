package org.cluo.job.tdd;

import java.util.List;

import static org.apache.commons.lang.math.NumberUtils.isNumber;

public class FizzBuzzRunner {

    public FizzBuzzRunner(String[] arguments, FizzBuzzPrinter fizzBuzzPrinter) {
        if (areCommandArgumentsValid(arguments)) {
            List<String> collection = fizzBuzzPrinter.print(Integer.valueOf(arguments[0]), Integer.valueOf(arguments[1]));
            printResults(collection);
        }

    }

    private void printResults(final List<String> collection) {
        StringBuilder resultString = new StringBuilder();
        int numberOfEntries = collection.size();
        int loop = 0;
        for (String entry : collection) {
           resultString.append(entry);
           if (loop<numberOfEntries - 1){
               resultString.append(" ");
           }
            loop++;
        }
        System.out.println(resultString.toString());
    }

    private boolean areCommandArgumentsValid(String[] arguments) {
        if (arguments.length == 0 || arguments.length!=2) {
            System.out.print("Two arguments [start] and [end] are required");
            return false;
        } else if (!isNumber(arguments[0]) || !isNumber(arguments[1])) {
            System.out.print("Argument is not of number");
            return false;
        }
        return true;
    }

    public static void main (String[] arguments) {
        new FizzBuzzRunner(arguments, new FizzBuzzPrinter());
     }
}
