public class Equipment
{
    private static int count = 0;
    
    private boolean working;
    private int id;
    
    public Equipment()
    {
        Equipment.count++;
        this.working = true;
        this.id = count;
    }

    public int getId()
    {
        return this.id;
    }

    public boolean getWorking()
    {
        return this.working;
    }
    
    public void setWorking(boolean state)
    {
        working = state;
    }
}