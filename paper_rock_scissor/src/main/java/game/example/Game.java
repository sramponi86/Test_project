package game.example;

import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private final GameEngine engine = new GameEngine();

    public void start() {
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Choose a mode:");
        System.out.println("1. Player vs Computer");
        System.out.println("2. Computer vs Computer");
        
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> playerVsComputer();
            case 2 -> computerVsComputer();
            default -> System.out.println("Invalid choice. Exiting...");
        }
    }

    private void playerVsComputer() {
        System.out.println("Enter your choice (rock, paper, scissors):");
        String playerMove = scanner.next().toLowerCase();
        String computerMove = engine.generateComputerMove();

        System.out.println("Computer chose: " + computerMove);
        System.out.println(engine.determineWinner(playerMove, computerMove));
    }

    private void computerVsComputer() {
        String computer1Move = engine.generateComputerMove();
        String computer2Move = engine.generateComputerMove();

        System.out.println("Computer 1 chose: " + computer1Move);
        System.out.println("Computer 2 chose: " + computer2Move);
        System.out.println(engine.determineWinner(computer1Move, computer2Move));
    }
}
