package ui;
import java.util.List;
import java.util.ArrayList;

public class ListofMazes {
    private int numMazes;
    private List<MazeMap> mazeMaps;

    public ListofMazes() {
        this.numMazes = 0;
        mazeMaps = new ArrayList<>();
    }

    public int get_mazes() {
        return numMazes;
    }

    public void add_maze(MazeMap mazeMap) {
        mazeMaps.add(mazeMap);
        numMazes += 1;
    }

    public void print_maze(int x) {
        // Stub
    }

    public void print_all_mazes() {
        for (MazeMap maze : mazeMaps) {
            System.out.println(maze.get_maze());
        }
    }
}
