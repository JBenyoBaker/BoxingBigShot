import javax.swing.*;
import java.util.ArrayList;

public class Boxer
{
    // Contains the boxer's different images
    private ArrayList<ImageIcon> images = new ArrayList<>();

    // Keeps track of which image is the current image to be displayed on the screen
    private ImageIcon currentImage;

    // Keep track of the boxer's position
    private int x;
    private int y;

    // Keeps track of the boxer's health
    private int health;

    /* Constructor. Initializes the health, x, y, images,
       and sets the current image to the non-punching one.
    */
    public Boxer(int health, int x, int y, ImageIcon image1, ImageIcon image2)
    {
        this.health = health;
        this.x = x;
        this.y = y;
        images.add(image1);
        images.add(image2);
        currentImage = images.get(0);
    }

    // Returns the images which is to be painted on the screen
    public ImageIcon getCurrentImage() {
        return currentImage;
    }

    // Sets which image is to be painted on the screen
    public void setCurrentImage(ImageIcon currentImage) {
        this.currentImage = currentImage;
    }

    // Returns the boxers current health
    public int getHealth() {
        return health;
    }

    // Changes the boxers current health
    public void setHealth(int health) {
        this.health = health;
    }

    // Returns the boxer's x
    public int getX() {
        return x;
    }

    // Changes the boxer's x
    public void setX(int x)
    {
        if (x > 0 && x < 775)
        {
            this.x = x;
        }
        else if (x <= 0)
        {
            x = 0;
        }
        else
        {
            x = 775;
        }
    }

    // Returns the boxer's y
    public int getY() {
        return y;
    }

    // Returns the boxers arraylist of images
    public ArrayList<ImageIcon> getImages() {
        return images;
    }
}