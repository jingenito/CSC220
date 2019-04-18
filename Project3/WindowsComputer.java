public class WindowsComputer extends Computer
{
    public WindowsComputer(int bits)
    {
        super(bits);
        this.add("Skype");
    }
    
    @Override
    public String toString()
    {
        return this.getBits() + "-bit Windows Computer, " + super.getId() + " " + (super.getWorking() ? "" : "(broken)");
    }
}