import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

public class Gui extends JFrame implements KeyListener
{

    private Image background;

    private Image boxer;

    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;

    private Game match;


    public Gui(Game match)
    {
        this.match = match;
        background = new ImageIcon("Resources/download-17.jpg").getImage();
        boxer = new ImageIcon("Resources/Boxer1.png").getImage();

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Big Boxing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setVisible(true);
    }

    public void paint(Graphics g)
    {
        paintBackground(g);
        paintBoxer(g, match.getBoxer1());
        paintBoxer(g, match.getBoxer2());
    }
    public void paintBackground(Graphics g)
    {
        g.drawImage(background, 0, 0, 1000, 800, this);
    }

    public void paintBoxer(Graphics g, Boxer boxer1)
    {
        g.drawImage(boxer1.getCurrentImage().getImage(), boxer1.getX(), boxer1.getY(), 300, 300, this);
    }

    public void keyTyped(KeyEvent e)                // #5 Required for KeyListener
    {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyReleased(KeyEvent e)             // #6 Required for KeyListener
    {
    }

    @Override
    public void keyPressed(KeyEvent e)              // #7 Required for KeyListener
    {
        // The keyCode lets you know which key was pressed
        int keyCode = e.getKeyCode();

        Boxer boxer1 = match.getBoxer1();
        Boxer boxer2 = match.getBoxer2();

        if(keyCode == KeyEvent.VK_W)
        {
            if (boxer2.getX() - boxer1.getX() < 75)
            {
                boxer2.setHealth(boxer2.getHealth() - 1);
            }
            boxer1.setCurrentImage(boxer1.getImages().get(1));
            paintBoxer(this.getGraphics(), boxer1);
            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException exception)
            {
                Thread.currentThread().interrupt();
            }
            boxer1.setCurrentImage(boxer1.getImages().get(0));
        }
        else if (keyCode == KeyEvent.VK_A)
        {
            boxer1.setX(boxer1.getX() -  75);
        }
        else if (keyCode == KeyEvent.VK_D)
        {
            boxer1.setX(boxer1.getX() + 75);
        }
        else if(keyCode == KeyEvent.VK_UP)
        {
            if (boxer2.getX() - boxer1.getX() < 75)
            {
                boxer1.setHealth(boxer1.getHealth() - 1);
            }
            boxer2.setCurrentImage(boxer2.getImages().get(1));
            paintBoxer(this.getGraphics(), boxer2);
            System.out.println("DEF");
            try {
                Thread.sleep(250);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
            boxer2.setCurrentImage(boxer2.getImages().get(0));
        }
        else if (keyCode == KeyEvent.VK_LEFT)
        {
            boxer2.setX(boxer2.getX() -  75);
        }
        else if (keyCode == KeyEvent.VK_RIGHT)
        {
            boxer2.setX(boxer2.getX() + 75);
        }
        System.out.println(boxer1);
        repaint();
    }
}