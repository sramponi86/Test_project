import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import game.example.GameEngine;

public class GameEngineTest {

    @Test
    public void testDetermineP1Winner() {
        GameEngine engine = new GameEngine();
        // Test Player 1 wins scenarios
        assertEquals("Player 1 wins!", engine.determineWinner("rock", "scissors"));
        assertEquals("Player 1 wins!", engine.determineWinner("paper", "rock"));
        assertEquals("Player 1 wins!", engine.determineWinner("scissors", "paper"));
    }

    @Test
    public void testDetermineP2Winner() {
        GameEngine engine = new GameEngine();
        // Test Player 2 wins scenarios
        assertEquals("Player 2 wins!", engine.determineWinner("rock", "paper"));
        assertEquals("Player 2 wins!", engine.determineWinner("paper", "scissors"));
        assertEquals("Player 2 wins!", engine.determineWinner("scissors", "rock"));
    }

    @Test
    public void testDetermineInvalidSelection() {
        GameEngine engine = new GameEngine();
        // Test invalid move
        assertEquals("Invalid move by Player 1!", engine.determineWinner("invalid", "rock"));
    }
    
    @Test
    public void testDetermineTie() {
        GameEngine engine = new GameEngine();

        // Test tie scenarios
        assertEquals("It's a tie!", engine.determineWinner("rock", "rock"));
        assertEquals("It's a tie!", engine.determineWinner("paper", "paper"));
        assertEquals("It's a tie!", engine.determineWinner("scissors", "scissors"));
    }

    @Test
    void testGenerateComputerMove() {
        GameEngine engine = new GameEngine();

        // Call the method multiple times to ensure randomness
        for (int i = 0; i < 100; i++) {
            String move = engine.generateComputerMove();
            assertTrue(move.equals("rock") || move.equals("paper") || move.equals("scissors"),
                       "Invalid move generated: " + move);
        }
    }
}