import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{
    Pacman pacman = new Pacman();
    Ghost ghost = new Ghost();
    int[] [] map = {{5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 6},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                    {1, 0, 5, 2, 6, 0, 5, 2, 2, 2, 2, 6, 0, 5, 2, 2, 6, 0, 5, 2, 2, 2, 2, 6, 0, 5, 2, 6, 0, 3},
                    {1, 0, 1, 9, 3, 0, 1, 9, 9, 9, 9, 3, 0, 1, 9, 9, 3, 0, 1, 9, 9, 9, 9, 3, 0, 1, 9, 3, 0, 3},
                    {1, 0, 7, 4, 8, 0, 7, 4, 4, 4, 4, 8, 0, 7, 4, 4, 8, 0, 7, 4, 4, 4, 4, 8, 0, 7, 4, 8, 0, 3},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                    {1, 0, 5, 2, 6, 0, 5, 2, 2, 6, 0, 5, 2, 2, 2, 2, 2, 2, 6, 0, 5, 2, 2, 6, 0, 5, 2, 6, 0, 3},
                    {1, 0, 1, 9, 3, 0, 1, 9, 9, 3, 0, 1, 9, 9, 9, 9, 9, 9, 3, 0, 1, 9, 9, 3, 0, 1, 9, 3, 0, 3},
                    {1, 0, 1, 9, 3, 0, 1, 9, 9, 3, 0, 1, 9, 9, 9, 9, 9, 9, 3, 0, 1, 9, 9, 3, 0, 1, 9, 3, 0, 3},
                    {1, 0, 1, 9, 3, 0, 7, 4, 4, 8, 0, 7, 4, 4, 4, 4, 4, 4, 8, 0, 7, 4, 4, 8, 0, 1, 9, 3, 0, 3},
                    {1, 0, 1, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 3, 0, 3},
                    {1, 0, 7, 4, 8, 0, 5, 2, 2, 2, 2, 6, 0, 5, 2, 2, 6, 0, 5, 2, 2, 2, 2, 6, 0, 7, 4, 8, 0, 3},
                    {1, 0, 0, 0, 0, 0, 1, 9, 9, 9, 9, 3, 0, 1, 9, 9, 3, 0, 1, 9, 9, 9, 9, 3, 0, 0, 0, 0, 0, 3},
                    {1, 0, 5, 2, 6, 0, 7, 4, 4, 4, 4, 8, 0, 7, 4, 4, 8, 0, 7, 4, 4, 4, 4, 8, 0, 5, 2, 6, 0, 3},
                    {1, 0, 1, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 3, 0, 3},
                    {1, 0, 1, 9, 3, 0, 5, 2, 2, 6, 0, 5, 2, 2, 2, 2, 2, 2, 6, 0, 5, 2, 2, 6, 0, 1, 9, 3, 0, 3},
                    {1, 0, 1, 9, 3, 0, 1, 9, 9, 3, 0, 1, 9, 9, 9, 9, 9, 9, 3, 0, 1, 9, 9, 3, 0, 1, 9, 3, 0, 3},
                    {1, 0, 1, 9, 3, 0, 1, 9, 9, 3, 0, 1, 9, 9, 9, 9, 9, 9, 3, 0, 1, 9, 9, 3, 0, 1, 9, 3, 0, 3},
                    {1, 0, 7, 4, 8, 0, 7, 4, 4, 8, 0, 7, 4, 4, 4, 4, 4, 4, 8, 0, 7, 4, 4, 8, 0, 7, 4, 8, 0, 3},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                    {1, 0, 5, 2, 6, 0, 5, 2, 2, 2, 2, 6, 0, 5, 2, 2, 6, 0, 5, 2, 2, 2, 2, 6, 0, 5, 2, 6, 0, 3},
                    {1, 0, 1, 9, 3, 0, 1, 9, 9, 9, 9, 3, 0, 1, 9, 9, 3, 0, 1, 9, 9, 9, 9, 3, 0, 1, 9, 3, 0, 3},
                    {1, 0, 7, 4, 8, 0, 7, 4, 4, 4, 4, 8, 0, 7, 4, 4, 8, 0, 7, 4, 4, 4, 4, 8, 0, 7, 4, 8, 0, 3},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                    {7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8}};
    /** 
     * Constructor for objects of class Background.
     * 
     */
    public Background()
    {    
        // Create a new world with 30x25 cells with a cell size of 20x20 pixels.
        super(30, 25, 20); 
        
        for(int row = 0; row < map.length; row++){
            for(int col = 0; col < map[row].length; col++){
                tileAddition(map[row][col], col, row);
            }
        }
        
        addObject(pacman, 15, 14);
        addObject(ghost, 15, 10);
    }
    
    public void tileAddition(int tileNum, int x, int y){
        if(tileNum == 0){
            addObject(new Tile0(), x, y);
            addObject(new Pellet(), x, y);
        }
        if(tileNum == 1){
            addObject(new Tile1(), x, y);
        }
        if(tileNum == 2){
            addObject(new Tile2(), x, y);
        }
        if(tileNum == 3){
            addObject(new Tile3(), x, y);
        }
        if(tileNum == 4){
            addObject(new Tile4(), x, y);
        }
        if(tileNum == 5){
            addObject(new Tile5(), x, y);
        }
        if(tileNum == 6){
            addObject(new Tile6(), x, y);
        }
        if(tileNum == 7){
            addObject(new Tile7(), x, y);
        }
        if(tileNum == 8){
            addObject(new Tile8(), x, y);
        }
        else if(tileNum == 9){
            addObject(new Tile0(), x, y);
        }
    }
    
    public int mapValue(int x, int y){
        return map[y][x];
    }
    
    public void gameOver(){
        removeObject(pacman);
        removeObject(ghost);
        Greenfoot.setWorld(new GameOver());
    }
}
