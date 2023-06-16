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
    
    Label maxGhostsInfo = new Label("Max number of Ghosts: " + Ghost.maxGhost, 16);
    Label spawnRateInfo = new Label("Ghost Spawn Rate: " + Ghost.spawnRate / 1000 + " secs", 16);
    Label ghostSpeedInfo = new Label("Ghost Speed: 1 cell/" + Ghost.speed / 1000.00 + " secs", 16);
    Label pacSpeedInfo = new Label("Pacman Speed: 1 cell/" + Pacman.movementRate / 1000.00 + " secs", 16);
    Label pelletWorthInfo = new Label("Pellet Worth: " + Pellet.pelletPoint + " points", 16);
    Label totalPoints = new Label("Total Points: " + Pellet.points + " points", 16);
    
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
    
    SimpleTimer waitBuy = new SimpleTimer();
    
    /**
     * Constructor for objects of class Shop.
     * 
     */
    public Shop()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(40, 25, 20); 
        introduction.setFillColor(Color.BLACK);
        
        addObject(introduction, 14, 3);
        
        addObject(maxGhostsInfo, 34, 2);
        addObject(spawnRateInfo, 34, 4);
        addObject(ghostSpeedInfo, 34, 6);
        addObject(pacSpeedInfo, 34, 8);
        addObject(pelletWorthInfo, 34, 10);
        addObject(totalPoints, 34, 12);
        
        addObject(maxGhosts, 6, 7);
        addObject(spawnRate, 6, 12);
        addObject(ghostSpeed, 6, 17);
        addObject(pacSpeed, 21, 7);
        addObject(pelletWorth, 21, 12);
        
        addObject(maxGhostKey, 6, 9);
        addObject(spawnRateKey, 6, 14);
        addObject(ghostSpeedKey, 6, 19);
        addObject(pacSpeedKey, 21, 9);
        addObject(pelletWorthKey, 21, 14);
        waitBuy.mark();
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("m") && Pellet.points >= 50 && waitBuy.millisElapsed() < 1000){
            removeObject(cannotBuy);
            Ghost.maxGhost -= 2;
            Pellet.points -= 50;
            waitBuy.mark();
            removeObject(maxGhostsInfo);
            maxGhostsInfo = new Label("Max number of Ghosts: " + Ghost.maxGhost, 16);
            addObject(maxGhostsInfo, 34, 2);
            removeObject(totalPoints);
            totalPoints = new Label("Total Points: " + Pellet.points + " points", 16);
            addObject(totalPoints, 34, 12);
        }
        else if(Greenfoot.isKeyDown("m") && Pellet.points < 50 && waitBuy.millisElapsed() > 1000){
            cannotBuy.setFillColor(Color.RED);
            addObject(cannotBuy,15, 22);
            waitBuy.mark();
        }
        if(Greenfoot.isKeyDown("r") && Pellet.points >= 10 && waitBuy.millisElapsed() > 1000){
            removeObject(cannotBuy);
            Ghost.spawnRate += 1000;
            Pellet.points -= 10;
            waitBuy.mark();
            removeObject(spawnRateInfo);
            spawnRateInfo = new Label("Ghost Spawn Rate: " + Ghost.spawnRate / 1000 + " secs", 16);
            addObject(spawnRateInfo, 34, 4);
            removeObject(totalPoints);
            totalPoints = new Label("Total Points: " + Pellet.points + " points", 16);
            addObject(totalPoints, 34, 12);
        }
        else if(Greenfoot.isKeyDown("r") && Pellet.points < 10 && waitBuy.millisElapsed() > 1000){
            cannotBuy.setFillColor(Color.RED);
            addObject(cannotBuy,15, 22);
            waitBuy.mark();
        }
        if(Greenfoot.isKeyDown("g") && Pellet.points >= 25 && waitBuy.millisElapsed() > 1000){
            removeObject(cannotBuy);
            Ghost.speed += 20;
            Pellet.points -= 25;
            waitBuy.mark();
            removeObject(ghostSpeedInfo);
            ghostSpeedInfo = new Label("Ghost Speed: 1 cell/" + Ghost.speed / 1000.00 + " secs", 16);
            addObject(ghostSpeedInfo, 34, 6);
            removeObject(totalPoints);
            totalPoints = new Label("Total Points: " + Pellet.points + " points", 16);
            addObject(totalPoints, 34, 12);
        }
        else if(Greenfoot.isKeyDown("g") && Pellet.points < 25 && waitBuy.millisElapsed() > 1000){
            cannotBuy.setFillColor(Color.RED);
            addObject(cannotBuy,15, 22);
            waitBuy.mark();
        }
        if(Greenfoot.isKeyDown("s") && Pellet.points >= 30 && waitBuy.millisElapsed() > 1000){
            removeObject(cannotBuy);
            Pacman.movementRate *= 0.9;
            Pellet.points -= 30;
            waitBuy.mark();
            removeObject(pacSpeedInfo);
            Label pacSpeedInfo = new Label("Pacman Speed: 1 cell/" + Pacman.movementRate / 1000.00 + " secs", 16);
            addObject(pacSpeedInfo, 34, 8);
            removeObject(totalPoints);
            totalPoints = new Label("Total Points: " + Pellet.points + " points", 16);
            addObject(totalPoints, 34, 12);
        }
        else if(Greenfoot.isKeyDown("s") && Pellet.points < 30 && waitBuy.millisElapsed() > 1000){
            cannotBuy.setFillColor(Color.RED);
            addObject(cannotBuy,15, 22);
            waitBuy.mark();
        }
        if(Greenfoot.isKeyDown("p") && Pellet.points >= 100 && waitBuy.millisElapsed() > 1000){
            removeObject(cannotBuy);
            Pellet.pelletPoint -= 2;
            Pellet.points -= 100;
            waitBuy.mark();
            removeObject(pelletWorthInfo);
            Label pelletWorthInfo = new Label("Pellet Worth: " + Pellet.pelletPoint + " points", 16);
            addObject(pelletWorthInfo, 34, 10);
            removeObject(totalPoints);
            totalPoints = new Label("Total Points: " + Pellet.points + " points", 16);
            addObject(totalPoints, 34, 12);
        }
        else if(Greenfoot.isKeyDown("p") && Pellet.points < 100 && waitBuy.millisElapsed() > 1000){
            cannotBuy.setFillColor(Color.RED);
            addObject(cannotBuy,15, 22);
            waitBuy.mark();
        }
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new Background());
        }
    }
}
