import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    GreenfootImage[] pacman = new GreenfootImage[3];
    SimpleTimer animation = new SimpleTimer();
    /**
     * Act - do whatever the Pacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Pacman(){
        for(int i = 0; i < pacman.length; i++){
            pacman[i] = new GreenfootImage("pacmanEat/eat" + (i + 1) + ".png");
        }
        setImage(pacman[0]);
        animation.mark();
    }
    
    public void act()
    {
        animatePacman();
    }
    
    int animationCount = 1;
    public void animatePacman(){
        if(animation.millisElapsed() > 100){
            setImage(pacman[animationCount % 3]);
            animationCount++;
            animation.mark();
        }
    }
}