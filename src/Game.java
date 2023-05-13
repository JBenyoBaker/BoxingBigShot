import javax.swing.*;
import java.util.ArrayList;

public class Game
{
    // Boxer 1 not punching
    ImageIcon b1 = new ImageIcon("Resources/Boxer1.png");

    // Boxer 1 punching
    ImageIcon b2 = new ImageIcon("Resources/Boxer2.png");

    // Boxer 2 not punching
    ImageIcon b3 = new ImageIcon("Resources/Boxer1L.png");

    // Boxer 2 punching
    ImageIcon b4 = new ImageIcon("Resources/Boxer2L.png");

    // Both boxers
    private Boxer boxer1;
    private Boxer boxer2;

    private Gui graphics;

    // Creates new Gui object and initializes boxers
    public Game()
    {
        graphics = new Gui(this);
        boxer1 = new Boxer(10, 100, 350, b1, b2);
        boxer2 = new Boxer(10, 600, 350, b3, b4);
    }

    /* Starts the program by printing the instructions,
       and repaints when the method is done running.
     */
    public void playGame()
    {
        graphics.paintInstructions(graphics.getGraphics());
        graphics.repaint();
    }

    // Returns Boxer1
    public Boxer getBoxer1()
    {
        return boxer1;
    }

    // Returns Boxer2
    public Boxer getBoxer2()
    {
        return boxer2;
    }


    // Creates a new game and calls play game.
    public static void main(String[] args)
    {
        Game g = new Game();
        g.playGame();
    }
}