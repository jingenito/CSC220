public class Printer extends Equipment
{
    private String name;
    private boolean isColor;

    public Printer(String name, boolean isColor)
    {
        super();
        this.name = name;
        this.isColor = isColor;
    }

    public Printer(String name)
    {
        super();
        this.name = name;
        this.isColor = false;
    }

    public String getName()
    {
        return this.name;
    }

    public boolean getIsColor()
    {
        return this.isColor;
    }

    @Override
    public String toString()
    {
        return String.format("Printer: %s, %s, %s, %s", this.name, this.isColor ? "Color" : "Black & White", super.getId(), super.getWorking());
    }
}