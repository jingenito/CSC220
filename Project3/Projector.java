public class Projector extends Equipment
{
    private String name;
    private boolean isCeiling;

    public Projector(String name, boolean isCeiling)
    {
        super();
        this.name = name;
        this.isCeiling = isCeiling;
    }

    public Projector(String name)
    {
        super();
        this.name = name;
        this.isCeiling = false;
    }

    public String getName()
    {
        return this.name;
    }

    public boolean getIsCeiling()
    {
        return this.isCeiling;
    }

    @Override
    public String toString()
    {
        return String.format("Printer: %s, %s, %s, %s", this.name, this.isCeiling ? "Ceiling" : "Table", super.getId(), super.getWorking());
    }
}