import java.util.Random;
public class Weapon {
    public enum weaponType{SWORD, AXE, SPEAR, JAVELIN, GUN, STONE}
    private weaponType weapon;
    private String name;
    private int damage;
    private int health;

    public String getName(){
        return name;
    }

    public int getDamage(){
        return damage;
    }

    public Weapon(){
        setWeapon();
    }

    public int getHealth(){
        return health;
    }

    public void minusHealth(){
        health-=1;
    }

    public void setWeapon(){
        int randomNum = Player.randNumGen(weaponType.values().length * 2);
        if(randomNum <= 1){
            weapon = weaponType.SWORD;
            name = "sword";
            damage = 10;
        }
        else if(randomNum <= 3){
            weapon = weaponType.AXE;
            name = "axe";
            damage = 20;
        }
        else if(randomNum <= 5){
            weapon = weaponType.SPEAR;
            name = "spear";
            damage = 15;
        }
        else if(randomNum <= 7){
            weapon = weaponType.JAVELIN;
            name = "javelin";
            damage = 25;
        }
        else if(randomNum == 8){
            weapon = weaponType.GUN;
            name = "gun";
            damage = 30;
        }
        else if(randomNum <= 11){
            weapon = weaponType.STONE;
            name = "stone";
            damage = 3;
        }
        else
            System.out.println("Error");

        health = 4;
    }
}
