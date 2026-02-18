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
