import java.util.Random;

public class Player{
    private boolean alive;
    private String name;
    private int health;
    private Weapon weapon;

    public Player(String name){
        this.name = name;
        health = 100;
        weapon = new Weapon();
        alive = true;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public boolean getStatus(){
        return alive;
    }

    //one in four chance player doesnt heal
    public void heal(){
        if(randNumGen(4) == 3)
            System.out.println(name + " dropped healing syringe. Unable to heal!");
        else{
            health+=15;
            if(health > 100)
                health = 100;
        }
    }

    //one in four chance a player dodges attack
    public void takeDamage(int damage){
        if(randNumGen(4) == 3)
            System.out.println(name + " dodged!");
        else{
            System.out.println(name + " was hit!");
            health -= damage;
            if(health < 0) {
                health = 0;
                alive = false;
            }
        }
    }

    @Override
    public String toString(){
        String details = "Health: " + health + " || Weapon: " + weapon.getName()+ " does " +  weapon.getDamage() + " damage ";
        return details;
    }

    public static int randNumGen(int bound){
        Random random = new Random();
        int randomNum = random.nextInt(bound);
        return randomNum;
    }


}


