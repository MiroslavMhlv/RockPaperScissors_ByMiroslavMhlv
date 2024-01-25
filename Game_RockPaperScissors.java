import java.util.Random;
import java.util.Scanner;

public class Game_RockPaperScissors {

    private static final String ROCK = "ROCK";
    private static final String PAPER = "PAPER";
    private static final String SCISSORS = "SCISSORS";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\t\t\t\tWelcome to the game of Rock-Paper-Scissors! Please enter your username.\n" +
                "\t\t\t\t\t\t\t\t\t\tUsername: ");
        String username = scanner.nextLine();

        boolean gameOver = false;
        int playerWins = 0;
        int computerWins = 0;

        while (!gameOver) {

            System.out.print("\n\t\t\t\t\tChoose rock [R], paper [P] or scissors [S]: ");
            String playerMove = scanner.nextLine();

            if (playerMove.equalsIgnoreCase("r") || playerMove.equalsIgnoreCase("rock")) {
                playerMove = ROCK;
            } else if (playerMove.equalsIgnoreCase("p") || playerMove.equalsIgnoreCase("paper")) {
                playerMove = PAPER;
            } else if (playerMove.equalsIgnoreCase("s") || playerMove.equalsIgnoreCase("scissors")) {
                playerMove = SCISSORS;
            } else {
                System.out.println("\t\t\t\t\t\t[ERROR] Invalid Input. Try again...");
                continue;
            }

            Random random = new Random();
            int computerRandomNumber = random.nextInt(3);

            String computerMove = "";

            switch (computerRandomNumber) {
                case 0:
                    computerMove = ROCK;
                    break;
                case 1:
                    computerMove = PAPER;
                    break;
                case 2:
                    computerMove = SCISSORS;
                    break;
            }

            System.out.printf("\n\t\t\t\t\tYou chose %s! The computer chose %s.\n", playerMove, computerMove);

            if ((playerMove.equals(ROCK) && computerMove.equals(SCISSORS)) ||
                    (playerMove.equals(PAPER) && computerMove.equals(ROCK)) ||
                    (playerMove.equals(SCISSORS) && computerMove.equals(PAPER))) {
                playerWins++;
                System.out.printf("\t\t\t\t\tYou WIN. Result: [%s %d:%d Computer]", username, playerWins, computerWins);
            } else if ((playerMove.equals(ROCK) && computerMove.equals(PAPER)) ||
                    (playerMove.equals(PAPER) && computerMove.equals(SCISSORS)) ||
                    (playerMove.equals(SCISSORS) && computerMove.equals(ROCK))) {
                computerWins++;
                System.out.printf("\t\t\t\t\tYou LOSE. Result: [%s %d:%d Computer]", username, playerWins, computerWins);
            } else {
                System.out.printf("\t\t\t\t\tThis game was a DRAW. Result: [%s %d:%d Computer]", username, playerWins, computerWins);
            }

            System.out.print("\n\n\t\tDo you want to continue? Type \"no\" to stop or anything else to continue playing. ");
            String continuePlay = scanner.nextLine();

            if (continuePlay.equalsIgnoreCase("no") || continuePlay.equalsIgnoreCase("n")) {
                gameOver = true;
                System.out.println("\n\t\t\t\tThis game was made by Miroslav Mihaylov. A student from SoftUni." +
                        "\n\t\t\t\t\t\t\t\t\tThank you for playing, " + username + "!");
            }
        }
    }
}