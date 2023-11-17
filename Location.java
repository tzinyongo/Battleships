public class Location
{
    private int row;
    private int col;

    public Location(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Location)
            return col == ((Location) obj).getCol() && row == ((Location) obj).getRow();
        return false;
    }
}

