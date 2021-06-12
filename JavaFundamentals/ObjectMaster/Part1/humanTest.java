public class HumanTest{
    public static void main(String[] args){
        Human person1 = new Human();
        Human person2 = new Human();
        System.out.println("Health before attack = " + person1.health);
        person2.attack(person1);
        System.out.println("Health after attack = " + person1.health);
    }
}