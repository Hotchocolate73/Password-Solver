package dylan.solver;

import java.util.Scanner;

public class PasswordInput {
    public static String getPasswordFromConsole(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the password to solve:\n>");
        return scanner.nextLine();
    }
}
