public class Computer extends Equipment
{
    private int bits;
    private java.util.ArrayList<String> programs;

    public Computer(int bits)
    {
        super();
        this.bits = bits;
        programs = new java.util.ArrayList<String>();
    }

    public int getBits()
    {
        return bits;
    }

    public void add(String ...programs)
    {
        for(String program : programs)
        {
            this.programs.add(program.toLowerCase());
        }
    }

    public boolean hasInstalled(String program)
    {
        return programs.contains(program.toLowerCase());
    }
}
