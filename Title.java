import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Titlescreen for the game
 * 
 * @author (Dylan Windsor) 
 * @version (June 15th 2023)
 */
public class Title extends World
{
    GreenfootImage blank = new GreenfootImage("Wall.jpg");
    Label gameName = new Label("Pacman 2.0", 50);
    Label instructions = new Label("Press Enter to Start", 50);
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public Title()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(30, 25, 20); 
        blank.scale(600, 500);
        setBackground(blank);
        addObject(gameName, 15, 11);
        addObject(instructions, 15, 13);
        
        Ghost.spawnRate = 3000;
        Ghost.maxGhost = 20;
        Ghost.speed = 100;
        Pellet.points = 0;
        Pellet.pelletPoint = 1;
        Pacman.movementRate = 500;
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new Background());
        }
    }
}
