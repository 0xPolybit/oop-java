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
