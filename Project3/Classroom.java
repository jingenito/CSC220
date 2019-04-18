public class Classroom
{
    private String building;
    private String room;
    private java.util.ArrayList<Equipment> equipment;

    public Classroom(String building, String room)
    {
        this.building = building;
        this.room = room;
        this.equipment = new java.util.ArrayList<Equipment>();
    }

    public String getBuilding()
    {
        return this.building;
    }

    public String getRoom()
    {
        return this.room;
    }

    public void add(Equipment ...equips)
    {
        for(Equipment e : equips)
        {
            this.equipment.add(e);
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.building);
        sb.append(" ");
        sb.append(this.room);
        sb.append(" equipment: ");
        sb.append(System.lineSeparator());
        for(Equipment e : equipment)
        {
            sb.append(e);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}