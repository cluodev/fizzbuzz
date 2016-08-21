#FizzBuzz Fun

#Requirements
Write some code that prints out the following for a contiguous range of numbers:
* the number
* 'fizz' for numbers that are multiples of 3
* 'buzz' for numbers that are multiples of 5
* 'fizzbuzz' for numbers that are multiples of 15
* If the number contains a three you must output the text 'lucky'. This overrides any existing behaviour
* Produce a report at the end of the program showing how many times the following were output
  - fizz
  - buzz
  - fizzbuzz
  - lucky
  - integer

# System requirements
- Java 1.7
- Maven 3

# Build
- mvn clean install

# Run
- java -jar release/fizzbuzz-1.0-SNAPSHOT-standalone.jar 1 20
