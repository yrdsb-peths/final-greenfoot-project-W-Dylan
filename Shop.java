import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop extends World
{
    Label introduction = new Label("Welcome to the Shop", 50);
    Label maxGhosts = new Label("Reduce max # of ghosts (50)", 20);
    Label spawnRate = new Label("Reduce ghost spawn rate (10)", 20);
    Label ghostSpeed = new Label("Reduce ghost speed (25)", 20);
    Label pacSpeed = new Label("Increase your speed (30)", 20);
    Label pelletWorth = new Label("Increase pellet worth (100)", 20);
    Label maxGhostKey = new Label("Press m to buy", 17);
    Label spawnRateKey = new Label("Press r to buy", 17);
    Label ghostSpeedKey = new Label("Press g to buy", 17);
    Label pacSpeedKey= new Label("Press s to buy", 17);
    Label pelletWorthKey = new Label("Press p to buy", 17);
    Label cannotBuy = new Label("Cannot buy item", 50);
    
    /**
     * Constructor for objects of class Shop.
     * 
     */
    public Shop()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(30, 25, 20); 
        introduction.setFillColor(Color.BLACK);
        addObject(introduction, 15, 3);
        addObject(maxGhosts, 7, 7);
        addObject(spawnRate, 7, 12);
        addObject(ghostSpeed, 7, 17);
        addObject(pacSpeed, 22, 7);
        addObject(pelletWorth, 22, 12);
        addObject(maxGhostKey, 7, 9);
        addObject(spawnRateKey, 7, 14);
        addObject(ghostSpeedKey, 7, 19);
        addObject(pacSpeedKey, 22, 9);
        addObject(pelletWorthKey, 22, 14);
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("m") && Pellet.points >= 50){
            removeObject(cannotBuy);
            Ghost.maxGhost -= 2;
            Pellet.points -= 50;
        }
        else if(Greenfoot.isKeyDown("m") && Pellet.points < 50){
            cannotBuy.setFillColor(Color.RED);
            addObject(cannotBuy,15, 22);
        }
        if(Greenfoot.isKeyDown("r") && Pellet.points >= 10){
            removeObject(cannotBuy);
            Ghost.spawnRate += 1000;
            Pellet.points -= 10;
        }
        else if(Greenfoot.isKeyDown("r") && Pellet.points < 10){
            cannotBuy.setFillColor(Color.RED);
            addObject(cannotBuy,15, 22);
        }
        if(Greenfoot.isKeyDown("g") && Pellet.points >= 25){
            removeObject(cannotBuy);
            Ghost.speed += 50;
            Pellet.points -= 25;
        }
        else if(Greenfoot.isKeyDown("g") && Pellet.points < 25){
            cannotBuy.setFillColor(Color.RED);
            addObject(cannotBuy,15, 22);
        }
        if(Greenfoot.isKeyDown("s") && Pellet.points >= 30){
            removeObject(cannotBuy);
            Pacman.movementRate += 0.05;
            Pellet.points -= 30;
        }
        else if(Greenfoot.isKeyDown("s") && Pellet.points < 30){
            cannotBuy.setFillColor(Color.RED);
            addObject(cannotBuy,15, 22);
        }
        if(Greenfoot.isKeyDown("p") && Pellet.points >= 100){
            removeObject(cannotBuy);
            Pellet.pelletPoint -= 2;
            Pellet.points -= 100;
        }
        else if(Greenfoot.isKeyDown("p") && Pellet.points < 100){
            cannotBuy.setFillColor(Color.RED);
            addObject(cannotBuy,15, 22);
        }
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new Background());
        }
    }
}
