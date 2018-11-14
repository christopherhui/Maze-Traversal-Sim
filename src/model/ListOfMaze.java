package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ListOfMaze {
    private List<MazeMap> mazeMaps;

    // EFFECTS: List has no mazes
    public ListOfMaze() {
        mazeMaps = new ArrayList<>();
    }

    // EFFECTS: Return the number of mazes in the list
    public int get_num_mazes() {
        return mazeMaps.size();
    }

    // EFFECTS: Return the mazes in mazeMap
    public List<MazeMap> get_mazes() {return mazeMaps;}

    // MODIFIES: this
    // EFFECTS: Adds a maze to mazeMaps
    public void add_maze(MazeMap mazeMap) {
        mazeMaps.add(mazeMap);
    }

    // REQUIRES: index is within range bounds
    public MazeMap get_maze(int i) {
        return mazeMaps.get(i);
    }

    // REQUIRES: x must be an index between 0 and the length of the list - 1
    // MODIFIES: this
    // EFFFECTS: Removes a maze from the list of mazes at index x
    public void remove_maze(int x) {
        mazeMaps.remove(x);
    }

    public void replace_maze(int i, MazeMap m) {
        mazeMaps.set(i, m);
    }

    public boolean contains_maze(MazeMap m) {
        return mazeMaps.contains(m);
    }
}
