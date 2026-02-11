package lab.day8;

import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String : ");
        String firstStr = sc.nextLine();
        
        StringBuilder changedCase = new StringBuilder();
        for (int i = 0; i < firstStr.length(); i++) {
            char c = firstStr.charAt(i);
            if (Character.isLowerCase(c)) changedCase.append(Character.toUpperCase(c));
            else if (Character.isUpperCase(c)) changedCase.append(Character.toLowerCase(c));
            else changedCase.append(c);
        }
        System.out.println("The string after changing the case is " + changedCase);
        System.out.println("The string after reversing is " + new StringBuilder(firstStr).reverse());

        System.out.print("Enter the second string for comparision : ");
        String str2 = sc.nextLine();
        System.out.println("The difference between ASCII value is " + Math.abs(firstStr.compareTo(str2)));

        System.out.print("Enter the string to be inserted into first string : ");
        String insertStr = sc.nextLine();
        System.out.println("The string after insertion is : " + firstStr + " " + insertStr);

        System.out.print("Enter a String : ");
        String strCase = sc.nextLine();
        System.out.println("Uppercase: " + strCase.toUpperCase());
        System.out.println("Lowercase: " + strCase.toLowerCase());

        System.out.print("Enter a String : ");
        String strPos1 = sc.nextLine();
        System.out.print("Enter a character : ");
        char ch1 = sc.nextLine().charAt(0);
        int pos1 = strPos1.indexOf(ch1);
        if (pos1 != -1) {
            System.out.println("Position of entered character: " + (pos1 + 1));
        } else {
            System.out.println("Entered character is not present");
        }

        System.out.print("Enter a String : ");
        String strPos2 = sc.nextLine();
        System.out.print("Enter a character : ");
        char ch2 = sc.nextLine().charAt(0);
        int pos2 = strPos2.indexOf(ch2);
        if (pos2 != -1) {
            System.out.println("Position of entered character: " + (pos2 + 1));
        } else {
            System.out.println("Entered character is not present");
        }

        System.out.print("Enter a String : ");
        String strPal1 = sc.nextLine();
        if (strPal1.equals(new StringBuilder(strPal1).reverse().toString())) {
            System.out.println("Entered string is palindrome");
        } else {
            System.out.println("Entered string is not a palindrome");
        }

        System.out.print("Enter a String : ");
        String strPal2 = sc.nextLine();
        if (strPal2.equals(new StringBuilder(strPal2).reverse().toString())) {
            System.out.println("Entered string is palindrome");
        } else {
            System.out.println("Entered string is not a palindrome");
        }

        System.out.print("Enter a String : ");
        String countStr = sc.nextLine();
        int words = 0, vowels = 0, consonants = 0;
        String trimmed = countStr.trim();
        if (!trimmed.isEmpty()) {
            words = trimmed.split("\\s+").length;
        }
        for (char c : countStr.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if ("aeiou".indexOf(c) != -1) vowels++;
                else consonants++;
            }
        }
        System.out.println("No. of words: " + words);
        System.out.println("No. of vowels: " + vowels);
        System.out.println("No. of consonants: " + consonants);

        sc.close();
    }
}
