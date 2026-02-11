# Day 7: Exception Handling

## [Question 1](./ArrayIndexExceptionDemo.java)

Write a Java program to generate an ArrayIndexOutOfBoundsException and handle it using catch statement.

**Input:** `Enter the numbers - Example: 1 2 3 4 5 (Suppose array size is 4)`

**Output:** `Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException:4`

## [Question 2](./ArithmeticExceptionDemo.java)

Write a Java program to handle an ArithmeticException using try, catch, and finally block.

**Input:** `Enter two operands for division operation`

**Output:** `ArithmeticException caught by try-catch-finally block`

## [Question 3](./NegativeNumberDemo.java)

Write a Java class which has a method called ProcessInput(). This method checks the number entered by the user. If the entered number is negative then throw a user defined exception called NegativeNumberException, otherwise it displays the double value of the entered number.

**Input:** `Enter a number: 4`

**Output:** `Double value: 8`

**Input:** `Enter a number: -4`

**Output:**
```
Caught the exception
Exception occurred: NegativeNumberException: number should be positive
```

## [Question 4](./TimeExceptionDemo.java)

Write a program to create user defined exceptions called HrsException, MinException and SecException. Create a class Time which contains data members hours, minutes, seconds and methods to set the time from user which throws the user defined exceptions if hours (>24 or <0), minutes (>60 or <0), seconds (>60 or <0).

**Input:**
```
Enter hours: 4
Enter minutes: 54
Enter seconds: 34
```

**Output:** `Correct Time-> 4:54:34`

**Input:**
```
Enter hours: 30
Enter minutes: 65
Enter seconds: 65
```

**Output:**
```
Caught the exception
Exception occurred: HrsException:hour is not in range 0-24
Exception occurred: MinException:minute is not in range 0-60
Exception occurred: SecException:second is not in range 0-60
```

## [Question 5](./CheckArgumentDemo.java)

Create a user defined exception named CheckArgument to check the number of arguments passed through command line. If the number of arguments is less than four then throw the CheckArgument exception, else print the addition of squares of all the four elements.

**Input:** `4 3 2 1`

**Output:** `30`

**Input:** `4 3 2`

**Output:** `Exception occurred - CheckArgument`
