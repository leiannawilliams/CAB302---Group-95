public interface MazeFactory {
    int generateCell(int size);

    /**
     * The MazeFactory Interface will be used to actually generate the maze.
     * Consists of a single generateMaze() method.
     */
    public default void generateMaze(){
        return;
    }
}
