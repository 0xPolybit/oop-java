# Day 9: File Handling

## [Question 1](./StudentFileDemo.java)

Write a Java program which will accept student details like Student RollNo, Name, Subject, Marks from the keyboard using Scanner class, store the same in a file. Again open the file, read the content and display all.

**Input:**
```
Enter number of students: 2
Enter the name of the file to write student details: students.txt
Enter details for student 1:
Roll No: 101
Name: Amit
Subject: Java
Marks: 85
Enter details for student 2:
Roll No: 102
Name: Kumar
Subject: Python
Marks: 90
```

**Output:**
```
Student details written to file: students.txt

Reading student details from file: students.txt
RollNo  Name    Subject Marks
101     Amit    Java    85
102     Kumar   Python  90
```

## [Question 2](./FileCopyDemo.java)

Write a program in Java to copy the content of a given file to another user entered file using character stream (using FileReader and FileWriter classes) and byte stream (using FileInputStream and FileOutputStream classes).

**Input:**
```
Enter the source file name: sourcefile.txt
Enter the destination file name for character stream copy: chardest.txt
Enter the destination file name for byte stream copy: bytedest.txt
```

**Output:**
```
File Copied using Character Stream to: chardest.txt
File Copied using Byte Stream to: bytedest.txt
```

## [Question 3](./BinaryFileCompare.java)

Write a Java program to compare two binary files, printing the first byte position where they differ.

**Input:** `Two binary files specified in the program (file1.bin, file2.bin)`

**Output:** `Two files are equal`

**Input:** `Two binary files specified in the program (file1.bin, file2.bin)`

**Output:** `Two files are not equal: byte position at which two files differ is 30`

## [Question 4](./FileStats.java)

Write a Java program that displays the number of characters, number of lines and number of words present in a text file whose name is given by the user.

**Input:** `Enter the name of the file: filename.txt`

**Output:**
```
No. of characters - 100
No. of lines - 5
No. of words - 20
```
