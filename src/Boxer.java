import javax.swing.*;
import java.util.ArrayList;

public class Boxer
{
    private ArrayList<ImageIcon> images = new ArrayList<>();

    private ImageIcon currentImage;
    private int x;
    private int y;
    private int speed;
    private int health;
    private int power;

    private int wins = 0;

    private int losses = 0;

    private int draws = 0;

    private int currentHealth = health;

    public ImageIcon getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(ImageIcon currentImage) {
        this.currentImage = currentImage;
    }

    public Boxer(int health, int power, int speed, int x, int y, ImageIcon image1, ImageIcon image2)
    {
        this.health = health;
        this.power = power;
        this.speed = speed;
        this.x = x;
        this.y = y;
        images.add(image1);
        images.add(image2);
        currentImage = images.get(0);
    }


    public void incrementWins()
    {
        this.wins += 1;
    }

    public void incrementLosses()
    {
        this.losses += losses;
    }

    public void incrementDraws()
    {
        this.draws += draws;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getX() {
        return x;
    }

    public ArrayList<ImageIcon> getImages() {
        return images;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}