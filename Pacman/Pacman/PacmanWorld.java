import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacmanWorld extends World
{
    private static final int WIDTH_WALL = 28;
    private static final int HEIGHT_WALL = 28;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public PacmanWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Wall wall = new Wall();
        //int widthWall = wall.getImage().getWidth();

        for(int x = 50; x < 550; x+=WIDTH_WALL) //muros horizontales
        {
            wall = new Wall();
            addObject(wall,x,30);//
            wall = new Wall();
            addObject(wall,x, 350);//muro de abajo
        }

        int heightWall = wall.getImage().getHeight();
        for(int y = 58; y < 200; y+=HEIGHT_WALL) //muros verticales
        {
            wall = new Wall();
            addObject(wall,50,y);

            wall = new Wall();
            addObject(wall,525,y);
        }

        //Pacman pacman = new Pacman();

        Banana banana = new Banana();
        addObject(banana,115,306);
        SmallBall smallBall = new SmallBall();
        addObject(smallBall,240,177);
        Orange orange = new Orange();
        addObject(orange,270,112);
        Orange orange2 = new Orange();
        addObject(orange2,522,244);
        Cherry cherry = new Cherry();
        addObject(cherry,283,244);
        cherry.setLocation(268,242);
        Cherry cherry2 = new Cherry();
        addObject(cherry2,367,140);
        Cherry cherry3 = new Cherry();
        addObject(cherry3,383,242);
        BigBall bigBall = new BigBall();
        addObject(bigBall,133,161);
        BigBall bigBall2 = new BigBall();
        addObject(bigBall2,333,76);
        BigBall bigBall3 = new BigBall();
        addObject(bigBall3,195,226);
        BigBall bigBall4 = new BigBall();
        addObject(bigBall4,332,197);
        bigBall4.setLocation(340,181);
        SmallBall smallBall2 = new SmallBall();
        addObject(smallBall2,194,99);
        SmallBall smallBall3 = new SmallBall();
        addObject(smallBall3,196,130);
        SmallBall smallBall4 = new SmallBall();
        addObject(smallBall4,205,160);
        SmallBall smallBall5 = new SmallBall();
        addObject(smallBall5,190,194);
        SmallBall smallBall6 = new SmallBall();
        addObject(smallBall6,174,160);
        smallBall3.setLocation(187,132);
        smallBall4.setLocation(230,199);
        SmallBall smallBall7 = new SmallBall();
        addObject(smallBall7,199,279);
        BigBall bigBall5 = new BigBall();
        addObject(bigBall5,62,234);
        SmallBall smallBall8 = new SmallBall();
        addObject(smallBall8,303,295);
        SmallBall smallBall9 = new SmallBall();
        addObject(smallBall9,402,273);
        SmallBall smallBall10 = new SmallBall();
        addObject(smallBall10,301,196);
        SmallBall smallBall11 = new SmallBall();
        addObject(smallBall11,302,142);
        SmallBall smallBall12 = new SmallBall();
        addObject(smallBall12,418,113);
        SmallBall smallBall13 = new SmallBall();
        addObject(smallBall13,413,167);
        SmallBall smallBall14 = new SmallBall();
        addObject(smallBall14,446,211);
        smallBall.setLocation(258,175);
        smallBall.setLocation(260,162);

        Ballon ballon = new Ballon();
        addObject(ballon,379,187);
        cherry3.setLocation(357,246);

        PacmanHud hud = new PacmanHud();
        addObject(hud, 0, 0);

        Pacman pacman = new Pacman(hud);
        addObject(pacman, 110, 90);//110 90 son las coordenadas, añado al pacman hasta el final para que se vea al frente
    }
}
