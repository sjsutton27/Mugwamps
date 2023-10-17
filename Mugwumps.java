import java.util.Arrays;
import java.util.Scanner;

public class Mugwumps {
    public static void main(String[] args) {
        int[] board = new int[100]; // Fixed array declaration
        int guesses = 10;
        int userX, userY; // Removed initialization
        boolean won = false;

        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 4; i++) { // Fixed loop control
            int mugwumpsX = (int) (Math.random() * 10); // Adjusted grid size
            int mugwumpsY = (int) (Math.random() * 10); // Adjusted grid size
            int mugwumpIndex = convert2d1d(mugwumpsX, mugwumpsY);
            board[mugwumpIndex] = 1;
        }

        while (guesses > 0 && !won) { // Fixed loop conditions
            System.out.println("Enter X:");
            userX = input.nextInt(); // Changed next() to nextInt()
            System.out.println("Enter Y:");
            userY = input.nextInt(); // Changed next() to nextInt()

            if (isValidSpot(userX, userY)) {
                int id = convert2d1d(userX, userY);
                if (board[id] == 1) {
                    board[id] = 2;
                    guesses--;
                    System.out.println("You found a Mugwump!");
                } else {
                    double distance = distanceFromMugwump(userX, userY, userX, userY);
                    System.out.println("Distance from Mugwump: " + distance);
                    guesses--;
                }
                won = checkWin(board);
            } else {
                System.out.println("Invalid Coordinates");
            }
        }

        if (won) {
            System.out.println("Congratulations! You found all the Mugwumps!");
        } else {
            System.out.println("Game over. You've run out of guesses.");
        }
    }

    public static int generateMugwump() {
        int Mugwumps = (int) (Math.random() * 100);
        return Mugwumps;
    }

    public static boolean isValidSpot(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }

    public static double distanceFromMugwump(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static int convert2d1d(int x, int y) {
        return y * 10 + x;
    }

    public static boolean checkWin(int[] board) {
        for (int i = 0; i < 100; i++) {
            if (board[i] == 1) {
                return false;
            }
        }
        return true;
    }
}
