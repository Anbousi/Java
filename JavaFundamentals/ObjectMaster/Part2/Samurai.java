public class Samurai extends Human{
    static int count = 0;
    public Samurai(){
        count++;
    }

    private int health = 200;

    public void deathBlow(Human attacked){
        this.setHealth(this.getHealth()/2);
        attacked.setHealth(0);
    }

    public void meditate(){
        this.setHealth((this.getHealth()/2) + this.getHealth());
    }

    public static int howMany(){
        return count;
    }
}