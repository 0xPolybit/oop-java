package lab.day8;

import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String : ");
        String name = sc.next();
        String newname = changeCase(name);
        System.out.println("name after modification of case is " + newname);
        newname = reverseString(newname);
        System.out.println("name after reversal is " + newname);

        sc.nextLine();

        System.out.print("Enter the second string for comparision : ");
        String str2 = sc.nextLine();
        System.out.println("The difference between ASCII value is " + compareStrings(name, str2));

        System.out.print("Enter the string to be inserted into first string : ");
        String insertStr = sc.nextLine();
        System.out.println("The string after insertion is : " + insertString(name, insertStr));

        System.out.print("Enter a String : ");
        String strCase = sc.nextLine();
        displayUpperLower(strCase);

        System.out.print("Enter a String : ");
        String strPos1 = sc.nextLine();
        System.out.print("Enter a character : ");
        char ch1 = sc.nextLine().charAt(0);
        checkChar(strPos1, ch1);

        System.out.print("Enter a String : ");
        String strPos2 = sc.nextLine();
        System.out.print("Enter a character : ");
        char ch2 = sc.nextLine().charAt(0);
        checkChar(strPos2, ch2);

        System.out.print("Enter a String : ");
        String pal1 = sc.nextLine();
        checkPalindrome(pal1);

        System.out.print("Enter a String : ");
        String pal2 = sc.nextLine();
        checkPalindrome(pal2);

        System.out.print("Enter a String : ");
        String countStr = sc.nextLine();
        countStats(countStr);

        sc.close();
    }

    static String changeCase(String str) {
        String result = null;
        result = str.toUpperCase();
        return result;
    }

    static String reverseString(String str) {
        String result = null;
        StringBuffer sb = new StringBuffer(str);
        result = sb.reverse().toString();
        return result;
    }

    static int compareStrings(String s1, String s2) {
        int result = 0;
        result = Math.abs(s1.compareTo(s2));
        return result;
    }

    static String insertString(String s1, String s2) {
        String result = null;
        result = s1 + " " + s2;
        return result;
    }

    static void displayUpperLower(String str) {
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());
    }

    static void checkChar(String str, char ch) {
        int pos = str.indexOf(ch);
        if (pos != -1) {
            System.out.println("Position of entered character: " + (pos + 1));
        } else {
            System.out.println("Entered character is not present");
        }
    }

    static void checkPalindrome(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(rev)) {
            System.out.println("Entered string is palindrome");
        } else {
            System.out.println("Entered string is not a palindrome");
        }
    }

    static void countStats(String str) {
        int words = 0, vowels = 0, consonants = 0;
        String trimmed = str.trim();
        if (!trimmed.isEmpty()) {
            words = trimmed.split("\\s+").length;
        }
        for (char c : str.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if ("aeiou".indexOf(c) != -1) vowels++;
                else consonants++;
            }
        }
        System.out.println("No. of words: " + words);
        System.out.println("No. of vowels: " + vowels);
        System.out.println("No. of consonants: " + consonants);
    }
}
