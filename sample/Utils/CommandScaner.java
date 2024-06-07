package sample.Utils;

import java.util.Scanner;

public class CommandScaner {
    public static final Scanner scanner = new Scanner(System.in);

    public static int ScanCommandNumber() throws NumberFormatException {
        return scanner.nextInt();
    }

    public static String ScanString() {
        String name = scanner.next();
        return name;
    }
}
