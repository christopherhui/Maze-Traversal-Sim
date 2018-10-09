package model;
import model.MazeMap;

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
    public int get_num_mazes() {
        return mazeMaps.size();
    }

    // EFFECTS: Return the mazes in mazeMap
    public List<MazeMap> get_mazes() {return mazeMaps;}

    // MODIFIES: this
    // EFFECTS: Adds a maze to mazeMaps
    public void add_maze(MazeMap mazeMap) {
        mazeMaps.add(mazeMap);
        numMazes += 1;
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
        numMazes -= 1;
    }

    // REQUIRES: mazeMaps has at least one maze
    // EFFECTS: Prints all mazes that are in mazeMaps
    public void print_all_mazes() {
        for (MazeMap maze : mazeMaps) {
            System.out.println(maze.get_maze());
        }
    }

    public void replace_maze(int i, MazeMap m) {
        mazeMaps.set(i, m);
    }
}
