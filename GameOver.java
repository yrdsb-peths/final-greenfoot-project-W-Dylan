import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Screen for the end of the game
 * 
 * @author (Dylan Windsor) 
 * @version (June 15th 2023)
 */
public class GameOver extends World
{
    GreenfootImage blank = new GreenfootImage("Wall.jpg");
    Label gameOver = new Label("Game Over", 50);
    Label score = new Label("Score: " + Pellet.finalScore, 40);
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(30, 25, 20); 
        blank.scale(600, 500);
        setBackground(blank);
        addObject(gameOver, 15, 12);
        addObject(score, 15, 14);
    }
}
