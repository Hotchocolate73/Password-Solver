package dylan.solver;

public class PasswordSolver {
    public void solvePassword(String passwordToSolve, char lowerLimit, char upperLimit){
        long startTime = System.nanoTime();
        String constructedPassword = "";

        System.out.print("Solving using the following set of characters: ");
        for(char currentChar = lowerLimit; currentChar <= upperLimit; currentChar++){
            System.out.print(currentChar);
        }

        System.out.println();

        for(int passwordIndex = 0; passwordIndex < passwordToSolve.length(); passwordIndex++){
            for(char currentChar = lowerLimit; currentChar <= upperLimit; currentChar++){
                if(currentChar == passwordToSolve.charAt(passwordIndex)){
                    System.out.print(".");
                    constructedPassword += currentChar;
                }
            }
        }

        System.out.println();
        System.out.println("Your password is: " + constructedPassword);
        long endTime = System.nanoTime();
        double diff = (endTime - startTime) / 1000000000D;
        System.out.println("Elapsed time: " + diff + "s");
    }
}
