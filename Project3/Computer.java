public class Computer extends Equipment
{
    private int bits;
    private java.util.ArrayList<String> programs;

    public Computer(int bits)
    {
        super();
        this.bits = bits;
        this.programs = new java.util.ArrayList<String>();
    }

    //bits get method
    public int getBits()
    {
        return bits;
    }

    //add method which accepts a string array of programs
    public void add(String ...programs)
    {
        for(String program : programs)
        {
            //stored as all lowercase to make comparison easier
            this.programs.add(program.toLowerCase());
        }
    }

    //contains method for installed programs
    public boolean hasInstalled(String program)
    {
        return this.programs.contains(program.toLowerCase());
    }
}
