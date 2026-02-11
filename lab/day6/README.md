# Day 6: Packages and Nested/Inner Classes

## [Question 1](./HelloWorld.java)

Create HelloWorld class in a separate package called "mypack" and run it.

**Input:** `No user input required`

**Output:** `Hello World`

## [Question 2](./Sales.java)

Define two packages as – General and Marketing. In General package define a class 'Employee' with data members as empid(protected), ename(private) and a public method as earnings() which calculates total earnings as:
- earnings: basic + DA (80% of basic) + HRA (15% of basic)

In Marketing package define a class 'Sales' which is extending from 'Employee' class and has a method tallowance() which calculates Travelling Allowance as 5% of total earning. Write the programs to find out total earning of a sales person for the given basic salary amount and print along with the emp id.

**Input:**
```
Enter the employee id and employee name: 123 Amit
Enter the basic salary: 1000
```

**Output:**
```
The emp id of the employee is 123
The total earning is 1950.0
```

## [Question 3](./UniversityDemo.java)

Design a class University that contains an inner class Department. University has fields: universityName, location; Department has fields: deptName, hodName. The inner class should access and display the outer class data. Create an object of the inner class from the outer class.

**Input:** `Values mentioned in the program`

**Output:**
```
University: KIIT University
Location: Bhubaneswar
Department: Computer Science
HOD: Dr. A. Kumar
```

## [Question 4](./BankDemo.java)

Create a class Bank with a static nested class InterestCalculator that has a static method to calculate simple interest. Demonstrate that static nested classes cannot access non-static members directly.

**Input:** `Values mentioned in the program`

**Output:**
```
Simple Interest: 100.0
Non-static member accessed through object: Global Bank
```

## [Question 5](./GreetingDemo.java)

Create an interface Greeting with a method sayHello(). Implement the interface using an anonymous inner class and display a custom greeting message.

**Input:** `No user input required`

**Output:** `Hello, this is a custom greeting from an anonymous inner class!`
