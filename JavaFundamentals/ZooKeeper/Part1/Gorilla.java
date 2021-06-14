public class Gorilla extends Mammal{


    public void throwSomething() {
        System.out.println("Wissssh throw things at people");
        this.setEnergy(this.getEnergy()-5);
    }

    public void eatBananas(){
        System.out.println("Eating an Banana");
        this.setEnergy(this.getEnergy()+10);
    }

    public void climb(){
        System.out.println("Climbing");
        this.setEnergy(this.getEnergy()-10);
    }
}