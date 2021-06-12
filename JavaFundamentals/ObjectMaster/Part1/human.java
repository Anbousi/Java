public class Human{
    public int health = 100;
    public int strength = 3;
    public int stealth = 3;
    public int intelligence = 3;

    public int attack(Human attacked){
        attacked.health -= this.strength;
        return attacked.health;
    }
}