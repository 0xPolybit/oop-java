# Day 9: File Handling - Common Errors

---

## Question 1: Student Details File I/O

### Source Code

```java
package lab.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentFileDemo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the name of the file to write student details: ");
        String fileName = sc.nextLine();

        FileWriter fw = new FileWriter(fileName);

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Roll No: ");
            int rollNo = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Subject: ");
            String subject = sc.nextLine();
            System.out.print("Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            fw.write(rollNo + "," + name + "," + subject + "," + marks + "\n");
        }

        fw.close();
        System.out.println("Student details written to file: " + fileName);

        System.out.println("\nReading student details from file: " + fileName);
        System.out.println("RollNo\tName\tSubject\tMarks");

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            System.out.println(parts[0] + "\t" + parts[1] + "\t" + parts[2] + "\t" + parts[3]);
        }
        br.close();

        sc.close();
    }
}
```

### Sample Input/Output

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

### Common Errors

| Sl No. | Error | Error Type | Error Fix |
|--------|-------|------------|-----------|
| 1 | `InputMismatchException` when a non-integer is entered for Roll No or Marks | Runtime | Validate input or use `nextLine()` with `Integer.parseInt()` wrapped in a try-catch |
| 2 | `ArrayIndexOutOfBoundsException` when reading back the file if a student's name or subject contains a comma | Runtime | Use a different delimiter (e.g., `\|`) that is unlikely to appear in input data |
| 3 | Missing `sc.nextLine()` after `sc.nextInt()` causes the Name field to be skipped and read as empty | Logical | Always call `sc.nextLine()` immediately after `sc.nextInt()` to consume the leftover newline |

---

## Question 2: File Copy using Character and Byte Streams

### Source Code

```java
package lab.day9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyDemo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the source file name: ");
        String source = sc.nextLine();

        System.out.print("Enter the destination file name for character stream copy: ");
        String charDest = sc.nextLine();

        FileReader fr = new FileReader(source);
        FileWriter fw = new FileWriter(charDest);
        int ch;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }
        fr.close();
        fw.close();
        System.out.println("File Copied using Character Stream to: " + charDest);

        System.out.print("Enter the destination file name for byte stream copy: ");
        String byteDest = sc.nextLine();

        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(byteDest);
        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }
        fis.close();
        fos.close();
        System.out.println("File Copied using Byte Stream to: " + byteDest);

        sc.close();
    }
}
```

### Sample Input/Output

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

### Common Errors

| Sl No. | Error | Error Type | Error Fix |
|--------|-------|------------|-----------|
| 1 | `FileNotFoundException` when the source file does not exist at the given path | Runtime | Verify the file exists before opening, or handle the exception and prompt the user to re-enter the filename |
| 2 | Character stream (`FileReader`/`FileWriter`) may corrupt binary files because it performs character encoding conversion | Logical | Use `FileInputStream`/`FileOutputStream` (byte stream) for binary files; use character streams only for text files |
| 3 | Destination file is silently overwritten if it already exists, causing unintended data loss | Logical | Check if the destination file exists using `new File(dest).exists()` and prompt the user for confirmation before overwriting |

---

## Question 3: Binary File Comparison

### Source Code

```java
package lab.day9;

import java.io.FileInputStream;
import java.io.IOException;

public class BinaryFileCompare {
    public static void main(String[] args) throws IOException {
        String file1 = "file1.bin";
        String file2 = "file2.bin";

        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        int byte1, byte2;
        long position = 1;
        boolean equal = true;

        while (true) {
            byte1 = fis1.read();
            byte2 = fis2.read();

            if (byte1 == -1 && byte2 == -1) {
                break;
            }

            if (byte1 != byte2) {
                equal = false;
                break;
            }

            position++;
        }

        fis1.close();
        fis2.close();

        if (equal) {
            System.out.println("Two files are equal");
        } else {
            System.out.println("Two files are not equal: byte position at which two files differ is " + position);
        }
    }
}
```

### Sample Input/Output

**Input:** `Two binary files specified in the program (file1.bin, file2.bin)`

**Output:** `Two files are equal`

**Input:** `Two binary files specified in the program (file1.bin, file2.bin)`

**Output:** `Two files are not equal: byte position at which two files differ is 30`

### Common Errors

| Sl No. | Error | Error Type | Error Fix |
|--------|-------|------------|-----------|
| 1 | `FileNotFoundException` if either `file1.bin` or `file2.bin` does not exist in the working directory | Runtime | Ensure both files exist in the project root, or use absolute paths, or accept filenames from the user at runtime |
| 2 | Files of different lengths where one ends before the other are not correctly identified as unequal if only the `-1 && -1` check is used (one returns -1 while the other still has data) | Logical | The current `byte1 != byte2` comparison handles this since `-1 != remaining_byte`, but explicitly checking `(byte1 == -1) != (byte2 == -1)` makes the intent clearer |
| 3 | `fis2.close()` is never reached if `fis1.close()` throws an exception, causing a resource leak | Runtime | Use a try-with-resources block: `try (FileInputStream fis1 = ...; FileInputStream fis2 = ...)` to guarantee both streams are closed |

---

## Question 4: File Statistics (Characters, Lines, Words)

### Source Code

```java
package lab.day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileStats {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name of the file: ");
        String fileName = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        int characters = 0;
        int lines = 0;
        int words = 0;

        String line;
        while ((line = br.readLine()) != null) {
            lines++;
            characters += line.length();
            if (!line.trim().isEmpty()) {
                words += line.trim().split("\\s+").length;
            }
        }

        br.close();
        sc.close();

        System.out.println("No. of characters - " + characters);
        System.out.println("No. of lines - " + lines);
        System.out.println("No. of words - " + words);
    }
}
```

### Sample Input/Output

**Input:** `Enter the name of the file: sample.txt`

**Output:**
```
No. of characters - 100
No. of lines - 5
No. of words - 20
```

### Common Errors

| Sl No. | Error | Error Type | Error Fix |
|--------|-------|------------|-----------|
| 1 | `FileNotFoundException` when the user enters a filename that does not exist | Runtime | Wrap the `FileReader` in a try-catch block and display a user-friendly message prompting re-entry of a valid filename |
| 2 | Character count does not include newline characters (`\n`) since `readLine()` strips them, leading to a lower count than expected | Logical | Add `lines` (or `lines - 1` for the last line) to `characters` if newline characters should be included in the count |
| 3 | `int` overflow for very large files where total character count exceeds `Integer.MAX_VALUE` (2,147,483,647) | Runtime | Use `long` instead of `int` for the `characters`, `lines`, and `words` counters |
