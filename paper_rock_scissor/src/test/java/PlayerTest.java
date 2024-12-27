import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import game.example.GameEngine;
import game.example.Player;

public class PlayerTest {
    @Test
    public void testComputerPlayerMove() {
        Player player1 = new Player("Test1", true);
        GameEngine engine =  new GameEngine();
        
        assertTrue(player1.makeMove(engine).equals("rock") || player1.makeMove(engine).equals("scissor") || player1.makeMove(engine).equals("paper"));
    }

    @Test
    public void testHumanPlayerRockMove() {
        Player player1 = new Player("Test1", false);
        GameEngine engine =  new GameEngine();

        String simulatedInput = "rock\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        String move = player1.makeMove(engine);
        System.setIn(originalIn);
        
        assertEquals("rock", move);
    }

    @Test
    public void testHumanPlayerPaperMove() {
        Player player1 = new Player("Test1", false);
        GameEngine engine =  new GameEngine();

        String simulatedInput = "paper\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        String move = player1.makeMove(engine);
        System.setIn(originalIn);
        
        assertEquals("paper", move);
    }

    @Test
    public void testHumanPlayerScissorMove() {
        Player player1 = new Player("Test1", false);
        GameEngine engine =  new GameEngine();

        String simulatedInput = "scissor\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        String move = player1.makeMove(engine);
        System.setIn(originalIn);
        
        assertEquals("scissor", move);
    }
}
