import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends SmoothMover
{
    GreenfootImage[] pacman = new GreenfootImage[3];
    SimpleTimer animation = new SimpleTimer();
    SimpleTimer movement = new SimpleTimer();
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
        movement.mark();
    }
    
    public void act()
    {
        animatePacman();
        if(isTouching(Pellet.class)){
            removeTouching(Pellet.class);
        }
        if(movement.millisElapsed() > 0){
            moving();
        }
    }
    
    int animationCount = 1;
    private void animatePacman(){
        if(animation.millisElapsed() > 100){
            setImage(pacman[animationCount % 3]);
            animationCount++;
            animation.mark();
        }
    }
    
    private boolean isWall(int x, int y){
        Background world = (Background) getWorld();
        return world.mapValue(x, y) == 0;
    }
    
    private int[] getCoord(){
        int[] coord = {this.getX(), this.getY()};
        return coord;
    }
    
    private void moving(){
        int[] coord = getCoord();
        if(Greenfoot.isKeyDown("right") && isWall(coord[0] + 1, coord[1])){
            setRotation(0);
            move(0.05);
            movement.mark();
        }
        else if(Greenfoot.isKeyDown("left") && isWall(coord[0] - 1, coord[1])){
            setRotation(180);
            move(0.05);
            movement.mark();
        }
        else if(Greenfoot.isKeyDown("up") && isWall(coord[0], coord[1] - 1)){
            setRotation(270);
            move(0.05);
            movement.mark();
        }
        else if(Greenfoot.isKeyDown("down") && isWall(coord[0], coord[1] + 1)){
            setRotation(90);
            move(0.05);
            movement.mark();
        }
    }
}
