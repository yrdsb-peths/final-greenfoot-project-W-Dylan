import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class which creates Pacman, in which the user will be controlling
 * 
 * @author (Dylan Windsor) 
 * @version (June 15th)
 */
public class Pacman extends SmoothMover
{
    GreenfootImage[] pacman = new GreenfootImage[3];
    SimpleTimer animation = new SimpleTimer();
    SimpleTimer movement = new SimpleTimer();
    static public int movementRate = 500;
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
            Pellet.points++;
            Pellet.finalScore++;
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
        if(Greenfoot.isKeyDown("right") && isWall(coord[0] + 1, coord[1]) && movement.millisElapsed() > movementRate){
            setRotation(0);
            move(1);
            movement.mark();
        }
        else if(Greenfoot.isKeyDown("left") && isWall(coord[0] - 1, coord[1]) && movement.millisElapsed() > movementRate){
            setRotation(180);
            move(1);
            movement.mark();
        }
        else if(Greenfoot.isKeyDown("up") && isWall(coord[0], coord[1] - 1) && movement.millisElapsed() > movementRate){
            setRotation(270);
            move(1);
            movement.mark();
        }
        else if(Greenfoot.isKeyDown("down") && isWall(coord[0], coord[1] + 1) && movement.millisElapsed() > movementRate){
            setRotation(90);
            move(1);
            movement.mark();
        }
    }
}
