public class HumanTest{
    public static void main(String[] args){
        Human person1 = new Human();
        Human person2 = new Human();

        Ninja Tasneem = new Ninja();
        Wizard Mahmoud = new Wizard();
        Samurai Ibtisal = new Samurai();
        Samurai Diaa = new Samurai();

        System.out.println("Person1 Health before attack = " + person1.getHealth());
        person2.attack(person1);
        System.out.println("Person1 Health after attacked = " + person1.getHealth());

        System.out.println("\n");
        Mahmoud.fireball(person1);
        System.out.println("Person1 Health after attacked by Wizzard = " + person1.getHealth());
        System.out.println("\n");

        Tasneem.steal(Mahmoud);
        System.out.println("Mahmoud Wizard attacked by Tasneem Ninja = " + Mahmoud.getHealth());
        System.out.println("Tasneem Ninja healths = " + Tasneem.getHealth());

        System.out.println("\n");
        Tasneem.runAway();
        System.out.println("Tasneem Ninja after run away = " + Tasneem.getHealth());
        System.out.println("\n");

        System.out.println("Ibtisal Samurai is attacking Mahmoud");
        Ibtisal.deathBlow(Mahmoud);
        System.out.println("Mahmoud Wizard is dead, Health = " + Mahmoud.getHealth());
        System.out.println("Ibtisal Samurai Health = " + Ibtisal.getHealth());

        Ibtisal.meditate();
        System.out.println("Ibtisal Samurai Health after meditation = " + Ibtisal.getHealth());

        System.out.println("Number of Samurai/s = " + Samurai.howMany());

    }
}
