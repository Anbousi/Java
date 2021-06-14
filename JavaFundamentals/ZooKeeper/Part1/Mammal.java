public class Mammal{
    private int energy = 100;

    public int displayEnergy(){
        System.out.println("Energy Level: " + this.energy);
        return this.energy;
    }

    public int getEnergy(){
        return this.energy;
    }
    public void setEnergy(int E){
        this.energy = E;
    }

    
    
}