# Day 5: Interfaces

## [Question 1](./WashingMachine.java)

Define an interface Motor with a data member – capacity and two methods such as run() and consume(). Define a Java class 'WashingMachine' which implements this interface and write the code to check the value of the interface data member through an object of the class.

**Input:** `Values mentioned in the program`

**Output:** `Capacity of the motor is 5`

## [Question 2](./Substaff.java)

Define an interface Salary with three methods – earnings(), deductions() and bonus() and define a Java class 'Manager' which uses this interface without implementing bonus() method. Also define another Java class 'Substaff' which extends from 'Manager' class and implements bonus() method. Write the complete program to find out earnings, deduction and bonus of a substaff with basic salary amount entered by the user as per the following guidelines:
- earnings: basic + DA (80% of basic) + HRA (15% of basic)
- deduction PF: 12% of basic
- bonus: 50% of basic

**Input:** `Basic salary - 50000`

**Output:**
```
Earnings - 97500
Deduction - 6000
Bonus - 25000
```

## [Question 3](./Head.java)

Define an interface Employee with a method getDetails() to get employee details as Empid and Ename. Also define a derived interface Manager with a method getDeptDetails() to get department details such as Deptid and Deptname. Then define a class Head which implements Manager interface and also prints all details of the employee. Write the complete program to display all details of one head of the department.

**Input:**
```
Enter employee id - 123
Enter employee name - Sidharth Ambani
Enter department id - 06
Enter department name - Marketing
```

**Output:**
```
Employee id - 123
Employee name - Sidharth Ambani
Department id - 06
Department name - Marketing
```
