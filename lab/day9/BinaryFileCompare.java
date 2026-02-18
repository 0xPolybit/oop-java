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
