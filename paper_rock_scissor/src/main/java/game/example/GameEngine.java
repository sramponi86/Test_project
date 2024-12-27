package game.example;

import java.util.Random;

public class GameEngine {
    private final String[] choices = {"rock", "paper", "scissors"};

    public String generateComputerMove() {
        Random random = new Random();
        return choices[random.nextInt(choices.length)];
    }

    public String determineWinner(String move1, String move2) {
        if (move1.equals(move2)) {
            return "It's a tie!";
        }

        return switch (move1) {
            case "rock" -> move2.equals("scissors") ? "Player 1 wins!" : "Player 2 wins!";
            case "paper" -> move2.equals("rock") ? "Player 1 wins!" : "Player 2 wins!";
            case "scissors" -> move2.equals("paper") ? "Player 1 wins!" : "Player 2 wins!";
            default -> "Invalid move by Player 1!";
        };
    }
}
