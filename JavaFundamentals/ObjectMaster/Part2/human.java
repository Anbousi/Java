public class Human{
    private int health = 100;
    private int strength = 3;
    private int stealth = 3;
    private int intelligence = 3;

    public int attack(Human attacked){
        attacked.health -= this.strength;
        return attacked.health;
    }
// Health---------------------------------------
    public int getHealth(){
        return this.health;
    }

    public void setHealth(int health){
        this.health = health;
    }

// Strength---------------------------------------

    public int getStrength(){
        return this.strength;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }

// Stealth---------------------------------------
    public int getStealth(){
        return this.stealth;
    }

    public void setStealth(int stealth){
        this.stealth = stealth;
    }

// Intelligence---------------------------------------

    public int getIntelligence(){
        return this.intelligence;
    }

    public void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }
   
}