import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class Gui extends JFrame implements KeyListener
{

    // Boxing ring pixel art image
    private Image background;

    // Dimensions of the window
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;

    private Game match;


    /* Constructor, takes in a game from the game class,
       initializes the instance variables,
       and it opens a new window.
     */
    public Gui(Game match)
    {
        // Initialize instance variables
        this.match = match;
        background = new ImageIcon("Resources/BoxingRing.png").getImage();

        // Opens a new window Titled "Big Boxing."
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Big Boxing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setVisible(true);
    }

    /* Paints the initial screen with instructions,
     waits for a KeyBoard input, and waits for a certain amount of time,
     or for a keyboard input to start the fight.
     */
    public void paintInstructions (Graphics g)
    {
        // Colors the background white, and puts the pixel art text over it
        g.setColor(Color.WHITE);
        g.fillRect(0,0,1000,800);
        g.drawImage(new ImageIcon("Resources/pixil-frame-0 (1).png").getImage(), 0, 0, 1000, 800, this);

        /* Adds a time delay which will give the player plenty of time to
         read the instructions but will auto-start the game after a while.
         */
        try
        {
            Thread.sleep(50000000);
        }
        catch (InterruptedException exception)
        {
            Thread.currentThread().interrupt();
        }
    }

    // Paints the ring, boxers, and health.
    public void paint(Graphics g)
    {
        paintBackground(g);
        if (match.getBoxer1() != null && match.getBoxer2() != null)
        {
            paintBoxer(g, match.getBoxer1());
            paintBoxer(g, match.getBoxer2());
            paintHealth(g, match.getBoxer1(), match.getBoxer2());
        }
    }

    // Fills the screen white and then paints the boxing ring over it.
    public void paintBackground(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0,0,1000, 800);
        g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
    }

    // Draws a boxer in their current state (punching or not punching), at their respective x and y coordinates.
    public void paintBoxer(Graphics g, Boxer boxer1)
    {
        g.drawImage(boxer1.getCurrentImage().getImage(), boxer1.getX(), boxer1.getY(), 300, 300, this);
    }

    // Paints each of the Boxers health bars.
    public void paintHealth(Graphics g, Boxer boxer1, Boxer boxer2)
    {
        g.setColor(Color.RED);
        g.fillRect(100, 100, 200, 20);
        g.fillRect(700, 100, 200, 20);
        g.setColor(Color.GREEN);
        g.fillRect(100, 100, 20 * boxer1.getHealth(), 20);
        g.fillRect(700, 100, 20 * boxer2.getHealth(), 20);
    }

    /* Paints the win screen, first by filling the screen white,
       and then by painting a larger version of the boxer that won.
       It also closes the game after five seconds if the user does not.
     */
    public void paintWinner(Graphics g, Boxer winner)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,1000, 800);
        // Draws the pixelart text which says "Winner!"
        g.drawImage(new ImageIcon("Resources/Winner!.png").getImage(), 0,100, 1000, 800, this);
        // Draws a large version of the boxer that won.
        g.drawImage(winner.getImages().get(0).getImage(), 250, 150, 500, 500, this);
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException exception)
        {
            Thread.currentThread().interrupt();
        }
        System.exit(0);
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

    // Receives and processes all user key input.
    @Override
    public void keyPressed(KeyEvent e)              // #7 Required for KeyListener
    {
        // The keyCode lets you know which key was pressed
        int keyCode = e.getKeyCode();

        //takes in both boxer objects
        Boxer boxer1 = match.getBoxer1();
        Boxer boxer2 = match.getBoxer2();

        // If W is pressed make boxer 1 punch and do damage to boxer 2 if he's close enough
        if(keyCode == KeyEvent.VK_W)
        {
            if (boxer2.getX() - boxer1.getX() < 150 && boxer2.getX() - boxer1.getX() > 0)
            {
                boxer2.setHealth(boxer2.getHealth() - 1);
                boxer2.setX(boxer2.getX() + 75);
            }
            // Changes the Boxer's image to the one of him punching.
            boxer1.setCurrentImage(boxer1.getImages().get(1));
            paintBoxer(this.getGraphics(), boxer1);
            // Sleeps so that the user can see the punching image.
            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException exception)
            {
                Thread.currentThread().interrupt();
            }

            // Changes the Boxer's image to the one of him not punching and repaints.
            boxer1.setCurrentImage(boxer1.getImages().get(0));
            repaint();
            // Determines if Boxer 1 has won.
            if(boxer2.getHealth() <= 0)
            {
                this.paintWinner(this.getGraphics(), boxer1);
            }
            return;
        }

        // Moves boxer 1 left, and repaints
        else if (keyCode == KeyEvent.VK_A)
        {
            boxer1.setX(boxer1.getX() -  75);
            repaint();
        }
        // Moves boxer 1 right, and repaints
        else if (keyCode == KeyEvent.VK_D)
        {
            boxer1.setX(boxer1.getX() + 75);
            repaint();
        }

        // If the up Arrow is pressed make boxer 2 punch and do damage to boxer 1 if he's close enough
        else if(keyCode == KeyEvent.VK_UP)
        {
            if (boxer2.getX() - boxer1.getX() < 150 && boxer2.getX() - boxer1.getX() > 0)
            {
                boxer1.setHealth(boxer1.getHealth() - 1);
                boxer1.setX(boxer1.getX() - 75);
            }
            // Changes the Boxer's image to the one of him punching.
            boxer2.setCurrentImage(boxer2.getImages().get(1));
            paintBoxer(this.getGraphics(), boxer2);
            // Sleeps so that the user can see the punching image.
            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException exception)
            {
                Thread.currentThread().interrupt();
            }
            // Changes the Boxer's image to the one of him not punching and repaints.
            boxer2.setCurrentImage(boxer2.getImages().get(0));
            repaint();
            // Determines if Boxer 2 has won.
            if(boxer1.getHealth() <= 0)
            {
                this.paintWinner(this.getGraphics(), boxer2);
            }
            return;
        }

        // Moves boxer 2 left, and repaints
        else if (keyCode == KeyEvent.VK_LEFT)
        {
            boxer2.setX(boxer2.getX() -  75);
            repaint();
        }
        // Moves boxer 2 right, and repaints
        else if (keyCode == KeyEvent.VK_RIGHT)
        {
            boxer2.setX(boxer2.getX() + 75);
            repaint();
        }
        // Used on the initial screen to go start the boxing match by calling repaint.
        else if (keyCode == KeyEvent.VK_SPACE)
        {
            repaint();
        }
    }
}