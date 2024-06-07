package Practice01Class.ishida.practice;

import java.util.Scanner;


public class CommandScaner {
    static final Scanner scanner = new Scanner(System.in);

    static int ScanCommandNumber() throws NumberFormatException{
            return scanner.nextInt();
    }

    static String ScanString(){
        String name = scanner.next();
        return name;
    }
}
