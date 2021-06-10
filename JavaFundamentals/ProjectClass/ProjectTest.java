public class ProjectTest{
    public static void main(String[] args) {
        Project project1 = new Project();
        Project project2 = new Project("test2");
        Project project3 = new Project("test3" , "try Overlay method");

        project1.setName("test1");
        String p1 = project1.getTheName();

        project1.setDescription("try setName method");
        String p2 =project1.getTheDescription();

        String p3 =project1.elevatorPitch();
        String p4 =project2.getTheName();
        String p5 =project3.getTheDescription();
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);
        System.out.println("p4: " + p4);
        System.out.println("p5: " + p5);
    }
}