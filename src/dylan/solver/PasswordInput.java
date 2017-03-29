package dylan.solver;

import java.util.Scanner;

public class PasswordInput {
    public static String getPasswordFromConsole(char lowerLimit, char upperLimit){
        Scanner scanner = new Scanner(System.in);


        boolean leaveCondition = false;
        String userInput = "";
        while(!leaveCondition) {
            System.out.print("Enter the password to solve:\n>");
            userInput = scanner.nextLine();
            leaveCondition = true;

            for (int userInputIndex = 0; userInputIndex < userInput.length(); userInputIndex++) {
                char currentChar = userInput.charAt(userInputIndex);
                if (currentChar > upperLimit || currentChar < lowerLimit) {
                    System.out.println("Inavlid character detected! - \'" + currentChar + "\'");
                    leaveCondition = false;
                }
            }
        }

        return userInput;
    }
}
