import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Ship
{
    private int length;
    private List<Location> locations;
    private List<Location> hitsTaken;

    public Ship(int length)
    {
        this.length = length;
        locations = new ArrayList<Location>();
        hitsTaken = new ArrayList<Location>();
    }

    public void addLocation(Location... loc)
    {
        locations.addAll(Arrays.asList(loc));
    }

    public List<Location> getLocations()
    {
        return locations;
    }

    /**
     * Add Location loc to hitsTaken.
     *
     * @param loc
     */
    public void takeHit(Location loc)
    {
        hitsTaken.add(loc);
    }

    /**
     * Returns true if the number of hits taken is
     *   equal to the length of this ship.
     *
     * @return
     */
    public boolean isSunk()
    {
        if(hitsTaken.size() == locations.size())
            return true;
        return false;
    }
}

