// Project3.java
// Name       : Joe Ingenito
// Date       : 4/9/19
// Description: Create equipment for 2 different Classrooms... Forcina 403, and STEM 112
//javac Project3.java
//java Project3

public class Project3
{
    public static void main(String[] args)
    {
        // Create equipment for Forcina 403
        Printer print1 = new Printer("HP C123");
        Projector proj1 = new Projector("Epson P321", false);
        Computer comp1 = new WindowsComputer(32);
        Computer comp2 = new WindowsComputer(64);
        comp2.setWorking(false);
        
        // Create classroom and add equipment
        Classroom F403 = new Classroom("Forcina", "403");
        F403.add(print1, proj1, comp1, comp2);

        // Create equipment for STEM 112
        Printer print2 = new Printer("Lenovo C123", true);
        Projector proj2 = new Projector("Brightside BB23");
        Computer comp3 = new MacintoshComputer(64);
        Computer comp4 = new MacintoshComputer(64);
        Computer comp5 = new MacintoshComputer(64);
        proj2.setWorking(false);
        comp3.setWorking(false);
        
        // Create classroom and add equipment
        Classroom S112 = new Classroom("STEM", "112");
        S112.add(comp3, comp4, comp5, print2, proj2);
        
        // Print classroom inventory
        System.out.println(F403);
        System.out.println(S112);
    }
}