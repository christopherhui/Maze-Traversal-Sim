package ui;
import java.util.List;
import java.util.ArrayList;

public class ListofMazes {
    private int numMazes;
    private List<MazeMap> mazeMaps;

    // EFFECTS: List has no mazes
    public ListofMazes() {
        this.numMazes = 0;
        mazeMaps = new ArrayList<>();
    }

    // EFFECTS: Return the number of mazes in the list
    public int get_mazes() {
        return numMazes;
    }

    // MODIFIES: this
    // EFFECTS: Adds a maze to mazeMaps
    public void add_maze(MazeMap mazeMap) {
        mazeMaps.add(mazeMap);
        numMazes += 1;
    }

    // REQUIRES: x must be an index between 0 and the length of the list - 1
    // MODIFIES: this
    // EFFFECTS: Removes a maze from the list of mazes at index x
    public void remove_maze(int x) {

    }

    // REQUIRES: mazeMaps has at least one maze
    // EFFECTS: Prints all mazes that are in mazeMaps
    public void print_all_mazes() {
        for (MazeMap maze : mazeMaps) {
            System.out.println(maze.get_maze());
        }
    }
}
