public class Wizard extends Human{
    private int health = 50;
    private int intelligence = 8;

    public void heal(Human healed){
        healed.setHealth(healed.getHealth() + this.intelligence);
        // return healed.health;
    }

    public void fireball(Human attacked){
        attacked.setHealth(attacked.getHealth() - (this.intelligence*3));
        // return attacked.health;
    }
    
}
