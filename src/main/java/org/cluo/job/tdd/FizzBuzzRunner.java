package org.cluo.job.tdd;

import java.util.List;

import static org.apache.commons.lang.math.NumberUtils.isNumber;

public class FizzBuzzRunner {

    public FizzBuzzRunner(String[] arguments, FizzBuzzPrinter fizzBuzzPrinter) {
        if (areCommandArgumentsValid(arguments)) {
            try {
                List<String> collection =
                        fizzBuzzPrinter.print(Integer.valueOf(arguments[0]), Integer.valueOf(arguments[1]));
                printCollection(collection);
                printCollectionReport(collection);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

    private void printCollectionReport(final List<String> collection) {
         FizzBuzzReporter fizzBuzzReporter = new FizzBuzzReporter(
              new WordCounter(collection,"fizz"),
              new WordCounter(collection,"buzz"),
              new WordCounter(collection,"fizzbuzz"),
              new WordCounter(collection,"lucky"),
              new IntegerCounter(collection)
         );
         System.out.print(fizzBuzzReporter.report());
    }

    private void printCollection(final List<String> collection) {
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
            System.out.println("Two arguments [start] and [end] are required");
            return false;
        } else if (!isNumber(arguments[0]) || !isNumber(arguments[1])) {
            System.out.println("Argument is not of number");
            return false;
        }
        return true;
    }

    public static void main (String[] arguments) {
        new FizzBuzzRunner(arguments, new FizzBuzzPrinter());
     }
}
