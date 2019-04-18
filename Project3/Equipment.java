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

    //id get method
    public String getId()
    {
        return "SN: " + this.id;
    }

    //working get method
    public boolean getWorking()
    {
        return this.working;
    }
    
    //working set method
    public void setWorking(boolean state)
    {
        working = state;
    }
}