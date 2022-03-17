import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    private static final int OFFSET = 10;
    private static final int MAX_COUNTER_MOUTH = 10; //entre más grande el numero más lento se mueve la boca
    private static final int MAX_COUNTER_MOVEMENT = 4; //entre mas chico el numero, mas rapido se mueve

    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;

    private GreenfootImage []images;
    private int currentImage;
    private int counterMouth;
    private int counterMovement;
    private int offsetX = 0;
    private int offsetY = 0;
    private int direction;
    private int score;
    private PacmanHud pacmanHud;

    //Constructor
    public Pacman(PacmanHud pacmanHud)
    {
        images = new GreenfootImage[2];
        images[0] = new GreenfootImage("images/pacman-closeGood.png");
        images[1] = new GreenfootImage("images/pacman-openGood.png");
        this.pacmanHud = pacmanHud;
    }

    public void act()
    {

        openCloseMouth();

        movePacman();

        checkColissions();//ve si choca con algun objeto

        //getWorld().showText(String.valueOf(score), 400, 30); //ctrl + espacio para menu de funciones, String.valueOf(score) convierte el score a string

    }

    private void checkColissions(){
        Item item = (Item)getOneIntersectingObject(Item.class); //si choca con un objeto

        if(item!=null){//si choca
            getWorld().removeObject(item);//le quita al mundo el actor,
            score += item.getScore(); //cada item tiene su score, el getScore es un método del Item,
            pacmanHud.setScore(score);
            
            if(getWorld().getObjects(Item.class).isEmpty()){
                offsetX = 0;
                offsetY = 0;
                getWorld().showText("YOU WIN!", 350, 250);
            }
        }

        //Lo anterior es el resumen de:
        /*Actor actor = getOneIntersectingObject(Banana.class); //si choca con una banana

        if(actor!=null){//si choca
        getWorld().removeObject(actor);//le quita al mundo el actor,
        score += 40;
        }

        actor = getOneIntersectingObject(Orange.class); 

        if(actor!=null){//si choca
        getWorld().removeObject(actor);//le quita al mundo el actor, 
        score += 30;
        }

        actor = getOneIntersectingObject(Cherry.class); //si choca con una banana

        if(actor!=null){//si choca
        getWorld().removeObject(actor);//le quita al mundo el actor, en este caso la banana
        score += 20;
        }

        actor = getOneIntersectingObject(SmallBall.class); 

        if(actor!=null){//si choca
        getWorld().removeObject(actor);//le quita al mundo el actor,
        score += 5;
        }

        actor = getOneIntersectingObject(BigBall.class);

        if(actor!=null){//si choca
        getWorld().removeObject(actor);//le quita al mundo el actor,
        score += 10;
        }*/
    }

    private void openCloseMouth(){
        counterMouth++;

        if(counterMouth == MAX_COUNTER_MOUTH){ //hace que la boca no se mueva tan rápido
            counterMouth = 0;
            setImage(images[currentImage]);//setea la imagen
            currentImage = (currentImage + 1) % images.length; //para que vaya de 1 y 0, o sea que abra y cierre
        }
    }

    private void movePacman(){
        counterMovement++;

        if(counterMovement < MAX_COUNTER_MOVEMENT){
            return;
        }

        int currentX = getX();
        int currentY = getY();

        counterMovement = 0;

        handleDirection();//Movimiento

        Actor wall = getWallOnTheWay(); //Encontrar muros en el camino

        if(wall == null){ //si no hya nada con que chocar se va a mover
            setLocation(currentX + offsetX, currentY + offsetY);
        }

    }
    private void handleDirection()
    {
        if(Greenfoot.isKeyDown("UP")){ //aqui no se necesita crear un objeto ya que el método es global (static)
            offsetX = 0;
            offsetY = -OFFSET;
            direction = UP;
        }else if(Greenfoot.isKeyDown("DOWN")){
            offsetX = 0;
            offsetY = OFFSET;
            direction = DOWN;
        }else if(Greenfoot.isKeyDown("RIGHT")){ //aqui no se necesita crear un objeto ya que el método es global (static)
            offsetY = 0;
            offsetX = OFFSET;
            direction = RIGHT;
        }else if(Greenfoot.isKeyDown("LEFT")){
            offsetY = 0;
            offsetX = -OFFSET;
            direction = LEFT;
        }
    }

    private Wall getWallOnTheWay(){

        switch(direction){
            case UP:
                return (Wall)getOneObjectAtOffset(0,-30,Wall.class);//Para saber si está chocando, este método ya es parte de la clase Actor
            case DOWN:
                return (Wall)getOneObjectAtOffset(0,30,Wall.class);//Para saber si está chocando, este método ya es parte de la clase Actor
            case RIGHT:
                return (Wall)getOneObjectAtOffset(30,0,Wall.class);//Para saber si está chocando, este método ya es parte de la clase Actor
            case LEFT:
                return (Wall)getOneObjectAtOffset(-30,0,Wall.class);//Para saber si está chocando, este método ya es parte de la clase Actor
        }
        return null;
    }
}
