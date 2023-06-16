import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io. *;

/**
 * Write a description of class Ghost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends SmoothMover
{
    GreenfootImage[] ghost = new GreenfootImage[2];
    String facing;
    SimpleTimer moveTimer = new SimpleTimer();
    static public int spawnRate = 3000;
    static public int maxGhost = 20;
    static public int speed = 100;
    static public int ghostNum = 0;
    
    /**
     * Act - do whatever the Ghost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moving();
        if(this.isTouching(Pacman.class)){
            Background world = (Background) getWorld();
            world.gameOver();
        }
    }
    
    public Ghost(){
        for(int i = 0; i < ghost.length; i++){
            ghost[i] = new GreenfootImage("ghostImages/ghostBody" + i + ".png");
        }
        setImage(ghost[0]);
        ghostNum++;
        facing = "right";
        moveTimer.mark();
    }
    
    boolean haveMoved = false;
    private void moving(){
        int[] coord = getCoord();
        if(haveMoved){
            if(intersection(coord)){
                String[] availableDirection = intersectionType(coord);
                int rando = Greenfoot.getRandomNumber(availableDirection.length);
                facing = availableDirection[rando];
            }
            haveMoved = false;
        }
        
        if(facing.equals("right") && moveTimer.millisElapsed() > speed){
            setRotation(0);
            move(1);
            moveTimer.mark();
            haveMoved = true;
        }
        else if(facing.equals("left") && moveTimer.millisElapsed() > speed){
            setRotation(180);
            move(1);
            moveTimer.mark();
            haveMoved = true;
        }
        else if(facing.equals("up") && moveTimer.millisElapsed() > speed){
            setRotation(270);
            move(1);
            moveTimer.mark();
            haveMoved = true;
        }
        else if(facing.equals("down") && moveTimer.millisElapsed() > speed){
            setRotation(90);
            move(1);
            moveTimer.mark();
            haveMoved = true;
        }
    }
    
    private int[] getCoord(){
        int[] coord = {this.getX(), this.getY()};
        return coord;
    }

    private boolean intersection(int[] coords){
        if(facing.equals("right") || facing.equals("left")){
            if(tileType(coords[0], coords[1] + 1) == 0 || tileType(coords[0], coords[1] - 1) == 0){
                return true;
            }
            return false;
        }
        else{
            if(tileType(coords[0] + 1, coords[1]) == 0 || tileType(coords[0] - 1, coords[1]) == 0){
                return true;
            }
            return false;
        }
    }
    
    private int tileType(int x, int y){
        Background world = (Background) getWorld();
        return world.mapValue(x, y);
    }
    
    private String[] intersectionType(int[] coords){
        String[] result = new String[0];
        System.out.println("||||");
        if(tileType(coords[0] + 1, coords[1]) == 0 && !facing.equals("left")){
            result = biggerStringArray(result);
            System.out.println(facing);
            result[result.length - 1] = "right";
        }
        if(tileType(coords[0] - 1, coords[1]) == 0 && !facing.equals("right")){
            result = biggerStringArray(result);
            System.out.println(facing);
            result[result.length - 1] = "left";
        }
        if(tileType(coords[0], coords[1] + 1) == 0 && !facing.equals("up")){
            result = biggerStringArray(result);
            System.out.println(facing);
            result[result.length - 1] = "down";
        }
        if(tileType(coords[0], coords[1] - 1) == 0 && !facing.equals("down")){
            result = biggerStringArray(result);
            System.out.println(facing);
            result[result.length - 1] = "up";
        }
        System.out.println("|||");
        for(int i = 0; i < result.length; i++){ 
            System.out.println(result[i]);
        }
        return result;
    }
    
    public String[] biggerStringArray(String[] arr){
        String[] result = new String[arr.length + 1];
        for(int i = 0; i < arr.length; i++){
            result[i] = arr[i];
        }
        return result;
    }
}
