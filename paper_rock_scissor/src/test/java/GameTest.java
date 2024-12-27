import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import game.example.Game;

public class GameTest {
    @Test
    void testFirstGameChoice() {
        Game game = new Game();
        // Redirect System.out to capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Simulate human player input
        String simulatedInput = "1\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Run the Player vs Computer game
        game.start();

        // Restore original System.out and System.in
        System.setOut(originalOut);
        System.setIn(originalIn);

        // Get the captured output
        String output = outputStream.toString();

        // Validate the output contains expected messages
        assertTrue(output.contains("Welcome to Rock, Paper, Scissors!"));
        assertTrue(output.contains("Choose a mode:"));
        assertTrue(output.contains("1. Player vs Computer"));
        assertTrue(output.contains("2. Computer vs Computer"));
        assertTrue(output.contains("Enter your choice (rock, paper, scissors):"));
    }
}
