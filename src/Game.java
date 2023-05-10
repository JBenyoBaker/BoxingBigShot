import javax.swing.*;
import java.util.ArrayList;

public class Game
{
    ImageIcon b1 = new ImageIcon("Resources/Boxer1.png");
    ImageIcon b2 = new ImageIcon("Resources/Boxer2.png");

    ImageIcon b3 = new ImageIcon("Resources/Boxer1L.png");

    ImageIcon b4 = new ImageIcon("Resources/Boxer2L.png");
    private Boxer boxer1 = new Boxer(10, 10, 10, 100, 350, b1, b2);
    private Boxer boxer2 = new Boxer(10,10,10, 600, 350, b3, b4);

    private Gui graphics;
    public Game()
    {
        graphics = new Gui(this);
    }

    public void playGame()
    {
        graphics.repaint();
    }

    public Boxer getBoxer1()
    {
        return boxer1;
    }

    public Boxer getBoxer2()
    {
        return boxer2;
    }


    public static void main(String[] args)
    {
        Game g = new Game();
        g.playGame();
    }
}