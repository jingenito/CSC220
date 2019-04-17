public class MacintoshComputer extends Computer
{
    public MacintoshComputer(int bits)
    {
        super(bits);
        this.add("Skype", "FaceTime");
    }
    
    @Override
    public String toString()
    {
        return this.getBits() + "-bit Macintosh Computer";
    }
}