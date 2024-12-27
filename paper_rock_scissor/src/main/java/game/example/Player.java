package game.example;

import java.util.Scanner;

public class Player {
    private final String name;
    private final boolean isComputer;

    public Player(String name, boolean isComputer) {
        this.name = name;
        this.isComputer = isComputer;
    }

    public String makeMove(GameEngine engine) {
        if (isComputer) {
            return engine.generateComputerMove();
        } else {
            System.out.println(name + ", enter your move (rock, paper, scissors):");
            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);
            return scanner.next().toLowerCase();
        }
    }
}
