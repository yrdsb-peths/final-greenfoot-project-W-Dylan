import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new Background());
        }
    }
}
