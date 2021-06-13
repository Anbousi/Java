public class Animal{
    static int count = 0;
    String type = "animal";

    public Animal(){
        System.out.println("I am an animal");
        count++;
    }

        public Animal(String type){
        System.out.println("Type: " + type);
        count++;
    }

}