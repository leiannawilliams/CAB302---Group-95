import java.util.ArrayList;

public interface Maze {
    int col = 0;
    int rows = 0;
    ArrayList<Integer> walls = null;

    int generateCell(int size);
}
