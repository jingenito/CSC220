// Project3.java
// Name       : Joe Ingenito
// Date       : 4/9/19
// Description: Create equipment for Forcina 403

public class Project3 {
    public static void main(String[] args) 
    {

        // Create equipment for Forcina 403
        Printer   print1 = new Printer("HP C123");
        Projector proj1  = new Projector("Epson P321", false);
        Computer  comp1  = new WindowsComputer(32);
        Computer  comp2  = new WindowsComputer(64);
        comp2.setWorking(false);

        // Create classroom and add equipment
        Classroom F403   = new Classroom("Forcina", "403");
        F403.add( print1 );
        F403.add( proj1  );
        F403.add( comp1  );
        F403.add( comp2  );

        // Create equipment for STEM 112
        Printer   print2 = new Printer("Lenovo C123", true);
        Projector proj2  = new Projector("Brightside BB23");
        Computer  comp3  = new MacintoshComputer(64);
        Computer  comp4  = new MacintoshComputer(64);
        Computer  comp5  = new MacintoshComputer(64);
        proj2.setWorking( false );
        comp3.setWorking( false );

        // Create classroom and add equipment
        Classroom S112   = new Classroom("STEM", "112");
        S112.add( comp3  );
        S112.add( comp4  );
        S112.add( comp5  );
        S112.add( print2 );
        S112.add( proj2  );

        // Print classroom inventory
        System.out.println(F403);
        System.out.println(S112);
    }

    public static class Equipment
    {
        boolean working;
        int id;
        private static int count;

        public Equipment()
        {
            working = true;
            Equipment.count++;
            id = count;
        }

        public void setWorking(boolean state)
        {
            working = state;
        }
    }

    public static class Computer extends Equipment
    {
        private int _bits;
        private ArrayList<String> programs;

        public Computer(int bits)
        {
            this._bits = bits;
            programs = new ArrayList<String>();
        }

        public int getBits()
        {
            return _bits;
        }

        public void add(String ...programs)
        {
            for(String program : programs)
            {
                this.programs.add(program);
            }
        }

        public boolean hasInstalled(String program)
        {
            return programs.contains(program.toLowerCase());
        }
    }

    public static class WindowsComputer extends Computer
    {
        public WindowsComputer(int bits)
        {
            super(bits);
            this.add("skype");
        }

        @Override
        public String toString()
        {
            return this.getBits() + "-bit Windows Computer";
        }
    }

    public static class MacintoshComputer extends Computer
    {
        public MacintoshComputer(int bits)
        {
            super(bits);
            this.add("skype", "faceTime");
        }

        @Override
        public String toString()
        {
            return this.getBits() + "-bit Macintosh Computer";
        }
    }
}

/* Expected output

Forcina 403 equipment:
1. HP C123 black and white printer (SN:1)
2. Epson P321 table projector (SN:2)
3. 32-bit Windows Computer (SN:3)
4. 64-bit Windows Computer (SN:4) (broken)

STEM 112 equipment:
1. 64-bit Macontosh Computer (SN:7) (broken)
2. 64-bit Macontosh Computer (SN:8)
3. 64-bit Macontosh Computer (SN:9)
4. Lenovo C123 color printer (SN:5)
5. Brightside BB23 ceiling projector (SN:6) (broken)

*/