import java.util.Random;

public class ComputerPlayer extends Player
{
    public ComputerPlayer(String name)
    {
        super(name);
    }

    /**
     * Randomly chooses a Location that has not been
     *   attacked (Location loc is ignored).  Marks
     *   the attacked Location on the guess board
     *   with a positive number if the enemy Player
     *   controls a ship at the Location attacked;
     *   otherwise, if the enemy Player does not
     *   control a ship at the attacked Location,
     *   guess board is marked with a negative number.
     *
     * If the enemy Player controls a ship at the attacked
     *   Location, the ship must add the Location to its
     *   hits taken.  Then, if the ship has been sunk, it
     *   is removed from the enemy Player's list of ships.
     *
     * Return true if the attack resulted in a ship sinking;
     *   false otherwise.
     *
     * @param enemy The Player to attack.
     * @param loc The Location to attack.
     * @return
     */
    @Override
    public boolean attack(Player enemy, Location loc)
    {
        Location landloc = new Location((int)(Math.random() * 10), (int)(Math.random() * 10));

       while(this.getGuessBoard()[landloc.getRow()][landloc.getCol()] != 0)
            landloc = new Location(((int) (Math.random() * 10)), ((int) (Math.random() * 10)));

        if (enemy.hasShipAtLocation(landloc))
        {
            setGuessBoard(landloc.getRow(),landloc.getCol(),1);
            enemy.getShip(landloc).takeHit(landloc);

            if(enemy.getShip(landloc).isSunk())
            {
                enemy.removeShip(enemy.getShip(landloc));
                return true;
            }
            return false;
        }
        else
            this.getGuessBoard()[landloc.getRow()][landloc.getCol()] = -1;
        return false;
    }

    /**
     * Construct an instance of
     *
     *   AircraftCarrier,
     *   Destroyer,
     *   Submarine,
     *   Cruiser, and
     *   PatrolBoat
     *
     * and add them to this Player's list of ships.
     */
    @Override
    public void populateShips()
    {
        super.addShip(new AircraftCarrier(new Location(0, 1), new Location(0,2), new Location(0,3), new Location(0,4), new Location(0,5)));
        super.addShip(new Destroyer(new Location(3, 1), new Location(3,2),new Location(3,3),new Location(3,4)));
        super.addShip(new Submarine(new Location(4,3), new Location(4,4), new Location(4,5)));
        super.addShip(new Cruiser(new Location(5,2), new Location(5,3), new Location(5,4)));
        super.addShip(new PatrolBoat(new Location(9,0), new Location(9,1)));

    }
}
