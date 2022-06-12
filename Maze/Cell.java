package Maze;

/* Maze generation algorithm
 * Andras Szabo. (2019). Retrieved from: https://github.com/bandi22/java-swing-maze
 */

public class Cell {
    private boolean visited; //cell is visited by maze generator

    //int index;

    int x; //X coordinate
    int y; //Y coordinate

    // Neighboring cells:
    Cell toNorth;
    Cell toSouth;
    Cell toWest;
    Cell toEast;

    // Start with cell walls up
    boolean wallN = true;
    boolean wallS = true;
    boolean wallE = true;
    boolean wallW = true;


    // *** Constructor ***//

    /**
     * Class constructor to create cell in maze
     * @param index index of cell on grid used to generate maze
     */
    public Cell (int index)
    {
        visited = false;
        //this.index = index;

    } //constructor


    // *** Getter-setter methods ***//
    /**
     * Setter method for xPos of cell on the maze grid
     * @param x xPosition of cell
     */
    public void setX (int x)
    {
        this.x = x;
    } //setX

    /**
     * Setter method for the yPos of cell on the maze grid
     * @param y yPosition of cell
     */
    public void setY (int y)
    {
        this.y = y;
    } //setY

    /**
     * Getter method for the xPos of cell on the maze grid
     * @return xPosition
     */
    public int getX ()
    {
        return this.x;
    } //getX

    /**
     * Getter method for the yPos of cell on the maze grid
     * @return yPosition
     */
    public int getY ()
    {
        return this.y;
    } //getY

    /**
     * Setter method to set neighbouring cell as visited if true
     * @param visited Neighbouring cell
     */
    public void setVisited(boolean visited)
    {
        this.visited = visited;
    } //setVisited

    /**
     * Getter method if neighbouring cell has been visited is set to true
     * @return visited Neighboring cell
     */
    public boolean getVisited()
    {
        return this.visited;
    } //getVisited


    // *** Other methods *** //
    /**
     * Checks to see if current cell has unvisited neighbours
     * @param cell current maze cell
     * @return .
     */
    public boolean hasUnvisitedNeighbors (Cell cell)
    {
        return (cell.toNorth != null && !cell.toNorth.visited) || (cell.toSouth != null && !cell.toSouth.visited) || (cell.toEast != null && !cell.toEast.visited) || (cell.toWest != null && !cell.toWest.visited);
    }
}