package dylan.main;

import dylan.solver.PasswordInput;
import dylan.solver.PasswordSolver;

public class Main {
    public static void main(String[] args) {
        PasswordSolver solver = new PasswordSolver();
        String password = PasswordInput.getPasswordFromConsole('!', 'z');
        solver.solvePassword(password, '!', 'z');
    }
}
