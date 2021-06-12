public class Ninja extends Human{
    private int stealth = 10;
    
    public void steal(Human attacked){
        attacked.setHealth(attacked.getHealth()-this.stealth) ;
        this.setHealth(this.getHealth()+ this.stealth) ;
    }

    public void runAway(){
        this.setHealth(this.getHealth() - 10);
    }
}