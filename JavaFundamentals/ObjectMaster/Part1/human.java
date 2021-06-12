public class human{
    public int health = 100;
    public int strength = 3;
    public int stealth = 3;
    public int intelligence = 3;

    public int attack(){
        this.health -= this.strength;
        return this.health;
    }
}