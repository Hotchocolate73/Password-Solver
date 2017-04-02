package dylan.solver;

import java.util.ArrayList;
import java.util.List;

public class PasswordSolver {
    public void solvePassword(String passwordToSolve, char lowerLimit, char upperLimit){
        System.out.println("Password length: " + passwordToSolve.length() + " characters");
        long startTime = System.nanoTime();

        int attempts = 0;
        String validCharacters = getValidCharacters(lowerLimit, upperLimit);




        System.out.println("Solving using the following set of characters:\n" + validCharacters);

        List<Character> constructedPasswordList = new ArrayList<>();
        boolean leaveCondition = false;
        int currentIndex = 0;
        for(int charInPassword = 0; charInPassword < passwordToSolve.length(); charInPassword++){
            constructedPasswordList.add(' ');
            constructedPasswordList.set(charInPassword, validCharacters.charAt(0));
            char currentChar = constructedPasswordList.get(charInPassword);
            int currentValue = (int)currentChar;
            int nextValue = (int)currentChar;
            char nextChar = currentChar;

            while(currentChar < validCharacters.charAt(validCharacters.length() - 1)){
                currentChar = nextChar;
                currentValue = (int)currentChar;
                nextValue = (int)currentChar + 1;
                nextChar = (char)nextValue;
                constructedPasswordList.set(charInPassword, currentChar);
                System.out.println("current char: " + currentChar + " next char: " + nextChar + " current guess: " + charArrayListToString(constructedPasswordList));

                if(charArrayListToString(constructedPasswordList).equals(passwordToSolve)){
                    leaveCondition = true;
                    break;
                }

                currentValue++;
            }

            if(leaveCondition){
                break;
            }
        }

        System.out.println();

        if(charArrayListToString(constructedPasswordList).equals(passwordToSolve)) {
            System.out.println("Your password is: " + charArrayListToString(constructedPasswordList));
            System.out.println("Attempts to guess: " + attempts);
        } else {
            System.out.println("ERROR: COULD NOT SOLVE FOR PASSWORD \"" + passwordToSolve + "\" WITH CHARSET \"" + validCharacters + "\".");
        }

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

    private String getValidCharacters(char lowerLimit, char upperLimit){
        String validCharacters = "";

        for(char currentChar = lowerLimit; currentChar <= upperLimit; currentChar++){
            validCharacters += currentChar;
        }

        return validCharacters;
    }
}
