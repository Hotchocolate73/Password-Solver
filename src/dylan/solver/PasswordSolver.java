package dylan.solver;

import java.util.ArrayList;
import java.util.List;

public class PasswordSolver {
    public void solvePassword(String passwordToSolve, char lowerLimit, char upperLimit){
        System.out.println("Password length: " + passwordToSolve.length() + " characters");
        long startTime = System.nanoTime();

        int attempts = 0;
        String validCharacters = "";

        System.out.print("Solving using the following set of characters: ");
        for(char currentChar = lowerLimit; currentChar <= upperLimit; currentChar++){
            validCharacters += currentChar;
        }


        System.out.println(validCharacters);

//        for(int passwordIndex = 0; passwordIndex < passwordToSolve.length(); passwordIndex++){
//            for(char currentChar = lowerLimit; currentChar <= upperLimit; currentChar++){
//                if(currentChar == passwordToSolve.charAt(passwordIndex)){
//                    System.out.print(".");
//                    constructedPassword += currentChar;
//                }
//
//                attempts++;
//            }
//        }
        List<Character> constructedPasswordList = new ArrayList<>();
        boolean leaveCondition = false;
        int currentIndex = 0;
        constructedPasswordList.add(' ');
        while(true) {

            for (int i = 0; i < validCharacters.length(); i++) {
                char currentCharInValid = validCharacters.charAt(i);
                constructedPasswordList.set(currentIndex, currentCharInValid);
                System.out.print(charArrayListToString(constructedPasswordList) + ", ");

                if (charArrayListToString(constructedPasswordList).equals(passwordToSolve)) {
                    break;
                }
                else if(currentCharInValid == validCharacters.charAt(validCharacters.length() - 1)){
                    constructedPasswordList.add(validCharacters.charAt(0));
                }
            }

            System.out.println();
            currentIndex++;
            break;
        }

        System.out.println();
        System.out.println("Your password is: " + charArrayListToString(constructedPasswordList));
        System.out.println("Attempts to guess: " + attempts);
        long endTime = System.nanoTime();
        double diff = (endTime - startTime) / 1000000000D;
        System.out.println("Elapsed time: " + diff + "s");
    }

    private String charArrayListToString(List<Character> list){
        StringBuilder builder = new StringBuilder(list.size());

        for(Character ch : list){
            builder.append(ch);
        }

        return builder.toString();
    }
}
