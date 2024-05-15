package sample;
import java.util.Scanner;

public class CommandScaner {
    private final Scanner scanner = new Scanner(System.in);

    int ScanCommandNumber(){
        try{
            return scanner.nextInt();
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
            return Common.errorCommand;
        }
    }

    String ScanString(){
        String name = scanner.next();
        return name;
    }
}
